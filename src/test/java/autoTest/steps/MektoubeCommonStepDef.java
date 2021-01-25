package autoTest.steps;

import autoTest.service.TestDataService;
import autoTest.steps.serenity.MektoubeCommonEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

public class MektoubeCommonStepDef {
    @Steps
    MektoubeCommonEndUserSteps mektoubeCommonEndUserSteps;

    @Before
    public void beforeScenario() {
        if (TestDataService.properties == null) {
            TestDataService.setProperties("\\src\\test\\resources\\data_test\\data.properties");
        }
    }

    @Given("^Go to \"([^\"]*)\" url$")
    public void goToUrl(java.lang.String urlName) {
        mektoubeCommonEndUserSteps.goToUrl(urlName);
    }

    @When("^Cleare local storage$")
    public void cleareLocalStorage() {
        mektoubeCommonEndUserSteps.cleareLocalStorage();
    }

    @When("^Login with account \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void loginWithAccountAndPassword(String account, String password) {
        mektoubeCommonEndUserSteps.loginWithAccountAndPassword(account, password);
    }

    @When("^Should see message popup at top \"([^\"]*)\"$")
    public void shouldSeeMessagePopupAtTop(String mess) {
        mektoubeCommonEndUserSteps.shouldSeeMessagePopupAtTop(mess);
    }

    @Then("^Should see message popup in line \"([^\"]*)\"$")
    public void shouldSeeMessagePopupInLine(String mess) {
        mektoubeCommonEndUserSteps.shouldSeeMessagePopupInLine(mess);
    }

    @When("^Click \"([^\"]*)\"$")
    public void click(String button) {
        mektoubeCommonEndUserSteps.click(button);
    }

    @When("^Wait about (\\d+) second$")
    public void waitAboutSecond(int second) {
        mektoubeCommonEndUserSteps.waitAboutSecond(second);
    }

    @When("^Click on \"([^\"]*)\" which index is \"([^\"]*)\"$")
    public void clickOnWhichIndexIs(String button, int number) {
        mektoubeCommonEndUserSteps.clickOnWhichIndexIs(button, number);
    }

    @When("^Scroll to \"([^\"]*)\" and click$")
    public void scrollToAndClick(String button) {
        mektoubeCommonEndUserSteps.scrollToAndClick(button);
    }

    @When("^Scroll to \"([^\"]*)\" which index is \"([^\"]*)\" and click$")
    public void scrollToWhichIndexIsAndClick(String button, int number) {
        mektoubeCommonEndUserSteps.scrollToWhichIndexIsAndClick(button, number);
    }

    @When("^Wait until element \"([^\"]*)\" is visible$")
    public void waitUntilElementIsVisible(String button) {
        mektoubeCommonEndUserSteps.waitUntilElementIsVisible(button);
    }


    @Then("^Browser should redirect to \"([^\"]*)\" \\(new tab\\)$")
    public void browserShouldRedirectToNewTab(String targetUrl) {
        mektoubeCommonEndUserSteps.browserShouldRedirectToNewTab(targetUrl);
    }

    @When("^Browser should redirect to url contain \"([^\"]*)\"$")
    public void browserShouldRedirectToUrlContain(String url) {
        mektoubeCommonEndUserSteps.browserShouldRedirectToUrlContain(url);
    }

    @Then("^Redirect to link \"([^\"]*)\"$")
    public void redirectToLink(String url) {
        mektoubeCommonEndUserSteps.redirectToLink(url);
    }

    @When("^Click button \"([^\"]*)\"$")
    public void clickButton(String button) {
        mektoubeCommonEndUserSteps.clickButton(button);
    }

    @When("^Click on radio button that has text \"([^\"]*)\"$")
    public void clickOnRadioButtonThatHasText(String button) {
        mektoubeCommonEndUserSteps.clickOnRadionButtonThatHasText(button);
    }

    @When("^Insert \"([^\"]*)\" into Field \"([^\"]*)\"$")
    public void insertIntoField(String text, String fieldName) {
        mektoubeCommonEndUserSteps.insertIntoField(text, fieldName);
    }

    @When("^Logout current female account$")
    public void logoutCurrentFemaleAccount() {
        mektoubeCommonEndUserSteps.logoutCurrentFemaleAccount();
    }

    @When("^Logout current male account$")
    public void logoutCurrentMaleAccount() {
        mektoubeCommonEndUserSteps.logoutMaleCurrentAccount();
    }

    @When("^CLick filter by username$")
    public void clickFilterByUsername() {
        mektoubeCommonEndUserSteps.clickFilterByUsername();
    }

    @When("^Insert username of woman account to search username filter$")
    public void insertUsernameOfWomanAccountToSearchUsernameFilter() {
        mektoubeCommonEndUserSteps.insertUsernameOfWomanAccountToSearchUsernameFilter();
    }

    @When("^Only one radio button is clicked$")
    public void onlyOneRadioButtonIsClicked() {
        mektoubeCommonEndUserSteps.onlyOneRadioButtonIsClicked();
    }

    @When("^Get profile name from \"([^\"]*)\"$")
    public void getProfileNameFrom(String fieldName) {
        mektoubeCommonEndUserSteps.getProfileNameFrom(fieldName);
    }

    public void scroll() throws AWTException {
        mektoubeCommonEndUserSteps.scroll();
    }

    @Then("^Should see message popup at top \"([^\"]*)\" or \"([^\"]*)\"$")
    public void shouldSeeMessagePopupAtTopOr(String mess1, String mess2) {
        mektoubeCommonEndUserSteps.shouldSeeMessagePopupAtTopOr(mess1, mess2);
    }

    @When("^Scroll to element that has text \"([^\"]*)\" and click$")
    public void scrollToElementThatHasTextAndClick(String button) {
        mektoubeCommonEndUserSteps.scrollToElementThatHasTextAndClick(button);
    }

    @When("^Clear text from field \"([^\"]*)\"$")
    public void clearTextFromField(String button) {
        mektoubeCommonEndUserSteps.clearTextFromField(button);
    }

    @When("^Refresh curent page$")
    public void refreshCurentPage() {
        mektoubeCommonEndUserSteps.refreshCurentPage();
    }

    @Then("^Should see message popup \"([^\"]*)\"$")
    public void shouldSeeMessagePopup(String mess) {
        mektoubeCommonEndUserSteps.shouldSeeMessagePopup(mess);
    }

    @When("^Scroll to view \"([^\"]*)\"$")
    public void scrollToView(String element) {
        mektoubeCommonEndUserSteps.scrollToView(element);
    }

    @When("^Insert \"([^\"]*)\" into \"([^\"]*)\" Field \\(upd\\)$")
    public void insertIntoFieldUpd(String value, String field) {
        mektoubeCommonEndUserSteps.insertIntoFieldUpd(value, field);
    }

    @Then("^Browser should redirect to \"([^\"]*)\"$")
    public void browserShouldRedirectTo(String urlName) {
        mektoubeCommonEndUserSteps.shouldGotoUrl(urlName);
    }

    @When("^Scroll All page$")
    public void scrollAllPage() {
        mektoubeCommonEndUserSteps.scrollAllPage();
    }

    @When("^Click on the element is \"([^\"]*)\" by xpath$")
    public void clickOnTheElementIsByXpath(String element) {
        mektoubeCommonEndUserSteps.clickOnTheElementIsByXpath(element);
    }

    @And("^Refresh page$")
    public void refreshPage() {
        mektoubeCommonEndUserSteps.refreshPage();
    }

    @Then("^The page show error message is \"([^\"]*)\"$")
    public void thePageShowErrorMessageIs(String errorMess) {
        mektoubeCommonEndUserSteps.thePageShowErrorMessageIs(errorMess);
    }

    @And("^Broswer remain at url \"([^\"]*)\"$")
    public void broswerRemainAtUrl(String urlName) {
        mektoubeCommonEndUserSteps.shouldGotoUrl(urlName);
    }

    @When("^Open new tab$")
    public void openNewTab() throws AWTException {
        mektoubeCommonEndUserSteps.openNewTab();
    }
}
