package npnets.graphicaleditor.editor.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
 
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
 
public class NodeCreateCommand extends Command {
 
  //private static final Dimension defaultDimension = new Dimension(50, 50);
  private Node newNode;
  private Point coordinates;
  private HighLevelPetriNet net;
 
  @Override public void execute() {
    if(coordinates != null) {
      newNode.setCoordinates(coordinates);
    }
    newNode.setNet(net);
  }
 
  @Override public void undo() {
    newNode.setNet(null);
  }
 
  public void setLocation(Point location) {
	coordinates = location;
  }
 
  public void setParent(HighLevelPetriNet net) {
    this.net = net;
  }
 
  public void setNode(Node newNode) {
    this.newNode = newNode;
  }
}