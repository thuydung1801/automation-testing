package autoframework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class AddToCartPage extends BasePage{

    By addBtn = By.id("product-addtocart-button");
    By countItem = By.className("counter-number");
    By selectSz = By.cssSelector(".product-custom-option.required");
    By msgErr = By.cssSelector("div[id*='-error']");

    public void clickItemHasText(String name){
            //to catch all web elements into list
        List<WebElement> list=getDriver().findElements(By.className("product-item-link"));
        //if you want to get all elements text into array list
        List<String> all_elements_text=new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            //loading text of each element in to array all_elements_text
            all_elements_text.add(list.get(i).getText());
            //to print directly
            System.out.println(list.get(i).getText());
        }
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getText().equalsIgnoreCase(name) ){
                System.out.println("Click san pham nay: " + list.get(i).getText());
                list.get(i).click();
                break;
            }
        }
    }
    public void choseSz(String size){
        Select select = new Select(getDriver().findElement(selectSz));
        select.selectByValue(size);
    }
    public void clickAddBtn(){
        getDriver().findElement(addBtn).click();
    }
    public void showMsgErr(String expectMsg){

        Assert.assertEquals(expectMsg,getDriver().findElement(msgErr).getText());

    }
    public void  count(){
        getDriver().findElement(countItem).getText();
        System.out.println("Số lượng: "+getDriver().findElement(countItem).getText());
    }
}
