package com.home;

import javax.swing.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.ArrayList;

public class GUI {
    private JPanel mainPanel;
    private JButton receiveData;
    private JTextField cityEnter;
    private JLabel temp;
    private JLabel weather;
    private JLabel wind;
    private JLabel cloud;
    private JLabel[] lbls = {temp, weather, wind, cloud};
    private ArrayList<String> keys = new ArrayList<>();

    GUI(){
        JFrame mainFrame = new JFrame("Погодка");
        mainFrame.setContentPane(mainPanel);

        receiveData.addActionListener((ActionEvent ae) -> {
            setData(Weather.request(getCity()));;
        });

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setSize(300,300);
        mainFrame.setVisible(true);
    }
    public void setData(Hashtable<String, String> ht) {
        keys.clear();
        clearLbls();
        if (ht != null) {

            for (Object o : ht.keySet().toArray()) {
                keys.add((String) o);
            }

            for (int i = 0; i < 4; i++) {
                lbls[i].setText(keys.get(i) + " >>> " + ht.get(keys.get(i)));
            }
        } else {
            JOptionPane.showInternalMessageDialog(mainPanel, "Город не найден");
        }
    }
    public String getCity() {
        return cityEnter.getText();
    }
    public void clearLbls() {
        for(JLabel lbl : lbls) {
            lbl.setText("");
        }
    }
}
