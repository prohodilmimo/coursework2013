package npnets.graphicaleditor.editor.command;

import org.eclipse.gef.commands.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Arc;
//import npn.model.highlevelnet.Arc;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
//import npn.model.highlevelnet.Net;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
//import npn.model.highlevelnet.Node;
 
public class NodeDeleteCommand extends Command {
 
  private Node node;
  private HighLevelPetriNet net;
  private List<Arc> arcs;
  private Map<Arc, Node> arcSources;
  private Map<Arc, Node> arcTargets;
 
  private void detachLinks() {
	    arcs = new ArrayList<Arc>();
	    arcSources = new HashMap<Arc, Node>();
	    arcTargets = new HashMap<Arc, Node>();
	    arcs.addAll(node.getIncomingArcs());
	    arcs.addAll(node.getOutgoingArcs());
	    for (Arc arc : arcs) {
	      arcSources.put(arc, arc.getSource());
	      arcTargets.put(arc, arc.getTarget());
	      arc.setSource(null);
	      arc.setTarget(null);
	      arc.setNet(null);
	    }
	  }
	 
	  private void reattachLinks() {
	    for (Arc arc : arcs) {
	      arc.setSource(arcSources.get(arc));
	      arc.setTarget(arcTargets.get(arc));
	      arc.setNet(net);
	    }
	  }
  
  @Override
  public void execute() {
	  detachLinks();
	  node.setNet(null);
  }
 
  @Override
  public void undo() {
	reattachLinks();
    node.setNet(net);
  }
 
  public void setNode(Node node) {
    this.node = node;
    this.net = node.getNet();
  }
}