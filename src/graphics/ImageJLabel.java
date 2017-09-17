package graphics;

import level.Tile;

import javax.swing.*;

/**
 * Created by bubof on 17.09.2017.
 */
public class ImageJLabel extends JLabel {
    private Tile tile;

    public ImageJLabel(Tile tile){
        this.tile = tile;
    }

    public Tile getTile(){
        return this.tile;
    }
}
