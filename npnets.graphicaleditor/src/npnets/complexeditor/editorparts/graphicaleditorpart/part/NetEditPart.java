package npnets.complexeditor.editorparts.graphicaleditorpart.part;

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

import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolNodeSN;

import npnets.complexeditor.editorparts.graphicaleditorpart.policy.NetXYLayoutPolicy;

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
	  protected List<NPNSymbolNodeSN> getModelChildren() {
	    List<NPNSymbolNodeSN> retVal = new ArrayList<NPNSymbolNodeSN>();
	    NPNDiagramNetSystem net = (NPNDiagramNetSystem) getModel();
	    retVal.addAll(net.getNodes());
	    return retVal;
	  }
	 
	  @Override public void activate() {
	    if(!isActive()) {
	      ((NPNDiagramNetSystem)getModel()).eAdapters().add(adapter);
	    }
	    super.activate();
	  }
	 
	  @Override public void deactivate() {
	    if(isActive()) {
	      ((NPNDiagramNetSystem)getModel()).eAdapters().remove(adapter);
	    }
	    super.deactivate();
	  }
	 
	public class NetAdapter implements Adapter {
		@Override public void notifyChanged(Notification notification) {
	      refreshChildren();
	    }
	 
	    @Override public Notifier getTarget() {
	      return (NPNDiagramNetSystem)getModel();
	    }
	 
	    @Override public void setTarget(Notifier newTarget) {
	      // Do nothing.
	    }
	 
	    @Override public boolean isAdapterForType(Object type) {
	      return type.equals(NPNDiagramNetSystem.class);
	    }
	} 
}
