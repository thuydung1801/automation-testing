package autoframework.steps.backEnd;

import autoframework.pages.backEnd.PackageReadyShippingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PackageReadyShippingSteps {
    PackageReadyShippingPage nia =  new PackageReadyShippingPage();
    @When("Choose item have row in Package Ready Shipping Page :(.*)")
    public void chooseRow(int numberOfRow){
        nia.chooseRow(numberOfRow);
    }
    @And("Click button to create ship")
    public void clickAcceptBtn(){
        nia.clickAcceptBtn();
    }
    @And("Click button to cancel ship")
    public void clickCancelBtn(){
        nia.clickCancelBtn();
    }
    @Then("^The system show success message$")
    public void theSystemShowSuccessMessage() {

    }
}
