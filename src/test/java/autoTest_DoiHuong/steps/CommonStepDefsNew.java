package autoTest_DoiHuong.steps;
import autoTest_DoiHuong.Entity.OrderInfo;
import autoTest_DoiHuong.Utils.Vars;
import autoTest_DoiHuong.pages.CommonPages;
import autoTest_DoiHuong.pages.ManageStonePages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;


public class CommonStepDefsNew {
    @Steps
    CommonPages commonPages;

    @Steps
    ManageStonePages manageStonePages;

    @Given("^Go to \"([^\"]*)\" url$")
        public void goToUrl(String urlName) throws InterruptedException{
            commonPages.goToUrl(urlName);}

    @Given("^go to the admin \"([^\"]*)\"$")
    public void goToTheAdmin(String url) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        commonPages.goToUrl(url);
    }

//    @And("^I test dependency injection$")
//    public void iTestDependencyInjection() {
//        OrderInfo orderInfo = ((OrderInfo) Vars.get("order1"));
//        System.out.println(orderInfo.getCertificate());
//        System.out.println(orderInfo.getClarity());
//    }

    @And("^I filter stone with var name \"([^\"]*)\"$")
    public void  filterStone(String varName) throws InterruptedException {
        OrderInfo orderInfo = ((OrderInfo) Vars.get(varName));
        manageStonePages.resetFilter();
        manageStonePages.selectCertificate(orderInfo.getCertificate());
        manageStonePages.selectClarity(orderInfo.getClarity());
        manageStonePages.selectType(orderInfo.getType());
    }
}
