package autoframework.steps.frontEnd;

import autoframework.pages.frontEnd.RegisterAccPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegisterAccStep  {
    @Steps
    RegisterAccPage nia;

    @When("Click Sign In/ Sign Up button")
    public void signUpBtn(){
        System.out.println("Click Sign up Button");
        nia.clickSignUpBtn();
    }
    @When("Click accept button")
    public void clickBtn(){
        System.out.println("Click Accept Button");
        nia.AcceptBtn();
    }
    @When("Click Submit button")
    public void clickSubmitBtn()  {
        System.out.println("Click Submit Button");
        nia.SubmitBtn();
    }
    @Then("^Show error-box$")
    public void error_box() {
        System.out.println("login fail");
    }

    @Then("Show Error Messages under button :(.*)")
    public void getMsgError_acceptBtn(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgError_acceptBtn(expectMsg);
    }

     @Then("Show Error Messages under blank :(.*)")
    public void checkErrorMsg_firstName_blank(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgError_all_blank(expectMsg);
    }



   }
