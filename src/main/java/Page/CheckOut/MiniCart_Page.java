package Page.CheckOut;

import Page_Element.CheckOut.MiniCart_Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        //côkies

        Thread.sleep(7000);
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
        Thread.sleep(10000);
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

    public void ClickAddToCart() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", MiniCart.isDisplayBookRingSize);
        System.out.println("CHECK:==isDisplayBookRingSize==");
        boolean stt = MiniCart.isDisplayBookRingSize.isDisplayed();
        if (!stt) {
            System.out.println("==========");
        } else {
            Thread.sleep(5000);
            System.out.println("STATUS:~~~~~~~~isDisplayBookRingSize==");
            Thread.sleep(5000);
            MiniCart.isDisplayBookRingSize.click();
            System.out.println("MESSAGE:~~~~~~~~ Click Success ==");
            Thread.sleep(10000);

        }

    }
    public void Clickkkkkk () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean stt2 = MiniCart.isDisplayContentRingSize.isDisplayed();
        if (stt2) {
            System.out.println("==========");
        } else {
            Thread.sleep(5000);
            js.executeScript("arguments[0].scrollIntoView();", MiniCart.selectRingSize);
            Thread.sleep(5000);
            Select selects = new Select(driver.findElement(By.xpath("//div[@class='dropdown-container']")));
            Thread.sleep(5000);
            js.executeScript("arguments[0].scrollIntoView();", MiniCart.selectRingSize);
            selects.selectByIndex(21);
            System.out.println("AAAAAAAAAAAA");
        }
        js.executeScript("arguments[0].scrollIntoView();", MiniCart.AddToCarts);
        Thread.sleep(20000);
        MiniCart.AddToCarts.click();
    }
}



