package autoTest.steps;

import autoTest.steps.serenity.FeatureForNonSubscriberEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FeatureForNonSubscriberStepDef {

    @Steps
    FeatureForNonSubscriberEndUserSteps featureForNonSubscriberEndUserSteps;

    @And("^Should see payment page$")
    public void shouldSeePaymentPage() {
        featureForNonSubscriberEndUserSteps.shouldSeePaymentPage();
    }


    @And("^Leave all fields in payment page empty$")
    public void leaveAllFieldsInPaymentPageEmpty() {
        featureForNonSubscriberEndUserSteps.leaveAllFieldsInPaymentPageEmpty();
    }

    @And("^Fill invalid number on payment page$")
    public void fillInvalidNumberOnPaymentPage() {
        featureForNonSubscriberEndUserSteps.fieldInvalidNumberOnPaymentPage();
    }

    @When("^Fill alphabet om payment page$")
    public void fillAlphabetOmPaymentPage() {
        featureForNonSubscriberEndUserSteps.fillAlphabetOmPaymentPage();
    }


    @And("^Fill special characters on payment page$")
    public void fillSpecialCharactersOnPaymentPage() {
        featureForNonSubscriberEndUserSteps.fillSpecialCharactersOnPaymentPage();
    }

    @Then("^check that the six month option is pre-selected$")
    public void checkThatTheSixMonthOptionIsPreSelected() {
        featureForNonSubscriberEndUserSteps.checkThatTheSixMonthOptionIsPreSelected();
    }

    @When("^Click contact request or discuss button$")
    public void clickContactRequestOrDiscussButton() {
        featureForNonSubscriberEndUserSteps.clickContactRequestOrDiscussButton();
    }


    @Then("^Should see blur message$")
    public void shouldSeeBlurMessage() {
        featureForNonSubscriberEndUserSteps.shouldSeeBlurMessage();
    }

    @Then("^Can read service messages$")
    public void canReadServiceMessages() {
        featureForNonSubscriberEndUserSteps.canReadServiceMessages();
    }

    @When("^Click on message unread$")
    public void clickOnMessageUnread() {
        featureForNonSubscriberEndUserSteps.clickOnMessageUnread();
    }


    @Then("^Should see pay express in payment modal$")
    public void shouldSeePayExpressInPaymentModal() {
        featureForNonSubscriberEndUserSteps.shouldSeePayExpressInPaymentModal();
    }

    @Then("^Should see enough unread message$")
    public void shouldSeeEnoughUnreadMessage() {
        featureForNonSubscriberEndUserSteps.shouldSeeEnoughUnreadMessage();
    }

    @When("^I try to click \"([^\"]*)\"$")
    public void iTryToClick(String button)  {
       featureForNonSubscriberEndUserSteps.iTryToClick(button);
    }

    @When("^Should see modal popup with message \"([^\"]*)\"$")
    public void shouldSeeModalPopupWithMessage(String text)  {
       featureForNonSubscriberEndUserSteps.shouldSeeModalPopupWithMessage(text);
    }

    @When("^I try to see other members picture full page$")
    public void iTryToSeeOtherMembersPictureFullPage() {
        featureForNonSubscriberEndUserSteps.iTryToSeeOtherMembersPictureFullPage();
    }

    @When("^I try to smile more than (\\d+) profile$")
    public void iTryToSmileMoreThanProfile(int arg0) {
        featureForNonSubscriberEndUserSteps.iTryToSmileMoreThanProfile();
    }
}
