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
                keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_ENGRAVING"), PropertiesFile.getPropValue("PRD_DATA_TEXT_ENGRAVING"));

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

    public void productInfo() throws InterruptedException {

        setUp();
        Thread.sleep(2000);
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_PRODUCT_INFO"));
        Thread.sleep(5000);

        keyword.click(PropertiesFile.getPropValue("PRD_CLICK_PRODUCT"));

        System.out.printf("-----test 1: Show  detail image" +"\n");
        keyword.click(PropertiesFile.getPropValue("PRD_SHOW_IMG"));
        Thread.sleep(2000);
//        keyword.imWait(2);
        keyword.clickByCss(PropertiesFile.getPropValue("PRD_CLOSE"));
        System.out.printf("=> test 1 done"+"\n");

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
        keyword.click(PropertiesFile.getPropValue("PRD_DROPDOWN"));
        keyword.imWait(2);
        keyword.click(PropertiesFile.getPropValue("PRD_OPTION_SIZE"));
        keyword.imWait(2);
        keyword.click(PropertiesFile.getPropValue("PRD_FINDSIZE"));

        keyword.imWait(2);
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_FIRSTNAME"), PropertiesFile.getPropValue("PRD_DATA_FIRSTNAME"));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_LASTNAME"), PropertiesFile.getPropValue("PRD_DATA_LASTNAME"));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_EMAIL"), PropertiesFile.getPropValue("PRD_DATA_EMAIL"));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_STREET"), PropertiesFile.getPropValue("PRD_DATA_STREET"));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_CODE"), PropertiesFile.getPropValue("PRD_DATA_CODE"));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_CITY"), PropertiesFile.getPropValue("PRD_DATA_CITY"));

//        keyword.recaptchaClick();
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("PRD_CHECK"));
//        keyword.click(PropertiesFile.getPropValue("PRD_BTN_SUBMIT"));

    }
    public void optionDimensionGuide() throws InterruptedException {
        setUp();
        Thread.sleep(3000);
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_PRODUCT_DETAIL"));
        keyword.imWait(2);
        keyword.click(PropertiesFile.getPropValue("PRD_DROPDOWN"));
        keyword.imWait(2);
        System.out.printf("done" +"\n");
        keyword.click(PropertiesFile.getPropValue("PRD_OPTION_SIZE"));
        keyword.imWait(2);
        keyword.click(PropertiesFile.getPropValue("PRD_FINDSIZE"));
        keyword.imWait(2);
        keyword.clickByCss(PropertiesFile.getPropValue("PRD_LINK_SIZEGUIDE"));

    }
    public void optionFreeSize(){
        keyword.click(PropertiesFile.getPropValue("PRD_DROPDOWN"));
        keyword.click(PropertiesFile.getPropValue("PRD_OPTION_SIZE"));
        keyword.click(PropertiesFile.getPropValue("PRD_FREESIZE"));

    }

}
