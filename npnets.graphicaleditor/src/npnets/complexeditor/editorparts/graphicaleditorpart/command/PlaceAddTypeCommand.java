package npnets.complexeditor.editorparts.graphicaleditorpart.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;

import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.NPnet;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Place;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenType;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenTypeElementNet;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN;

public class PlaceAddTypeCommand extends Command{
	  private NPNSymbolPlaceSN place;
	  private List<TokenType> pool;
	  private ListDialog sd;
	 
	  @Override public void execute() {
		  sd = new ListDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell());
		  sd.setContentProvider(new ArrayContentProvider());
		  sd.setLabelProvider(new LabelProvider());
		  sd.setInput(pool);
	      sd.setTitle("Choose the net");
		  if (sd.open() == Window.OK)
			  ((Place)place.getModel()).setType((TokenType) sd.getResult()[0]);
	  }
	 
	  @Override public void undo() {
		  ((Place)place.getModel()).setType(null);
	  }
	   
	  public void setPlace(NPNSymbolPlaceSN place) {
		  this.place = place;
		  pool = new ArrayList<TokenType>();
		  pool.add(((NPnet)place.getDiagram().getHost()).getTypeAtomic());
		  for (TokenType tt : ((NPnet)place.getDiagram().getHost()).getTypeElementNet())
			  pool.add(tt);
	  }
}
