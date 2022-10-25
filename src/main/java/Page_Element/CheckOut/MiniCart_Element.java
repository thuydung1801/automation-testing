package Page_Element.CheckOut;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MiniCart_Element {
    RemoteWebDriver driver;
//=======================ADD TO CART AND CHECK DETAIL ============================
    @FindBy(xpath = "(//a[@class='product photo product-item-photo'])[14]") public WebElement SelectProductCheckOut;
    @FindBy(css = "a.product.photo.product-item-photo") public WebElement SelectProductCheckOut1;
    @FindBy(css = "button#product-addtocart-button.action.primary.tocart") public WebElement AddToCarts;

//    ACCep Cookies
    @FindBy(css ="div.amgdprcookie-bar-container" ) public  WebElement checkCookies;
    @FindBy(css ="button.amgdprcookie-button.-allow" ) public  WebElement ClickBtnAccCookies;

    @FindBy(css = "div.tab-content.content-popup.geoip-popup-content") public WebElement CheckBookSwitchTo;
    @FindBy (css = "span.geoip-close") public WebElement CloseBook;
    @FindBy(xpath = "//div[@class='dropdown-input sprite-bf']") public WebElement selectRingSize;
    @FindBy(xpath = "//option[@value='23']") public WebElement SelectTypeRingSize;

//=======================CHECK VIEW CART BUTTON ============================
    @FindBy(xpath = "//a[@title='Shopping Bag']") public WebElement CheckMiniCart;
    @FindBy(xpath = "//aside[@class='modal-slide minicart modal-sm _inner-scroll _show']//button[@type='button']") public WebElement CloseCheckMiniCart;
    @FindBy(css = "a.action.primary.viewcart") public  WebElement CheckViewCart;

    @FindBy(css = "div.added-to-cart-popup") public WebElement CloseMessage;
    @FindBy(css = "div.close") public WebElement CloseIcon;

    public MiniCart_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
