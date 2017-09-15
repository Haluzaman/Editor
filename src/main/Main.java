package main;

import Jpanels.MainPanel;

import javax.swing.*;

/**
 * Created by bubof on 21.05.2017.
 */
public class Main {

    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setContentPane(new MainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
    }
}
