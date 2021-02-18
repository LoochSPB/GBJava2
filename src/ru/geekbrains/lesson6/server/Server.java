package ru.geekbrains.lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;


    public Server () {


        try {
            serverSocket = new ServerSocket(1010);
            Socket client = serverSocket.accept();
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
            String incomingMessage;

            while (true) {
                try{
                    incomingMessage = in.readUTF();
                    out.writeUTF("Server: " + incomingMessage);
                    System.out.println("Incoming Message is: " + incomingMessage);
                } catch (EOFException e) {
                    System.out.println("Connection closed");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
