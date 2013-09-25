package npnets.complexeditor.editorparts.graphicaleditorpart.part;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.viewers.TextCellEditor;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolNodeSN;
import npnets.complexeditor.editorparts.graphicaleditorpart.figure.NodeFigure;
import npnets.complexeditor.editorparts.graphicaleditorpart.policy.NodeComponentEditPolicy;
import npnets.complexeditor.editorparts.graphicaleditorpart.policy.NodeDirectEditPolicy;
import npnets.complexeditor.editorparts.graphicaleditorpart.policy.NodeGraphicalNodeEditPolicy;

public abstract class NodeEditPart extends AbstractGraphicalEditPart implements org.eclipse.gef.NodeEditPart {  
	private NodeAdapter adapter;
	
	protected abstract Dimension getSize();
	
	@Override protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NodeDirectEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new NodeGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
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
	    NPNSymbolNodeSN model = (NPNSymbolNodeSN)getModel();
	    NetEditPart parent = (NetEditPart) getParent();
	    
	    setName(figure, model);
	    
	    parent.setLayoutConstraint(this, figure, model.getConstraints());
	}
	
	public void setName(NodeFigure figure, NPNSymbolNodeSN model) {
		figure.getNameLabel().setText(model.getModel().getName());
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
			((NPNSymbolNodeSN)getModel()).eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override public void deactivate() {
		if(isActive()) {
		    ((NPNSymbolNodeSN)getModel()).eAdapters().remove(adapter);
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
			return (NPNSymbolNodeSN)getModel();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(NPNSymbolNodeSN.class);
		}
	}
}

