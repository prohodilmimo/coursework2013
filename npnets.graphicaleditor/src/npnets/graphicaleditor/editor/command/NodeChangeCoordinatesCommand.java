package npnets.graphicaleditor.editor.command;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolNodeSN;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

public class NodeChangeCoordinatesCommand extends Command {
 
  private Point oldCoordinates;
  private Point newCoordinates;
  private NPNSymbolNodeSN model;
   
  @Override public void execute() {
    if(oldCoordinates == null) {
      oldCoordinates = model.getConstraints().getLocation();
    }
    model.getConstraints().setLocation(newCoordinates);
  }
 
  @Override public void undo() {
    model.getConstraints().setLocation(oldCoordinates);
  }
 
  public void setModel(NPNSymbolNodeSN model) {
    this.model = model;
  }
   
  public void setNewCoordinates(Point newCoordinates) {
    this.newCoordinates = newCoordinates;
  }
}