package autoframework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchProductsPage extends CommonPage {
    By searchInp = By.id("search");
    By searchBtn =  By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button");
    By msgError_search = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[2]");
    By linkResult = By.xpath("//*[@id=\"mm-0\"]/div[3]/div[3]/ul/li[2]");
    By listBox = By.id("autocomplete-product");

    public void insertSearch(String key) {
        getDriver().findElement(searchInp).sendKeys(key);
    }
    public void insertKey(String key) throws InterruptedException {
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
        Assert.assertEquals(expectLk,getDriver().findElement(linkResult).getText());
    }

}
