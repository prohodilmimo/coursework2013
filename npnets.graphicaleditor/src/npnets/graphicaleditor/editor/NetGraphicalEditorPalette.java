package npnets.graphicaleditor.editor;

import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
 
import npnets.graphicaleditor.editor.factory.ArcFactory;
import npnets.graphicaleditor.editor.factory.PlaceFactory;
import npnets.graphicaleditor.editor.factory.TransitionFactory;
import npnets.graphicaleditor.editor.tool.CreationAndDirectEditTool;
 
public class NetGraphicalEditorPalette extends PaletteRoot {
 
  PaletteGroup group;
 
  public NetGraphicalEditorPalette() {
    addGroup();
    addSelectionTool();
    addPlaceTool();
    addTransitionTool();
    addArcTool();
  }
 
  private void addSelectionTool() {
    SelectionToolEntry entry = new SelectionToolEntry();
    group.add(entry);
    setDefaultEntry(entry);
  }
 
  private void addGroup() {
    group = new PaletteGroup("HLPN Controls");
    add(group);
  }
 
  private void addPlaceTool() {
    CreationToolEntry entry = new CreationToolEntry("Place", "Create a new Place", new PlaceFactory(), null, null);
    entry.setToolClass(CreationAndDirectEditTool.class);   
    group.add(entry);
  }
 
  private void addTransitionTool() {
    CreationToolEntry entry = new CreationToolEntry("Transition", "Create a new Transition", new TransitionFactory(), null, null);
    entry.setToolClass(CreationAndDirectEditTool.class);   
    group.add(entry);
    }
  
  private void addArcTool() {
    ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry("Arc", "Creates a new Arc", new ArcFactory(), null, null);
    group.add(entry);
    }
}