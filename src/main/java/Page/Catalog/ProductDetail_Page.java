package Page.Catalog;

import Page_Element.catalog.ProductDetail_Element;
import Page_Lib.ReadData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void clickProduct(){
        productDetailElement.clickProduct.click();
    }
    public void clickShowImg(){
        productDetailElement.clickImg.click();
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

    public void closeDialog(){
        productDetailElement.clickClose.click();

    }
    public void clickDropdown() throws InterruptedException {
        productDetailElement.clickDropdown.click();
        Thread.sleep(1000);
        productDetailElement.clickOptionSize.click();

    }
}
