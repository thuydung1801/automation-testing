package autoTest.steps;

import autoTest.steps.serenity.LoginEndUserSteps;
import net.thucydides.core.annotations.Steps;


public class LoginStepDef {

    @Steps
    LoginEndUserSteps demoEndUserSteps;

//    @Given("^Go to \"([^\"]*)\" url$")
//    public void goToUrl(String url){
//
//        demoEndUserSteps.goToUrl(url);
//    }


//    @When("^Click on \"([^\"]*)\"$")
//    public void clickOn(String signinBtn)  {
//        // Write code here that turns the phrase above into concrete actions
//        demoEndUserSteps.clickSigin(signinBtn);
//    }




//    @And("^User try to sign in with \"([^\"]*)\" on  Email and \"([^\"]*)\" on password$")
//    public void userTryToSignInWithOnEmailAndOnPassword(String email, String password) throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        demoEndUserSteps.inputAccount(email, password);
//    }

//    @Then("^The error message \"([^\"]*)\" is shown$")
//    public void theErrorMessageIsShown(String errorMessage) throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//
//        //Assert.assertEquals(errorMessage, demoEndUserSteps.showErrorMessage().getText());
//        demoEndUserSteps.showErrorMessage(errorMessage);
//    }
}
