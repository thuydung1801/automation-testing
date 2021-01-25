package autoTest.steps.serenity;

import autoTest.pages.LoginPage;

public class LoginEndUserSteps {

    LoginPage demoPage;

    public void goToUrl(String url){
        demoPage.goToUrl(url);
    }

//    public void clickSigin(String signinBtn) {
//        demoPage.clickSigin(signinBtn);
//    }

    public void inputAccount(String email, String password) throws InterruptedException {
        demoPage.inputAccount(email, password);

    }


    public void showErrorMessage(String errorMessage) throws InterruptedException {
        demoPage.showErrorMessage(errorMessage);
    }
}
