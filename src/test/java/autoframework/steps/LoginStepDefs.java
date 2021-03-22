package autoframework.steps;


import autoframework.pages.LoginPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginStepDefs {
    @Steps
    LoginPages nia;


    @When("^I login with (valid|invalid) username and password$")
    public void login(String isValid) {
        nia.clickOnSignInButton();
        nia.login(isValid);
    }

    @Then("^I should( not)? be on user profile page$")
    public void iShouldBeOnUserProfilePage(String negative) {
        System.out.println("Is on page: " + nia.isOnPage());
        if(negative == null) {
            Assert.assertTrue(nia.isOnPage());
        } else {
            Assert.assertFalse(nia.isOnPage());
        }
    }
    
//    -------Lan's code-------------
    @When("^Click on Sigin$")
    public void clickOnSigIn() {
        nia.clickOnSigin();
    }

    @And("^input \"([^\"]*)\" and \"([^\"]*)\"$")
    public void inputAnd(String arg0, String arg1) throws Throwable {
        nia.inputAccount(arg0, arg1);
    }


    @Then("^The \"([^\"]*)\" is shown$")
    public void theIsShown(String arg0) throws Throwable {
        nia.showErrorMessage(arg0);
    }

    @Then("^The site will redirect to \"([^\"]*)\"$")
    public void theSiteWillRedirectTo(String arg0) throws Throwable {
        nia.redirectToLink(arg0);
    }

//    @When("^login adminPage with \"([^\"]*)\" and \"([^\"]*)\"$")
//    public void loginAdminPageWithAnd(String account, String password) throws Throwable {
//        nia.loginAdminPageWithAnd(account, password);
//    }

    @Given("^Login \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginWithAnd(String adminPage, String account, String password) throws Throwable {
        nia.loginAdminPageWithAnd(adminPage, account, password);
    }
    
}
