package autoTest.steps;
import autoTest.steps.serenity.CommonEndUserSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CommonStepdefs {
    @Steps
    CommonEndUserSteps commonEndUserSteps;
    @When("^Click on \"([^\"]*)\"$")
    public void clickOn(String elLocator)  {
       // Write code here that turns the phrase above into concrete actions
       commonEndUserSteps.clickOn(elLocator);
    }

    @Given("^Go to \"([^\"]*)\" url$")
    public void goToUrl(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.goToUrl(url);
    }

    





    @And("^input \"([^\"]*)\" into \"([^\"]*)\"$")
    public void inputInto(String arg0, String arg1) throws Throwable {

        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.input(arg0, arg1);
    }



    @Then("^The \"([^\"]*)\" \"([^\"]*)\" is shown$")
    public void theIsShown(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.assertMsg(arg0, arg1);
    }


    @Then("^The site will redirect to \"([^\"]*)\" url$")
    public void theSiteWillRedirectToUrl(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.redirectTo(arg0);
    }

    @When("^Click on \"([^\"]*)\" then select \"([^\"]*)\"$")
    public void clickOnThenSelect(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.selectOption(arg0, arg1);
    }


    @Then("^The \"([^\"]*)\" is \"([^\"]*)\"$")
    public void theIs(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.validateInformation(arg0, arg1);
    }

    @Then("^The \"([^\"]*)\" is shown below the \"([^\"]*)\"$")
    public void theIsShownBelowThe(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.showErrorMsg(arg0, arg1);
    }

    @And("^Scroll and click on \"([^\"]*)\"$")
    public void scrollAndClickOn(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.scrollAndClick(arg0);
    }




    @When("^Move mouse over \"([^\"]*)\" then click on \"([^\"]*)\"$")
    public void moveMouseOverThenClickOn(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.hoverThenClickOn(arg0, arg1);
    }


    @And("^Wait until \"([^\"]*)\" disappear then click on \"([^\"]*)\"$")
    public void waitUntilDisappearThenClickOn(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.waitDisapearAndClick(arg0, arg1);
    }

    @And("^Choose an item$")
    public void chooseAnItem() {
        commonEndUserSteps.chooseAnItem();
    }

    @Then("^The \"([^\"]*)\" Message is shown$")
    public void theMessageIsShown(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonEndUserSteps.validateResultMsg(message);
    }


//    @Then("^The \"([^\"]*)\" appears there$")
//    public void theAppearsThere(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        commonEndUserSteps.isExitElement(arg0);
//    }
}

