package npnets.graphicaleditor.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramsFactory;
 
public class PlaceFactory implements CreationFactory {
 
  @Override public Object getNewObject() {
    return NPNDiagramsFactory.eINSTANCE.createNPNSymbolPlaceSN();
  }
 
  @Override public Object getObjectType() {
    return NPNSymbolPlaceSN.class;
  }
 
}