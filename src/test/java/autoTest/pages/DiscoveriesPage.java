package autoTest.pages;

import autoTest.service.TestDataService;
import cucumber.api.java.bs.A;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.beans.Introspector;
import java.util.ArrayList;

import net.thucydides.core.pages.PageObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class DiscoveriesPage extends PageObject {
    MektoubeCommonPage commonPage = new MektoubeCommonPage();
    MyProfileModule profileModule = new MyProfileModule();
    NotificationPage noti = new NotificationPage();

    public boolean cannotSeeLetterButton() {
        ArrayList<WebElement> letterButton = new ArrayList<>(getDriver().findElements(By.cssSelector("button[class='mdc-button mdc-button--unelevated mdc-btn--pink']")));
        if (letterButton.size() > 0) {
            System.out.println(letterButton.size());
            return false;
        } else {
            System.out.println(letterButton.size());
            return true;
        }
    }

    public boolean cannotSeeSmileButton() {
        ArrayList<WebElement> smileButton = new ArrayList<>(getDriver().findElements(By.cssSelector(".user__head button[class='mdc-button mdc-button--outline mdc-button--unelevated']")));
        if (smileButton.size() > 0) {
            System.out.println(smileButton.size() + "fail huhu");
            return false;
        } else {
            System.out.println(smileButton.size() + "pass hehe");
            return true;
        }
    }

    public boolean cannotSeeDiscussButton() {
        ArrayList<WebElement> DiscussButton = new ArrayList<>(getDriver().findElements(By.cssSelector(".user__head button[class='mdc-button mdc-button--unelevated']")));
        if (DiscussButton.size() > 0) {
            System.out.println(DiscussButton.size() + "fail huhu");
            return false;
        } else {
            System.out.println(DiscussButton.size() + "pass hehe");
            return true;
        }
    }

    public boolean cannotSeeAdviceToDiscussButton() {
        ArrayList<WebElement> AdviceToDiscussButton = new ArrayList<>(getDriver().findElements(By.cssSelector("button[class='mdc-button mdc-button--unelevated mdc-btn--pink full-wrap']")));
        if (AdviceToDiscussButton.size() > 0) {
            System.out.println(AdviceToDiscussButton.size() + "fail huhu");
            return false;
        } else {
            System.out.println(AdviceToDiscussButton.size() + "pass hehe");
            return true;
        }
    }

    public boolean shouldSeeInMyProfileInformation(String pratiquant) {
        WebElement Pratiquant = getDriver().findElement(By.cssSelector("div.col.col--size-1 ul li:nth-child(9) strong"));
        String ContentOfPratiquant = Pratiquant.getText();
        System.out.println(ContentOfPratiquant + " " + "hihi");
        if (ContentOfPratiquant.contentEquals(pratiquant)) {
            return true;
        }
        return false;
    }

    public boolean shouldSeeInMyResearch(String pratiquant) {
        WebElement Pratiquant = getDriver().findElement(By.cssSelector("section.section.section--profile div div:nth-child(3) div.section__group-body ul li:nth-child(4) strong"));
        String ContentOfPratiquant = Pratiquant.getText();
        System.out.println(ContentOfPratiquant + " " + "hehe");
        if (ContentOfPratiquant.contentEquals(pratiquant)) {
            return true;
        }
        return false;
    }



    public void uploadAvatarFromComputer() throws AWTException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[class='material-icons']")));
        fileInput.click();

        try {
            Thread.sleep(3 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String text = System.getProperty("user.dir") + "\\src\\test\\resources\\data_test\\testPicture4.jpg";
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("already upload photo");
    }

    public boolean shouldNotShowThisBlockedAccount() {
        ArrayList<WebElement> profileList = new ArrayList<>(getDriver().findElements(By.cssSelector(".profile")));
        if (profileList.size() > 0) {
            ArrayList<WebElement> profileContent = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='profile__content'] h5")));

            ArrayList<String> profileContentElement = new ArrayList<>();
            for (WebElement displayItem : profileContent) {
                profileContentElement.add(displayItem.getText());

                String abc = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('accountName')");

                for (String item : profileContentElement) {
                    if (item.contentEquals(abc)) {
                        System.out.println(item + " " + "fail" + abc);
                        return false;
                    }
                    System.out.println(item + " " + "hihi ok don't show blocked account: " + abc);
                }
            }
        } else {
            ArrayList<WebElement> searchIcon = new ArrayList<>(getDriver().findElements(By.cssSelector("i[class='material-icons right-icon']")));
            if (searchIcon.size() == 0) {
                System.out.println(searchIcon + "fail");
                return false;
            }
            System.out.println(searchIcon + " " + "pass");
            WebElement textOfNotify = getDriver().findElement(By.cssSelector("div[class='no-items__inner'] h4"));
            String textOfNotifyElement = textOfNotify.getText();
            if (!textOfNotifyElement.contentEquals("Aucun resultat trouvé pour votre recherche.")) {
                System.out.println(textOfNotifyElement + "fail");
                return false;
            }
            System.out.println(textOfNotify + " " + "pass");
        }

        return true;
    }

    public boolean shouldSeeButtonSmileDiscussOrDestinyAgain() {
        ArrayList<WebElement> letterButton = new ArrayList<>(getDriver().findElements(By.cssSelector("button[class='mdc-button mdc-button--unelevated mdc-btn--pink']")));
        ArrayList<WebElement> DiscussButton = new ArrayList<>(getDriver().findElements(By.cssSelector(".user__head button[class='mdc-button mdc-button--unelevated']")));
        ArrayList<WebElement> smileButton = new ArrayList<>(getDriver().findElements(By.cssSelector(".user__head button[class='mdc-button mdc-button--outline mdc-button--unelevated']")));
        if (smileButton.size() == 0) {
            System.out.println(smileButton + "smile button not show");
            return false;
        }
        if (letterButton.size() > 0 && DiscussButton.size() > 0) {
            System.out.println(smileButton.size() + "show both letter button: " + letterButton.size() + "and discuss button " + DiscussButton.size());
            return false;
        }
        System.out.println("smile button: " + smileButton.size() + "destiny button: " + letterButton.size() + "discuss button: " + DiscussButton.size());

        return true;
    }

    public boolean shouldSeeButtonSmileDiscussOrDestinyAgainInMaleProfile() {
        ArrayList<WebElement> DiscussButton = new ArrayList<>(getDriver().findElements(By.cssSelector("button[class='mdc-button mdc-button--unelevated']")));
        ArrayList<WebElement> smileButton = new ArrayList<>(getDriver().findElements(By.cssSelector("button[class='mdc-button mdc-button--outline mdc-button--unelevated']")));
        ArrayList<WebElement> AdviceToDiscussButton = new ArrayList<>(getDriver().findElements(By.cssSelector("button[class='mdc-button mdc-button--unelevated mdc-btn--pink full-wrap']")));
        if (AdviceToDiscussButton.size() > 0 && DiscussButton.size() == 0 && smileButton.size() == 0) {
            System.out.println("only destiny button appear" + DiscussButton + " " + smileButton + " " + AdviceToDiscussButton);
            return true;
        }
        if (AdviceToDiscussButton.size() == 0 && DiscussButton.size() > 0 && smileButton.size() > 0) {
            System.out.println("only 2 buttons appear: discussion" + DiscussButton + " smile button: " + smileButton + "Advice To be destiny not show " + AdviceToDiscussButton);
            return true;
        }
        if (AdviceToDiscussButton.size() > 0 && DiscussButton.size() == 0 && smileButton.size() > 0) {
            System.out.println("only 2 buttons appear: destiny" + AdviceToDiscussButton + " smile button: " + smileButton + "discussion not show " + DiscussButton);
            return true;
        }

        System.out.println("shows all 3 button" + DiscussButton + " " + smileButton + " " + AdviceToDiscussButton);
        return false;
    }

    public void clickOnWhichIndexIsContainAvatar(String fieldName, int number) {
        String cssSelector = TestDataService.properties.getProperty(fieldName);
        if (cssSelector == null) {
            cssSelector = fieldName;
        }
        ArrayList<WebElement> settingList = new ArrayList<>(getDriver().findElements(By.cssSelector(cssSelector)));
        settingList.get(number).click();
    }

    public boolean avatarPictureIsPopup() {
        ArrayList<WebElement> popupAvatar = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='pictures-gallery modal is--opened']")));
        if (popupAvatar.size() > 0) {
            System.out.println("pass " + popupAvatar);
            return true;
        }
        System.out.println("fail " + popupAvatar);
        return false;
    }

    public boolean checkIfPopupAvatarIsClosed() {
        ArrayList<WebElement> popupAvatarClosed = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='pictures-gallery modal is--opened']")));
        if (popupAvatarClosed.size() > 0) {
            System.out.println("fail " + popupAvatarClosed);
            return false;
        }
        System.out.println("pass " + popupAvatarClosed);
        return true;
    }

    public boolean wiewTwentyProfileAndProfileNamesIsSortedCorrectly() {
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText = accountName.getText();
        System.out.println(accountNameText);
        WebElement nextNarrow = getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']"));
        nextNarrow.click();
        System.out.println(nextNarrow);
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName1 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText1 = accountName1.getText();
        System.out.println(accountNameText1);
        getDriver().findElement(By.cssSelector("#main-wrapper > div.content.content-profile > div.profiles-control-navs > a.control-button.next-nav")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName2 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText2 = accountName2.getText();
        System.out.println(accountNameText2);
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName3 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText3 = accountName3.getText();

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName4 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText4 = accountName4.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName5 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText5 = accountName5.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName6 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText6 = accountName6.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName7 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText7 = accountName7.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName8 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText8 = accountName8.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName9 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText9 = accountName9.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName10 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText10 = accountName10.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName11 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText11 = accountName11.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName12 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText12 = accountName12.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName13 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText13 = accountName13.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName14 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText14 = accountName14.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName15 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText15 = accountName15.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName16 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText16 = accountName16.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName17 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText17 = accountName17.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName18 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText18 = accountName18.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountName19 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameText19 = accountName19.getText();
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button next-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement backNarrow = getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']"));
        backNarrow.click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText = accountNameBack.getText();
        if (!accountNameText19.contentEquals(accountNameBackText)) {
            System.out.println(accountNameText19 + accountNameBackText);
            return false;
        }
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack1 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText1 = accountNameBack1.getText();
        if (!accountNameText18.contentEquals(accountNameBackText1)) {
            System.out.println(accountNameText18 + accountNameBackText1);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack2 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText2 = accountNameBack2.getText();
        if (!accountNameText17.contentEquals(accountNameBackText2)) {
            System.out.println(accountNameText17 + accountNameBackText2);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack3 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText3 = accountNameBack3.getText();
        if (!accountNameText16.contentEquals(accountNameBackText3)) {
            System.out.println(accountNameText16 + accountNameBackText3);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack4 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText4 = accountNameBack4.getText();
        if (!accountNameText15.contentEquals(accountNameBackText4)) {
            System.out.println(accountNameText15 + accountNameBackText4);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack5 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText5 = accountNameBack5.getText();
        if (!accountNameText14.contentEquals(accountNameBackText5)) {
            System.out.println(accountNameText14 + accountNameBackText5);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack6 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText6 = accountNameBack6.getText();
        if (!accountNameText13.contentEquals(accountNameBackText6)) {
            System.out.println(accountNameText13 + accountNameBackText6);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack7 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText7 = accountNameBack7.getText();
        if (!accountNameText12.contentEquals(accountNameBackText7)) {
            System.out.println(accountNameText12 + accountNameBackText7);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack8 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText8 = accountNameBack8.getText();
        if (!accountNameText11.contentEquals(accountNameBackText8)) {
            System.out.println(accountNameText11 + accountNameBackText8);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack9 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText9 = accountNameBack9.getText();
        if (!accountNameText10.contentEquals(accountNameBackText9)) {
            System.out.println(accountNameText10 + accountNameBackText9);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack10 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText10 = accountNameBack10.getText();
        if (!accountNameText9.contentEquals(accountNameBackText10)) {
            System.out.println(accountNameText9 + accountNameBackText10);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack11 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText11 = accountNameBack11.getText();
        if (!accountNameText8.contentEquals(accountNameBackText11)) {
            System.out.println(accountNameText8 + accountNameBackText11);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack12 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText12 = accountNameBack12.getText();
        if (!accountNameText7.contentEquals(accountNameBackText12)) {
            System.out.println(accountNameText7 + accountNameBackText12);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack13 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText13 = accountNameBack13.getText();
        if (!accountNameText6.contentEquals(accountNameBackText13)) {
            System.out.println(accountNameText6 + accountNameBackText13);
            return false;
        }
        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack14 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText14 = accountNameBack14.getText();
        if (!accountNameText5.contentEquals(accountNameBackText14)) {
            System.out.println(accountNameText5 + accountNameBackText14);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack15 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText15 = accountNameBack15.getText();
        if (!accountNameText4.contentEquals(accountNameBackText15)) {
            System.out.println(accountNameText4 + accountNameBackText15);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack16 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText16 = accountNameBack16.getText();
        if (!accountNameText3.contentEquals(accountNameBackText16)) {
            System.out.println(accountNameText3 + accountNameBackText16);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack17 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText17 = accountNameBack17.getText();
        if (!accountNameText2.contentEquals(accountNameBackText17)) {
            System.out.println(accountNameText2 + accountNameBackText17);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack18 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText18 = accountNameBack18.getText();
        if (!accountNameText1.contentEquals(accountNameBackText18)) {
            System.out.println(accountNameText1 + accountNameBackText18);
            return false;
        }

        getDriver().findElement(By.cssSelector("div[class='profiles-control-navs'] a[class='control-button prev-nav']")).click();
        commonPage.waitUntilElementIsVisible("div[class='user__meta'] h1");
        WebElement accountNameBack19 = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountNameBackText19 = accountNameBack19.getText();
        if (!accountNameText.contentEquals(accountNameBackText19)) {
            System.out.println(accountNameText + accountNameBackText19);
            return false;
        }

        System.out.println(accountNameText19 + " " + accountNameBackText + " pass");
        System.out.println(accountNameText18 + " " + accountNameBackText1 + " pass2");
        System.out.println(accountNameText1 + " " + accountNameBackText18 + " pass3");
        System.out.println(accountNameText + " " + accountNameBackText19 + " pass4");
        return true;
    }

    public boolean checkIfContentInModalShowFull() {
        String headerTitle1 = getDriver().findElement(By.cssSelector(".modal--header__title h2")).getText();

        String headerTitle2 = getDriver().findElement(By.cssSelector(".modal--header__title p")).getText();

        String textBuyStep1 = getDriver().findElement(By.cssSelector(".modal--body form.form.form--check-allopass-smscode  p.buy-step:nth-child(1)")).getText();

        String textBuySyntax1 = getDriver().findElement(By.cssSelector(".modal--body form.form.form--check-allopass-smscode  p.buy-syntax:nth-child(2) span")).getText();

        String textBuyStep2 = getDriver().findElement(By.cssSelector(".modal--body form.form.form--check-allopass-smscode  p.buy-step:nth-child(3)")).getText();

        String cancelButton = getDriver().findElement(By.cssSelector(".form--actions.text-center .mdc-button.mdc-button--outline.mdc-button--unelevated")).getText();

        String confirmPaymentBtn = getDriver().findElement(By.cssSelector(".form--actions.text-center .mdc-button.mdc-button--unelevated:nth-child(2)")).getText();

        String note = getDriver().findElement(By.cssSelector(".allopass-legal span")).getText();


        if (headerTitle1.contentEquals("Augmentez vos visites !") && headerTitle2.contentEquals("Votre profil plus visible et en tête de liste pendant 24h*")
                && textBuyStep1.contentEquals("1. Obenez votre code par SMS") && textBuySyntax1.contentEquals("Envoyer MEK au 81015") && textBuyStep2.contentEquals("2. Entrer votre code d’accès")
                && cancelButton.contentEquals("ANNULER") && confirmPaymentBtn.contentEquals("VALIDER VOTRE CODE") && note.contentEquals("3.00 €/SMS + prix d'un SMS 1 envoi de SMS par code d'accès")) {
            return true;
        }
        System.out.println(headerTitle1);
        System.out.println(headerTitle2);
        System.out.println(textBuyStep1);
        System.out.println(textBuySyntax1);
        System.out.println(textBuyStep2);
        System.out.println(cancelButton);
        System.out.println(confirmPaymentBtn);
        System.out.println(note);

        return false;
    }

    public boolean checkIfContentInAdvertisement() {
        ArrayList<WebElement> Advertisement = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles li.profile--item.fake-profile-boost")));
        if (Advertisement.size() == 0) {
            System.out.println(" this account don't have Advertisement booster or already use it");
            return false;
        } else {
            String title1 = getDriver().findElement(By.cssSelector("ul.list-profiles li.profile--item.fake-profile-boost .fake-content h3")).getText();
            String title2 = getDriver().findElement(By.cssSelector("ul.list-profiles li.profile--item.fake-profile-boost .fake-content p")).getText();
            String textInButton = getDriver().findElement(By.cssSelector("ul.list-profiles li.profile--item.fake-profile-boost .fake-content button")).getText();
            if (!title1.contentEquals("Augmentez vos visites !")) {
                System.out.println(title1);

                return false;

            }
            if (!title2.contentEquals("Boostez votre profil.\n" +
                    "Soyez en tête de liste !")) {

                System.out.println(title2);

                return false;
            }
            if (!textInButton.contentEquals("Cliquez ici !")) {

                System.out.println(textInButton);

                return false;
            }
            System.out.println(title1);
            System.out.println(title2);
            System.out.println(textInButton);

        }
        return true;
    }

    public void clickConfirmWithoutInputCode() {
        getDriver().findElement(By.cssSelector(".form--actions.text-center button[class='mdc-button mdc-button--unelevated']")).click();
    }

    public boolean shouldSeeRedAlert(String alert) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.simple-error")));
        String popupErrorMsgElementText = popupErrorMsgElements.getText();
        if (popupErrorMsgElementText.contentEquals(alert)) {
            System.out.println(popupErrorMsgElementText);
            return true;
        }
        System.out.println(popupErrorMsgElementText);
        return false;
    }

    public boolean alloPassModalIsClosed() {
        ArrayList<WebElement> settingModal = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='setting--modal check-allopass-modal mobile-nofull modal is--opened']")));
        if (settingModal.size() > 0) {
            System.out.println(settingModal);
            return false;
        }
        System.out.println(settingModal);
        return true;
    }

    public void selectTheProfileHasNameThatWeAreSearching(String name) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
//        ArrayList<WebElement> profile = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".profile"))));
//        for (int i = 0; i < profile.size(); i++) {
//            String userName = profile.get(i).findElement(By.cssSelector(".profile__content h5")).getText();
//            if (userName.contentEquals(name)) {
//                profile.get(i).click();
//                break;
//            }
//        }
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + name + "']")));
        //div[@class='profile__content']//*[text()='shera']
        account.click();
    }

    public void selectBlockThisPerson() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        commonPage.waitUntilElementIsVisible("DropDownOption");
        commonPage.click("DropDownOption");
        ArrayList<WebElement> dropDownList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a[class='mdc-list-item__text']"))));
        dropDownList.get(1).click();
    }

    public boolean shouldSeeBlockAccount() {
        commonPage.waitUntilElementIsVisible("div[class='user-info'] h3");
        WebElement profileContent = getDriver().findElement(By.cssSelector("div[class='user-info'] h3"));
        String profileContent1 = profileContent.getText();

        String abc = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('accountName')");

        if (profileContent1.contentEquals(Introspector.decapitalize(abc))) {
            System.out.println("this function is correct" + " " + profileContent1 + " " + Introspector.decapitalize(abc));
            return true;
        } else {
            System.out.println("fail hehe" + " " + profileContent1 + " haha hihi" + " " + abc);
            return false;
        }
    }

    public void getProfileName() {
        commonPage.waitUntilElementIsVisible(".user__head .user__meta h1");
        WebElement accountName = getDriver().findElement(By.cssSelector("div[class='user__meta'] h1"));
        String accountName1 = accountName.getText();

        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('accountName','" + accountName1 + "')");

    }

    public void clickOnBlackliste() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement blackListe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-settings']//*[contains(text(),'Blackliste')]")));
        blackListe.click();
    }

    public boolean shouldSeeCompleteProfile() {
        commonPage.waitUntilElementIsVisible("div[class='section__group']");
        String[] profileItemList = {
                "Sur mektoube pour",
                "Habite à",
                "Situation familiale",
                "A des enfants",
                "Veut des enfants",
                "Origine",
                "Silhouette",
                "Style",
                "Pratiquante",
                "Tabac",
                "Cheveux",
                "Yeux",
                "Habitudes Alimentaires",
                "Langues",
                "Domicile",
                "Caractères",
                "Activités Sportives",
                "Sports pratiqués",
                "Niveau d'études",
                "Secteur d'activité",
                "Signe Astrologique",
                "Âge",
                "Localisation",
                "Origine",
                "Pratiquant",
                "Situation familiale",
                "Silhouette",
                "A des enfants",
                "Veut des enfants",
                "Taille",
                "Cheveux",
                "Yeux",
                "Caractère",
                "Loisirs à partager",
                "Style",
                "Niveau d'études",
                "Secteur d'activité",
                "Tabac"
        };
        ArrayList<WebElement> profileDisplayItemList = new ArrayList<>(getDriver().findElements(By.cssSelector(".list-text li strong")));
        ArrayList<String> profileDisplayItemTextList = new ArrayList<>();
        for (WebElement displayItem : profileDisplayItemList) {
            profileDisplayItemTextList.add(displayItem.getText().replace(" :", ""));
        }
        for (String item : profileItemList) {
            if (!profileDisplayItemTextList.contains(item)) {
                System.out.println(profileDisplayItemTextList);
                return false;
            }
        }
        System.out.println(profileDisplayItemTextList);
        return true;
    }

    public boolean checkTheConnectionStatus() {
        ArrayList<WebElement> status = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='status status--online']")));
        WebElement profileStatus = getDriver().findElement(By.cssSelector("div.user__meta > p:nth-child(3)"));
        String profileStatus1 = profileStatus.getText();
        if (status.size() > 0 && profileStatus1.contentEquals("En ligne")) {
            System.out.println("this account has status" + " " + profileStatus1);
            return true;
        } else {
            status = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='status status--away']")));
            profileStatus = getDriver().findElement(By.cssSelector("div.user__meta > p:nth-child(3)"));
            String profileStatus2 = profileStatus.getText();
            if ((status.size() > 0 && profileStatus2.contentEquals("Vient de se déconnecter"))) {
                System.out.println("this account has status" + " " + profileStatus2);
                return true;
            } else {
                profileStatus = getDriver().findElement(By.cssSelector("div.user__meta > p:nth-child(3)"));
                String profileStatus3 = profileStatus.getText();
                if ((profileStatus3.contains("Dernière connexion: "))) {
                    System.out.println("this account has status" + " " + profileStatus3);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean canSeeFavoriteAccountInProfile() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //div[@class='profile__content']//*[text()='Emna98']")));
        account.click();

        WebElement accountName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='user__meta'] h1")));
        String accountName1 = accountName.getText();

        getDriver().findElement(By.cssSelector("button[class='mdc-icon-button material-icons']")).click();
        ArrayList<WebElement> dropDownList = new ArrayList<>(getDriver().findElements(By.cssSelector("a[class='mdc-list-item__text']")));
        dropDownList.get(0).click();
        try {
            Thread.sleep(5 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        commonPage.click("div[class='header__aside hidden-xs']");
        commonPage.click("a[href='/main/my-account/favorite']");


        WebElement profileContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='profile__content'] h5")));
        String profileContent1 = profileContent.getText();

        if (profileContent1.contentEquals(accountName1)) {
            //if (profileContent1.contentEquals(Introspector.decapitalize(accountName1))) {
            System.out.println("this function is correct" + " " + profileContent1 + " " + Introspector.decapitalize(accountName1));
            return true;
        } else {
            System.out.println(profileContent1 + " " + accountName1);
            return false;
        }

    }

    public void selectReportAbuseButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        commonPage.waitUntilElementIsVisible("DropDownOption");
        commonPage.click("DropDownOption");
        ArrayList<WebElement> dropDownList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a[class='mdc-list-item__text']"))));
        dropDownList.get(2).click();
    }

    public void chooseAProfileSimilarThatContainAvatar() {
        ArrayList<WebElement> SimilarProfileList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='owl-stage'] div[class='profile__avatar']")));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", SimilarProfileList.get(0));
        ArrayList<WebElement> profileAvaList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='owl-item active'] div[class='slider__slide'] span[class='avatar avatar-box-backgrounded']")));
        while (profileAvaList.size() == 0) {
            if (getDriver().findElements(By.cssSelector("div[class='owl-next disabled']")).size() > 0) {
                break;
            } else {
                getDriver().findElement(By.cssSelector("div[class='owl-nav'] div[class='owl-next']")).click();
            }
            profileAvaList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='owl-item active'] div[class='slider__slide'] span[class='avatar avatar-box-backgrounded']")));
        }
        if (profileAvaList.size() > 0) {
            profileAvaList.get(0).click();
        } else {
            System.out.println("there is no Profile that contain avatar");
        }
    }

    public void chooseASimilarProfile() {
        ArrayList<WebElement> SimilarProfileList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='owl-stage'] div[class='profile__avatar']")));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", SimilarProfileList.get(0));
        ArrayList<WebElement> profileSimilarList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='profile  ']")));
        profileSimilarList.get(0).click();

    }

    public void searchAccount(String userName) {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.waitUntilElementIsVisible("div[class='modal__main_footer inside-header']");
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.waitAboutSecond(1);
        commonPage.insertIntoField(userName, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        commonPage.waitUntilElementIsVisible(".profile");

    }

    public void reportAndBlockAProfile() {
        selectReportAbuseButton();
        commonPage.waitUntilElementIsVisible("ReportModal");
        commonPage.clickOnRadionButtonThatHasText("Injure");
        commonPage.click("button[class='mdc-button mdc-button--unelevated full-wrap-width']");
        commonPage.waitUntilElementIsVisible("textarea[placeholder='Merci de donner des précisions sur le signalement']");
        commonPage.insertIntoField("this is test report message", "textarea[placeholder='Merci de donner des précisions sur le signalement']");
        commonPage.click("button[class='mdc-button mdc-button--unelevated full-wrap-width']");
    }

    public void shouldSeeBlockedAccountInBlacklistAndRemoveIt() {
        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("settingBtn");
        commonPage.click("settingBtn");
        commonPage.waitUntilElementIsVisible(".list-settings");
        commonPage.scrollToElementThatHasTextAndClick("Blackliste");
        commonPage.waitUntilElementIsVisible("div[class='setting--modal blocklist-modal modal is--opened'] .blocklist-item");
        shouldSeeBlockAccount();
        profileModule.removeAccountFromBlackList();
    }

    public void deleteBlockedAccountFromBlacklist() {
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("settingBtn");
        commonPage.click("settingBtn");
        commonPage.waitUntilElementIsVisible(".list-settings");
        commonPage.scrollToElementThatHasTextAndClick("Blackliste");
        commonPage.waitUntilElementIsVisible("div[class='setting--modal blocklist-modal modal is--opened'] .blocklist-item");
        profileModule.removeAccountFromBlackList();
    }

    public void canViewTwentyCompleteProfile() {
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToNextProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']"); //Make sure all profile show the distance between two profiles
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToNextProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToNextProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToNextProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToNextProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToNextProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToNextProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToNextProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToNextProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToNextProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToPreviousProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToPreviousProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToPreviousProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToPreviousProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToPreviousProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToPreviousProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToPreviousProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToPreviousProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToPreviousProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");
        commonPage.waitUntilElementIsVisible("narrowToNextProfile");
        commonPage.click("narrowToPreviousProfile");
        shouldSeeCompleteProfile();
        commonPage.waitUntilElementIsVisible("div[class='user__distance']");

    }

    public void uploadAvatarFromComputerToUnderApprovalProcess(String picture) throws AWTException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[class='material-icons']")));
        fileInput.click();


        try {
            Thread.sleep(3 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String text = System.getProperty("user.dir") + "\\src\\test\\resources\\data_test\\" + picture;
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("already upload photo");
    }

    public void thePopupShowErrorMessageLine(){
        assertEquals("Le nom est requis.", getDriver().findElement(By.cssSelector("p.error")).getText());
    }

    public void thePageShowUsersThatHaveOnline(){
        int count=0;
        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector(".profile__avatar > .profile__status")));

        for(WebElement user: userList){
            try {
                if (user.findElement(By.cssSelector(".status")).isEnabled()) {
                    System.out.println(" passed");
                    count+=1;
                }
            }catch(Exception e){
//                if(user.findElement(By.cssSelector(".status.status--away")).isEnabled()){
//                    System.out.println(" passed away");
//                }else{
                System.out.println("error");
                System.out.println("count=="+count);
                assertEquals("error","error1");
                //}
            }
        }
    }

    public void theLabelDontShow(String silhouette, String silhouetteText){
        String cssSelector = TestDataService.properties.getProperty(silhouetteText);
        try{
            getDriver().findElement(By.cssSelector(cssSelector)).isDisplayed();
            System.out.println("faild");
            assertEquals("error","error when show "+silhouette+" in"+silhouette+"label");
        }catch (Exception e){
            System.out.println("passed, "+silhouette+" label dont show "+silhouette);
        }
    }

    public void theAgeLabelDontShowAgeRange(){
        try{
            assertEquals("",getDriver().findElement(By.cssSelector("div.filter > div:nth-child(1) > div.filter__item-aside > span")).getText());
            //getDriver().findElement(By.cssSelector("div.filter > div.filter__item:nth-child(1) > div.filter__item-aside > span")).isDisplayed();
            //System.out.println("faild");
            //assertEquals("error","error when show age range in age label");
        }catch (SerenityManagedException ex){
            //the age label show default age; 18_99
            assertEquals("18 - 99",getDriver().findElement(By.cssSelector("div.filter > div:nth-child(1) > div.filter__item-aside > span")).getText());
        }
        catch (Exception e){
            System.out.println("passed, age label dont show age range");
        }
        //assertFalse(getDriver().findElement(By.cssSelector("div.filter > div.filter__item:nth-child(1) > div.filter__item-aside > span")).isDisplayed());
    }
    public void theFilterIsReseted(){
        //check all filter is empty or is not stick
        //all radios
        ArrayList<WebElement> radioList = new ArrayList<>(getDriver().findElements(By.cssSelector("input[type='radio']")));
        for(WebElement radio: radioList){
            if(! radio.isSelected()){
                System.out.println("pass");
            }else{
                System.out.println("faild");
                assertEquals("none check","checked");
            }
        }
    }

    public void theSizeLabelDontShowSize(){
        try{
            getDriver().findElement(By.cssSelector("div.filter > div.filter__item:nth-child(5) > div.filter__item-aside > span")).isDisplayed();
            System.out.println("faild");
            assertEquals("error","error when show country in country label");
        }catch (Exception e){
            System.out.println("passed, size label dont show size");
        }
    }

    public void theCountryLabelDontShowCountry(){
        try{
//            getDriver().findElement(By.cssSelector("div.filter > div.filter__item:nth-child(4) > div.filter__item-aside > span")).isDisplayed();
//            System.out.println("faild");
            assertEquals("",getDriver().findElement(By.cssSelector("div.filter > div.filter__item:nth-child(4) > div.filter__item-aside > span")).getText());
        }catch (Exception e){
            System.out.println("error when show country in country label");
        }
    }

    public void theOriginLabelDontShowOrigin(){
        try{
//            getDriver().findElement(By.cssSelector("div.filter > div.filter__item:nth-child(4) > div.filter__item-aside > span")).isDisplayed();
//            System.out.println("faild");
            assertEquals("",getDriver().findElement(By.cssSelector("div.filter > div.filter__item:nth-child(3) > div.filter__item-aside > span")).getText());
        }catch (Exception e){
            System.out.println("faild");
            System.out.println("error when show origin in origin label");
        }
    }

    public void clickOnSpecialElementIs(String value) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("click value= " + value);
        String selected = "";
        try {
            if(value.equals("more_vert")) {
                selected = getDriver().findElement(By.cssSelector("div.blocklist-list > div.blocklist-item:nth-child(1) > div.left-info > div.user-info > h3")).getText();
                System.out.println("name just unblock: " + selected);
            }else if(value.equals("firstMoreVert")){
                selected = getDriver().findElement(By.cssSelector("div.hidden-xs.list-search-wrap > div.filter__item:nth-child(1) > div.filter__item-content > h5")).getText();
                System.out.println("first element in search save list ="+selected);
            }else if(value.equals("firstGif")){
                selected = getDriver().findElement(By.cssSelector("div#gifSlider > label:nth-child(1) > div > img")).getAttribute("src");
                System.out.println("Selected: " + selected);
            }else if(value.equals("firstRequestName")){
                //name of profile that response later
                selected = getDriver().findElement(By.cssSelector("div.infinite-scroll-component > div.request:nth-child(1) > div.request__head > h5")).getText();
                System.out.println("first request name: "+selected);
            }else if(value.equals("AcceptInLast5Refusals")){
                selected = getDriver().findElement(By.cssSelector("div.modal--body > .request:nth-child(1) > div.request__head > h5")).getText();
                System.out.println("first name in 5 last refusals: "+selected);
            }else if(value.equals("firstDeleteInConversation")) {
                //get name of first discussion
                selected=getDriver().findElement(By.cssSelector("div[style='position: relative;'] > div:nth-child(1) > div.message__content > div.message__head > h5")).getText();
                System.out.println("first name in message: "+selected);
            }
            else {
                selected = getDriver().findElement(By.cssSelector("div.infinite-scroll-component  > div.request:nth-child(1) > div.request__head > h5")).getText();
                System.out.println("Select name: " + selected);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        //export this value to the file
        noti.WriteToFile(selected);

        String cssSelector = TestDataService.properties.getProperty(value);
        if (cssSelector == null) {
            cssSelector = value;
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.cssSelector(cssSelector)));
        element.click();
    }

    public void thePageShowNotificationEditedFilter(){
        String noti = getDriver().findElement(By.cssSelector("div.container-fluid > div[class='top-message-overlay success'] > div.top-message-text > div")).getText();
        System.out.println("noti "+noti);
        assertEquals("Filtre édité", noti);
    }

    public void checkingInSaveListHaveEditedName(String name){
        ArrayList<WebElement> searchList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.filter__item > div.filter__item-content > h5")));
        for(WebElement ele: searchList){
            if(ele.equals(name)) {
                System.out.println("passed");
                return;
            }
        }
    }

    public void thePageShowAllProfileHaveBirthdayToday(){
        ArrayList<WebElement> userHaveBirthdayTodayList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li > div.profile   > div.profile__avatar")));
        for(WebElement prof: userHaveBirthdayTodayList){
            prof.click();
            String alertText = getDriver().findElement(By.cssSelector("div.alert__text")).getText();
            assertEquals("C'est son anniversaire aujourd'hui!Souhaite-lui un Joyeux Anniversaire",alertText);
        }
    }

    public void thePageShowAllProfileThatHaveAgeRangeFromTo(int num1, int num2){
        ArrayList<WebElement> searchList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li > a > div.profile__content > p:nth-child(2)")));
        for(WebElement prof: searchList){
            System.out.println("before change real age "+prof.getText());

            //split space " " and list.get(0)
            String[] tempList = prof.getText().split(" ");
            int realAge = Integer.parseInt(tempList[0]);
            System.out.println("real age is "+realAge);
            if(realAge>= num1&&realAge<=num2){
                System.out.println("check age is passed");
                continue;
            }
            assertEquals("error","error  check age range");
        }
    }

    public void thePageShowAllProfilesThatHavePictureProfile(){
        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector(".profile__avatar")));
        for(WebElement prof: userList){
            assertEquals("avatar avatar-box-backgrounded", prof.findElement(By.cssSelector("span")).getAttribute("class"));
        }
    }

    public void thePageOnlyOneChoiceCanBeSelected(){
        //second radio will be selected, first radio is not selected
        assertFalse(getDriver().findElement(By.cssSelector("div[role='radiogroup'] > label:nth-child(1) > span > span > input")).isSelected());
        assertTrue(getDriver().findElement(By.cssSelector("div[role='radiogroup'] > label:nth-child(2) > span > span > input")).isSelected());
    }

    public void thePageShowAllProfileThatHaveAboveEnteredName(){
        //save all name
        ArrayList<WebElement> userNameList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li > a > div.profile__content > h5")));
        for(WebElement user: userNameList){
            assertTrue(user.getText().contains("woman"));
        }
    }

    public void thePopupShowsRedErrorMessage(){
        String errorMessage = getDriver().findElement(By.cssSelector("div.modal__main_footer > p")).getText();
        assertEquals("Le Pseudo ne peut pas être vide",errorMessage);
    }

    public void theCoutryLabelShowCountryText(){
        assertEquals("Italie",getDriver().findElement(By.cssSelector("div.filter > div.filter__item:nth-child(4) > div.filter__item-aside > span")).getText());
    }

    public void thePageShowNameInSearchListIs(String nameSearch){
        int count=0;
        ArrayList<WebElement> searchList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.hidden-xs.list-search-wrap > div div.filter__item-content> h5")));
        for(WebElement search: searchList){
            if(search.getText().equals(nameSearch)){
                System.out.println("passed");
                count=1;
                break;
            }
        }
        assertEquals(1,count);
    }

    public void thePageShowAllProfileThatHaveAboveCountry() throws IOException, ParseException {
//        JSONParser parser = new JSONParser();
//        JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Program Files\\Automation testing\\mock-mektoube-qa\\src\\test\\java\\autoTest\\pages\\citiesOfItaly.json"));
//        ArrayList<String> cityItalyList = new ArrayList<>();
//        // int count=0;
//        for (Object o : a)
//        {
//            JSONObject italy = (JSONObject) o;
//            String city = (String) italy.get("Name");
//            cityItalyList.add(city);
//        }
//
//        int countNotPass=0;
//        int countPass=0;
//         ArrayList<WebElement> realCoutryList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.profile__content > p:nth-child(3)")));
//         for(WebElement country: realCoutryList){
//             if(cityItalyList.contains(country.getText())){
//                 countPass++;
//                 System.out.println("pass:"+country.getText());
//                 continue;
//             }else{
//                 //contain much letter is oke
//
//                 countNotPass++;
//                 System.out.println("invalidate: "+country.getText()+"####");
//             }
//         }
//        System.out.println("not pass=="+countNotPass);
//        System.out.println("pass=="+countPass);
////        ArrayList<WebElement> realCoutryList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.profile__content > p:nth-child(3)")));
////        ArrayList<String> italyTownList = new ArrayList<>();
////        for(WebElement country: realCoutryList) {
////            italyTownList.add(country.getText());
////        }
//        getDriver().get("https://www.mektoube.fr/inscription/entityForm");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        getDriver().findElement(By.cssSelector("div.list--radio label:nth-child(2)")).click();
//        getDriver().findElement(By.cssSelector("button i.material-icons")).click();
//        getDriver().findElement(By.cssSelector("input[placeholder='JJ']")).sendKeys("11");
//        getDriver().findElement(By.cssSelector("input[placeholder='MM']")).sendKeys("11");
//        getDriver().findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1989");
//        getDriver().findElement(By.cssSelector("button i.material-icons")).click();
//        getDriver().findElement(By.cssSelector("div.list--radio label:nth-child(1)")).click();
//        getDriver().findElement(By.cssSelector("button i.material-icons")).click();
//        getDriver().findElement(By.cssSelector("div.field--choosen__main")).click();
//        getDriver().findElement(By.cssSelector("div.list--radio label:nth-child(3)")).click();
//        getDriver().findElement(By.cssSelector("button i.material-icons")).click();
//        getDriver().findElement(By.cssSelector("input[name='zipcode']")).sendKeys("1");
//        getDriver().findElement(By.cssSelector("button i.material-icons")).click();
//
//        ArrayList<WebElement> cityList = new ArrayList<>(getDriver().findElements(By.cssSelector("span.form-label")));
//        ArrayList<String> citis = new ArrayList<>();
//        PrintWriter writer = new PrintWriter("cityOfItaly.txt", "UTF-8");
//        for(WebElement cityName: cityList){
//            citis.add(cityName.getText());
//            System.out.println(cityName.getText());
//            writer.print(cityName.getText()+"@");
//        }
////        for(String ct: citis){
////            writer.print(ct);
////        }
//        writer.close();
//        System.out.println("size: "+citis.size());
        //get all county in Italy

        //read file and save in array
        ArrayList<String> citisData = new ArrayList<>();
        FileReader fileReader = new FileReader("cityOfItaly.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String temp = bufferedReader.readLine();
        System.out.println(temp);
        String[] arr =  temp.split("@");
        //save into arraylist to easy
        for(String ct: arr){
            citisData.add(ct);
        }
        System.out.println("size of citisData: "+citisData.size());
        //check realCitis
        ArrayList<WebElement> realCitis = new ArrayList<>(getDriver().findElements(By.cssSelector("div.profile__content p:nth-child(3)")));
        for(WebElement city: realCitis){
            if(citisData.contains(city.getText())){
                continue;
            }else{
                System.out.println("faild: "+city.getText());
            }
        }
    }

    public void theSearchNamePopUpShowErrorMessage(String errorMess){
        assertEquals(errorMess,getDriver().findElement(By.cssSelector("p.error")).getText());
    }

    public void checkingThatThereIsNoDuplicatesProfilesOnTheDiscovery() {
        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(net.serenitybdd.core.annotations.findby.By.cssSelector("li.profile--item")));
        //set dont allow store duplicate element
        Set<WebElement> set = new HashSet<WebElement>(userList);
        List<WebElement> newUserList = new ArrayList<WebElement>(set);
        if (userList.size() == newUserList.size()) {
            System.out.println(":))))))))))))Dont have duplicate profile on the discovery");
        } else {
            System.out.println(":((((((((((Have duplicate profile on the discovery");
        }
        return;
    }

    public void checkingAProfileWithoutConnectionPoint() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector(".profile--item")));
//        ArrayList<WebElement> userOnline = new ArrayList<>(getDriver().findElements(By.cssSelector(".status.status--online")));
//        ArrayList<WebElement> userAway = new ArrayList<>(getDriver().findElements(By.cssSelector(".status.status--away")));
//        System.out.println("There are " + userList.size() + " profile");
//        System.out.println("There are " + userOnline.size() + " profile");
//        System.out.println("There are " + userAway.size() + " profile");
//        int userNoPoint = userList.size() - userAway.size() - userOnline.size();
//        System.out.println("=>>There are " + userNoPoint + " profiles that no point connection...");

        //click on first profile in discovery
        //new code 12/2/2020
        int count = 0;
        getDriver().findElement(By.cssSelector("ul.list-profiles li:nth-child(1) h5")).click();
        //if online-> next
        while (count < 50) {
            count++;
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.user__meta")));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (getDriver().findElement(By.cssSelector("div.user__avatar div[class='status status--online']")).isDisplayed()) {
                    //click to next profile
                    getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();
                    System.out.println("next->>");
                    continue;
                }
            }catch(org.openqa.selenium.NoSuchElementException e) {
                try {
                    System.out.println(e.getClass().getTypeName());
                    if (getDriver().findElement(By.cssSelector("div.user__avatar div[class='status status--away']")).isDisplayed()) {
                        //click to next profile
                        getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();
                        System.out.println("next->>");
                        continue;
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getClass().getTypeName());
                    //not on line -> check have Dernière connexion?-> dont have failed
                    //have to show "Dernière connexion"  below the name
                    assertTrue(getDriver().findElement(By.cssSelector("div.user__meta p:nth-child(3)")).getText().contains("Dernière connexion"));
                    //click to next profile
                    getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();
                    System.out.println("done-->next");

                }
            }
        }
    }

    public void checkingAProfileWithTheOrangeConnectionPoint() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ArrayList<WebElement> userAway = new ArrayList<>(getDriver().findElements(By.cssSelector(".status.status--away")));
//        System.out.println("There are " + userAway.size() + " user that is away");
//        //check one user: click on user then check both in profile
//        if (userAway.size() != 0) {
//            userAway.get(0).click();
//            String statusOnline = getDriver().findElement(By.cssSelector(".user__avatar > div")).getAttribute("class");
//            if (statusOnline.equals("status status--away")) {
//                System.out.println(":))Person is away that is right!!");
//                getDriver().close();
//                return;
//            }
//            System.out.println(":((Person is away that is wrong");
//            getDriver().close();
//        }
        //new code 12/2/2020
        int count=0;
        getDriver().findElement(By.cssSelector("ul.list-profiles li:nth-child(1) h5")).click();
        //if online-> next
        while (count<50) {
            count++;
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.user__meta")));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (getDriver().findElement(By.cssSelector("div.user__avatar div[class='status status--online']")).isDisplayed()) {
                    //click to next profile
                    getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();
                    System.out.println("next->>");
                    continue;
                }
            }catch(org.openqa.selenium.NoSuchElementException e) {
                try {
                    System.out.println(e.getClass().getTypeName());
                    if (getDriver().findElement(By.cssSelector("div.user__avatar div[class='status status--away']")).isDisplayed()) {
                        assertTrue(getDriver().findElement(By.cssSelector("div.user__meta p:nth-child(3)")).getText().equals("Vient de se déconnecter"));
                        //click to next profile
                        getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();
                        System.out.println("next->>");
                        continue;
                    }
                } catch (Exception ex) {
                    //click to next profile
                    getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();
                    System.out.println("done-->next");
                    continue;
                }
            }
        }
    }

    public void checkingAProfileWithTheGreenConnectionPoint() {
//        ArrayList<WebElement> userOnline = new ArrayList<>(getDriver().findElements(By.cssSelector(".status.status--online")));
//        System.out.println("There are " + userOnline.size() + " user that is away");
//        //check one user: click on user then check both in profile
//        userOnline.get(0).click();
//        String statusOnline = getDriver().findElement(By.cssSelector(".user__avatar > div")).getAttribute("class");
//        if (statusOnline.equals("status status--online")) {
//            System.out.println(":))Person is online that is right!!");
//            getDriver().close();
//            return;
//        }
//        System.out.println(":((Person is online that is wrong");
//        getDriver().close();
//        new code
        int count=0;
        getDriver().findElement(By.cssSelector("ul.list-profiles li:nth-child(1) h5")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.user__meta")));
        //if online-> next
        while (count<50) {
            count++;
            WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.user__meta")));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if(getDriver().findElement(By.cssSelector("div.user__avatar div[class='status status--online']")).isDisplayed()){
                    assertTrue(getDriver().findElement(By.cssSelector("div.user__meta p:nth-child(3)")).getText().equals("En ligne"));
                    //click to next profile
                    getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();
                    System.out.println("done next->>");
                }
            }catch (Exception e){
                //check away because filter
                //if not online, not away=> failed
                if(getDriver().findElement(By.cssSelector("div.user__avatar div[class='status status--away']")).isDisplayed()){
                    assertTrue(getDriver().findElement(By.cssSelector("div.user__meta p:nth-child(3)")).getText().equals("Vient de se déconnecter"));
                    //click to next profile
                    getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();
                    System.out.println("next->>");
                }
            }
        }
    }

    public void thePictureHaveToCorrectSize() {
        ArrayList<WebElement> nonePicProUserList = new ArrayList<>(getDriver().findElements(By.cssSelector(".avatar.entity-avatar > img")));
        ArrayList<WebElement> picProUserList = new ArrayList<>(getDriver().findElements(By.cssSelector(".avatar.avatar-box-backgrounded > img")));
        //with persons have profile picture: 160x160
        //with persons have not profile pricture: 101x101
        System.out.println("There are " + nonePicProUserList.size() + " profile that not have profile picture");
        System.out.println("There are " + picProUserList.size() + " profile that have profile picture");
        int count1 = 0;
        for (WebElement user : nonePicProUserList) {
            count1++;
            int heightImg = user.getSize().getHeight();
            int widthImg = user.getSize().getWidth();
            System.out.println("Count1: " + count1);
            System.out.println("Real Height of img: " + heightImg);
            System.out.println("Real Width of img: " + widthImg);
        }

        int count = 0;
        for (WebElement user : picProUserList) {
            count++;
            int heightImg1 = user.getSize().getHeight();
            int widthImg1 = user.getSize().getWidth();
            System.out.println("Count: " + count);
            System.out.println("Real Height of img: " + heightImg1);
            System.out.println("Real Width of img: " + widthImg1);
        }
        getDriver().close();
    }

    public void theNumberOfProfileThatHaveNotPictureProfile() {
        ArrayList<WebElement> nonePicProUserList = new ArrayList<>(getDriver().findElements(By.cssSelector(".avatar.entity-avatar > img")));
        System.out.println("The number of profile that have not picture profile are " + nonePicProUserList.size());
    }

    public void seeTheGoodFlag() {
        ArrayList<WebElement> goodFlagProfileList = new ArrayList<>(getDriver().findElements(By.cssSelector(".profile__flag > img")));
        System.out.println("Number of person have good flag are " + goodFlagProfileList.size());
        ArrayList<String> discoverySrcFlagList = new ArrayList<>();
        for(WebElement flag: goodFlagProfileList){
            System.out.println(flag.getAttribute("src"));
            discoverySrcFlagList.add(flag.getAttribute("src"));
        }

        System.out.println("goodFlagProfileList: "+goodFlagProfileList.size());
        System.out.println("discoverySrcFlagList: "+discoverySrcFlagList.size());

        //click on first profile
        //if have profile ->next
        //non profile -> check 2 image and check origin
        getDriver().findElement(By.cssSelector("ul.list-profiles li:nth-child(1) h5")).click();
        //
        try{
            if(getDriver().findElement(By.cssSelector(".avatar.entity-avatar")).isDisplayed()){
                //scroll to view MySheet
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                        getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
                if(discoverySrcFlagList.get(0).contains("/images/flags/world@2x.png")){
                    assertEquals("Autre",getDriver().findElement(By.cssSelector("div[class='col col--size-1'] ul li:nth-child(6) span")).getText());
                }else{
                    assertEquals(getDriver().findElement(By.cssSelector("div.user__bar ul li:nth-child(1) strong")).getText(),getDriver().findElement(By.cssSelector("div[class='col col--size-1'] ul li:nth-child(6) span")).getText());
                    assertEquals(discoverySrcFlagList.get(0),getDriver().findElement(By.cssSelector(".user__bar ul li.current-profile__col:nth-child(1) img")).getAttribute("src"));
                }
                //scroll on top
                JavascriptExecutor js = (JavascriptExecutor)getDriver();
                js.executeScript("window.scrollBy(0,-1500)");
                //click next profile
                getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
                System.out.println("-->next done");
            }
        }catch(Exception e){
            //click next profile
            getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
            System.out.println("next-->");
        }

        int count=1;
        while(count<goodFlagProfileList.size()){

            try{
                if(getDriver().findElement(By.cssSelector(".avatar.entity-avatar")).isDisplayed()){
                    //scroll to view MySheet
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                            getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
                    if(discoverySrcFlagList.get(count).contains("/images/flags/world@2x.png")){
                        assertEquals("Autre",getDriver().findElement(By.cssSelector("div[class='col col--size-1'] ul li:nth-child(6) span")).getText());
                    }else{
                        assertEquals(getDriver().findElement(By.cssSelector("div.user__bar ul li:nth-child(1) strong")).getText(),getDriver().findElement(By.cssSelector("div[class='col col--size-1'] ul li:nth-child(6) span")).getText());
                        assertEquals(discoverySrcFlagList.get(count),getDriver().findElement(By.cssSelector(".user__bar ul li.current-profile__col:nth-child(1) img")).getAttribute("src"));
                    }
                    //scroll on top
                    JavascriptExecutor js = (JavascriptExecutor)getDriver();
                    js.executeScript("window.scrollBy(0,-1500)");
                    //click next profile
                    getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
                    count++;
                    System.out.println("-->next done");
                }
            }catch(Exception e){
                //click next profile
                getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
                System.out.println("next-->");
            }
        }
//
//        //click on all profiles without photo
//        //idea: save all images and src of images=> click all image of profile, get image and check with src of image
//        int count=0;
//        for(String discoverySrc: discoverySrcFlagList){
//            System.out.println("\n"+count);
//            System.out.println("1 discoverySrc: "+discoverySrc);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//            //String discoverySrc = goodFlag.getAttribute("src");
//            goodFlagProfileList.get(count).click();
//            if(discoverySrc.contains("/images/flags/world@2x.png")){
//                //in profile just have one flag, not yet correct
//                //check origin = Autre
//                //scroll to view MySheet
//                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
//                        getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
//                assertEquals("Autre",getDriver().findElement(By.cssSelector("div[class='col col--size-1'] ul li:nth-child(6) span")).getText());
//                //click discovery
//                getDriver().findElement(By.cssSelector("#main_header > div > nav > ul > li:nth-child(1) > a > span.text")).click();
//                count++;
//                continue;
//            }
//
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
//                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
//
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            String profileSrc = getDriver().findElement(By.cssSelector(".user__bar ul li.current-profile__col:nth-child(1) img")).getAttribute("src");
//            System.out.println("2 profileSrc: "+profileSrc);
//            assertEquals(discoverySrc, profileSrc);
//
//            String flagText = getDriver().findElement(By.cssSelector("div.user__bar ul li:nth-child(1) strong")).getText();
//            String originText = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] ul li:nth-child(6) span")).getText();
//            System.out.println(flagText+"____?___"+originText);
//            assertEquals(flagText, originText);
//
//            //click discovery
//            getDriver().findElement(By.cssSelector("#main_header > div > nav > ul > li:nth-child(1) > a > span.text")).click();
//            count++;
//        }
    }

    public void saveIdOfProfileIs(String profile){

        String profileId = getDriver().findElement(By.cssSelector(".list-profiles > .profile--item:nth-child(1)")).getAttribute("id");
        noti.WriteToFile(profileId);
    }

    public void browserShouldRedirectToThisPerson() throws Exception {
        String id = noti.ReadFromFile();
        System.out.println("id=="+id);
        //cut just get id number
        String numberId = id.substring(11);
        System.out.println("Number id is " + numberId);
        String currentUrl = getDriver().getCurrentUrl();
        System.out.println("Current url " + currentUrl);

        if (currentUrl.equals("https://www.mektoube.fr/main/profil/" + numberId)) {
            System.out.println("Click successful..");
            return;
        } else {
            System.out.println("Real url: " + "https://www.mektoube.fr/main/profil/" + numberId);
            System.out.println("Click faild...");
            return;
        }
    }

    public void setUpSizeCm(int size){
        WebElement element = getDriver().findElement(By.cssSelector("div[class='rc-slider rc-slider-vertical']"));
        Actions moveSlider = new Actions(getDriver());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Action action = moveSlider.dragAndDropBy(element, 300, 0).build();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.perform();
    }

    public void thePageShowAllProfileThatHaveMaxSizeCm(int size){
        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li")));
        ArrayList<String> userIdList = new ArrayList<>();
        for(WebElement user: userList){
            userIdList.add(user.getAttribute("id"));
            System.out.println("id just save "+user.getAttribute("id"));
        }
        //click on users
        for(String id: userIdList){
            System.out.println("click on "+id);
            getDriver().findElement(By.cssSelector("#"+id+"> a > div.profile__content > h5")).click();
            //get value of size
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String sizeValue = getDriver().findElement(By.cssSelector("ul.list-complex > li:nth-child(2) > h2")).getText();
            String[] temp = sizeValue.split("m");
            System.out.println("temp[0] "+temp[0]);
            try {
                float realSizeValue = Float.parseFloat(temp[0].replace(",", "."));
                System.out.println("real size value is "+realSizeValue);
                if(realSizeValue>=1 && realSizeValue<=2.20){
                    System.out.println("passed");
                    System.out.println("...continue click next profile...");
                    //return discovery page that save above result search
                    getDriver().findElement(By.cssSelector(".nav.nav--primary > ul > li:nth-child(1) > a")).click();
                }
                else{
                    assertEquals("error","error1");
                }
            }catch (NumberFormatException e){
                System.out.println("this profile dont show size ");
                getDriver().findElement(By.cssSelector(".nav.nav--primary > ul > li:nth-child(1) > a")).click();
            }
        }
    }

    public void clickIfItIsDisable(String element){
        String cssSelector = TestDataService.properties.getProperty(element);
        if(getDriver().findElement(By.cssSelector(cssSelector)).isSelected()){
            return;
        }else{
            getDriver().findElement(By.cssSelector(cssSelector)).click();
        }
    }

    public void theDiscoveryPageShowAllManProfile() {
        try{
            while (getDriver().findElement(By.cssSelector("a.control-button.next-nav")).isDisplayed()) {
                //scroll to view MySheet
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                        getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
                //check man profile
                assertEquals("Pratiquant :", getDriver().findElement(By.cssSelector("div[class='col col--size-1'] ul li:nth-child(9) strong")).getText());
                //scroll on top
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("window.scrollBy(0,-1000)");
                //click next profile
                getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
                System.out.println("-->next done");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch (org.openqa.selenium.NoSuchElementException e){
            //scroll to view MySheet
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
            //check man profile
            assertEquals("Pratiquant :", getDriver().findElement(By.cssSelector("div[class='col col--size-1'] ul li:nth-child(9) strong")).getText());
        }
    }

    public void theDiscoveryPageShowAllWomanProfile(){
        try {
            while (getDriver().findElement(By.cssSelector("a.control-button.next-nav")).isDisplayed()) {
                //scroll to view MySheet
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                        getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
                //check man profile
                assertEquals("Pratiquante :", getDriver().findElement(By.cssSelector("div[class='col col--size-1'] ul li:nth-child(9) strong")).getText());
                //scroll on top
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("window.scrollBy(0,-1000)");
                //click next profile
                getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
                System.out.println("-->next done");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }}
        catch(org.openqa.selenium.NoSuchElementException e){
            //scroll to view MySheet
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
            //check man profile
            assertEquals("Pratiquante :", getDriver().findElement(By.cssSelector("div[class='col col--size-1'] ul li:nth-child(9) strong")).getText());
        }
    }

    public void setUpAgeRangeFromTo(int minAge, int maxAge){
//        WebElement element = getDriver().findElement(By.cssSelector("div.rc-slider"));
//        Actions moveSlider = new Actions(getDriver());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Point point = element.getLocation();
//        int xcord = point.getX();
//        System.out.println("Position of the webelement from left side is "+xcord +" pixels");
//        int ycord = point.getY();
//        System.out.println("Position of the webelement from top side is "+ycord +" pixels");
//
//        //200~95: just scroll left, age range from 95 to 100
//        moveSlider.dragAndDropBy(element,600 , 297).build().perform();

        //new code 19/2
        //getDriver().findElement(By.cssSelector("div.rc-slider")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String minAgeOnSlider = getDriver().findElement(By.cssSelector("div[class='rc-slider-handle rc-slider-handle-1']")).getAttribute("aria-valuenow");
        int numberOfMinAgeOnSlider = Integer.parseInt(minAgeOnSlider);
        System.out.println(numberOfMinAgeOnSlider);
        String maxAgeOnSlider = getDriver().findElement(By.cssSelector("div[class='rc-slider-handle rc-slider-handle-2']")).getAttribute("aria-valuenow");
        int numberOfMaxAgeOnSlider = Integer.parseInt(maxAgeOnSlider);
        System.out.println(numberOfMaxAgeOnSlider);
        if (minAge > numberOfMinAgeOnSlider) {

            if (maxAge > numberOfMaxAgeOnSlider) {
                //
                System.out.println("max age out of range, set max age = max age on slider, =99");
            }
            if (maxAge < numberOfMaxAgeOnSlider) {
                for (int j = 0; j < (numberOfMaxAgeOnSlider-maxAge -2); j++) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_DOWN);
                }
            }
            if (numberOfMaxAgeOnSlider == maxAge) {
                System.out.println("max age is ok");
            }
            for (int i = 0; i < (minAge - numberOfMinAgeOnSlider); i++) {
                getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-1")).sendKeys(Keys.ARROW_UP);
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            getDriver().findElement(By.cssSelector("button i.material-icons")).click();
//            assertEquals(String.valueOf(minAge)+" - "+String.valueOf(maxAge),getDriver().findElement(By.cssSelector("div.filter__item-aside span.value-text")).getText());
        }
        if (minAge < numberOfMinAgeOnSlider) {
            for (int i = numberOfMinAgeOnSlider; i > minAge; i--) {
                System.out.println("out of min age range, set min age = numberOfMinAge on slider, =18");
            }
            if (maxAge > numberOfMaxAgeOnSlider) {
                System.out.println("max age out of range, set max age = max age on slider, =99");
            }
            if (maxAge < numberOfMaxAgeOnSlider) {
                for (int j = 0; j < (numberOfMaxAgeOnSlider-maxAge - 2); j++) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_DOWN);
                }
            }
            if (numberOfMaxAgeOnSlider == maxAge) {
                System.out.println("max age is ok");
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            getDriver().findElement(By.cssSelector("button i.material-icons")).click();
//            assertEquals(String.valueOf(minAge)+" - "+String.valueOf(maxAge),getDriver().findElement(By.cssSelector("div.filter__item-aside span.value-text")).getText());
        }
        if (numberOfMinAgeOnSlider == minAge) {
            System.out.println("min age is ok");
            if (maxAge > numberOfMaxAgeOnSlider) {
                System.out.println("max age out of range, set max age = max age on slider, =99");
            }
            if (maxAge < numberOfMaxAgeOnSlider) {
                for (int j = 0; j < (numberOfMaxAgeOnSlider-maxAge - 2); j++) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_DOWN);
                }
            }
            if (numberOfMaxAgeOnSlider == maxAge) {
                System.out.println("max age is ok");
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            getDriver().findElement(By.cssSelector("button i.material-icons")).click();
//            assertEquals(String.valueOf(minAge)+" - "+String.valueOf(maxAge),getDriver().findElement(By.cssSelector("div.filter__item-aside span.value-text")).getText());
        }
    }

    //waiting for bug 1248 res done after check again
    public void setUpSizeFromCmToCm(int minSize, int maxSize){

        //new code 19/2/2020

        String minSizeOnSlider = getDriver().findElement(By.cssSelector("div[class='rc-slider-handle rc-slider-handle-1']")).getAttribute("aria-valuenow");
        int numberOfMinSizeOnSlider = Integer.parseInt(minSizeOnSlider);
        System.out.println(numberOfMinSizeOnSlider);
        String maxSizeOnSlider = getDriver().findElement(By.cssSelector("div[class='rc-slider-handle rc-slider-handle-2']")).getAttribute("aria-valuenow");
        int numberOfMaxSizeOnSlider = Integer.parseInt(maxSizeOnSlider);
        System.out.println(numberOfMaxSizeOnSlider);
        if (minSize > numberOfMinSizeOnSlider) {

            if (maxSize > numberOfMaxSizeOnSlider) {
                //
                System.out.println("max age out of range, set max age = max age on slider, =220");
            }
            if (maxSize < numberOfMaxSizeOnSlider) {
                for (int j = 0; j < (numberOfMaxSizeOnSlider-maxSize -2); j++) {
                    getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_DOWN);
                }
            }
            if (numberOfMaxSizeOnSlider == maxSize) {
                System.out.println("max age is ok");
            }
            for (int i = 0; i < (minSize - numberOfMinSizeOnSlider); i++) {
                getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-1")).sendKeys(Keys.ARROW_UP);
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (minSize < numberOfMinSizeOnSlider) {
            for (int i = numberOfMinSizeOnSlider; i > minSize; i--) {
                System.out.println("out of min age range, set min age = numberOfMinAge on slider, =100");
            }
            if (maxSize > numberOfMaxSizeOnSlider) {
                System.out.println("max age out of range, set max age = max age on slider, =220");
            }
            if (maxSize < numberOfMaxSizeOnSlider) {
                for (int j = 0; j < (numberOfMaxSizeOnSlider-maxSize - 2); j++) {
                    getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_DOWN);
                }
            }
            if (numberOfMaxSizeOnSlider == maxSize) {
                System.out.println("max age is ok");
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (numberOfMinSizeOnSlider == minSize) {
            System.out.println("min age is ok");
            if (maxSize > numberOfMaxSizeOnSlider) {
                System.out.println("max age out of range, set max age = max age on slider, =220");
            }
            if (maxSize < numberOfMaxSizeOnSlider) {
                for (int j = 0; j < (numberOfMaxSizeOnSlider-maxSize - 2); j++) {
                    getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_DOWN);
                }
            }
            if (numberOfMaxSizeOnSlider == maxSize) {
                System.out.println("max age is ok");
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void thePageShowAllProfileThatHaveSizeFromCmToCm(int minSize, int maxSize){
        //scroll to view my sheet
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));

        String sizeString = getDriver().findElement(By.cssSelector("ul.list-complex li:nth-child(2) h2")).getText();
        System.out.println(sizeString);

        String[] temp = sizeString.split("m");
        String sizeNumb = temp[0].trim();

        assertTrue(Float.parseFloat(sizeNumb.replace(",","."))*100>=minSize);
        assertTrue(Float.parseFloat(sizeNumb.replace(",","."))*100<=maxSize);

        //scroll on Top
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,-1000)");

        int count=0;
        while(count<25){
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='control-button next-nav']")));

            getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();

            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));

            sizeString = getDriver().findElement(By.cssSelector("ul.list-complex li:nth-child(2) h2")).getText();
            System.out.println(sizeString);

            temp = sizeString.split("m");
            sizeNumb = temp[0];

            assertTrue(Float.parseFloat(sizeNumb.replace(",","."))*100>=minSize);
            assertTrue(Float.parseFloat(sizeNumb.replace(",","."))*100<=maxSize);

            //scroll on Top
            js.executeScript("window.scrollBy(0,-1000)");

            count++;
        }
    }

    public void thePageShowNotificationAndDontShowInThisSearchResult(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        String notiText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.container-fluid > div[class='top-message-overlay success'] > div.top-message-text > div"))).getText();
        assertEquals("Filtre supprimé",notiText);

        String searchSaveName="";
        try {
            searchSaveName  = noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<WebElement> searchList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.filter__item > div.filter__item-content > h5")));
        for(WebElement ele: searchList){
            if(ele.equals(searchSaveName)) {
                assertEquals("error", searchSaveName);
            }
        }
        System.out.println("Pass : the search save list dont have search save name deleted.");
    }

    public void thePageShowAllProfileThatHaveAboveSilhouette(){
        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li")));
        ArrayList<String> userIdList = new ArrayList<>();
        for(WebElement user: userList){
            try{
                if(user.findElement(By.cssSelector("div.fake-content")).isEnabled()){
                    continue;
                }
            }catch (Exception e){
                userIdList.add(user.getAttribute("id"));
                System.out.println("id just save "+user.getAttribute("id"));
            }
        }
        //click on users
        for(String id: userIdList){
            getDriver().findElement(By.cssSelector("#"+id+"> a > div.profile__content > h5")).click();
            //get value of Silhouette
            try {
                String value = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(7) > span")).getText();

                try {
                    assertEquals("Mince", value);
                } catch (Exception e) {
                    try {
                        assertEquals("", value);
                    } catch (Exception e1) {
                        assertEquals("error", "error1");
                    }
                }
            }catch (Exception e){
                continue;
            }
            System.out.println("...continue click next profile...");
            //return discovery page that save above result search
            getDriver().findElement(By.cssSelector(".nav.nav--primary > ul > li:nth-child(1) > a")).click();
        }
    }

    //1/6/2020
    public void thePageShowAllProfileThatHaveAboveFamilySituation(){
//        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li")));
//        ArrayList<String> userIdList = new ArrayList<>();
//        for(WebElement user: userList){
//            userIdList.add(user.getAttribute("id"));
//            System.out.println("id just save "+user.getAttribute("id"));
//        }
//        //click on users
//        for(String id: userIdList){
//            System.out.println("click on "+id);
//            getDriver().findElement(By.cssSelector("#"+id+"> a > div.profile__content > h5")).click();
//            //get value of family situation
//            String value = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(3) > span")).getText();
//            if(value.equals("")){
//                System.out.println("Dont care this attribute!!");
//            }else {
//                assertEquals("Divorcée", value);
//            }
//            System.out.println("...continue click next profile...");
//            //return discovery page that save above result search
//            getDriver().findElement(By.cssSelector(".nav.nav--primary > ul > li:nth-child(1) > a")).click();
//        }
        //click on first profile in discovery after have search result
        getDriver().findElement(By.cssSelector("ul.list-profiles li:nth-child(1) h5")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //scroll to see MySheet and check
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentSilhouette = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(3) > span")).getText();
        assertEquals("Divorcée",currentSilhouette);
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,-1000)");
        //kiem tra xem profile cuoi chua neu chua thi click tiep
        // just check 10
        int count=0;
        while(count<10){

            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='control-button next-nav']")));

            getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
            String currentSilhouette1 = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(3) > span")).getText();
            assertEquals("Divorcée",currentSilhouette1);
            js.executeScript("window.scrollBy(0,-1000)");
            count++;
        }
    }

    //29/6/2020
    public void thePageShowAllProfileThatHaveAboveChoicedChildren(){
//        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li")));
//        ArrayList<String> userIdList = new ArrayList<>();
//        for(WebElement user: userList){
//            try{
//                if(user.findElement(By.cssSelector("div.fake-content")).isEnabled()){
//                    continue;
//                }
//            }catch (Exception e){
//                userIdList.add(user.getAttribute("id"));
//                System.out.println("id just save "+user.getAttribute("id"));
//            }
//        }
//        //click on users
//        for(String id: userIdList){
//            System.out.println("click on "+id);
//            getDriver().findElement(By.cssSelector("#"+id+"> a > div.profile__content > h5")).click();
//            //scroll to view origin field
//            MektoubeCommonPage mcp = new MektoubeCommonPage();
//            mcp.scrollToView("MySheet");
//            //get value of Silhouette
//            String value = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(4) > span")).getText();
//            if(value.equals("")){
//                System.out.println("Dont care this attribute!!");
//            }else {
//                assertEquals("Non", value);
//            }
//            System.out.println("...continue click next profile...");
//            //return discovery page that save above result search
//            getDriver().findElement(By.cssSelector(".nav.nav--primary > ul > li:nth-child(1) > a")).click();
//        }
        //new code 13/2/2020
        //click on first profile
        getDriver().findElement(By.cssSelector("ul.list-profiles li:nth-child(1) h5")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //scroll to see MySheet and check pratiquant
        MektoubeCommonPage mcp = new MektoubeCommonPage();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentPratiquant = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(4) > span")).getText();
        assertEquals("Non",currentPratiquant);
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,-1000)");
        //kiem tra xem profile cuoi chua neu chua thi click tiep
        //currentPratiquant = currentPratiquant1
        int count=1;
        while(getDriver().findElement(By.cssSelector("a.control-button.next-nav")).isEnabled()){
            getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
            String currentPratiquant1 = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(4) > span")).getText();
            assertEquals("Non",currentPratiquant1);
            js.executeScript("window.scrollBy(0,-1000)");
            count++;
            if(count>10){
                break;
            }
        }
    }

    public void thePageShowAllProfileThatHaveAbovePratiquant(){

        //click on first profile
        getDriver().findElement(By.cssSelector("ul.list-profiles li:nth-child(1) h5")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //scroll to see MySheet and check pratiquant
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentPratiquant = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(9) > span")).getText();
        assertEquals("Dans le Din",currentPratiquant);
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,-1000)");
        //kiem tra xem profile cuoi chua neu chua thi click tiep
        //currentPratiquant = currentPratiquant1
        int count=1;
        while(getDriver().findElement(By.cssSelector("a.control-button.next-nav")).isEnabled()){
            getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));                String currentPratiquant1 = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(9) > span")).getText();
            assertEquals("Dans le Din",currentPratiquant1);
            js.executeScript("window.scrollBy(0,-1000)");
            count++;
            if(count>10){
                break;
            }
        }
//        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li")));
//        ArrayList<String> userIdList = new ArrayList<>();
//        for(WebElement user: userList){
//            try{
//                if(user.findElement(By.cssSelector("div.fake-content")).isEnabled()){
//                    continue;
//                }
//            }catch (Exception e){
//                userIdList.add(user.getAttribute("id"));
//                System.out.println("id just save "+user.getAttribute("id"));
//            }
//        }
//        //click on users
//        for(String id: userIdList){
//            System.out.println("click on "+id);
//            getDriver().findElement(By.cssSelector("#"+id+"> a > div.profile__content > h5")).click();
//            //scroll to view origin field
//            JavascriptExecutor js = (JavascriptExecutor) getDriver();
//            js.executeScript("window.scrollTo(0,500)");
//            //get value of Silhouette
//            String value = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(9) > span")).getText();
//            if(value.equals("")){
//                System.out.println("Dont care this attribute!!");
//            }else {
//                assertEquals("Dans le Din", value);
//            }
//            System.out.println("...continue click next profile...");
//            //return discovery page that save above result search
//            getDriver().findElement(By.cssSelector(".nav.nav--primary > ul > li:nth-child(1) > a")).click();
//        }
    }

    public void thePageShowAllProfilesThatHaveAboveSmokingChoice(){

        int count=0;
        //click on first profile
        getDriver().findElement(By.cssSelector("ul.list-profiles li:nth-child(1) h5")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //check pratiquant
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));            String currentStatusSmoke = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(10) > span")).getText();
        assertEquals("Oui, occasionnellement",currentStatusSmoke);
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,-1000)");
        //kiem tra xem profile cuoi chua neu chua thi click tiep
        //currentPratiquant = currentPratiquant1
        while(getDriver().findElement(By.cssSelector("a.control-button.next-nav")).isEnabled()){
            if(count>15){
                System.out.println("Checking enough...");
                return;
            }
            getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));                String currentStatusSmoke1 = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(10) > span")).getText();
            assertEquals("Oui, occasionnellement",currentStatusSmoke1);
            count++;
            js.executeScript("window.scrollBy(0,-1000)");
        }
//        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li")));
//        ArrayList<String> userIdList = new ArrayList<>();
//        for(WebElement user: userList){
//            try{
//                if(user.findElement(By.cssSelector("div.fake-content")).isEnabled()){
//                    continue;
//                }
//            }catch (Exception e){
//                userIdList.add(user.getAttribute("id"));
//                System.out.println("id just save "+user.getAttribute("id"));
//            }
//        }
//        //click on users
//        for(String id: userIdList){
//            System.out.println("click on "+id);
//            getDriver().findElement(By.cssSelector("#"+id+"> a > div.profile__content > h5")).click();
//            //scroll to view origin field
//            JavascriptExecutor js = (JavascriptExecutor) getDriver();
//            js.executeScript("window.scrollTo(0,500)");
//            //get value of Silhouette
//            String value = getDriver().findElement(By.cssSelector("div[class='col col--size-1'] > ul > li:nth-child(10) > span")).getText();
//            if(value.equals("")){
//                System.out.println("Dont care this attribute!!");
//            }else {
//                assertEquals("Oui, occasionnellement", value);
//            }
//            System.out.println("...continue click next profile...");
//            //return discovery page that save above result search
//            getDriver().findElement(By.cssSelector(".nav.nav--primary > ul > li:nth-child(1) > a")).click();
//        }
    }

    public void thePageShowAllProfilesThatHaveAboveLevelOfStudy(){
//click on first profile
        getDriver().findElement(By.cssSelector("ul.list-profiles li:nth-child(1) h5")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //check
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(2) div.section__group-head h2")));
        String currentLevelStudy = getDriver().findElement(By.cssSelector("div.section__inner > div.section__group:nth-child(2) > div.section__group-body > ul > li:nth-child(9) > span")).getText();
        assertEquals("Bac +3",currentLevelStudy);
        System.out.println("pass");
        //scroll on top
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,-1000)");
//        WebElement element = getDriver().findElement(By.cssSelector(".profiles-control-navs"));
//        js.executeScript("arguments[0].scrollIntoView();", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //kiem tra xem profile cuoi chua neu chua thi click tiep
        //currentPratiquant = currentPratiquant1
        int count=1;
        while(getDriver().findElement(By.cssSelector("a.control-button.next-nav")).isEnabled()){
            getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(2) div.section__group-head h2")));
            String currentLevelStudy1 = getDriver().findElement(By.cssSelector("div.section__inner > div.section__group:nth-child(2) > div.section__group-body > ul > li:nth-child(9) > span")).getText();
            assertEquals("Bac +3",currentLevelStudy1);
            System.out.println("pass");
            //scroll on top
            js.executeScript("window.scrollBy(0,-1000)");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if(count>10){
                break;
            }
        }
//        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li")));
//        ArrayList<String> userIdList = new ArrayList<>();
//        for(WebElement user: userList){
//            try{
//                if(user.findElement(By.cssSelector("div.fake-content")).isEnabled()){
//                    continue;
//                }
//            }catch (Exception e){
//                userIdList.add(user.getAttribute("id"));
//                System.out.println("id just save "+user.getAttribute("id"));
//            }
//        }
//        //click on users
//        for(String id: userIdList){
//            System.out.println("click on "+id);
//            getDriver().findElement(By.cssSelector("#"+id+"> a > div.profile__content > h5")).click();
//            //scroll to view origin field
//            JavascriptExecutor js = (JavascriptExecutor) getDriver();
//            js.executeScript("window.scrollTo(0,500)");
//            //get value of Silhouette
//            String value = getDriver().findElement(By.cssSelector("div.section__inner > div.section__group:nth-child(2) > div.section__group-body > ul > li:nth-child(9) > span")).getText();
//            System.out.println(value);
//            if(value.equals("")){
//                System.out.println("Dont care this attribute!!");
//            }else {
//                assertEquals("Bac +3", value);
//            }
//            System.out.println("...continue click next profile...");
//            //return discovery page that save above result search
//            getDriver().findElement(By.cssSelector(".nav.nav--primary > ul > li:nth-child(1) > a")).click();
//        }
    }

    public void thePageShowAllProfileThatHaveAboveOrigin() throws InterruptedException {
        try{
            //click on first profile
            getDriver().findElement(By.cssSelector("ul.list-profiles li:nth-child(1) h5")).click();

            //check origin
            String currentOrigin = getDriver().findElement(By.cssSelector("div.user__bar li:nth-child(1) strong")).getText();
            assertEquals("Algérien",currentOrigin);
            //click next profile

            //for
            while(getDriver().findElement(By.cssSelector("a.control-button.next-nav")).isEnabled()){
                getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
                //check origin
                String currentOrigin1 = getDriver().findElement(By.cssSelector("div.user__bar li:nth-child(1) strong")).getText();
                assertEquals("Algérien",currentOrigin1);
                //click next profile
//            getDriver().findElement(By.cssSelector("a.control-button.next-nav")).click();
            }
        }catch (Exception e){
            Thread.sleep(20000);
        }
    }
}
