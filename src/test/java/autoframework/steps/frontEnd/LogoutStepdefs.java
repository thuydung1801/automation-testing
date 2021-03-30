package autoframework.steps.frontEnd;


import autoframework.pages.frontEnd.LogoutPages;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

public class LogoutStepdefs {
    @Steps
    LogoutPages loginPages;

    @And("^After I click in Sign out button$")
    public void afterIClickInSignOutButton() {

        loginPages.Logout();
    }
}
