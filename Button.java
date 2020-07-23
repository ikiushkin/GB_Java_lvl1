package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {

    public Button() {
        this.setPreferredSize(new Dimension(150,50));
        this.setText("Exit");
        this.setBackground(Color.YELLOW);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
