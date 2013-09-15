package npnets.graphicaleditor.editor.action;

import java.util.List;

import npnets.graphicaleditor.editor.part.PlaceEditPart;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public class PlaceAddSystemAction extends SelectionAction {
	public static final String ADD_SYSTEM = "Add System";
    public static final String REQ_ADD_SYSTEM = "Add System";
    
    Request request;
    
    public PlaceAddSystemAction(IWorkbenchPart part) {
        super(part);
        setId(ADD_SYSTEM);
        setText("Add system");
        request = new Request(REQ_ADD_SYSTEM);
    }
    @Override
    public void run() {
        @SuppressWarnings("unchecked") List<PlaceEditPart> editParts = getSelectedObjects();
        CompoundCommand compoundCommand = new CompoundCommand();
        for(PlaceEditPart placeEditPart : editParts) {
            compoundCommand.add(placeEditPart.getCommand(request));
        }
        execute(compoundCommand);
    }
    
    @Override
    protected boolean calculateEnabled() {
        if(getSelectedObjects().isEmpty()) {
            return false;
        }
        for(Object selectedObject : getSelectedObjects()) {
            if(!(selectedObject instanceof PlaceEditPart)) {
                return false;
            }
        }
        return true;
    }
}
