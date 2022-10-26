package Page_Element.CheckOut;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutFlow_Element {
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
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[4]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[2]/a[2]") public WebElement DeleteProduct;
    @FindBy(css = "._show > div.modal-inner-wrap") public  WebElement isDisplayBookDelete;
    @FindBy(xpath = "//button[@class='action primary delete-cart-item']") public  WebElement Deletebtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[4]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/div[1]/div[3]/div[1]/label[1]/select[1]") public WebElement SelectDropdown ;
    @FindBy(css = "#shopping-cart-table div div.actions.actions-toolbar > a.action.action-view-detail") public  WebElement ViewDetail;
    @FindBy(xpath = "//aside[@class='modal-slide modal-sm modal-cart-view-detail _inner-scroll _show']//div[@class='modal-inner-wrap']") public WebElement isDisplayBook;
    @FindBy(css = "div:nth-child(6) > div:nth-child(2) > span:nth-child(1)") public WebElement ClickToAdd;

    @FindBy(xpath = "//aside[@class='modal-slide engraving-form-modal modal-sm _inner-scroll _show']//div[@class='modal-inner-wrap']") public WebElement isDissPlayBookEng;

    @FindBy(xpath = "//li[contains(@class,'font-item Snell_BT')]") public WebElement SelectFontText;
    @FindBy(css = "div.engraving-option.text-option > div > div.engraving-field-input > div.input-field-editable") public WebElement EnterText;
    @FindBy(css = "aside[role='dialog'] span:nth-child(5)") public WebElement SelectIcon;
    @FindBy(css = "button[class='button']") public WebElement SaveBtn;
    public CheckOutFlow_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
