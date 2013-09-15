package npnets.graphicaleditor.editor.part;
 
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
 
import npnets.graphicaleditor.editor.figure.PlaceFigure;
 
public class PlaceEditPart extends NodeEditPart {
	@Override
	protected Dimension getSize(){
		return new Dimension(50, 50);
	}
	
	@Override
	protected IFigure createFigure() {
	    return new PlaceFigure();
	}
}