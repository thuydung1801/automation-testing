package Page_Lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class Common {
    static RemoteWebDriver driver ;
    @FindBy(css = "button.amgdprcookie-button.-allow") public WebElement submitCookie;
    @FindBy(linkText = "Stay Here on www.glamira.de") public WebElement clickAllow;


    public Common(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element , String mes){
        System.out.printf("click :" + mes + "\n");
        element.click();
    }
    public  void sendKey(WebElement element , String text){
        System.out.printf("sendKey :" + text + "\n");
        element.sendKeys(text);
    }
    public void submitCookie(){
        click(submitCookie , "accept cookie");
    }
    public void skipAllow(){
        click(clickAllow , "skip");

    }
    public void randomSelect(WebElement element){
//        click(productDetailElement.clickDropdown , "dropdown");
        List<WebElement> links = driver.findElements(By.xpath("(//select[@name=\'options[250976][EU]\'])[1]"));
        WebElement random = links.get(new Random().nextInt(links.size()));
        random.click();

    }


}
