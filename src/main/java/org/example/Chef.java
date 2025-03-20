package org.example;

public class Chef {

    private final String name;
    private final String specialization;
    private int taskCount = 0;

    public Chef(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void assignTask(String task) {
        System.out.println(name + " is assigned to task: " + task);
        taskCount++;
    }

    public void setTaskCount(int count) {
        this.taskCount = count;
    }

    public int getTaskCount() {
        return taskCount;
    }

}
