package npnets.graphicaleditor.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolNodeSN;
import npnets.graphicaleditor.editor.command.NodeRenameCommand;
import npnets.graphicaleditor.editor.figure.NodeFigure;

public class NodeDirectEditPolicy extends DirectEditPolicy {
	 
	  @Override protected Command getDirectEditCommand(DirectEditRequest request) {
	    NodeRenameCommand command = new NodeRenameCommand();
	    command.setModel((NPNSymbolNodeSN) getHost().getModel());
	    command.setNewName((String) request.getCellEditor().getValue());
	    return command;
	  }
	 
	  @Override protected void showCurrentEditValue(DirectEditRequest request) {
	    String value = (String) request.getCellEditor().getValue();
	    ((NodeFigure)getHostFigure()).getNameLabel().setText(value);    
	  }
}
