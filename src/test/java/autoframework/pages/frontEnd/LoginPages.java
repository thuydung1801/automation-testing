package autoframework.pages.frontEnd;

import autoframework.pages.H_CommonPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static autoframework.service.TestDataService.properties;

public class LoginPages extends H_CommonPages{
    private final String css_signInButton = "div.header-panel-right li.authorization-link";
    private final String css_emailTextBox = "input#email";
    private final String css_passwordTextBox = "input#pass";
    private final String css_buttonLogin = "button#send2";
    private final String Myaccount = "div[id=\"account-nav block-collapsible-nav\"]";

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
            email = properties.getProperty("email");
            password = properties.getProperty("Hpassword");
        } else {
            email = properties.getProperty("wrongEmail");
            password = properties.getProperty("wrongPassword");
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
}
