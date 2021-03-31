package autoframework.pages.frontEnd;

import autoframework.pages.CommonPageL;

public class CheckoutPage extends CommonPageL {
    String firstnameLoacator = "div[name=\"shippingAddress.firstname\"] input";
    String lastnameLocator = "div[name=\"shippingAddress.lastname\"] input";
    String emailLoacator = "fieldset#customer-email-fieldset input#customer-email";
    String streetAddressLocator = "div[name=\"shippingAddress.street.0\"] input";
    String countryLocator = "div[name=\"shippingAddress.country_id\"] select";
    String cityLocator = "div[name=\"shippingAddress.city\"] input";
    String zipCodeLocator = "div[name=\"shippingAddress.postcode\"] input";
    String phoneNumLocator = "div[name=\"shippingAddress.telephone\"] input";
    String deliveryExpressLocator = "tbody>tr:nth-child(1) input.radio";
    String nextBtnLocator = "button.continue";
    String creditCardLocator = "div.payment-method:nth-child(4)>div>input";
    String cardNumberLocator = "#encryptedCardNumber";
    String expiryDateLocator = "input#encryptedExpiryDate";
    String cvcLocator = "input#encryptedSecurityCode";
    String holderNameLocator = "div.adyen-checkout__card__holderName input";
    String paymentAgreementLocator = "div.checkout-agreement input";
    String placeOrderBtnLocator = "button#place-order-trigger";
    String bankTransferMethodLocator = "#checkmo";
    String agreementLocator = "#agreement__6";
    String successPage = "https://test.glamira2.just4demo.biz/glgb/checkout/onepage/success/";


    public void inputInfo(String firstname, String lastname, String email, String streetAddress, String country, String city, String zipCode, String phoneNumber) {
        insertIntoField(firstname, firstnameLoacator);
        insertIntoField(lastname, lastnameLocator);
        insertIntoField(email, emailLoacator);
        insertIntoField(streetAddress, streetAddressLocator);
        insertIntoField(city, cityLocator);
        insertIntoField(zipCode, zipCodeLocator);
        insertIntoField(phoneNumber, phoneNumLocator);
        selectOption(countryLocator, country);
    }

    public void clickOnFreeStandardDeliveryThenClickNextBtn() {
        scrollToAndClick(deliveryExpressLocator);
        click(nextBtnLocator);
        waitAboutSecond(3);
    }

    public void chooseCreditCardAndInputThenClickOnPlaOrderButton(String creditNum, String expiryDate, String cvc, String holderName) {
        click(creditCardLocator);
        waitAboutSecond(5);
        insertIntoField(creditNum,cardNumberLocator);
        insertIntoField(expiryDate,expiryDateLocator);
        insertIntoField(cvc, cvcLocator);
        insertIntoField(holderName, holderNameLocator);
        click(paymentAgreementLocator);
        click(placeOrderBtnLocator);
    }

    public void chooseBankTransfer() {
        click(bankTransferMethodLocator);

    }

    public void agreeTemrsConditionsAndClickPlaceOrder() {
        click(agreementLocator);
        click(placeOrderBtnLocator);
    }

    public void theOrderPlaceSuccessfully() {
        waitAboutSecond(10);
        redirectToLink(successPage);
    }
}
