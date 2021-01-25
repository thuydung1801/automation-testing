package autoTest.pages;

import autoTest.service.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;


public class CommonPage extends PageObject {
    public void gotoUrl(String urlName) {
        String url = TestDataService.properties.getProperty(urlName);
        if (url == null) {
            url = urlName;
        }
        getDriver().get(url);
        getDriver().manage().window().maximize();

    }

    public void click(String button) {
        System.out.println("check ");
        String cssSelector = TestDataService.properties.getProperty(button);
        //System.out.println("check ");
        if (cssSelector == null) {
            System.out.println("check2");
            cssSelector = button;
            System.out.println(cssSelector);
        }
        try {
            Thread.sleep(2000);
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
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
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
        String inputTxt = TestDataService.properties.getProperty(text);
        if (cssSelector == null) {
            cssSelector = fieldName;
        }
        if (inputTxt == null) {
            inputTxt = text;
        }

        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(inputTxt);
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
        String xpathSelector = TestDataService.properties.getProperty(element);
        if (xpathSelector == null) {
            xpathSelector = element;
        }
        getDriver().findElement(By.xpath(xpathSelector)).click();
    }


    public void thePageShowErrorMessageIs(String errorMess) {
        assertEquals(errorMess, getDriver().findElement(By.cssSelector("div.top-message-overlay > div.top-message-text > div")).getText());
    }
    public void assertMsg (String expectedMsg, String msgLocator){
        String expectedMess = TestDataService.properties.getProperty(expectedMsg);
        if (expectedMess == null){
            expectedMess = expectedMsg;
        }
        String msglct = TestDataService.properties.getProperty(msgLocator);
        if (msglct == null){
            msglct = msgLocator;
        }
        assertEquals(expectedMess, getDriver().findElement(By.cssSelector(msglct)).getText());
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

    public void hideAdvertisingFrame(){
        waitUntillElementVisiableAndClick("closeAdvertisingFrame");
    }

    public void waitUntillElementVisiableAndClick(String element){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String xpathSelector = TestDataService.properties.getProperty(element);
        if (xpathSelector == null) {
            xpathSelector = element;
        }
        System.out.println(xpathSelector);

        WebDriverWait wait = new WebDriverWait(getDriver(), 15);

        int size = getDriver().findElements(By.tagName("iframe")).size();
        System.out.println("number of frame: " +size);

        ArrayList<WebElement> iframeList = new ArrayList<>(getDriver().findElements(By.xpath("//div[@class='news-survey']//iframe[@data-cc-src='popup']")));
        if(iframeList.size() != 0){
            getDriver().switchTo().frame(1);
            WebElement exitIcon = getDriver().findElement(By.xpath(xpathSelector));
//            WebElement exitIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelector)));
            exitIcon.click();
            getDriver().switchTo().defaultContent();
        }

//               try{
//                   int total=getDriver().findElements(By.xpath(xpathSelector)).size();
//                   System.out.println("total close: "+total);
//                   if(total==1){
//                       WebElement exitIcon = getDriver().findElement(By.xpath(xpathSelector));
////            WebElement exitIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelector)));
//                       exitIcon.click();
//                       getDriver().switchTo().defaultContent();
//                   }
//               }catch (Exception e){
//                   getDriver().switchTo().defaultContent();
//               }
    }

    public void saveToLocalStorageWithName(String element, String elementName) {
        String cssSelector = TestDataService.properties.getProperty(element);
        if (cssSelector == null) {
            cssSelector = element;
        }
        String nowPrice = getDriver().findElement(By.cssSelector(cssSelector)).getText();
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('"+elementName+"','" + nowPrice + "')");
    }

    public void scrollOnTopPage() {
        //window.scrollTo(0, 0);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,0)");
    }

    public void validateInformation(String element, String expectedInfo) {

        String cssSelector = TestDataService.properties.getProperty(element);
        if (cssSelector == null){
            cssSelector = element;
        }
        String expectedText = TestDataService.properties.getProperty(expectedInfo);
        if (expectedText == null) {
            expectedText = expectedInfo;
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String actualInfo = getDriver().findElement(By.cssSelector(cssSelector)).getText();
        assertEquals(expectedText, actualInfo);


    }
}


