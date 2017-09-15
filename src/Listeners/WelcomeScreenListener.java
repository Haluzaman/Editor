package Listeners;

import Jpanels.MainPanel;
import Jpanels.WelcomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bubof on 21.05.2017.
 */
public class WelcomeScreenListener implements ActionListener{

    private WelcomeScreen ws;
    public WelcomeScreenListener (WelcomeScreen ws){
        this.ws = ws;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == ws.getConfirmButton()){

            JRadioButton[] buttons = ws.getRadioButtons();
            for(int i = 0; i < buttons.length;i++){
                if(buttons[i].isSelected()){
                    ws.getMainPanel().switchTo(buttons[i].getName());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Please choose one choice");
        }
    }
}
