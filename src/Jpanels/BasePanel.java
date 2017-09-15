package Jpanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bubof on 21.05.2017.
 */
public abstract class BasePanel extends JPanel{

    protected String name;
    protected JLabel namePanel;
    protected MainPanel mainPanel;

    public BasePanel(String name,MainPanel mainPanel){
        this.name = name;
        this.mainPanel = mainPanel;
        this.setLayout(null);
        namePanel = new JLabel(name);
        namePanel.setBounds(new Rectangle((mainPanel.getWidth()>>1)-75,50,150,25));
        this.add(namePanel);
    }

    protected abstract void init();

    public MainPanel getMainPanel(){
        return mainPanel;
    }

}
