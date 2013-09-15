package npnets.graphicaleditor.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Arc;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HLPNFactory;
//import npn.model.highlevelnet.HighlevelnetFactory;
//import npn.model.highlevelnet.Arc;
 
public class ArcFactory implements CreationFactory {
 
  @Override public Object getNewObject() {
    return HLPNFactory.eINSTANCE.createArc();
  }
 
  @Override public Object getObjectType() {
    return Arc.class;
  }
 
}