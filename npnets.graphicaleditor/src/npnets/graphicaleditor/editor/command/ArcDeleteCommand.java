package npnets.graphicaleditor.editor.command;

//import npn.model.highlevelnet.Arc;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Arc;
//import npn.model.highlevelnet.Net;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
//import npn.model.highlevelnet.Node;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;

import org.eclipse.gef.commands.Command;

public class ArcDeleteCommand extends Command {

	private Arc arc;
	private HighLevelPetriNet net;
	private Node source;
	private Node target;
    
	@Override public boolean canExecute() {
        return arc != null;
    }
	@Override
	public void execute() {
		net = arc.getNet();
        source = arc.getSource();
        target = arc.getTarget();
		
		arc.setSource(null);
	    arc.setTarget(null);
	    arc.setNet(null);
	}
	@Override
	public void undo() {
		arc.setSource(source);
		arc.setTarget(target);
		arc.setNet(net);
	}
	
	public void setArc(final Arc arcParam) {
		arc = arcParam;
	}
}
