package core;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class KeyWordAndroid {

    public KeyWordAndroid() {

    }
    private static AndroidDriver<?> driver;


    /**
     * Android native web app action keywords
     */

    public void openMobileWebApp(String androidURL, String platformName, String platformVersion, String udid) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName" , platformName);
        caps.setCapability("platformVersion" , platformVersion);
        caps.setCapability("udid" , udid);
        driver = new AndroidDriver(new URL(androidURL) , caps);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void tapElement(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        TouchAction action = new TouchAction(driver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();


    }

    /**
     * Mobile web app action keywords
     */

    public void clickElement(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public void inputText(String xpath, String text) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(text);
    }
    public void pressEnter(){
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

}
