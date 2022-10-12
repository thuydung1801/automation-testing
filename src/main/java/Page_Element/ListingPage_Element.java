package Page_Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListingPage_Element
{
    WebDriver driver;
    public ListingPage_Element(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
