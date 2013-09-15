package npnets.graphicaleditor.editor.policy;

import npn.model.highlevelnet.Arc;
import npnets.graphicaleditor.editor.command.ArcDeleteCommand;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

public class ArcConnectionEditPolicy extends ConnectionEditPolicy {
	 @Override protected Command getDeleteCommand(GroupRequest request) {
		   ArcDeleteCommand arcDeleteCommand = new ArcDeleteCommand();
		   arcDeleteCommand.setArc((Arc) getHost().getModel());
		   return arcDeleteCommand;
	 }
}
