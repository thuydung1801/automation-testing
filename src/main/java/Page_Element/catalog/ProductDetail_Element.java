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
    @FindBy(xpath = "(//div[@class='product-item-info'])[1]") public WebElement clickProduct;

    @FindBy(xpath = "//div[@id='product-media-container']//a[1]") public WebElement clickShowImg1;
    @FindBy(xpath = "(//a[@class='selector-item selector-item-img'])[2]") public WebElement clickShowImg2;
    @FindBy(xpath = "(//a[@class='selector-item selector-item-video'])[1]") public WebElement clickShowVideo3;

    @FindBy(xpath = "//main[@id='maincontent']//a[1]//img[1]") public WebElement clickImg;
    @FindBy(xpath = "(//button[@type='button'])[17]") public WebElement clickClose;
    @FindBy(xpath = "//div[@class='dropdown-input sprite-bf']") public WebElement clickDropdown;
    @FindBy(xpath = "//option[@value='15,3']") public WebElement clickOptionSize;

    public ProductDetail_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
