package autoTest.steps.serenity;

import autoTest.pages.HomePageAndLoginPage;
import autoTest.pages.MektoubeCommonPage;
import autoTest.service.TestDataService;

import java.awt.*;

import net.thucydides.core.annotations.Step;

import java.util.ArrayList;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

public class MektoubeCommonEndUserSteps {
    MektoubeCommonPage mektoubeCommonPage;

    HomePageAndLoginPage homePageAndLoginPage = new HomePageAndLoginPage();

    public void goToUrl(String urlName) {
        mektoubeCommonPage.gotoUrl(urlName);
    }

    public void loginWithAccountAndPassword(String account, String password) {
        mektoubeCommonPage.loginWithAccountAndPassword(account, password);
    }

    public void shouldSeeMessagePopupAtTop(String mess) {
        assertThat(mektoubeCommonPage.shouldSeeMessagePopupAtTop(mess), is(equalTo(true)));
    }

    public void shouldSeeMessagePopupInLine(String mess) {
        assertThat(mektoubeCommonPage.shouldSeeMessagePopupInLine(mess), is(equalTo(true)));
    }

    public void click(String button) {
        mektoubeCommonPage.click(button);
    }

    public void waitAboutSecond(int second) {
        mektoubeCommonPage.waitAboutSecond(second);
    }

    public void clickOnWhichIndexIs(String button, int number) {
        mektoubeCommonPage.clickOnWhichIndexIs(button, number);
    }

    public void waitUntilElementIsVisible(String button) {
        mektoubeCommonPage.waitUntilElementIsVisible(button);
    }

    public void scrollToView(String element) {
        mektoubeCommonPage.scrollToView(element);
    }

    public void insertIntoFieldUpd(String value, String field) {
        mektoubeCommonPage.insertIntoFieldUpd(value, field);
    }

    @Step
    public void shouldGotoUrl(String urlName) {
        String url = TestDataService.properties.getProperty(urlName);
        if (url == null) {
            url = urlName;
        }
        if (url.contentEquals("http://aide.mektoube.fr/")) {

            ArrayList<String> tabs_windows = new ArrayList<String>(getDriver().getWindowHandles());
            getDriver().switchTo().window(tabs_windows.get(1));
            assertThat(mektoubeCommonPage.getCurrentUrl(), containsString(url));
        } else {
            mektoubeCommonPage.waitAboutSecond(2);
            assertThat(mektoubeCommonPage.getCurrentUrl(), containsString(url));
        }
    }

    public void browserShouldRedirectToNewTab(String url) {
        ArrayList<String> tabs_windows = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs_windows.get(1));//switch to new tab
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(mektoubeCommonPage.getCurrentUrl(), containsString(url));//compare post url with wish url
        System.out.println("==>Successful " + url);
    }

    public void redirectToLink(String url) {
        assertThat(mektoubeCommonPage.redirectToLink(url), is(equalTo(true)));
    }

    public void clickButton(String button) {
        mektoubeCommonPage.clickButton(button);
    }

    public void clickOnRadionButtonThatHasText(String button) {
        mektoubeCommonPage.clickOnRadionButtonThatHasText(button);
    }

    public void insertIntoField(String text, String fieldName) {
        mektoubeCommonPage.insertIntoField(text, fieldName);
    }

    public void logoutCurrentFemaleAccount() {
        mektoubeCommonPage.logoutCurrentFemaleAccount();
    }

    public void logoutMaleCurrentAccount() {
        mektoubeCommonPage.logoutCurrentFemaleAccount();
    }

    public void clickFilterByUsername() {
        mektoubeCommonPage.clickFilterByUsername();
    }

    public void insertUsernameOfWomanAccountToSearchUsernameFilter() {
        mektoubeCommonPage.insertUsernameOfWomanAccountToSearchUsernameFilter();
    }


    public void browserShouldRedirectToUrlContain(String url) {
        assertThat(mektoubeCommonPage.browserShouldRedirectToUrlContain(url), is(equalTo(true)));
    }

    public void onlyOneRadioButtonIsClicked() {
        assertThat(mektoubeCommonPage.onlyOneRadioButtonIsClicked(), is(equalTo(true)));
    }

    public void scrollToWhichIndexIsAndClick(String button, int number) {
        mektoubeCommonPage.scrollToWhichIndexIsAndClick(button, number);
    }

    public void getProfileNameFrom(String fieldName) {
        mektoubeCommonPage.getProfileNameFrom(fieldName);
    }

    public void scrollToAndClick(String button) {
        mektoubeCommonPage.scrollToAndClick(button);
    }

    public void cleareLocalStorage() {
        mektoubeCommonPage.cleareLocalStorage();
    }

    public void scroll() throws AWTException {
        mektoubeCommonPage.scroll();
    }

    public void shouldSeeMessagePopupAtTopOr(String mess1, String mess2) {
        assertThat(mektoubeCommonPage.shouldSeeMessagePopupAtTopOr(mess1, mess2), is(equalTo(true)));
    }

    public void scrollToElementThatHasTextAndClick(String button) {
        mektoubeCommonPage.scrollToElementThatHasTextAndClick(button);
    }

    public void clearTextFromField(String button) {
        mektoubeCommonPage.clearTextFromField(button);
    }

    public void refreshCurentPage() {
        mektoubeCommonPage.refreshCurentPage();
    }

    public void shouldSeeMessagePopup(String mess) {
        ArrayList<String> mess1 = homePageAndLoginPage.getErrorMessages();
        assertThat(mess1, hasItem(containsString(mess)));
    }

    public void scrollAllPage() {
        mektoubeCommonPage.scrollAllPage();
    }

    public void clickOnTheElementIsByXpath(String element) {
        mektoubeCommonPage.clickOnTheElementIsByXpath(element);
    }

    public void refreshPage() {
        mektoubeCommonPage.refreshPage();
    }

    public void thePageShowErrorMessageIs(String errorMess) {
        mektoubeCommonPage.thePageShowErrorMessageIs(errorMess);
    }

    public void openNewTab() throws AWTException {
        mektoubeCommonPage.openNewTab();
    }
}
