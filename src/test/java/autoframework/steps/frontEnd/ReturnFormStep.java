package autoframework.steps.frontEnd;

import autoframework.pages.frontEnd.ReturnFormPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReturnFormStep {
    ReturnFormPage nia;

    @When("Click button Submit return form")
    public void clickSubmitReturn() {
        nia.clickSubmitReturn();
    }

    @Then("show message for al blank (.*)")
    public void showAllmsgForReturn(String msg) {
        nia.getMsgError_all_blank_return_form(msg);

    }

    @Then("Show error message for email blank: (.*)")
    public void showErrorMessageForEmailBlank(String msg) {
        nia.showErrorMessageForEmailBlank(msg);
    }


}

