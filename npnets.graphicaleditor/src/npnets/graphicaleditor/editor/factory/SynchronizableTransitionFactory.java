package npnets.graphicaleditor.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

//import npn.model.nestednet.NestednetFactory;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsFactory;
//import npn.model.nestednet.SynchronizableTransition;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.TransitionSynchronized;

public class SynchronizableTransitionFactory implements CreationFactory {
	  @Override public Object getNewObject() {
		    return NPNetsFactory.eINSTANCE.createTransitionSynchronized();
		  }
		 
		  @Override public Object getObjectType() {
		    return TransitionSynchronized.class;
		  }
}

