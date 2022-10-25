package Page.CheckOut;

import Page_Element.CheckOut.MiniCart_Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class MiniCart_Page {
    RemoteWebDriver driver;
    MiniCart_Element MiniCart;


    public MiniCart_Page(RemoteWebDriver driver) {
        this.driver = driver;
        MiniCart = new MiniCart_Element(driver);
        driver.manage().window().maximize();
    }

    public void ClickProductSelected() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", MiniCart.SelectProductCheckOut);
        System.out.println(" ======== scroll the page till the element is found ========");
        Thread.sleep(1000);
        MiniCart.SelectProductCheckOut.click();

        //================================ ACCEPT COOLIES ================================

        Thread.sleep(1000);
        boolean status = MiniCart.checkCookies.isDisplayed();
        System.out.println("CHECK: ~~~~~~~ Is Display AccepCookies Book:" + '\n');
        if (status) {
            System.out.println("STATUS: ~~~~~~~ Is Display " + '\n');
            Thread.sleep(1000);
            MiniCart.ClickBtnAccCookies.click();
            System.out.println("MESSAGE: " + "=> Click the button to agree to ALL Cookie Policies Successfully");
        }
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        System.out.println("CHECK: ~~~~~~~ Is Display Switch To Book:" + '\n');
        boolean status1 = MiniCart.CheckBookSwitchTo.isDisplayed();
        if (!status1) {
            System.out.println("====FAILED==== :))");
        } else {
            System.out.println("STATUS: ~~~~~~~ Is Display " + '\n');
            Thread.sleep(1000);
            MiniCart.CloseBook.click();
            System.out.println("MESAGE:~~~~~~~ Close Success.~~~~~~~");
        }
        Thread.sleep(1000);
    }
    //================================ ADD PRODUCT TO CART ================================
    public void ClickElement() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(2000);
        MiniCart.selectRingSize.click();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.scrollToElement(MiniCart.SelectTypeRingSize).perform();
        Thread.sleep(1000);
        MiniCart.SelectTypeRingSize.click();
        Thread.sleep(1000);
        MiniCart.AddToCarts.click();
    }

    // ======================================CHECK DETAIL VIEW======================================
    public void CheckMiniCart() throws InterruptedException {
        System.out.println("~~~~~~~~~~~~~~~CheckMiniCart~~~~~~~~~~~~~~~");
        Thread.sleep(1000);
        boolean statusMessage = MiniCart.CloseMessage.isDisplayed();
        if (!statusMessage) {
            System.out.println(" NO MESSAGE ");
        } else if (statusMessage) {
            MiniCart.CloseIcon.click();
        } else {
            System.out.println(" NEXT STEEP ");
        }

    }

    // =========================================  CHECK VIEW CART BUTTON=================================
    public void CheckViewCart() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        MiniCart.CheckMiniCart.click();
        Thread.sleep(2000);
        MiniCart.CloseCheckMiniCart.click();
        Thread.sleep(2000);
        MiniCart.CheckMiniCart.click();
        Thread.sleep(2000);
        MiniCart.CheckViewCart.click();
        Thread.sleep(1000);
    }
    // ========================================= add two =================================
    public void AddProDuctTwo() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", MiniCart.SelectProductCheckOut);
        System.out.println(" ======== scroll the page till the element is found ========");
        Thread.sleep(1000);
        MiniCart.SelectProductCheckOut1.click();
        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(2000);
        MiniCart.selectRingSize.click();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.scrollToElement(MiniCart.SelectTypeRingSize).perform();
        Thread.sleep(1000);
        MiniCart.SelectTypeRingSize.click();
        Thread.sleep(1000);
        MiniCart.AddToCarts.click();
    }
}



