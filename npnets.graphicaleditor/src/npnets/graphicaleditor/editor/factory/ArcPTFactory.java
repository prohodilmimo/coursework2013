package npnets.graphicaleditor.editor.factory;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcPTSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramsFactory;
 
public class ArcPTFactory extends ArcFactory {
 
  @Override public Object getNewObject() {
    return NPNDiagramsFactory.eINSTANCE.createNPNSymbolArcPTSN();
  }
 
  @Override public Object getObjectType() {
    return NPNSymbolArcPTSN.class;
  }
}