package npnets.complexeditor.editorparts.graphicaleditorpart.command;

import ru.mathtech.npntool.npnets.npndiagrams.NPNDiagramNetSystem;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolArcPTSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolTransitionSN;

public class ArcPTDeleteCommand extends ArcDeleteCommand {

	private NPNSymbolArcPTSN arc;
	private NPNDiagramNetSystem net;
	private NPNSymbolPlaceSN source;
	private NPNSymbolTransitionSN target;
    
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
