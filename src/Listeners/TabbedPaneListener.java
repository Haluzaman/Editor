package Listeners;

import Jpanels.EditorOptions;
import Jpanels.TilesPanel;
import config.CONFIG;
import graphics.ImageJLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by bubof on 17.09.2017.
 */
public class TabbedPaneListener implements MouseListener{

    private JTabbedPane tabbedPane;
    private EditorOptions parentPanel;
    public TabbedPaneListener(JTabbedPane tabbedPane,EditorOptions parentPanel){
        this.tabbedPane = tabbedPane;
        this.parentPanel = parentPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.tabbedPane.getSelectedComponent() instanceof TilesPanel){
            Component c = findElement(e);
            if(c instanceof ImageJLabel)
            CONFIG.CURRENT_TILE = ((ImageJLabel) c).getTile();
            parentPanel.setImageLabelIcon();
            System.out.println("Click on tile: " + findElement(e));
        }
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

    public Component findElement(MouseEvent e){
        int xPos = e.getX();
        int yPos = e.getY();
        Component[] components = ((JPanel)e.getSource()).getComponents();
        for(int i = 0;i < components.length;i++){
            //should be method probably
            if(xPos >= components[i].getX() && xPos <= components[i].getX()+components[i].getWidth() &&  yPos >= components[i].getY() && yPos<= components[i].getY()+components[i].getHeight()){
                return components[i];
            }
        }
        return EditorOptionsListener.nonWorking;
    }
}
