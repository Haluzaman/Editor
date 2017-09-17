package Listeners;

import Jpanels.Editor;
import Jpanels.EditorPanel;
import config.CONFIG;
import level.Level;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by bubof on 17.09.2017.
 */
public class EditorListener implements MouseListener {

    private Level level;

    public EditorListener(Level level){
        this.level = level;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseXPos = e.getX();
        int mouseYPos = e.getY();
        int realXPos = mouseXPos/ EditorPanel.SCALE + level.getScreen().getX();
        int realYPos = mouseYPos/ EditorPanel.SCALE + level.getScreen().getY();
        int clickRow = realYPos>>CONFIG.TILE_HEIGHT_BYTE;
        int clickColumn = realXPos>>CONFIG.TILE_WIDTH_BYTE;
        System.out.println("Setting tile at: " + clickRow + " " + clickColumn);
        level.setTile(CONFIG.CURRENT_TILE,clickColumn,clickRow);
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
