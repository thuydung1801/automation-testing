package autoframework.pages;

import autoframework.service.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class H_CommonPages extends PageObject {

    public void goTotheUrl(String urlName) throws InterruptedException {
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
    //hover and click chuột
    public void hoverThenClickOn(String arg0, String arg1){
        String elToHoverLocator = TestDataService.properties.getProperty(arg0);
        if (elToHoverLocator == null) {
            elToHoverLocator = arg0;
        }
        String elToClickLocator = TestDataService.properties.getProperty(arg1);
        if (elToClickLocator == null) {
            elToClickLocator = arg1;
        }


        WebElement elToHover = getDriver().findElement(By.xpath(elToHoverLocator));

        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";


        ((JavascriptExecutor) getDriver()).executeScript(javaScript, elToHover);

        WebElement elToClick = getDriver().findElement(By.xpath(elToClickLocator));


        ((JavascriptExecutor) getDriver()).executeScript(javaScript, elToClick);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        elToClick.click();


    }
    //select ring size
    public void Clickon(String arg0){

        String elCssSelector = TestDataService.properties.getProperty(arg0);
        if (elCssSelector == null) {
            elCssSelector = arg0;
        }
//        String selectedText = TestDataService.properties.getProperty(arg1);
//        if (selectedText == null) {
//            selectedText = arg1;
//        }
//        Select selector = new Select(getDriver().findElement(By.xpath(elCssSelector)));
        try {
            Thread.sleep(800);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.xpath(elCssSelector)).click();
        waitAboutSecond(5);
        //  selector.selectByValue(selectedText);
    }

    //time wait
    public void waitAboutSecond(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //chyen huong trang
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

    //input text and enter
    public void enterTextIntoField(String text, String fieldName) {
        String cssSelector = TestDataService.properties.getProperty(fieldName);
        String inputTxt = TestDataService.properties.getProperty(text);
        if (cssSelector == null) {
            cssSelector = fieldName;
        }
        if (inputTxt == null) {
            inputTxt = text;
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
        el.sendKeys(inputTxt + Keys.ENTER);
//        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(inputTxt);
        System.out.println(text);
    }
    //scroll chuot
    public void scrollTo(By by) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(by));
    }
    //ham click moi
    public void click(By by) {
        int i = 0;
        while (i < 3) {
            try {
                getDriver().findElement(by).click();
                break;
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void scrollToAndClick(String button) {
        String cssSelector = TestDataService.properties.getProperty(button);
        if (cssSelector == null) {
            cssSelector = button;
        }
        WebElement Element = getDriver().findElement(By.xpath(cssSelector));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", Element);
        Element.click();
        System.out.println(Element);
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
        ArrayList<WebElement> filterItemList = new ArrayList<>(getDriver().findElements(By.xpath(cssSelector)));
        System.out.println("filter item have size " + filterItemList.size());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", filterItemList.get(0));
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

        assertEquals(expectedText.toLowerCase(), actualInfo.toLowerCase());
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
    public void OpenNewTab(String url){
        try {
            //Ra lệnh cho rô-bốt mở tab mới
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);

            //Đoạn này để nhảy sang tab mới
            waitAboutSecond(1); // wait cho nay 1s cho` tab no open han ra
            ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
            waitAboutSecond(1);
            getDriver().switchTo().window(tabs.get(1));
            //Mở link mới trên tab mới
            String Link = TestDataService.properties.getProperty(url);
            if (Link== null){
                Link = url;
            }
            getDriver().get(Link);
            waitAboutSecond(5);
            //getDriver().switchTo().window(tabs.get(0));
            waitAboutSecond(5);

        } catch (AWTException e) {
            e.printStackTrace();

        }
    }
}


