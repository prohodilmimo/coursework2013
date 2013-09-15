package npnets.graphicaleditor.editor.part;

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
//import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.viewers.TextCellEditor;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Dimension;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Arc;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
import npnets.graphicaleditor.editor.figure.NodeFigure;
import npnets.graphicaleditor.editor.policy.NodeComponentEditPolicy;
import npnets.graphicaleditor.editor.policy.NodeDirectEditPolicy;
import npnets.graphicaleditor.editor.policy.NodeGraphicalNodeEditPolicy;

public abstract class NodeEditPart extends AbstractGraphicalEditPart implements org.eclipse.gef.NodeEditPart {  
	private NodeAdapter adapter;
	
	protected abstract Dimension getSize();
	
	@Override protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NodeDirectEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new NodeGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
		}
	
	@Override protected List<Arc> getModelSourceConnections() {
	    Node model = (Node)getModel();
	    return model.getOutgoingArcs();
	}
		 
    @Override protected List<Arc> getModelTargetConnections() {
    	Node model = (Node)getModel();
	    return model.getIncomingArcs();
    }
		 
	@Override public void performRequest(Request req) {
	    if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
	    	performDirectEditing();
	    }
	}
	   
	private void performDirectEditing() {
	    Label label = ((NodeFigure)getFigure()).getNameLabel();
	    NodeDirectEditManager manager = new NodeDirectEditManager(this, TextCellEditor.class, new NodeCellEditorLocator(label), label);
	    manager.show();
	}   
	
	@Override protected void refreshVisuals() {
	    NodeFigure figure = (NodeFigure)getFigure();
	    Node model = (Node)getModel();
	    NetEditPart parent = (NetEditPart) getParent();
	    
	    setName(figure, model);
	    
	    parent.setLayoutConstraint(this, figure, new Rectangle(model.getCoordinates(), getSize()));
	}
	
	public void setName(NodeFigure figure, Node model) {
		figure.getNameLabel().setText(model.getName());
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
	    return ((NodeFigure)getFigure()).getConnectionAnchor();
	  }
	 
	  public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
	    return ((NodeFigure)getFigure()).getConnectionAnchor();
	  }
	 
	  @Override public ConnectionAnchor getSourceConnectionAnchor(Request request) {
	    return ((NodeFigure)getFigure()).getConnectionAnchor();
	  }
	 
	  @Override public ConnectionAnchor getTargetConnectionAnchor(Request request) {
	    return ((NodeFigure)getFigure()).getConnectionAnchor();
	  }
	public NodeEditPart() {
		super();
		adapter = new NodeAdapter();
	}
	
	@Override public void activate() {
		if(!isActive()) {
			((Node)getModel()).eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override public void deactivate() {
		if(isActive()) {
		    ((Node)getModel()).eAdapters().remove(adapter);
		}
		super.deactivate();
	} 
 
	public class NodeAdapter implements Adapter {
		@Override public void notifyChanged(Notification notification) {
			refreshVisuals();
		    refreshSourceConnections();
		    refreshTargetConnections();
		}

		@Override public Notifier getTarget() {
			return (Node)getModel();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(Node.class);
		}
	}
}

