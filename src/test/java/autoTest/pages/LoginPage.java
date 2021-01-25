package autoTest.pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginPage extends PageObject {

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

    public void inputAccount(String email, String password) throws InterruptedException{

        Thread.sleep(3000);
        WebElement emailTxt = getDriver().findElement(By.id("email"));
        WebElement passwordTxt = getDriver().findElement(By.id("pass"));
        WebElement loginBtn = getDriver().findElement(By.cssSelector("div.account-login-form span span"));
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        loginBtn.click();


    }

    public void showErrorMessage(String errorMessage) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(errorMessage, getDriver().findElement(By.cssSelector("div.account-login ul.messages span")).getText());
        //WebElement errorMessage = getDriver().findElement(By.cssSelector("div.account-login ul.messages span"));

        //return errorMessage;

    }
}
