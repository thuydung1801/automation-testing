package autoframework.steps;

import autoframework.pages.CommonPage;
import autoframework.service.TestDataService;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CommonPageSteps {
    @Steps
    CommonPage nia;

    @Before
    public void beforeScenario() {
        if (TestDataService.properties == null) {
            TestDataService.setProperties("//src//test//resources//data_test//data.properties");
        }
    }

    @And("Wait about (.*) seconds")
    public void waitAboutSeconds(int second) throws InterruptedException {
        nia.waitAboutSeconds(second);
    }
    @And("I click button has text (.*)")
    public void iClickButtonHasText(String buttontext) {
        nia.iClickButtonHasText(buttontext);
    }
    @And("I click button has id (.*)")
    public void iClickButtonHasId(String buttontext) {
        nia.clickButtonById(buttontext);
    }
    @And("Wait until display button has text (.*)")
    public void waitUntilDisplayButtonHasText(String buttontext) {
        nia.waitUntilDisplayButtonHasText(buttontext);
    }
    @And("Wait until display element by xpath (.*)")
    public void waitUntilDisplayElementByXpath(String element) {
        nia.waitUntilDisplayElementByXpath(element);
    }
    @And("Click button by xpath (.*)")
    public void clickButtonByXpath(String xpathButton) {
       nia.clickButtonByXpath(xpathButton);
    }
    @When("Insert (.*) into field (.*)")
    public void insertIntoField(String text, String xpath) {
        nia.insertIntoFieldByXpath(text,xpath);
    }
    @When("Insert (.*) into box have name: (.*)")
    public void insertName(String text, String name) throws InterruptedException {
        System.out.println(" Insert "+ text+ " into " + name);
        nia.insertIntoFieldByName(text, name);
    }
    @And("Insert (.*) into box have id: (.*)")
    public void insertId(String text, String id) throws InterruptedException {
        System.out.println(" Insert "+ text+ " into " + id);
        nia.insertIntoFieldById(text, id);
    }
    @Then("Show Error Messages :(.*)")
    public void checkErrorMsg(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgError_fail(expectMsg);
    }
    @Then("^Successfully into (.*) front site$")
    public void Successfully(String expectUrl) throws InterruptedException {
        System.out.println("Successfully");
        nia.checkURl(expectUrl);
    }
    @Then("Show Messages : (.*)")
    public void getMsgItem(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgItem(expectMsg);
    }
    @And("Click button by class (.*)")
    public void clickButtonByClass(String classButton) {
        nia.clickButtonByclass(classButton);
    }
    @When ("Click accept cookie")
    public void acceptCookie(){
        nia.acceptCookie();
    }
    @Then("Show error message for id (.*) blank: (.*)")
    public void showErrorMessageForBlankById(String id,String msg) {
        nia.showErrorMessageForBlankById(id,msg);
    }

    @Then("Show error message for class (.*) blank: (.*)")
    public void showErrorMessageForBlankByClass(String clname,String msg) {
        nia.showErrorMessageForBlankByClass(clname,msg);
    }
//    ----Hương's code
    @When("^Click on \"([^\"]*)\"$")
    public void clickOn(String elLocator)  {
        // Write code here that turns the phrase above into concrete actions
        nia.clickOn(elLocator);
    }


    @And("^input \"([^\"]*)\" into \"([^\"]*)\"$")
    public void inputInto(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.insertIntoField(arg0, arg1);
    }



    @Then("^The \"([^\"]*)\" \"([^\"]*)\" is shown$")
    public void theIsShown(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.assertMsg(arg0, arg1);
    }


    @Then("^The site will redirect to \"([^\"]*)\" url$")
    public void theSiteWillRedirectToUrl(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.redirectToLink(arg0);
    }

    @When("^Click on \"([^\"]*)\" then select \"([^\"]*)\"$")
    public void selectOption(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.selectOption(arg0, arg1);
    }


    @Then("^The \"([^\"]*)\" is \"([^\"]*)\"$")
    public void theIs(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.validateInformation(arg0, arg1);
    }

    @Then("^The \"([^\"]*)\" is shown below the \"([^\"]*)\"$")
    public void assertMsg(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.assertMsg(arg0, arg1);
    }

    @And("^Scroll and click on \"([^\"]*)\"$")
    public void scrollAndClickOn(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.scrollToAndClick(arg0);
    }

    @When("^Move mouse over \"([^\"]*)\" then click on \"([^\"]*)\"$")
    public void moveMouseOverThenClickOn(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.hoverThenClickOn(arg0, arg1);
    }


    @And("^Wait until \"([^\"]*)\" disappear then click on \"([^\"]*)\"$")
    public void waitUntilDisappearThenClickOn(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.scrollToAndClick( arg1);
    }

    @And("^Choose an item$")
    public void chooseAnItem() {
        nia.chooseAnItem();
    }

    @Then("^The \"([^\"]*)\" Message is shown$")
    public void theMessageIsShown(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.scrollToAndClick(message);
    }
    @Given("^Go to \"([^\"]*)\" url$")
    public void goToUrl(String url) {
        nia.gotoUrl(url);
    }

// -----Lan's code










}