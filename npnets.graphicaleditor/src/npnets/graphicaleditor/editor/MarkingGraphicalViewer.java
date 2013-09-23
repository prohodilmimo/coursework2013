package npnets.graphicaleditor.editor;

import java.util.EventObject;

import ru.mathtech.npntool.npnets.highlevelnets.marking.Marking;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.provider.HLPNItemProviderAdapterFactory;
//import npn.model.highlevelnet.Net;
//import npn.model.provider.NPNItemProviderAdapterFactory;
import npnets.graphicaleditor.editor.action.NodeCloneAction;
import npnets.graphicaleditor.editor.action.PlaceAddTokenAction;
import npnets.graphicaleditor.editor.part.NPNEditPartFactory;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class MarkingGraphicalViewer extends GraphicalEditorWithFlyoutPalette {
	private HighLevelPetriNet net;
	private ContextMenuProvider contextMenu;
	private PropertySheetPage propertyPage;
	private Resource opdResource;

//-----------------Meta-------------------------	

	public MarkingGraphicalViewer() {
	    setEditDomain(new DefaultEditDomain(this));
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
		return new NetGraphicalEditorContextMenuProvider(getGraphicalViewer(), getActionRegistry());
	}
	
//-----------------Misc------------------------
	
	/**
     * This methos implements adapting to {@link IPropertySheetPage}. All other requests are
     * forwarded to the {@link GraphicalEditorWithFlyoutPalette#getAdapter(Class) parent}
     * implementation.
     */
    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
        if(type.equals(IPropertySheetPage.class)) {
            if(propertyPage == null) {
                propertyPage = (UndoablePropertySheetPage) super.getAdapter(type);
                // A new PropertySourceProvider was implemented to fetch the model
                // from the edit part when required. The property source is provided
                // by the generated EMF classes and wrapped by the AdapterFactoryContentProvider
                // to yield standard eclipse interfaces.
                IPropertySourceProvider sourceProvider = new IPropertySourceProvider() {
                    IPropertySourceProvider modelPropertySourceProvider = new AdapterFactoryContentProvider(new HLPNItemProviderAdapterFactory());
 
                    @Override
                    public IPropertySource getPropertySource(Object object) {
                        IPropertySource source = null;
                        if(object instanceof EditPart) {
                            source = modelPropertySourceProvider.getPropertySource(((EditPart) object).getModel());
                        } else {
                            source = modelPropertySourceProvider.getPropertySource(object);
                        }
 
                        if(source != null) {
                            return new UnwrappingPropertySource(source);
                        } else {
                            return null;
                        }
                    }
 
                };
                UndoablePropertySheetEntry root = new UndoablePropertySheetEntry(getCommandStack());
                root.setPropertySourceProvider(sourceProvider);
                propertyPage.setRootEntry(root);
            }
            return propertyPage;
        }
        return super.getAdapter(type);
    }
 
    /**
     * A property source which unwraps values that are wrapped in an EMF
     * {@link PropertyValueWrapper}
     *
     * @author vainolo
     *
     */
    public class UnwrappingPropertySource implements IPropertySource {
        private IPropertySource source;
 
        public UnwrappingPropertySource(final IPropertySource source) {
            this.source = source;
        }
 
        @Override
        public Object getEditableValue() {
            Object value = source.getEditableValue();
            if(value instanceof PropertyValueWrapper) {
                PropertyValueWrapper wrapper = (PropertyValueWrapper) value;
                return wrapper.getEditableValue(null);
            } else {
                return source.getEditableValue();
            }
        }
 
        @Override
        public IPropertyDescriptor[] getPropertyDescriptors() {
            return source.getPropertyDescriptors();
        }
 
        @Override
        public Object getPropertyValue(Object id) {
            Object value = source.getPropertyValue(id);
            if(value instanceof PropertyValueWrapper) {
                PropertyValueWrapper wrapper = (PropertyValueWrapper) value;
                return wrapper.getEditableValue(null);
            } else {
                return source.getPropertyValue(id);
            }
        }
 
        @Override
        public boolean isPropertySet(Object id) {
            return source.isPropertySet(id);
        }
 
        @Override
        public void resetPropertyValue(Object id) {
            source.resetPropertyValue(id);
        }
 
        @Override
        public void setPropertyValue(Object id, Object value) {
            source.setPropertyValue(id, value);
        }
    }
}

