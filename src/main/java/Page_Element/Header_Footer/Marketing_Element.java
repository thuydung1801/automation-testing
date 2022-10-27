package Page_Element.Header_Footer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Marketing_Element {
    RemoteWebDriver driver;
//    @FindBy(xpath = "//input[@id='zip']") public WebElement prd_Code;
    @FindBy(xpath = "//input[@placeholder='Ann Walker']") public WebElement ipName;

    @FindBy(xpath = "//div[@class ='amcard-form-container']/div[2]/input[1]") public WebElement ipMail;

//    @FindBy(xpath = "//input[@id='zip']") public WebElement prd_Code;



    public Marketing_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
