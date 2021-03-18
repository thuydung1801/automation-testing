package autoframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class CheckOutPage extends BasePage {


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
