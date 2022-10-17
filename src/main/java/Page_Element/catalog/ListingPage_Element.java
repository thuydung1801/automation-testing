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
    @FindBy(xpath = "(//a[@title='VIEW ALL RINGS'])[1]") public WebElement BtnViewAll;
    @FindBy(xpath = "//ol[contains(@class,'stone-filter-desktop')]//img[contains(@alt,'Black Diamond')]") public WebElement SelectStones;
   @FindBy(xpath = "(//dt[contains(@role,'heading')])[2]") public  WebElement SelectCarat;

    public ListingPage_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
