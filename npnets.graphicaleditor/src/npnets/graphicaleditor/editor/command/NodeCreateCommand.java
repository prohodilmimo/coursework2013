package npnets.graphicaleditor.editor.command;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HLPNFactory;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolNodeSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolTransitionSN;
//import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
 
public class NodeCreateCommand extends Command {
 
  private static final Dimension defaultDimension = new Dimension(50, 50);
  private NPNSymbolNodeSN newNode;
  private Point coordinates;
  private NPNDiagramNetSystem net;
 
  @Override public void execute() {
    if(coordinates != null) {
      newNode.setConstraints(new Rectangle(coordinates, defaultDimension));
    }
    Node newModel = newNode instanceof NPNSymbolPlaceSN ? HLPNFactory.eINSTANCE.createPlace() : HLPNFactory.eINSTANCE.createTransition();
    newNode.setModel(newModel);
    newNode.setDiagram(net);
    newNode.getDiagram().getModel().getNodes().add(newModel);
  }
 
  @Override public void undo() {
	  newNode.setDiagram(null);
  }
 
  public void setLocation(Point location) {
	coordinates = location;
  }
 
  public void setParent(NPNDiagramNetSystem net) {
	    this.net = net;
	}
  
  public void setNode(NPNSymbolNodeSN newNode) {
	    this.newNode = newNode;
	}
  
  /*public void setParent(HighLevelPetriNet net) {
    this.net = net;
  }
 
  public void setNode(Node newNode) {
    this.newNode = newNode;
  }*/
}