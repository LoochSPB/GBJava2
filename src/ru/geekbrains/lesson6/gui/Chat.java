package ru.geekbrains.lesson6.gui;

import ru.geekbrains.lesson6.client.Client;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {

    private static String clientName;

    public static void setClientName(String clientName) {
        Chat.clientName = clientName;
    }

    public Chat() {
        Client client = new Client();

        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width/2-640/2,dim.height/2-480/2,640,480);
        setLayout(new BorderLayout());

        JPanel centerText = new JPanel();
        centerText.setLayout(new BorderLayout());
        JTextArea chat = new JTextArea();
        chat.setEditable(false);
        chat.setBorder(new LineBorder(Color.GRAY));
        add(centerText);
        centerText.add(chat, BorderLayout.CENTER);

        JPanel messageBox = new JPanel();
        messageBox.setLayout(new BorderLayout());

        JTextField messageArea = new JTextField();
        messageArea.setBorder(new LineBorder(Color.gray));
        messageBox.add(messageArea, BorderLayout.CENTER);
        messageArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.messageSend(messageArea.getText());
                messageSend(messageArea,chat);
                chat.append(client.messageReceive() + "\n");

            }
        });
        add(messageBox, BorderLayout.SOUTH);

        JButton send = new JButton("Send");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.messageSend(messageArea.getText());
                messageSend(messageArea,chat);
                chat.append(client.messageReceive() + "\n");
            }
        });
        messageBox.add(send,BorderLayout.EAST);
        setVisible(true);
    }

    private void messageSend(JTextField messageArea, JTextArea chat) {
        String message = clientName + ": " + messageArea.getText() + "\n";
        chat.append(message);
        messageArea.setText(null);
    }

    public static void main(String[] args) {
    new NameWindow();
    }
}
