package npnets.complexeditor.action;

import java.util.ArrayList;

import npnets.complexeditor.NestedPetriNetSystemEditor;
import npnets.complexeditor.editorparts.ElementNetEditorPart;
import npnets.complexeditor.editorparts.graphicaleditorpart.NetSimpleGraphicalEditor;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.actions.OpenInNewWindowAction;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.part.MultiPageEditorPart;

import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.ElementNetMarked;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenTypeElementNet;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem;

public class OpenElementNetEditorAction extends Action {

	private TokenTypeElementNet tten;
	private NestedPetriNetSystemEditor parentEditor;
	
	public OpenElementNetEditorAction(TokenTypeElementNet tten, IEditorPart parentEditor) {
		this.tten = tten;
		this.parentEditor = (NestedPetriNetSystemEditor) parentEditor;
	}
	
	public void run(){
		ArrayList<NetSimpleGraphicalEditor> editors = new ArrayList<NetSimpleGraphicalEditor>();
		NPNDiagramNetSystem netDiagram = tten.getDiagram();
		for (ElementNetMarked enm : tten.getElementNetMarkeds()) {
			editors.add(new NetSimpleGraphicalEditor());
		}
		
		int pageIndex = 0;
		
		pageIndex = parentEditor.addPage(null);
		parentEditor.setPageText(pageIndex, "|");
		
		try {
			for(NetSimpleGraphicalEditor editor : editors) {
				pageIndex = parentEditor.addPage(editor, parentEditor.getEditorInput());
				editor.getAdapter(GraphicalViewer.class);
				parentEditor.setPageText(pageIndex, "EN " + tten.getName() + ", marking " + (editors.indexOf(editor) + 1));
				editor.setInput(netDiagram);
			}
			pageIndex = parentEditor.addPage(null);
			parentEditor.setPageText(pageIndex, "+");
		}
		catch(PartInitException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isEnabled() {
		return tten.getNet() != null & tten.getDiagram() != null & !(tten.getElementNetMarkeds().isEmpty());
	}
	
	public String getText() {
		return "Open for editing";
	}
}
