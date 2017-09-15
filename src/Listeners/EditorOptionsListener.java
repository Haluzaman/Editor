package Listeners;

import Jpanels.Editor;
import Jpanels.EditorOptions;
import Jpanels.EditorPanel;

/**
 * Created by bubof on 15.09.2017.
 */
public class EditorOptionsListener {

    private EditorPanel editorPanel;
    private Editor editor;
    private EditorOptions editorOptions;

    public EditorOptionsListener(EditorPanel editorPanel){
        this.editorPanel = editorPanel;
        this.editor =(Editor) editorPanel.getChild(EditorPanel.EDITOR_INDEX);
        this.editorOptions =(EditorOptions) editorPanel.getChild(EditorPanel.EDITOR_OPTIONS_INDEX);
    }


}
