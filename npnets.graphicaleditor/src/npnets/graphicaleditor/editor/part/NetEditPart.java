package npnets.graphicaleditor.editor.part;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
//import npn.model.highlevelnet.Net;
//import npn.model.highlevelnet.Node;
import npnets.graphicaleditor.editor.policy.NetXYLayoutPolicy;

public class NetEditPart extends AbstractGraphicalEditPart {
	 private NetAdapter adapter;
	 
	  public NetEditPart() {
	    super();
	    adapter = new NetAdapter();
	  }
	 
	  @Override
	  protected IFigure createFigure() {
	    FreeformLayer layer = new FreeformLayer();
	    layer.setLayoutManager(new FreeformLayout());
	    layer.setBorder(new LineBorder(1));
	    return layer;
	  }
	 
	  @Override
	  protected void createEditPolicies() {
	    installEditPolicy(EditPolicy.LAYOUT_ROLE, new NetXYLayoutPolicy());
	  }
	 
	  @Override 
	  protected List<Node> getModelChildren() {
	    List<Node> retVal = new ArrayList<Node>();
	    HighLevelPetriNet net = (HighLevelPetriNet) getModel();
	    retVal.addAll(net.getNodes());
	    return retVal;
	  }
	 
	  @Override public void activate() {
	    if(!isActive()) {
	      ((HighLevelPetriNet)getModel()).eAdapters().add(adapter);
	    }
	    super.activate();
	  }
	 
	  @Override public void deactivate() {
	    if(isActive()) {
	      ((HighLevelPetriNet)getModel()).eAdapters().remove(adapter);
	    }
	    super.deactivate();
	  }
	 
	public class NetAdapter implements Adapter {
		@Override public void notifyChanged(Notification notification) {
	      refreshChildren();
	    }
	 
	    @Override public Notifier getTarget() {
	      return (HighLevelPetriNet)getModel();
	    }
	 
	    @Override public void setTarget(Notifier newTarget) {
	      // Do nothing.
	    }
	 
	    @Override public boolean isAdapterForType(Object type) {
	      return type.equals(HighLevelPetriNet.class);
	    }
	} 
}
