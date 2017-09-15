package Jpanels;

import Listeners.OptionsPanelListener;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bubof on 21.05.2017.
 */
public class OptionsPanel extends BasePanel {

    private HashMap<Integer,JLabel> labels;
    private HashMap<Integer, JTextArea> areas;
    private JRadioButton hasGridButton;
    private JButton confirm;

    public OptionsPanel(String name,MainPanel mainPanel){
        super(name,mainPanel);
        init();
    }

    protected void init(){

        labels = new HashMap<Integer,JLabel>();
        areas = new HashMap<Integer,JTextArea>();

        labels.put(0,new JLabel("Number of Rows"));
        labels.put(1,new JLabel("Number of Cols"));
        labels.put(2,new JLabel("Width of Tile"));
        labels.put(3,new JLabel("Height of Tile"));
        labels.put(4, new JLabel("Show grid"));

        areas.put(0,new JTextArea(""));
        areas.put(1,new JTextArea(""));
        areas.put(2,new JTextArea(""));
        areas.put(3,new JTextArea(""));

        for(int i = 0; i < (labels.size()-1/*>>1*/);i++){
            labels.get(i).setBounds(20,100+ (i*50),100,25);
            this.add(labels.get(i));
        }

        labels.get(4).setBounds(150,100,100,25);
        this.add(labels.get(4));

        hasGridButton = new JRadioButton("Grid is ON");
        hasGridButton.setSelected(true);
        hasGridButton.setBounds(150,130,100,25);
        this.add(hasGridButton);

        confirm = new JButton("Confirm");
        confirm.setBounds((mainPanel.getWidth()>>1)-85,mainPanel.getHeight()-50,100,25);
        this.add(confirm);

        for(int i = 0; i < (areas.size()/*>>1*/);i++){
            areas.get(i).setBounds(20,130 + (i*50),100,15);
            this.add(areas.get(i));
        }

        OptionsPanelListener opl = new OptionsPanelListener(this);
        confirm.addActionListener(opl);
    }

    public JButton getConfirmButton(){
        return confirm;
    }

    public JTextArea getTextAreaByID(int key){
        return this.areas.get(key);
    }

    public JRadioButton getHasGridButton(){
        return hasGridButton;
    }
}
