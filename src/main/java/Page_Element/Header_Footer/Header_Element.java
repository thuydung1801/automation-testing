package Page_Element.Header_Footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header_Element {
//    WebDriver driver;
  //  ChromeDriver driver;
    RemoteWebDriver driver;
    @FindBy(xpath = "//span[@class='authorization-text']") public WebElement headerLogin;

    @FindBy(xpath = "//input[@id='search']") public WebElement headerSearch;

    @FindBy(xpath = "(//button[@title='Search'])[2]") public WebElement headerBtnSearch;

    @FindBy(xpath = "//span[@class='remove_search_keyword active']") public WebElement headerBtnNext;


    public Header_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


}
