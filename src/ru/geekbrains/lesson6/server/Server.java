package ru.geekbrains.lesson6.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;


    public Server() {


        try {
            serverSocket = new ServerSocket(1010);
            Socket client = serverSocket.accept();
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

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
                    System.out.println("Incoming Message is: " + in.readUTF());
                } catch (EOFException e) {
                    System.out.println("Connection closed");
                    break;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }

    }


}
