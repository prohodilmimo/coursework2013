package npnets.graphicaleditor.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
 
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolNodeSN;

import npnets.graphicaleditor.editor.command.ArcPTCreateCommand;
 
public class NodeGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
 
  @Override protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
    ArcCreateCommand result = (ArcCreateCommand) request.getStartCommand();
    result.setTarget((NPNSymbolNodeSN)getHost().getModel());
    return result;
  }
 
  @Override protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
    ArcCreateCommand result = new ArcCreateCommand();
    result.setSource((NPNSymbolNodeSN)getHost().getModel());
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
