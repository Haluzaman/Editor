package Jpanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by bubof on 21.05.2017.
 */
public class EditorPanel extends JPanel{

    public static final int EDITOR_INDEX = 0;
    public static final int EDITOR_OPTIONS_INDEX = 1;

    private MainPanel mp;
//    private JPanel editor;
//    private JPanel options;
    private ArrayList<JPanel> childPanels;

    public static final int WIDTH = 320;
    public static final int HEIGHT = MainPanel.HEIGHT/3;
    public static final int SCALE = 3;

    public EditorPanel(MainPanel mp){
        this.mp = mp;
        GridBagLayout grid = new GridBagLayout();
        this.setLayout(grid);
    }

    public void init(){
        childPanels = new ArrayList<>();

        JPanel editor = new Editor();
        editor.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        editor.setSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        editor.setBorder(BorderFactory.createLineBorder(Color.RED,1));
        childPanels.add(editor);
        InputMap im = this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0,false),"UP");
        ActionMap am = this.getActionMap();
        am.put("UP", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("up");
//                editor.keyPressed(KeyEvent.VK_UP);
                ((Editor)childPanels.get(EDITOR_INDEX)).keyPressed(KeyEvent.VK_UP);
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,false),"LEFT");
        am.put("LEFT",new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("left");
                ((Editor)childPanels.get(EDITOR_INDEX)).keyPressed(KeyEvent.VK_LEFT);
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,false),"RIGHT");
        am.put("RIGHT",new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("right");
                ((Editor)childPanels.get(EDITOR_INDEX)).keyPressed(KeyEvent.VK_RIGHT);
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0,false),"DOWN");
        am.put("DOWN",new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("down");
                ((Editor)childPanels.get(EDITOR_INDEX)).keyPressed(KeyEvent.VK_DOWN);
            }
        });
        JPanel options = new EditorOptions();
        System.out.println(editor.getX() + " " + editor.getY() + " " + "editor width " + editor.getWidth() + " height " + editor.getHeight());
        options.setPreferredSize(new Dimension((MainPanel.WIDTH) - editor.getWidth(),MainPanel.HEIGHT));
        options.setSize(new Dimension((MainPanel.WIDTH) - editor.getWidth(),MainPanel.HEIGHT));
        options.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        System.out.println(options.getX() + " " + options.getY() + " " + "opt width " + options.getWidth() + " height " + options.getHeight());
        childPanels.add(options);
        this.add(childPanels.get(EDITOR_INDEX));
        this.add(childPanels.get(EDITOR_OPTIONS_INDEX));
    }

    public JPanel getChild(int index){
        return this.childPanels.get(index);
    }

}
