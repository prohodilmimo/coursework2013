package npnets.complexeditor.editorparts.graphicaleditorpart.part;
 
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcPTSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcTPSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN;
 
import npnets.complexeditor.editorparts.graphicaleditorpart.figure.PlaceFigure;
 
public class PlaceEditPart extends NodeEditPart {
	@Override protected List<NPNSymbolArcPTSN> getModelSourceConnections() {
		NPNSymbolPlaceSN model = (NPNSymbolPlaceSN)getModel();
	    return model.getOutArcs();
	}
		 
    @Override protected List<NPNSymbolArcTPSN> getModelTargetConnections() {
    	NPNSymbolPlaceSN model = (NPNSymbolPlaceSN)getModel();
	    return model.getInArcs();
    }
    
	@Override
	protected Dimension getSize(){
		return new Dimension(50, 50);
	}
	
	@Override
	protected IFigure createFigure() {
	    return new PlaceFigure();
	}
}