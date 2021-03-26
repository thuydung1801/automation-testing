package autoframework.pages.frontEnd;

import autoframework.pages.CommonPage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegisterAccPage extends CommonPage {

    By signUpBtn = By.className("authorization-text");
    By acceptBtn = By.name("is_subscribed");
    By submitBtn = By.className("submit");
    By msgError = By.className("message-error");
    By msgError_firstName_blank = By.id("firstname-error");
    By msgError_lastName_blank = By.id("lastname-error");
    By msgError_email_blank = By.id("email_address-error");
    By msgError_emailConfirm_blank = By.id("emailconfirm-error");
    By msgError_password_blank = By.id("password-error");
    By msgError_passwordConfirmation_blank = By.id("password-confirmation-error");
    By msgError_acceptBtn= By.id("is_subscribed-error");


    // Click button
    public void clickSignUpBtn(){
        getDriver().findElement(signUpBtn).click();
    }
    public void AcceptBtn(){
        getDriver().findElement(acceptBtn).click();
    }
    public void SubmitBtn()  {
        getDriver().findElement(submitBtn).click();
    }
    // register fail
    public void getMsgError_fail(String expectMsgError){
        Assert.assertEquals(expectMsgError,getDriver().findElement(msgError).getText());
    }
    // all blank
    public void getMsgError_all_blank(String expectMsgError){
        Assert.assertEquals(expectMsgError,getDriver().findElement(msgError_firstName_blank).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(msgError_lastName_blank).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(msgError_email_blank).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(msgError_emailConfirm_blank).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(msgError_password_blank).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(msgError_passwordConfirmation_blank).getText());

    }
    // do not click accept button
    public void getMsgError_acceptBtn(String expectMsgError){
        Assert.assertEquals(expectMsgError,getDriver().findElement(msgError_acceptBtn).getText());
    }
}
