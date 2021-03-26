package autoframework.steps.frontEnd;

import autoframework.pages.frontEnd.ForgotPassPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ForgotPassStep {
    ForgotPassPage nia;
    @When("Click forgot Password button")
    public void clickForgotPassBtn(){
        System.out.println("Click Forgot Password Button");
        nia.forgotPassBtn();
    }
    @When("Click Reset My Password button")
    public void clickResetMyPassBtn() {
        System.out.println("Click Reset my Password Button");
        nia.resetMyPassBtn();
    }
    @When("Click Go Back button")
    public void clickGoBackBtn()  {
        System.out.println("Click Go Back Button");
        nia.goBackBtn();
    }
    @Then("Show messages: (.*)")
    public void getMsgSuc_forgotPass(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgSuc_forgotPass(expectMsg);
    }
    @Then("Show Error Messages :(.*)")
    public void checkErrorMsg(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgError_fail(expectMsg);
    }

}
