package npnets.graphicaleditor.editor.command;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

//import npn.model.highlevelnet.Net;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;
//import npn.model.highlevelnet.Place;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Place;

public class PlaceAddSystemCommand extends Command{
	  private Place place;
	  SelectionDialog sd;
	 
	  @Override public void execute() {
		 /* sd = new ListSelectionDialog(
				  getShell(), null,
			      new BaseWorkbenchContentProvider(), new WorkbenchLabelProvider(),
			      "Select the net to nest:");
	      sd.setTitle("Choose the net");
		  sd.setInitialElementSelections(place.getNet().getProject().getNets());
		  sd.open();
		  ((SystemPlace)place).setType((Net)sd.getResult()[0]);*/
	  }
	 
	  @Override public void undo() {
		  
	  }
	   
	  public void setPlace(Place place) {
		  this.place = place;
	  }
}
