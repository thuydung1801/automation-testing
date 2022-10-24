package Page_Element.CheckOut;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MiniCart_Element {
    RemoteWebDriver driver;
//=======================ADD TO CART============================
    @FindBy(xpath = "(//a[@class='product photo product-item-photo'])[14]") public WebElement SelectProductCheckOut;
    @FindBy(xpath = "(//button[@id='product-addtocart-button'])[1]']") public WebElement AddToCarts;

//    ACCep Cookies
    @FindBy(css ="div.amgdprcookie-bar-container" ) public  WebElement checkCookies;
    @FindBy(css ="button.amgdprcookie-button.-allow" ) public  WebElement ClickBtnAccCookies;

    @FindBy(css = "div.tab-content.content-popup.geoip-popup-content") public WebElement CheckBookSwitchTo;

    @FindBy (css = "span.geoip-close") public WebElement CloseBook;

//Select Size
    @FindBy(css = "div.dropdown-input.sprite-bf") public WebElement isDisplayBookRingSize;
    @FindBy(xpath = "//div[@class='dropdown-container']") public WebElement isDisplayContentRingSize;
    @FindBy(xpath = "//option[@value='21']") public WebElement selectRingSize;


    public MiniCart_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
