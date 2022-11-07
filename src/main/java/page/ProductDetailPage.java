package page;

import core.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;

import java.util.ArrayList;
import java.util.WeakHashMap;


public class ProductDetailPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    public ProductDetailPage() {
        super();
    }
    public ProductDetailPage(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
    }
    public void setUp() throws InterruptedException {
        objLogin.loginOnAlert();
        objRegister.acceptAllCookies();
        objRegister.chooseLanguages();
    }
    public void selectOption() throws InterruptedException {
        Thread.sleep(100);
        ArrayList<String> arr = new ArrayList<>();
        arr.add(PropertiesFile.getPropValue("PRD_STONE2"));
        arr.add(PropertiesFile.getPropValue("PRD_METAL_ALLOY"));
        arr.add(PropertiesFile.getPropValue("PRD_ENGRAVING"));

        for(String option : arr){
            if(option != arr.get(arr.size()-1)){
                Thread.sleep(2000);
                keyword.click(option);

            }
            else{
                keyword.click(option);
                Thread.sleep(2000);
                keyword.click(PropertiesFile.getPropValue("PRD_TEXT_ENGRAVING"));
                Thread.sleep(20000);
                keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_ENGRAVING"),
                        PropertiesFile.getPropValue("PRD_DATA_TEXT_ENGRAVING"));

            }

        }

    }
    public void clickDropdown() throws InterruptedException {
        keyword.click(PropertiesFile.getPropValue("PRD_DROPDOWN"));
        Thread.sleep(1000);
//        keyword.click(PropertiesFile.getPropValue("PRD_CLICK_OPTIONE_SiZE"));
        keyword.randomElement(PropertiesFile.getPropValue("PRD_CLICK_OPTIONE_SiZE"));
    }
    public void clickAddCart() throws InterruptedException {
        Thread.sleep(3000);
        keyword.click(PropertiesFile.getPropValue("PRD_BTN_ADDCART"));
//        Thread.sleep(10000);
        keyword.imWait(10);
        keyword.click(PropertiesFile.getPropValue("PRD_CART"));
        keyword.click(PropertiesFile.getPropValue("PRD_BTN_VIEWCART"));
        keyword.imWait(1);
        keyword.click(PropertiesFile.getPropValue("PRD_BTN_VIEWDETAIL"));

        System.out.printf("check engravingText : " );
        keyword.getText(PropertiesFile.getPropValue("PRD_GET_TEXT_ENGRAVING"));


    }
    public void optionSize(){
        keyword.click(PropertiesFile.getPropValue("PRD_DROPDOWN"));
        keyword.imWait(2);
        keyword.click(PropertiesFile.getPropValue("PRD_OPTION_SIZE"));
        keyword.imWait(2);

    }

    public void productInfo() throws InterruptedException {

        setUp();
        Thread.sleep(2000);
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_PRODUCT_INFO"));
        Thread.sleep(5000);

        keyword.click(PropertiesFile.getPropValue("PRD_CLICK_PRODUCT"));

    }
    public void testCase_PRD_Info1() throws InterruptedException {
//        productInfo();
        System.out.printf("-----test 1: Show  detail image" +"\n");
        keyword.click(PropertiesFile.getPropValue("PRD_SHOW_IMG"));
        Thread.sleep(2000);
        keyword.clickByCss(PropertiesFile.getPropValue("PRD_CLOSE"));
        System.out.printf("=> test 1 done"+"\n");

    }
    public void testCase_PRD_Info2() throws InterruptedException {
//        productInfo();
        System.out.printf("-----test 2: Default option "+"\n");
        selectOption();
        System.out.printf("=> test 2 done"+"\n");

        System.out.printf("------test 2.1: Dropdown"+"\n");
        keyword.imWait(1);
        clickDropdown();
        System.out.printf("=> test 2.1 done"+"\n");

        System.out.printf("------test 2.2: Add to cart"+"\n");
        clickAddCart();
        System.out.printf("=>test 2.2 done"+"\n");
    }
    public void testCase_PRD_Info3(){
        System.out.printf("---------test 3:check optionFreeSize " +"\n");
        keyword.openNewTab(PropertiesFile.getPropValue("URL_PRODUCT_DETAIL"));
        optionFreeSize();
        System.out.printf("=> test 3 done");
    }


    public void optionFindSize() throws InterruptedException  {
        setUp();
        Thread.sleep(2000);
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_PRODUCT_DETAIL"));
        keyword.imWait(2);
        optionSize();
        keyword.click(PropertiesFile.getPropValue("PRD_FINDSIZE"));
        //---------------
        ipFindSize(PropertiesFile.getPropValue("PRD_DATA_FIRSTNAME"),
                PropertiesFile.getPropValue("PRD_DATA_LASTNAME"),
                PropertiesFile.getPropValue("PRD_DATA_EMAIL"),
                PropertiesFile.getPropValue("PRD_DATA_STREET"),
                Integer.parseInt(PropertiesFile.getPropValue("PRD_DATA_CODE")),
                PropertiesFile.getPropValue("PRD_DATA_CITY"));

        //----------
//        ipFindSize(PropertiesFile.getPropValue("PRD_DATA_FIRSTNAME"),
//                PropertiesFile.getPropValue("PRD_DATA_LASTNAME"),
//                PropertiesFile.getPropValue("PRD_DATA_ERROR"),
//                PropertiesFile.getPropValue("PRD_DATA_STREET"),
//                Integer.parseInt(PropertiesFile.getPropValue("PRD_DATA_CODE")),
//                PropertiesFile.getPropValue("PRD_DATA_CITY"));

        //------------



    }
    public void optionDimensionGuide() throws InterruptedException {
//        setUp();
        Thread.sleep(3000);
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_PRODUCT_DETAIL"));
        keyword.imWait(2);
        optionSize();
        keyword.click(PropertiesFile.getPropValue("PRD_FINDSIZE"));
        keyword.imWait(2);
        keyword.clickByCss(PropertiesFile.getPropValue("PRD_LINK_SIZEGUIDE"));

    }
    public void optionFreeSize(){
        optionSize();
        keyword.click(PropertiesFile.getPropValue("PRD_FREESIZE"));

    }
    public void ipFindSize(String firstName, String lastName, String email, String street, int code, String city) throws InterruptedException {
        keyword.imWait(2);
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_FIRSTNAME"),firstName);
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_LASTNAME"),lastName);
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_EMAIL"),email);
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_STREET"), street);
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_CODE"), String.valueOf(code));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_CITY"),city);

//        keyword.recaptchaClick();
        Thread.sleep(10000);
        keyword.click(PropertiesFile.getPropValue("PRD_CHECK"));
        keyword.click(PropertiesFile.getPropValue("PRD_BTN_SUBMIT"));

        if(PropertiesFile.getPropValue("PRD_TEXT_ERROR").isEmpty()){
            System.out.printf("Continue...." + "\n");
        }
        else{
            System.out.printf("Error..." + "\n");

        }


    }



}
