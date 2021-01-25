package autoTest.pages;

import autoTest.service.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class MektoubeCommonPage extends PageObject {

    public void gotoUrl(String urlName) {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("ie.ensureCleanSession", true);


        try {
            Thread.sleep(15 * 1000);
            DesiredCapabilities ieCap = DesiredCapabilities.internetExplorer();
            ieCap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = TestDataService.properties.getProperty(urlName);
        if (url == null) {
            url = urlName;
        }
        getDriver().get(url);
        getDriver().manage().window().maximize();
        ArrayList<WebElement> advance = new ArrayList<>(getDriver().findElements(By.cssSelector("button[id='details-button']")));
        if (advance.size() > 0) {
            getDriver().findElement(By.cssSelector("button[id='details-button']")).click();
            waitAboutSecond(1);
            getDriver().findElement(By.cssSelector("a[id='proceed-link']")).click();
        }
        ArrayList<WebElement> moreInfor = new ArrayList<>(getDriver().findElements(By.cssSelector("span[id='moreInfoContainer']")));
        if (moreInfor.size() > 0) {
            getDriver().findElement(By.cssSelector("span[id='moreInfoContainer']")).click();
            waitAboutSecond(2);
            getDriver().findElement(By.cssSelector("a[id='overridelink']")).click();
        }

    }

    public void loginWithAccountAndPassword(String account, String password) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
//        WebElement homeIntro = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='home-intro']")));
        waitAboutSecond(3);
        ArrayList<WebElement> Cookie = new ArrayList<>(getDriver().findElements(By.cssSelector("button[class='mdc-button mdc-button--outlined']")));
        System.out.println(Cookie.size());
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header__inner a[href='/login']")));
        if (Cookie.size() > 0) {
            Cookie.get(0).click();
            loginButton.click();
        } else {
            loginButton.click();
        }
        waitAboutSecond(4);
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='username']")));
        userNameField.sendKeys(account);

        WebElement passWordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='password']")));
        passWordField.sendKeys(password);
        getDriver().findElement(By.cssSelector(".form__actions button[type='submit']")).click();
    }


    public boolean shouldSeeMessagePopupAtTop(String mess) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
        String popupErrorMsgElementText = popupErrorMsgElements.getText();
        if (popupErrorMsgElementText.contentEquals(mess)) {
            System.out.println(popupErrorMsgElementText + " pass");
            return true;
        }
        System.out.println(popupErrorMsgElementText + " fail");
        return false;

    }

    public boolean shouldSeeMessagePopupInLine(String mess) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        ArrayList<String> errorMsgs = new ArrayList<>();
        ArrayList<WebElement> inlineErrorMsgElements = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("p.error"))));
        for (WebElement errorItem : inlineErrorMsgElements) {
            errorMsgs.add(errorItem.getText());
        }
        if (errorMsgs.contains(mess)) {

            System.out.println(errorMsgs);
            return true;
        }
        System.out.println(errorMsgs);
        return false;

    }

    public void click(String button) {

        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            cssSelector = button;
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("css " + cssSelector);
        getDriver().findElement(By.cssSelector(cssSelector)).click();

    }

    public void waitAboutSecond(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnWhichIndexIs(String button, int number) {
        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            cssSelector = button;
        }
        ArrayList<WebElement> settingList = new ArrayList<>(getDriver().findElements(By.cssSelector(cssSelector)));
        settingList.get(number).click();
    }

    public void waitUntilElementIsVisible(String button) {
        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            cssSelector = button;
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 80);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    public void scrollToView(String element) {
        String cssSelector = TestDataService.properties.getProperty(element);
        if (cssSelector == null) {
            cssSelector = element;
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<WebElement> filterItemList = new ArrayList<>(getDriver().findElements(By.cssSelector(cssSelector)));
        System.out.println("filter item have size " + filterItemList.size());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", filterItemList.get(0));
    }

    public void insertIntoFieldUpd(String value, String field) {
        String cssSelector = TestDataService.properties.getProperty(field);
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.cssSelector(cssSelector)));
        element.sendKeys(value);

    }

    public String getCurrentUrl() {
        System.out.println(getDriver().getCurrentUrl());
        return getDriver().getCurrentUrl();
    }


    public boolean redirectToLink(String url) {
        String urlName = TestDataService.properties.getProperty(url);
        if (urlName == null) {
            urlName = url;
        }
        String realUrl = getDriver().getCurrentUrl();
        if (realUrl.contentEquals(urlName)) {

            System.out.println(realUrl + " " + urlName + " pass");
            return true;
        }

        System.out.println(realUrl + " " + urlName + " fail");
        return false;
    }

    public void clickButton(String button) {
        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            cssSelector = button;
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
//        element.click();

//        getDriver().findElement(By.cssSelector(cssSelector)).click();
//        System.out.println(cssSelector);
        WebElement Element = getDriver().findElement(By.cssSelector(cssSelector));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", Element);
        Element.click();
        System.out.println(Element);
    }

    public void clickOnRadionButtonThatHasText(String button) {
        String xpath = TestDataService.properties.getProperty(button);
        if (xpath == null) {
            xpath = button;
        }
        WebElement Element = getDriver().findElement(By.xpath(xpath));
        Element.click();
    }

    public void insertIntoField(String text, String fieldName) {
        String cssSelector = TestDataService.properties.getProperty(fieldName);
        if (cssSelector == null) {
            cssSelector = fieldName;
        }

        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(text);
        System.out.println(text);
    }

    public void logoutCurrentFemaleAccount() {
        WebElement myProfileButton = getDriver().findElement(By.cssSelector("div[class='header__aside hidden-xs']"));
        //waitUntilElementIsVisible("div[class='header__aside hidden-xs']");
        myProfileButton.click();
        waitUntilElementIsVisible("a[href='/main/my-account/parameters']");
        getDriver().findElement(By.cssSelector("a[href='/main/my-account/parameters']")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> settingList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".list-settings .filter .filter__item"))));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", settingList.get(settingList.size() - 1));

        settingList.get(settingList.size() - 1).click();
    }


    public void clickFilterByUsername() {
        scrollToElementThatHasTextAndClick("//div[@class='list-toggle-options']//*[contains(text(),'Critères avancés')]");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> filterItemList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.filter__item"))));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", filterItemList.get(filterItemList.size() - 1));
        filterItemList.get(filterItemList.size() - 1).click();
    }

    public void insertUsernameOfWomanAccountToSearchUsernameFilter() {
        String abc = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('nameField')");
        getDriver().findElement(By.cssSelector("input[type='text']")).sendKeys(abc);
        System.out.println(abc);

    }

    public boolean browserShouldRedirectToUrlContain(String url) {
        waitAboutSecond(4);
        String urlName = TestDataService.properties.getProperty(url);
        if (urlName == null) {
            urlName = url;
        }
        String realUrl = getDriver().getCurrentUrl();
        if (realUrl.contains(urlName)) {
            System.out.println(realUrl + " pass");
            return true;
        }
        System.out.println(realUrl + " fail " + urlName);
        return false;

    }

    public boolean onlyOneRadioButtonIsClicked() {
        ArrayList<WebElement> radioButtonList = (ArrayList<WebElement>) getDriver().findElements(By.cssSelector("input[type='radio']"));
        int numberOfSelectedRadioButton = 0;
        for (int i = 0; i < radioButtonList.size(); i++) {
            if (radioButtonList.get(i).isSelected()) {

                numberOfSelectedRadioButton++;
            }
        }
        if (numberOfSelectedRadioButton == 1) {
            System.out.println(numberOfSelectedRadioButton + " pass");
            return true;
        }
        System.out.println(numberOfSelectedRadioButton + " false");
        return false;

    }

    public void scrollToWhichIndexIsAndClick(String button, int number) {
        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            cssSelector = button;
        }
        ArrayList<WebElement> toggleList = new ArrayList<>(getDriver().findElements(By.cssSelector(cssSelector)));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", toggleList.get(number));
        toggleList.get(number).click();
    }

    public void getProfileNameFrom(String fieldName) {
        String cssSelector = TestDataService.properties.getProperty(fieldName);
        if (cssSelector == null) {
            cssSelector = fieldName;
        }
        WebElement accountName = getDriver().findElement(By.cssSelector(cssSelector));
        String accountName1 = accountName.getAttribute("value");
        System.out.println(accountName1 + " " + "hehehihi");
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('accountName','" + accountName1 + "')");


    }

    public void scrollToAndClick(String button) {
        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            cssSelector = button;
        }
        WebElement Element = getDriver().findElement(By.cssSelector(cssSelector));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", Element);
        Element.click();
        System.out.println(Element);
    }

    public void cleareLocalStorage() {
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.clear()");
    }

    public void scroll() throws AWTException {

        ArrayList<WebElement> mess = new ArrayList<>(getDriver().findElements(net.serenitybdd.core.annotations.findby.By.cssSelector(".message")));
        System.out.println(mess.size());
        Robot robot = new Robot();
        WebElement messagesList = getDriver().findElement(net.serenitybdd.core.annotations.findby.By.cssSelector(".messages"));
        Point listMess = messagesList.getLocation();
        int xcord = listMess.getX();
        int ycord = listMess.getY() + 120;
        robot.mouseMove(xcord, ycord);
        System.out.println(xcord + " " + ycord);

        int itemLoaded = 0;
        int totalItems = mess.size();

        while (itemLoaded < totalItems) {

            //scroll and wait a bit to give the impression of smooth scrolling
            robot.mouseWheel(40);

            try {
                Thread.sleep(5 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            itemLoaded = totalItems;
            mess = new ArrayList<>(getDriver().findElements(net.serenitybdd.core.annotations.findby.By.cssSelector(".message")));
            totalItems = mess.size();
            System.out.println(mess.size());
        }
        mess = new ArrayList<>(getDriver().findElements(net.serenitybdd.core.annotations.findby.By.cssSelector(".message")));
        System.out.println(mess.size());
        System.out.println(mess.get(mess.size() - 1).findElement(net.serenitybdd.core.annotations.findby.By.cssSelector("div[class='message__head'] h5")).getText());

    }

    public boolean shouldSeeMessagePopupAtTopOr(String mess1, String mess2) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.cssSelector("div.top-message-text")));
        String popupErrorMsgElementText = popupErrorMsgElements.getText();
        System.out.println(popupErrorMsgElementText);
        if (popupErrorMsgElementText.contentEquals(mess1) || popupErrorMsgElementText.contentEquals(mess2)) {
            return true;
        }
        return false;
    }

    public void scrollToElementThatHasTextAndClick(String button) {
        String xpath = TestDataService.properties.getProperty(button);
        if (xpath == null) {
            xpath = button;
        }
        WebElement Element = getDriver().findElement(By.xpath(xpath));
//        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//        jse.executeScript("arguments[0].scrollIntoView()", Element);
        Element.click();
        System.out.println(Element);

    }

    public void clearTextFromField(String button) {
        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            cssSelector = button;
        }
        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
//        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(Keys.DELETE);
    }

    public void refreshCurentPage() {
        getDriver().navigate().refresh();
    }

    public void scrollAllPage() {
        //scroll to get all user have choosed before
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        int itemLoaded = 0;
        int totalItems = getDriver().findElements(net.serenitybdd.core.annotations.findby.By.cssSelector(".profile__avatar")).size();
        int i = 1;
        while (itemLoaded < totalItems) {
            int intTo = i * 5000;
            js.executeScript("window.scrollTo(0," + intTo + ");");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            itemLoaded = totalItems;
            totalItems = getDriver().findElements(net.serenitybdd.core.annotations.findby.By.cssSelector(".profile__avatar")).size();
            i++;
        }
    }

    public void clickOnTheElementIsByXpath(String element) {
        getDriver().findElement(By.xpath(element)).click();
    }


    public void thePageShowErrorMessageIs(String errorMess) {
        assertEquals(errorMess, getDriver().findElement(By.cssSelector("div.top-message-overlay > div.top-message-text > div")).getText());
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }


    public void openNewTab() throws AWTException {
        Robot robot = new Robot();

        // open new browser tab
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        waitAboutSecond(2);
    }
}
