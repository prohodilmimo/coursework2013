package npnets.graphicaleditor.editor.part;

import java.util.List;


import npnets.graphicaleditor.model.project.Project;
import ru.mathtech.npntool.npnets.npndiagrams.*;

import npnets.graphicaleditor.editor.factory.NetFactory;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
 
public class NPNEditPartFactory implements EditPartFactory {
  @Override
  public EditPart createEditPart(EditPart context, Object model) {
    EditPart part = null;
    
    /*if(model instanceof Project) {
    	// TODO: another way
    	List<Net> nets = ((Project) model).getNets();
    	if (nets.isEmpty()) nets.add((Net) new NetFactory.getNewObject() );
    	model = nets.get(0);
        part = new NetEditPart();
        
    } else*/ if(model instanceof NPNDiagramNetSystem) {
        part = new NetEditPart();
    } else if(model instanceof NPNSymbolTransitionSN) {
        part = new TransitionEditPart();
    } else if(model instanceof NPNSymbolPlaceSN) {
        part = new PlaceEditPart();
    } else if(model instanceof NPNSymbolArcSN) {
        part = new ArcEditPart();
    }
    if(part != null) {
      part.setModel(model);
    }
     
    return part;
  }
}
