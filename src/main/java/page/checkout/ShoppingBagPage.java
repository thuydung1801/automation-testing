package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class ShoppingBagPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();

    public ShoppingBagPage(KeywordWeb key){
        super(key);
    }
    public ShoppingBagPage(){ super(); }

    public RegisterPage objRegist;

    public SignInPage objSignIn;

    //add any product with only a size field
    public void addProduct(String url) throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);

        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        keyword.scrollDownToElement("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_ADDPRODUCT_CHECKBOX_SIZE_H");
        Thread.sleep(2000);
        //keyword.click("CHECKOUT_ADDPRODUCT_BTN_CLOSE");
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);

    }

    //add product: bracelet
    public void addBraceletProduct(String url) throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);

        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        keyword.scrollDownToElement("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);

    }

    //add any product with an engraving
    public void addProductWithEngraving(String url) throws InterruptedException {
        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        Thread.sleep(2000);
        keyword.click("CHECKOUT_ADDPRODUCT_LBL_ENGRAVING");
        keyword.imWait(10);
        keyword.sendKeys("CHECKOUT_ADDPRODUCT_TXT_ENGRAVING",
                "CHECKOUT_DATA_ENGRAVING");
        Thread.sleep(2000);
        keyword.scrollDownToElement("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_ADDPRODUCT_CHECKBOX_SIZE_H");
        Thread.sleep(2000);
        //keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_CLOSE"));
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);
    }
    //add any product with double engraving
    public void addProductWithDoubleEngraving(String url) throws InterruptedException {
        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        Thread.sleep(2000);
        keyword.click("CHECKOUT_ADDPRODUCT_LBL_ENGRAVING");
        keyword.imWait(10);
        keyword.sendKeys("CHECKOUT_ADDPRODUCT_TXT_ENGRAVING_18_WOMEN",
                "CHECKOUT_DATA_ENGRAVING");
        keyword.imWait(3);
        keyword.sendKeys("CHECKOUT_ADDPRODUCT_TXT_ENGRAVING_18_MEN",
                "CHECKOUT_DATA_ENGRAVING");
        keyword.imWait(3);
        keyword.scrollDownToElement("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_ADDPRODUCT_CHECKBOX_SIZE_H");
        Thread.sleep(2000);
        //keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_CLOSE"));
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);
    }

    //add any product with attached gift
    public void addProductWithGift(String url) throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);

        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        keyword.scrollDownToElement("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(5000);
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_CHECKBOX_WOMENRING_GIFT");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_CHECKBOX_MENRING_GIFT");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_CLOSE");
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        Thread.sleep(2000);

    }
    //click to view all product in shopping bag
    public void clickShoppingBagPage() throws InterruptedException {
        Thread.sleep(10000);
        keyword.click("CHECKOUT_BTN_MINICART");
        Thread.sleep(10000);
        keyword.click("CHECKOUT_MINICART_VIEWALL");
        keyword.imWait(10);
    }
    //remove any product depends on the type of product
    public void removeProduct(String typeOfProduct) throws InterruptedException {
        keyword.click(typeOfProduct);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LBL_REMOVE",10);
        keyword.imWait(10);
        keyword.click("CHECKOUT_BTN_CONFIRM_REMOVE");
        if(!keyword.verifyElementPresent(typeOfProduct)){
            logger.info("Passed");
        }
    }
    // confirm message displayed or not
    public void confirmMessage(String messages){
        keyword.imWait(10);
        keyword.verifyElementVisible(messages);
    }
    //change quantity of product in cart
    public void changeQty(String qty){
        keyword.imWait(5);
        keyword.selectDropDownListByIndex("CHECKOUT_DDL_QTY",
                qty);
    }

    //click button view detail depends on the type of product
    public void viewDetail(String typeOfProduct) throws InterruptedException {
        keyword.click(typeOfProduct);

    }

    //click button Edit depends on the type of product
    public void clickEdit(String btnEdit) throws InterruptedException {
        keyword.webDriverWaitForElementPresent("CHECKOUT_LBL_HEADER",10);
        keyword.click(btnEdit);
        Thread.sleep(5000);
    }

    //edit option of ring to check update case
    public void editOptions() throws InterruptedException {
        keyword.click("CHECKOUT_CBX_BLACKDIAMOND");
        Thread.sleep(1000);
        keyword.click("CHECKOUT_LBL_METAL");
        keyword.webDriverWaitForElementPresent("CHECKOUT_CBX_METAL",10);
        keyword.scrollDownToElement("CHECKOUT_BTN_UPDATE");
        keyword.click("CHECKOUT_CBX_METAL");
        keyword.click("CHECKOUT_BTN_UPDATE");
        keyword.webDriverWaitForElementPresent("CHECKOUT_MESSAGES_UPDATE_21",10);
    }

    //edit earing is already in the cart
    public void editEaringOptions(){
        keyword.click("CHECKOUT_BTN_PAIR");
        keyword.click("CHECKOUT_BTN_PAIR");
        keyword.scrollDownToElement("CHECKOUT_BTN_UPDATE");
        keyword.click("CHECKOUT_BTN_UPDATE");
    }
    //edit couple ring is already in the cart
    public void editCoupleRings(){
        keyword.click("CHECKOUT_LBL_STONE");
        keyword.webDriverWaitForElementPresent("CHECKOUT_CBX_DIAMOND",10);
        keyword.click("CHECKOUT_CBX_DIAMOND");
        keyword.scrollDownToElement("CHECKOUT_LBL_PROFILE");
        keyword.click("CHECKOUT_LBL_PROFILE");
        keyword.webDriverWaitForElementPresent("CHECKOUT_CBX_PROFILE_B",10);
        keyword.click("CHECKOUT_CBX_PROFILE_B");
        keyword.webDriverWaitForElementPresent("CHECKOUT_DDL_SIZE",5);
        keyword.click("CHECKOUT_DDL_SIZE");
        keyword.click("CHECKOUT_CBX_SIZE_L");
        keyword.scrollDownToElement("CHECKOUT_BTN_UPDATE");
        keyword.click("CHECKOUT_BTN_UPDATE");
        keyword.webDriverWaitForElementPresent("CHECKOUT_MESSAGES_UPDATE_23",10);
    }
    //input engraving of single ring
    public void inputEngravingwithSingleRing(String data, String btnAdd, String engraving) throws InterruptedException {
        keyword.webDriverWaitForElementPresent("CHECKOUT_LBL_VIEWDETAIL",5);
        Thread.sleep(5000);
        keyword.verifyElementPresent(btnAdd);
        keyword.click(btnAdd);
        keyword.imWait(30);
        keyword.webDriverWaitForElementPresent("CHECKOUT_TITLE_ENGRAVING",5);
        keyword.imWait(30);
        keyword.clearText("CHECKOUT_TXT_ENGRAVING");
        Thread.sleep(5000);
        keyword.sendKeys("CHECKOUT_TXT_ENGRAVING", data);
        Thread.sleep(2000);
        keyword.click("CHECKOUT_VIEWDETAIL_BTN_SAVE");
        Thread.sleep(5000);
        keyword.assertEquals(data, engraving);
    }
    //input engraving of couple rings
    public void inputEngravingwithCoupleRing(String data, String btnAdd, String txtWomen,
                                             String txtMen ) throws InterruptedException {
        keyword.webDriverWaitForElementPresent("CHECKOUT_LBL_VIEWDETAIL",5);
        Thread.sleep(5000);
        keyword.click(btnAdd);
        keyword.imWait(10);
        keyword.webDriverWaitForElementPresent("CHECKOUT_TITLE_ENGRAVING",5);
        keyword.imWait(10);
        keyword.clearText(txtWomen);
        keyword.imWait(3);
        keyword.sendKeys(txtWomen, data);
        keyword.imWait(20);
        keyword.clearText(txtMen);
        keyword.sendKeys(txtMen, data);
        Thread.sleep(2000);

    }
    @Step("Input valid data")
    public void inputCorrectly(String data, String engraving) throws InterruptedException {
        keyword.click("CHECKOUT_VIEWDETAIL_BTN_SAVE");
        Thread.sleep(10000);
        keyword.assertEquals(data+ " - "+ data
                , PropertiesFile.getPropValue(engraving));
    }
    @Step("Input invalid data")
    public void inputError(String lblErrorMessage1, String lblErrorMessage2, String dataExpected, String engraving, boolean flag) throws InterruptedException {
        keyword.verifyElementPresent(lblErrorMessage1);
        keyword.verifyElementPresent(lblErrorMessage2);
        if(flag == true) {
            keyword.click("CHECKOUT_VIEWDETAIL_BTN_SAVE");
            Thread.sleep(10000);
            keyword.assertEquals(dataExpected + " - " + dataExpected, engraving);
        }
    }
    //compareData
    public void compareData(String expect, String actual){
        keyword.assertEquals(expect, actual);
    }
    @Step("missing fill product's size")
    public void missingFillSize(){
        keyword.click("CHECKOUT_DDL_SIZE");
        keyword.click("CHECKOUT_CBX_SIZE_CUSTOM");
        keyword.click("CHECKOUT_BTN_UPDATE");
    }
    @Step("click to choose free gift wrapping")
    public void clickGiftWrapping(){
        keyword.click("CHECKOUT_CBX_WRAP_UNIVERSE");
    }

    @Step("click to choose free gift wrapping")
    public void moveToPagecheckOut() throws InterruptedException {
        Thread.sleep(10000);
        keyword.click("CHECKOUT_BTN_CHECKOUT");
        keyword.webDriverWaitForElementPresent("CHECKOUT_LBL_CHECKOUT",10);
    }
    @Step("common checkout")
    public void checkOut() throws InterruptedException {
        Thread.sleep(3000);
        keyword.click("CHECKOUT_BTN_CHECKOUT_ADDRESS");
        keyword.webDriverWaitForElementPresent("CHECKOUT_BTN_CHECKOUT_SHIPMENT",5);
        Thread.sleep(10000);
        keyword.click("CHECKOUT_BTN_CHECKOUT_SHIPMENT");
        keyword.webDriverWaitForElementPresent("CHECKOUT_LBL_CHECKOUT_PAYMENT",10);
    }
    @Step("submit order")
    public void submit(){
        keyword.click("CHECKOUT_BTN_ORDER");
        String messages = keyword.getAlertText();
        keyword.acceptAlert();
        keyword.simpleAssertEquals(messages,"CHECKOUT_MESSAGES_PAYMENT");
    }
    @Step("check out with payment method: visa")
    public void checkOutWithVisa(String flag) throws InterruptedException {
        keyword.webDriverWaitForElementPresent("CHECKOUT_CBX_CHECKOUT_VISA",10);
        Thread.sleep(10000);
        keyword.click("CHECKOUT_CBX_CHECKOUT_VISA");
        Thread.sleep(3000);
        switch (flag) {
            //input valid information
            case "success":
                keyword.switchToIFrameByXpath("CHECKOUT_IFRAME_CHECKOUT_VISA");
                keyword.sendKeys("CHECKOUT_TBX_CHECKOUT_VISA", "CHECKOUT_DATA_CHECKOUT_VISA");
                keyword.switchToDefaultContent();
                keyword.switchToIFrameByXpath("CHECKOUT_IFRAME_CHECKOUT_EXPIRYDATE");
                keyword.sendKeys("CHECKOUT_TBX_CHECKOUT_EXPIRYDATE", "CHECKOUT_DATA_CHECKOUT_EXPIRYDATE");
                keyword.switchToDefaultContent();
                keyword.switchToIFrameByXpath("CHECKOUT_IFRAME_CHECKOUT_CVC");
                keyword.sendKeys("CHECKOUT_TBX_CHECKOUT_CVC", "CHECKOUT_DATA_CHECKOUT_CVC");
                keyword.switchToDefaultContent();
                keyword.sendKeys("CHECKOUT_TBX_CHECKOUT_NAME", "CHECKOUT_DATA_CHECKOUT_NAME");
                keyword.click("CHECKOUT_BTN_ORDER");
                keyword.webDriverWaitForElementPresent("CHECKOUT_SUCCESSPAGE", 10);
                keyword.verifyElementPresent("CHECKOUT_SUCCESSPAGE");
                break;
            //missing input all of fields
            case "failByMissing":
                keyword.click("CHECKOUT_BTN_ORDER");
                keyword.assertEquals("CHECKOUT_DATA_MESSAGES_VISA", "CHECKOUT_MESSAGES_VISA");
                keyword.assertEquals("CHECKOUT_DATA_MESSAGES_VISA", "CHECKOUT_MESSAGES_EXPIRYDATE");
                keyword.assertEquals("CHECKOUT_DATA_MESSAGES_VISA", "CHECKOUT_MESSAGES_CVC");
                break;
            //input defuse card
            case "failByCard":
                keyword.switchToIFrameByXpath("CHECKOUT_IFRAME_CHECKOUT_VISA");
                keyword.sendKeys("CHECKOUT_TBX_CHECKOUT_VISA", "CHECKOUT_DATA_CHECKOUT_VISA_2");
                keyword.switchToDefaultContent();
                keyword.switchToIFrameByXpath("CHECKOUT_IFRAME_CHECKOUT_EXPIRYDATE");
                keyword.sendKeys("CHECKOUT_TBX_CHECKOUT_EXPIRYDATE", "CHECKOUT_DATA_CHECKOUT_EXPIRYDATE_2");
                keyword.switchToDefaultContent();
                keyword.switchToIFrameByXpath("CHECKOUT_IFRAME_CHECKOUT_CVC");
                keyword.sendKeys("CHECKOUT_TBX_CHECKOUT_CVC", "CHECKOUT_DATA_CHECKOUT_CVC_2");
                keyword.switchToDefaultContent();
                keyword.sendKeys("CHECKOUT_TBX_CHECKOUT_NAME", "CHECKOUT_DATA_CHECKOUT_NAME");
                keyword.click("CHECKOUT_BTN_ORDER");
                Thread.sleep(5000);
                keyword.verifyElementVisible("CHECKOUT_MESSAGES_VISA_2");
                break;
        }
    }
    //check out with paypal payment method
    public void checkOutWithPayPal() throws InterruptedException {
        Thread.sleep(5000);
        keyword.click("CHECKOUT_CBX_CHECKOUT_PAYPAL");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_BTN_ORDER");
        keyword.clearText("PAYPAL_EMAIL");
        keyword.sendKeys("PAYPAL_EMAIL", "PAYPAL_DATA_EMAIL");
        keyword.sendKeys("PAYPAL_PASSWORD", "PAYPAL_DATA_PASSWORD");
        keyword.click("PAYPAL_BTN_LOGIN");
        keyword.webDriverWaitForElementPresent("PAYPAL_BTN_COMPLETE",10);
        keyword.click("PAYPAL_BTN_COMPLETE");
        keyword.webDriverWaitForElementPresent("CHECKOUT_SUCCESSPAGE", 20);
        keyword.verifyElementPresent("CHECKOUT_SUCCESSPAGE");
    }
    //check out with klarna payment method
    public void checkOutWithKlarnaLater() throws InterruptedException {
        Thread.sleep(10000);
        keyword.webDriverWaitForElementPresent("CHECKOUT_CBX_CHECKOUT_KLARNA_LATER",10);
        keyword.click("CHECKOUT_CBX_CHECKOUT_KLARNA_LATER");
        Thread.sleep(2000);
        keyword.click("CHECKOUT_BTN_ORDER");
        Thread.sleep(10000);
        keyword.switchToIFrameByXpath("KLARNA_IFRAME");
        Thread.sleep(10000);
        keyword.webDriverWaitForElementPresent("KLARNA_BTN_CONTINUE",30);
        keyword.click("KLARNA_BTN_CONTINUE");
        keyword.webDriverWaitForElementPresent("KLARNA_TBX_OTP",10);
        keyword.sendKeys("KLARNA_TBX_OTP", "KLARNA_DATA_OTP");
        Thread.sleep(10000);
        keyword.webDriverWaitForElementPresent("KLARNA_BTN_CONFIRM",10);
        keyword.click("KLARNA_BTN_CONFIRM");
        keyword.click("KLARNA_BTN_FAVOURITE");
        keyword.imWait(20);
        keyword.webDriverWaitForElementPresent("CHECKOUT_SUCCESSPAGE", 10);
        keyword.verifyElementPresent("CHECKOUT_SUCCESSPAGE");

    }
    //check out with bank transfer payment method
    public void checkOutWithBankTransfer() throws InterruptedException {
        keyword.webDriverWaitForElementPresent("CHECKOUT_CBX_CHECKOUT_BANK",10);
        keyword.click("CHECKOUT_CBX_CHECKOUT_BANK");
        Thread.sleep(6000);
        keyword.click("CHECKOUT_BTN_ORDER");
        keyword.webDriverWaitForElementPresent("CHECKOUT_SUCCESSPAGE", 20);
        keyword.verifyElementPresent("CHECKOUT_SUCCESSPAGE");
    }
    //click to print the receipt
    public void clickPrint() throws InterruptedException {
        keyword.click("SUCCESS_BTN_PRINT");
        Thread.sleep(3000);
        keyword.switchToTab(1);
        keyword.executeJavaScript("window.print=function(){window.close();};");
    }
    //input data of field: Use Store Credit
    public void clickUseCredit(String money){
        keyword.sendKeys("CHECKOUT_TXT_STORE_CREDIT",money);
        keyword.click("CHECKOUT_BTN_USE_CREDIT");
    }
    //cancel action use credit
    public void cancelUseCredit() throws InterruptedException {
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_STORE_CREDIT"));
        clickUseCredit("1");
        Thread.sleep(12000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_CANCEL_CREDIT"));
        keyword.assertEquals("CHECKOUT_MESSAGE_USE_CREDIT_ERROR","CHECKOUT_LBL_USE_CREDIT");
    }
    //calculate the discount
    public void discount(boolean flag) throws InterruptedException {
        if (flag){
            Float rawPrice = Float.valueOf(keyword.getTextWithOutCharacters("CHECKOUT_LBL_TOTAL_PRICE","£"));
            logger.info(String.valueOf(rawPrice));
            String totalPrice = String.valueOf(calculateMoney(rawPrice, 1));
            Thread.sleep(20000);
            String actualPrice = keyword.getTextWithOutCharacters("CHECKOUT_LBL_TOTAL_PRICE","£");
            logger.info(actualPrice);
            String lastPrice = keyword.removeLastChar(actualPrice);
            PropertiesFile.serPropValue("CHECKOUT_TOTAL_AMOUNT",actualPrice);
            keyword.simpleAssertEquals(totalPrice, lastPrice);
        }else {
            Thread.sleep(7000);
            String actualPrice = keyword.getTextWithOutCharacters("CHECKOUT_LBL_TOTAL_PRICE", "£");
            String lastPrice = keyword.removeLastChar(actualPrice);
            PropertiesFile.serPropValue("CHECKOUT_TOTAL_AMOUNT",actualPrice);
            Thread.sleep(10000);
            keyword.simpleAssertEquals("0.0", lastPrice);
        }
    }
    //use credit
    public void useCredit(boolean flag) throws InterruptedException {
        logger.info("useCredit");
        if(flag) {
            keyword.webDriverWaitForElementPresent("CHECKOUT_LBL_USE_CREDIT", 10);
            keyword.assertEquals("CHECKOUT_MESSAGE_USE_CREDIT", "CHECKOUT_LBL_USE_CREDIT");
            Thread.sleep(20000);
            String actualPrice = keyword.getTextWithOutCharacters("CHECKOUT_LBL_TOTAL_PRICE", "£");
            logger.info(actualPrice);
            String lastPrice = keyword.removeLastChar(actualPrice);
            keyword.simpleAssertEquals("0.0", lastPrice);
            keyword.click("CHECKOUT_BTN_ORDER");
            keyword.webDriverWaitForElementPresent("CHECKOUT_SUCCESSPAGE", 20);
            keyword.verifyElementPresent("CHECKOUT_SUCCESSPAGE");
        }else {
            keyword.webDriverWaitForElementPresent("CHECKOUT_LBL_CREDIT_ERROR",10);
            keyword.assertEquals("CHECKOUT_MESSAGES_CREDIT_ERROR","CHECKOUT_LBL_CREDIT_ERROR");
        }

    }
    //checkout with store credit in cases where the balance is greater than, equal to or less than the amount payable
    public void checkOutWithStoreCredit(String flag) throws InterruptedException {
        Thread.sleep(10000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_STORE_CREDIT"));
        //keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_TXT_STORE_CREDIT"),10);
        Float credit = Float.valueOf(1);
        switch (flag){
            //The balance is equal to the amount payable
            case "equals":
                String price = keyword.getTextWithOutCharacters("CHECKOUT_LBL_TOTAL_PRICE","£");
                clickUseCredit(price);
                useCredit(true);
                break;
            //The balance is less than the amount payable
            case "less":
                clickUseCredit(String.valueOf(credit));
                Float rawPrice = Float.valueOf(keyword.getTextWithOutCharacters("CHECKOUT_LBL_TOTAL_PRICE","£"));
                logger.info(String.valueOf(rawPrice));
                String totalPrice = String.valueOf(calculateMoney(rawPrice, credit));
                discount(true);
                checkOutWithBankTransfer();
                break;
            //The balance is more than the amount payable
            case "more":
                Float rawPrice1 = Float.valueOf(keyword.getTextWithOutCharacters("CHECKOUT_LBL_TOTAL_PRICE","£"));
                String totalPrice1 = String.valueOf(moreMoney(rawPrice1, credit));
                clickUseCredit(totalPrice1);
                useCredit(true);
                break;
            //Input invalid data on field Use Store Credit
            case "wrong":
               clickUseCredit("-100");
               useCredit(false);
                break;
            //Input data > the balance on field Use Store Credit
            case "max":
                clickUseCredit("10000000000000");
                keyword.verifyElementPresent("CHECKOUT_LBL_USE_CREDIT_ERROR");
        }
    }
    //apply active coupon with 2 situations: > total and < total money
    public void applyCoupon(String couponCode, boolean flag) throws InterruptedException {
        Thread.sleep(5000);
        keyword.click("CHECKOUT_LBL_COUPON");
        keyword.sendKeys("CHECKOUT_TBX_COUPON",couponCode);
        keyword.click("CHECKOUT_BTN_COUPON");
        discount(flag);
        if (flag){
            checkOutWithBankTransfer();
        }else {
            keyword.click("CHECKOUT_BTN_ORDER");
            keyword.webDriverWaitForElementPresent("CHECKOUT_SUCCESSPAGE", 20);
            keyword.verifyElementPresent("CHECKOUT_SUCCESSPAGE");
        }


    }
    @Step("apply the coupon is used")
    public void applyUsedCoupon(String couponCode) throws InterruptedException {
        Thread.sleep(5000);
        keyword.click("CHECKOUT_LBL_COUPON");
        keyword.sendKeys("CHECKOUT_TBX_COUPON",couponCode);
        keyword.click("CHECKOUT_BTN_COUPON");
        keyword.webDriverWaitForElementPresent("CHECKOUT_MESSAGES_COUPON_ERROR",10);
    }

    public void applyCouponAnUseStoreCredit(String couponCode) throws InterruptedException {
        Thread.sleep(5000);
        keyword.click("CHECKOUT_LBL_COUPON");
        keyword.sendKeys("CHECKOUT_TBX_COUPON",couponCode);
        keyword.click("CHECKOUT_BTN_COUPON");
        clickUseCredit("610");
        discount(false);

    }

    public void getOrderNumber(){
        String text = keyword.getTextWithOutCharacters("CHECKOUT_ORDER_NUMBER","Your Order Number Is ");
        PropertiesFile.serPropValue("CHECKOUT_DATA_ORDER_NUMBER",text);
    }

    public void openNewTab() throws InterruptedException {
        objSignIn = new SignInPage(this.keyword);
        keyword.openNewTabFromTabBase(1,"BE_URL");
        objSignIn.loginAdmin("BE_ADMIN_USERNAME","BE_ADMIN_PASSWORD");
    }

    public void verifyOrderStatus(String status) throws InterruptedException {
        keyword.navigateToUrl("https://dev3.glamira.com/secured2021/sales/order/");
        keyword.webDriverWaitForElementPresent("BE_ORDER_TBX_SEARCH",10);
        keyword.sendKeys("BE_ORDER_TBX_SEARCH","CHECKOUT_DATA_ORDER_NUMBER");
        Thread.sleep(10000);
        keyword.click("BE_ORDER_BTN_SEARCH");
        keyword.webDriverWaitForElementPresent("BE_ORDER_GRV",10);
        keyword.assertEquals(status,"BE_ORDER_GRV_STATUS");
    }

    public void checkInvoices() throws InterruptedException {
        Thread.sleep(5000);
        keyword.click("BE_ORDER_GRV_STATUS");
        Thread.sleep(5000);
        keyword.webDriverWaitForElementPresent("BE_ORDER_BTN_INVOICE",10);
        keyword.click("BE_ORDER_BTN_INVOICE");
        String amount = keyword.getTextWithOutCharacters("BE_ORDER_STATUS_AMOUNT","£");
        keyword.simpleAssertEquals("CHECKOUT_TOTAL_AMOUNT",amount);
    }

    @Step("calculate the actual money")
    public Float calculateMoney(float total, float storeCredit){
        return total - storeCredit;
    }
    @Step("calculate the actual money > total money")
    public Float moreMoney(float total, float storeCredit){
        return total + storeCredit;
    }

}
