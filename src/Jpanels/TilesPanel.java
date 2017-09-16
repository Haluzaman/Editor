package Jpanels;

import graphics.Sprite;
import level.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by bubof on 15.09.2017.
 */
public class TilesPanel extends JPanel{

    private ArrayList<Tile> availableTiles;
    private GridBagConstraints gbc;

    public TilesPanel(){
        availableTiles = Tile.allTiles;
        if(availableTiles == null)
            System.out.println("available tiles are not initialized");
        GridBagLayout gridBag = new GridBagLayout();
        this.setLayout(gridBag);
        gbc = new GridBagConstraints();
        initGUI();
    }

    private void initGUI(){
        int size = availableTiles.size();
        int ypos = 0;
        int xpos = 0;
        for(int y = 0;y < size;y++){
            if(y > 0 && y%5 == 0) {
                ypos++;
                xpos=0;
            }
                JLabel label = new JLabel();
                setImageLabelIcon(label,availableTiles.get(y));
                gbc.gridx = xpos++;
                gbc.gridy = ypos;
                this.add(label,gbc);
        }
    }

    public void setImageLabelIcon(JLabel label,Tile currentTile){
        BufferedImage image = new BufferedImage(16*3,16*3,BufferedImage.TYPE_INT_ARGB);
        int pix[] = graphics.Graphics.scaleImage(currentTile.getSprite().getPixels(),16,16,16*3,16*3);
//        int pix[] = currentTile.getSprite().getPixels();
        int width = currentTile.getSprite().getWidth();
        int height = currentTile.getSprite().getHeight();
        for(int y = 0;y < height*3;y++){
            for(int x = 0;x < width*3;x++){
                image.setRGB(x,y,pix[x+y*width*3]);
            }
        }
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }
}
