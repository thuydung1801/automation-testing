package page;

import core.*;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.util.ArrayList;
import java.util.WeakHashMap;


public class ProductDetailPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private SignInPage signInPage;

    public ProductDetailPage() {
        super();
    }
    public ProductDetailPage(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        signInPage = new SignInPage();
    }
    public void setUp() throws InterruptedException {
        objLogin.loginOnAlert();
        objRegister.acceptAllCookies();
        objRegister.chooseLanguages();
    }
    public void setUpWithLogin() throws InterruptedException {
        objLogin.loginOnAlert();
        objRegister.acceptAllCookies();
        objRegister.chooseLanguages();
        keyword.untilJqueryIsDone(30L);

        keyword.navigateToUrl("https://dev3.glamira.com/glgb/");
        keyword.untilJqueryIsDone(30L);
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS",null,null,true);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

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

                keyword.click("PRD_METAL_COLOR");
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.webDriverWaitForElementPresent("PRD_METAL_COLOR_OPTION",20);
                keyword.untilJqueryIsDone(30L);

                keyword.click("PRD_METAL_COLOR_OPTION");
                keyword.untilJqueryIsDone(30L);
                keyword.verifyElementVisible("PRD_VERIFY_IMG");
            }

        }

    }
    public void clickDropdown() throws InterruptedException {
        keyword.click("PRD_DROPDOWN");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        keyword.randomElement("PRD_CLICK_OPTIONE_SiZE");
    }
    public void clickAddCart() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("PRD_BTN_ADDCART");
//        Thread.sleep(10000);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.imWait(10);
        keyword.click("PRD_CART");
        keyword.click("PRD_BTN_VIEWCART");
        keyword.imWait(1);
        keyword.click("PRD_BTN_VIEWDETAIL");

    }
    public void optionSize() throws InterruptedException {
        keyword.click("PRD_DROPDOWN");
        keyword.imWait(2);
        keyword.click("PRD_OPTION_SIZE");
    }

    public void productInfo() throws InterruptedException {

        setUp();
        Thread.sleep(2000);
        keyword.navigateToUrl("URL_PRODUCT_INFO");
        keyword.webDriverWaitForElementPresent("PRD_CLICK_PRODUCT",20);
        keyword.click("PRD_CLICK_PRODUCT");
        keyword.untilJqueryIsDone(30L);

    }
    public void showImgProduct() throws InterruptedException {
        productInfo();
        System.out.printf("-----test 1: Show  detail image" +"\n");
        keyword.click("PRD_SHOW_IMG");
//        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresentByCss("PRD_CLOSE",50);
        keyword.clickByCss("PRD_CLOSE");
        keyword.verifyElementVisible("PRD_VERIFY_DEFAULT_IMG");

    }
    public void chooseDefaultOptionWithRing() throws InterruptedException {
     //   productInfo();
        System.out.printf("-----test 2: Default option "+"\n");
        selectOption();
        System.out.printf("=> test 2 done"+"\n");

        System.out.printf("------test 2.1: Dropdown"+"\n");
        keyword.imWait(1);
        clickDropdown();
        System.out.printf("=> test 2.1 done"+"\n");

    }
    public void chooseDefaultOptionWithNecklace1() throws InterruptedException {
//        setUp();
        keyword.openNewTab("https://dev3.glamira.com/glde/diamant-halsketten/");
        keyword.click("PRD_CLICK_PRODUCT_NECKLACE");
        keyword.untilJqueryIsDone(30L);
        keyword.verifyElementVisible("PRD_VERIFY_DEFAULT_NECKLACE");


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
        keyword.webDriverWaitForElementPresent("PRD_METAL_COLOR_OPTION",20);
        keyword.untilJqueryIsDone(30L);

        keyword.click("PRD_METAL_COLOR_OPTION");
        keyword.untilJqueryIsDone(30L);

        keyword.click("PRD_CLICK_CHAIN");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("PRD_CLICK_CHAIN_COLOR",20);

        keyword.click("PRD_CLICK_CHAIN_COLOR");
        keyword.untilJqueryIsDone(30L);

        keyword.click("PRD_CLICK_CHAIN_LENGTH");
        keyword.verifyElementVisible("PRD_VERIFY_NECKLACE");

    }
    public void commonOptionEngravingWithSendKey(String data)throws InterruptedException{
        keyword.openNewTab("URL_PRODUCT_DETAIL");
        keyword.webDriverWaitForElementPresent("PRD_ENGRAVING",20);
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
    public void commonOptionEngravingWithCopyPaste(String element1, String element2,String content)throws InterruptedException{
        keyword.openNewTab("URL_PRODUCT_DETAIL");
        keyword.webDriverWaitForElementPresent("PRD_ENGRAVING",20);
        keyword.click("PRD_ENGRAVING");

        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        keyword.copyPaste(element1,element2,content);
        clickDropdown();
        clickAddCart();
    }
    public void removeItemProduct() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.click("PRD_BTN_CLOSE_VIEWDETAIL");
        keyword.webDriverWaitForElementPresent("PRD_BTN_REMOVE_ITEM",30);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("PRD_BTN_REMOVE_ITEM");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.webDriverWaitForElementPresent("PED_BTN_REMOVE_OK",30);
        keyword.untilJqueryIsDone(30L);

        keyword.click("PED_BTN_REMOVE_OK");
        keyword.untilJqueryIsDone(30L);
    }

    public void productOptionEngraving1() throws InterruptedException {
        commonOptionEngravingWithSendKey("PRD_DATA_TEXT_ENGRAVING1");
        keyword.untilJqueryIsDone(30L);
        keyword.assertEquals("PRD_DATA_TEXT_ENGRAVING1","PRD_GET_TEXT_ENGRAVING");
        removeItemProduct();
    }
    public void productOptionEngraving2() throws InterruptedException{
        commonOptionEngravingWithCopyPaste("PRD_TEXT_ENGRAVING","PRD_TEXT_ENGRAVING","PRD_DATA_TEXT_ENGRAVING1");
        keyword.untilJqueryIsDone(30L);

        keyword.assertEquals("PRD_DATA_TEXT_ENGRAVING1","PRD_GET_TEXT_ENGRAVING");
        removeItemProduct();
    }
    public void productOptionEngraving3() throws InterruptedException {
        commonOptionEngravingWithSendKey("PRD_DATA_TEXT_ENGRAVING3");
        keyword.untilJqueryIsDone(30L);
        keyword.assertEquals("PRD_DATA_TEXT_ENGRAVING3","PRD_GET_TEXT_ENGRAVING");
        removeItemProduct();
    }
    public void productOptionEngraving4() throws InterruptedException {
        commonOptionEngravingWithCopyPaste("PRD_TEXT_ENGRAVING","PRD_TEXT_ENGRAVING","PRD_DATA_TEXT_ENGRAVING3");
        keyword.assertEquals("PRD_DATA_TEXT_ENGRAVING3","PRD_GET_TEXT_ENGRAVING");
        removeItemProduct();

    }
    public void chooseOptionFreeSize() throws InterruptedException {
        System.out.printf("---------test 3:check optionFreeSize " +"\n");
        keyword.openNewTab("URL_PRODUCT_DETAIL");
        optionFreeSize();
        System.out.printf("=> test 3 done");
    }

    public void commonFindSize() throws InterruptedException {
//        setUp();
        keyword.untilJqueryIsDone(30L);
        keyword.openNewTab("URL_PRODUCT_DETAIL");
        keyword.imWait(2);
        optionSize();
        keyword.webDriverWaitForElementPresent("PRD_FINDSIZE",20);
        keyword.click("PRD_FINDSIZE");

    }
    public void checkVerifySizeRing() throws InterruptedException {
        String exp = keyword.getText("PRD_DROPDOWN");
        String expected = exp.substring(0,2);
        String act = keyword.getText("PRD_CHECK_SIZE");
        String actual = act.substring(0,2);
        Assert.assertEquals(expected, actual);
        Thread.sleep(1000);
    }
    public void ringSize1() throws InterruptedException {
        keyword.reLoadPage();
        clickDropdown();
        keyword.untilJqueryIsDone(30L);
        checkVerifySizeRing();
        keyword.click("PRD_BTN_ADDCART");

    }
    public void ringSize2() throws InterruptedException {
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(30L);
        keyword.click("PRD_BTN_ADDCART");
        keyword.click("PRD_BTN_CLOSE_POPUP_SIZE");
        checkVerifyInputNull();
    }
    public void ringSize3() throws InterruptedException {
        keyword.click("PRD_DROPDOWN");
        keyword.untilJqueryIsDone(30L);
        keyword.click("PRD_OPTION_SIZE_AVERAGE");
        checkVerifySizeRing();
        keyword.click("PRD_BTN_ADDCART");
    }
    public void ringSize4(){

    }
    public void optionFindSizeWithInpSuccess() throws InterruptedException {
        commonFindSize();
        ipFindSize("PRD_DATA_FIRSTNAME", "PRD_DATA_LASTNAME", "PRD_DATA_EMAIL",
                "PRD_DATA_STREET", Integer.parseInt(PropertiesFile.getPropValue("PRD_DATA_CODE")),
                "PRD_DATA_CITY");

    }
    public void optionFindSizeWithInpNull() throws InterruptedException{
        commonFindSize();
//        keyword.openNewTab(PropertiesFile.getPropValue("URL_PRODUCT_DETAIL"));
        ipFindSize("COM_DATA_NULL","COM_DATA_NULL","COM_DATA_NULL",
                "COM_DATA_NULL", Integer.parseInt((PropertiesFile.getPropValue("PRD_DATA_CODE"))),
                "COM_DATA_NULL");
        checkVerifyInputNull();
    }
    public void optionFindSizeWithInpEmailError() throws InterruptedException{
        commonFindSize();
        ipFindSize("COM_DATA_NULL","COM_DATA_NULL","COM_DATA_ERROR",
                "PRD_DATA_STREET", Integer.parseInt(PropertiesFile.getPropValue("PRD_DATA_CODE")),
                "PRD_DATA_CITY");
        checkVerifyInputWithEmailError();
    }
    public void optionDimensionGuide() throws InterruptedException {
//        setUp();
        keyword.untilJqueryIsDone(30L);

        keyword.navigateToUrl("URL_PRODUCT_DETAIL");
        keyword.imWait(2);
        optionSize();
        keyword.click("PRD_FINDSIZE");
        keyword.imWait(2);
        keyword.clickByCss("PRD_LINK_SIZEGUIDE");
        keyword.webDriverWaitForElementPresent("PRD_VERIFY_LINK",20);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);

        keyword.verifyElementVisible("PRD_VERIFY_LINK");
        keyword.untilJqueryIsDone(30L);
    }
    public void optionFreeSize() throws InterruptedException {
        optionSize();
        keyword.click("PRD_FREESIZE");

    }
    public void checkVerifyInputNull(){
        keyword.assertEquals("COM_DATA_MESSAGES_NULL",
                "COM_TEXT_ERROR");
    }
    public void checkVerifyInputWithEmailError(){
        keyword.assertEquals("COM_DATA_MESSAGES_EMAIL",
                "COM_TEXT_ERROR_EMAIL");
    }
    public void ipFindSize(String firstName, String lastName, String email, String street,int code, String city) throws InterruptedException {
        keyword.imWait(5);
        keyword.sendKeys("PRD_TEXT_FIRSTNAME",firstName);
        keyword.sendKeys("PRD_TEXT_LASTNAME",lastName);
        keyword.sendKeys("PRD_TEXT_EMAIL",email);
        keyword.sendKeys("PRD_TEXT_STREET", street);
        keyword.sendKeys("PRD_TEXT_CODE",String.valueOf(code) );
        keyword.sendKeys("PRD_TEXT_CITY",city);

//        keyword.recaptchaClick();
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);

//        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("PRD_CHECK_VERYFI"), 10);
//        if(keyword.verifyElementVisible(PropertiesFile.getPropValue("PRD_CHECK_VERYFI"))){

            keyword.click("PRD_CHECK");
            keyword.click("PRD_BTN_SUBMIT");
    }
    public void commonProductPageWithLength(String getText,String dataBefore, String btnEdit,String verify,String option, String dataAfter ,String submit,boolean check) throws InterruptedException {
//        keyword.navigateToUrl(url);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);

      //  String textBefore = keyword.getText(getText);
        keyword.assertEquals(dataBefore,getText);
        keyword.click(btnEdit);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.verifyElementVisible(verify);

        keyword.click(option);
        if(check){
            keyword.click(submit);
            keyword.untilJqueryIsDone(30L);
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        }
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
      //  String textAfter = keyword.getText(getText);
        keyword.assertEquals(dataAfter,getText);
    }
    public void newNPP01() throws InterruptedException {
      //  setUpWithLogin();
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/glamira-bracelet-carolin.html?alloy=white-375&leather=beige&stone1=diamond-Brillant");
        commonProductPageWithLength("PRD_NEW_PAGE_GET_VALUE_LENGTH_1","PRD_NEW_PAGE_VERIFY_DATA_LENGTH_BEFORE_1",
                "PRD_NEW_PAGE_BTN_EDIT","PRD_NEW_PAGE_VERIFY_ALL_OPTION",
                "PRD_NEW_PAGE_BTN_EDIT_OPTION_LARGE","PRD_NEW_PAGE_VERIFY_DATA_LENGTH_AFTER_1",
                "PRD_NEW_PAGE_BTN_OK_PRODUCT",false);

    }
    public void newNPP02() throws InterruptedException {
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/glamira-bracelet-blejan-20-cm.html?alloy=yellow-750&stone1=diamond-Brillant");
        commonProductPageWithLength("PRD_NEW_PAGE_GET_VALUE_LENGTH_2","PRD_NEW_PAGE_VERIFY_DATA_LENGTH_BEFORE_2",
                "PRD_NEW_PAGE_BTN_EDIT_DETAIL","PRD_NEW_PAGE_VERIFY_OPTION_LARGE",
                "PRD_NEW_PAGE_BTN_OPTION_MEDDIUM","PRD_NEW_PAGE_VERIFY_DATA_LENGTH_AFTER_2",
                "PRD_NEW_PAGE_BTN_OK_PRODUCT",true);

    }
    public void newNPP03() throws InterruptedException {
        keyword.back();
        commonProductPageWithLength("PRD_NEW_PAGE_GET_VALUE_LENGTH_2","PRD_NEW_PAGE_VERIFY_DATA_LENGTH_BEFORE_2",
                "PRD_NEW_PAGE_BTN_EDIT_DETAIL","PRD_NEW_PAGE_VERIFY_OPTION_LARGE",
                "PRD_NEW_PAGE_BTN_OPTION_LENGTH","PRD_NEW_PAGE_VERIFY_DATA_LENGTH_BEFORE_2",
                "PRD_NEW_PAGE_BTN_OK_PRODUCT",true);

    }
    public void newNPP04() throws InterruptedException {
        keyword.reLoadPage();
        commonProductPageWithLength("PRD_NEW_PAGE_GET_VALUE_LENGTH_2","PRD_NEW_PAGE_VERIFY_DATA_LENGTH_BEFORE_2",
                "PRD_NEW_PAGE_BTN_EDIT_DETAIL","PRD_NEW_PAGE_VERIFY_OPTION_LARGE",
                "PRD_NEW_PAGE_BTN_OPTION_MEDDIUM","PRD_NEW_PAGE_VERIFY_DATA_LENGTH_BEFORE_2",
                "PRD_NEW_PAGE_BTN_CANCEL",true);

    }
    public void commonProductPageWithStoneSize(String element,String verify,String option,String message,String optionAfter,String submit,String verifyAfter,boolean check) throws InterruptedException {
        keyword.click(element);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        keyword.verifyElementVisible(verify);
        keyword.click(option);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        keyword.verifyElementVisible(message);
        if(optionAfter!=null){
            keyword.click(optionAfter);
        }

        keyword.click(submit);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(check){
            keyword.click(element);
        }

        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.verifyElementVisible(verifyAfter);

    }
    public void newNPP05() throws InterruptedException {
//        setUpWithLogin();
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/glamira-ring-bridal-rise-skud32258-1.html?alloy=white-585&stone1=diamond-sapphire");
        commonProductPageWithStoneSize("PRD_NEW_PAGE_BTN_STONE_SIZE","PRD_NEW_PAGE_VERIFY_ALL_OPTION_STONE",
                "PRD_NEW_PAGE_OPTION_STONE_005","PRD_NEW_PAGE_VERIFY_OPTION_STONE_005",
                null,
                "PRD_NEW_PAGE_BTN_OK_PRODUCT","PRD_NEW_PAGE_VERIFY_OPTION_STONE_005_AFTER",true);

    }
    public void newNPP06() throws InterruptedException {
//        setUpWithLogin();
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/fever-twist-1.html?alloy=white-silber&womenstone=diamond-zirconia");
        commonProductPageWithStoneSize("PRD_NEW_PAGE_BTN_SET_OPTION","PRD_NEW_PAGE_VERIFY_ALL_SET_OPTION",
                "PRD_NEW_PAGE_SET_OPTION_WOMEN","PRD_NEW_PAGE_VERIFY_SET_OPTION_WOMEN",
                "PRD_NEW_PAGE_SET_OPTION_WOMEN_AFTER",
                "PRD_NEW_PAGE_BTN_OK_PRODUCT","PRD_NEW_PAGE_VERIFY_SET_OPTION_WOMEN_AFTER",true);

    }
    public void newNPP07() throws InterruptedException {
        keyword.back();
        commonProductPageWithStoneSize("PRD_NEW_PAGE_BTN_SET_OPTION","PRD_NEW_PAGE_VERIFY_ALL_SET_OPTION",
                "PRD_NEW_PAGE_SET_OPTION_WOMEN","PRD_NEW_PAGE_VERIFY_SET_OPTION_WOMEN",
                "PRD_NEW_PAGE_SET_OPTION_MEN",
                "PRD_NEW_PAGE_BTN_OK_PRODUCT","PRD_NEW_PAGE_VERIFY_SET_OPTION_MEN_AFTER",true);

    }
    public void newNPP08() throws InterruptedException {
        keyword.back();
        commonProductPageWithStoneSize("PRD_NEW_PAGE_BTN_SET_OPTION","PRD_NEW_PAGE_VERIFY_ALL_SET_OPTION",
                "PRD_NEW_PAGE_SET_OPTION_WOMEN","PRD_NEW_PAGE_VERIFY_SET_OPTION_WOMEN",
                "PRD_NEW_PAGE_SET_OPTION_PAIR",
                "PRD_NEW_PAGE_BTN_OK_PRODUCT","PRD_NEW_PAGE_VERIFY_SET_OPTION_PAIR_AFTER",false);

    }




}
