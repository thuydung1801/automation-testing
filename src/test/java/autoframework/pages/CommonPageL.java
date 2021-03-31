package autoframework.pages;

import autoframework.service.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import static org.apache.xml.serialize.LineSeparator.Web;


public class CommonPageL extends PageObject {
    String theFirstItemLocator = "table.data-grid tbody tr:nth-of-type(1) input";
    String loadingMaskLocator = "div.loading-mask";
    String confirmBtnLocator = "div.modal-inner-wrap button.action-accept";
    String messageLocator = "div.messages div div";
    String userNameLocator = "#username";
    String passwordLocator = "#login";
    String loginBtnLocator = "button.action-login";


    public void loginAdminPageWithAnd(String adminPage, String account, String password) {
        this.gotoUrl(adminPage);
        insertIntoField(account,userNameLocator);
        insertIntoField(password,passwordLocator);
        click(loginBtnLocator);

    }


    public void gotoUrl(String urlName) {
        String url = TestDataService.properties.getProperty(urlName);
        if (url == null) {
            url = urlName;
        }
        getDriver().get(url);
        getDriver().manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }


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
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebDriverWait waiter = new WebDriverWait(getDriver(), 15);
//        System.out.println("css " + cssSelector);
        WebElement el = waiter.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        el.click();
        System.out.println("clicked");
        waitAboutSecond(5);
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

    public String getCurrentUrl() {
        System.out.println(getDriver().getCurrentUrl());
        return getDriver().getCurrentUrl();
    }

    public void redirectToLink(String url) {
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
        assertEquals(urlName, realUrl);
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
        System.out.println(actualInfo);
        System.out.println(expectedText);
        boolean validation = actualInfo.toLowerCase().contains(expectedText.toLowerCase());
        assertEquals(true, validation);


//        assertEquals(expectedText.toLowerCase(), actualInfo.toLowerCase());



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

        assertEquals(expectedText.substring(2), actualInfo.substring(1));



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

        assertEquals(expectedText, actualInfo);

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
        click(confirmBtnLocator);
        waitAboutSecond(20);




    }

    public void validateResultMsg(String message) {
        validateInformation(messageLocator,message);

    }

//    public void isExitElement(String arg0) {
//        String elCSSlocator = TestDataService.properties.getProperty(arg0);
//        if (elCSSlocator == null) {
//            elCSSlocator = arg0;
//        }
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        WebElement element = getDriver().findElement(By.cssSelector(elCSSlocator));
//
//
//    }
}


