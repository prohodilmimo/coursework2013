package npnets.complexeditor.editorparts.graphicaleditorpart.factory;

import org.eclipse.gef.requests.CreationFactory;
 
//import npn.model.highlevelnet.HighlevelnetFactory;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenTypesFactory;
//import npn.model.highlevelnet.Token;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.Token;
 
public class TokenFactory implements CreationFactory {
 
  @Override public Object getNewObject() {
    return TokenTypesFactory.eINSTANCE.createToken();
  }
 
  @Override public Object getObjectType() {
    return Token.class;
  }
 
}