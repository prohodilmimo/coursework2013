package npnets.graphicaleditor.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcTPSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramsFactory;
 
public class ArcTPFactory implements CreationFactory {
 
  @Override public Object getNewObject() {
    return NPNDiagramsFactory.eINSTANCE.createNPNSymbolArcTPSN();
  }
 
  @Override public Object getObjectType() {
    return NPNSymbolArcTPSN.class;
  }
 
}