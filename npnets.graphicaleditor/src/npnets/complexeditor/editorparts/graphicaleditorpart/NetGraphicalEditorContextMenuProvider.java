package npnets.complexeditor.editorparts.graphicaleditorpart;

import npnets.complexeditor.editorparts.graphicaleditorpart.action.NodeCloneAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.action.PlaceAddTokenAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.action.PlaceAddTypeAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.action.TransitionAddSynchronizationAction;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

public class NetGraphicalEditorContextMenuProvider  extends ContextMenuProvider {
 
    private ActionRegistry actionRegistry;
 
    public NetGraphicalEditorContextMenuProvider(EditPartViewer viewer, final ActionRegistry actionRegistry) {
    	super(viewer);
        setActionRegistry(actionRegistry);
    }
 
    @Override
    public void buildContextMenu(IMenuManager menu) {
        GEFActionConstants.addStandardActionGroups(menu);

        IAction action;

        action = getActionRegistry().getAction(ActionFactory.UNDO.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
        action = getActionRegistry().getAction(ActionFactory.REDO.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
        action = getActionRegistry().getAction(ActionFactory.DELETE.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(ActionFactory.SELECT_ALL.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(NodeCloneAction.CLONE);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(PlaceAddTokenAction.ADD_TOKEN);
        menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
        action = getActionRegistry().getAction(PlaceAddTypeAction.ADD_TYPE);
        menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
        action = getActionRegistry().getAction(TransitionAddSynchronizationAction.ADD_SYNC);
        menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
    }
 
    protected ActionRegistry getActionRegistry() {
        return actionRegistry;
    }
 
    protected void setActionRegistry(final ActionRegistry actionRegistry) {
        this.actionRegistry = actionRegistry;
    }
}
