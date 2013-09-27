package npnets.complexeditor.editorparts.graphicaleditorpart.action;

import java.util.List;

import npnets.complexeditor.editorparts.graphicaleditorpart.part.PlaceEditPart;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public class PlaceAddTypeAction extends SelectionAction {
	public static final String ADD_TYPE= "Add Type";
    public static final String REQ_ADD_TYPE = "Add Type";
    
    Request request;
    
    public PlaceAddTypeAction(IWorkbenchPart part) {
        super(part);
        setId(ADD_TYPE);
        setText("Add type");
        request = new Request(REQ_ADD_TYPE);
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
