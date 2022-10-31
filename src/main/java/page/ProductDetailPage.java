package page;

import core.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.WeakHashMap;


public class ProductDetailPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public ProductDetailPage() {
        super();
    }
    public ProductDetailPage(KeywordWeb key){
        super(key);
    }
    public void selectOption() throws InterruptedException {
        Thread.sleep(100);
        ArrayList<String> arr = new ArrayList<>();
        arr.add(PropertiesFile.getPropValue("PRD_STONE2"));
        arr.add(PropertiesFile.getPropValue("PRD_METAL_ALLOY"));
        arr.add(PropertiesFile.getPropValue("PRD_ENGRAVING"));

        for(String option : arr){
            if(option != arr.get(arr.size()-1)){
                keyword.clickByXpath(option);
            }
            else{
                keyword.clickByXpath(option);
                keyword.clickByCss(PropertiesFile.getPropValue("PRD_TEXT_ENGRAVING"));
                keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_ENGRAVING"), PropertiesFile.getPropValue("PRD_DATA_TEXT_ENGRAVING"));

            }

        }

    }
    public void clickDropdown() throws InterruptedException {
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_DROPDOWN"));
        Thread.sleep(1000);
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_CLICK_OPTIONE_SiZE"));
    }
    public void clickAddCart() throws InterruptedException {
        Thread.sleep(500);
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_BTN_ADDCART"));
        Thread.sleep(100);
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_CART"));
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_BTN_VIEWCART"));
        Thread.sleep(100);
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_BTN_VIEWDETAIL"));

        System.out.printf("check engravingText : " );
        keyword.getText(PropertiesFile.getPropValue("PRD_GET_TEXT_ENGRAVING"));


    }
    public void submitCookie(){
        logger.info("click accept cookie : " );
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("PRD_BTN_ACCEPT_COOKIE"), 50);
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_BTN_ACCEPT_COOKIE"));
       // driver.findElement(By.cssSelector(PropertiesFile.getPropValue("PRD_BTN_ACCEPT_COOKIE"))).click();
    }
    public void productInfo() throws InterruptedException {


        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_PRODUCT_INFO"));
        Thread.sleep(5000);
        keyword.submitCookie();

        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_CLICK_PRODUCT"));

        System.out.printf("-----test 1: Show  detail image" +"\n");
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_SHOW_IMG"));
        Thread.sleep(500);
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_CLOSE"));
        System.out.printf("=> test 1 done"+"\n");

        System.out.printf("-----test 2: Default option "+"\n");
        keyword.submitAllow();
        selectOption();
        System.out.printf("=> test 2 done"+"\n");

        System.out.printf("------test 2.1: Dropdown"+"\n");
        Thread.sleep(1000);
        clickDropdown();
        System.out.printf("=> test 2.1 done"+"\n");

        System.out.printf("------test 2.2: Add to cart"+"\n");
        clickAddCart();
        System.out.printf("=>test 2.2 done"+"\n");

        System.out.printf("---------test 3: Quantity option for earring men" +"\n");
        keyword.openNewTab(PropertiesFile.getPropValue("URL_PRODUCT_DETAIL"));
        optionFreeSize();
        System.out.printf("=> test 3 done");


    }
    public void optionFindSize() throws InterruptedException  {
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_PRODUCT_DETAIL"));
        Thread.sleep(600);
        keyword.submitCookie();
        keyword.scrollToPosition();
        keyword.submitAllow();
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_DROPDOWN"));
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_OPTION_SIZE"));
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_FINDSIZE"));

        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_FIRSTNAME"), PropertiesFile.getPropValue("PRD_DATA_FIRSTNAME"));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_LASTNAME"), PropertiesFile.getPropValue("PRD_DATA_LASTNAME"));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_EMAIL"), PropertiesFile.getPropValue("PRD_DATA_EMAIL"));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_STREET"), PropertiesFile.getPropValue("PRD_DATA_STREET"));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_CODE"), PropertiesFile.getPropValue("PRD_DATA_CODE"));
        keyword.sendKeys(PropertiesFile.getPropValue("PRD_TEXT_CITY"), PropertiesFile.getPropValue("PRD_DATA_CITY"));
        Thread.sleep(200);

        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_CHECK"));
//        keyword.clickByCss(PropertiesFile.getPropValue("PRD_BTN_SUBMIT"));

    }
    public void optionDimensionGuide() throws InterruptedException {
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_PRODUCT_DETAIL"));
Thread.sleep(20000);
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_DROPDOWN"));
        keyword.submitAllow();
        keyword.submitCookie();
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_DROPDOWN"));
        System.out.printf("done" +"\n");
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_OPTION_SIZE"));
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_FINDSIZE"));
        keyword.clickByCss(PropertiesFile.getPropValue("PRD_LINK_SIZEGUIDE"));

    }
    public void optionFreeSize(){
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_DROPDOWN"));
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_OPTION_SIZE"));
        keyword.clickByXpath(PropertiesFile.getPropValue("PRD_FREESIZE"));

    }

}
