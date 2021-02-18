package ru.geekbrains.lesson1;

public class TeamMembers {

    private String name;
    private int swimmingDistance;
    private int climbingDistance;
    private boolean isPassed;

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }


    public TeamMembers(String name, int swimmingDistance, int climbingDistance) {
        this.name = name;
        this.swimmingDistance = swimmingDistance;
        this.climbingDistance = climbingDistance;
    }

    public String getName() {
        return name;
    }

    public int getSwimmingDistance() {
        return swimmingDistance;
    }

    public int getClimbingDistance() {
        return climbingDistance;
    }

    @Override
    public String toString() {
        return "TeamMembers{" +
                "name='" + name + '\'' +
                ", swimmingDistance=" + swimmingDistance +
                ", climbingDistance=" + climbingDistance +
                ", isPassed=" + isPassed +
                '}';
    }
}
