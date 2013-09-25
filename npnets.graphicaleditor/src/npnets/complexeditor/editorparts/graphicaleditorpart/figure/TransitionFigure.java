package npnets.complexeditor.editorparts.graphicaleditorpart.figure;
 
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
 
public class TransitionFigure extends Figure implements NodeFigure {
  private Label nameLabel;
  private RectangleFigure rectangle;
  ConnectionAnchor connectionAnchor;
  
  public TransitionFigure() {
    setLayoutManager(new XYLayout());
    rectangle = new RectangleFigure();
    add(rectangle);
    nameLabel = new Label();
    add(nameLabel);
  }
  
  @Override protected void paintFigure(Graphics graphics) {
    Rectangle r = getBounds().getCopy();
    setConstraint(rectangle, new Rectangle(0, 0, r.width, r.height));
    setConstraint(nameLabel, new Rectangle(0, 0, r.width, r.height));
    nameLabel.invalidate();   
    rectangle.invalidate();
  }
 
  public Label getNameLabel() {
    return nameLabel;
  }
  public ConnectionAnchor getConnectionAnchor() {
		if (connectionAnchor == null) {
	      connectionAnchor = new ChopboxAnchor(this);
	    }
	    return connectionAnchor;
	  }
}