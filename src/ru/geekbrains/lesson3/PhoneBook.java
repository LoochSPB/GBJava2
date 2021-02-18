package ru.geekbrains.lesson3;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBook = new HashMap<>();


    public void add(String name, String number) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(number);
        }
        else {
            Set<String> numbers = new HashSet<>();
            numbers.add(number);
            phoneBook.put(name, numbers);
        }
    }

    public Set<String> get (String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        return Collections.emptySet();
    }

}
