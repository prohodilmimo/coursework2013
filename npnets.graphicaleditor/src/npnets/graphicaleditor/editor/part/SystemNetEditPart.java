package npnets.graphicaleditor.editor.part;

import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet;
//import npn.model.nestednet.SystemNet;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class SystemNetEditPart extends NetEditPart {
	private SystemNetAdapter adapter;
	public SystemNetEditPart() {
	    super();
	    adapter = new SystemNetAdapter();
	}
	
	public class SystemNetAdapter implements Adapter {
		@Override public void notifyChanged(Notification notification) {
	      refreshChildren();
	    }
	 
	    @Override public Notifier getTarget() {
	      return (NPnet)getModel();
	    }
	 
	    @Override public void setTarget(Notifier newTarget) {
	      // Do nothing.
	    }
	 
	    @Override public boolean isAdapterForType(Object type) {
	      return type.equals(NPnet.class);
	    }
	} 
}
