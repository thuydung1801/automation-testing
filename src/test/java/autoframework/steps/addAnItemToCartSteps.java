package autoframework.steps;

import autoframework.pages.AddToCartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addAnItemToCartSteps {
    AddToCartPage nia;

    @When("I click item has name: (.*)")
    public void iClickItemHasText(String name) {
        nia.clickItemHasText(name);
    }
    @And("I add this item to cart")
    public void clickAddBtn(){nia.clickAddBtn();}
    @And("Chose ring size: (.*)")
    public void choseSz(String size){
        nia.choseSz(size);
    }
    @Then("Show message for ring size: (.*)")
    public void showMsg(String expectMsg){
        nia.showMsgErr(expectMsg);
    }
    @Then("the number of products in the shopping cart increases")
    public void countItem(){nia.count();}

}
