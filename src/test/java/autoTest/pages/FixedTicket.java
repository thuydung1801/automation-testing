package autoTest.pages;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


import autoTest.service.TestDataService;
import cucumber.api.java.mk_latn.No;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import java.util.ArrayList;

public class FixedTicket extends PageObject {
    MektoubeCommonPage commonPage = new MektoubeCommonPage();
    NotificationPage noti = new NotificationPage();

    public void goBack() {
        ((JavascriptExecutor) getDriver()).executeScript("window.history.go(-1)");
    }

    public boolean shouldSeeUniqueSavedSearchName() {

        ArrayList<String> savedSearchList = new ArrayList<>();
        ArrayList<WebElement> savedSearchListElement = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='list-toggle-wrap active toggle-list-search'] .filter__item h5")));
        for (WebElement searchName : savedSearchListElement) {
            String textSearchName = searchName.getText();
            savedSearchList.add(textSearchName);
        }
        System.out.println(savedSearchList);
        ArrayList<String> savedSearchList2 = new ArrayList<>();
        savedSearchList2.add(savedSearchList.get(0));

        for (int i = 1; i < savedSearchList.size(); i++) {
            for (int j = 0; j < savedSearchList2.size(); j++) {
                if (savedSearchList.get(i).contentEquals(savedSearchList2.get(j))) {
                    System.out.println(savedSearchList2 + " duplicate");
                    return false;
                }
            }
            savedSearchList2.add(savedSearchList.get(i));

        }
        return true;

    }

    public void editSavedSearchHasName(String name) {
        ArrayList<WebElement> SavedSearchItem = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='list-toggle-wrap active toggle-list-search'] .filter__item")));
        System.out.println(SavedSearchItem.size());
        for (int i = 0; i < SavedSearchItem.size(); i++) {

            String textSearchName = SavedSearchItem.get(i).findElement(By.cssSelector("h5")).getText();
            if (textSearchName.contentEquals(name)) {
                SavedSearchItem.get(i).findElement(By.cssSelector(".right-value-arrow i.material-icons.right-icon")).click();

                System.out.println("đã click vào dấu 3 chấm");
                commonPage.waitUntilElementIsVisible("div[role='presentation'] ul li:nth-child(2)");
                commonPage.click("div[role='presentation'] ul li:nth-child(2)");
                commonPage.waitAboutSecond(1);
                System.out.println("đã click vào chữ edit");

                WebElement toDayIsBirthday = getDriver().findElement(By.cssSelector("div[class='list-toggle-wrap active toggle-criteria-simple'] .filter .filter__item:nth-child(4) input[type='radio']"));
                JavascriptExecutor jse = (JavascriptExecutor) getDriver();
                jse.executeScript("arguments[0].scrollIntoView()", toDayIsBirthday);

                getDriver().findElement(By.cssSelector("div[class='list-toggle-wrap active toggle-criteria-simple'] .filter .filter__item:nth-child(3) input[type='radio']")).click();
                getDriver().findElement(By.cssSelector(".search__list button[type='submit']")).click();

                break;
            }
            break;
        }

    }

    public void editNameOfSavedSearchHasNameTo(String name1, String name2) {
        ArrayList<WebElement> SavedSearchItem = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='list-toggle-wrap active toggle-list-search'] .filter__item")));
        System.out.println(SavedSearchItem.size());
        for (int i = 0; i < SavedSearchItem.size(); i++) {

            String textSearchName = SavedSearchItem.get(i).findElement(By.cssSelector("h5")).getText();
            if (textSearchName.contentEquals(name1)) {
                SavedSearchItem.get(i).findElement(By.cssSelector(".right-value-arrow i.material-icons.right-icon")).click();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("div[role='document'] ul li:nth-child(3)")).click();
                try {
                    Thread.sleep(3 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector(".save-filter-name input[type='text']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
                try {
                    Thread.sleep(10 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector(".save-filter-name input[type='text']")).sendKeys(name2);
                getDriver().findElement(By.cssSelector(".save-filter__bottom button[type='submit']")).click();
                break;
            }

        }
    }

    public boolean shouldSeeUniqueSavedSearchNameContain(String name) {
        ArrayList<String> savedSearchList = new ArrayList<>();
        ArrayList<WebElement> savedSearchListElement = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='list-toggle-wrap active toggle-list-search'] .filter__item h5")));
        for (WebElement searchName : savedSearchListElement) {
            String textSearchName = searchName.getText();
            savedSearchList.add(textSearchName);
        }
        System.out.println(savedSearchList);

        for (int i = 0; i < savedSearchList.size(); i++) {
            if (savedSearchList.get(i).contentEquals(name)) {
                System.out.println(savedSearchList.get(i));
                return true;
            }
            System.out.println(savedSearchList.get(i));

        }

        return false;

    }

    public void deleteTheSearchHasNameIs(String name) {
        ArrayList<WebElement> SavedSearchItem = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='list-toggle-wrap active toggle-list-search'] .filter__item")));
        System.out.println(SavedSearchItem.size());
        for (int i = 0; i < SavedSearchItem.size(); i++) {

            String textSearchName = SavedSearchItem.get(i).findElement(By.cssSelector("h5")).getText();
            if (textSearchName.contentEquals(name)) {
                SavedSearchItem.get(i).findElement(By.cssSelector(".right-value-arrow i.material-icons.right-icon")).click();
                commonPage.waitUntilElementIsVisible("div[role='document'] ul li:nth-child(1)");
                commonPage.click("div[role='document'] ul li:nth-child(1)");

            }
        }

    }

    public void profileJustShowsNextProfileIcon() {
        try {
            assertTrue(getDriver().findElement(By.cssSelector("a.control-button.prev-nav > span > i")).isEnabled());
        } catch (Exception e) {
            assertTrue(getDriver().findElement(By.cssSelector("a.control-button.next-nav > span > i")).isEnabled());
        }
    }

    public void clickOnLastProfileInDiscovery() {
        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li")));
        getDriver().findElement(By.cssSelector("#" + userList.get(userList.size() - 1).getAttribute("id"))).click();
    }

    public void profileJustShowsPreviousProfileIcon() {
        try {
            assertTrue(getDriver().findElement(By.cssSelector("a.control-button.next-nav > span > i")).isEnabled());
        } catch (Exception e) {
            assertTrue(getDriver().findElement(By.cssSelector("a.control-button.prev-nav > span > i")).isEnabled());
        }
    }

    public void profileShowPreviousProfileAndNextProfile() {
        assertTrue(getDriver().findElement(By.cssSelector("a.control-button.next-nav > span > i")).isEnabled());
        assertTrue(getDriver().findElement(By.cssSelector("a.control-button.prev-nav > span > i")).isEnabled());
    }

    public void theLastMessageMustBeDisplayed() {
        ArrayList<WebElement> rowMessList = new ArrayList<>(getDriver().findElements(By.cssSelector("span.mes-body-text")));
        int rowNum = rowMessList.size();
        String lastRowText = rowMessList.get(rowNum - 1).getText();
        String messShow = getDriver().findElement(By.cssSelector("div[style='position: relative;'] div.message:nth-child(1) div.message__body")).getText();
        assertEquals(lastRowText, messShow);
    }

    public void theCancelGifIsEnable() {
        assertTrue(getDriver().findElement(By.cssSelector("span.btn-send-gif.active")).isEnabled());
    }

    public void thePageHaveCriteriaNumberInDiscoveryHaveToZeroByDefault() {
        assertEquals("0", getDriver().findElement(By.cssSelector("div.badge")).getText());
    }

    public void saveDataToCheckAgainThatAreAnd(String value1, String value2) {
        String cssSelector1 = TestDataService.properties.getProperty(value1);
        String cssSelector2 = TestDataService.properties.getProperty(value2);
        System.out.println(getDriver().findElement(By.cssSelector(cssSelector1)).getText() + "-" + getDriver().findElement(By.cssSelector(cssSelector2)).getText());
        noti.WriteToFile(getDriver().findElement(By.cssSelector(cssSelector1)).getText() + "-" + getDriver().findElement(By.cssSelector(cssSelector2)).getText());
    }

    public void thePaysAndRegionLabelStillDisplayTheSelectedSelection() {
        String textValue = "";
        try {
            textValue = noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(textValue);
        String[] textValueArr = textValue.split("-");
        System.out.println("1: " + textValueArr[0] + "*******" + "2: " + textValueArr[1]);
        assertEquals(textValueArr[0], getDriver().findElement(By.cssSelector("div.filter > div.filter__item:nth-child(4) > .filter__item-aside > span")).getText());
        assertEquals(textValueArr[1], getDriver().findElement(By.cssSelector("div.filter > div.filter__item:nth-child(5) > .filter__item-aside > span")).getText());
    }

    public void clickOnFirstProfileInDiscoveryNonSaveName() {
        getDriver().findElement(By.cssSelector("ul.list-profiles > li:nth-child(1) > a.profile  > div.profile__content > h5")).click();
    }

    public void srollOnTop(int numb) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,-" + numb + ")");
    }

    public void srollOnTopByRobot(int numb) throws AWTException {
//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        Long value = (Long) executor.executeScript("return window.pageYOffset;");
//        System.out.println("pre location of page: "+value);

        //use robot to control mouse to scroll special element in page
        Robot robot = new Robot();
        //find location want to move mouse to
        ArrayList<WebElement> messRowList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.chat__row.animated")));
        NotificationPage noti = new NotificationPage();
        noti.WriteToFile(messRowList.get(messRowList.size() - 1).getAttribute("id"));
        WebElement messageRowArea = getDriver().findElement(By.cssSelector("div.chat__body-rows div.chat__row.animated:nth-child(" + (messRowList.size() - 1) + ")"));
        //get location when move mouse into then can scroll
        Point testimoniaAreaPoint = messageRowArea.getLocation();
        int xcord = testimoniaAreaPoint.getX() + 100;// get x location of testimonial
        int ycord = testimoniaAreaPoint.getY() + 200;// get y location of testimonial
        robot.mouseMove(xcord, ycord);// move mouse into above location (x,y)
        try {
            Thread.sleep(1 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        robot.mouseMove(xcord, ycord);// move mouse into above location (x,y)
        try {
            Thread.sleep(1 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(xcord + "---" + ycord);

        //wheelAmt: + towards the user|| - away from the user
        robot.mouseWheel(-numb);
    }

    public void theLastMessageMustBeNotDisplay() throws Exception {
        NotificationPage noti = new NotificationPage();
        //assertFalse(getDriver().findElement(By.cssSelector("#"+noti.ReadFromFile())).isEnabled());
        assertTrue(getDriver().findElement(By.cssSelector("div[class='scolldown-button visible']")).isEnabled());
        //
//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        Long value = (Long) executor.executeScript("return window.pageYOffset;");
//        System.out.println("location of page: "+value);


    }

    public void theQuoteMessageAndLastMessageMustBeCorresponding() {
        ArrayList<WebElement> rowMessList = new ArrayList<>(getDriver().findElements(By.cssSelector("span.mes-body-text")));
        int rowNum = rowMessList.size();
        String lastRowText = rowMessList.get(rowNum - 1).getText();
        String messShow = getDriver().findElement(By.cssSelector("div[style='position: relative;'] div.message:nth-child(1) div.message__body")).getText();
        //if is short message
        assertEquals(lastRowText, messShow);
//        //if is long message
//        lastRowText.contains(messShow.substring(0,messShow.length()-3));
    }

    public void thePageDontShowSmileAndDiscussButtons() {
        Boolean userActionButtons = null;
        try {
            userActionButtons = getDriver().findElement(By.cssSelector("user__actions")).isDisplayed();
        } catch (Exception e) {
            System.out.println("DONE ");
            return;
        }
        if (userActionButtons == true) {
            assertEquals(false, true);
        }
    }

    public void theSelectionListContainsInLine(String selectionText, int lineNum) {
        if (lineNum == 1) {
            assertEquals(selectionText, getDriver().findElement(By.cssSelector("ul.mdc-list li:nth-child(" + lineNum + ") a.mdc-list-item__text")).getText());
            return;
        }
        assertEquals(selectionText, getDriver().findElement(By.cssSelector("ul.mdc-list li:nth-child(" + (lineNum + 1) + ") a.mdc-list-item__text")).getText());
    }

    public void thePageShowSmileAndDiscussButtons() {
        ArrayList<WebElement> buttonCountList = new ArrayList<>(getDriver().findElements(By.cssSelector("button i.material-icons")));
        assertEquals(2, buttonCountList.size());
    }

    public void theMessageNunberFromAre(String name, int numb) {
        //get number of first message but that is not the most way
        String messNumb = getDriver().findElement(By.cssSelector("div[style='position: relative;'] div[class='message message--unread']:nth-child(1) span.unread-dot")).getText();
        assertEquals(numb, Integer.parseInt(messNumb));
    }

    public void checkEphemeralReportModal() {
        assertEquals("Signaler cette photo", getDriver().findElement(By.cssSelector("div.modal--header__title h2")).getText());

        assertEquals("Vous estimez que cette photo est incorrecte.", getDriver().findElement(By.cssSelector("div.modal--header__title p")).getText());

        assertEquals("Votre signalement est et restera anonyme.", getDriver().findElement(By.cssSelector("div.modal--header__title div")).getText());

        assertEquals("ANNULER", getDriver().findElement(By.cssSelector("form button:nth-child(1)")).getText());

        assertEquals("VALIDER", getDriver().findElement(By.cssSelector("form button:nth-child(2)")).getText());

    }

    public boolean shouldSeeMetaTag(String metaTag) {
        commonPage.waitUntilElementIsVisible("div[class='header__inner']");
//        WebElement meta = getDriver().findElement(By.xpath("//*[contains(text(),'Mektoube.fr – Site N°1 de la rencontre Musulmane et Maghrébine')]"));
        WebElement element = getDriver().findElement(By.tagName("title"));
        String meta = element.getAttribute("textContent");
        if (meta.contentEquals(metaTag)) {
            System.out.println(element.getAttribute("textContent"));
            return true;
        }
        System.out.println(element.getAttribute("textContent"));
        return false;

    }

    public void timeOfQuoteMessageLastMessageAndRealTimeHaveSame() {

        //get time in last message
        ArrayList<WebElement> chat_rows = new ArrayList<>(getDriver().findElements(By.cssSelector("div.chat__row")));
        String lastMessageTime = getDriver().findElement(By.cssSelector("div.chat__body-rows div.chat__row:nth-child(" + (chat_rows.size()) + ") span.mes-time-state span.time")).getText();
        System.out.println("last message time: " + lastMessageTime);

        //get time in current message Quote
        String quoteMessageTime = getDriver().findElement(By.cssSelector("div[style='position: relative;'] div.message:nth-child(1) div.meta__text")).getText();
        System.out.println("quote message time: " + quoteMessageTime);

        // get current time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("real time: " + dtf.format(now));

        assertEquals(dtf.format(now), lastMessageTime);
        assertEquals(dtf.format(now), quoteMessageTime);
    }

    public void profileStatusMustMatchInDiscoveryProfileAndMessage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        ArrayList<WebElement> userList = new ArrayList<>(getDriver().findElements(By.cssSelector("li.profile--item")));
        ArrayList<WebElement> awayUserList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.profile__status div[class='status status--away']")));

        System.out.println("size::" + awayUserList.size());
        while (awayUserList.size() == 0) {
            System.out.println("size::" + awayUserList.size());
            if (awayUserList.size() == 0) {
                // This  will scroll down the page by  1000 pixel vertical
                js.executeScript("window.scrollBy(0,1000)");
                commonPage.waitAboutSecond(1);
            } else {

                //click on first profile
                commonPage.click("firstProfileInDiscovery");


//                for(WebElement profile: userList){
//                    System.out.println("continue");
//                    try{
//                        if(profile.findElement(By.cssSelector("div.profile__status div[class='status status--away']")).isEnabled()){
//
//                            System.out.println("Click on first away profile in discovery...");
//                            commonPage.click("href=['"+profile.findElement(By.cssSelector("a.profile")).getAttribute("href")+"']");
//                            assertEquals(true, getDriver().findElement(By.cssSelector("div.user__avatar div[class='status status--away']")).isEnabled());
//
//                            commonPage.click("discussBtn");
//                            assertEquals(true, getDriver().findElement(By.cssSelector("h1 div[class='status status--away']")).isEnabled());
//                            assertEquals(true, getDriver().findElement(By.cssSelector
//                                    ("div[style='position: relative;'] div.message:nth-child(1) div.message__user-name div[class='status status--away']")).isEnabled());
//
//                            commonPage.click("h1.name");
//                            assertEquals(true, getDriver().findElement(By.cssSelector("div.user__avatar div[class='status status--away']")).isEnabled());
//                        }
//                    }catch(Exception e){
//                        continue;
//                    }
//                }
//                return;
            }
        }
    }

    public boolean shouldSeeProfileOfAccount(String accountName) {
        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("div.user__meta h1");
        String name = getDriver().findElement(By.cssSelector("div.user__meta h1")).getText();
        if (accountName.contentEquals(name.replace("\n" + "edit", ""))) {
            System.out.println(name);
            return true;
        }
        System.out.println(name + " haizzz");
        return false;
    }

    public void shouldSeeAllNotificationsAndMessagesOfAccountPhuongChi() throws AWTException {
        assertThat(shouldSeeNotificationOfAccountPhuongChi(), is(equalTo(true)));
        assertThat(shouldSeeMessageOfAccountPhuongChi(), is(equalTo(true)));
        assertThat(shouldSeeContactRequestOfAccountPhuongChi(), is(equalTo(true)));

    }
    public boolean shouldSeeContactRequestOfAccountPhuongChi() throws AWTException {
        commonPage.waitUntilElementIsVisible("CrossYourDestiniesTextLink");
        commonPage.click("CrossYourDestiniesTextLink");
        commonPage.waitUntilElementIsVisible(".request");
        ArrayList<WebElement> contactRequest = new ArrayList<>(getDriver().findElements(By.cssSelector(".request")));
        if (contactRequest.size() > 0) {
            System.out.println(contactRequest.size());
            Robot robot = new Robot();
            WebElement contactRequestList = getDriver().findElement(By.cssSelector(".request"));
            Point listNoti = contactRequestList.getLocation();
            int xcord = listNoti.getX();
            int ycord = listNoti.getY() + 120;
            robot.mouseMove(xcord, ycord);
            System.out.println(xcord + " " + ycord);

            int itemLoaded = 0;
            int totalItems = contactRequest.size();

            while (itemLoaded < totalItems) {

                //scroll and wait a bit to give the impression of smooth scrolling
                robot.mouseWheel(40);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                itemLoaded = totalItems;
                contactRequest = new ArrayList<>(getDriver().findElements(By.cssSelector(".request")));
                totalItems = contactRequest.size();
                System.out.println(contactRequest.size());
            }
            ArrayList<String> usernameOfContactRequest = new ArrayList<>();
            ArrayList<WebElement> contactRequestUserName = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='request__head'] h5")));
            for (WebElement contactRequestMetaItem : contactRequestUserName) {
                usernameOfContactRequest.add(contactRequestMetaItem.getText());
            }
            System.out.println(usernameOfContactRequest);
            String[] contactRequestItemList = {
                    "yanis",
                    "omar sadek",
                    "tarek",
                    "nino",
                    "hamim",
                    "aziz772",
                    "sabeur",
                    "nssenmass",
                    "mohamed lamine",
                    "estyass",
                    "manc37",
                    "esmail",
                    "apaisement",
                    "laveriteeee",
                    "soul_mate",
                    "fmomo75",
                    "mouns",
                    "riadparadis",
                    "18 mostafa",

            };
            for (String item : contactRequestItemList) {
                if (!usernameOfContactRequest.contains(item)) {
                    System.out.println("KO");
                    return false;
                }
            }

        }
        System.out.println("OK");
        return true;
    }

    public boolean shouldSeeMessageOfAccountPhuongChi() throws AWTException {
        commonPage.waitUntilElementIsVisible("Messages");
        commonPage.click("Messages");
        commonPage.waitUntilElementIsVisible(".message");
        ArrayList<WebElement> mess = new ArrayList<>(getDriver().findElements(By.cssSelector(".message")));
        if (mess.size() > 0) {
            System.out.println(mess.size());
            Robot robot = new Robot();
            WebElement notificationList = getDriver().findElement(By.cssSelector(".messages"));
            Point listNoti = notificationList.getLocation();
            int xcord = listNoti.getX();
            int ycord = listNoti.getY() + 120;
            robot.mouseMove(xcord, ycord);
            System.out.println(xcord + " " + ycord);

            int itemLoaded = 0;
            int totalItems = mess.size();

            while (itemLoaded < totalItems) {

                //scroll and wait a bit to give the impression of smooth scrolling
                robot.mouseWheel(40);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                itemLoaded = totalItems;
                mess = new ArrayList<>(getDriver().findElements(By.cssSelector(".message")));
                totalItems = mess.size();
                System.out.println(mess.size());
            }
            ArrayList<String> usernameOfMessage = new ArrayList<>();
            ArrayList<WebElement> messageUserName = new ArrayList<>(getDriver().findElements(org.openqa.selenium.By.cssSelector("div[class='message__user-name'] h5")));
            for (WebElement messageMetaItem : messageUserName) {
                usernameOfMessage.add(messageMetaItem.getText());
            }
            System.out.println(usernameOfMessage);
            String[] messageItemList = {
                    "brahath",
                    "montassir93",
                    "yassine_yes",
                    "brandon92500",
                    "yassine_yes2",
                    "arthur96",
                    "arthur29",
                    "arthur93",
                    "nass111",
                    "ghallout",
                    "montassir931",
                    "kamel309218",
                    "kamel221053",
                    "pluie99",
                    "bilou92600",
                    "kamel586456",
                    "kamel205229",

            };
            for (String item : messageItemList) {
                if (!usernameOfMessage.contains(item)) {
                    System.out.println("KO");
                    return false;
                }
            }

        }
        System.out.println("OK");
        return true;
    }

    public boolean shouldSeeNotificationOfAccountPhuongChi() throws AWTException {
        commonPage.waitUntilElementIsVisible("NotificationTextLink");
        commonPage.click("NotificationTextLink");
        commonPage.waitUntilElementIsVisible(".notification-item");
        ArrayList<WebElement> noti = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification-item")));
        if (noti.size() > 0) {
            System.out.println(noti.size());
            Robot robot = new Robot();
            WebElement notificationList = getDriver().findElement(By.cssSelector(".list-notification"));
            Point listNoti = notificationList.getLocation();
            int xcord = listNoti.getX();
            int ycord = listNoti.getY() + 120;
            robot.mouseMove(xcord, ycord);
            System.out.println(xcord + " " + ycord);

            int itemLoaded = 0;
            int totalItems = noti.size();

            while (itemLoaded < totalItems) {

                //scroll and wait a bit to give the impression of smooth scrolling
                robot.mouseWheel(40);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                itemLoaded = totalItems;
                noti = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification-item")));
                totalItems = noti.size();
                System.out.println(noti.size());
            }
            ArrayList<String> usernameOfNoti = new ArrayList<>();
            ArrayList<WebElement> notiMeta = new ArrayList<>(getDriver().findElements(org.openqa.selenium.By.cssSelector("div[class='notification__meta'] h5")));
            for (WebElement notiMetaItem : notiMeta) {
                usernameOfNoti.add(notiMetaItem.getText());
            }
            System.out.println(usernameOfNoti);
            String[] notiItemList = {
                    "karim",
                    "yacine",
                    "nino",
                    "daz12",
                    "hamim",
                    "sabeur",
                    "laveriteeee",
                    "nssenmass",
                    "tounsii14",
                    "mohazient",
                    "ra774",
                    "mohamed lamine",
                    "mohamed islam",
                    "jeanlouis",
                    "estyass",
                    "manc37",
                    "esmail",
                    "brahath",
                    "etmoi",
                    "apaisement",
                    "naouri",
                    "kabyle06",
                    "aniss",
                    "noureddine25",
                    "noureddine25",
                    "jfffryuyfet",
                    "yanis34",
                    "20_shehat",
                    "ousmane",
                    "jawad",
                    "maghrebunited",
                    "jawad",
                    "soul_mate",
                    "rimk92",
                    "omerhamza",
                    "brucewaynee",
                    "avectoi",
                    "arthur96",
                    "las2pick",
                    "kfizan",
                    "k1hm",
            };
            for (String item : notiItemList) {
                if (!usernameOfNoti.contains(item)) {
                    System.out.println("KO");
                    return false;
                }
            }

        }
        System.out.println("OK");
        return true;
    }


    public void theTestimonialsContainAllItSParts(){
        assertEquals("Ils se sont rencontrés sur Mektoube",getDriver().findElement(By.cssSelector("section[class='section section--testimonials'] h2[class='underlined']")).getText());

        assertEquals("DÉCOUVRIR TOUTES LES HISTOIRES", getDriver().findElement(By.cssSelector("a[href='/temoignages']")).getText());

        commonPage.click("div#slick-slide00 .testimonial__body");
        commonPage.waitUntilElementIsVisible("div.title");
        assertEquals(true,getDriver().getCurrentUrl().contains("/interviews/1"));
        commonPage.scrollToAndClick("div[role='button']");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonPage.waitUntilElementIsVisible("div.title");
        assertEquals(true,getDriver().getCurrentUrl().contains("/interviews/2"));
        commonPage.scrollToAndClick("div[class='flex flex-row flex-row-sa m-2 lead'] div[role='button']:nth-child(2)");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonPage.waitUntilElementIsVisible("div.title");
        assertEquals(true,getDriver().getCurrentUrl().contains("/interviews/3"));
        commonPage.scrollToAndClick("div[class='flex flex-row flex-row-sa m-2 lead'] div[role='button']:nth-child(2)");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonPage.waitUntilElementIsVisible("div.title");
        assertEquals(true,getDriver().getCurrentUrl().contains("/interviews/4"));
        commonPage.scrollToAndClick("div[class='flex flex-row flex-row-sa m-2 lead'] div[role='button']:nth-child(2)");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonPage.waitUntilElementIsVisible("div.title");
        assertEquals(true,getDriver().getCurrentUrl().contains("/interviews/5"));
        commonPage.scrollToAndClick("div[class='flex flex-row flex-row-sa m-2 lead'] div[role='button']:nth-child(2)");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonPage.waitUntilElementIsVisible("div.title");
        assertEquals(true,getDriver().getCurrentUrl().contains("/interviews/6"));

        commonPage.click("div.section--header i");
        commonPage.scrollToAndClick("a[href='/temoignages']");
        assertEquals(true,getDriver().getCurrentUrl().contains("/temoignages"));
    }

    public void thePageShowMessageAt(String errorMess, String element){
        assertEquals(errorMess,getDriver().findElement(By.cssSelector(element)).getText());
    }

    HomePageAndLoginPage homePageAndLoginPage = new HomePageAndLoginPage();
    public void createAManAccountWithEmail(String email){
        commonPage.gotoUrl("https://www.mektoube.fr/");
        commonPage.click("iAmAMan");
        commonPage.click("FreeRegistration");
        commonPage.redirectToLink("birthdayForm.url");
        homePageAndLoginPage.enterAValidDateOfBirthAndValidate();
        commonPage.redirectToLink("originForm.url");
        commonPage.clickOnRadionButtonThatHasText("//div[@class='list--radio']//*[contains(text(),'Algérienne')]");
        commonPage.click("confirmBtn");
        commonPage.click("MaLocalisationField");
        commonPage.waitAboutSecond(5);
        commonPage.waitUntilElementIsVisible("CountriesList");
        commonPage.clickOnRadionButtonThatHasText("France");
        commonPage.click("confirmBtn");
        commonPage.waitAboutSecond(2);
        commonPage.redirectToLink("zipCode.url");
        commonPage.insertIntoField("75001", "ZipcodeField");
        commonPage.click("confirmBtn");
        commonPage.waitAboutSecond(2);
        commonPage.redirectToLink("CityOfZipCode75001.url");
        homePageAndLoginPage.shouldSeeUniqueCity();
        commonPage.click("Paris1erCity");
        commonPage.click("confirmBtn");
        commonPage.waitAboutSecond(2);
        commonPage.redirectToLink("signUp.url");
        commonPage.insertIntoField(email,"input[type='email']");
        commonPage.insertIntoField("lanmek11", "input[type='text']");
        commonPage.insertIntoField("Mektoubi2017", "input[type='password']");
        commonPage.click("TermsOfUse1");
        commonPage.click("TermsOfUse2");
        commonPage.click("CreateAccountBtn");
    }

    public void thePageShowPopUpVoiceReportConfirm(){
        assertEquals("Signaler un message vocal\nVous estimez que ce message est incorrecte.\nVotre signalement est et restera anonyme.",
                getDriver().findElement(By.cssSelector("div.modal--header__title")).getText());
        assertEquals("Bloquer cette personne",getDriver().findElement(By.cssSelector("span.form-label")).getText());
        assertTrue(getDriver().findElement(By.cssSelector("input[type='checkbox']")).isEnabled());
    }

    public void allowToUseMicrophone(){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            System.out.println("can not allow microphone by robot");
            e.printStackTrace();
        }
        robot.delay(5000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public void clickOnLastMessage(int index){
        //get id of voice that near end
        String lastVoiceId = getDriver().findElement(By.cssSelector(".chat__row:last-child")).getAttribute("id");

        //substraction 1

    }

    public void theLastVoiceMessageIsNotAllowedPlaying(){
        assertEquals("play_circle_filled", getDriver().findElement(By.cssSelector(".chat__row:last-child div.audio-message i")).getText());
    }

    public void theVoiceMessageStillRecording(){
        String [] beforeRecortTime = getDriver().findElement(By.cssSelector("span.record-time")).getText().split(":");
        commonPage.waitAboutSecond(3);
        String [] afterRecortTime = getDriver().findElement(By.cssSelector("span.record-time")).getText().split(":");

        int beforeRecortTimeNumber = Integer.parseInt(beforeRecortTime[0]+beforeRecortTime[1]);
        int afterRecortTimeNumber = Integer.parseInt(afterRecortTime[0]+afterRecortTime[1]);

        assertTrue(beforeRecortTimeNumber < afterRecortTimeNumber);
    }

    MessageModule messageModule = new MessageModule();
    public void uploadEphemeralPictureIs(String imageName) throws AWTException {
        commonPage.waitUntilElementIsVisible("label[for='file-upload-camera']");
        WebElement fileInput = getDriver().findElement(By.cssSelector("label[for='file-upload-camera']"));
        System.out.println(fileInput);
        fileInput.click();

        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String text = System.getProperty("user.dir") + "\\src\\test\\resources\\data_test\\"+imageName;
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
        try {
            Thread.sleep(2 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assertThat(messageModule.SelectByDefaultFiveSecond(), is(equalTo(true)));
        getDriver().findElement(By.cssSelector(".delay-options div:nth-child(3)")).click();
        getDriver().findElement(By.cssSelector("button.submit-option")).click();
        try {
            Thread.sleep(5 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void dontShowSentImageThatChangedExtension(){
        String lastImageId = getDriver().findElement(By.cssSelector(".chat__row:last-child")).getAttribute("id");
        System.out.println(lastImageId);
        ArrayList<WebElement> imagesHaveTheSameId = new ArrayList<>(getDriver().findElements(By.cssSelector("div[id='"+lastImageId+"']")));
        //System.out.println(imagesHaveTheSameId.get(0).getAttribute("id"));
        //System.out.println(imagesHaveTheSameId.get(1).getAttribute("id"));
        assertEquals(1,imagesHaveTheSameId.size());
    }

    public void loginGmailAndClickLinkToRETURNTOMEKTOUBE(){
        commonPage.gotoUrl("http://www.google.com/gmail/");
        commonPage.waitUntilElementIsVisible("div[data-allow-at-sign='true']");
        commonPage.insertIntoField("mektoubitest@gmail.com","input[type='email']");
        commonPage.click("div#identifierNext");
        commonPage.waitUntilElementIsVisible("div[data-is-visible='false']");
        commonPage.waitAboutSecond(1);
        commonPage.insertIntoField("Mektoubi2017","input[type='password']");
        commonPage.click("div#passwordNext");
        commonPage.waitAboutSecond(2);
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        ArrayList<WebElement> returnToMektoube = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='xT']//*[contains(text(),'Retourner sur Mektoube')]"))));
        returnToMektoube.get(0).click();
        commonPage.waitAboutSecond(4);
        ArrayList<WebElement> expandMail = new ArrayList<>(getDriver().findElements(By.cssSelector("div.ajV img[src='//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif']")));
        System.out.println(expandMail.size());
        if (expandMail.size() > 0) {
            commonPage.scrollToAndClick("div.ajV img[src='//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif']:last-child");
        }
        commonPage.waitAboutSecond(1);
        ArrayList<WebElement> returnToMektoubeLink = new ArrayList<>(getDriver().findElements(By.xpath("//a/span[contains(text(),'SE CONNECTER DIRECTEMENT SUR MEKTOUBE')]")));
//        commonPage.clickOnRadionButtonThatHasText("//a/span[contains(text(),'Je confirme ma demande de désinscription')]");
        returnToMektoubeLink.get(returnToMektoubeLink.size() - 1).click();
    }

    public void theAccountNameIs(String name){
        commonPage.waitUntilElementIsVisible("div.user__meta h1");
        String [] usermetaString = getDriver().findElement(By.cssSelector("div.user__meta h1")).getText().split("\n");
        assertEquals(name, usermetaString[0]);
    }

    public void countingNumberOfBoostProfileOnDiscovery(){
        int boostProfileNumber = getDriver().findElements(By.cssSelector("div.boost-star")).size();
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('boostProfileNumber','" + boostProfileNumber + "')");
    }

    public void theBoostProfilesLikeWhenNotRefreshed(){
        int currentBoostProfileNumber = getDriver().findElements(By.cssSelector("div.boost-star")).size();
        int expectedBoostProfileNumber =(int)((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('boostProfileNumber')");
        assertEquals( expectedBoostProfileNumber,currentBoostProfileNumber);
    }

    public void theButtonIsDisabledThatIs(String element){
        String voiceIcon = TestDataService.properties.getProperty(element);
        getDriver().findElement(By.cssSelector(voiceIcon)).isDisplayed();
    }

}
