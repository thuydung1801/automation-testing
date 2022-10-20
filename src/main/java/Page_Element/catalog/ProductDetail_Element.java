package Page_Element.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductDetail_Element {
    RemoteWebDriver driver;
    @FindBy(css = "button.amgdprcookie-button.-allow") public WebElement submitCookie;
    @FindBy(xpath = "(//div[@class='product-item-info'])[1]") public WebElement clickProduct;

    @FindBy(xpath = "//div[@id='product-media-container']//a[1]") public WebElement clickShowImg1;
    @FindBy(xpath = "(//a[@class='selector-item selector-item-img'])[2]") public WebElement clickShowImg2;
    @FindBy(xpath = "(//a[@class='selector-item selector-item-video'])[1]") public WebElement clickShowVideo3;

    @FindBy(xpath = "//main[@id='maincontent']//a[1]//img[1]") public WebElement clickImg;
    @FindBy(xpath = "(//button[@type='button'])[17]") public WebElement clickClose;

    //---------Default option-------
    @FindBy(xpath = "//div[@id='stone_diamonds']//div[@class='option_label inactive']") public WebElement mainStone;
    @FindBy(css = "div[id='stone_2'] div[class='option_label inactive']") public WebElement stone2;
    @FindBy(xpath = "//div[@id='alloy_colour']//div[@class='option_label inactive']") public WebElement metal_alloy;
    @FindBy(xpath = "//div[@id='engraving']//div[@class='option_label inactive']") public WebElement engraving;
    @FindBy(xpath = "//div[@placeholder='Please enter your text here']") public WebElement engravingText;
    @FindBy(xpath = "//div[@class='dropdown-input sprite-bf']") public WebElement clickDropdown;
    @FindBy(xpath = "//option[@value='15,3']") public WebElement clickOptionSize;

    @FindBy(xpath = "//button[@id='product-addtocart-button']") public WebElement clickBtnAddCart;

    @FindBy(xpath = "//a[@title='warenkorb']") public WebElement clickCart;
    @FindBy(xpath = "//a[@class='action primary viewcart']") public WebElement viewCart;

    @FindBy(xpath = "(//span[contains(text(),'View Detail')])[1]") public WebElement viewDetail;
    @FindBy(xpath = "(//div[@class='option-detail add-engraving'])[2]") public WebElement getTextengr;
    @FindBy(linkText = "Stay Here on www.glamira.de") public WebElement clickAllow;
//
//    @FindBy(xpath = "") public WebElement ;
//    @FindBy(xpath = "") public WebElement ;
//    @FindBy(xpath = "") public WebElement ;





    public ProductDetail_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
