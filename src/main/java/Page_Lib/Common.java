package Page_Lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Common {
    static RemoteWebDriver driver ;

    public Common(RemoteWebDriver driver) {
        this.driver = driver;
    }
    public void click(WebElement element , String mes){
        System.out.printf("click :" + mes + "\n");
        element.click();
    }
    public  void sendKey(WebElement element , String text){
        System.out.printf("sendKey :" + text + "\n");
        element.sendKeys(text);
    }


}
