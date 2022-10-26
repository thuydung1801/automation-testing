package Page.CheckOut;

import Page_Element.CheckOut.CheckOutFlow_Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOutFlow_Page {
    RemoteWebDriver driver;
    CheckOutFlow_Element CheckOutFl;


    public CheckOutFlow_Page(RemoteWebDriver driver) {
        this.driver = driver;
        CheckOutFl = new CheckOutFlow_Element(driver);
        driver.manage().window().maximize();
    }

    public void ClickProductSelected() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", CheckOutFl.SelectProductCheckOut);
        System.out.println(" ======== scroll the page till the element is found ========");
        Thread.sleep(1000);
        CheckOutFl.SelectProductCheckOut.click();

        //================================ ACCEPT COOLIES ================================

        Thread.sleep(1000);
        boolean status = CheckOutFl.checkCookies.isDisplayed();
        System.out.println("CHECK: ~~~~~~~ Is Display AccepCookies Book:" + '\n');
        if (status) {
            System.out.println("STATUS: ~~~~~~~ Is Display " + '\n');
            Thread.sleep(1000);
            CheckOutFl.ClickBtnAccCookies.click();
            System.out.println("MESSAGE: " + "=> Click the button to agree to ALL Cookie Policies Successfully");
        }
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        System.out.println("CHECK: ~~~~~~~ Is Display Switch To Book:" + '\n');
        boolean status1 = CheckOutFl.CheckBookSwitchTo.isDisplayed();
        if (!status1) {
            System.out.println("====FAILED==== :))");
        } else {
            System.out.println("STATUS: ~~~~~~~ Is Display " + '\n');
            Thread.sleep(1000);
            CheckOutFl.CloseBook.click();
            System.out.println("MESAGE:~~~~~~~ Close Success.~~~~~~~");
        }
        Thread.sleep(1000);
    }

    //================================ ADD PRODUCT TO CART ================================
    public void ClickElement() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(2000);
        CheckOutFl.selectRingSize.click();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.scrollToElement(CheckOutFl.SelectTypeRingSize).perform();
        Thread.sleep(1000);
        CheckOutFl.SelectTypeRingSize.click();
        Thread.sleep(1000);
        CheckOutFl.AddToCarts.click();
    }

    // ======================================CHECK DETAIL VIEW======================================
    public void CheckMiniCart() throws InterruptedException {
        System.out.println("~~~~~~~~~~~~~~~CheckMiniCart~~~~~~~~~~~~~~~");
        Thread.sleep(1000);
        boolean statusMessage = CheckOutFl.CloseMessage.isDisplayed();
        if (!statusMessage) {
            System.out.println(" NO MESSAGE ");
        } else if (statusMessage) {
            CheckOutFl.CloseIcon.click();
        } else {
            System.out.println(" NEXT STEEP ");
        }

    }

    // =========================================  CHECK VIEW CART BUTTON=================================
    public void CheckViewCart() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        CheckOutFl.CheckMiniCart.click();
        Thread.sleep(2000);
        CheckOutFl.CloseCheckMiniCart.click();
        Thread.sleep(2000);
        CheckOutFl.CheckMiniCart.click();
        Thread.sleep(2000);
        CheckOutFl.CheckViewCart.click();
        Thread.sleep(1000);
    }

    // ========================================= add two =================================
    public void AddProDuctTwo() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", CheckOutFl.SelectProductCheckOut);
        System.out.println(" ======== scroll the page till the element is found ========");
        Thread.sleep(1000);
        CheckOutFl.SelectProductCheckOut1.click();
        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(2000);
        CheckOutFl.selectRingSize.click();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.scrollToElement(CheckOutFl.SelectTypeRingSize).perform();
        Thread.sleep(1000);
        CheckOutFl.SelectTypeRingSize.click();
        Thread.sleep(1000);
        CheckOutFl.AddToCarts.click();
    }

    // =========================================DELETE PRODUCT =================================
    public void DeleteProductInCart() throws InterruptedException {
        CheckOutFl.DeleteProduct.click();
        Thread.sleep(1000);
        System.out.println("============== CHECK BOOK DELETE ==============");
        Boolean statusBookCart = CheckOutFl.isDisplayBookDelete.isDisplayed();
        if (!statusBookCart) {
            System.out.println("//////");
        } else {
            System.out.println("STATUS:~~~~~~  IS DISPLAY");
            CheckOutFl.Deletebtn.click();
        }
    }

    // ========================================= UPDATE QTY =================================
    public void UpdateQty() throws InterruptedException {
        Thread.sleep(1000);
        CheckOutFl.SelectDropdown.click();
        Thread.sleep(1000);
        Select select = new Select(CheckOutFl.SelectDropdown);
        select.selectByValue("3");
    }

    // ========================================= VIEW DETAIL =================================
    public void ViewDetailProduct() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("============== CHECK BOOK PRODUCT DETAIL ==============");
        CheckOutFl.ViewDetail.click();
        Thread.sleep(1000);
        boolean statusBook = CheckOutFl.isDisplayBook.isDisplayed();
        if (!statusBook) {
            System.out.println("/////");
        } else {
            System.out.println("STATUS:~~~~~~  IS DISPLAY");
            Thread.sleep(1000);
            CheckOutFl.ClickToAdd.click();
        }
    }

    // ========================================= SelectEngraving =================================
    public void SelectEngraving() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("============== CHECK BOOK SelectEngraving ==============");
        boolean statusBookEng = CheckOutFl.isDissPlayBookEng.isDisplayed();
        if (!statusBookEng) {
            System.out.println("////");
        } else {
            Thread.sleep(1000);
            System.out.println("STATUS:~~~~~~  IS DISPLAY");
            CheckOutFl.SelectFontText.click();
            Thread.sleep(1000);
            CheckOutFl.EnterText.sendKeys("Nguyen thi ngoc ");
            Thread.sleep(1000);
            CheckOutFl.SelectIcon.click();
        }
    }
    public void SaveBTN() throws InterruptedException{
        Thread.sleep(1000);
        CheckOutFl.SaveBtn.click();
    }
}



