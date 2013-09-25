package npnets.complexeditor.editorparts.graphicaleditorpart.figure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
 
public interface NodeFigure extends IFigure {
  public Label getNameLabel();
  public ConnectionAnchor getConnectionAnchor();
}