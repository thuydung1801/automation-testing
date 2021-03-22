package autoframework.pages;

import autoframework.service.TestDataService;
import junit.framework.TestCase;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CommonPage extends PageObject {
    public static WebDriver driver;
    By msgError = By.className("message-error");// chung
    By msgItem = By.cssSelector(".page.messages");
    By cookieAccept = By.className("m-accept");


    public void waitAboutSeconds(int second) throws InterruptedException {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    boolean isElementPresent(WebElement element, int timeout){
        WebDriverWait wait;
        try{
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public void iClickButtonHasText(String buttontext) {
        ArrayList<WebElement> List = new ArrayList<>(getDriver().findElements(By.className("header-panel-right")));
        ArrayList<WebElement> list = new ArrayList<>(getDriver().findElements(By.className("header-content-wrap")));
        ArrayList<WebElement> listButtonAdmin = new ArrayList<>(getDriver().findElements(By.className("action-default")));
        ArrayList<WebElement> bigList = new ArrayList<WebElement>();
        bigList.addAll(list);
        bigList.addAll(List);
        bigList.addAll(listButtonAdmin);

        for (int i = 0; i < bigList.size(); i++) {
            if (bigList.get(i).getText().equalsIgnoreCase(buttontext)){
                System.out.println("Click button nay: " + bigList.get(i).getText());
                bigList.get(i).click();
                break;
            }
        }
    }
    public void clickButtonById(String idButton) {
        String idElement = TestDataService.properties.getProperty(idButton);
        if (idElement == null) {
            idElement = idButton;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.id(idElement));
        Element.click();
    }
    public void clickButtonByclass(String classButton) {
        String classElement = TestDataService.properties.getProperty(classButton);
        if (classElement == null) {
            classElement = classButton;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.className(classElement));
        Element.click();
    }

    public void waitUntilDisplayButtonHasText(String buttontext) {
        ArrayList<WebElement> headerPanelRightBtnList = new ArrayList<>(getDriver().findElements(By.className("header-panel-right")));
        for (int i = 0; i < headerPanelRightBtnList.size(); i++) {
            if (headerPanelRightBtnList.get(i).getText().equalsIgnoreCase(buttontext)){
                System.out.println(buttontext + " is displayed");
                System.out.println("click Place Order");
            }
        }
    }
    public void waitUntilDisplayElementByXpath(String element) {
        String xpathElement = TestDataService.properties.getProperty(element);
        if (xpathElement == null) {
            xpathElement = element;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathElement)));
    }
    public void clickButtonByXpath(String xpathButton) {
        String xpathElement = TestDataService.properties.getProperty(xpathButton);
        if (xpathElement == null) {
            xpathElement = xpathButton;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.xpath(xpathElement));
        Element.click();
    }
    public void insertIntoFieldByXpath(String text, String xpath) {
        String xpathElement = TestDataService.properties.getProperty(xpath);
        if (xpathElement == null) {
            xpathElement = xpath;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = driver.findElement(By.xpath(xpathElement));
        Element.click();
        Element.sendKeys(text);
    }
    public void insertIntoFieldById(String text, String id) {
        String idElement = TestDataService.properties.getProperty(id);
        if (idElement == null) {
            idElement = id;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.id(idElement));
        Element.click();
        Element.sendKeys(text);
    }
    public void insertIntoFieldByName(String text, String name) {
        String nameElement = TestDataService.properties.getProperty(name);
        if (nameElement == null) {
            nameElement = name;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.name(nameElement));
        Element.sendKeys(text);
    }
    public void gotoUrl(String url) {
        String urlInPro = TestDataService.properties.getProperty(url);
        if (urlInPro == null) {
            urlInPro = url;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().get(urlInPro);
        System.out.println("go to the " + urlInPro);

    }
    public void checkURl(String expectUrl) throws InterruptedException {
        Thread.sleep(10000);
        String ExpectUrl = TestDataService.properties.getProperty(expectUrl);
        if (ExpectUrl == null) {
            ExpectUrl = expectUrl;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(ExpectUrl, getDriver().getCurrentUrl());
    }
    public void getMsgError_fail(String expectMsgError){
        Assert.assertEquals(expectMsgError,getDriver().findElement(msgError).getText());
    }
    public void getMsgItem(String expectMsg){
        System.out.println("show actual msg:" +getDriver().findElement(msgItem).getText());
        Assert.assertEquals(expectMsg,getDriver().findElement(msgItem).getText());
    }
    public void acceptCookie(){
        getDriver().findElement(cookieAccept).click();
    }

    public void showErrorMessageForBlankById(String id, String msg) {
        String idElement = TestDataService.properties.getProperty(id);
        if (idElement == null) {
            idElement = id;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.id(idElement));
        System.out.println("show message: "+ Element.getText());
        Assert.assertEquals(msg,Element.getText());

    }
    public void showErrorMessageForBlankByClass(String clname, String msg) {
        String clnameElement = TestDataService.properties.getProperty(clname);
        if (clnameElement == null) {
            clnameElement = clname;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.className(clnameElement));
        System.out.println("show message: "+ Element.getText());
        Assert.assertEquals(msg,Element.getText());

    }
    
    
//    ----Huong's Code
String theFirstItemLocator = "table.data-grid tbody tr:nth-of-type(1) input";
    String loadingMaskLocator = "div.loading-mask";
    String confirmBtnLocator = "div.modal-inner-wrap button.action-accept";
    String messageLocator = "div.messages div div";




    public void clickOn(String button) {
        System.out.println("check ");
        String cssSelector = TestDataService.properties.getProperty(button);
        //System.out.println("check ");
        if (cssSelector == null) {
            System.out.println("check2");
            cssSelector = button;
            System.out.println(cssSelector);
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebDriverWait waiter = new WebDriverWait(getDriver(), 15);
//        System.out.println("css " + cssSelector);
        WebElement el = waiter.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        el.click();
        System.out.println("clicked");
        waitAboutSecond(3);
//        getDriver().findElement(By.cssSelector(cssSelector)).click();

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
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
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

//    public String getCurrentUrl() {
//        System.out.println(getDriver().getCurrentUrl());
//        return getDriver().getCurrentUrl();
//    }

//    public boolean redirectToLink(String url) {
//        String urlName = TestDataService.properties.getProperty(url);
//        if (urlName == null) {
//            urlName = url;
//        }
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String realUrl = getDriver().getCurrentUrl();
//        TestCase.assertEquals(urlName, realUrl);
//        return false;
//    }

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


//    public void enterTextIntoField(String text, String fieldName) {
//        String cssSelector = TestDataService.properties.getProperty(fieldName);
//        String inputTxt = TestDataService.properties.getProperty(text);
//        if (cssSelector == null) {
//            cssSelector = fieldName;
//        }
//        if (inputTxt == null) {
//            inputTxt = text;
//        }
//        WebDriverWait wait = new WebDriverWait(getDriver(),15);
//        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
//        el.clear();
//        el.sendKeys(inputTxt+Keys.ENTER);
////        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(inputTxt);
//        System.out.println(text);
//        waitAboutSecond(3);
//    }


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

//    public boolean browserShouldRedirectToUrlContain(String url) {
//        waitAboutSecond(4);
//        String urlName = TestDataService.properties.getProperty(url);
//        if (urlName == null) {
//            urlName = url;
//        }
//        String realUrl = getDriver().getCurrentUrl();
//        if (realUrl.contains(urlName)) {
//            System.out.println(realUrl + " pass");
//            return true;
//        }
//        System.out.println(realUrl + " fail " + urlName);
//        return false;
//
//    }

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

//    public void scrollToAndClick(String button) {
//        String cssSelector = TestDataService.properties.getProperty(button);
//        if (cssSelector == null) {
//            cssSelector = button;
//        }
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        WebElement Element = getDriver().findElement(By.cssSelector(cssSelector));
//        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//        jse.executeScript("arguments[0].scrollIntoView()", Element);
//        Element.click();
//        System.out.println(Element);
//    }

//    public void selectOption(String element, String selectObject){
//        String elCssSelector = TestDataService.properties.getProperty(element);
//        if (elCssSelector == null) {
//            elCssSelector = element;
//        }
//        String selectedText = TestDataService.properties.getProperty(selectObject);
//        if (selectedText == null) {
//            selectedText = selectObject;
//        }
//        Select selector = new Select(getDriver().findElement(By.cssSelector(elCssSelector)));
//        selector.selectByValue(selectedText);
//    }
    public void selectOtionByText(String element, String selectObject) {
        String elCssSelector = TestDataService.properties.getProperty(element);
        if (elCssSelector == null) {
            elCssSelector = element;
        }
        String selectedText = TestDataService.properties.getProperty(selectObject);
        if (selectedText == null) {
            selectedText = selectObject;
        }
        Select selector = new Select(getDriver().findElement(By.cssSelector(elCssSelector)));
        selector.selectByVisibleText(selectedText);
    }
    public void InputText(String text, String element){
        String orderID = TestDataService.properties.getProperty(text);
        if (orderID == null) {
            orderID = text;
        }
        String expectedText = TestDataService.properties.getProperty(element);
        if (expectedText == null) {
            expectedText = element;
        }
        getDriver().findElement(By.xpath(element)).clear();

        getDriver().findElement(By.xpath(element)).sendKeys("\n" + orderID+ Keys.ENTER);
        // getDriver().findElement(By.id("fulltext")).;
        waitAboutSecond(10);
    }
//    public void cleareLocalStorage() {
//        ((JavascriptExecutor) getDriver()).executeScript("localStorage.clear()");
//    }

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

//    public void scrollToElementThatHasTextAndClick(String button) {
//        String xpath = TestDataService.properties.getProperty(button);
//        if (xpath == null) {
//            xpath = button;
//        }
//        WebElement Element = getDriver().findElement(By.xpath(xpath));
////        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
////        jse.executeScript("arguments[0].scrollIntoView()", Element);
//        Element.click();
//        System.out.println(Element);
//
//    }

//    public void clearTextFromField(String button) {
//        String cssSelector = TestDataService.properties.getProperty(button);
//        if (cssSelector == null) {
//            cssSelector = button;
//        }
//        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
////        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(Keys.DELETE);
//    }

    public void refreshCurentPage() {
        getDriver().navigate().refresh();
    }

//    public void scrollAllPage() {
//        //scroll to get all user have choosed before
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        int itemLoaded = 0;
//        int totalItems = getDriver().findElements(net.serenitybdd.core.annotations.findby.By.cssSelector(".profile__avatar")).size();
//        int i = 1;
//        while (itemLoaded < totalItems) {
//            int intTo = i * 5000;
//            js.executeScript("window.scrollTo(0," + intTo + ");");
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            itemLoaded = totalItems;
//            totalItems = getDriver().findElements(net.serenitybdd.core.annotations.findby.By.cssSelector(".profile__avatar")).size();
//            i++;
//        }
//    }

//    public void clickOnTheElementIsByXpath(String element) {
//        String xpathSelector = TestDataService.properties.getProperty(element);
//        if (xpathSelector == null) {
//            xpathSelector = element;
//        }
//        getDriver().findElement(By.xpath(xpathSelector)).click();
//    }


//    public void thePageShowErrorMessageIs(String errorMess) {
//        TestCase.assertEquals(errorMess, getDriver().findElement(By.cssSelector("div.top-message-overlay > div.top-message-text > div")).getText());
//    }
//    public void assertMsg (String expectedMsg, String msgLocator){
//        String expectedMess = TestDataService.properties.getProperty(expectedMsg);
//        if (expectedMess == null){
//            expectedMess = expectedMsg;
//        }
//        String msglct = TestDataService.properties.getProperty(msgLocator);
//        if (msglct == null){
//            msglct = msgLocator;
//        }
//        TestCase.assertEquals(expectedMess, getDriver().findElement(By.cssSelector(msglct)).getText());
//    }

//    public void refreshPage() {
//        getDriver().navigate().refresh();
//    }

    public void openNewTab(String url) throws AWTException {
        Robot robot = new Robot();

        // open new browser tab
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        waitAboutSecond(2);
    }

//    public void hideAdvertisingFrame(){
//        waitUntillElementVisiableAndClick("closeAdvertisingFrame");
//    }

//    public void waitUntillElementVisiableAndClick(String element){
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        String xpathSelector = TestDataService.properties.getProperty(element);
//        if (xpathSelector == null) {
//            xpathSelector = element;
//        }
//        System.out.println(xpathSelector);
//
//        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
//
//        int size = getDriver().findElements(By.tagName("iframe")).size();
//        System.out.println("number of frame: " +size);
//
//        ArrayList<WebElement> iframeList = new ArrayList<>(getDriver().findElements(By.xpath("//div[@class='news-survey']//iframe[@data-cc-src='popup']")));
//        if(iframeList.size() != 0){
//            getDriver().switchTo().frame(1);
//            WebElement exitIcon = getDriver().findElement(By.xpath(xpathSelector));
////            WebElement exitIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelector)));
//            exitIcon.click();
//            getDriver().switchTo().defaultContent();
//        }
//
////               try{
////                   int total=getDriver().findElements(By.xpath(xpathSelector)).size();
////                   System.out.println("total close: "+total);
////                   if(total==1){
////                       WebElement exitIcon = getDriver().findElement(By.xpath(xpathSelector));
//////            WebElement exitIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSelector)));
////                       exitIcon.click();
////                       getDriver().switchTo().defaultContent();
////                   }
////               }catch (Exception e){
////                   getDriver().switchTo().defaultContent();
////               }
//    }

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
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement el = getDriver().findElement(By.cssSelector(cssSelector));
        String actualInfo = el.getText();


        if (actualInfo == null) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
            actualInfo = javascriptExecutor.executeScript("return arguments[0].value", el).toString();;

        }
        System.out.println(el);
        System.out.println(el.isDisplayed());

        TestCase.assertEquals(expectedText.toLowerCase(), actualInfo.toLowerCase());



    }
    public void validatePrice(String element, String expectedInfo) {

        String cssSelector = TestDataService.properties.getProperty(element);
        if (cssSelector == null){
            cssSelector = element;
        }
        String expectedText = TestDataService.properties.getProperty(expectedInfo);
        if (expectedText == null) {
            expectedText = expectedInfo;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement el = getDriver().findElement(By.cssSelector(cssSelector));
        String actualInfo = el.getText();


        if (actualInfo == null) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
            actualInfo = javascriptExecutor.executeScript("return arguments[0].value", el).toString();;

        }
        System.out.println(el);
        System.out.println(el.isDisplayed());

        TestCase.assertEquals(expectedText.substring(2), actualInfo.substring(1));



    }
    public void validateNumber(String element, String expectedInfo) {

        String cssSelector = TestDataService.properties.getProperty(element);
        if (cssSelector == null) {
            cssSelector = element;
        }
        String expectedText = TestDataService.properties.getProperty(expectedInfo);
        if (expectedText == null) {
            expectedText = expectedInfo;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement el = getDriver().findElement(By.cssSelector(cssSelector));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        String actualInfo = javascriptExecutor.executeScript("return arguments[0].value", el).toString();
        ;

        System.out.println(el);
        System.out.println(el.isDisplayed());

        TestCase.assertEquals(expectedText, actualInfo);

    }



    public void moveMouseOver(String element) {
        String elCSSselector = TestDataService.properties.getProperty(element);
        if (elCSSselector == null) {
            elCSSselector = element;

        }
        WebElement movedToElement = getDriver().findElement(By.cssSelector(elCSSselector));
        Actions action = new Actions(getDriver());
        action.moveToElement(movedToElement).perform();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void hoverThenClickOn(String arg0, String arg1) {
        String elToHoverLocator = TestDataService.properties.getProperty(arg0);
        if (elToHoverLocator == null) {
            elToHoverLocator = arg0;
        }
        String elToClickLocator = TestDataService.properties.getProperty(arg1);
        if (elToClickLocator == null) {
            elToClickLocator = arg1;
        }


        WebElement elToHover = getDriver().findElement(By.cssSelector(elToHoverLocator));

        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";


        ((JavascriptExecutor) getDriver()).executeScript(javaScript, elToHover);

        WebElement elToClick = getDriver().findElement(By.cssSelector(elToClickLocator));


        ((JavascriptExecutor) getDriver()).executeScript(javaScript, elToClick);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        elToClick.click();


    }

    public void waitUntilElementDisapear(String arg0) {
        String elCSSlocator = TestDataService.properties.getProperty(arg0);
        if (elCSSlocator == null) {
            elCSSlocator = arg0;
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(elCSSlocator)));
        System.out.println("check wait element disapear");


    }

    public void selectRadioBox(String element) {
        String elCSSLocator = TestDataService.properties.getProperty(element);
        if (elCSSLocator == null) {
            elCSSLocator = element;
        }

        WebElement el = getDriver().findElement(By.cssSelector(elCSSLocator));
        System.out.println(el.isEnabled());
        el.click();
        System.out.println(el.isSelected());

    }

    public void chooseAnItem() {
        waitAboutSecond(3);
        waitUntilElementDisapear(loadingMaskLocator);
        getDriver().findElement(By.cssSelector(theFirstItemLocator)).click();
//        waitAboutSecond(3);

    }

    public void actionConfirmation() {
        clickOn(confirmBtnLocator);
        waitAboutSecond(20);




    }

    public void validateResultMsg(String message) {
        validateInformation(messageLocator,message);

    }



//    ----Lan's code


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
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebDriverWait waiter = new WebDriverWait(getDriver(), 15);
//        System.out.println("css " + cssSelector);
        WebElement el = waiter.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        el.click();
        System.out.println("clicked");
        waitAboutSecond(3);
//        getDriver().findElement(By.cssSelector(cssSelector)).click();

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
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String realUrl = getDriver().getCurrentUrl();
        TestCase.assertEquals(urlName, realUrl);
        return false;
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
        WebDriverWait wait = new WebDriverWait(getDriver(),15);
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
        el.clear();
        el.sendKeys(inputTxt);
//        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(inputTxt);
        System.out.println(text);
    }
    public void enterTextIntoField(String text, String fieldName) {
        String cssSelector = TestDataService.properties.getProperty(fieldName);
        String inputTxt = TestDataService.properties.getProperty(text);
        if (cssSelector == null) {
            cssSelector = fieldName;
        }
        if (inputTxt == null) {
            inputTxt = text;
        }
        WebDriverWait wait = new WebDriverWait(getDriver(),15);
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
        el.clear();
        el.sendKeys(inputTxt+Keys.ENTER);
//        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(inputTxt);
        System.out.println(text);
        waitAboutSecond(3);
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


    public void scrollToAndClick(String button) {
        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            cssSelector = button;
        }
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebElement Element = getDriver().findElement(By.cssSelector(cssSelector));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", Element);
        Element.click();
        System.out.println(Element);
    }

    public void selectOption(String element, String selectObject){
        String elCssSelector = TestDataService.properties.getProperty(element);
        if (elCssSelector == null) {
            elCssSelector = element;
        }
        String selectedText = TestDataService.properties.getProperty(selectObject);
        if (selectedText == null) {
            selectedText = selectObject;
        }
        Select selector = new Select(getDriver().findElement(By.cssSelector(elCssSelector)));
        selector.selectByValue(selectedText);
    }


    public void cleareLocalStorage() {
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.clear()");
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
        TestCase.assertEquals(errorMess, getDriver().findElement(By.cssSelector("div.top-message-overlay > div.top-message-text > div")).getText());
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
        TestCase.assertEquals(expectedMess, getDriver().findElement(By.cssSelector(msglct)).getText());
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
    }


}




