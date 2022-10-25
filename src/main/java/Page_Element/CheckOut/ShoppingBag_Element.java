package Page_Element.CheckOut;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ShoppingBag_Element {
    RemoteWebDriver driver;

//====COOKIES======
    @FindBy(css ="div.amgdprcookie-bar-container" ) public  WebElement checkCookies;
    @FindBy(css ="button.amgdprcookie-button.-allow" ) public  WebElement ClickBtnAccCookies;

    @FindBy(css = "div.tab-content.content-popup.geoip-popup-content") public WebElement CheckBookSwitchTo;
    @FindBy (css = "span.geoip-close") public WebElement CloseBook;
    //=======================CHECK VIEW CART BUTTON ============================
    @FindBy(xpath = "//a[@title='Shopping Bag']") public WebElement CheckMiniCart;
    @FindBy(xpath = "//aside[@class='modal-slide minicart modal-sm _inner-scroll _show']//button[@type='button']") public WebElement CloseCheckMiniCart;
    @FindBy(css = "a.action.primary.viewcart") public  WebElement CheckViewCart;

    @FindBy(css = "div.added-to-cart-popup") public WebElement CloseMessage;
    @FindBy(css = "div.close") public WebElement CloseIcon;
    public ShoppingBag_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
