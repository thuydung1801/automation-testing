package Tests.CheckOut;

import Common_Page.AbstractBase_Test;
import org.testng.annotations.Test;

public class MiniCart_Test extends AbstractBase_Test {
    @Test
    public void addToCart() throws InterruptedException {
        App().Flow().navigateToUrl("https://dev3.glamira.com/glgb/diamond-rings/");
        System.out.println("============START============");
        App().Pages().miniCartPage().ClickProductSelected();
        Thread.sleep(1000);
        App().Flow().getCurrentPageUrl();
        System.out.println(  App().Flow().getCurrentPageUrl());
        App().Pages().miniCartPage().ClickAddToCart();
        App().Pages().miniCartPage().Clickkkkkk();
    }

}
