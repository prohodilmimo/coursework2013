package npnets.graphicaleditor.editor.policy;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
 
 
//import npn.model.highlevelnet.Net;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
//import npn.model.highlevelnet.Node;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
//import npn.model.highlevelnet.Place;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Place;
//import npn.model.highlevelnet.Transition;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Transition;
import npnets.graphicaleditor.editor.command.NodeChangeCoordinatesCommand;
import npnets.graphicaleditor.editor.command.NodeCreateCommand;

public class NetXYLayoutPolicy extends XYLayoutEditPolicy {

	@Override protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
	    NodeChangeCoordinatesCommand command = new NodeChangeCoordinatesCommand();
	    command.setModel((Node) child.getModel());
	    command.setNewCoordinates(((Rectangle)constraint).getLocation());
	    return command;
	}
	 
	@Override protected Command getCreateCommand(CreateRequest request) {
	    Command retVal = null;
	    if(request.getNewObjectType().equals(Place.class) || request.getNewObjectType().equals(Transition.class)) {
	      NodeCreateCommand command = new NodeCreateCommand();
	      command.setLocation(request.getLocation());
	      command.setParent((HighLevelPetriNet)(getHost().getModel()));
	      command.setNode((Node)(request.getNewObject()));
	      retVal = command;
	    } 
	    return retVal;
	}
}
