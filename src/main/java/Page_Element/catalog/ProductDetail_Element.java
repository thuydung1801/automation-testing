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

    @FindBy(xpath = "(//span[@class='selector-item selector-item-img'])[1]") public WebElement clickImg;
    @FindBy(css = "button.mz-button.mz-button-close") public WebElement clickClose;

    //---------Default option-------
    @FindBy(xpath = "//div[@id='stone_diamonds']//div[@class='option_label inactive']") public WebElement mainStone;
    @FindBy(css = "div[id='stone_2'] div[class='option_label inactive']") public WebElement stone2;
    @FindBy(xpath = "//div[@id='alloy_colour']//div[@class='option_label inactive']") public WebElement metal_alloy;
    @FindBy(xpath = "//div[@id='engraving']//div[@class='option_label inactive']") public WebElement engraving;
    @FindBy(css = "div[placeholder='Bitte geben Sie Ihren Text hier ein']") public WebElement engravingText;
    @FindBy(xpath = "//div[@class='dropdown-input sprite-bf']") public WebElement clickDropdown;
    @FindBy(xpath = "//option[@value='15,3']") public WebElement clickOptionSize;

    @FindBy(xpath = "//button[@id='product-addtocart-button']") public WebElement clickBtnAddCart;

    @FindBy(xpath = "//a[@title='warenkorb']") public WebElement clickCart;
    @FindBy(xpath = "//a[@class='action primary viewcart']") public WebElement viewCart;

    @FindBy(xpath = "(//span[contains(text(),'View Detail')])[1]") public WebElement viewDetail;
    @FindBy(xpath = "(//div[@class='option-detail add-engraving'])[2]") public WebElement getTextengr;
    @FindBy(linkText = "Stay Here on www.glamira.de") public WebElement clickAllow;
//------------Quantity option for earring men---------
    @FindBy(css = "#ui-id-202") public WebElement hoverMens;
    @FindBy(xpath = "(//font[contains(text(),'earrings')])[2]") public WebElement clickEaring;

    //------------Dimension Guide/ Find size----------
    @FindBy(xpath = "//span[@class='discover-size link']") public WebElement optionSize;
    @FindBy(xpath = "(//div[@id='ringsize-link-form'])[2]") public WebElement optionFindSize;
    @FindBy(xpath = "//font[contains(text(),'ring size guide.')]") public WebElement pageSizeGuide;

    //-----------------Form free a ring size------
    @FindBy(xpath = "(//div[contains(@class,'collapse-title sprite-bf')])[6]") public WebElement optionFreeSize;
    @FindBy(xpath = "//input[@id='firstname']") public WebElement prd_FirstName;
    @FindBy(xpath = "//input[@id='lastname']") public WebElement prd_LastName;
    @FindBy(xpath = "//input[@id='email_address']") public WebElement prd_Email;
    @FindBy(xpath = "//input[@id='street_1']") public WebElement prd_Street;
    @FindBy(xpath = "//input[@id='zip']") public WebElement prd_Code;
    @FindBy(xpath = "//input[@id='city']") public WebElement prd_City;
    @FindBy(xpath = "(//body)[1]") public WebElement check1;
    @FindBy(xpath = "(//input[@id='agreement-36'])[1]") public WebElement check2;
    @FindBy(css = "form[id='form-validate-ringsizer'] button[title='From you']") public WebElement prd_submit;


//    @FindBy(xpath = "//span[@class='discover-size link']") public WebElement optionSize;




    public ProductDetail_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
