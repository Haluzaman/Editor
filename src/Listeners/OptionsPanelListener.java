package Listeners;

import Jpanels.MainPanel;
import Jpanels.OptionsPanel;
import config.CONFIG;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bubof on 21.05.2017.
 */
public class OptionsPanelListener implements ActionListener{

    private OptionsPanel op;
    public OptionsPanelListener(OptionsPanel op){
        this.op = op;
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == op.getConfirmButton()){

            int numRows;
            int numCols;
            int tileHeight;
            int tileWidth;

            try {
                numRows = Integer.parseInt(op.getTextAreaByID(0).getText());
                CONFIG.NUMBER_OF_ROWS = numRows;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Wrong input format in numRows field!");
                op.getTextAreaByID(0).setText("");

            }

            try {
                numCols = Integer.parseInt(op.getTextAreaByID(1).getText());
                CONFIG.NUMBER_OF_COLUMNS = numCols;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Wrong input format in numCols field!");
                op.getTextAreaByID(1).setText("");

            }

            try {
                tileWidth = Integer.parseInt(op.getTextAreaByID(2).getText());
                CONFIG.TILE_WIDTH = tileWidth;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Wrong input format in Width of Tile field!");
                op.getTextAreaByID(2).setText("");

            }

            try {
                tileHeight = Integer.parseInt(op.getTextAreaByID(3).getText());
                CONFIG.TILE_HEIGHT = tileHeight;
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Wrong input format in Height of Tile field!");
                op.getTextAreaByID(3).setText("");

            }

            boolean hasGrid = op.getHasGridButton().isEnabled();

            CONFIG.SHOW_GRID = hasGrid;
            CONFIG.computeByteSizes();

            op.getMainPanel().setDimension(new java.awt.Dimension(320*3,180*3));
            op.getMainPanel().switchTo(MainPanel.CARDS_ID[2]);
        }
    }
}
