package Page.Catalog;

import Page_Element.catalog.ListingPage_Element;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;

public class ListingPage_Page {
    RemoteWebDriver driver;
    Actions actions;

    ListingPage_Element ListingPage;


    public ListingPage_Page(RemoteWebDriver driver) {
        this.driver = driver;
        ListingPage = new ListingPage_Element(driver);
        driver.manage().window().maximize();
    }

    public void ClickOnView() {
        ListingPage.BtnViewAll.click();
    }

    public void SelectStn() {
        ListingPage.SelectStones.click();
    }

    public void SelectCR() {
//        actions.moveToElement(ListingPage.SelectCarat).build().perform();
        ListingPage.SelectCarat.click();
    }
}
