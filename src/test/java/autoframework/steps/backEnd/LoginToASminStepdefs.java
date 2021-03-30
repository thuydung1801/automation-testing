package autoframework.steps.backEnd;
import autoframework.pages.backEnd.LoginToAdminPages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginToASminStepdefs {
    @Steps
    LoginToAdminPages logintoadminPages;

    @When("^I login to admin with (valid|invalid) username and password$")
    public void iLoginToAdminWithInvalidUsernameAndPassword(String isValid) {
        logintoadminPages.LoginAdmin(isValid);

    }

    @Then("^I should (not)? be on Admin Porfile pages$")
    public void iShouldNotBeOnAdminPorfilePages(String negative) {
        System.out.println("Is on page: " + logintoadminPages.AdminPages());
        if(negative == null) {
            Assert.assertTrue(logintoadminPages.AdminPages());
        } else {
            Assert.assertFalse(logintoadminPages.AdminPages());
        }
    }
}
