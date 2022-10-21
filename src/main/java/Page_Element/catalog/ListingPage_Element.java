package Page_Element.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListingPage_Element
{
    RemoteWebDriver driver;
    @FindBy(xpath = "//a[@title='VIEW ALL RINGS']") public WebElement BtnViewAll;
    @FindBy(xpath = "//ol[contains(@class,'stone-filter-desktop')]//img[contains(@alt,'Black Diamond')]") public WebElement SelectStones;
    @FindBy(xpath = "(//dt[contains(@role,'heading')])[2]") public  WebElement SelectCarat;
   @FindBy(css ="div.amgdprcookie-bar-container" ) public  WebElement checkCookies;
    @FindBy(css ="button.amgdprcookie-button.-allow" ) public  WebElement ClickBtnAccCookies;
    @FindBy(css = "div.tab-content.content-popup.geoip-popup-content") public WebElement CheckBookSwitchTo;
    @FindBy (css = "span.geoip-close") public WebElement CloseBook;
//Scrl
    @FindBy (xpath = "//div[@class='block-content snap-slider-container ']") public  WebElement ScrollElement;
    @FindBy (css = "div.snap-slider-nav") public WebElement CheckBookSlide;
    @FindBy (css = "button.nav__button-next") public WebElement NextSlide;
//   Filter
    @FindBy(css = "li.item.label.filter-diamonds") public WebElement CheckBookDiamonds;
    @FindBy(xpath = "(//label[contains(text(),'Blue Diamond')])[1]") public WebElement ClickElementDiamonds;

    public ListingPage_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
