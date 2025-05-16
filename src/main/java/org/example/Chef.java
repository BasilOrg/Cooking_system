package org.example;

public class Chef {

    private String name;
    private String specialization;
    private int taskCount = 0;


    @Override
    public String toString() {

        return ( "Chef Name:"+name+'\t'+"specialization:"+specialization+"\n");
    }



    public Chef() {

    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setName(String name) {
        this.name = name;
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
