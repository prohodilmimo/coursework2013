package npnets.complexeditor.editorparts.graphicaleditorpart;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.provider.HLPNItemProviderAdapterFactory;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem;
import npnets.complexeditor.editorparts.graphicaleditorpart.action.NodeCloneAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.action.PlaceAddTypeAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.action.PlaceAddTokenAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.part.NPNEditPartFactory;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.emf.common.ui.CommonUIPlugin;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.MultiPageEditorSite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class NetGraphicalEditor extends GraphicalEditorWithFlyoutPalette
	implements IPropertyListener, Listener{
	  
	  private ContextMenuProvider contextMenu;
	  private PropertySheetPage propertyPage;
	  
	  protected IWorkbenchPage page;
	  protected IWorkbenchPart part;
	  protected Collection<Object> buddies = new ArrayList<Object>();
	  protected GraphicalViewer viewer;
	  protected Composite container;
	  boolean isActive;
	  protected CLabel titleLabel;
	  protected ToolBar actionBar;
	  protected ToolBarManager toolBarManager;
	  protected MenuManager menuManager;
	  protected Image pullDownImage;
	  protected ToolBar systemBar;
	  protected FlyoutPaletteComposite control;
	  
	  protected MouseListener mouseListener = 
	    new MouseAdapter() 
	    {
	      @Override
	      public void mouseDown(MouseEvent e){
	        requestActivation();
	      }
	      @Override
	      public void mouseDoubleClick(MouseEvent e) {
	        if (e.getSource() == titleLabel) {
	          doMaximize();
	        }
	      } 
	    };

	  protected IPartListener partListener = 
	    new IPartListener()
	    {
	      public void partActivated(IWorkbenchPart p) {
	        // Do nothing
	      }
	      
	      public void partBroughtToTop(IWorkbenchPart p) {
	        // Do nothing
	      }
	      public void partClosed(IWorkbenchPart p) {
	        // Do nothing
	      }
	      public void partDeactivated(IWorkbenchPart p) {
	        if (p == NetGraphicalEditor.this.part) {
	          showFocus(false);
	        }
	      }
	      
	      public void partOpened(IWorkbenchPart p) {
	        // Do nothing
	      }
	    };
	    
	    class PaneToolBarManager extends ToolBarManager {
	      public PaneToolBarManager(ToolBar paneToolBar) {
	        super(paneToolBar);
	      }

	      /**
	       *  EATM I have no idea how this is supposed to be called.
	       */
	      @Override
	      protected void relayout(ToolBar toolBar, int oldCount, int newCount) {
	        // remove/add the action bar from the view so to avoid
	        // having an empty action bar participating in the view's
	        // layout calculation (and maybe causing an empty bar to appear)
	        /*if (newCount < 1) {
	          if (control.getTopCenter() != null) {
	            control.setTopCenter(null);
	          }
	        } else {
	          toolBar.layout();
	          if (control.getTopCenter() == null) {
	            control.setTopCenter(toolBar);
	          }
	        }*/
	        Composite parent= toolBar.getParent();
	        parent.layout();
	        if (parent.getParent() != null)
	        {
	          parent.getParent().layout();
	        }
	      }    
	    }

//-----------------GraphicalEdtitor properties-------------------------	

	public NetGraphicalEditor(IWorkbenchPage page, IWorkbenchPart part) {
	    setEditDomain(new DefaultEditDomain(this));
	    this.page = page;
	    this.part = part;
	    page.addPartListener(partListener);;
    }
	
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		  super.init(site, input);
		}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
	    //getGraphicalViewer().setContents(net);
	} 
	   
	@Override
	protected void configureGraphicalViewer() {
	    super.configureGraphicalViewer();
	    getGraphicalViewer().setEditPartFactory(new NPNEditPartFactory());
	    contextMenu = new NetGraphicalEditorContextMenuProvider(getGraphicalViewer(), getActionRegistry());
	    getGraphicalViewer().setContextMenu(contextMenu);
	} 
	
	/*@Override
	public void commandStackChanged(EventObject event) {
		firePropertyChange(PROP_DIRTY);
	    super.commandStackChanged(event);
    }*/
	
//------------------Tools-----------------------
	
	@Override
	protected void createActions() {
		SelectionAction action = new NodeCloneAction(this);
	    getActionRegistry().registerAction(action);
	    getSelectionActions().add(action.getId());
	    action = new PlaceAddTokenAction(this);
	    getActionRegistry().registerAction(action);
	    getSelectionActions().add(action.getId());
	}
	
	@Override
	protected PaletteRoot getPaletteRoot() {
		return new NetGraphicalEditorPalette();
	}
	
	public ContextMenuProvider getContextMenu(){
		return new NetGraphicalEditorContextMenuProvider(viewer, getActionRegistry());
	}
	
//-----------------Misc------------------------
	
	@Override
	public void handleEvent(Event event) {
	 if (event.type == SWT.Activate) {
	      requestActivation();
	    }
	}

	public void createControl(Composite parent) {
	    if (getControl() == null) {
	      container = parent;

	      // Create view form.    
	      //control = new ViewForm(parent, SWT.NONE);
	      //control = new FigureCanvas(parent, SWT.NONE);\
	      
	      control = new FlyoutPaletteComposite(parent, 0, this.page, this.getPaletteViewerProvider(), this.getPalettePreferences());
	      
	      control.addDisposeListener
	        (new DisposeListener() {
	           public void widgetDisposed(DisposeEvent event) {
	             dispose();
	           }
	         });
	      control.setSize(200, 500);
	      //control.marginHeight = 0;

	      // Create a title bar.
	      createTitleBar();
	      
	      viewer = createViewer(control);
	      //control.setContent(viewer.getControl());

	      control.setTabList(new Control [] { viewer.getControl() });
	      
	      // When the pane or any child gains focus, notify the workbench.
	      control.addListener(SWT.Activate, this);
	      hookFocus(control);
	      hookFocus(viewer.getControl());
	    }
	  }
	
	public void hookFocus(Control ctrl) {
		  ctrl.addMouseListener(mouseListener);
	}

	public GraphicalViewer createViewer(Composite parent) {
		try {
			init((IEditorSite) part.getSite(), ((IEditorPart) part).getEditorInput());
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.createPartControl(new Composite(parent, SWT.LEFT_TO_RIGHT));
		return getGraphicalViewer();
	}
	
	public GraphicalViewer getViewer() {
		//this.viewer = getGraphicalViewer();
		//return getGraphicalViewer();
		/*this.addPropertyListener(new IPropertyListener() {
			public void propertyChanged(Object source, int propertyId) {
				MultiPageEditorPart.this.handlePropertyChange(propertyId);
			}
		});*
		
		initializeGraphicalViewer();
		configureGraphicalViewer();*/
		return this.viewer;
	}

	public Control getControl() {
	    return control;
	}

	protected void createTitleBar() {
		// Only do this once.
	    if (titleLabel == null) {
	      // Title.  
	      titleLabel = new CLabel(control, SWT.SHADOW_NONE);
	      hookFocus(titleLabel);
	      titleLabel.setAlignment(SWT.LEFT);
	      titleLabel.setBackground(null, null);
	      titleLabel.addMouseListener (new MouseAdapter() {
	           @Override
	          public void mouseDown(MouseEvent e) {
	             if (e.button == 3) {
	               showTitleLabelMenu(e);
	             }
	           }
	         });
	      updateTitles();

	      // Listen to title changes.
	      // getViewPart().addPropertyListener(this);
	      
	      // Action bar.
	      actionBar = new ToolBar(control, SWT.FLAT | SWT.WRAP);
	      hookFocus(actionBar);
	      //control.setTopCenter(actionBar);
	      
	      // System bar.  
	      systemBar = new ToolBar(control, SWT.FLAT | SWT.WRAP);
	      hookFocus(systemBar);
	      if (menuManager != null && !menuManager.isEmpty()) {
	        createPulldownMenu();
	      }
	      //control.setTopRight(systemBar);
	    }
		
	}
	
	  protected void doMaximize()
	  {
	    Control child = control;
	    for (Control parent = control.getParent(); parent instanceof SashForm || parent instanceof CTabFolder; parent = parent.getParent())
	    {
	      if (parent instanceof CTabFolder)
	      {
	        CTabFolder cTabFolder = (CTabFolder)parent;
	        cTabFolder.setMaximized(!cTabFolder.getMaximized());
	      }
	      else if (parent instanceof SashForm)
	      {
	        SashForm sashForm = (SashForm)parent;
	        if (sashForm.getMaximizedControl() == null)
	        {
	          sashForm.setMaximizedControl(child);
	        }
	        else
	        {
	          sashForm.setMaximizedControl(null);
	        }
	      }
	      child = parent;
	    }
	  }
	  
	private void showTitleLabelMenu(MouseEvent e) {
		Menu menu = new Menu(titleLabel);

	    boolean isMaximized = 
	        control.getParent() instanceof SashForm ? 
	          ((SashForm)control.getParent()).getMaximizedControl() != null :
	          control.getParent() instanceof CTabFolder && ((CTabFolder)control.getParent()).getMaximized();

	    MenuItem restoreItem = new MenuItem(menu, SWT.NONE);
	    restoreItem.setText(CommonUIPlugin.INSTANCE.getString("_UI_Restore_menu_item"));
	    restoreItem.addSelectionListener
	      (new SelectionAdapter() 
	       {
	         @Override
	        public void widgetSelected(SelectionEvent selectionEvent) 
	         {
	           doMaximize();
	         }
	       });
	    restoreItem.setEnabled(isMaximized);

	    MenuItem maximizeItem = new MenuItem(menu, SWT.NONE);
	    maximizeItem.setText(CommonUIPlugin.INSTANCE.getString("_UI_Maximize_menu_item"));
	    maximizeItem.addSelectionListener
	      (new SelectionAdapter() 
	       {
	         @Override
	        public void widgetSelected(SelectionEvent selectionEvent) 
	         {
	           doMaximize();
	         }
	       });
	    maximizeItem.setEnabled(!isMaximized);

	    Point point = new Point(e.x, e.y);
	    point = titleLabel.toDisplay(point);
	    menu.setLocation(point.x, point.y);
	    menu.setVisible(true);
		
	}

	protected void requestActivation() {
	    control.setFocus();//.getContents().setFocus();
	    showFocus(true);		
	}

	public void showFocus(boolean inFocus) {
		if (inFocus != isActive) {
	      isActive = inFocus;

	      if (titleLabel != null) {
	        if (inFocus){
	          //titleLabel.setBackground(WorkbenchColors.getActiveGradient(), WorkbenchColors.getActiveGradientPercents());
	          // titleLabel.setForeground(titleLabel.getDisplay().getSystemColor(SWT.COLOR_TITLE_FOREGROUND));
	          titleLabel.update();
	          titleLabel.redraw();
	          //actionBar.setBackground(WorkbenchColors.getActiveGradientEnd());
	          //systemBar.setBackground(WorkbenchColors.getActiveGradientEnd());
	        } else {
	          //titleLabel.setBackground(null, null);
	          // titleLabel.setForeground(null);
	          titleLabel.update();
	          titleLabel.redraw();
	          //actionBar.setBackground(WorkbenchColors.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
	          //systemBar.setBackground(WorkbenchColors.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
	        }
	      }
	    }
	}

	@Override
	public void propertyChanged(Object source, int propID) {
		if (propID == IWorkbenchPart.PROP_TITLE)
	      updateTitles();
	}

	public void updateTitles() {
	    titleLabel.update();
	}
	
	 private void createMenuManager() 
	  {
	    menuManager = new MenuManager("Pane Menu");
	    if (systemBar != null)
	    {
	      createPulldownMenu();
	    }
	  }

	  /**
	   * Create a pull-down menu on the action bar.
	   */
	  private void createPulldownMenu() {
	    if (systemBar != null) {
	      ToolItem ti = new ToolItem(systemBar, SWT.PUSH, 0);
	      try {
	        pullDownImage = 
	          ImageDescriptor.createFromURL
	            (new URL(CommonUIPlugin.INSTANCE.getImage("full/ctool16/ViewPullDown").toString())).createImage();
	        ti.setImage(pullDownImage);
	        ti.addSelectionListener
	          (new SelectionAdapter() {
	             @Override
	            public void widgetSelected(SelectionEvent e) {
	              showViewMenu();
	             }
	           });
	      }
	      catch (MalformedURLException exception) {
	        // Do nothing
	      }
	    }
	  }
	  
	  public MenuManager getMenuManager() {
	    if (menuManager == null) {
	      createMenuManager();
	    }
	    return menuManager;
	  }

	  public ToolBarManager getToolBarManager() {
	    if (toolBarManager == null) {
	      toolBarManager = new PaneToolBarManager(actionBar);
	    }
	    return toolBarManager;
	  }
	  
	  private void showViewMenu() {
	    Menu aMenu = menuManager.createContextMenu(getControl());
	    Point topLeft = new Point(0, 0);
	    topLeft.y += systemBar.getBounds().height;
	    topLeft = systemBar.toDisplay(topLeft);
	    aMenu.setLocation(topLeft.x, topLeft.y);
	    aMenu.setVisible(true);
	  }
}