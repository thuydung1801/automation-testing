package Tests.CheckOut;

import Common_Page.AbstractBase_Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckOut_Flow extends AbstractBase_Test {
    @Test(priority = 1)
    public void addToCart_2() throws InterruptedException {
        App().Flow().navigateToUrl("https://dev3.glamira.com/glgb/diamond-rings/");
        System.out.println("============START============");
        App().Pages().CheckOutFlowPage().ClickProductSelected();
        Thread.sleep(1000);
        App().Flow().getCurrentPageUrl();
        System.out.println(App().Flow().getCurrentPageUrl());
        App().Pages().CheckOutFlowPage().ClickElement();
        Thread.sleep(1000);
        App().Flow().navigateToUrl("https://dev3.glamira.com/glgb/diamond-rings/");
        App().Pages().CheckOutFlowPage().AddProDuctTwo();
    }

    @Test(priority = 2)
    public void CheckCartPage() throws InterruptedException {
        App().Flow().getCurrentPageUrl();
        Thread.sleep(1000);
        System.out.println("~~~~~ CHECK VIEW DETAIL CART ~~~~~");
        Thread.sleep(1000);
        App().Pages().CheckOutFlowPage().CheckMiniCart();
        Thread.sleep(1000);
        System.out.println("~~~~~ CHECK VIEW CART~~~~~");
        Thread.sleep(1000);
        App().Pages().CheckOutFlowPage().CheckViewCart();
        Thread.sleep(1000);
        App().Pages().CheckOutFlowPage().DeleteProductInCart();
    }

    @Test(priority = 3)
    public void UpdateQty() throws InterruptedException {
        App().Flow().getCurrentPageUrl();
        Thread.sleep(1000);
        App().Pages().CheckOutFlowPage().UpdateQty();
    }

    @Test(priority = 4)
    public void ViewDetail() throws InterruptedException {
        App().Flow().getCurrentPageUrl();
        Thread.sleep(1000);
        App().Pages().CheckOutFlowPage().ViewDetailProduct();
    }

    @Test(priority = 5)
    public void SelectEngraving() throws InterruptedException {
        App().Flow().getCurrentPageUrl();
        Thread.sleep(1000);
        App().Pages().CheckOutFlowPage().SelectEngraving();
    }

    @Test(priority = 6)
    public void SaveBTN() throws InterruptedException {
        App().Flow().getCurrentPageUrl();
        Thread.sleep(1000);
        App().Pages().CheckOutFlowPage().SaveBTN();
    }

}
