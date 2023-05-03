package page;

import core.*;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.testng.Assert;
import page.checkout.LoginAddressPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

import java.util.ArrayList;
import java.util.Date;
import java.util.WeakHashMap;


public class ProductDetailPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private SignInPage signInPage;
    private SignUpPage signUpPage;
    private LoginAddressPage objLoginAddress;

    public ProductDetailPage() {
        super();
    }
    public ProductDetailPage(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        signInPage = new SignInPage();
        signUpPage = new SignUpPage();
        objLoginAddress = new LoginAddressPage();
    }
    public void setUp() throws InterruptedException {
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        //  objLogin.loginOnAlert();
        objRegister.acceptAllCookies();
     //   objRegister.chooseLanguages();
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
                keyword.untilJqueryIsDone(30L);
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.webDriverWaitForElementPresent("PRD_METAL_COLOR_OPTION",20);
                keyword.untilJqueryIsDone(30L);
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.scrollDownToElement("PRD_METAL_COLOR_OPTION");
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
        Thread.sleep(5000);
        keyword.click("PRD_CART");
        keyword.click("PRD_BTN_VIEWCART");
        keyword.imWait(1);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("PRD_BTN_VIEWDETAIL");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");


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
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void showImgProduct() throws InterruptedException {
   //     productInfo();
        System.out.printf("-----test 1: Show  detail image" +"\n");
        keyword.click("PRD_SHOW_IMG");
//        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresentByCss("PRD_CLOSE",50);
        keyword.clickByCss("PRD_CLOSE");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.verifyElementVisible("PRD_VERIFY_DEFAULT_IMG");

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
    public void chooseDefaultOptionWithNecklace1() throws InterruptedException {
//        setUp();
        keyword.openNewTab("https://dev3.glamira.com/glgb/diamond-necklaces/diamond/");

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
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("PRD_CLICK_CHAIN_LENGTH");
        keyword.verifyElementVisible("PRD_VERIFY_NECKLACE");

    }
    public void commonOptionEngravingWithSendKey(String data)throws InterruptedException{
        keyword.openNewTab("URL_PRODUCT_DETAIL");
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("PRD_ENGRAVING",20);
        keyword.scrollDownToElement("PRD_ENGRAVING");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
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
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
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
        String text = keyword.getText("PRD_GET_TEXT_ENGRAVING");
        System.out.printf("get text : " + text );
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
        System.out.printf("expect : " +expected + "\n" + "actual : " +actual+"\n");
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
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        checkVerifyInputNull();
    }
    public void ringSize3() throws InterruptedException {
        keyword.click("PRD_DROPDOWN");
        keyword.untilJqueryIsDone(30L);
        keyword.click("PRD_OPTION_SIZE_AVERAGE");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

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
        keyword.click("PRD_LINK_SIZEGUIDE");
       // keyword.webDriverWaitForElementPresent("PRD_VERIFY_LINK",20);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);

        keyword.verifyElementVisible("PRD_VERIFY_LINK");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.switchToTab(0);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

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

    public void checkChangePrice(String beforePrice, String afterPrice,String verifyImg){
        boolean check;
        if(keyword.verifyElementVisible(verifyImg) && !beforePrice.equalsIgnoreCase(afterPrice)){
            check=true;
        } else{
            check=false;
        }
        Assert.assertEquals(check,true);
    }
    public void checkPrice(String beforePrice, String afterPrice){
        boolean check;
        if(beforePrice.equalsIgnoreCase(afterPrice)){
            check=true;
        }else{
            check=false;
        }
        Assert.assertEquals(check,true);
    }
    public void commonVerifyProductPageWithOption1(String beforePrice, String afterPrice,String option,String backUrl,String verifyImg ) throws InterruptedException {
//        boolean check;
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        String bfPrice = keyword.getText(beforePrice);
        keyword.untilJqueryIsDone(30L);
        if (backUrl!=null){
            keyword.navigateToUrl(backUrl);
        }
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(60L);
        keyword.click(option);
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(60L);
        String afPrice = keyword.getText(afterPrice);
        System.out.printf("before : " + bfPrice + "\n" + "after : " + afPrice + "\n");
        if(verifyImg!=null){
            checkChangePrice(bfPrice,afPrice,verifyImg);
        }
        else {
            checkPrice(bfPrice,afPrice);
        }

    }

    public void newNPP12(String baseURL) throws InterruptedException {
//        setUp();
        keyword.navigateToUrl(baseURL + "glamira-ring-leila-skug100425.html?alloy=white-585&stone1=diamond-Brillant&stone2=diamond-Brillant");
        commonVerifyProductPageWithOption1("PRD_NEW_PAGE_GET_PRICE","PRD_NEW_PAGE_GET_PRICE",
                    "PRD_NEW_PAGE_OPTION_STONE",null,"PRD_NEW_PAGE_VERIFY_IMG_1");
    }
    public void newNPP13(String baseURL) throws InterruptedException {
        keyword.navigateToUrl(baseURL + "glamira-ring-alceste.html?alloy=white-585&stone1=diamond-Brillant&stone2=diamond-Brillant&stone3=diamond-Brillant");
        commonVerifyProductPageWithOption1("PRD_NEW_PAGE_GET_PRICE","PRD_NEW_PAGE_GET_PRICE",
                    "PRD_NEW_PAGE_OPTION_STONE", null,"PRD_NEW_PAGE_VERIFY_LAYER_IMG_1");
    }
    public void newNPP14(String baseURL) throws InterruptedException {
        keyword.navigateToUrl(baseURL +  "glamira-halskette-maria-skug100700.html?alloy=white-585&stone1=diamond-sapphire");
        keyword.untilJqueryIsDone(30L);
        keyword.click("PRD_METAL_ALLOY");
        keyword.executeJavaScript("window.scrollTo(0, 500)");
        keyword.untilJqueryIsDone(30L);
        keyword.click("PRD_NEW_PAGE_OPTION_COLOR");
        keyword.untilJqueryIsDone(30L);
        commonVerifyProductPageWithOption1("PRD_NEW_PAGE_GET_PRICE","PRD_NEW_PAGE_GET_PRICE",
                "PRD_NEW_PAGE_OPTION_METAL", null,"PRD_NEW_PAGE_VERIFY_IMG_CHAIN");
    }
    public void commonSubmitFormBracelet(String baseURL) throws InterruptedException {
        keyword.navigateToUrl(baseURL +  "glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
//        keyword.executeJavaScript("window.scrollTo(0, 300)");
        keyword.click("PRD_LIST_PAGE_BTN_MORE_DETAIL");
        keyword.untilJqueryIsDone(60L);
        keyword.click("PRD_NEW_PAGE_CLICK_LENGTH");
        keyword.untilJqueryIsDone(60L);
        keyword.click("PRD_NEW_PAGE_CLICK_FIND_BRACELET_SIZE");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");
        Thread.sleep(3000);
        if(keyword.verifyElementVisible("PRD_NEW_PAGE_CLICK_LINK_LOGIN_REGISTER")){
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");
            Thread.sleep(1000);
            keyword.click("PRD_NEW_PAGE_CLICK_LINK_LOGIN_REGISTER");

        }
        Thread.sleep(2000);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");


    }
    public void commonInputInformationOrderBraceletSizer(boolean flag) throws InterruptedException {
        // flag = true check for customer login and flag= false not for customer login
        if(!flag){

            keyword.click("PRD_NEW_PAGE_CLICK_HERE");
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");

            keyword.executeJavaScript("window.scrollTo(0, 500)");
        }
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");
        Thread.sleep(2000);
        keyword.sendKeys("PRD_NEW_PAGE_INP_ADDRESS_STREET","LP_DATA_STREET");
        keyword.sendKeys("PRD_NEW_PAGE_INP_ZIP_CODE","CHECKOUT_LA_DATA_CODE_1");
        keyword.sendKeys("PRD_NEW_PAGE_INP_CITY","CHECKOUT_LA_DATA_CITY_1");
        keyword.click("PRD_NEW_PAGE_CHECKBOX");
        keyword.click("PRD_NEW_PAGE_SUBMIT");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");
        keyword.verifyElementVisible("PRD_NEW_PAGE_MESS_SUCCESS");
        keyword.assertEquals("PRD_NEW_PAGE_DATA_MESS_SUCCESS","PRD_NEW_PAGE_MESS_SUCCESS");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");

    }
// NPP15-18 : https://dev3.glamira.com/glgb/
    public void newNPP15(String baseURL) throws InterruptedException {
        setUp();
        commonSubmitFormBracelet(baseURL);
        signInPage.loginSuccessfully("COM_INP_DATA_EMAIL","COM_INP_DATA_PASS");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");
        Thread.sleep(3000);
        commonInputInformationOrderBraceletSizer(false);
    }
    public void commonInputEmailAndPasswordRandom() throws InterruptedException {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String mail = "dung"+timestamp+"@gmail.com";
        PropertiesFile.serPropValue("COM_INP_DATA_EMAIL_RANDOM",mail);

        String pass = "Dung*"+timestamp;
        PropertiesFile.serPropValue("COM_INP_DATA_PASS_RANDOM",pass);
        keyword.untilJqueryIsDone(60L);
    }
    public void submitformBraceletSucessfullyWithRegisterAccount() throws InterruptedException {
        keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");

        commonInputEmailAndPasswordRandom();

        signUpPage.sendKeyFullDataFormInformation("thuy","dung","COM_INP_DATA_EMAIL_RANDOM","COM_INP_DATA_EMAIL_RANDOM");
        keyword.click("PRD_NEW_PAGE_BTN_NEXT");
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");

        signUpPage.sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION",
                "COM_INP_DATA_PASS_RANDOM", "SIGNUP_SELECT_TITLE",
                "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("PRD_NEW_PAGE_BTN_NEXT_CREATE_ACC");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");

    }
    public void newNPP16(String baseURL) throws InterruptedException {
        objLoginAddress.resetForNewCase();
        commonSubmitFormBracelet(baseURL);
        submitformBraceletSucessfullyWithRegisterAccount();
        commonInputInformationOrderBraceletSizer(false);
    }
    public void newNPP18_NPP17(String baseURL) throws InterruptedException {
        objLoginAddress.resetForNewCase();
        commonInputEmailAndPasswordRandom();
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL_RANDOM","COM_INP_DATA_PASS_RANDOM",null,null,true);
        commonSubmitFormBracelet(baseURL);
        keyword.click("PRD_NEW_PAGE_SUBMIT");
        keyword.assertEquals("COM_DATA_MESSAGES_NULL","COM_TEXT_ERROR");
        // NPP17
        commonSubmitFormBracelet(baseURL);
        commonInputInformationOrderBraceletSizer(true);
    }
//    public void newNPP17(String baseURL) throws InterruptedException {
//        commonInputEmailAndPasswordRandom();
//        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL_RANDOM","COM_INP_DATA_PASS_RANDOM",null,null,true);
//        commonSubmitFormBracelet(baseURL);
//        commonInputInformationOrderBraceletSizer(true);
//    }


    public void pricePP01(String baseURL) throws InterruptedException {
//        setUp();
        //https://www.glamira.com/
        keyword.navigateToUrl(baseURL + "glamira-ring-verde.html");
        commonVerifyProductPageWithOption1("PRD_PAGE_GET_PRICE","PRD_PAGE_GET_PRICE",
                "PRD_PAGE_CLICK_PRD_PP01", baseURL + "diamond-rings/diamond/",null);

    }
    public void pricePP02(String baseURL) throws InterruptedException{
        setUp();
        keyword.navigateToUrl(baseURL + "exclusive-deals/");
        commonVerifyProductPageWithOption1("PRD_LIST_PAGE_PRICE_PRD_PP02","PRD_PAGE_GET_PRICE",
                "PRD_LIST_PAGE_CLICK_PRD_PP02", null,null);

    }
    public void pricePP03(String baseURL) throws InterruptedException{
        setUp();
        boolean check;
        keyword.navigateToUrl(baseURL + "diamond-rings/");
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(60L);
        keyword.executeJavaScript("window.scrollTo(0, 900)");
        keyword.click("PRD_LIST_PAGE_FILTER_SHAPE");
        keyword.click("PRD_LIST_PAGE_FILTER_SHAPE_OPTION");
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(60L);
        String beforePrice = keyword.getText("PRD_LIST_PAGE_PRICE_PRD_PP03");

        keyword.click("PRD_LIST_PAGE_CLICK_PRD_PP03");
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(60L);
        String afterPrice = keyword.getText("PRD_PAGE_GET_PRICE");

        keyword.executeJavaScript("window.scrollTo(0, 700)");
        keyword.click("PRD_LIST_PAGE_BTN_MORE_DETAIL");
        String getTextShape = keyword.getText("PRD_LIST_PAGE_PRD_DETAIL_GET_SHAPE");
        System.out.printf("before : " + beforePrice + "\n" + "after : " + afterPrice + "\n");
        System.out.printf("shape == " + getTextShape);
        keyword.waitForElementNotVisible(60,"//div[@class='loading-mask']");

        if(getTextShape.equalsIgnoreCase(PropertiesFile.getPropValue("PRD_LIST_PAGE_PRD_DETAIL_DATA_SHAPE")) &&
                beforePrice.equalsIgnoreCase(afterPrice) ){
            check=true;
        }else{
            check=false;
        }
        Assert.assertEquals(check,true);
    }

}
