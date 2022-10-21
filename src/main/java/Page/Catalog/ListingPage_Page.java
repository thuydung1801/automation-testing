package Page.Catalog;

import Page_Element.catalog.ListingPage_Element;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ListingPage_Page {
    RemoteWebDriver driver;
    Actions actions;
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
        Thread.sleep(2000);
        boolean status1 = ListingPage.CheckBookSwitchTo.isDisplayed();
        if (!status1) {
            System.out.println("ĐANG CHẠY LÀM GÌ CĂNG :))");
        } else {
            System.out.println("CHECK: ~~~~~~~ Is Display Switch To Book:" + '\n');
            Thread.sleep(1000);
            ListingPage.CloseBook.click();
        }
    }
}
