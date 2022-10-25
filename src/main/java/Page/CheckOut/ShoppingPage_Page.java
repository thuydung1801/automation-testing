package Page.CheckOut;

import Page_Element.CheckOut.MiniCart_Element;
import Page_Element.CheckOut.ShoppingBag_Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ShoppingPage_Page {
    RemoteWebDriver driver;
    ShoppingBag_Element ShoppingPage;

    // CHECK DETAIL VIEW
    public void CheckMiniCart() throws InterruptedException {
        Thread.sleep(1000);
        boolean status = ShoppingPage.checkCookies.isDisplayed();
        System.out.println("CHECK: ~~~~~~~ Is Display AccepCookies Book:" + '\n');
        if (status) {
            System.out.println("STATUS: ~~~~~~~ Is Display " + '\n');
            Thread.sleep(1000);
            ShoppingPage.ClickBtnAccCookies.click();
            System.out.println("MESSAGE: " + "=> Click the button to agree to ALL Cookie Policies Successfully");
        }
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,500)");
//        boolean status1 = ShoppingPage.CheckBookSwitchTo.isDisplayed();
//        if (!status1) {
//            System.out.println("====FAILED==== :))");
//        } else {
//            System.out.println("STATUS: ~~~~~~~ Is Display " + '\n');
//            Thread.sleep(1000);
//            ShoppingPage.CloseBook.click();
//            System.out.println("MESAGE:~~~~~~~ Close Success.~~~~~~~");
//        }
//        Thread.sleep(1000);
//        boolean statusMessage = ShoppingPage.CloseMessage.isDisplayed();
//        if (!statusMessage) {
//            System.out.println(" NO MESSAGE ");
//        } else if (statusMessage) {
//            ShoppingPage.CloseIcon.click();
//        } else {
//            System.out.println(" NEXT STEEP ");
//        }
    }

    //  CHECK VIEW CART BUTTON
    public void CheckViewCart() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        ShoppingPage.CheckMiniCart.click();
        Thread.sleep(2000);
        ShoppingPage.CloseCheckMiniCart.click();
        Thread.sleep(2000);
        ShoppingPage.CheckMiniCart.click();
        Thread.sleep(2000);
        ShoppingPage.CheckViewCart.click();
        Thread.sleep(2000);
    }

    public ShoppingPage_Page(RemoteWebDriver driver) {
        this.driver = driver;
        ShoppingPage = new ShoppingBag_Element(driver);
        driver.manage().window().maximize();
    }
}
