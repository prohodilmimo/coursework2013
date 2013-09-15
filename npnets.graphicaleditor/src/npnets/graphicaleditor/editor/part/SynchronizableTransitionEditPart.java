package npnets.graphicaleditor.editor.part;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.TransitionSynchronized;
//import npn.model.highlevelnet.Node;
//import npn.model.nestednet.SynchronizableTransition;
import npnets.graphicaleditor.editor.figure.NodeFigure;

public class SynchronizableTransitionEditPart extends TransitionEditPart {
	@Override
	public void setName(NodeFigure figure, Node model) {
	    figure.getNameLabel().setText(((TransitionSynchronized)model).getSynchronization().getName());
	}
}
