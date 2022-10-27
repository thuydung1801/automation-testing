package step;

import core.KeyWordAndroid;
import core.PropertiesFile;
import io.cucumber.java.en.Given;

import java.net.MalformedURLException;

public class CCB {
    public CCB() {

    }
    KeyWordAndroid mobile = new KeyWordAndroid();
   @Given("^Mobile browser is on the google page$")
   public void mobileBrowserIsOnTheGooglePage() throws MalformedURLException {
       PropertiesFile.setPropertiesFile();
       mobile.openMobileWebApp(PropertiesFile.getPropValue("APPIUM_URL"),
               PropertiesFile.getPropValue("PLATFORM_NAME"),
               PropertiesFile.getPropValue("PLATFORM_VERSION"),
               PropertiesFile.getPropValue("UDID"));
       //mobile.swipeScreen(UP);
       mobile.tapElement(PropertiesFile.getPropValue("TEXT_CHROME"));
   }
}
