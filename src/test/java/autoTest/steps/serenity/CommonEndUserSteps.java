package autoTest.steps.serenity;
import autoTest.service.TestDataService;
import autoTest.pages.CommonPage;

public class CommonEndUserSteps {
    CommonPage commonPage;



    public void clickSigin(String signinBtn) {
        commonPage.click(signinBtn);
    }

    public void goToUrl(String url) {
        commonPage.gotoUrl(url);
    }


    public void input(String arg0, String arg1) {
        commonPage.insertIntoField(arg0, arg1);
    }

    public void assertMsg(String arg0, String arg1) throws Throwable{
        commonPage.waitAboutSecond(10);
        commonPage.assertMsg(arg1, arg0);
    }

    public void redirectTo(String arg) {
        commonPage.redirectToLink(arg);
    }

    public void selectOption(String arg0, String arg1) {
        commonPage.clickButton(arg0);
        commonPage.scrollToAndClick(arg1);
    }

    public void validateInformation(String arg0, String arg1) {
        commonPage.validateInformation(arg0, arg1);
    }
}
