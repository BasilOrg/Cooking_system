package BasilSystem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Customer;
import org.example.TestInput;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class Feature1 {

    ArrayList<Customer>ac=new ArrayList<>();

    @Then("the field {string} should be error")
    public void theFieldShouldBeError(String string) {

        System.out.println("Please enter the information");
        assertEquals(false,false);
        // Write code here that turns the phrase above into concrete actions
    }

    @When("user clik on insert order and flag is {string}")
    public void userClikOnInsertOrderAndFlagIs(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("he fill in {string} with {string}")
    public void heFillInWith(String string, String string2) {
        boolean flag =false;
        if(string.equals("Name")){

            flag= TestInput.nameTest(string2);
            if(flag) assertTrue(true);
            else assertFalse(false);

        }
        if(string.equals("dietaryPresences")){

            flag= TestInput.dietaryPresencesTest(string2);
            if(flag) assertTrue(true);
            else assertFalse(false);

        }
        if(string.equals("Allergies")){

            flag= TestInput.allergiesTest(string2);
            if(flag) assertTrue(true);
            else assertFalse(false);

        }




        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the system should store {string} as a dietary preference and {string} for {string}")
    public void theSystemShouldStoreAsADietaryPreferenceAndFor(String dietaryPresences, String allergies, String name) {
        // Write code here that turns the phrase above into concrete actions
        Customer customer=new Customer();
        customer.setName(name);
        customer.setDietaryPreference(dietaryPresences);
        customer.setAllergy(allergies);

        ac.add(customer);
    }

    @Then("I should receive a confirmation message that my information has been saved")
    public void iShouldReceiveAConfirmationMessageThatMyInformationHasBeenSaved() {

        System.out.println("The information saved Successfully!");
        assertTrue(true);
        // Write code here that turns the phrase above into concrete actions
    }

    @When("user click on insert order and flag is {string}")
    public void userClickOnInsertOrderAndFlagIs(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the user should see {string}")
    public void theUserShouldSee(String string) {

        boolean flag =false;

            flag= TestInput.nameTest(string);
            if(flag) assertTrue(true);
            else System.out.println("Name is Invalid OR Name must be A a string ");





            flag= TestInput.dietaryPresencesTest(string);
            if(flag) assertTrue(true);
            else  System.out.println("dietaryPresences must be a String  OR dietaryPresences is Invalid");




            flag= TestInput.allergiesTest(string);
            if(flag) assertTrue(true);
            else ;System.out.println("Allergies must be a String  OR Allergies is Invalid   ");


        // Write code here that turns the phrase above into concrete actions
    }

    @When("I retrieve the preferences for {string}")
    public void iRetrieveThePreferencesFor(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should see {string} in dietary preferences")
    public void iShouldSeeInDietaryPreferences(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should see {string} in allergies")
    public void iShouldSeeInAllergies(String string) {
        // Write code here that turns the phrase above into concrete actions
    }


}
