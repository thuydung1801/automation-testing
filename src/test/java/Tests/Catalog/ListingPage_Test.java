package Tests.Catalog;

import Common_Page.AbstractBase_Test;
import org.testng.annotations.Test;

public class ListingPage_Test extends AbstractBase_Test {
    @Test
    public void ClickAllView() throws InterruptedException {
        App().Flow().navigateToUrl("https://dev3.glamira.com/glgb/rings-home/");
        System.out.println("1.---> get URL Page Success");
        App().Pages().ListingPage().ClickOnView();
        System.out.println("2.---> Click Success Button OnView");
        Thread.sleep(2000);
        App().Pages().ListingPage().isDplCookiebook();
        Thread.sleep(2000);
        App().Pages().ListingPage().isDplSwitchTo();
        System.out.println("---> Click Success Button Close");
//        App().Pages().ListingPage().SelectStn();
//        App().Pages().ListingPage().SelectCR();
    }
}
