package autoTest.steps;

import autoTest.steps.serenity.NotificationScreenEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class NotificationScreenStepDef {

    @Steps
    NotificationScreenEndUserSteps notificationScreenEndUserSteps;

    @When("^Click on the person have above name \"([^\"]*)\"$")
    public void clickOnThePersonHaveAboveName(String name) {
        notificationScreenEndUserSteps.clickOnThePersonHaveAboveName(name);
    }

    @When("^Scroll All page \"([^\"]*)\"$")
    public void scrollAllPage(String element) {
        notificationScreenEndUserSteps.scrollAllPage(element);
    }

    @Then("^the green point of the notifications are displayed$")
    public void theGreenPointOfTheNotificationsAreDisplayed() {
        notificationScreenEndUserSteps.theGreenPointOfTheNotificationsAreDisplayed();
    }

    @Then("^The page recevied a refused photo notification$")
    public void thePageReceviedARefusedPhotoNotification() {
        notificationScreenEndUserSteps.thePageReceviedARefusedPhotoNotification();
    }


    @Then("^Clicking on a notification of smile$")
    public void clickingOnANotificationOfSmile() {
        notificationScreenEndUserSteps.clickingOnANotificationOfSmile();
    }

    @Then("^The page redirect to page of profile$")
    public void thePageRedirectToPageOfProfile() {
        notificationScreenEndUserSteps.thePageRedirectToPageOfProfile();
    }

    @And("^Name of notification must equal with name in profile$")
    public void nameOfNotificationMustEqualWithNameInProfile() {
        notificationScreenEndUserSteps.nameOfNotificationMustEqualWithNameInProfile();
    }


    @When("^Clicking on a notification of visit$")
    public void clickingOnANotificationOfVisit() {
        notificationScreenEndUserSteps.clickingOnANotificationOfVisit();
    }

    @Then("^The page show all notifications that are smile noti$")
    public void thePageShowAllNotificationsThatAreSmileNoti() {
        notificationScreenEndUserSteps.thePageShowAllNotificationsThatAreSmileNoti();
    }

    @Then("^The page show all notifications that are visit noti$")
    public void thePageShowAllNotificationsThatAreVisitNoti() {
        notificationScreenEndUserSteps.thePageShowAllNotificationsThatAreVisitNoti();
    }

    @Then("^The page show all notifications that are all notis$")
    public void thePageShowAllNotificationsThatAreAllNotis() {
        notificationScreenEndUserSteps.thePageShowAllNotificationsThatAreAllNotis();
    }

    @When("^Click on a notification of visit in real time$")
    public void clickOnANotificationOfVisitInRealTime() {
        notificationScreenEndUserSteps.clickOnANotificationOfVisitInRealTime();
    }

    @And("^The profile must have green point$")
    public void theProfileMustHaveGreenPoint() {
        notificationScreenEndUserSteps.theProfileMustHaveGreenPoint();
    }

    @When("^Click on a notification of smile in real time$")
    public void clickOnANotificationOfSmileInRealTime() {
        notificationScreenEndUserSteps.clickOnANotificationOfSmileInRealTime();
    }

    @Then("^The page recevied a accept photo notification$")
    public void thePageReceviedAAcceptPhotoNotification() {
        notificationScreenEndUserSteps.thePageReceviedAAcceptPhotoNotification();
    }

    @When("^Click on the element is \"([^\"]*)\" if not yet checked$")
    public void clickOnTheElementIsIfNotYetChecked(String element) {
        notificationScreenEndUserSteps.clickOnTheElementIsIfNotYetChecked(element);
    }

    @Then("^The page show green notification is \"([^\"]*)\" at \"([^\"]*)\"$")
    public void thePageShowGreenNotificationIsAt(String greenMess, String element) {
        notificationScreenEndUserSteps.thePageShowGreenNotificationIsAt(greenMess, element);
    }

    @Then("^The page shows first visit notification is \"([^\"]*)\"$")
    public void thePageShowsFirstVisitNotificationIs(String name) {
        notificationScreenEndUserSteps.thePageShowsFirstVisitNotificationIs(name);
    }

    @When("^Click message button in first notification in noti page$")
    public void clickMessageButtonInFirstNotificationInNotiPage() {
        notificationScreenEndUserSteps.clickMessageButtonInFirstNotificationInNotiPage();
    }
}
