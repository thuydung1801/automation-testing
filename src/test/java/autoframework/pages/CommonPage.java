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
    By msgItem = By.cssSelector(".page.messages");
    By cookieAccept = By.className("m-accept");


    public void waitAboutSeconds(int second)  {
        try {
            Thread.sleep(second * 1000L);
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
        ArrayList<WebElement> listButtonHomePage = new ArrayList<>(getDriver().findElements(By.className("authorization-text")));

        ArrayList<WebElement> bigList = new ArrayList<>();
        bigList.addAll(list);
        bigList.addAll(List);
        bigList.addAll(listButtonAdmin);

        for (WebElement webElement : bigList) {
            if (webElement.getText().equalsIgnoreCase(buttontext)) {
                System.out.println("Click button nay: " + webElement.getText());
                webElement.click();
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
        for (WebElement webElement : headerPanelRightBtnList) {
            if (webElement.getText().equalsIgnoreCase(buttontext)) {
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
        String textInsert = TestDataService.properties.getProperty(text);
        if (textInsert == null) {
            textInsert = text;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.id(id));
        Element.click();
        System.out.println(" Insert "+ text+ " into " + id);
        Element.sendKeys(textInsert);
    }
    public void insertIntoFieldByName(String text, String name) {
        String insertText = TestDataService.properties.getProperty(text);
        if (insertText == null) {
            insertText = text;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement Element = getDriver().findElement(By.name(name));
        Element.sendKeys(insertText);
        System.out.println(" Insert "+ text+ " into " + name);
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
    public void checkURl(String expectUrl)  {

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

    public void getMsgItem(String expectMsg){
        System.out.println("show actual msg:" +getDriver().findElement(msgItem).getText());
        Assert.assertEquals(expectMsg,getDriver().findElement(msgItem).getText());
    }
    public void acceptCookie(){
        getDriver().findElement(cookieAccept).click();
    }

    public void showErrorMessageForBlankById(String id, String msg) {
//        String idElement = TestDataService.properties.getProperty(id);
//        if (idElement == null) {
//            idElement = id;
//        }
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        WebElement Element = getDriver().findElement(By.id(id));
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
    public void waitAboutSecond(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}




