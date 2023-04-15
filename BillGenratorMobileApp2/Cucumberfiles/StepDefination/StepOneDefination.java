package StepDefination;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepOneDefination {
	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {

		System.out.println("Preconditions are mentioned here.");
	}

	@When("^I complete action$")
	public void i_complete_action() throws Throwable {
		System.out.println("Complete One action here");
	}

	@When("^I check for the (.+) in step$")
	public void i_check_for_the_in_step(String value) throws Throwable {
		System.out.println("Check something in step.");
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {
		System.out.println("Validate the outcome");
	}

	@Then("^I verify the (.+) in step$")
	public void i_verify_the_in_step(String status) throws Throwable {
		System.out.println("Verify something in step.");
	}

	@And("^some other precondition$")
	public void some_other_precondition() throws Throwable {
		System.out.println("Another precondition");
	}

	@And("^some other action$")
	public void some_other_action() throws Throwable {
		System.out.println("Some other actions");
	}

	@And("^yet another action$")
	public void yet_another_action() throws Throwable {
		System.out.println("Yet other actions");
	}

	@And("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
		System.out.println("check more outcomes");
	}
	
//	io.cucumber.junit.UndefinedStepException: The step 'I want to write a step with name1' is undefined.
//	You can implement this step using the snippet(s) below:

	@Given("I want to write a step with name1")
	public void i_want_to_write_a_step_with_name1() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I want to write a step with name1");
	    //throw new io.cucumber.java.PendingException();
	}
//	io.cucumber.junit.UndefinedStepException: The step 'I want to write a step with name2' is undefined.
//	You can implement this step using the snippet(s) below:

	@Given("I want to write a step with name2")
	public void i_want_to_write_a_step_with_name2() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I want to write a step with name2");
	   // throw new io.cucumber.java.PendingException();
	}







}