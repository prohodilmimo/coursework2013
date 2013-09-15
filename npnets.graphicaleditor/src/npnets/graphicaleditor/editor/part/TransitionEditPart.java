package npnets.graphicaleditor.editor.part;

import npnets.graphicaleditor.editor.figure.TransitionFigure;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;

public class TransitionEditPart extends NodeEditPart {
	
	@Override protected Dimension getSize(){
		return new Dimension(10, 50);
	}
	
	@Override
	protected IFigure createFigure() {
		return new TransitionFigure();
	}
}
