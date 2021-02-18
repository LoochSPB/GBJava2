package ru.geekbrains.lesson3;

import java.util.*;

public class Main {
//    1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
//    уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
//    2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//    В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер
//    телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
//    (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
//    Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять
//    еще дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
//    Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().

    private static String[] words = {
            "Великобритания", "Германия", "Италия", "Канада", "США", "Франция", "Япония","Великобритания", "Канада",
            "Германия", "Италия", "Канада", "Япония","Германия", "Италия"};

    public static void main(String[] args) {
        Set<String> setWords = new HashSet<>(Arrays.asList(words));
        System.out.println(setWords);

        Map<String,Integer> mapWords = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (mapWords.containsKey(words[i])){
            mapWords.put(words[i], mapWords.get(words[i]) + 1);
            }
            else {
                mapWords.put(words[i], 1);
            }
        }
        System.out.println(mapWords);

        phoneBookTest();

    }

    private static void phoneBookTest() {
        PhoneBook book = new PhoneBook();
        book.add("Sergey", "9215816632");
        book.add("Ivan", "9685216464");
        book.add("Sergey", "9112202222");
        book.add("Petr", "9269501941");

        System.out.println(book.get("Sergey"));
    }





}
