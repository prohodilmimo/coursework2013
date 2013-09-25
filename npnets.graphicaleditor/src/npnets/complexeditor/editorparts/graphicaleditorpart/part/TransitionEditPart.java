package npnets.complexeditor.editorparts.graphicaleditorpart.part;

import java.util.List;

import npnets.complexeditor.editorparts.graphicaleditorpart.figure.TransitionFigure;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcPTSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcTPSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolTransitionSN;

public class TransitionEditPart extends NodeEditPart {
	@Override protected List<NPNSymbolArcTPSN> getModelSourceConnections() {
		NPNSymbolTransitionSN model = (NPNSymbolTransitionSN)getModel();
	    return model.getOutArcs();
	}
		 
    @Override protected List<NPNSymbolArcPTSN> getModelTargetConnections() {
    	NPNSymbolTransitionSN model = (NPNSymbolTransitionSN)getModel();
	    return model.getInArcs();
    }
	@Override protected Dimension getSize(){
		return new Dimension(10, 50);
	}
	
	@Override
	protected IFigure createFigure() {
		return new TransitionFigure();
	}
}
