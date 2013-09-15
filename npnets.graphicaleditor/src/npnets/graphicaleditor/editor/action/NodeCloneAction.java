package npnets.graphicaleditor.editor.action;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import npnets.graphicaleditor.editor.part.NodeEditPart;

public class NodeCloneAction extends SelectionAction {
	public static final String CLONE = "Clone";
    public static final String REQ_CLONE = "Clone";
    
    Request request;
    
    public NodeCloneAction(IWorkbenchPart part) {
        super(part);
        setId(CLONE);
        setText("Clone node");
        request = new Request(REQ_CLONE);
    }
    @Override
    public void run() {
        @SuppressWarnings("unchecked") List<NodeEditPart> editParts = getSelectedObjects();
        CompoundCommand compoundCommand = new CompoundCommand();
        for(NodeEditPart nodeEditPart : editParts) {
            compoundCommand.add(nodeEditPart.getCommand(request));
        }
        execute(compoundCommand);
    }
    
    @Override
    protected boolean calculateEnabled() {
        if(getSelectedObjects().isEmpty()) {
            return false;
        }
        for(Object selectedObject : getSelectedObjects()) {
            if(!(selectedObject instanceof NodeEditPart)) {
                return false;
            }
        }
        return true;
    }
}
