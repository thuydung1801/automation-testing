package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
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
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_CLOSE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
//        String expected = keyword.getText(PropertiesFile.getPropValue("CHECKOUT_LBL_MESSAGE"));
//        String actual = "Women's ring Smart Ornament was added to your shopping cart.";
//        logger.info(expected);
//        logger.info(actual);
//        keyword.assertEquals(expected,actual);

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
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_CLOSE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
    }

    public void addProductWithGift(String url) throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);

        Thread.sleep(5000);
        keyword.navigateToUrl(url);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
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
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_MINICART"));
        keyword.imWait(10);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_MINICART_VIEWALL"));

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
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_LBL_VIEWDETAIL"),5);


    }
    public void inputEngravingwithSingleRing(String data, String btnAdd, String engraving) throws InterruptedException {
        keyword.imWait(30);
        keyword.click(PropertiesFile.getPropValue(btnAdd));
        keyword.imWait(30);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_TITLE_ENGRAVING"),5);
        keyword.imWait(20);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TXT_ENGRAVING"),
                PropertiesFile.getPropValue(data));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_VIEWDETAIL_BTN_SAVE"));
        Thread.sleep(2000);
        keyword.assertEquals(PropertiesFile.getPropValue(data),
                PropertiesFile.getPropValue(engraving));
    }
    public void inputEngravingwithCoupleRing() throws InterruptedException {
        keyword.imWait(15);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_HYPERLINK_ADD"));
        keyword.imWait(10);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_TITLE_ENGRAVING"),5);
        keyword.imWait(10);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TXT_WOMEN_ENGRAVING"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_ENGRAVING"));
        Thread.sleep(2000);
        keyword.imWait(20);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_TXT_MEN_ENGRAVING"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_ENGRAVING"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_VIEWDETAIL_BTN_SAVE"));
        Thread.sleep(10000);
        keyword.assertEquals(PropertiesFile.getPropValue("CHECKOUT_DATA_ENGRAVING")+ " - "+ PropertiesFile.getPropValue("CHECKOUT_DATA_ENGRAVING")
        , PropertiesFile.getPropValue("CHECKOUT_LBL_ENGRAVING"));
    }
}
