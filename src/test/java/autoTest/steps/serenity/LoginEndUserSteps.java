package autoTest.steps.serenity;

import autoTest.pages.LoginPage;

public class LoginEndUserSteps {

    LoginPage loginPage;

    public void goToUrl(String url){
        loginPage.goToUrl(url);
    }

//    public void clickSigin(String signinBtn) {
//        demoPage.clickSigin(signinBtn);
//    }

    public void inputAccount(String email, String password) throws InterruptedException {
        loginPage.inputAccount(email, password);

    }


    public void showErrorMessage(String errorMessage) throws InterruptedException {
        loginPage.showErrorMessage(errorMessage);
    }

    public void click() {
        loginPage.clickOnSigin();

    }

    public void clickOnSiginButton() {
        loginPage.clickOnSiginBtn();
    }

    public void redirectToLink(String arg0) {
        loginPage.redirectToLink(arg0);
    }

    public void loginAdminPageWithAnd(String adminPage, String account, String password) {
        loginPage.loginAdminPageWithAnd(adminPage, account, password);
    }
}
