package npnets.complexeditor.editorparts.graphicaleditorpart.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.jface.viewers.TextCellEditor;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcSN;

import npnets.complexeditor.editorparts.graphicaleditorpart.figure.ArcFigure;
import npnets.complexeditor.editorparts.graphicaleditorpart.policy.ArcConnectionEditPolicy;


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
	
	public void setName(ArcFigure figure, NPNSymbolArcSN model) {
		figure.getNameLabel().setText(model.getModel().getName());
	}
	
	  @Override protected void createEditPolicies() {
	    installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ArcConnectionEditPolicy());
	  }
	 
	  @Override protected IFigure createFigure() {
	    ArcFigure af = new ArcFigure();
	    if (((NPNSymbolArcSN)getModel()).getModel().getName() != null)
	    	af.setLabelText(((NPNSymbolArcSN)getModel()).getModel().getName());
	    
	    return af;
	  }
 
}