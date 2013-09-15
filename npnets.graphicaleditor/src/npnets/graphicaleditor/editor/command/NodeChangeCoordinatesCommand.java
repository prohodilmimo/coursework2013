package npnets.graphicaleditor.editor.command;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

public class NodeChangeCoordinatesCommand extends Command {
 
  private Point oldCoordinates;
  private Point newCoordinates;
  private Node model;
   
  @Override public void execute() {
    if(oldCoordinates == null) {
      oldCoordinates = model.getCoordinates();
    }
    model.setCoordinates(newCoordinates);
  }
 
  @Override public void undo() {
    model.setCoordinates(oldCoordinates);
  }
 
  public void setModel(Node model) {
    this.model = model;
  }
   
  public void setNewCoordinates(Point newCoordinates) {
    this.newCoordinates = newCoordinates;
  }
}