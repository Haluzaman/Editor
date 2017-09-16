package Listeners;

import Jpanels.Editor;
import Jpanels.EditorOptions;
import Jpanels.EditorPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by bubof on 15.09.2017.
 */
public class EditorOptionsListener implements MouseListener{

    private EditorPanel editorPanel;
    private Editor editor;
    private EditorOptions editorOptions;
    // if nothing on JPanel is found, then returning this, i dont have to bother with null pointer
    private Component nonWorking = new JTextPane();

    public EditorOptionsListener(EditorPanel editorPanel){
        this.editorPanel = editorPanel;
    }

    public void initListener(){
        this.editor = (Editor) editorPanel.getChild(EditorPanel.EDITOR_INDEX);
        this.editorOptions =(EditorOptions) editorPanel.getChild(EditorPanel.EDITOR_OPTIONS_INDEX);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("On Options Panel click: " +((EditorOptions)e.getSource()).getComponents());
        Component c = findElement(e);
        if(c instanceof JLabel)
            System.out.println("It is mothafuckin JLabel!");
        if(c instanceof JTabbedPane)
            System.out.println("It is mothafuckin JTabbedPane!");
        System.out.println("Component: " + c);
    }

    public Component findElement(MouseEvent e){
        int xPos = e.getX();
        int yPos = e.getY();
        Component[] components = ((EditorOptions)e.getSource()).getComponents();
        for(int i = 0;i < components.length;i++){
            //should be method probably
            if(xPos >= components[i].getX() && xPos <= components[i].getX()+components[i].getWidth() &&  yPos >= components[i].getY() && yPos<= components[i].getY()+components[i].getHeight()){
                return components[i];
            }
        }
        return nonWorking;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
