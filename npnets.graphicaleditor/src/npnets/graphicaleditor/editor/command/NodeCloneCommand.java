package npnets.graphicaleditor.editor.command;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
//import npn.model.highlevelnet.Net;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
//import npn.model.highlevelnet.Node;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Place;
//import npn.model.highlevelnet.Place;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Transition;
//import npn.model.highlevelnet.Transition;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.TransitionSynchronized;
//import npn.model.nestednet.SynchronizableTransition;
import npnets.graphicaleditor.editor.factory.PlaceFactory;
import npnets.graphicaleditor.editor.factory.TransitionFactory;

import org.eclipse.gef.commands.Command;

public class NodeCloneCommand extends Command {	  	 
	private Node newNode;
	private Node node;
	private HighLevelPetriNet net;
	 
	@Override public void execute() { 
		newNode = (Node) (node instanceof Place ? new PlaceFactory() : new TransitionFactory()).getNewObject();
	  	newNode.setCoordinates(node.getCoordinates());
	  	if (node instanceof TransitionSynchronized) ((TransitionSynchronized)newNode).setSynchronization(((TransitionSynchronized)node).getSynchronization());
		newNode.setNet(net);
  	}
 
  	@Override public void undo() {
  		newNode.setNet(null);
  	}

  	public void setNode(Node node) {
  		this.node = node;
  		this.net = node.getNet();
  	}
}