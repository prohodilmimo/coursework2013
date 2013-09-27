package npnets.complexeditor.editorparts.graphicaleditorpart.command;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HLPNFactory;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Transition;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPNetsFactory;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.Synchronization;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.TransitionSynchronized;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolTransitionSN;

public class TransitionAddSynchronizationCommand extends Command {
	  private Transition transition;
	  private TransitionSynchronized tr;
	  private NPNSymbolTransitionSN symbol;
	  private List<Synchronization> pool;
	  private ListDialog sd;
	 
	  @Override public void execute() {
		  
		  sd = new ListDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell());
		  sd.setContentProvider(new ArrayContentProvider());
		  sd.setLabelProvider(new LabelProvider());
		  sd.setInput(this.pool);
	      sd.setTitle("Choose the net");
		  if (sd.open() == Window.OK) {
			  Synchronization r = (Synchronization) sd.getResult()[0];
			  tr = reset(transition);
			  tr.setSynchronization(r);
			  r.getInvolved().add(tr);
			  transition = tr;
		  }
	  }
	 
	  @Override public void undo() {
		  transition.setNet(tr.getNet());
		  symbol.setModel(transition);
		  tr.getSynchronization().getInvolved().remove(tr);
		  tr.setSynchronization(null);
		  tr.setNet(null);
	  }
	  
	  protected TransitionSynchronized reset(Transition input) {
		  TransitionSynchronized ts = NPNetsFactory.eINSTANCE.createTransitionSynchronized();
		  ts.setId(input.getId());
		  ts.setName(input.getName());
		  ts.setComment(input.getComment());
		  ts.setNet(input.getNet());
		  symbol.setModel(ts);
		  transition.setNet(null);
		  return ts;
	  }
	  
	  public void setTransition(NPNSymbolTransitionSN transition) {
		  symbol = transition;
		  this.transition = (Transition)transition.getModel();
		  pool = ((NPnet)transition.getDiagram().getHost()).getSynchronizations();
	  }
}
