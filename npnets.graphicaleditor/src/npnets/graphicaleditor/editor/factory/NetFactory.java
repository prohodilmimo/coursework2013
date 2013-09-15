package npnets.graphicaleditor.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HLPNFactory;
//import npn.model.highlevelnet.HighlevelnetFactory;
//import npn.model.highlevelnet.Net;
 
public class NetFactory implements CreationFactory {
 
  @Override public Object getNewObject() {
    return HLPNFactory.eINSTANCE.createHighLevelPetriNet();
  }
 
  @Override public Object getObjectType() {
    return HighLevelPetriNet.class;
  }
 
}