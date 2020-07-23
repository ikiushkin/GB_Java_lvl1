package ru.geekbrains;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("My Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(700, 200, 500, 500);

        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 200));

        JButton button = new Button();
        add(button);

        setVisible(true);
    }
}

