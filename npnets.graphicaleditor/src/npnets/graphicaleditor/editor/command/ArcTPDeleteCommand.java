package npnets.graphicaleditor.editor.command;

import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcTPSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolTransitionSN;

public class ArcTPDeleteCommand extends ArcDeleteCommand {

	private NPNSymbolArcTPSN arc;
	private NPNDiagramNetSystem net;
	private NPNSymbolTransitionSN source;
	private NPNSymbolPlaceSN target;
    
	@Override
	public void execute() {
		net = arc.getDiagram();
        source = arc.getSource();
        target = arc.getTarget();
		
		arc.setSource(null);
	    arc.setTarget(null);
	    arc.setDiagram(null);
	}
	@Override
	public void undo() {
		arc.setSource(source);
		arc.setTarget(target);
		arc.setDiagram(net);
	}
}
