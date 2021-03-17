package autoTest.steps;

import autoTest.steps.serenity.CheckoutEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class CheckoutStepdefs {

    @Steps
    CheckoutEndUserSteps checkoutEndUserSteps;
    @And("^input \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void input(String firstname, String lastname, String email, String streetAddress, String country, String city, String zipCode, String phoneNumber) throws Throwable {
        checkoutEndUserSteps.inputInfo(firstname, lastname, email, streetAddress, country, city, zipCode, phoneNumber);
    }


    @And("^Click on freeStandardDelivery then click nextBtn$")
    public void clickOnFreeStandardDeliveryThenClickNextBtn() {
        checkoutEndUserSteps.clickOnFreeStandardDeliveryThenClickNextBtn();
    }

    @And("^Choose credit card and input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" then click on pla order button$")
    public void chooseCreditCardAndInputThenClickOnPlaOrderButton(String creditNum, String expiryDate, String CVC, String holderName) throws Throwable {
        checkoutEndUserSteps.chooseCreditCardAndInputThenClickOnPlaOrderButton(creditNum, expiryDate, CVC, holderName);
    }

    @And("^Choose Bank Transfer$")
    public void chooseBankTransfer() {
        checkoutEndUserSteps.chooseBankTransfer();
    }

    @And("^Agree Temrs-conditions and click Place order$")
    public void agreeTemrsConditionsAndClickPlaceOrder() {
        checkoutEndUserSteps.agreeTemrsConditionsAndClickPlaceOrder();
    }

    @Then("^The order place successfully$")
    public void theOrderPlaceSuccessfully() {
        checkoutEndUserSteps.theOrderPlaceSuccessfully();
    }
}
