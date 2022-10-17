package Tests.Catalog;

import Common_Page.AbstractBase_Test;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

public class ListingPage_Test extends AbstractBase_Test {
    @Test
    public void ClickAllView() {
        App().Flow().navigateToUrl("https://dev1.glamira.com/glgb/rings-home/");
        App().Pages().ListingPage().ClickOnView();
        App().Pages().ListingPage().SelectStn();
        App().Pages().ListingPage().SelectCR();
    }

}
