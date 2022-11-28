package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;


public class KeywordWeb {
    private static Logger logger = LogHelper.getLogger();
    public static WebDriver driver;
    public KeywordWeb() {
    }
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
        if (rawUrl != null && !rawUrl.isEmpty()) {
            logger.info("go to url: " + rawUrl);
            logger.info("url: " + url);
            driver.get(rawUrl);
        }
    }

    public void openNewTab(String url) {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        // driver.navigate().to(url);
        String URL = PropertiesFile.getPropValue(url);
        if (URL == null) {
            URL = url;
        }
        navigateToUrl(URL);
    }

    public void closeBrowser() {
        logger.info("close browser: ");
        driver.quit();
    }

    public void clearText(String element) {
        logger.info("clearText");
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        driver.findElement(By.xpath(xPathElement)).clear();
    }

    public void click(String element) {
        logger.info("click" + element);
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        driver.findElement(By.xpath(xPathElement)).click();
    }

    public void clickByCss(String element) {
        logger.info("click" + element);
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        driver.findElement(By.cssSelector(xPathElement)).click();
    }

    public void randomElement(String element) {
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        List<WebElement> weblist = driver.findElements(By.xpath(xPathElement));
        int size = weblist.size();
        int randnMumber = ThreadLocalRandom.current().nextInt(0, size);
        weblist.get(randnMumber).click();

    }

    public void randomConcatElement(String element, int num) throws InterruptedException {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomNumber = random.nextInt(1, num);
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        String ele = xPathElement + "[" + randomNumber + "]";
        Thread.sleep(1000);
        driver.findElement(By.xpath(ele)).click();
    }

    public String getText(String element) {
        logger.info("get Text of" + element);
        String text = PropertiesFile.getPropValue(element);
        if (text == null) {
            text = element;
        }
        return driver.findElement(By.xpath(text)).getText();
    }

    public void sendKeys(String element, String content) {
        logger.info("send keys" + element + "with " + content);
        String xPathElement1 = PropertiesFile.getPropValue(element);
        String xPathElement2 = PropertiesFile.getPropValue(content);
        if (xPathElement1 == null) {
            xPathElement1 = element;
        }
        if (xPathElement2 == null) {
            xPathElement2 = content;

        }
        driver.findElement(By.xpath(xPathElement1)).sendKeys(xPathElement2);
    }

    public String getTextWithOutCharacters(String element, String oldChar) {
        logger.info("getText of " + element + " without " + oldChar);
        String xPathElement1 = PropertiesFile.getPropValue(element);
        String xPathElement2 = PropertiesFile.getPropValue(oldChar);
        if (xPathElement1 == null) {
            xPathElement1 = element;
        }
        if (xPathElement2 == null) {
            xPathElement2 = oldChar;

        }
        return driver.findElement(By.xpath(xPathElement1)).getText().replace(xPathElement2, "");
    }


    public String removeLastChar(String str) {
        return str.isEmpty() ? "" : str.substring(0, str.length() - Character.charCount(str.codePointBefore(str.length())));
    }

    public void doubleClick(String element) {
        logger.info("double click" + element);
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        Actions builder = new Actions(driver);
        WebElement elementRep = driver.findElement(By.xpath(xPathElement));
        builder.doubleClick(elementRep).perform();
    }

    public void dragAndDropToObj(String startElement, String endElement) {
        logger.info("drag from" + startElement + " to" + endElement);
        String xPathElement1 = PropertiesFile.getPropValue(startElement);
        if (xPathElement1 == null) {
            xPathElement1 = startElement;
        }
        String xPathElement2 = PropertiesFile.getPropValue(endElement);
        if (xPathElement2 == null) {
            xPathElement2 = endElement;
        }
        Actions builder = new Actions(driver);
        WebElement source = driver.findElement(By.xpath(xPathElement1));
        WebElement target = driver.findElement(By.xpath(xPathElement2));
        builder.dragAndDrop(source, target).perform();
    }

    public void rightClick(String element, String menuItem) {
        logger.info("rightClick" + element);
        String xPathElement1 = PropertiesFile.getPropValue(element);
        if (xPathElement1 == null) {
            xPathElement1 = element;
        }
        String xPathElement2 = PropertiesFile.getPropValue(menuItem);
        if (xPathElement2 == null) {
            xPathElement2 = menuItem;
        }
        Actions builder = new Actions(driver);
        WebElement clickMe = driver.findElement(By.xpath(xPathElement1));
        WebElement editMenuItem = driver.findElement(By.xpath(xPathElement2));
        builder.contextClick(clickMe).moveToElement(editMenuItem).click().perform();
    }

    public void hoverAndClick(String element) {
        logger.info("Move To Element" + element);
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        Actions action = new Actions(driver);
        WebElement elementRep = driver.findElement(By.xpath(xPathElement));
        action.moveToElement(elementRep).perform();
    }
    public void hoverAndClicks(String element) {
        logger.info("Move To Element" + element);
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        Actions action = new Actions(driver);
        WebElement elementRep = driver.findElement(By.xpath(xPathElement));
        action.moveToElement(elementRep).clickAndHold();
    }

    public void executeJavaScript(String command) {
        logger.info("Executing JavaScript");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(command);
    }


    public void takeScreenshot(String imgformat, String srcpath) throws
            IOException, InterruptedException, AWTException {
        logger.info("Taking screenshot save to:" + srcpath);
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, imgformat, new File(srcpath));
    }

    public void maximizeWindow() {
        logger.info("Maximizing browser window...");
        driver.manage().window().maximize();
    }

    public void back() {
        logger.info("Back window...");
        driver.navigate().back();
    }

    public void reLoadPage() {
        logger.info("ReLoad Page...");
        driver.navigate().refresh();
    }

    public void navigateToUrl(String url) {
        logger.info("Navigating to URL..." + url);
        String xPathElement = PropertiesFile.getPropValue(url);
        if (xPathElement == null) {
            xPathElement = url;
        }
        driver.navigate().to(xPathElement);
    }

    public void getCurrentPageUrl() {
        logger.info("Navigating to URL...");
        driver.getCurrentUrl();
    }

    public void acceptAlert() {
        logger.info("Accepting alert...");
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getAlertText() {
        logger.info("Getting alert text...");
        Alert alert = driver.switchTo().alert();
        return alert.getText();

    }

    public void dismissAlert() {
        logger.info("Dismissing alert...");
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void setAlertText(String alertText) {
        logger.info("Setting alert text...");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(alertText);
        alert.accept();
    }

    //send username and password to alert login
    public void handleLoginPopup(String username, String password, String authenUrl) {
        logger.info("login by authen link with" + username + " " + password);
        String xPathElement1 = PropertiesFile.getPropValue(username);
        if (xPathElement1 == null) {
            xPathElement1 = username;
        }
        String xPathElement2 = PropertiesFile.getPropValue(password);
        if (xPathElement2 == null) {
            xPathElement2 = password;
        }
        String xPathElement3 = PropertiesFile.getPropValue(authenUrl);
        if (xPathElement3 == null) {
            xPathElement3 = authenUrl;
        }
        String url = "https://" + xPathElement1 + ":" + xPathElement2 + "@" + xPathElement3;
        driver.navigate().to(url);
    }

    public void switchToFrame(String frame) {
        logger.info("Switching to frame...");
        driver.switchTo().frame(frame);
    }

    public void switchToFrameByIndex(int index) {
        logger.info("Switching to frame by index...");
        driver.switchTo().frame(index);
    }

    public void switchToIFrame() {
        logger.info("Switching to Iframe");
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
    }

    public void listWindowID() {
        for (String windowid : driver.getWindowHandles()) {
            logger.info("Listing window ID..." + windowid);
        }
    }

    public void switchToIFrameByXpath(String element) {
        logger.info("Switching to Iframe");
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        WebElement iframe = driver.findElement(By.xpath(xPathElement));
        driver.switchTo().frame(iframe);
    }

    public void switchToWindow(String window) {
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

    public void switchToParentWindow() {
        logger.info("switchToParentWindow");
        String parentWindowId = driver.getWindowHandle();
        driver.switchTo().window(parentWindowId);
    }

    public void simpleAssertEquals(String expected, String actual) {
        logger.info("compare from " + expected + " with " + actual);
        String xPathElement1 = PropertiesFile.getPropValue(expected);
        if (xPathElement1 == null) {
            xPathElement1 = expected;
        }
        String xPathElement2 = PropertiesFile.getPropValue(actual);
        if (xPathElement2 == null) {
            xPathElement2 = actual;
        }
        Assert.assertEquals(actual, expected);

    }

    public void switchToTab(int tabNum) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNum));
    }


    public void closeWindowByIndex(int index) {
        logger.info("closeWindowByIndex");
        switchToWindowByIndex(index);
        driver.close();
    }

    public void closeTab(int tabNum) {
        switchToTab(tabNum);
        driver.close();
    }

    public void closeWindowTitle(String title) {
        for (String windowid : driver.getWindowHandles()) {
            String windowTitle = driver.switchTo().window(windowid).getTitle();
            if (windowTitle.equals(title)) {
                driver.close();
                break;
            }
        }
    }

    public void scrollDownToElement(String xPath) {
        logger.info("scrollDownToElement" + xPath);
        String xPathElement = PropertiesFile.getPropValue(xPath);
        if (xPathElement == null) {
            xPathElement = xPath;
        }
        WebElement element = driver.findElement(By.xpath(xPathElement));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void scrollDownToElementByCss(String element) {
        logger.info("scroll to element");
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        WebElement elements = driver.findElement(By.cssSelector(xPathElement));
        Actions actions = new Actions(driver);
        actions.moveToElement(elements);
        actions.perform();
    }

    public void scrollToPosition() {
        logger.info(" scrolling to position ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)");
    }

    public void scrollToReversePosition() {
        logger.info(" scrolling to position ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-5000)");
    }

    public void switchToDefaultContent() {
        logger.info("SwitchTODefaultContent");
        driver.switchTo().defaultContent();
    }

    public void recaptchaClick() {
        logger.info("click recaptcha");
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha/api2/anchor?ar=1')]")));

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border"))).click();
    }

    //verify keyword
    public boolean verifyElementPresent(String element) {
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        try {
            driver.findElement(By.xpath(xPathElement));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void selectDropDownListByIndex(String ddlPath, String itemName) {
        logger.info("select item by visibe text");
        String xPathElement1 = PropertiesFile.getPropValue(ddlPath);
        if (xPathElement1 == null) {
            xPathElement1 = ddlPath;
        }
        String xPathElement2 = PropertiesFile.getPropValue(itemName);
        if (xPathElement2 == null) {
            xPathElement2 = itemName;
        }
        Select dropDownList = new Select(driver.findElement(By.xpath(xPathElement1)));
        dropDownList.selectByVisibleText(xPathElement2);

    }

    public boolean verifyElementVisible(String element) {
        logger.info("verifyElementVisible" + element);
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        try {
            driver.findElement(By.xpath(xPathElement)).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean CheckIsDisplayElement(String element) {
        logger.info("Check status element btn radio");
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        boolean stt = driver.findElement(By.xpath(xPathElement)).isDisplayed();
        if (!stt) {
            System.out.println("Not selected");
        } else {
            driver.navigate().back();
            System.out.println("Checkbox selected");
        }
        return stt;
    }

    public boolean checkStatusIsDisplay(String element) {
        logger.info("Check status ");
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        boolean status = driver.findElement(By.xpath(xPathElement)).isDisplayed();
        if (status) {
            System.out.println("Is Display" + "\t" + element);
        } else {
            System.out.println("Is not Display" + "\t" + element);
        }
        return status;
    }
    // wait keywords

    public void imWait(long timeout) {
        logger.info("implicitlyWait");
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }
    public void webDriverWaitForElementPresent(String element, long timeout) {
        logger.info("webDriverWaitForElementPresent" + element);
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathElement)));
    }

    public void webDriverWaitForElementPresentByCss(String element, long timeout) {
        logger.info("webDriverWaitForElementPresentByCss");
        String xPathElement = PropertiesFile.getPropValue(element);
        if (xPathElement == null) {
            xPathElement = element;
        }
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(xPathElement)));
    }

    public void fluentWaitForElementPresent(String element, Duration polling, Duration timeout) {
        logger.info("fluentWaitForElementPresent");
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public void deleteInput() {
        ((JavascriptExecutor) driver).executeScript("document.getElementByClass('input-box').reset()");
        System.out.printf("clear.....");
    }

    public void assertEquals(String expected, String actual) {
        logger.info("compare from " + expected + " with " + actual);
        String xPathElement1 = PropertiesFile.getPropValue(expected);
        String xPathElement2 = PropertiesFile.getPropValue(actual);
        if (xPathElement1 == null) {
            xPathElement1 = expected;
        }
        if (xPathElement2 == null) {
            xPathElement2 = actual;
        }
        String actualText = driver.findElement(By.xpath(xPathElement2)).getText();
        Assert.assertEquals(actualText, xPathElement1);

    }

}
