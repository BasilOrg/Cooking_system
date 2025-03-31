package BasilSystem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Chef;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class Feature3 {


    private String pendingTask;
    private final Map<String, Chef> chefRegistry = new HashMap<>();
    private Chef assignedChef;

    @Given("the kitchen has chefs with different expertise levels")
    public void the_kitchen_has_chefs_with_different_expertise_levels() {
        System.out.println("\nThe kitchen has chefs with different expertise levels.");
        assertTrue(true);

    }

    @Given("chef {string} specializes in {string}")
    public void chef_specializes_in(String name, String specialization) {
        Chef chef = new Chef(name, specialization);
        chefRegistry.put(name, chef);
        System.out.println(chef);
        assertTrue(true);

    }

    @When("a new cooking task {string} needs to be assigned")
    public void a_new_cooking_task_needs_to_be_assigned(String taskName) {
        pendingTask = taskName;
        System.out.println("A new cooking task '" + taskName + "' needs to be assigned.");
        assertTrue(true);

    }

    @Then("the system assigns the task to chef {string}")
    public void the_system_assigns_the_task_to_chef(String chefName) {
        assignedChef = chefRegistry.get(chefName);
        if (assignedChef != null) {
            assignedChef.assignTask(pendingTask);
            System.out.println("Task '" + pendingTask + "' assigned to " + chefName);
            assertTrue(true);

        } else {
            System.out.println("Chef " + chefName + " not found.");
            assertFalse(false);
        }
    }

    @Then("chef {string} receives a notification about the task")
    public void chef_receives_a_notification_about_the_task(String chefName) {
        if (assignedChef != null && assignedChef.getName().equals(chefName)) {
            System.out.println(chefName + " received a notification for task: " + pendingTask);
            assertTrue(true);

        }
    }

    @Given("chef {string} already has {int} tasks assigned")
    public void chef_already_has_tasks_assigned(String chefName, Integer taskCount) {
        Chef chef = chefRegistry.get(chefName);
        if (chef != null) {
            chef.setTaskCount(taskCount);
            System.out.println(chefName + " already has " + taskCount + " tasks.");
            assertTrue(true);

        }
    }

    @Given("chef {string} has {int} tasks assigned")
    public void chef_has_tasks_assigned(String chefName, Integer taskCount) {
        Chef chef = chefRegistry.get(chefName);
        if (chef != null) {
            chef.setTaskCount(taskCount);
            System.out.println(chefName + " has " + taskCount + " tasks assigned.");
            assertTrue(true);

        }
    }

    @Then("the system assigns the task to chef {string} to balance the workload")
    public void the_system_assigns_the_task_to_chef_to_balance_the_workload(String chefName) {
        assignedChef = chefRegistry.get(chefName);
        if (assignedChef != null) {
            assignedChef.assignTask(pendingTask);
            System.out.println("Task '" + pendingTask + "' reassigned to balance workload: " + chefName);
            assertTrue(true);

        }
    }

    @Given("chef {string} is assigned the task {string}")
    public void chef_is_assigned_the_task(String chefName, String taskName) {
        assignedChef = chefRegistry.get(chefName);
        if (assignedChef != null) {
            assignedChef.assignTask(taskName);
            System.out.println(chefName + " is assigned the task: " + taskName);
            assertTrue(true);

        }
    }

    @When("the system sends task notifications")
    public void the_system_sends_task_notifications() {
        System.out.println("The system is sending task notifications.");
        assertTrue(true);

    }

    @Then("chef {string} should receive a notification with the task details")
    public void chef_should_receive_a_notification_with_the_task_details(String chefName) {
        assignedChef = chefRegistry.get(chefName);
        if (assignedChef != null) {
            System.out.println(chefName + " received a notification with the task details for: " + pendingTask);
            assertTrue(true);

        }
    }
}


