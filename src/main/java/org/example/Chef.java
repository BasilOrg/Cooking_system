package org.example;

import java.util.logging.Logger;

public class Chef {

    private String name;
    private String specialization;
    private int taskCount = 0;
    Logger logger = Logger.getLogger(getClass().getName());


    @Override
    public String toString() {

        return ( "Chef Name:"+name+'\t'+"specialization:"+specialization+"\n");
    }



    public Chef() {

// default implementation ignored
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
        logger.info(name + " is assigned to task: " + task);  // Compliant, output via logger
        taskCount++;
    }

    public void setTaskCount(int count) {
        this.taskCount = count;
    }
/*
    public int getTaskCount() {
        return taskCount;
    }


 */
}
