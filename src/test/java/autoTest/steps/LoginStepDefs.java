package autoTest.steps;

import autoTest.steps.serenity.LoginEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefs {
    @Steps
    LoginEndUserSteps logInEndUserSteps;




    @When("^Click on Sigin$")
    public void clickOnSigIn() {
        logInEndUserSteps.click();
    }

    @And("^input \"([^\"]*)\" and \"([^\"]*)\"$")
    public void inputAnd(String arg0, String arg1) throws Throwable {
        logInEndUserSteps.inputAccount(arg0, arg1);
    }

    @And("^Click on Sigin button$")
    public void clickOnSiginButton() {
        logInEndUserSteps.clickOnSiginButton();
    }

    @Then("^The \"([^\"]*)\" is shown$")
    public void theIsShown(String arg0) throws Throwable {
        logInEndUserSteps.showErrorMessage(arg0);
    }

    @Then("^The site will redirect to \"([^\"]*)\"$")
    public void theSiteWillRedirectTo(String arg0) throws Throwable {
        logInEndUserSteps.redirectToLink(arg0);
    }

//    @When("^login adminPage with \"([^\"]*)\" and \"([^\"]*)\"$")
//    public void loginAdminPageWithAnd(String account, String password) throws Throwable {
//        logInEndUserSteps.loginAdminPageWithAnd(account, password);
//    }

    @Given("^Login \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginWithAnd(String adminPage, String account, String password) throws Throwable {
        logInEndUserSteps.loginAdminPageWithAnd(adminPage, account, password);
    }
}
