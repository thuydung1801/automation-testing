package Page.Catalog;

import Page_Element.catalog.ProductDetail_Element;
import Page_Lib.Common;
import Page_Lib.ReadData;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ProductDetail_Page extends Common {
    RemoteWebDriver driver;
    ProductDetail_Element productDetailElement;
    ReadData data;



    public ProductDetail_Page(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        data = new ReadData();
        productDetailElement = new ProductDetail_Element(driver);

    }
    public void submitCookie(){
        click(productDetailElement.submitCookie , "accept cookie");
    }
    public void skipAllow(){
        click(productDetailElement.clickAllow , "skip");

    }
    public void scrollToBottom() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void clickProduct(){
        click(productDetailElement.clickProduct , "product 1");
    }
    public void clickShowImg() throws InterruptedException {
        submitCookie();
        Thread.sleep(1000);
        click(productDetailElement.clickImg , "show img");
        Thread.sleep(1000);
        click(productDetailElement.clickClose, "close img");

    }

    public void selectOption() throws InterruptedException {
        Thread.sleep(100);
        ArrayList<WebElement> arr = new ArrayList<>();
//        arr.add(productDetailElement.mainStone);
        arr.add(productDetailElement.stone2);
        arr.add(productDetailElement.metal_alloy);
        arr.add(productDetailElement.engraving);

        for (WebElement option : arr ){
            if(option != arr.get(arr.size()-1)){
                option.click();

            }
            else{
                option.click();
                click(productDetailElement.engravingText , "input engraving");
                sendKey(productDetailElement.engravingText , data.getKey("engravingTextKey"));
            }
        }

    }
    public void clickDropdown() throws InterruptedException {
        click(productDetailElement.clickDropdown , "dropdown");
        Thread.sleep(1000);
        click(productDetailElement.clickOptionSize , "select option");
    }
    public void clickAddCart() throws InterruptedException {
        Thread.sleep(500);
        click(productDetailElement.clickBtnAddCart , "btn add to cart");
        Thread.sleep(100);
        click(productDetailElement.clickCart , "btn cart");
        click(productDetailElement.viewCart, "show view cart");
        Thread.sleep(100);
        click(productDetailElement.viewDetail , "show detail product");

        System.out.printf("check engravingText : " );
        productDetailElement.getTextengr.getText().equalsIgnoreCase(data.getKey("engravingTextKey"));
        System.out.printf("True" + "\n");
    }

    public void optionEarringMen(){
        productDetailElement.submitCookie.click();
//        skipAllow();
        Actions actions = new Actions(driver);
        actions.moveToElement(productDetailElement.hoverMens);
        actions.moveToElement(productDetailElement.clickEaring);
        actions.click().build().perform();
    }
    public void optionFindSize() throws InterruptedException  {
//        productDetailElement.submitCookie.click();
//        boolean present;
//        try {
//            driver.findElement(By.cssSelector("button.amgdprcookie-button.-allow"));
//            present = true;
//        } catch (NoSuchElementException e) {
//            present =false ;
//        }
//        System.out.printf("present: " +present);
//        if(present){
//            Thread.sleep(500);
//        scrollToBottom();
//        skipAllow();
//        System.out.printf("click 1");
        Thread.sleep(600);
//        }
        submitCookie();
        scrollToBottom();

        skipAllow();
        click(productDetailElement.clickDropdown , "dropdown");
        click(productDetailElement.optionSize , "discover size options");
        click(productDetailElement.optionFindSize , "option find size");

//        productDetailElement.check1.click();
        sendKey(productDetailElement.prd_FirstName , data.getKey("prd_FirstName"));
        sendKey(productDetailElement.prd_LastName, data.getKey("prd_LastName"));
        sendKey(productDetailElement.prd_Email,data.getKey("prd_Email") );
        sendKey(productDetailElement.prd_Street, data.getKey("prd_Street"));
        sendKey(productDetailElement.prd_Code, data.getKey("prd_Code"));
        sendKey(productDetailElement.prd_City,data.getKey("prd_City") );
        Thread.sleep(200);
//            productDetailElement.check1.click();
        click(productDetailElement.check2 , "verify");
        click(productDetailElement.prd_submit , "btn from you");

    }

    public void optionDimensionGuide() throws InterruptedException {
        click(productDetailElement.clickDropdown , "dropdown");
        skipAllow();
        submitCookie();
        click(productDetailElement.clickDropdown , "dropdown");
        click(productDetailElement.optionSize , "discover size options");
        click(productDetailElement.optionFindSize, "option find size");
        click(productDetailElement.pageSizeGuide, "navigate to SizeGuide page");

    }
    public void optionFreeSize(){
        click(productDetailElement.clickDropdown , "dropdown");
        click(productDetailElement.optionSize , "discover size options");
        click(productDetailElement.optionFreeSize , "option free size");
    }


}
