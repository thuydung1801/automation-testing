package autoTest.pages;


import autoTest.service.TestDataService;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.beans.Introspector;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.mk_latn.No;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactRequestPage extends PageObject {
    MektoubeCommonPage commonPage = new MektoubeCommonPage();
    NotificationPage noti = new NotificationPage();
    MessageModule messageModule = new MessageModule();

    public void chooseProfileContainContactRequestButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> profile = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".profile"))));

        profile.get(0).click();

        System.out.println("sdsadsd");

        ArrayList<WebElement> contactRequestBtn = new ArrayList<>(getDriver().findElements(By.cssSelector("button[class='mdc-button mdc-button--unelevated mdc-btn--pink']")));
        if (contactRequestBtn.size() > 0) {
            System.out.println("ok");
        } else {
            getDriver().findElement(By.cssSelector(".user__sidebar .user__header i[class='material-icons']")).click();
            ArrayList<WebElement> profile2 = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".profile"))));
            profile2.get(1).click();
            ArrayList<WebElement> contactRequestBtn2 = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[class='mdc-button mdc-button--unelevated mdc-btn--pink']"))));
            if (contactRequestBtn2.size() > 0) {
                System.out.println("ok");
            }
        }

    }

    public boolean shouldSeeExplanationInTheMessageField() {
        commonPage.waitUntilElementIsVisible("WriteContactRequestModal");
        WebElement explanationInMess = getDriver().findElement(By.cssSelector("div[class='request-contact-description']"));
        String explanationInMessText = explanationInMess.getText();
        if (explanationInMessText.contentEquals("Votre premier message est précieux. Tant qu’elle n’aura pas accepté de croiser votre destin vous ne pourrez pas lui renvoyer d’autres messages.")) {
            System.out.println(explanationInMessText + " pass");

            return true;
        }
        System.out.println(explanationInMessText + " fail");
        return false;
    }

    public boolean theModalForWriteMessageIsClosing() {
        ArrayList<WebElement> ModalDestinyMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='setting--modal contact-request-modal small-form-modal mobile-nofull avoid-keyboard-space modal is--opened']")));
        if (ModalDestinyMess.size() > 0) {
            System.out.println(ModalDestinyMess + " fail");
            return false;
        }
        System.out.println(ModalDestinyMess + " pass");
        return true;

    }

    public boolean shouldSeeSeeTherePagesOfExplanation() {

        commonPage.waitUntilElementIsVisible("div[class='photo-info--modal request-info--modal modal is--opened']");

        WebElement header = getDriver().findElement(By.cssSelector("div[class='modal--body'] h3[class='heading']"));
        String headerText = header.getText();
        if (!headerText.contentEquals("Croiser son destin, c'est quoi ?")) {
            return false;
        }
        WebElement contentPage1 = getDriver().findElement(By.cssSelector("div[class='owl-item active'] div[class='slide-item']:nth-child(1) p"));
        String contentPage1Text = contentPage1.getText();
        if (!contentPage1Text.contentEquals("Les femmes recevaient trop de messages.\n" +
                "\n" +
                "Votre premier message se noyait dans la masse.")) {
            return false;
        }
        commonPage.waitUntilElementIsVisible("div[class='owl-item active'] div[class='slide-item'] img[src='/images/temp/destin_man_1.png']");
        boolean img1 = getDriver().findElement(By.cssSelector("div[class='owl-item active'] div[class='slide-item'] img[src='/images/temp/destin_man_1.png']")).isDisplayed();
        if (!img1) {
            System.out.println("missing picture1");
            return false;
        }
        commonPage.click("button[class='owl-next']");

        if (!headerText.contentEquals("Croiser son destin, c'est quoi ?")) {
            return false;
        }
        commonPage.waitUntilElementIsVisible("div[class='owl-item active'] div[class='slide-item'] img[src='/images/temp/destin_man_2.png']");
        boolean img2 = getDriver().findElement(By.cssSelector("div[class='owl-item active'] div[class='slide-item'] img[src='/images/temp/destin_man_2.png']")).isDisplayed();
        if (!img2) {
            System.out.println("missing picture2");
            return false;
        }

        WebElement contentPage2 = getDriver().findElement(By.cssSelector("div[class='owl-item active'] div[class='slide-item'] p"));
        String contentPage2Text = contentPage2.getText();
        if (!contentPage2Text.contentEquals("Cette nouvelle fonctionnalité permet aux femmes de choisir les hommes avec lesquels elles veulent discuter. \n" +
                "\n" +
                "Ainsi, les femmes sont plus attentives à votre 1er message. \n" +
                "\n" +
                "Si vous lui plaisez, elle ne peut pas vous rater !")) {
            return false;
        }
        commonPage.click("button[class='owl-next']");

        commonPage.waitUntilElementIsVisible("div[class='owl-item active'] div[class='slide-item'] img[src='/images/temp/destin_man_3.png']");
        boolean img3 = getDriver().findElement(By.cssSelector("div[class='owl-item active'] div[class='slide-item'] img[src='/images/temp/destin_man_3.png']")).isDisplayed();
        if (!img3) {
            System.out.println("missing picture3");
            return false;
        }
        WebElement contentPage3 = getDriver().findElement(By.cssSelector("div[class='owl-item active'] div[class='slide-item'] p"));
        String contentPage3Text = contentPage3.getText();
        if (!contentPage3Text.contentEquals("Si elle accepte de croiser votre destin, vous pouvez échanger ensemble. \n" +
                "\n" +
                "Si elle refuse, vous ne pourrez pas la recontacter avant 30 jours.")) {
            return false;
        }
        return true;
    }

    public boolean checkIfInspirationalTextCanChange() throws AWTException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        Robot robot = new Robot();
        for (int i = 0; i < 15; i++) {
            commonPage.waitUntilElementIsVisible(".inpirational-tooltip button[type='button']");
            commonPage.click(".inpirational-tooltip button[type='button']");
            ArrayList<String> inpirationalOptionList = new ArrayList<>();
            ArrayList<WebElement> inpirationalElement = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".inspirational-list .inspirational-item"))));
            System.out.println(inpirationalElement.size());
            for (WebElement inpirationalOption : inpirationalElement) {
                inpirationalOptionList.add(inpirationalOption.getText());
            }

            if (i > 9) {
                robot.mouseWheel(10);

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                inpirationalElement.get(i).click();

            } else {
                inpirationalElement.get(i).click();
            }

            String MessageDisplayInTextArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".field-wrap textarea"))).getText();
            if (inpirationalOptionList.get(i).contentEquals("Salam. Qu'est-ce que tu fais pour te relaxer après une journée difficile ?")) {
                if (!MessageDisplayInTextArea.contentEquals("Salam. \n" +
                        "Qu'est-ce que tu fais pour te relaxer après une journée difficile ?")) {
                    return false;
                }

            } else {
                if (!inpirationalOptionList.get(i).replace(" ", "").equals(MessageDisplayInTextArea.replace(" ", ""))) {
                    System.out.println(i);
                    System.out.println(inpirationalOptionList.get(i));
                    System.out.println(MessageDisplayInTextArea + " fail");
                    return false;


                }
            }


            System.out.println(i);
            System.out.println(inpirationalOptionList.get(i));
            System.out.println(MessageDisplayInTextArea + " pass");
            commonPage.clearTextFromField(".field-wrap textarea");

        }

        ArrayList<WebElement> CloseBtn = new ArrayList<>(getDriver().findElements(By.cssSelector(".setting--modal.inspirational-modal.modal.is--opened a.closer.hidden-xs i.material-icons")));
        if (CloseBtn.size() > 0) {
            CloseBtn.get(0).click();
        } else {
            System.out.println("ok, k cần click");
        }
        return true;

    }

    public boolean choseInspirationalText() throws AWTException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        Robot robot = new Robot();
        commonPage.waitUntilElementIsVisible(".inpirational-tooltip button[type='button']");
        commonPage.click(".inpirational-tooltip button[type='button']");


        ArrayList<WebElement> inpirationalOption = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".inspirational-list .inspirational-item"))));
        System.out.println("number of expiration text " + inpirationalOption.size());

        WebElement inpirationalList = getDriver().findElement(By.cssSelector(".inspirational-list"));
        Point inpirationalListLocation = inpirationalList.getLocation();
        int x = inpirationalListLocation.getX();
        int y = inpirationalListLocation.getY() + 120;
        robot.mouseMove(x, y);
        System.out.println(x + " " + y);

        //scroll and wait a bit to give the impression of smooth scrolling
        robot.mouseWheel(10);


        inpirationalOption = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".inspirational-list .inspirational-item"))));

        if (inpirationalOption.size() != 15) {
            System.out.println("number of expiration text " + inpirationalOption.size());
            return false;
        }
        inpirationalOption.get(inpirationalOption.size() - 2).click();

        commonPage.waitUntilElementIsVisible(".field-wrap textarea");
        WebElement InTextArea = getDriver().findElement(By.cssSelector(".field-wrap textarea"));
        String MessageDisplayInTextArea = InTextArea.getText();
        System.out.println(MessageDisplayInTextArea + " ok1");
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem(arguments[0],arguments[1])", "InTextArea", MessageDisplayInTextArea);
        System.out.println(MessageDisplayInTextArea + " ok2");
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();
        return true;

    }

    public void loginInByWomanAccount() {

        String abc = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('emailField')");
        getDriver().findElement(By.cssSelector("input[name='username']")).sendKeys(abc);
        System.out.println(abc);

        getDriver().findElement(By.cssSelector("input[name='password']")).sendKeys("Mektoubi2017");

        getDriver().findElement(By.cssSelector("button[type='submit']")).click();

    }

    public void acceptContactRequestOf(String user) {
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='request__head'] h5"))));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(user)) {
                ArrayList<WebElement> acceptMess = new ArrayList<>(getDriver().findElements(By.cssSelector("a[class='mdc-button mdc-button--unelevated']")));
                acceptMess.get(i).click();
                commonPage.waitUntilElementIsVisible("button[class='mdc-button mdc-button--unelevated full-wrap-width']");
                getDriver().findElement(By.cssSelector("button[class='mdc-button mdc-button--unelevated full-wrap-width']")).click();

            }

        }
    }

    public boolean shouldSeeMessageWithFirst(String user) {
        commonPage.waitUntilElementIsVisible(".message");
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(user)) {
                if (i == 0) {
                    System.out.println(i + " pass");
                    return true;
                }

                ArrayList<WebElement> acceptMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
                String commercialMess = acceptMess.get(0).getText();
                if (i == 1 && commercialMess.contentEquals("L'Equipe Mektoube")) {
                    System.out.println(commercialMess + " " + i);
                    return true;
                }

            }
        }
        return false;
    }

    public boolean shouldSeeMessageWithSameContentOfSentMessage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        String MessageMaleSent = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('InTextArea')");
        String MessageInFemaleLogChat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".chat__body-rows div:nth-child(1) span.mes-body-text"))).getText();
        if (MessageMaleSent.replace(" ", "").contains(MessageInFemaleLogChat.replace(" ",""))) {
            System.out.println(MessageInFemaleLogChat + MessageMaleSent + " Pass");
            return true;
        }
        System.out.println(MessageInFemaleLogChat + MessageMaleSent + " fail");
        return false;

    }

    public boolean shouldSeeAppearInLogChat(String name) {
        commonPage.waitUntilElementIsVisible("div[class='chat__head'] h1[class='name'] span");
        WebElement userName = getDriver().findElement(By.cssSelector("div[class='chat__head'] h1[class='name'] span"));
        String userNameText = userName.getText();
        if (userNameText.contentEquals(name)) {
            System.out.println(userNameText + " pass");
            return true;
        }
        System.out.println(userNameText + " fail");
        return false;
    }

    public boolean shouldSeeTextOnButtonChangeTo(String text) {
        WebElement clickedDestinyBtn = getDriver().findElement(By.cssSelector("button[class='mdc-button mdc-button--unelevated mdc-btn--pink'] .mdc-button__label"));
        String textOnDestinyBtn = clickedDestinyBtn.getText();
        if (textOnDestinyBtn.contentEquals(text)) {
            System.out.println(textOnDestinyBtn + " pass");
            return true;
        }
        System.out.println(textOnDestinyBtn + " fail");
        return false;
    }

    public boolean shouldSeeWomanNameOnCrossYourDestiniesScreen(String name) {
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='request__head'] h5"))));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(name)) {
                System.out.println(name);
                ArrayList<WebElement> Discuss = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='request__foot'] a[class='mdc-button mdc-button--unelevated']")));
                Discuss.get(i).click();
            }
            return true;

        }
        return false;
    }

    public boolean shouldSeeWomanNameOnMessageScreen(String name) {
        commonPage.waitUntilElementIsVisible("div[class='message__head'] h5");
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(name)) {
                if (i == 0) {
                    System.out.println(name);
                    System.out.println(i + " pass");
                    ArrayList<WebElement> message = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='clickable-overlay']")));
                    message.get(i).click();
                    return true;
                }
                ArrayList<WebElement> acceptMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
                String commercialMess = acceptMess.get(0).getText();
                if (i == 1 && commercialMess.contentEquals("L'Equipe Mektoube")) {
                    System.out.println(commercialMess + " " + i);
                    ArrayList<WebElement> message = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='clickable-overlay']")));
                    message.get(i).click();

                    return true;
                }

            }
        }
        return false;
    }

    public boolean shouldSeeDiscussAndSmileButton() {

        ArrayList<WebElement> DiscussButton = new ArrayList<>(getDriver().findElements(By.cssSelector(".user__head button[class='mdc-button mdc-button--unelevated']")));
        if (DiscussButton.size() == 0) {
            System.out.println(DiscussButton.size() + " fail huhu");
            return false;
        }
        ArrayList<WebElement> smileButton = new ArrayList<>(getDriver().findElements(By.cssSelector(".user__head button[class='mdc-button mdc-button--outline mdc-button--unelevated']")));
        if (smileButton.size() == 0) {
            System.out.println(smileButton.size() + " fail huhu");
            return false;
        }
        System.out.println(DiscussButton + " pass");
        System.out.println(smileButton + " pass");
        return true;
    }


    public boolean shouldSendMessageAsUsual(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement sentMess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='chat__message chat__message--host']//*[text() = '" + text + "']")));

        ArrayList<WebElement> tickOfSentMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='chat__row']:last-child div[class='chat__message chat__message--host'] i.material-icons")));
        if (tickOfSentMess.size() != 1) {
            System.out.println(tickOfSentMess.size());
            return false;
        }
        System.out.println(sentMess + " pass");
        System.out.println(tickOfSentMess.size() + " pass");
        return true;
    }


    public boolean shouldSeeRequestContactMessageBelowProfileAvatar(String mess) {

        commonPage.waitUntilElementIsVisible(".destiny--request-mesage");
        commonPage.waitUntilElementIsVisible(".request-message");
        WebElement requestMessage = getDriver().findElement(By.cssSelector("div[class='destiny--request-mesage'] div[class='request-message'] p"));
        String requestMessageText = requestMessage.getText();
        if (requestMessageText.contentEquals(mess)) {
            System.out.println(requestMessageText);
            return true;
        }
        System.out.println(requestMessageText);
        return false;
    }


    public boolean doNotSeeNameOfOnContactRequestList(String name) {
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        ArrayList<WebElement> noContactRequest = new ArrayList<>(getDriver().findElements(By.cssSelector("section.section--requests div.section__body div.no-items__inner")));
        if (noContactRequest.size() > 0) {
            return true;
        }

        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='request__head'] h5")));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(name)) {
                System.out.println(i + " fail");
                return false;
            }
            System.out.println(i + " true");
        }

        return true;
    }

    public void clickDiscussAgainWithWomanThatAlreadyDeleteMessage() {
        String savedName = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('accountName')");
        System.out.println(savedName);
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='request__head'] h5")));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(savedName)) {
                System.out.println(savedName);
                ArrayList<WebElement> acceptMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='request'] div[class='request__foot'] a[class='mdc-button mdc-button--unelevated']")));
                acceptMess.get(i).click();


            }

        }
    }

    public void getProfileManeOn(String element) {
        String cssSelector = TestDataService.properties.getProperty(element);
        if (cssSelector == null) {
            cssSelector = element;
        }
        WebElement accountName = getDriver().findElement(By.cssSelector(cssSelector));
        String accountName1 = accountName.getText();
        System.out.println(accountName1 + " " + "hehehihi");
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('accountName','" + accountName1 + "')");

    }

    public boolean shouldSeeWomanNameThatDeletedMessageOnMessageScreen() {
        String abc = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('accountName')");
        System.out.println(abc);
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(Introspector.decapitalize(abc))) {
                if (i == 0) {
                    System.out.println(Introspector.decapitalize(abc));
                    System.out.println(i + " pass");
                    ArrayList<WebElement> message = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='clickable-overlay']")));
                    message.get(i).click();
                    return true;
                }
                ArrayList<WebElement> acceptMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
                String commercialMess = acceptMess.get(0).getText();
                if (i == 1 && commercialMess.contentEquals("L'Equipe Mektoube")) {
                    System.out.println(commercialMess + " " + i);
                    ArrayList<WebElement> message = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='clickable-overlay']")));
                    message.get(i).click();

                    return true;
                }

            }
        }
        return false;
    }

    public boolean doNotSeeNameOfOnMessageScreen(String name) {
        commonPage.waitUntilElementIsVisible("Messages");
        commonPage.click("Messages");
        ArrayList<WebElement> noMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='chat chat--empty']")));
        if (noMess.size() > 0) {
            System.out.println(" empty message");
            return true;
        } else {
            ArrayList<String> userNames = new ArrayList<>();
            ArrayList<WebElement> userNameList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
            for (WebElement userName : userNameList) {
                String textOfUserName = userName.getText();
                userNames.add(textOfUserName);
            }
            System.out.println(userNames);

            for (int i = 0; i < userNames.size(); i++) {

                if (userNames.get(i).contentEquals(name)) {
                    System.out.println(i + " fail");
                    return false;
                }
                System.out.println(i + " true");
            }

            return true;
        }
    }

    public void logOutCurrentMaleAccountAndLoginWithWomanAccount() {
        commonPage.logoutCurrentFemaleAccount();
//        commonPage.clickToLinkSeConnecter();
        commonPage.loginWithAccountAndPassword("mektoubitest@gmail.com", "Mektoubi2017");
//        loginInByWomanAccount();
    }

    public boolean shouldSeeContactRequestIsBlocked() {
        commonPage.click(".user__header i.material-icons");
        commonPage.waitUntilElementIsVisible("Profile");
        commonPage.clickOnWhichIndexIs("Profile", 0);
        commonPage.waitUntilElementIsVisible(".user__actions");
        commonPage.click("destinyBtn");
        commonPage.waitAboutSecond(2);
        ArrayList<WebElement> contactRequestModal = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='setting--modal contact-request-modal small-form-modal mobile-nofull avoid-keyboard-space modal is--opened']")));
        if (contactRequestModal.size() > 0) {
            System.out.println(contactRequestModal.size() + " fail");
            return false;
        }
        System.out.println(contactRequestModal.size() + " pass");
        return true;
    }

    public void searchWomanAccountAndSendInspirationalText(String womanAccount) throws AWTException {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.insertIntoField(womanAccount, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitUntilElementIsVisible("submitFilter");
        commonPage.click("submitFilter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + womanAccount + "']")));
        account.click();
        commonPage.waitUntilElementIsVisible("destinyBtn");
        commonPage.click("destinyBtn");
        assertThat(checkIfInspirationalTextCanChange(), is(equalTo(true)));
        assertThat(choseInspirationalText(), is(equalTo(true)));
    }

    public void searchWomanAccountAndContactRequest(String womanAccount) {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.insertIntoField(womanAccount, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + womanAccount + "']")));
        account.click();
        commonPage.waitUntilElementIsVisible("destinyBtn");
        commonPage.click("destinyBtn");
        commonPage.waitUntilElementIsVisible("textarea[placeholder='Donnez-lui envie de répondre et personnalisez votre message ! ']");
        commonPage.insertIntoField("hi, this is test greeting", "textarea[placeholder='Donnez-lui envie de répondre et personnalisez votre message ! ']");
//        commonPage.waitAboutSecond(1);
//        assertThat(shouldNotShouldInspirationToolTip(), is(equalTo(true)));
        commonPage.click("button[type='submit']");
    }

    public boolean shouldNotShouldInspirationToolTip() {
        ArrayList<WebElement> InspirationToolTip = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='inpirational-tooltip show']")));
        if (InspirationToolTip.size() > 0) {
            System.out.println(InspirationToolTip.size());
            return false;
        }
        System.out.println(InspirationToolTip.size());
        return true;
    }

    public void clickOnUserProfileLinkAndShouldSeeDiscussAndSmileButton() {
        commonPage.click("h1[class='name'] span");
        commonPage.waitUntilElementIsVisible(".user__actions");
        assertThat(shouldSeeDiscussAndSmileButton(), is(equalTo(true)));
    }

    public void clickToSeeProfileOfTheManWhoSendContactRequest() {
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        commonPage.waitUntilElementIsVisible("ToSeeProfile");
        commonPage.click("ToSeeProfile");
    }

    public void clickDécouvrirDesProfilsOnCroisezVosDestinsScreen() {
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        commonPage.waitUntilElementIsVisible("DecouvrirDesProfilsBtn");
        commonPage.click("DecouvrirDesProfilsBtn");

    }

    public void deleteMessageOf(String name) {
        commonPage.waitUntilElementIsVisible("div[class='message__head'] h5");
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(name)) {
                ArrayList<WebElement> acceptMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='clickable-overlay']")));
                acceptMess.get(i).click();
                commonPage.waitUntilElementIsVisible("button[class='mdc-icon-button material-icons']");
                commonPage.click("button[class='mdc-icon-button material-icons']");
                commonPage.waitUntilElementIsVisible("li[class='mdc-list-item']:nth-child(5)");
                commonPage.click("li[class='mdc-list-item']:nth-child(5)");
                commonPage.waitUntilElementIsVisible("button[class='mdc-button mdc-button--unelevated mdc-btn--red'] span[class='mdc-button__label']");
                commonPage.click("button[class='mdc-button mdc-button--unelevated mdc-btn--red'] span[class='mdc-button__label']");


            }

        }
    }

    public boolean shouldNotSeeWomanNameOnCrossYourDestiniesScreen(String name) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='request__head'] h5"))));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(name)) {
                System.out.println(name);
                System.out.println(userNames.get(i));
                return false;
            }
        }
        return true;
    }

    public boolean shouldSeeUnreadMessageOfOnMessageScreen(String name) {
        commonPage.waitUntilElementIsVisible("Messages");
        commonPage.click("Messages");
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);

        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message__head']//*[text() = '" + name + "']")));

        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='message__head'] h5"))));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(name)) {

                ArrayList<WebElement> messageContentElementList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__content']")));
                // Because can't click on div[class='message__content'] anymore =>> new array list div[class='clickable-overlay']
                ArrayList<WebElement> messageElementClickAbleList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='clickable-overlay']")));
                if (messageContentElementList.get(i).findElements(By.cssSelector("div[class='meta'] span[class='unread-dot']")).size() > 0) {

                    System.out.println(i);
                    messageElementClickAbleList.get(i).click();
                    return true;
                }
            }
        }
        return false;
    }

    public void acceptContactRequestOfToAnswerLater(String account) {
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='request__head'] h5"))));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(account)) {
                ArrayList<WebElement> acceptMess = new ArrayList<>(getDriver().findElements(By.cssSelector("a[class='mdc-button mdc-button--unelevated']")));
                acceptMess.get(i).click();
                commonPage.waitUntilElementIsVisible("button[class='mdc-button mdc-button--unelevated mdc-btn--white full-wrap-width']");
                commonPage.click("button[class='mdc-button mdc-button--unelevated mdc-btn--white full-wrap-width']");

            }

        }

    }

    public void refuseContactRequestOf(String account) {
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='request__head'] h5")));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(account)) {
                System.out.println(userNames.get(i));
                ArrayList<WebElement> refuse = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='request'] div[class='request__foot'] a[class='mdc-button mdc-button--outline mdc-button--unelevated']")));
                refuse.get(i).click();


            }

        }
    }

    public boolean checkIfIndicatorDisplayRightForNewContactRequest() {
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> userNameList1 = new ArrayList<>(wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='request__head'] h5"))));
        String lastContactRequest = userNameList1.get(0).getText();
        commonPage.click("DiscoveriesScreenBtn");
        commonPage.click("CrossYourDestiniesTextLink");
        ArrayList<WebElement> userNameList2 = new ArrayList<>(wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='request__head'] h5"))));
        String lastContactRequest2 = userNameList2.get(0).getText();
        if (lastContactRequest.equals(lastContactRequest2)) {
            try {
                WebDriverWait wait2 = new WebDriverWait(getDriver(), 5);
                ArrayList<WebElement> redmark = new ArrayList<>(wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span[class='mark red']"))));
                if (redmark.size() > 0) {
                    System.out.println(lastContactRequest + " " + lastContactRequest2);
                    System.out.println("still show red mark without contact request " + redmark );
                    return false;
                }
            } catch (Exception e) {
                System.out.println(lastContactRequest + " " + lastContactRequest2);
                System.out.println("ok, not show red mark" );
                return true;

            }
        }
        else {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            WebElement redmark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='mark red']")));
            System.out.println(lastContactRequest + " " + lastContactRequest2);
            System.out.println("ok, show red mark when have new contact request " + redmark );
            return true;
        }
        return false;
    }

    public boolean thePageShowsPopup() {
        try {
            getDriver().findElement(By.cssSelector("div.photo-info--modal.request-info--modal.modal.is--opened"));
            System.out.println("show popup");
            return true;
        } catch (Exception e) {
            System.out.println("Dont show pop up");
            return false;
        }
    }

    public boolean thePageDontShowDuplicateInvitations() {
        ArrayList<WebElement> requestContactUser = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component  > div.request > div.request__head > h5")));
        Set<WebElement> set = new HashSet<WebElement>(requestContactUser);
        List<WebElement> newUserList = new ArrayList<WebElement>(set);
        if (requestContactUser.size() == newUserList.size()) {
            System.out.println(":))))))))))))Dont have duplicate profile on the discovery");
        } else {
            System.out.println(":((((((((((Have duplicate profile on the discovery");
        }
        return true;
    }

    public void thePageShowsAGreenAcceptButtonAndAWhiteRefuseButtonInEachInvitations(){
        //show green accept button
        String greenColorString = getDriver().findElement(By.cssSelector("div[class='infinite-scroll-component '] div.request:nth-child(1) a[class='mdc-button mdc-button--unelevated']")).getCssValue("background-color");
        System.out.println("background color(green) "+greenColorString);
        ArrayList<WebElement> acceptButtonColorList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='infinite-scroll-component '] div.request:nth-child(1) a[class='mdc-button mdc-button--unelevated']")));
        for(WebElement user: acceptButtonColorList){
            if(user.getCssValue("background-color").equals("rgba(36, 207, 95, 1)")){
                System.out.println("pass");
            }else{
                System.out.println("faild");
                assertEquals("rgba(36, 207, 95, 1)", greenColorString);
            }
        }
        //show white refuse button
        String whiteColorString = getDriver().findElement(By.cssSelector("div[class='infinite-scroll-component '] div.request:nth-child(2) a[class='mdc-button mdc-button--unelevated']")).getCssValue("background-color");
        System.out.println("background color(white) "+whiteColorString);
        ArrayList<WebElement> refuseButtonColorList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='infinite-scroll-component '] div.request:nth-child(2) a[class='mdc-button mdc-button--unelevated']")));
        for(WebElement user: refuseButtonColorList){
            if(user.getCssValue("background-color").equals("rgba(255, 255, 255, 1)")){
                System.out.println(user.getCssValue("background-color"));
                System.out.println("pass");
            }else{
                System.out.println(user.getAttribute("background-color"));
                System.out.println("faild");
                assertEquals("error", whiteColorString);
            }
        }
    }

    public void theRequestContactPageDontShowThisPerson() {
        String cancelName = null;//or resposeLater or refuse or Nowanswer
        try {
            cancelName = noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("cancel name from varFile.txt file: " + cancelName);
        ArrayList<WebElement> requestContactUser = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component  > div.request > div.request__head > h5")));
        int count = 0;
        for (WebElement user : requestContactUser) {
            if (cancelName.equals(user)) {
                count++;
                System.out.println("==>:(((((((( ");
            }
        }
        if (count == 0) {
            System.out.println("==>:)))))))))))) dont show this person");
        }
    }

    public void theRequestContactPageStillShowsThisPerson() {
        String cancelName = null;
        try {
            cancelName =noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<WebElement> requestContactUser = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component  > div.request > div.request__head > h5")));
        int count = 0;
        for (WebElement user : requestContactUser) {
            if (user.getText().equals(cancelName)) {
                count++;
                System.out.println("Cancel Passed");
                getDriver().close();
                return;
            }
        }
        if(count==0){
            System.out.println("ERROR");
            assertEquals("error ",cancelName);
        }
    }

    public void theMessagePageDontHaveThisPerson(){
        //read var form varFile.txt
        String refuseName = null;
        try {
            refuseName = noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("==>refuse name from varFile.txt file: " + refuseName);
        //
        int count=0;
        System.out.println("...saving all messages into messList...");
        ArrayList<WebElement> messList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.messages__body > div > div > div.message__content > div >h5")));
        System.out.println("...starting scan...");
        for (WebElement name : messList) {
            System.out.println("NAME.getText()=="+name.getText());
            //assertEquals(answerLaterName,name.getText());
            if (name.getText().equals(refuseName)) {
                count++;
                System.out.println("ERROR");
                assertEquals(refuseName, "error");
                return ;
            }
        }
        if(count==0){
            System.out.println("refuse passed");
        }
    }

    public void thePageShowsFiveLastRefusalsProfile() {
        ArrayList<WebElement> lastRefuseList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.modal--body > div > div.request__head > h5")));
        System.out.println("Five last refuse user are ");
        for (WebElement userName : lastRefuseList) {
            System.out.println(userName.getText());
        }
    }

    public void theLastRefusalsListDontShowThisPerson(){
        String refuseName = null;
        try {
            refuseName = noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count=0;
        ArrayList<WebElement> lastRefuseList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.modal--body > div.request > div.request__head > h5")));
        for(WebElement user: lastRefuseList){
            if(user.getText().equals(refuseName)){
                count++;
                System.out.println("error");
                assertEquals(refuseName,"erorr");
            }
        }
        if(count==0){
            System.out.println("-->refuse person in 5 list successful");
        }
    }

    public void theLastRefusalsListStillShowThisPerson(){
        String refuseName = null;
        try {
            refuseName = noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count=0;
        ArrayList<WebElement> lastRefuseList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.modal--body > div.request > div.request__head > h5")));
        for(WebElement user: lastRefuseList){
            if(user.getText().equals(refuseName)){
                count++;
                System.out.println("********** "+user.getText());
                System.out.println("-->refuse person in 5 list successful");
                break;
            }
        }
        if(count==0){
            System.out.println("error");
            assertEquals(refuseName,"erorr");
        }
    }

    public void thePageShowsAllInvitationsArePresent() {
        ArrayList<WebElement> requestContactUser = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component  > div.request > div.request__head > h5")));
        System.out.println("Size: " + requestContactUser.size());
        for (WebElement user : requestContactUser) {
            System.out.println(user.getText());
        }
        getDriver().close();
    }

    public void theRequestContactTextHavePinkDot(){
        Boolean pinkDotClass=null;
        try{
            pinkDotClass = getDriver().findElement(By.cssSelector("span[class='mark red']")).isDisplayed();
            System.out.println("Check have pink dot is successfull");
            getDriver().close();
        }catch (Exception e){
            System.out.println("Dont have pink dot");
            assertEquals(pinkDotClass.toString(),"error");
        }
    }

    public void theRequestContactTextDontHavePinkDot(){
        Boolean pinkDotClass=null;
        try{
            pinkDotClass = getDriver().findElement(By.cssSelector("span[class='mark red']")).isDisplayed();
            System.out.println("faild");
            assertEquals(pinkDotClass,"error");
        }catch (Exception e){
            System.out.println("Pink dot dont have=> successful");

        }
        getDriver().close();
    }

    //up date 26/2/2020
    public void theMessagePageHaveThisPerson() {
        //getDriver().findElement(By.cssSelector("a[href='/main/messages']")).click();
        //read var form varFile.txt
        String answerLaterName = null;
        try {
            answerLaterName = noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("==>answer later name from varFile.txt file: " + answerLaterName);

        //scroll to get all message
        //not need element but need to use function
//        String a="";
//        MessageModule messageModule = new MessageModule();
//        try {
//            messageModule.scrollSpecialElement(a);
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }

        //search by filter by non read message
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Messages']")));
        commonPage.click("RoundButton");
        commonPage.click("unreadMessage");
        commonPage.waitAboutSecond(2);
        //scroll all message items, messageItem
        try {
            messageModule.scrollSpecialElement("messageItem");
        } catch (AWTException e) {
            e.printStackTrace();
        }
        int count = 0;
        System.out.println("...saving all messages into messList...");
        ArrayList<WebElement> messList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.messages__body > div > div > div.message__content > div >h5")));
        System.out.println("...starting scan...");
        for (WebElement name : messList) {
            System.out.println("NAME.getText()==" + name.getText());
            //assertEquals(answerLaterName,name.getText());
            if (name.getText().equals(answerLaterName)) {
                count++;
                System.out.println("==>:)) anwser later passed");
                getDriver().close();
                return;
            }
        }
        if (count == 0) {
            System.out.println("ERROR");
            assertEquals( answerLaterName,"Dont have this person in message ");
        }
    }
    public void clickOnAvatarOnChatHeader() {
        commonPage.waitUntilElementIsVisible("div[class='chat__head'] span[class='avatar avatar-box-backgrounded']");
        commonPage.click("div[class='chat__head'] span[class='avatar avatar-box-backgrounded']");
    }

    public void clickOnAvatarNextToEachChatMessage() {
        commonPage.waitUntilElementIsVisible("div[class='chat__message chat__message--guest'] span[class='avatar avatar-box-backgrounded']");
        commonPage.click("div[class='chat__message chat__message--guest'] span[class='avatar avatar-box-backgrounded']");
    }

    public void refuseFirstCrossAndSeeLastFiveRefusalsButton() {
        WebElement firstCross = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.infinite-scroll-component  div.request:nth-child(1)"));
        firstCross.findElement(org.openqa.selenium.By.xpath("//span[text()='Refuser']")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement lastFiveRefusal = wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//span[text()='5 derniers refus']")));
    }

    public void acceptContactRequestNowOfInRefuseList(String user){
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        commonPage.click("refuseListLink");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.modal--body div.request h5"))));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(user)) {
                ArrayList<WebElement> acceptMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div.modal--body div.right-arrow span")));
                acceptMess.get(i).click();
                commonPage.waitUntilElementIsVisible("button[class='mdc-button mdc-button--unelevated full-wrap-width']");
                getDriver().findElement(By.cssSelector("button[class='mdc-button mdc-button--unelevated full-wrap-width']")).click();
            }

        }
    }
}


