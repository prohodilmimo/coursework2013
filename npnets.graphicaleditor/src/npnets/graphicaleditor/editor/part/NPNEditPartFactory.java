package npnets.graphicaleditor.editor.part;

import java.util.List;

//import npn.model.Project;
//import npn.model.highlevelnet.Arc;
//import npn.model.highlevelnet.Place;
//import npn.model.highlevelnet.Transition;
//import npn.model.highlevelnet.Net;
//import npn.model.nestednet.SynchronizableTransition;
//import npn.model.nestednet.SystemNet;
import npnets.graphicaleditor.model.project.Project;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Arc;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Place;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Transition;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.TransitionSynchronized;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet;
//import npn.model.nestednet.SystemPlace;

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
        
    } else*/ if(model instanceof NPnet) {
        part = new SystemNetEditPart();
    } else if(model instanceof HighLevelPetriNet) {
        part = new NetEditPart();
    } else if(model instanceof TransitionSynchronized) {
        part = new SynchronizableTransitionEditPart();
    } else if(model instanceof Transition) {
        part = new TransitionEditPart();
    /*} else if(model instanceof SystemPlace) {
        part = new SystemPlaceEditPart();*/
    } else if(model instanceof Place) {
        part = new PlaceEditPart();
    } else if(model instanceof Arc) {
        part = new ArcEditPart();
    }
    if(part != null) {
      part.setModel(model);
    }
     
    return part;
  }
}
