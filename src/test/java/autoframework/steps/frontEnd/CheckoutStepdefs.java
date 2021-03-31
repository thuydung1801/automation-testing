package autoframework.steps.frontEnd;

import autoframework.pages.frontEnd.CheckoutPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class CheckoutStepdefs {

    @Steps
    CheckoutPage checkoutPage;
    @And("^input \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void input(String firstname, String lastname, String email, String streetAddress, String country, String city, String zipCode, String phoneNumber) throws Throwable {
        checkoutPage.inputInfo(firstname, lastname, email, streetAddress, country, city, zipCode, phoneNumber);
    }


    @And("^Click on freeStandardDelivery then click nextBtn$")
    public void clickOnFreeStandardDeliveryThenClickNextBtn() {
        checkoutPage.clickOnFreeStandardDeliveryThenClickNextBtn();
    }

    @And("^Choose credit card and input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" then click on pla order button$")
    public void chooseCreditCardAndInputThenClickOnPlaOrderButton(String creditNum, String expiryDate, String CVC, String holderName) throws Throwable {
        checkoutPage.chooseCreditCardAndInputThenClickOnPlaOrderButton(creditNum, expiryDate, CVC, holderName);
    }

    @And("^Choose Bank Transfer$")
    public void chooseBankTransfer() {
        checkoutPage.chooseBankTransfer();
    }

    @And("^Agree Temrs-conditions and click Place order$")
    public void agreeTemrsConditionsAndClickPlaceOrder() {
        checkoutPage.agreeTemrsConditionsAndClickPlaceOrder();
    }

    @Then("^The order place successfully$")
    public void theOrderPlaceSuccessfully() {
        checkoutPage.theOrderPlaceSuccessfully();
    }
}
