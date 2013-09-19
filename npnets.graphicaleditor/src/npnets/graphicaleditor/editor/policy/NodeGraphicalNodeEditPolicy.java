package npnets.graphicaleditor.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
 
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcSN;
//import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Arc;
//import npn.model.highlevelnet.Arc;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolNodeSN;
//import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
//import npn.model.highlevelnet.Node;
import npnets.graphicaleditor.editor.command.ArcCreateCommand;
 
public class NodeGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
 
  @Override protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
    ArcCreateCommand result = (ArcCreateCommand) request.getStartCommand();
    result.setTarget((Node)getHost().getModel());
    return result;
  }
 
  @Override protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
    ArcCreateCommand result = new ArcCreateCommand();
    result.setSource((Node)getHost().getModel());
    result.setArc((Arc) request.getNewObject());
    result.setNet(((Node)getHost().getModel()).getNet());
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
