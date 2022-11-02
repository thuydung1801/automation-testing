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
//        Thread.sleep(2000);
//        objRegist.chooseLanguages();
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_CHECKBOX_SIZE_H"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_CLOSE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_ADDPRODUCT_BTN_ADD"));
        keyword.verifyElementVisible(PropertiesFile.getPropValue("CHECKOUT_LBL_MESSAGE"));
        String expected = keyword.getText(PropertiesFile.getPropValue("CHECKOUT_LBL_MESSAGE"));
        String actual = "Women's ring Smart Ornament was added to your shopping cart.";
        logger.info(expected);
        logger.info(actual);
        keyword.assertEquals(expected,actual);


    }

    public void clickShoppingBagPage(){
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_MINICART"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_MINICART_VIEWALL"));


    }
}
