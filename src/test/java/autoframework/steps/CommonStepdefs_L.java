package autoframework.steps;

//import autoTest.pages.CommonPage_L;
import autoframework.pages.CommonPageL;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CommonStepdefs_L {
    @Steps
    CommonPageL commonPageL;
    @When("^Click on \"([^\"]*)\"$")
    public void clickOn(String elLocator)  {
       // Write code here that turns the phrase above into concrete actions
       commonPageL.click(elLocator);
    }

    @Given("^Go to \"([^\"]*)\"$")
    public void goToUrl(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageL.gotoUrl(url);
    }

    





    @And("^input \"([^\"]*)\" into \"([^\"]*)\"$")
    public void inputInto(String arg0, String arg1) throws Throwable {

        // Write code here that turns the phrase above into concrete actions
        commonPageL.insertIntoField(arg0, arg1);
    }



    @Then("^The \"([^\"]*)\" \"([^\"]*)\" is shown$")
    public void theIsShown(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageL.assertMsg(arg0, arg1);
    }


    @Then("^The site will redirect to \"([^\"]*)\" url$")
    public void theSiteWillRedirectToUrl(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageL.redirectToLink(arg0);
    }

    @When("^Click on \"([^\"]*)\" then select \"([^\"]*)\"$")
    public void clickOnThenSelect(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageL.selectOption(arg0, arg1);
    }


    @Then("^The \"([^\"]*)\" is \"([^\"]*)\"$")
    public void theIs(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageL.validateInformation(arg0, arg1);
    }

    @Then("^The \"([^\"]*)\" is shown below the \"([^\"]*)\"$")
    public void theIsShownBelowThe(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageL.validateInformation(arg0, arg1);
    }

    @And("^Scroll and click on \"([^\"]*)\"$")
    public void scrollAndClickOn(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageL.scrollToAndClick(arg0);
    }




    @When("^Move mouse over \"([^\"]*)\" then click on \"([^\"]*)\"$")
    public void moveMouseOverThenClickOn(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageL.hoverThenClickOn(arg0, arg1);
    }


    @And("^Wait until \"([^\"]*)\" disappear then click on \"([^\"]*)\"$")
    public void waitUntilDisappearThenClickOn(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageL.waitUntilElementDisapear(arg0);
        commonPageL.scrollToAndClick(arg1);
    }

    @And("^Choose an item$")
    public void chooseAnItem() {
        commonPageL.chooseAnItem();
    }

    @Then("^The \"([^\"]*)\" Message is shown$")
    public void theMessageIsShown(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPageL.validateResultMsg(message);
    }

    @Given("^Login \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginWithAnd(String adminPage, String account, String password) throws Throwable {
        commonPageL.loginAdminPageWithAnd(adminPage, account, password);
    }



//    @Then("^The \"([^\"]*)\" appears there$")
//    public void theAppearsThere(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        commonEndUserSteps.isExitElement(arg0);
//    }
}

