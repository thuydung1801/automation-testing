package Tests.CheckOut;

import Common_Page.AbstractBase_Test;
import org.testng.annotations.Test;

public class ShoppingBag_Test extends AbstractBase_Test {
    @Test
    public void ShoppingPage() throws InterruptedException {
        App().Flow().navigateToUrl("https://dev3.glamira.com/glgb/diamond-rings/");
        Thread.sleep(1000);
        App().Pages().shoppingPagePage().CheckMiniCart();
        System.out.println("~~~~~ CHECK VIEW DETAIL CART ~~~~~");
        Thread.sleep(1000);
        App().Pages().shoppingPagePage().CheckMiniCart();
        Thread.sleep(1000);
        System.out.println("~~~~~ CHECK VIEW CART~~~~~");
        Thread.sleep(1000);
        App().Pages().shoppingPagePage().CheckViewCart();
        Thread.sleep(1000);
    }
}
