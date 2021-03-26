package autoframework.pages.frontEnd;

import autoframework.pages.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends CommonPage {


    By logInBtn = By.id("send2");
    By cartBtn = By.className("move-minicart");
    By checkOutBtn = By.className("checkout-methods-items");
    By countryList = By.cssSelector("[name^='country_id'");
    By tax = By.cssSelector(".totals-tax");
    By totalTax = By.cssSelector(".sub");
    public void logIn(){
        getDriver().findElement(logInBtn).click();
    }
    public void goToCart() {
        getDriver().findElement(cartBtn).click();
    }
    public void checkOut(){
        getDriver().findElement(checkOutBtn).click();
    }
    public void clickCountry(String name){
        Select select = new Select(getDriver().findElement(countryList));
        select.selectByVisibleText(name);
    }
    public void showTax() {
        getDriver().findElement(By.id("block-shipping")).click();
    }
     public void getTax() {
         System.out.println(getDriver().findElement(tax).getText());
     }
    public void getTotal() {
        System.out.println(getDriver().findElement(totalTax).getText());
    }

}
