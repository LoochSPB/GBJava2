package ru.geekbrains.lesson8;

import ru.geekbrains.lesson8.client.ClientChatAdapter;

public class ClientTwo {
    public static void main(String[] args) {
        new ClientChatAdapter("localhost", 8989);
    }
}