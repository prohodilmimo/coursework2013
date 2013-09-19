package npnets.graphicaleditor.editor.command;

import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcSN;

import org.eclipse.gef.commands.Command;

public class ArcDeleteCommand extends Command {

	private NPNSymbolArcSN arc;
    
	@Override public boolean canExecute() {
        return arc != null;
    }
	
	public void setArc(final NPNSymbolArcSN arcParam) {
		arc = arcParam;
	}
}
