package Jpanels;

import Listeners.WelcomeScreenListener;

import javax.swing.*;
import java.awt.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

/**
 * Created by bubof on 21.05.2017.
 */
public class WelcomeScreen extends BasePanel {

    private JButton confirm;
    private JRadioButton[] buttons;
    public WelcomeScreen(String name,MainPanel mainPanel){
        super(name,mainPanel);
        init();
    }

    protected void init(){
        confirm = new JButton("confirm");
        confirm.setBounds((mainPanel.getWidth()>>1)-85,mainPanel.getHeight()-50,100,25);
        this.add(confirm);

        buttons = new JRadioButton[2];
        buttons[0] = new JRadioButton("Create new Map");
        buttons[1] = new JRadioButton("Open existing Map");

        ButtonGroup bg = new ButtonGroup();
        int bx = (mainPanel.getWidth()>>1) - 85;
        int by = (mainPanel.getHeight()>>1) - 50;
        for(int i = 0; i < buttons.length;i++) {
            buttons[i].setSelected(false);
            buttons[i].setBounds(bx,by + i*(25+15),150,25);
            bg.add(buttons[i]);
            this.add(buttons[i]);
        }

        buttons[0].setName(MainPanel.CARDS_ID[1]);
       // buttons[1].setName(MainPanel.CARDS_ID[]);
        WelcomeScreenListener wsl = new WelcomeScreenListener(this);
        confirm.addActionListener(wsl);
    }

    public JButton getConfirmButton(){
        return this.confirm;
    }

    public JRadioButton[] getRadioButtons(){ return this.buttons; }
}
