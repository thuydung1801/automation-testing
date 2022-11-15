package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import page.home.RegisterPage;

public class ShoppingBagPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();

    public ShoppingBagPage(KeywordWeb key){
        super(key);
    }
    public ShoppingBagPage(){ super(); }

    public RegisterPage objRegist;

    public void addProduct(String url) throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);

        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_CHECKBOX_SIZE_H"));
        Thread.sleep(2000);
        //keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_CLOSE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);

    }
    public void addBraceletProduct(String url) throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);

        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);

    }

    public void addProductWithEngraving(String url) throws InterruptedException {
        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_LBL_ENGRAVING"));
        keyword.imWait(10);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_TXT_ENGRAVING"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_ENGRAVING"));
        Thread.sleep(2000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_CHECKBOX_SIZE_H"));
        Thread.sleep(2000);
        //keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_CLOSE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
    }
    public void addProductWithDoubleEngraving(String url) throws InterruptedException {
        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_LBL_ENGRAVING"));
        keyword.imWait(10);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_TXT_ENGRAVING_18_WOMEN"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_ENGRAVING"));
        keyword.imWait(3);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_TXT_ENGRAVING_18_MEN"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_ENGRAVING"));
        keyword.imWait(3);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_CHECKBOX_SIZE_H"));
        Thread.sleep(2000);
        //keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_CLOSE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
    }

    public void addProductWithGift(String url) throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);

        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CHECKBOX_WOMENRING_GIFT"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CHECKBOX_MENRING_GIFT"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_CLOSE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);

    }

    public void clickShoppingBagPage() throws InterruptedException {
        Thread.sleep(10000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_MINICART"));
        Thread.sleep(10000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_MINICART_VIEWALL"));
        keyword.imWait(10);

    }

    public void removeProduct(String typeOfProduct) throws InterruptedException {
        keyword.click(PropertiesFile.getPropValue(typeOfProduct));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_LBL_REMOVE"),10);
        keyword.imWait(10);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_CONFIRM_REMOVE"));
        if(!keyword.verifyElementPresent(PropertiesFile.getPropValue(typeOfProduct))){
            logger.info("Passed");
        }
    }
    public void confirmMessage(String messages){
        keyword.imWait(10);
        keyword.verifyElementVisible(PropertiesFile.getPropValue(messages));
    }
    public void changeQty(String qty){
        keyword.imWait(5);
        keyword.selectDropDownListByIndex(PropertiesFile.getPropValue("CHECKOUT_DDL_QTY"),
                PropertiesFile.getPropValue(qty));
    }

    public void viewDetail(String typeOfProduct) throws InterruptedException {
        keyword.click(PropertiesFile.getPropValue(typeOfProduct));

    }
    public void clickEdit(String btnEdit) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_LBL_HEADER"),10);
        keyword.click(PropertiesFile.getPropValue(btnEdit));
        Thread.sleep(5000);
    }
    public void editOptions() throws InterruptedException {
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_BLACKDIAMOND"));
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_LBL_METAL"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_CBX_METAL"),10);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_BTN_UPDATE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_METAL"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_UPDATE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_MESSAGES_UPDATE_21"),10);
    }
    public void editEaringOptions(){
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_PAIR"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_PAIR"));
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_BTN_UPDATE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_UPDATE"));
    }
    public void editCoupleRings(){
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_LBL_STONE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_CBX_DIAMOND"),10);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_DIAMOND"));
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_LBL_PROFILE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_LBL_PROFILE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_CBX_PROFILE_B"),10);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_PROFILE_B"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_DDL_SIZE"),5);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_DDL_SIZE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_SIZE_L"));
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_BTN_UPDATE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_UPDATE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_MESSAGES_UPDATE_23"),10);
    }
    public void inputEngravingwithSingleRing(String data, String btnAdd, String engraving) throws InterruptedException {
//        keyword.imWait(30);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_LBL_VIEWDETAIL"),5);
        Thread.sleep(5000);
        keyword.verifyElementPresent(PropertiesFile.getPropValue(btnAdd));
        keyword.click(PropertiesFile.getPropValue(btnAdd));
        keyword.imWait(30);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_TITLE_ENGRAVING"),5);
        keyword.imWait(30);
        keyword.clearText(PropertiesFile.getPropValue("CHECKOUT_TXT_ENGRAVING"));
        Thread.sleep(5000);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TXT_ENGRAVING"),
                PropertiesFile.getPropValue(data));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_VIEWDETAIL_BTN_SAVE"));
        Thread.sleep(5000);
        keyword.assertEquals(PropertiesFile.getPropValue(data),
                PropertiesFile.getPropValue(engraving));
    }
    public void inputEngravingwithCoupleRing(String data, String btnAdd, String txtWomen,
                                             String txtMen ) throws InterruptedException {
//        keyword.imWait(15);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_LBL_VIEWDETAIL"),5);
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue(btnAdd));
        keyword.imWait(10);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_TITLE_ENGRAVING"),5);
        keyword.imWait(10);
        keyword.clearText(PropertiesFile.getPropValue(txtWomen));
        keyword.imWait(3);
        keyword.sendKeys(PropertiesFile.getPropValue(txtWomen),
                PropertiesFile.getPropValue(data));
        keyword.imWait(20);
        keyword.clearText(PropertiesFile.getPropValue(txtMen));
        keyword.sendKeys(PropertiesFile.getPropValue(txtMen),
                PropertiesFile.getPropValue(data));
        Thread.sleep(2000);

    }
    public void inputCorrectly(String data, String engraving) throws InterruptedException {
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_VIEWDETAIL_BTN_SAVE"));
        Thread.sleep(10000);
        keyword.assertEquals(PropertiesFile.getPropValue(data)+ " - "+ PropertiesFile.getPropValue(data)
                , PropertiesFile.getPropValue(engraving));
    }
    public void inputError(String lblErrorMessage1, String lblErrorMessage2, String dataExpected, String engraving, boolean flag) throws InterruptedException {
        keyword.verifyElementPresent(PropertiesFile.getPropValue(lblErrorMessage1));
        keyword.verifyElementPresent(PropertiesFile.getPropValue(lblErrorMessage2));
        if(flag == true) {
            keyword.click(PropertiesFile.getPropValue("CHECKOUT_VIEWDETAIL_BTN_SAVE"));
            Thread.sleep(10000);
            keyword.assertEquals(PropertiesFile.getPropValue(dataExpected) + " - "
                            + PropertiesFile.getPropValue(dataExpected)
                    , PropertiesFile.getPropValue(engraving));
        }
    }
    public void compareData(String expect, String actual){
        keyword.assertEquals(PropertiesFile.getPropValue(expect),
                PropertiesFile.getPropValue(actual));
    }
    @Step("missing fill product's size")
    public void missingFillSize(){
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_DDL_SIZE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_SIZE_CUSTOM"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_UPDATE"));
    }
    @Step("click to choose free gift wrapping")
    public void clickGiftWrapping(){
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_WRAP_UNIVERSE"));
    }

    @Step("click to choose free gift wrapping")
    public void moveToPagecheckOut() throws InterruptedException {
        Thread.sleep(10000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_CHECKOUT"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_LBL_CHECKOUT"),10);
    }
    public void checkOut() throws InterruptedException {
        Thread.sleep(3000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_CHECKOUT_ADDRESS"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_BTN_CHECKOUT_SHIPMENT"),5);
        Thread.sleep(10000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_CHECKOUT_SHIPMENT"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_LBL_CHECKOUT_PAYMENT"),10);
    }

    public void submit(){
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_ORDER"));
        String messages = keyword.getAlertText();
        keyword.acceptAlert();
        keyword.simpleAssertEquals(messages,PropertiesFile.getPropValue("CHECKOUT_MESSAGES_PAYMENT"));
    }
    public void checkOutWithVisa(String flag) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_CBX_CHECKOUT_VISA"),10);
        Thread.sleep(10000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_CHECKOUT_VISA"));
        Thread.sleep(3000);
        switch (flag) {
            case "success":
                keyword.switchToIFrameByXpath(PropertiesFile.getPropValue("CHECKOUT_IFRAME_CHECKOUT_VISA"));
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TBX_CHECKOUT_VISA"),
                        PropertiesFile.getPropValue("CHECKOUT_DATA_CHECKOUT_VISA"));
                keyword.switchToDefaultContent();
                keyword.switchToIFrameByXpath(PropertiesFile.getPropValue("CHECKOUT_IFRAME_CHECKOUT_EXPIRYDATE"));
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TBX_CHECKOUT_EXPIRYDATE"),
                        PropertiesFile.getPropValue("CHECKOUT_DATA_CHECKOUT_EXPIRYDATE"));
                keyword.switchToDefaultContent();
                keyword.switchToIFrameByXpath(PropertiesFile.getPropValue("CHECKOUT_IFRAME_CHECKOUT_CVC"));
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TBX_CHECKOUT_CVC"),
                        PropertiesFile.getPropValue("CHECKOUT_DATA_CHECKOUT_CVC"));
                keyword.switchToDefaultContent();
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TBX_CHECKOUT_NAME"),
                        PropertiesFile.getPropValue("CHECKOUT_DATA_CHECKOUT_NAME"));
                keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_ORDER"));
                keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_SUCCESSPAGE"), 10);
                keyword.verifyElementPresent(PropertiesFile.getPropValue("CHECKOUT_SUCCESSPAGE"));
                break;
            case "failByMissing":
                keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_ORDER"));
                keyword.assertEquals(PropertiesFile.getPropValue("CHECKOUT_DATA_MESSAGES_VISA"),
                        PropertiesFile.getPropValue("CHECKOUT_MESSAGES_VISA"));
                keyword.assertEquals(PropertiesFile.getPropValue("CHECKOUT_DATA_MESSAGES_VISA"),
                        PropertiesFile.getPropValue("CHECKOUT_MESSAGES_EXPIRYDATE"));
                keyword.assertEquals(PropertiesFile.getPropValue("CHECKOUT_DATA_MESSAGES_VISA"),
                        PropertiesFile.getPropValue("CHECKOUT_MESSAGES_CVC"));
                break;
            case "failByCard":
                keyword.switchToIFrameByXpath(PropertiesFile.getPropValue("CHECKOUT_IFRAME_CHECKOUT_VISA"));
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TBX_CHECKOUT_VISA"),
                        PropertiesFile.getPropValue("CHECKOUT_DATA_CHECKOUT_VISA_2"));
                keyword.switchToDefaultContent();
                keyword.switchToIFrameByXpath(PropertiesFile.getPropValue("CHECKOUT_IFRAME_CHECKOUT_EXPIRYDATE"));
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TBX_CHECKOUT_EXPIRYDATE"),
                        PropertiesFile.getPropValue("CHECKOUT_DATA_CHECKOUT_EXPIRYDATE_2"));
                keyword.switchToDefaultContent();
                keyword.switchToIFrameByXpath(PropertiesFile.getPropValue("CHECKOUT_IFRAME_CHECKOUT_CVC"));
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TBX_CHECKOUT_CVC"),
                        PropertiesFile.getPropValue("CHECKOUT_DATA_CHECKOUT_CVC_2"));
                keyword.switchToDefaultContent();
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TBX_CHECKOUT_NAME"),
                        PropertiesFile.getPropValue("CHECKOUT_DATA_CHECKOUT_NAME"));
                keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_ORDER"));
                Thread.sleep(5000);
                keyword.verifyElementVisible(PropertiesFile.getPropValue("CHECKOUT_MESSAGES_VISA_2"));
                break;
        }
    }
    public void checkOutWithPayPal() throws InterruptedException {
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_CHECKOUT_PAYPAL"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_ORDER"));
        keyword.clearText(PropertiesFile.getPropValue("PAYPAL_EMAIL"));
        keyword.sendKeys(PropertiesFile.getPropValue("PAYPAL_EMAIL"),
                PropertiesFile.getPropValue("PAYPAL_DATA_EMAIL"));
        keyword.sendKeys(PropertiesFile.getPropValue("PAYPAL_PASSWORD"),
                PropertiesFile.getPropValue("PAYPAL_DATA_PASSWORD"));
        keyword.click(PropertiesFile.getPropValue("PAYPAL_BTN_LOGIN"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("PAYPAL_BTN_COMPLETE"),10);
        keyword.click(PropertiesFile.getPropValue("PAYPAL_BTN_COMPLETE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_SUCCESSPAGE"), 20);
        keyword.verifyElementPresent(PropertiesFile.getPropValue("CHECKOUT_SUCCESSPAGE"));
    }

    public void checkOutWithKlarnaLater() throws InterruptedException {
        Thread.sleep(10000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_CBX_CHECKOUT_KLARNA_LATER"),10);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_CHECKOUT_KLARNA_LATER"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_ORDER"));
        Thread.sleep(10000);
        keyword.switchToIFrameByXpath(PropertiesFile.getPropValue("KLARNA_IFRAME"));
        Thread.sleep(10000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("KLARNA_BTN_CONTINUE"),30);
        keyword.click(PropertiesFile.getPropValue("KLARNA_BTN_CONTINUE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("KLARNA_TBX_OTP"),10);
        keyword.sendKeys(PropertiesFile.getPropValue("KLARNA_TBX_OTP"),
                PropertiesFile.getPropValue("KLARNA_DATA_OTP"));
        Thread.sleep(10000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("KLARNA_BTN_CONFIRM"),10);
        keyword.click(PropertiesFile.getPropValue("KLARNA_BTN_CONFIRM"));
        keyword.click(PropertiesFile.getPropValue("KLARNA_BTN_FAVOURITE"));
        keyword.imWait(20);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_SUCCESSPAGE"), 10);
        keyword.verifyElementPresent(PropertiesFile.getPropValue("CHECKOUT_SUCCESSPAGE"));

    }
    public void checkOutWithBankTransfer() throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_CBX_CHECKOUT_BANK"),10);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_CBX_CHECKOUT_BANK"));
        Thread.sleep(6000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_ORDER"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_SUCCESSPAGE"), 20);
        keyword.verifyElementPresent(PropertiesFile.getPropValue("CHECKOUT_SUCCESSPAGE"));
    }

    public void clickPrint(){
        keyword.click(PropertiesFile.getPropValue("SUCCESS_BTN_PRINT"));
    }
    public String removeLastChar(String str) {
        return str.isEmpty()? "": str.substring(0, str.length() - Character.charCount(str.codePointBefore(str.length())));
    }
    public void checkOutWithStoreCredit(String flag) throws InterruptedException {
        Thread.sleep(10000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_STORE_CREDIT"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_TXT_STORE_CREDIT"),10);

        switch (flag){
            case "equals":
                String price = keyword.getTextWithOutCharacters(PropertiesFile.getPropValue("CHECKOUT_LBL_TOTAL_PRICE"),"£");
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TXT_STORE_CREDIT"),price);
                keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_USE_CREDIT"));
                keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_LBL_USE_CREDIT"),10);
                keyword.assertEquals(PropertiesFile.getPropValue("CHECKOUT_MESSAGE_USE_CREDIT"),
                        PropertiesFile.getPropValue("CHECKOUT_LBL_USE_CREDIT"));
                break;
            case "less":
                Float credit = Float.valueOf(1);
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TXT_STORE_CREDIT"),String.valueOf(credit));
                keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_USE_CREDIT"));
                Float rawPrice = Float.valueOf(keyword.getTextWithOutCharacters(PropertiesFile.getPropValue("CHECKOUT_LBL_TOTAL_PRICE"),"£"));
                logger.info(String.valueOf(rawPrice));
                String totalPrice = String.valueOf(calculateMoney(rawPrice, credit));
                Thread.sleep(20000);
                String actualPrice = keyword.getTextWithOutCharacters(PropertiesFile.getPropValue("CHECKOUT_LBL_TOTAL_PRICE"),"£");
                logger.info(actualPrice);
                String lastPrice = removeLastChar(actualPrice);
                keyword.simpleAssertEquals(totalPrice, lastPrice);
                break;
            case "wrong":
                keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TXT_STORE_CREDIT"),"-100");
                keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_USE_CREDIT"));
                keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_LBL_USE_CREDIT"),10);
//                keyword.assertEquals(PropertiesFile.getPropValue("CHECKOUT_MESSAGE_USE_CREDIT"),
//                        PropertiesFile.getPropValue("CHECKOUT_LBL_USE_CREDIT"));
        }

        checkOutWithBankTransfer();
    }
    public Float calculateMoney(float total, float storeCredit){
        return total - storeCredit;
    }

}
