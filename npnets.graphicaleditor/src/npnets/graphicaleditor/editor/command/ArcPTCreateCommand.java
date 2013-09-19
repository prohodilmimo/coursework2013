package npnets.graphicaleditor.editor.command;

import org.eclipse.gef.commands.Command;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolTransitionSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcPTSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem;
 
public class ArcPTCreateCommand extends Command {
   
  private NPNSymbolTransitionSN target;
  private NPNSymbolPlaceSN source;
  private NPNSymbolArcPTSN arc;
  private NPNDiagramNetSystem net;
 
  @Override
  public boolean canExecute() {
    return source != null && target != null && arc != null;
  }
   
  @Override public void execute() {
    arc.setSource(source);
    arc.setTarget(target);
    arc.setDiagram(net);
  }
 
  @Override public void undo() {
    arc.getSource().getOutArcs().remove(arc);
    arc.setSource(null);
    arc.getTarget().getInArcs().remove(arc);
    arc.setTarget(null);
    arc.setDiagram(null);
  }
 
  public void setTarget(NPNSymbolTransitionSN target) {
	  //this.target = target.getClass() != this.source.getClass() ? target : null;
	  this.target = target;
  }
   
  public void setSource(NPNSymbolPlaceSN source) {
    this.source = source;
  }
   
  public void setArc(NPNSymbolArcPTSN arc) {
    this.arc = arc;
  }
   
  public void setNet(NPNDiagramNetSystem net) {
    this.net = net;
  }
}