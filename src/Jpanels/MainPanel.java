package Jpanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bubof on 21.05.2017.
 */
public class MainPanel extends JPanel {

    JPanel[] panels;
    public static final String[] CARDS_ID = {"WelcomeScreen","OptionsPanel","EditorPanel"};
    public static final int WIDTH = 1366;
    public static final int HEIGHT = 768;

    private CardLayout cl;
    public MainPanel(){
        //super(new CardLayout());
        this.setLayout(new CardLayout());
        Dimension d = new Dimension(WIDTH,HEIGHT);
        setPreferredSize(d);
        setSize(d);
        panels = new JPanel[3];
        panels[0] = new WelcomeScreen("Welcome to Editor",this);
        panels[1] = new OptionsPanel("Create new Map",this);
        panels[2] = new EditorPanel(this);
        this.add(panels[0],CARDS_ID[0]);
        this.add(panels[1],CARDS_ID[1]);
        this.add(panels[2],CARDS_ID[2]);
        cl = (CardLayout) this.getLayout();
        cl.show(this,CARDS_ID[0]);
    }

    public void switchTo(String ID){
        if(ID.equalsIgnoreCase(CARDS_ID[2])){
            System.out.println("init");
            ((EditorPanel)panels[2]).init();
        }
        panels[2].requestFocusInWindow();
        panels[2].requestFocus();
        cl.show(this,ID);
        panels[2].requestFocusInWindow();
        panels[2].requestFocus();
    }

    public void setDimension(Dimension d){
        setPreferredSize(d);
        setSize(d);
    }
}
