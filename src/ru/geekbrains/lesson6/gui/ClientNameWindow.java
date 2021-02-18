package ru.geekbrains.lesson6.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientNameWindow extends JFrame {
    public ClientNameWindow() {
        setTitle("Chat enter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width / 2 - 200 / 2, dim.height / 2 - 200 / 2, 300, 100);

        setLayout(new BorderLayout());

        JLabel askName = new JLabel("Enter your name: ");
        add(askName, BorderLayout.WEST);

        JTextField name = new JTextField();
        add(name, BorderLayout.CENTER);
        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ClientChat();
                ClientChat.setClientName(name.getText());
            }
        });

        JPanel button = new JPanel();
        button.setLayout(new BorderLayout());
        add(button, BorderLayout.SOUTH);

        JButton ok = new JButton("OK");
        button.add(ok, BorderLayout.EAST);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ClientChat();
                ClientChat.setClientName(name.getText());
            }
        });

        setVisible(true);
    }
}
