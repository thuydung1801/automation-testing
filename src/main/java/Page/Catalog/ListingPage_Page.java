package Page.Catalog;

import Page_Element.catalog.ListingPage_Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.Select;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

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
            Thread.sleep(1000);
        }
    }

    //    Scr
    public void ScrollElement() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(" scroll the page till the element is found");
        js.executeScript("arguments[0].scrollIntoView();", ListingPage.ClickElementDiamonds);
        System.out.println("MESSAGE:~~~~~Scroll to Element Successfully");
        Thread.sleep(1000);
        ListingPage.ClickElementDiamonds.click();
    }

    public void ScrollElement2() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ListingPage.ClicElementGreenTourmaline);
        Thread.sleep(5000);
        ListingPage.ClicElementGreenTourmaline.click();
    }

    //    Sorting
    public void Sorting() throws Exception {
        System.out.println(" CHECK: ~~~~~~ IS DisPlay SortElement");
        boolean statusSort = ListingPage.SortingProduct.isDisplayed();
        if (statusSort) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", ListingPage.SortingProduct);
            Thread.sleep(2000);
            ListingPage.SortingProduct.click();
//
            Thread.sleep(3000);
            boolean statusBookSort = ListingPage.CheckBookTypeSort.isDisplayed();
            if (statusBookSort) {
                System.out.println(" CHECK: ~~~~~~ IS DisPlay BookSortElement");
                Thread.sleep(2000);
//                ListingPage.SelectElementSort1.click();

                List<WebElement> list = driver.findElements(By.xpath(".//ul/li"));
                for(WebElement option : list) {
                    String text = option.getText();
                    if (text.equals("Relevance")) {
                        option.click();
                        break;
                    }
                }

            }
        }

    }
}
