package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.util.ArrayList;

public class ProductDetailPage_Mobile extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private SignInPage signInPage;
    private ProductDetailPage productDetailPage;

    public ProductDetailPage_Mobile() {
        super();
    }
    public ProductDetailPage_Mobile(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        signInPage = new SignInPage();
        productDetailPage = new ProductDetailPage();
    }
    public void showImgProduct() throws InterruptedException {
        //     productInfo();
        System.out.printf("-----test 1: Show  detail image" +"\n");
        keyword.click("PRD_SHOW_IMG_MOBILE");
//        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresentByCss("PRD_CLOSE",50);
        keyword.clickByCss("PRD_CLOSE");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.verifyElementVisible("PRD_SHOW_IMG_MOBILE");

    }
    public void selectOption() throws InterruptedException {
        Thread.sleep(100);
        ArrayList<String> arr = new ArrayList<>();
        arr.add(PropertiesFile.getPropValue("PRD_STONE2"));
        arr.add(PropertiesFile.getPropValue("PRD_METAL_ALLOY"));
//        arr.add(PropertiesFile.getPropValue("PRD_ENGRAVING"));

        for(String option : arr){
            if(option != arr.get(arr.size()-1) && option != arr.get(1)){
                keyword.untilJqueryIsDone(30L);
                keyword.click(option);

            }
            else if(option == arr.get(1)){
                keyword.untilJqueryIsDone(30L);
                keyword.click(option);
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.untilJqueryIsDone(30L);

//                keyword.click("PRD_SHOW_IMG_MOBILE");
//                keyword.untilJqueryIsDone(30L);
//                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//                keyword.webDriverWaitForElementPresent("PRD_METAL_COLOR_OPTION",20);
//                keyword.untilJqueryIsDone(30L);
//                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//                keyword.scrollDownToElement("PRD_METAL_COLOR_OPTION");
//                keyword.untilJqueryIsDone(30L);
//                keyword.click("PRD_METAL_COLOR_OPTION");
                keyword.untilJqueryIsDone(30L);
                keyword.verifyElementVisible("PRD_SHOW_IMG_MOBILE");
            }

        }

    }
    public void clickDropdown() throws InterruptedException {
        keyword.click("PRD_DROPDOWN");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        keyword.randomElement("PRD_CLICK_OPTIONE_SiZE");
    }
    public void chooseDefaultOptionWithRing() throws InterruptedException {
        //   productInfo();
        System.out.printf("-----test 2: Default option "+"\n");
        objRegister.acceptAllCookies();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        selectOption();
        System.out.printf("=> test 2 done"+"\n");

        System.out.printf("------test 2.1: Dropdown"+"\n");
        keyword.imWait(1);
        clickDropdown();
        System.out.printf("=> test 2.1 done"+"\n");

    }
    public void chooseDefaultOptionWithNecklace2() throws InterruptedException {
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("PRD_METAL_ALLOY",20);
        keyword.click("PRD_METAL_ALLOY");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);

        keyword.click("PRD_METAL_COLOR_NECKLACE");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.webDriverWaitForElementPresent("PRD_METAL_COLOR_OPTION_MOBILE",20);
        keyword.untilJqueryIsDone(30L);

        keyword.click("PRD_METAL_COLOR_OPTION_MOBILE");
        keyword.untilJqueryIsDone(30L);

        keyword.click("PRD_CLICK_CHAIN");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("PRD_CLICK_CHAIN_COLOR",20);

        keyword.click("PRD_CLICK_CHAIN_COLOR");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("PRD_CLICK_CHAIN_LENGTH");
        keyword.verifyElementVisible("PRD_VERIFY_NECKLACE");

    }
    public void clickAddCart() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("PRD_BTN_ADDCART");
//        Thread.sleep(10000);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        Thread.sleep(7000);
        keyword.click("PRD_CART");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("PRD_BTN_VIEWCART");
        keyword.imWait(1);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("PRD_BTN_VIEWDETAIL_MOBILE");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");


    }
    public void commonOptionEngravingWithSendKey(String data, int caseNum)throws InterruptedException{
        keyword.openNewTab("URL_PRODUCT_DETAIL");
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("PRD_ENGRAVING",20);
        keyword.scrollDownToElement("PRD_ENGRAVING");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        Thread.sleep(3000);
        if(caseNum == 1){
            objRegister.chooseLanguages();
            keyword.webDriverWaitForElementPresent("BTN_COOKIES",50);
            if(keyword.verifyElementPresent("BTN_COOKIES")){
                keyword.click("BTN_COOKIES");
                keyword.untilJqueryIsDone(30L);
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

            }
        }
        keyword.click("PRD_ENGRAVING");

        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("PRD_TEXT_ENGRAVING");
//        Thread.sleep(10000);
        keyword.sendKeys("PRD_TEXT_ENGRAVING", data);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        clickDropdown();
        clickAddCart();
    }
    public void productOptionEngraving1() throws InterruptedException {
        commonOptionEngravingWithSendKey("PRD_DATA_TEXT_ENGRAVING1",1);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        String text = keyword.getText("PRD_GET_TEXT_ENGRAVING");
        System.out.printf("get text : " + text );
        keyword.assertEquals("PRD_DATA_TEXT_ENGRAVING1","PRD_GET_TEXT_ENGRAVING");
        productDetailPage.removeItemProduct();
    }
    public void productOptionEngraving2() throws InterruptedException{
        productDetailPage.commonOptionEngravingWithCopyPaste("PRD_TEXT_ENGRAVING","PRD_TEXT_ENGRAVING","PRD_DATA_TEXT_ENGRAVING1");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        String text = keyword.getText("PRD_GET_TEXT_ENGRAVING");
        System.out.printf("get text : " + text );
        keyword.assertEquals("PRD_DATA_TEXT_ENGRAVING1","PRD_GET_TEXT_ENGRAVING");
        productDetailPage.removeItemProduct();
    }
    public void productOptionEngraving3() throws InterruptedException {
        commonOptionEngravingWithSendKey("PRD_DATA_TEXT_ENGRAVING3",3);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        String text = keyword.getText("PRD_GET_TEXT_ENGRAVING");
        System.out.printf("get text : " + text );
        keyword.assertEquals("PRD_DATA_TEXT_ENGRAVING3","PRD_GET_TEXT_ENGRAVING");
        productDetailPage.removeItemProduct();
    }
    public void productOptionEngraving4() throws InterruptedException {
        productDetailPage.commonOptionEngravingWithCopyPaste("PRD_TEXT_ENGRAVING","PRD_TEXT_ENGRAVING","PRD_DATA_TEXT_ENGRAVING3");
        String text = keyword.getText("PRD_GET_TEXT_ENGRAVING");
        System.out.printf("get text : " + text );
        keyword.assertEquals("PRD_DATA_TEXT_ENGRAVING3","PRD_GET_TEXT_ENGRAVING");
        productDetailPage.removeItemProduct();

    }

}
