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
        System.out.println(App().Flow().getCurrentPageUrl());
        App().Pages().miniCartPage().ClickElement();
        Thread.sleep(1000);
        App().Flow().navigateToUrl("https://dev3.glamira.com/glgb/diamond-rings/");
        App().Pages().miniCartPage().AddProDuctTwo();
        Thread.sleep(1000);
        System.out.println("~~~~~ CHECK VIEW DETAIL CART ~~~~~");
        Thread.sleep(1000);
        App().Pages().miniCartPage().CheckMiniCart();
        Thread.sleep(1000);
        System.out.println("~~~~~ CHECK VIEW CART~~~~~");
        Thread.sleep(1000);
        App().Pages().miniCartPage().CheckViewCart();
        Thread.sleep(1000);
    }


//

}
