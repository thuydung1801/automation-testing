package Page.Catalog;

import Page_Element.catalog.ListingPage_Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

import java.sql.Driver;

public class ListingPage_Page {
    RemoteWebDriver driver;
    ListingPage_Element ListingPage;

    public ListingPage_Page(RemoteWebDriver driver) {
        this.driver = driver;
        ListingPage = new ListingPage_Element(driver);
        driver.manage().window().maximize();
    }

    public void ClickOnView() {
        ListingPage.BtnViewAll.click();
    }

    public void SelectStn() {
        ListingPage.SelectStones.click();
    }

    public void SelectCR() {
        ListingPage.SelectCarat.click();
    }

    //    steep 2:
    public void isDplCookiebook() throws InterruptedException {
        boolean status = ListingPage.checkCookies.isDisplayed();
        System.out.println("CHECK: ~~~~~~~ Is Display AccepCookies Book:" + '\n');
        if (status) {
            System.out.println("STATUS: ~~~~~~~ Is Display " + '\n');
            Thread.sleep(1000);
            ListingPage.ClickBtnAccCookies.click();
            System.out.println("MESSAGE: " + "=> Click the button to agree to ALL Cookie Policies Successfully");
        }
    }

    //    Steep 3:
    public void isDplSwitchTo() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("CHECK: ~~~~~~~ Is Display Switch To Book:" + '\n');
        boolean status1 = ListingPage.CheckBookSwitchTo.isDisplayed();
        if (!status1) {
            System.out.println("ĐANG CHẠY LÀM GÌ CĂNG :))");
        } else {

            System.out.println("STATUS: ~~~~~~~ Is Display " + '\n');
            Thread.sleep(1000);
            ListingPage.CloseBook.click();
        }
    }

    public void scrollToElement() throws Exception {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", ListingPage.ScrollElement);
        Thread.sleep(500);
    }

    public void CheckDplBookSlide() throws Exception {
        Thread.sleep(10000);
        System.out.println("CHECK: ~~~~~~~ Is Display Book Slide:" + '\n');
        boolean status2 = ListingPage.CheckBookSlide.isDisplayed();
        if (status2) {
            System.out.println("STATUS: ~~~~~~~ Is Display " + '\n');
            Thread.sleep(2000);
            ListingPage.NextSlide.click();
            System.out.println("Action: ~~~~~~~ Click Next " + '\n');
        }
    }

    //    Finter
    public void CheckDplBookDiamonds() throws Exception {
        Thread.sleep(10000);
        System.out.println("CHECK: ~~~~~~~ Is Display Book Diamonds:" + '\n');
        boolean statusDiamond = ListingPage.CheckBookDiamonds.isDisplayed();
        if (statusDiamond) {
            System.out.println("STATUS: ~~~~~~~ Is Display " + '\n');
            Thread.sleep(2000);
        }
    }

    //    Scr
    public void ScrollElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(" scroll the page till the element is found");
        js.executeScript("arguments[0].scrollIntoView();", ListingPage.ClickElementDiamonds);
        ListingPage.ClickElementDiamonds.click();
    }


}
