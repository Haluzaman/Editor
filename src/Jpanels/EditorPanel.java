package Jpanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bubof on 21.05.2017.
 */
public class EditorPanel extends JPanel{

    private MainPanel mp;
    private JPanel editor;
    private JPanel options;

    public static final int WIDTH = 320;
    public static final int HEIGHT = MainPanel.HEIGHT/3;
    public static final int SCALE = 3;

    public EditorPanel(MainPanel mp){
        this.mp = mp;
        GridBagLayout grid = new GridBagLayout();
        this.setLayout(grid);
    }

    public void init(){

        editor = new Editor();
        editor.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        editor.setSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        editor.setBorder(BorderFactory.createLineBorder(Color.RED,1));

        InputMap im = this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0,false),"UP");
        ActionMap am = this.getActionMap();
        am.put("UP", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("up");
//                editor.keyPressed(KeyEvent.VK_UP);
                ((Editor)editor).keyPressed(KeyEvent.VK_UP);
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,false),"LEFT");
        am.put("LEFT",new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("left");
                ((Editor)editor).keyPressed(KeyEvent.VK_LEFT);
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,false),"RIGHT");
        am.put("RIGHT",new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("right");
                ((Editor)editor).keyPressed(KeyEvent.VK_RIGHT);
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0,false),"DOWN");
        am.put("DOWN",new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("down");
                ((Editor)editor).keyPressed(KeyEvent.VK_DOWN);
            }
        });
        options = new EditorOptions();
        System.out.println(editor.getX() + " " + editor.getY() + " " + "editor width " + editor.getWidth() + " height " + editor.getHeight());
        options.setPreferredSize(new Dimension((MainPanel.WIDTH) - editor.getWidth(),MainPanel.HEIGHT));
        options.setSize(new Dimension((MainPanel.WIDTH) - editor.getWidth(),MainPanel.HEIGHT));
        options.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        System.out.println(options.getX() + " " + options.getY() + " " + "opt width " + options.getWidth() + " height " + options.getHeight());
        this.add(editor);
        this.add(options);
    }

}
