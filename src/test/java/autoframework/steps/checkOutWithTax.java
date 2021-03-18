package autoframework.steps;


import autoframework.pages.CheckOutPage;
import org.openqa.selenium.By;
//import org.testng.annotations.BeforeMethod;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class checkOutWithTax {
    CheckOutPage nia ;

    @And ("Click button Sign In")
    public void clickLogIn() {
        nia.logIn();
    }
    @When("Go to Cart")
    public void goToCart(){
        nia.goToCart();
    }
    @When("Click Check out button")
    public void checkOut(){
        nia.checkOut();
 }
    @When("I click country: (.*)")
    public void clickCountry(String name) {
        nia.clickCountry(name);
    }
    @When("Show Tax")
    public void showTax(){
        nia.showTax();
    }
    @Then("Show Bill")
    public void showBill(){
        nia.getTax();
        nia.getTotal();
    }

}





