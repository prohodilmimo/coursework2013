package npnets.complexeditor.editorparts;

import npnets.complexeditor.NestedPetriNetSystemEditor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;


public class ModelTreeEditorPart extends EditorPart
	implements IMenuListener, IEditingDomainProvider {

	protected NestedPetriNetSystemEditor parentEditor;
	protected TreeViewer viewer;
	
	  public ModelTreeEditorPart(NestedPetriNetSystemEditor parent) {
	    super();
	    this.parentEditor = parent;
	  }

	  public EditingDomain getEditingDomain() {
	    return parentEditor.getEditingDomain();
	  }

	  protected BasicCommandStack getCommandStack() {
	    return ((BasicCommandStack)getEditingDomain().getCommandStack());
	  }
	    
	  protected AdapterFactory getAdapterFactory() {
	    return parentEditor.getAdapterFactory();
	  }
	    
	  protected void createContextMenuFor(StructuredViewer viewer) {
	    MenuManager contextMenu = new MenuManager("#PopUp");
	    contextMenu.add(new Separator("additions"));
	    contextMenu.setRemoveAllWhenShown(true);
	    contextMenu.addMenuListener(this);
	    Menu menu= contextMenu.createContextMenu(viewer.getControl());
	    viewer.getControl().setMenu(menu);
	    getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

	    int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
	    Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
	    viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
	    viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(getEditingDomain(), viewer));
	  }
	    
	  @Override
	  public void doSave(IProgressMonitor monitor) {
	    // nothing to do here - this is handled by the parent editor
	  }

	  @Override
	  public void doSaveAs() {
	    // nothing to do here - this is handled by the parent editor
	  }

	  @Override
	  public void init(IEditorSite site, IEditorInput input) throws PartInitException {
	    setSite(site);
	    setInput(input);
	  }

	  @Override
	  public boolean isDirty() {
	    return getCommandStack().isSaveNeeded();        
	  }

	  @Override
	  public boolean isSaveAsAllowed() {
	    return true;
	  }

	  public void menuAboutToShow(IMenuManager manager) {
	    // pass the request to show the context menu on to the parent editor
	    ((IMenuListener)parentEditor.getEditorSite().getActionBarContributor()).menuAboutToShow(manager);
	  }
	  
		@Override
		public void createPartControl(Composite parent) {
			viewer = new TreeViewer(parent, SWT.MULTI);
			viewer.setContentProvider(new AdapterFactoryContentProvider(getAdapterFactory()));
			viewer.setLabelProvider(new AdapterFactoryLabelProvider(getAdapterFactory()));
			viewer.setSelection(new StructuredSelection(getEditingDomain().getResourceSet().getResources().get(0)), true);
			getEditorSite().setSelectionProvider(viewer);
			new AdapterFactoryTreeEditor(viewer.getTree(), getAdapterFactory());
			createContextMenuFor(viewer);
		}

		@Override
		public void setFocus() {
			viewer.getTree().setFocus();
		}


		public void setInput(Object input) {
			viewer.setInput(input);
		}

}
