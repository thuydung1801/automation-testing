package autoframework.pages.frontEnd;

import autoframework.pages.H_CommonPages;
import org.openqa.selenium.By;

public class HUONGCheckoutPages extends H_CommonPages{
    // private final String jewery = "#store\\.menu > div > div > nav > button:nth-child(1)";
    private final String jewelryLocator = "//*[@id=\"menu_mega\"]/ul[4]/li[1]/a";
    private final String diamondringLocator = "//*[@id=\"menu_mega\"]/ul[4]/li[1]/ul/li[1]/ul/li[1]/ul/li[1]/a";
    private final String ringitem = "//*[@id=\"maincontent\"]/div[1]/div[1]/div[6]/ol/li[1]";
    private final String ringsize ="//*[@class=\"ringsize-selecter has-ringsizer-link\"]/select/option[2]";
    private final String addtocart ="//*[@id=\"product-addtocart-button\"]";
    private final String shoppingbag ="//*[@class=\"minicart-wrapper\"]";
    private final String checkoutbutton ="//*[@id=\"maincontent\"]/div[2]/div/div[3]/div[1]/ul/li/button/span";
    private final String shippingmethod ="//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input";
    private final String nextbutton ="//*[@id=\"checkout-step-shipping_method\"]//form//div[@id=\"shipping-method-buttons-container\"]//button";
    private final String PaymentMethod ="//*[@id=\"banktransfer\"]";
    private final String termslocator ="//*[@name=\"agreement[6]\"]";
    private final String placeorder ="//*[@id=\"place-order-trigger\"]";
    private final String notification ="//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[1]/div[1]";
    private final String paymentmethodPaypal ="//*[@id=\"iyzipay\"]";
    By accept = By.className(".required-entry");




//    ublic void iClickToJewery()  {
//        getDriver().findElement(By.cssSelector(jewery)).click();
//    }

    public void mouseHoverAndClick() {
        hoverThenClickOn(jewelryLocator,diamondringLocator);
    }


    public void iClickInDetailItem() {
        getDriver().findElement(By.xpath(ringitem)).click();
    }

    public void chooseRingSize() {
        Clickon(ringsize);

    }

    public void AddToCart() {
        Clickon(addtocart);

    }

    public void ClickShoppingBag() {
        getDriver().findElement(By.xpath(shoppingbag)).click();
        waitAboutSecond(5);
    }

    public void CheckoutButton() {
        getDriver().findElement(By.xpath(checkoutbutton)).click();
        waitAboutSecond(5);
    }

    public void ShippingMethod() {
        // getDriver().findElement(By.xpath(shippingmethod)).click();


        By by = new By.ByXPath(shippingmethod);
        scrollTo(by);
        click(by);
        waitAboutSecond(1);
    }

    public void NextButton() {
        getDriver().findElement(By.xpath(nextbutton)).click();
        waitAboutSecond(10);
    }

    public void paymentmethod() {
        getDriver().findElement(By.xpath(PaymentMethod)).click();
//        getDriver().findElement(accept).click();
        waitAboutSecond(5);
    }

    public void acceptterms() {

        getDriver().findElement(By.xpath(termslocator)).click();



    }

    public void clickInPlaceOrder() {
        getDriver().findElement(By.xpath("//*[@id=\"place-order-trigger\"]")).click();
        waitAboutSecond(60);
        //System.out.println("click Place Order");


    }


    public boolean viewssucess(String myorder) {
        try{
            return redirectToLink(myorder);
        }catch(Exception e){
            return false;
        }
    }
    public void paymentmethodPaypal() {
        getDriver().findElement(By.xpath(paymentmethodPaypal)).click();
        waitAboutSecond(5);
    }

}
