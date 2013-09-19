package npnets.graphicaleditor.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolTransitionSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramsFactory;
 
public class TransitionFactory implements CreationFactory {
 
  @Override public Object getNewObject() {
    return NPNDiagramsFactory.eINSTANCE.createNPNSymbolTransitionSN();
  }
 
  @Override public Object getObjectType() {
    return NPNSymbolTransitionSN.class;
  }
}
