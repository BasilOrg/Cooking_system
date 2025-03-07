package BasilSystem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Feature1 {


    @Given("I am a registered customer named {string}")
    public void i_am_a_registered_customer_named(String string) {



        // Write code here that turns the phrase above into concrete actions
    }

    @When("I navigate to the {string} section")
    public void i_navigate_to_the_section(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I enter {string} as my dietary preference")
    public void i_enter_as_my_dietary_preference(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I enter {string} as an allergy")
    public void i_enter_as_an_allergy(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I submit my preferences")
    public void i_submit_my_preferences() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the system should store {string} as a dietary preference for {string}")
    public void the_system_should_store_as_a_dietary_preference_for(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the system should store {string} as an allergy for {string}")
    public void the_system_should_store_as_an_allergy_for(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should receive a confirmation message that my information has been saved")
    public void i_should_receive_a_confirmation_message_that_my_information_has_been_saved() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("a customer {string} exists with dietary preferences {string} and allergies {string}")
    public void a_customer_exists_with_dietary_preferences_and_allergies(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("I am logged in as a chef")
    public void i_am_logged_in_as_a_chef() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I view the profile of customer {string}")
    public void i_view_the_profile_of_customer(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should see {string} listed under dietary preferences")
    public void i_should_see_listed_under_dietary_preferences(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should see {string} listed under allergies")
    public void i_should_see_listed_under_allergies(String string) {
        // Write code here that turns the phrase above into concrete actions
    }



}
