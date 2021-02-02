package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Team;
import ru.geekbrains.lesson1.TeamMembers;

public class SwimmingCourse extends AbstractCourse {

    private int distance;

    public SwimmingCourse(int distance) {
        this.distance = distance;
    }


    @Override
    public void doIt(TeamMembers teamMembers) {
        if (teamMembers.getSwimmingDistance() >= distance) {
            teamMembers.setPassed(true);
        } else {
            teamMembers.setPassed(false);
        }
    }


}
