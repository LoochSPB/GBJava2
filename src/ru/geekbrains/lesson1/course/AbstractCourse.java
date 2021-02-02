package ru.geekbrains.lesson1.course;


import ru.geekbrains.lesson1.Team;
import ru.geekbrains.lesson1.TeamMembers;

public abstract class AbstractCourse implements Course {

    protected int distance;
    protected abstract void doIt (TeamMembers teamMembers);

    @Override
    public void doIt(Team team) {
        for (int i = 0; i < team.getTeamMembers().length; i++) {
            doIt(team.getTeamMembers()[i]);
        }


    }
}
