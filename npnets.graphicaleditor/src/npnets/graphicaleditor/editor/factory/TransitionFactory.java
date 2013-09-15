package npnets.graphicaleditor.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Transition;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HLPNFactory;
//import npn.model.highlevelnet.HighlevelnetFactory;
//import npn.model.highlevelnet.Transition;
 
public class TransitionFactory implements CreationFactory {
 
  @Override public Object getNewObject() {
    return HLPNFactory.eINSTANCE.createTransition();
  }
 
  @Override public Object getObjectType() {
    return Transition.class;
  }
}
