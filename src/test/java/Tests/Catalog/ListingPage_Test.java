package Tests.Catalog;

import Common_Page.AbstractBase_Test;
import Page_Element.catalog.ListingPage_Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ListingPage_Test extends AbstractBase_Test {
//    RemoteWebDriver driver;
    ListingPage_Element scr;

    @Test
    public void ClickAllView() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        App().Flow().navigateToUrl("https://dev1.glamira.com/glgb/rings-home/");
        App().Pages().ListingPage().ClickOnView();
        App().Pages().ListingPage().SelectStn();
        App().Pages().ListingPage().SelectCR();
//        js.executeScript("arguments[0].scrollIntoView();", scr.SelectCarat);
    }
}
