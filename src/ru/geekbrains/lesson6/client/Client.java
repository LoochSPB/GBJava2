package ru.geekbrains.lesson6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public Client() {

        try {
            socket = new Socket("localhost", 1010);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                scanner = new Scanner(System.in);
                while (true) {
                    try {
                        System.out.println("Please enter message:");
                        out.writeUTF(scanner.next());
                    } catch (Exception e) {
                        System.out.println("Connection closed.");
                        break;
                    }
                }
            })
                    .start();

            while (true) {

                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
