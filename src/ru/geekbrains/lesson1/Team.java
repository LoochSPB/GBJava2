package ru.geekbrains.lesson1;

import java.util.Arrays;

public class Team {

    private String name;
    private TeamMembers[] teamMembers;
    public Team(String name, TeamMembers... teamMembers) {
        this.name = name;
        this.teamMembers = teamMembers;


    }

    public TeamMembers[] getTeamMembers() {
        return teamMembers;
    }

    public void showResults() {
        for (int i = 0; i < teamMembers.length ; i++) {
            if(getTeamMembers()[i].isPassed()) {
                System.out.println(getTeamMembers()[i]);
            }
        }
    }

}
