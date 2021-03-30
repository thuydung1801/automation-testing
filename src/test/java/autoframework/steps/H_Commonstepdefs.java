package autoframework.steps;

import autoframework.Entity.OrderInfo;
import autoframework.Utils.Vars;
import autoframework.pages.H_CommonPages;
import autoframework.pages.backEnd.ManageStonePages;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class H_Commonstepdefs {

    @Steps
    H_CommonPages commonPagesH;

    @Steps
    ManageStonePages manageStonePages;


    @Given("^Go to the \"([^\"]*)\" url$")
    public void goToTheUrl(String urlName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonPagesH.goTotheUrl(urlName);
    }

    @Given("^go to the admin \"([^\"]*)\"$")
    public void goToTheAdmin(String url) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        commonPagesH.goTotheUrl(url);
    }

    @And("^I filter stone with var name \"([^\"]*)\"$")
    public void  filterStone(String varName) throws InterruptedException {
        OrderInfo orderInfo = ((OrderInfo) Vars.get(varName));
        manageStonePages.resetFilter();
        manageStonePages.selectCertificate(orderInfo.getCertificate());
        manageStonePages.selectClarity(orderInfo.getClarity());
        manageStonePages.selectType(orderInfo.getType());
    }

}