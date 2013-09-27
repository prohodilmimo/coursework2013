package npnets.complexeditor.editorparts.graphicaleditorpart.command;

import java.math.BigInteger;
import java.util.List;

import ru.mathtech.npntool.npnets.highlevelnets.marking.Marking;
import ru.mathtech.npntool.npnets.highlevelnets.marking.MarkingFactory;
import ru.mathtech.npntool.npnets.highlevelnets.marking.PlaceMarking;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Place;
import ru.mathtech.npntool.npnets.highlevelnets.tokenexpressions.TokenExpressionsFactory;
import ru.mathtech.npntool.npnets.highlevelnets.tokenexpressions.TokenWeight;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.*;
import ru.mathtech.npntool.npnets.npndiagrams.NPNSymbolPlaceSN;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;

public class PlaceAddTokenCommand extends Command {	 
	  private Place place;
	  private Marking marking;
	  private Token newToken;
	 
	  @Override public void execute() {
		  List<TokenWeight> twl = findPlace(place).getMarking().getWeight();
		  
		  InputDialog sd;
		  sd = new InputDialog(
				  PlatformUI.getWorkbench().getDisplay().getActiveShell(),
				  "Hello", "Enter the weight of token", "1", null);
		  if (sd.open() == Window.OK) {
			  findTokenWeight(twl, new BigInteger(sd.getValue()));
		  }
		  
		  if (place.getType() instanceof TokenTypeElementNet)
			   newToken = TokenTypesFactory.eINSTANCE.createTokenNet();
		  else
			  newToken = TokenTypesFactory.eINSTANCE.createTokenAtomic();
		  
		  if (twl.isEmpty())
			  findPlace(place).getMarking().getWeight().add(TokenExpressionsFactory.eINSTANCE.createTokenWeight());
		  else findPlace(place).getMarking().getWeight().get(0).setToken(newToken);
		  
		  if (place.getType() instanceof TokenTypeElementNet)
			  ((TokenNet)newToken).setType((TokenTypeElementNet)place.getType());
		  else 
			  ((TokenAtomic)newToken).setType((TokenTypeAtomic)place.getType());
	  }
	  
	  private TokenWeight findTokenWeight(List<TokenWeight> list, BigInteger weight) {
		  for (TokenWeight t : list)
			  if (t.getWeight() == weight) return t;
		  TokenWeight t = TokenExpressionsFactory.eINSTANCE.createTokenWeight();
		  t.setWeight(weight);
		  list.add(t);
		  return t;
	  }
	 
	  private PlaceMarking findPlace(Place place) {
		  for (PlaceMarking pm : this.marking.getMap())
			  if (pm.getPlace() == place)
				  return pm;
		  PlaceMarking pm = MarkingFactory.eINSTANCE.createPlaceMarking();
		  marking.getMap().add(pm);
		  pm.setPlace(place);
		  pm.setMarking(TokenExpressionsFactory.eINSTANCE.createTokenMultiSet());
		  return pm;
	  }
	  
	  @Override public void undo() {
	    //TODO:
	  }
	  
	  public void setToken(Token newToken) {
		  this.newToken = newToken;
	  }
	 
	  public void setMarking(Marking marking) {
	    this.marking = marking;
	  }
	 
	  public void setPlace(NPNSymbolPlaceSN place) {
	    this.place = (Place)place.getModel();
	  }
}
