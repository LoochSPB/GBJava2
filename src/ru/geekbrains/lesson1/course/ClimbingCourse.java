package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Team;
import ru.geekbrains.lesson1.TeamMembers;

public class ClimbingCourse  extends AbstractCourse {

    private int distance;

    public ClimbingCourse(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(TeamMembers teamMembers) {
        if (teamMembers.getClimbingDistance() >= distance) {
            teamMembers.setPassed(true);
        } else {
            teamMembers.setPassed(false);
        }
    }
}
