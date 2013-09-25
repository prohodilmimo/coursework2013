package npnets.complexeditor.editorparts.graphicaleditorpart;

import npnets.complexeditor.editorparts.graphicaleditorpart.action.NodeCloneAction;
import npnets.complexeditor.editorparts.graphicaleditorpart.action.PlaceAddTokenAction;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

public class NetGraphicalEditorContextMenuProvider  extends ContextMenuProvider {
 
    private ActionRegistry actionRegistry;
    private EditPartViewer viewer;
 
    public NetGraphicalEditorContextMenuProvider(EditPartViewer viewer, final ActionRegistry actionRegistry) {
    	super(viewer);
        this.viewer = viewer;
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
        //((SelectionAction) action).setSelectionProvider(viewer);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(PlaceAddTokenAction.ADD_TOKEN);
        menu.appendToGroup(GEFActionConstants.GROUP_ADD, action);
        /*action = getActionRegistry().getAction(ActionFactory.CUT.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_COPY, action);
        action = getActionRegistry().getAction(ActionFactory.COPY.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_COPY, action);
        action = getActionRegistry().getAction(ActionFactory.PASTE.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_COPY, action);*/
    }
 
    protected ActionRegistry getActionRegistry() {
        return actionRegistry;
    }
 
    protected void setActionRegistry(final ActionRegistry actionRegistry) {
        this.actionRegistry = actionRegistry;
    }
}
