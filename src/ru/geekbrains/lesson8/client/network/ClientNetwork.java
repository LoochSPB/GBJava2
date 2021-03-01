package ru.geekbrains.lesson8.client.network;

public interface ClientNetwork {
    void send(String message);
    String receive();
}
