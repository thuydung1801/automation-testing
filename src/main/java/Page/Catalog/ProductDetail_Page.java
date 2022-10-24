package Page.Catalog;

import Page_Element.catalog.ProductDetail_Element;
import Page_Lib.ReadData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;

public class ProductDetail_Page {
    RemoteWebDriver driver;
    ProductDetail_Element productDetailElement;
    ReadData data;


    public ProductDetail_Page(RemoteWebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        data = new ReadData();
        productDetailElement = new ProductDetail_Element(driver);

    }
    public void skipAllow(){
        System.out.printf("skip" + "\n");
        productDetailElement.clickAllow.click();


    }
    public void clickProduct(){
        productDetailElement.clickProduct.click();
    }
    public void clickShowImg() throws InterruptedException {
        productDetailElement.submitCookie.click();
        Thread.sleep(1000);
        productDetailElement.clickImg.click();
        Thread.sleep(1000);
        productDetailElement.clickClose.click();
    }
//    public void click(){
//
//        List <WebElement> listImg = new ArrayList<WebElement>();
//
//        listImg.add(productDetailElement.clickShowImg1);
//        listImg.add(productDetailElement.clickShowImg2);
//        listImg.add(productDetailElement.clickShowVideo3);
//
//        System.out.printf("img1 : " + productDetailElement.clickShowImg1 + "\n");
//
//        System.out.printf("listImg: " +listImg + "\n");
//
//        Random r = new Random();
//        int randomValue = r.nextInt(listImg.size()); //Getting a random value that is between 0 and (list's size)-1
//        System.out.printf("vị trí : " + listImg.get(randomValue));
//        listImg.get(randomValue).click();
//    }

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
                productDetailElement.engravingText.click();
                productDetailElement.engravingText.sendKeys(data.getKey("engravingTextKey"));
            }
        }
//        productDetailElement.mainStone.click();
//        System.out.printf("option 1 done");
//        productDetailElement.stone2.click();
//        productDetailElement.metal_alloy.click();
//        productDetailElement.engraving.click();
//        productDetailElement.engravingText.sendKeys(data.getKey("engravingTextKey"));


    }
    public void clickDropdown() throws InterruptedException {
        productDetailElement.clickDropdown.click();
        Thread.sleep(1000);
        productDetailElement.clickOptionSize.click();

    }
    public void clickAddCart() throws InterruptedException {
        Thread.sleep(500);
        productDetailElement.clickBtnAddCart.click();
        Thread.sleep(100);
        productDetailElement.clickCart.click();
        productDetailElement.viewCart.click();
        Thread.sleep(100);
        productDetailElement.viewDetail.click();

        System.out.printf("check engravingText" + "\n");
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
    public void optionFreeSize(){
        productDetailElement.submitCookie.click();

        productDetailElement.clickDropdown.click();
        productDetailElement.optionSize.click();
        productDetailElement.optionFreeSize.click();
        productDetailElement.prd_FirstName.sendKeys(data.getKey("prd_FirstName"));
        productDetailElement.prd_LastName.sendKeys(data.getKey("prd_LastName"));
        productDetailElement.prd_Email.sendKeys(data.getKey("prd_Email"));
        productDetailElement.prd_Street.sendKeys(data.getKey("prd_Street"));
        productDetailElement.prd_Code.sendKeys(data.getKey("prd_Code"));
        productDetailElement.prd_City.sendKeys(data.getKey("prd_City"));

        productDetailElement.check1.click();
        productDetailElement.check2.click();
        productDetailElement.prd_submit.click();

    }

    public void optionFindSize(){

        productDetailElement.clickDropdown.click();
        productDetailElement.optionSize.click();
        productDetailElement.optionFindSize.click();
        productDetailElement.pageSizeGuide.click();


    }

}
