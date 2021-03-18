package autoTest_DoiHuong.steps;

import autoTest_DoiHuong.pages.LoginPages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginStepDefs {
    @Steps
    LoginPages loginPages;


    @When("^I login with (valid|invalid) username and password$")
    public void login(String isValid) {
        loginPages.clickOnSignInButton();
        loginPages.login(isValid);
    }




    @Then("^I should( not)? be on user profile page$")
    public void iShouldBeOnUserProfilePage(String negative) {
//        boolean flag = negative == null;
//        Assert.assertEquals(loginPages.isOnPage(), flag);

        System.out.println("Is on page: " + loginPages.isOnPage());
        if(negative == null) {
            Assert.assertTrue(loginPages.isOnPage());
        } else {
            Assert.assertFalse(loginPages.isOnPage());
        }
    }



//    @Then("^Go to the \"([^\"]*)\"url$")
//    public void goToTheUrl(String url) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        loginPages.goToTheUrl(url);
//    }
}
