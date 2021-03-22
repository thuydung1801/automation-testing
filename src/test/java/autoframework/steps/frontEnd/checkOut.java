package autoframework.steps.frontEnd;


import autoframework.pages.frontEnd.CheckOutPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class checkOut {
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
// ---Lan's code----
    @And("^input \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void input(String firstname, String lastname, String email, String streetAddress, String country, String city, String zipCode, String phoneNumber) throws Throwable {
        nia.inputInfo(firstname, lastname, email, streetAddress, country, city, zipCode, phoneNumber);
    }


    @And("^Click on freeStandardDelivery then click nextBtn$")
    public void clickOnFreeStandardDeliveryThenClickNextBtn() {
        nia.clickOnFreeStandardDeliveryThenClickNextBtn();
    }

    @And("^Choose credit card and input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" then click on pla order button$")
    public void chooseCreditCardAndInputThenClickOnPlaOrderButton(String creditNum, String expiryDate, String CVC, String holderName) throws Throwable {
        nia.chooseCreditCardAndInputThenClickOnPlaOrderButton(creditNum, expiryDate, CVC, holderName);
    }

    @And("^Choose Bank Transfer$")
    public void chooseBankTransfer() {
        nia.chooseBankTransfer();
    }

    @And("^Agree Temrs-conditions and click Place order$")
    public void agreeTemrsConditionsAndClickPlaceOrder() {
        nia.agreeTemrsConditionsAndClickPlaceOrder();
    }

    @Then("^The order place successfully$")
    public void theOrderPlaceSuccessfully() {
        nia.theOrderPlaceSuccessfully();
    }
}






