package Jpanels;

import Listeners.EditorOptionsListener;
import graphics.Sprite;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by bubof on 03.09.2017.
 */
public class EditorOptions extends JPanel{
    private static String[] availableTilesets = {"TEST-1","TEST-2","TEST-3"};
    private JLabel imageLabel;
    private ImageIcon icon;

    private JComboBox tileSetList;
    private EditorOptionsListener editorOptionsListener;

    private EditorPanel parentPanel;

    public EditorOptions(EditorPanel parentPanel){
        this.parentPanel = parentPanel;
        editorOptionsListener = new EditorOptionsListener(parentPanel);
        this.addMouseListener(editorOptionsListener);
        initGUI();
    }

    private void initGUI(){
        GridBagLayout grid = new GridBagLayout();
        this.setLayout(grid);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        imageLabel = new JLabel();
        imageLabel.setName("imageLabel");
        this.add(imageLabel,gbc);
        setImageLabelIcon();

        gbc.gridx = 0;
        gbc.gridy = 1;
        tileSetList = new JComboBox(availableTilesets);
        this.add(tileSetList,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new TilesPanel();
        //TODO: for selecting right tile -> do function
        panel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getSource() + "great!");
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
        });
        tabbedPane.addTab("TILES",panel1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);


        JPanel panel2 = new JPanel();
        tabbedPane.addTab("CREATURES",panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        //TODO: for changing tabs -> do function
        tabbedPane.addChangeListener(new ChangeListener() { //add the Listener

            public void stateChanged(ChangeEvent e) {

                System.out.println(""+tabbedPane.getSelectedIndex());

                if(tabbedPane.getSelectedIndex()==0) //Index starts at 0, so Index 2 = Tab3
                {
                    //do your stuff on Tab 3
                    System.out.println("ssadasdasdasd");
                }
            }
        });
        this.add(tabbedPane,gbc);
    }

    /** Adds image into JLabel after click on Image of Tile -> it is supposed to show current chosen tile*/
    public void setImageLabelIcon(){
        BufferedImage image = new BufferedImage(16*5,16*5,BufferedImage.TYPE_INT_ARGB);
        int pix[] = graphics.Graphics.scaleImage(Sprite.COAST_TILE.getPixels(),16,16,16*5,16*5);
        int width = Sprite.COAST_TILE.getWidth();
        int height = Sprite.COAST_TILE.getHeight();
        for(int y = 0;y < height*5;y++){
            for(int x = 0;x < width*5;x++){
                image.setRGB(x,y,pix[x+y*(width*5)]);
            }
        }
        icon = new ImageIcon(image);
        imageLabel.setIcon(icon);
    }

    public void initListener(){
        editorOptionsListener.initListener();
    }
}
