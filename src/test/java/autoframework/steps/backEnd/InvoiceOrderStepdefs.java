package autoframework.steps.backEnd;
import autoframework.pages.backEnd.InvoiceOrderPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class InvoiceOrderStepdefs {
    @Steps
    InvoiceOrderPages invoiceorderPages;


    @Given("^I click in Sales menu$")
    public void iClickInSalesMenu() {
        invoiceorderPages.salemenu();
    }

    @When("^I click in Order grid$")
    public void iClickInOrderGrid() {

        invoiceorderPages.Ordergrid();
    }

//    @And("^I enter order in the search box$")
//    public void iClickToSearchBox() {
//        invoiceorderPages.SearchBox();
//    }

    @And("^Click in 'view' item$")
    public void clickInViewItem() {
        invoiceorderPages.ViewItem();
    }

    @And("^Click in Invoice Order button$")
    public void clickInInvoiceOrderButton() {
        invoiceorderPages.InvoiceOrder();
    }

    @And("^Click in Submit Invoice$")
    public void clickInSubmitInvoice() {

        invoiceorderPages.SubmitInvoice();
    }

    @And("^the success message screen appears \"([^\"]*)\"$")
    public void theSuccessMessageScreenAppears(String text)  {
        invoiceorderPages.successmessage(text);
    }

    @When("^I click in Order item grid$")
    public void iClickInOrderItemGrid() {
        invoiceorderPages.OrderItemGrid();
    }

    @And("^I enter \"([^\"]*)\" in the search box$")
    public void iEnterInTheSearchBox(String orderid)  {
        invoiceorderPages.SearchBox(orderid);
    }

    @And("^I search \"([^\"]*)\" in the order box$")
    public void iSearchInTheOrderBox(String orderid)  {
        invoiceorderPages.enteridoforder(orderid);
    }
    @And("^column Is Requested To Process of record must have the status yes$")
    public void columnIsRequestedToProcessOfRecordMustHaveTheStatusYes() {
        invoiceorderPages.IsRequestedToProcessOfRecord();

    }

    @And("^I Click in Check box of order$")
    public void iClickInCheckBoxOfOrder() {
        invoiceorderPages.ChooseOrder();

    }
    @And("^Choose action Request To Process$")
    public void chooseActionRequestToProcess() {
        invoiceorderPages.ActionRequestToProcess();

    }

    @And("^Click submit button$")
    public void clickSubmitButton() {
        invoiceorderPages.clickSubmitButton();
    }

    @Then("^After click submit button The screen display shows the message \"([^\"]*)\"$")
    public void afterClickSubmitButtonTheScreenDisplayShowsTheMessage(String text)  {

        invoiceorderPages.TheScreenDisplayShowsTheMessage(text);
    }


//    @And("^if column Is Requested To Process of record has a state (NO|YES)$")
//    public void ifColumnIsRequestedToProcessOfRecordHasAStateNO() {
//        invoiceorderPages.ClickSubmitButton();

//    }



}

