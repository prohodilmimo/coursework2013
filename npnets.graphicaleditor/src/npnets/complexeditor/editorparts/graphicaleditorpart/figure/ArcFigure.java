package npnets.complexeditor.editorparts.graphicaleditorpart.figure;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MidpointLocator;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;

public class ArcFigure extends PolylineConnection {
	protected Label label;
	
	public ArcFigure() {
		setTargetDecoration(new PolygonDecoration());
		MidpointLocator labelLocator = new MidpointLocator(this, 0);
		label = new Label();
		label.setOpaque(true);
		add(label, labelLocator);
	}
	
	public void setLabelText(String labelText) {
		label.setText(labelText);
	}
	
	public Label getNameLabel() {
		return label;
	}
}
