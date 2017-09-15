package Jpanels;

import graphics.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.WritableRaster;
import java.io.IOException;

/**
 * Created by bubof on 03.09.2017.
 */
public class EditorOptions extends JPanel{

    public EditorOptions(){
        initGUI();
    }

    private void initGUI(){
        GridBagLayout grid = new GridBagLayout();
        this.setLayout(grid);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel imageLabel = new JLabel();
        imageLabel.setName("imageLabel");
        //TODO: make method for this shit, CJ!!!!!
        BufferedImage image = new BufferedImage(16*5,16*5,BufferedImage.TYPE_INT_ARGB);
        int pix[] = graphics.Graphics.scaleImage(Sprite.COAST_TILE.getPixels(),16,16,16*5,16*5);
        int width = Sprite.COAST_TILE.getWidth();
        int height = Sprite.COAST_TILE.getHeight();
        for(int y = 0;y < height*5;y++){
            for(int x = 0;x < width*5;x++){
                image.setRGB(x,y,pix[x+y*(width*5)]);
            }
        }
        ImageIcon icon = new ImageIcon(image);
        imageLabel.setIcon(icon);
        this.add(imageLabel,gbc);
    }
}
