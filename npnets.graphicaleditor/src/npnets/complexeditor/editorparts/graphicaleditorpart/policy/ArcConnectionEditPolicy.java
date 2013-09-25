package npnets.complexeditor.editorparts.graphicaleditorpart.policy;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcSN;
import npnets.complexeditor.editorparts.graphicaleditorpart.command.ArcDeleteCommand;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

public class ArcConnectionEditPolicy extends ConnectionEditPolicy {
	 @Override protected Command getDeleteCommand(GroupRequest request) {
		   ArcDeleteCommand arcDeleteCommand = new ArcDeleteCommand();
		   arcDeleteCommand.setArc((NPNSymbolArcSN) getHost().getModel());
		   return arcDeleteCommand;
	 }
}
