package autoframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends CommonPage {


    By logInBtn = By.id("send2");
    By cartBtn = By.className("move-minicart");
    By checkOutBtn = By.className("checkout-methods-items");
    By countryList = By.cssSelector("[name^='country_id'");
    By tax = By.cssSelector(".totals-tax");
    By totalTax = By.cssSelector(".sub");
    public void logIn(){
        getDriver().findElement(logInBtn).click();
    }
    public void goToCart() {
        getDriver().findElement(cartBtn).click();
    }
    public void checkOut(){
        getDriver().findElement(checkOutBtn).click();
    }
    public void clickCountry(String name){
        Select select = new Select(getDriver().findElement(countryList));
        select.selectByVisibleText(name);
    }
    public void showTax() {
        getDriver().findElement(By.id("block-shipping")).click();
    }
     public void getTax() {
         System.out.println(getDriver().findElement(tax).getText());
     }
    public void getTotal() {
        System.out.println(getDriver().findElement(totalTax).getText());
    }


//    --Huong's code
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
        clickOn(ringsize);

    }

    public void AddToCart() {
        clickOn(addtocart);

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

//
//        By ShippingMethod = new By.ByXPath(shippingmethod);
//        scrollTo(ShippingMethod);
//        click(ShippingMethod);
//        waitAboutSecond(1);
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





//    ------Lan's code-------


    String firstnameLoacator = "div[name=\"shippingAddress.firstname\"] input";
    String lastnameLocator = "div[name=\"shippingAddress.lastname\"] input";
    String emailLoacator = "fieldset#customer-email-fieldset input#customer-email";
    String streetAddressLocator = "div[name=\"shippingAddress.street.0\"] input";
    String countryLocator = "div[name=\"shippingAddress.country_id\"] select";
    String cityLocator = "div[name=\"shippingAddress.city\"] input";
    String zipCodeLocator = "div[name=\"shippingAddress.postcode\"] input";
    String phoneNumLocator = "div[name=\"shippingAddress.telephone\"] input";
    String deliveryExpressLocator = "tbody>tr:nth-child(1) input.radio";
    String nextBtnLocator = "button.continue";
    String creditCardLocator = "div.payment-method:nth-child(4)>div>input";
    String cardNumberLocator = "#encryptedCardNumber";
    String expiryDateLocator = "input#encryptedExpiryDate";
    String cvcLocator = "input#encryptedSecurityCode";
    String holderNameLocator = "div.adyen-checkout__card__holderName input";
    String paymentAgreementLocator = "div.checkout-agreement input";
    String placeOrderBtnLocator = "button#place-order-trigger";
    String bankTransferMethodLocator = "#checkmo";
    String agreementLocator = "#agreement__6";
    String successPage = "https://test.glamira2.just4demo.biz/glgb/checkout/onepage/success/";


    public void inputInfo(String firstname, String lastname, String email, String streetAddress, String country, String city, String zipCode, String phoneNumber) {
        insertIntoField(firstname, firstnameLoacator);
        insertIntoField(lastname, lastnameLocator);
        insertIntoField(email, emailLoacator);
        insertIntoField(streetAddress, streetAddressLocator);
        insertIntoField(city, cityLocator);
        insertIntoField(zipCode, zipCodeLocator);
        insertIntoField(phoneNumber, phoneNumLocator);
        selectOption(countryLocator, country);
    }

    public void clickOnFreeStandardDeliveryThenClickNextBtn() {
        scrollToAndClick(deliveryExpressLocator);
        click(nextBtnLocator);
        waitAboutSecond(3);
    }

    public void chooseCreditCardAndInputThenClickOnPlaOrderButton(String creditNum, String expiryDate, String cvc, String holderName) {
        click(creditCardLocator);
        waitAboutSecond(5);
        insertIntoField(creditNum,cardNumberLocator);
        insertIntoField(expiryDate,expiryDateLocator);
        insertIntoField(cvc, cvcLocator);
        insertIntoField(holderName, holderNameLocator);
        click(paymentAgreementLocator);
        click(placeOrderBtnLocator);
    }

    public void chooseBankTransfer() {
        click(bankTransferMethodLocator);

    }

    public void agreeTemrsConditionsAndClickPlaceOrder() {
        click(agreementLocator);
        click(placeOrderBtnLocator);
    }

    public void theOrderPlaceSuccessfully() {
        waitAboutSecond(10);
        redirectToLink(successPage);
    }
}
