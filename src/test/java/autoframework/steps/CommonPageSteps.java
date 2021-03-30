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
    @Given("^Go to \"([^\"]*)\" url$")
    public void goToUrl(String url) {
        nia.gotoUrl(url);
    }
    @And("Wait about (.*) seconds")
    public void waitAboutSeconds(int second)  {
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
    public void insertName(String text, String name)  {
        nia.insertIntoFieldByName(text, name);
    }
    @And("Insert (.*) into box have id: (.*)")
    public void insertId(String text, String id)  {
        nia.insertIntoFieldById(text, id);
    }

    @Then("^Successfully into (.*) front site$")
    public void Successfully(String expectUrl)  {
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



}