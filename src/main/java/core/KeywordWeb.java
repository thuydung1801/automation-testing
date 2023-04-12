package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

import static core.BaseTest.getDriver;

public class KeywordWeb {
    //    final AppiumDriver<MobileElement> driver = getDriver();
    public static Logger logger = LogHelper.getLogger();
    public static AndroidDriver<MobileElement> driver;
    //    public static MobileElement driver;
    public static WebDriverWait wait;

    public KeywordWeb() throws MalformedURLException {
//        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        wait= new WebDriverWait(driver,10);
    }
    public void navigateToUrl(String url) throws InterruptedException {
        logger.info("Navigating to URL..." + url);
        String xPathElement = PropertiesFile.getPropValue(url);
        if (xPathElement == null) {
            xPathElement = url;
        }
        driver.navigate().to(xPathElement);
    }
    public void click(String element) {
        logger.info("click" + element);
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
//        driver.findElement(By.xpath(xPathElement)).click();
        driver.findElementByXPath(xPathElement).click();
    }
    public void clickById(String element) {
        logger.info("click" + element);
        System.out.printf("====" +PropertiesFile.getPropValue(element) );
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
//        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(xPathElement)));
        driver.findElement(By.id(xPathElement)).click();
//        driver.findElementById(xPathElement).click();
//        ele.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(xPathElement))).click();
    }
}
