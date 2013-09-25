package npnets.complexeditor.editorparts.graphicaleditorpart.action;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import npnets.complexeditor.editorparts.graphicaleditorpart.part.PlaceEditPart;

import java.util.List;
	
public class PlaceAddTokenAction extends SelectionAction {
	public static final String ADD_TOKEN = "Add Token";
    public static final String REQ_ADD_TOKEN = "Add Token";
    
    Request request;
    
    public PlaceAddTokenAction(IWorkbenchPart part) {
        super(part);
        setId(ADD_TOKEN);
        setText("Add token");
        request = new Request(REQ_ADD_TOKEN);
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

