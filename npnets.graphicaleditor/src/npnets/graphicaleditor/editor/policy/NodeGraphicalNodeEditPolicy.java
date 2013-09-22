package npnets.graphicaleditor.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
 
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolNodeSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolTransitionSN;

import npnets.graphicaleditor.editor.command.ArcCreateCommand;
import npnets.graphicaleditor.editor.command.ArcPTCreateCommand;
import npnets.graphicaleditor.editor.command.ArcTPCreateCommand;
import npnets.graphicaleditor.editor.factory.ArcPTFactory;
import npnets.graphicaleditor.editor.factory.ArcTPFactory;
 
public class NodeGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
 
  @Override protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
	ArcCreateCommand result;// = (ArcCreateCommand) request.getStartCommand();
	if (getHost().getModel().getClass() != ((ArcCreateCommand)request.getStartCommand()).getSource().getClass()) {
	    if (request.getStartCommand() instanceof ArcPTCreateCommand)  {
	    	result = (ArcPTCreateCommand) request.getStartCommand();
	    	((ArcPTCreateCommand) result).setTarget((NPNSymbolTransitionSN)getHost().getModel());
	    } else {
	    	result = (ArcTPCreateCommand) request.getStartCommand();
	    	((ArcTPCreateCommand) result).setTarget((NPNSymbolPlaceSN)getHost().getModel());
	    }
	} else {
		result = null;
	}
    return result;
  }
 
  @Override protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
    ArcCreateCommand result;// = new ArcCreateCommand();
    if (getHost().getModel() instanceof NPNSymbolPlaceSN) {
    	request.setFactory(new ArcPTFactory());
    	result = new ArcPTCreateCommand();
    	((ArcPTCreateCommand) result).setSource((NPNSymbolPlaceSN)getHost().getModel());
    } else {
    	request.setFactory(new ArcTPFactory());
    	result = new ArcTPCreateCommand();
    	((ArcTPCreateCommand) result).setSource((NPNSymbolTransitionSN)getHost().getModel());
    }
    
    result.setArc((NPNSymbolArcSN) request.getNewObject());
    result.setNet(((NPNSymbolNodeSN)getHost().getModel()).getDiagram());
    request.setStartCommand(result);
    return result;
  }
 
  @Override protected Command getReconnectTargetCommand(ReconnectRequest request) {
    return null;
  }
 
  @Override protected Command getReconnectSourceCommand(ReconnectRequest request) {
    return null;
  }
}
