package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import org.testng.Assert;
public class KeywordWeb {
    private static Logger logger = LogHelper.getLogger();
    private static WebDriver driver;
    public KeywordWeb() {}
    public void openBrowser(String browser, String... url) {
        logger.info("Open browser");
        switch (browser.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "EGDE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        logger.info("open browser successfully" + browser);
        String rawUrl = url.length > 0 ? url[0] : "";
        if (rawUrl!= null && !rawUrl.isEmpty()){
            logger.info("go to url: " + rawUrl);
            logger.info("url: " + url);
            driver.get(rawUrl);
        }
    }

    public void closeBrowser(){
        logger.info("close browser: ");
        driver.quit();
    }
    public void click(String element){
        logger.info("click" + element);
        driver.findElement(By.xpath(element)).click();
    }
    public String getText(String element){
        logger.info("get Text of"+ element);
        String text = driver.findElement(By.xpath(element)).getText();
        return text;
    }
    public void sendKeys(String element, String content){
        logger.info("send keys" + element);
        driver.findElement(By.xpath(element)).sendKeys(content);

    }

    public void doubleClick(String element){
        logger.info("double click" + element);
        Actions builder = new Actions(driver);
        WebElement elementRep = driver.findElement(By.xpath(element));
        builder.doubleClick(elementRep).perform();
    }

    public void dragAndDropToObj(String startElement, String endElement){
        logger.info("drag from" + startElement + " to" + endElement );
        Actions builder = new Actions(driver);
        WebElement source = driver.findElement(By.xpath(startElement));
        WebElement target = driver.findElement(By.xpath(endElement));
        builder.dragAndDrop(source, target).perform();
    }

    public void rightClick(String element, String menuItem) {
        logger.info("rightClick" + element);
        Actions builder = new Actions(driver);
        WebElement clickMe = driver.findElement(By.xpath(element));
        WebElement editMenuItem = driver.findElement(By.xpath(menuItem));
        builder.contextClick(clickMe).moveToElement(editMenuItem).click().perform();
    }

    public void executeJavaScript(String command){
        logger.info("Executing JavaScript");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(command);
    }


    public void takeScreenshot(String imgformat, String srcpath) throws IOException, InterruptedException, AWTException {
        logger.info("Taking screenshot save to:" + srcpath);
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, imgformat, new File(srcpath));
    }

    public void maximizeWindow(){
        logger.info("Maximizing browser window...");
        driver.manage().window().maximize();
    }

    public void back(){
        logger.info("Back window...");
        driver.navigate().back();
    }
    public void navigateToUrl(String url){
        logger.info("Navigating to URL..."+ url);
        driver.navigate().to(url);
    }

    public void acceptAlert(){
        logger.info("Accepting alert...");
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String  getAlertText(){
        logger.info("Getting alert text...");
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    public void dismissAlert(){
        logger.info("Dismissing alert...");
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void setAlertText(String alertText){
        logger.info("Setting alert text...");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(alertText);
        alert.accept();
    }
    //send username and password to alert login
    public void handleLoginPopup(String username, String password, String authenUrl){
        logger.info("login by authen link with"+username+" "+password);
        String url = "https://"+username +":"+ password + "@" + authenUrl;
        driver.navigate().to(url);

    }
    public void switchToFrame(String frame){
        logger.info("Switching to frame...");
        driver.switchTo().frame(frame);
    }
    public void switchToFrameByIndex(int index){
        logger.info("Switching to frame by index...");
        driver.switchTo().frame(index);
    }
    public void switchToIFrame(){
        logger.info("Switching to Iframe");
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
    }

    public void listWindowID(){
        for(String windowid : driver.getWindowHandles()){
            logger.info("Listing window ID..." + windowid);
        }
    }
    public void switchToWindow(String window){
        logger.info("Switching to Window");
        driver.switchTo().window(window);
    }
    public void switchToWindowByIndex(int index) {
        logger.info("switchToWindowByIndex");
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(index));
    }
    public void getTitleWindowByIndex(int index) {
        logger.info("switchToWindowByIndex");
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(index)).getTitle();
    }
    public void switchToParentWindow(){
        String parentWindowId = driver.getWindowHandle();
        driver.switchTo().window(parentWindowId);
    }
    public void switchToTab(int tabNum){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNum));
    }

    public void closeWindowByIndex(int index){
        logger.info("closeWindowByIndex");
        switchToWindowByIndex(index);
        driver.close();
    }

    public void assertEquals(String expected, String actual){
        logger.info("compare from "+ expected+ " with "+ actual);
        Assert.assertEquals(expected,actual);

    }
    public void closeTab(int tabNum){
        switchToTab(tabNum);
        driver.close();
    }
    public void closeWindowTitle(String title){
        for (String windowid : driver.getWindowHandles()){
            String windowTitle = driver.switchTo().window(windowid).getTitle();
            if (windowTitle.equals(title)){
                driver.close();
                break;
            }
        }
    }
    public void scrollDownToElement(String xPath){
        logger.info("scrollDown to "+xPath);
        WebElement element = driver.findElement(By.xpath(xPath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void scrollToPosition(){
        logger.info(" scrolling to position " );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)");
    }
    public void switchToDefaultContent(){
        logger.info("SwitchTODefaultContent");
        driver.switchTo().defaultContent();
    }
    public void recaptchaClick(){
        logger.info("click recaptcha");
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha/api2/anchor?ar=1')]")));

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border"))).click();
    }
    public void selectDropDownListByIndex(String ddlPath, int index){
        logger.info("select item by visibe text");
        Select dropDownList = new Select(driver.findElement(By.xpath(ddlPath)));
        logger.info("1");
        dropDownList.selectByIndex(index);

    }


    //verify keyword
    public boolean verifyElementPresent(String element){
        try{
            driver.findElement(By.xpath(element));
            return true;
        } catch(NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean verifyElementVisible(String element){
        boolean blnVerify = false;
        try{
            blnVerify = driver.findElement(By.xpath(element)).isDisplayed();

        } catch(NoSuchElementException e){
            e.printStackTrace();
        }
        return blnVerify;
    }

    // wait keywords

    public void imWait(long timeout) {
        logger.info("implicitlyWait");
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public void webDriverWaitForElementPresent(String element, long timeout) {
        logger.info("webDriverWaitForElementPresent");
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public void fluentWaitForElementPresent(String element, Duration polling , Duration timeout){
        logger.info("fluentWaitForElementPresent");
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }


}
