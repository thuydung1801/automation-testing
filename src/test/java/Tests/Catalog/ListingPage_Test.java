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
//Scroll
//        App().Pages().ListingPage().scrollToElement();
//        System.out.println("---> Scrolled to Element");
    }

    @Test
    public void MainLissting() throws Exception {
        App().Flow().getCurrentPageUrl();
        System.out.println(App().Flow().getCurrentPageUrl());
        Thread.sleep(2000);
        App().Pages().ListingPage().CheckDplBookSlide();
        System.out.println("MESSAGE:~~~~~ Click Next Btn Successfully");
    }

    @Test
    public void FiltersStones() throws Exception {
        App().Flow().getCurrentPageUrl();
        Thread.sleep(1000);
        App().Pages().ListingPage().CheckDplBookDiamonds();
        System.out.println("MESSAGE:~~~~~ Click Item Diamonds Successfully");
        Thread.sleep(2000);
    }

    @Test
    public void ScrollToElement() throws Exception {
        App().Flow().getCurrentPageUrl();
        Thread.sleep(1000);
        App().Pages().ListingPage().ScrollElement();
        System.out.println("MESSAGE:~~~~~Scroll to Element Successfully");
        Thread.sleep(2000);
    }

}
