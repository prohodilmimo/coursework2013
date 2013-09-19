package npnets.graphicaleditor.editor.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import ru.mathtech.npntool.npnets.npndiagrams.*;
//import ru.mathtech.npntool.npnets.highlevelnets.marking.Marking;
//import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
//import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
//import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Place;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.Token;
import npnets.graphicaleditor.editor.action.NodeCloneAction;
import npnets.graphicaleditor.editor.action.PlaceAddSystemAction;
import npnets.graphicaleditor.editor.action.PlaceAddTokenAction;
import npnets.graphicaleditor.editor.command.NodeCloneCommand;
import npnets.graphicaleditor.editor.command.NodeDeleteCommand;
import npnets.graphicaleditor.editor.command.PlaceAddSystemCommand;
import npnets.graphicaleditor.editor.command.PlaceAddTokenCommand;
import npnets.graphicaleditor.editor.factory.TokenFactory;

public class NodeComponentEditPolicy extends ComponentEditPolicy {
	@Override protected Command createDeleteCommand(GroupRequest deleteRequest) {
		NodeDeleteCommand nodeDeleteCommand = new NodeDeleteCommand();
		nodeDeleteCommand.setNode((NPNSymbolNodeSN) getHost().getModel());
		return nodeDeleteCommand;
	}
	
    private NodeCloneCommand createCloneCommand() {
        NodeCloneCommand command = new NodeCloneCommand();
        command.setNode((NPNSymbolNodeSN) getHost().getModel());
        return command;
    }
    
    private PlaceAddTokenCommand createAddTokenCommand() {
    	PlaceAddTokenCommand command = new PlaceAddTokenCommand();
        command.setPlace((NPNSymbolPlaceSN) getHost().getModel());
        command.setToken((Token)(new TokenFactory()).getNewObject());
        //TODO: correct Marking
        command.setMarkup((Marking) ((HighLevelPetriNet)getHost().getParent().getModel()).getMarkups().get(0));
        return command;
    }
    
    private PlaceAddSystemCommand createAddSystemCommand() {
    	PlaceAddSystemCommand command = new PlaceAddSystemCommand();
        command.setPlace((NPNSymbolPlaceSN) getHost().getModel());
        return command;
    }
    
    @Override
    public Command getCommand(Request request) {
        if(request.getType().equals(NodeCloneAction.REQ_CLONE)) {
            return createCloneCommand();
        } else if(request.getType().equals(PlaceAddTokenAction.REQ_ADD_TOKEN)) {
            return createAddTokenCommand();
        } else if(request.getType().equals(PlaceAddSystemAction.REQ_ADD_SYSTEM)) {
            return createAddSystemCommand();
        }
        return super.getCommand(request);
    }
}