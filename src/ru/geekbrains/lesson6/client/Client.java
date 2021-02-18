package ru.geekbrains.lesson6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {

        try {
            socket = new Socket("localhost", 1010);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void messageSend(String message) {
        new Thread(() -> {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        })
                .start();
    }

    public String messageReceive() {

        while (true) {

            try {
//                System.out.println(in.readUTF());
                return in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
