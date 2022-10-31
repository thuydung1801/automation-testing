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
    public void changeQty(){
        keyword.imWait(5);
        keyword.selectDropDownListByIndex(PropertiesFile.getPropValue("CHECKOUT_DDL_QTY"), "2");
    }
}
