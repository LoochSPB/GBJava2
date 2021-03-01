package ru.geekbrains.lesson7.server.auth;

import java.util.HashSet;
import java.util.Set;

public class AuthenticationService {
    private static final Set<AuthEntry> entries = new HashSet<AuthEntry>();

    static {
        entries.add(new AuthEntry("l1", "p1", "Nickname1"));
        entries.add(new AuthEntry("l2", "p2", "Nickname2"));
        entries.add(new AuthEntry("l3", "p3", "Nickname3"));
    }



    public AuthEntry findUserByCredentials(String login, String password) {
        for (AuthEntry entry : entries) {
            if (entry.getLogin().equals(login) && entry.getPassword().equals(password)) {
                return entry;
            }
        }
        return null;
    }
}