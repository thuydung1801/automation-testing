package autoframework.pages.frontEnd;

import autoframework.pages.CommonPage;
import autoframework.service.TestDataService;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchProductsPage extends CommonPage {
    By searchInp = By.id("search");
    By searchBtn =  By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button");
    By msgError_search = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[2]");
    By linkResult = By.xpath("//*[@id=\"mm-0\"]/div[5]/div[3]/ul/li[2]/strong");
    By listBox = By.id("autocomplete-product");

    public void insertSearch(String key) {

        String insertKey = TestDataService.properties.getProperty(key);
        if (insertKey == null) {
            insertKey = key;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("insert" + insertKey + "into search box");
        getDriver().findElement(searchInp).sendKeys(insertKey);
    }
    public void insertKeyAndPress4Times(String key) throws InterruptedException {
        String insertKey = TestDataService.properties.getProperty(key);
        if (insertKey == null) {
            insertKey = key;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("insert" + insertKey + "into search box");
        getDriver().findElement(searchInp).sendKeys(key);
        Thread.sleep(10000);
        getDriver().findElement(listBox).sendKeys(Keys.DOWN, Keys.DOWN , Keys.DOWN,Keys.DOWN, Keys.RETURN);
    }
    public void searchBtn() throws InterruptedException {
        getDriver().findElement(searchBtn).click();
        Thread.sleep(10000);
    }
    public void getMsg_Search(String expectMsg){
        Assert.assertEquals(expectMsg,getDriver().findElement(msgError_search).getText());
    }
    public void getLink_Search(String expectLk){

        String expectLink = TestDataService.properties.getProperty(expectLk);
        if (expectLink == null) {
            expectLink = expectLk;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expectLink,getDriver().findElement(linkResult).getText());
        System.out.println("Go to link: HOME / " + expectLink );
    }

}
