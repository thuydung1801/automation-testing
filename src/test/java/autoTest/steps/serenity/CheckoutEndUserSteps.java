package autoTest.steps.serenity;

import autoTest.pages.CheckoutPage;

public class CheckoutEndUserSteps {
    CheckoutPage checkoutPage;

    public void inputInfo(String firstname, String lastname, String email, String streetAddress, String country, String city, String zipCode, String phoneNumber) {
        checkoutPage.inputInfo(firstname, lastname, email, streetAddress, country, city, zipCode, phoneNumber);
    }

    public void clickOnFreeStandardDeliveryThenClickNextBtn() {
        checkoutPage.clickOnFreeStandardDeliveryThenClickNextBtn();
    }

    public void chooseCreditCardAndInputThenClickOnPlaOrderButton(String creditNum, String expiryDate, String cvc, String holderName) {
        checkoutPage.chooseCreditCardAndInputThenClickOnPlaOrderButton(creditNum, expiryDate, cvc, holderName);
    }

    public void chooseBankTransfer() {
        checkoutPage.chooseBankTransfer();
    }

    public void agreeTemrsConditionsAndClickPlaceOrder() {
        checkoutPage.agreeTemrsConditionsAndClickPlaceOrder();
    }

    public void theOrderPlaceSuccessfully() {
        checkoutPage.theOrderPlaceSuccessfully();
    }
}
