package autoframework.steps;

import autoframework.pages.SearchProductsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchProductsStep {
    @Steps
    SearchProductsPage nia;
    @When("Insert key to block Search : (.*)")
    public void insertKeySearch(String key) throws InterruptedException {
        System.out.println(" Insert key :"+ key);
        nia.insertSearch(key);
    }
    @When("Insert key to block Search and press down 4 time : (.*)")
    public void insertKey(String key) throws InterruptedException {
        System.out.println(" Insert key :"+ key);
        nia.insertKey(key);
    }
    @When("click search button")
    public void clickSearchBtn() throws InterruptedException {
        System.out.println("Click Search Button");
        nia.searchBtn();
    }
    @Then("Show messages for search: (.*)")
    public void getMsg_Search(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsg_Search(expectMsg);
    }
    @Then("Go to link: HOME /(.*)")
    public void getLk_Search(String expectLk){
        System.out.println("Go to link: HOME / " + expectLk );
        nia.getLink_Search(expectLk);
    }
}
