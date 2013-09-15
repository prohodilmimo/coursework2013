package npnets.graphicaleditor.editor.command;

import org.eclipse.gef.commands.Command;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Arc;
//import npn.model.highlevelnet.Arc;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
//import npn.model.highlevelnet.Net;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
//import npn.model.highlevelnet.Node;
 
public class ArcCreateCommand extends Command {
   
  private Node source;
  private Node target;
  private Arc arc;
  private HighLevelPetriNet net;
 
  @Override
  public boolean canExecute() {
    return source != null && target != null && arc != null;
  }
   
  @Override public void execute() {
    arc.setSource(source);
    arc.setTarget(target);
    arc.setNet(net);
  }
 
  @Override public void undo() {
    arc.getSource().getOutgoingArcs().remove(arc);
    arc.setSource(null);
    arc.getTarget().getIncomingArcs().remove(arc);
    arc.setTarget(null);
    arc.setNet(null);
  }
 
  public void setTarget(Node target) {
	  this.target = target.getClass() != this.source.getClass() ? target : null;
  }
   
  public void setSource(Node source) {
    this.source = source;
  }
   
  public void setArc(Arc arc) {
    this.arc = arc;
  }
   
  public void setNet(HighLevelPetriNet net) {
    this.net = net;
  }
}