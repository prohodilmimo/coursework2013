package npnets.complexeditor.editorparts.graphicaleditorpart.factory;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcTPSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramsFactory;
 
public class ArcTPFactory extends ArcFactory {
 
  @Override public Object getNewObject() {
    return NPNDiagramsFactory.eINSTANCE.createNPNSymbolArcTPSN();
  }
 
  @Override public Object getObjectType() {
    return NPNSymbolArcTPSN.class;
  }
 
}