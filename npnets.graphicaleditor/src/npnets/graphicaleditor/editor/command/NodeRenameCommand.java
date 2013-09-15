package npnets.graphicaleditor.editor.command;

import org.eclipse.gef.commands.Command;

//import npn.model.highlevelnet.Node;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.Node;
 
public class NodeRenameCommand extends Command {
   
  private String oldName, newName;
  private Node model;
 
  @Override public void execute() {
    oldName = model.getName();
    model.setName(newName);
  }
 
  @Override public void undo() {
    model.setName(oldName);
  }
   
  public void setNewName(String newName) {
    this.newName = newName;
  }
   
  public void setModel(Node model) {
    this.model = model;
  }
}