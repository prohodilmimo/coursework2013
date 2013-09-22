package npnets.graphicaleditor.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcSN;
 
public class ArcFactory implements CreationFactory {
 
  @Override public Object getNewObject() {
    return null;
  }
 
  @Override public Object getObjectType() {
    return NPNSymbolArcSN.class;
  }
 
}