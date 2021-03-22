package autoframework.pages.frontEnd;

import autoframework.pages.CommonPage;
import autoframework.service.TestDataService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPages extends CommonPage {

    private final String css_signInButton = "div.header-panel-right li.authorization-link";
    private final String css_emailTextBox = "input#email";
    private final String css_passwordTextBox = "input#pass";
    private final String css_buttonLogin = "button#send2";
    private final String Myaccount = "div[class='block account-nav']";

    public void clickOnSignInButton() {
        getDriver().findElement(By.cssSelector(css_signInButton)).click();
    }

    public void login(String userName, String password) {
        WebElement texBoxEmail = getDriver().findElement(By.cssSelector(css_emailTextBox));
        WebElement textBoxPassWord = getDriver().findElement(By.cssSelector(css_passwordTextBox));
        WebElement buttonLogin = getDriver().findElement(By.cssSelector(css_buttonLogin));

        texBoxEmail.sendKeys(userName);
        textBoxPassWord.sendKeys(password);
        buttonLogin.click();
    }

    public void login(String isValid) {
        String email;
        String password;

        if (isValid.equalsIgnoreCase("valid")) {
            email = TestDataService.properties.getProperty("lanEmail");
            password = TestDataService.properties.getProperty("lanPassword");
        } else {
            email = TestDataService.properties.getProperty("lanWrongEmail");
            password = TestDataService.properties.getProperty("lanWrongPassword");
        }

        this.login(email, password);
    }

    public boolean isOnPage() {
        try {
            return getDriver().findElement(By.cssSelector(Myaccount)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
//    ---------LAN'S CODE----------
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



    public void loginAdminPageWithAnd(String adminPage, String username, String pass) {
        gotoUrl(adminPage);
        insertIntoField(username,userNameLocator);
        insertIntoField(pass,passwordLocator);
        click(loginBtnLocator);

    }
}




