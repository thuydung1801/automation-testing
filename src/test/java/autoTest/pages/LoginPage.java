package autoTest.pages;


public class LoginPage extends CommonPage {

//    @FindBy(linkText = "Signin")
//    WebElementFacade signInBtn;

    public void goToUrl(String url){
        getDriver().get(url);
    }

//    public void clickSigin(String signinBtn) {
//        WebElement signInBtn = getDriver().findElement(By.linkText(signinBtn));
//        signInBtn.click();
//
//    }
    String signin = "div.accountLinks";
    String emailField = "input#email";
    String passwordField= "input#pass";
    String signinBtn = "button#send2";
    String errorMessage = "div.account-login>ul.messages span";
    String userNameLocator = "#username";
    String passwordLocator = "#login";
    String loginBtnLocator = "button.action-login";





    public void inputAccount(String email, String password) throws InterruptedException{


        insertIntoField(email, emailField);
        insertIntoField(password, passwordField);


    }

    public void showErrorMessage(String message) throws InterruptedException {
        assertMsg(message, errorMessage);


    }

    public void clickOnSigin() {
        click(signin);
    }

    public void clickOnSiginBtn() {
        click(signinBtn);
    }

    public void loginAdminPageWithAnd(String adminPage, String account, String password) {
        gotoUrl(adminPage);
        insertIntoField(account,userNameLocator);
        insertIntoField(password,passwordLocator);
        click(loginBtnLocator);

    }
}
