package npnets.graphicaleditor.editor.command;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Arc;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.ArcTP;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HLPNFactory;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Place;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Transition;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolTransitionSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcTPSN;
 
public class ArcTPCreateCommand extends ArcCreateCommand {
  @Override public void execute() {
    Arc newModel = HLPNFactory.eINSTANCE.createArcTP();
    arc.setModel(newModel);
	
    ((NPNSymbolArcTPSN)arc).setSource((NPNSymbolTransitionSN)source);
    ((NPNSymbolArcTPSN)arc).setTarget((NPNSymbolPlaceSN)target);
    ((ArcTP)arc.getModel()).setSource((Transition)source.getModel());
    ((ArcTP)arc.getModel()).setTarget((Place)target.getModel());
    
    arc.setDiagram(net);
  }
 
  @Override public void undo() {
    ((Transition)((NPNSymbolArcTPSN)arc).getSource().getModel()).getOutArcs().remove(arc.getModel());
	((ArcTP)arc.getModel()).setSource(null);
	((NPNSymbolArcTPSN)arc).getSource().getOutArcs().remove(arc);
	((NPNSymbolArcTPSN)arc).setSource(null);
    
    ((Place)((NPNSymbolArcTPSN)arc).getTarget().getModel()).getInArcs().remove(arc.getModel());
    ((ArcTP)arc.getModel()).setTarget(null);
    ((NPNSymbolArcTPSN)arc).getTarget().getInArcs().remove(arc);
    ((NPNSymbolArcTPSN)arc).setTarget(null);
    
    ((NPNSymbolArcTPSN)arc).getModel().setNet(null);
    ((NPNSymbolArcTPSN)arc).setDiagram(null);
  }
 
  public void setTarget(NPNSymbolPlaceSN target) {
	  //this.target = target.getClass() != this.source.getClass() ? target : null;
	  this.target = target;
  }
   
  public void setSource(NPNSymbolTransitionSN source) {
    this.source = source;
  }
}