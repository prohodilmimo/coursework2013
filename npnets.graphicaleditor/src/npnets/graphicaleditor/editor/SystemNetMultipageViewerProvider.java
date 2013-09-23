package npnets.graphicaleditor.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

public class SystemNetMultipageViewerProvider {

	protected TreeViewer treeViewer;
	protected ViewerPane treeViewerPane;
	
	public SystemNetMultipageViewerProvider() {
		this.editors = new ArrayList<Object>();
		//this.editors.add(new TreeViewer(null));
		//this.editors.add(new NetGraphicalViewer());
	}

	public List<Object> getEditors() {
		return editors;
	}

	private List<Object> editors;
	
	public TreeViewer getTreeViewer(ComposedAdapterFactory adapterFactory, AdapterFactoryEditingDomain editingDomain){
		 
		this.treeViewer = (TreeViewer) treeViewerPane.getViewer(); 
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		treeViewer.setInput(editingDomain.getResourceSet());
		treeViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
		return treeViewer;
	}
	
	public ViewerPane getTreeViewerPane (IWorkbenchPage page, IWorkbenchPart part) {
		this.treeViewerPane = new ViewerPane(page, part) {
			@Override
			public Viewer createViewer(Composite composite) {
				Tree tree = new Tree(composite, SWT.MULTI);
				TreeViewer newTreeViewer = new TreeViewer(tree);
				return newTreeViewer;
			}
			@Override
			public void requestActivation() {
				super.requestActivation();
				((NestedPetriNetSystemEditor) part).setCurrentViewerPane(this);
			}
		};
		return this.treeViewerPane;
	}
	
	public ViewerPane getTreeViewerPane () {
		return this.treeViewerPane;
	}
	
	public NetGraphicalViewer getGraphicalViewer(){
		return new NetGraphicalViewer();
	}
}
