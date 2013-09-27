package npnets.complexeditor.editorparts.graphicaleditorpart.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import ru.mathtech.npntool.npnets.npndiagrams.*;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnetMarked;

import npnets.complexeditor.editorparts.graphicaleditorpart.action.NodeCloneAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.action.PlaceAddTokenAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.action.PlaceAddTypeAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.action.TransitionAddSynchronizationAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.command.NodeCloneCommand;
import npnets.complexeditor.editorparts.graphicaleditorpart.command.NodeDeleteCommand;
import npnets.complexeditor.editorparts.graphicaleditorpart.command.PlaceAddTypeCommand;
import npnets.complexeditor.editorparts.graphicaleditorpart.command.PlaceAddTokenCommand;
import npnets.complexeditor.editorparts.graphicaleditorpart.command.TransitionAddSynchronizationCommand;

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
        command.setMarking(((NPnet)((NPNSymbolPlaceSN) getHost().getModel()).getDiagram().getHost()).getHost().getMarking());
        return command;
    }
    
    private PlaceAddTypeCommand createAddSystemCommand() {
    	PlaceAddTypeCommand command = new PlaceAddTypeCommand();
        command.setPlace((NPNSymbolPlaceSN) getHost().getModel());
        return command;
    }
    
    private TransitionAddSynchronizationCommand createAddSymchronizationCommand() {
    	TransitionAddSynchronizationCommand command = new TransitionAddSynchronizationCommand();
        command.setTransition((NPNSymbolTransitionSN) getHost().getModel());
        return command;
    }    
    
    @Override
    public Command getCommand(Request request) {
        if(request.getType().equals(NodeCloneAction.REQ_CLONE)) {
            return createCloneCommand();
        } else if(request.getType().equals(PlaceAddTokenAction.REQ_ADD_TOKEN)) {
            return createAddTokenCommand();
        } else if(request.getType().equals(PlaceAddTypeAction.REQ_ADD_TYPE)) {
            return createAddSystemCommand();
        } else if(request.getType().equals(TransitionAddSynchronizationAction.REQ_ADD_SYNC)) {
        	return createAddSymchronizationCommand();
        }
        return super.getCommand(request);
    }
}