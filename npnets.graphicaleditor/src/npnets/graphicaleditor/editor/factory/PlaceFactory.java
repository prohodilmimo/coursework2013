package npnets.graphicaleditor.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Place;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HLPNFactory;
//import npn.model.highlevelnet.HighlevelnetFactory;
//import npn.model.highlevelnet.Place;
 
public class PlaceFactory implements CreationFactory {
 
  @Override public Object getNewObject() {
    return HLPNFactory.eINSTANCE.createPlace();
  }
 
  @Override public Object getObjectType() {
    return Place.class;
  }
 
}