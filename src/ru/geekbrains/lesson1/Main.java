package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.course.AbstractCourse;
import ru.geekbrains.lesson1.course.ClimbingCourse;
import ru.geekbrains.lesson1.course.Course;
import ru.geekbrains.lesson1.course.SwimmingCourse;

public class Main {
//    1. Разобраться с имеющимся кодом (написанный во время урока)
//    2. Создать класс Team, который будет содержать: название команды, массив из 4-х участников (т.е. в конструкторе можно сразу всех участников указывать), метод для вывода информации о членах команды прошедших дистанцию, метод вывода информации обо всех членах команды.
//    3. Создать класс Course (полоса препятствий), в котором будут находиться: массив препятствий, метод который будет просить команду пройти всю полосу;
//    То есть в итоге должно быть:
//
//    public static void main(String[] args) {
//        Course c = new Course(...); // Создаем полосу препятствий
//        Team team = new Team(...); // Создаем команду
//        c.doIt(team); // Просим команду пройти полосу
//        team.showResults(); // Показываем результаты
//    }

    public static void main(String[] args) {
        Course swimming = new SwimmingCourse(50);
        AbstractCourse climbing = new ClimbingCourse(30);


        Team team = new Team("Batman Team",
                new TeamMembers("Gorlum", 50, 55),
                new TeamMembers("Gimmly", 20, 15),
                new TeamMembers("Legolas", 70, 60),
                new TeamMembers("Gendalf", 15, 80)
                );

        swimming.doIt(team);
        System.out.println("Swimming winners: ");
        team.showResults();

        climbing.doIt(team);
        System.out.println("Climbing winners: ");
        team.showResults();

    }
}
