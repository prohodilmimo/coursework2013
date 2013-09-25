package npnets.complexeditor.editorparts.graphicaleditorpart.command;

import ru.mathtech.npntool.npnets.npndiagrams.*;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.TransitionSynchronized;
import npnets.complexeditor.editorparts.graphicaleditorpart.factory.PlaceFactory;
import npnets.complexeditor.editorparts.graphicaleditorpart.factory.TransitionFactory;

import org.eclipse.gef.commands.Command;

public class NodeCloneCommand extends Command {	  	 
	private NPNSymbolNodeSN newNode;
	private NPNSymbolNodeSN node;
	private NPNDiagramNetSystem net;
	 
	@Override public void execute() { 
		newNode = (NPNSymbolNodeSN) (node instanceof NPNSymbolPlaceSN ? new PlaceFactory() : new TransitionFactory()).getNewObject();
	  	newNode.setConstraints(node.getConstraints());
	  	if (node.getModel() instanceof TransitionSynchronized)
	  	  ((TransitionSynchronized)newNode.getModel()).setSynchronization(((TransitionSynchronized)node.getModel()).getSynchronization());
		newNode.setDiagram(net);
  	}
 
  	@Override public void undo() {
  		newNode.setDiagram(null);
  	}

  	public void setNode(NPNSymbolNodeSN node) {
  		this.node = node;
  		this.net = node.getDiagram();
  	}
}