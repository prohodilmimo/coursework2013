package npnets.graphicaleditor.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.jface.viewers.TextCellEditor;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Arc;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
import npnets.graphicaleditor.editor.figure.ArcFigure;
import npnets.graphicaleditor.editor.figure.NodeFigure;
import npnets.graphicaleditor.editor.policy.ArcConnectionEditPolicy;

public class ArcEditPart extends AbstractConnectionEditPart {
 
  public ArcEditPart() {
    super();
  }
  
	@Override public void performRequest(Request req) {
	    if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
	    	performDirectEditing();
	    }
	}
	   
	private void performDirectEditing() {
	    Label label = ((ArcFigure)getFigure()).getNameLabel();
	    NodeDirectEditManager manager = new NodeDirectEditManager(this, TextCellEditor.class, new NodeCellEditorLocator(label), label);
	    manager.show();
	}
	
	public void setName(ArcFigure figure, Arc model) {
		figure.getNameLabel().setText(model.getName());
	}
	
	  @Override protected void createEditPolicies() {
	    installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ArcConnectionEditPolicy());
	  }
	 
	  @Override protected IFigure createFigure() {
	    ArcFigure af = new ArcFigure();
	    if (((Arc)getModel()).getName() != null)
	    	af.setLabelText(((Arc)getModel()).getName());
	    
	    return af;
	  }
 
}