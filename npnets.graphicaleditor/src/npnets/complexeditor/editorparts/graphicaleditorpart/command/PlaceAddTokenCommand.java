package npnets.complexeditor.editorparts.graphicaleditorpart.command;

import ru.mathtech.npntool.npnets.highlevelnets.marking.Marking;
//import npn.model.highlevelnet.Markup;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Place;
//import npn.model.highlevelnet.Place;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.Token;
//import npn.model.highlevelnet.Token;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.TokenTypeElementNet;
import npn.model.nestednet.SystemToken;

import org.eclipse.gef.commands.Command;

public class PlaceAddTokenCommand extends Command {	 
	  private Place place;
	  private Marking markup;
	  private Token newToken;
	 
	  @Override public void execute() {
		  newToken.setName(place.getName() + "-t1");
		  newToken.setMarkup(markup);
		  newToken.setPosition(place);
		  if (place instanceof SystemPlace) 
			  ((SystemToken)newToken).setType(((SystemPlace)place).getType());
	  }
	 
	  @Override public void undo() {
	    newToken.setMarkup(null);
	  }
	  
	  public void setToken(Token newToken) {
		  this.newToken = newToken;
	  }
	 
	  public void setMarkup(Markup markup) {
	    this.markup = markup;
	  }
	 
	  public void setPlace(Place place) {
	    this.place = place;
	  }
}
