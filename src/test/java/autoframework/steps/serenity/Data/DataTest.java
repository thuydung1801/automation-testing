package autoframework.steps.serenity.Data;

import org.openqa.selenium.By;

public class DataTest {

    By firstNameInp = By.name("firstname");
    By lastNameInp = By.name("lastname");
    By emailInp = By.name("email");
    By emailConfirmInp = By.name("emailconfirm");
    By passwordInp = By.name("password");
    By passwordConfirmationInp = By.name("password_confirmation");
    By signUpBtn = By.cssSelector("[class='authorization-text']");
    By acceptBtn = By.name("is_subscribed");
    By submitBtn = By.className("submit");
    By msgError = By.className("message-error");
    By msgError_firstName_blank = By.id("firstname-error");
    By msgError_lastName_blank = By.id("lastname-error");
    By msgError_email_blank = By.id("email_address-error");
    By msgError_emailConfirm_blank = By.id("emailconfirm-error");
    By msgError_password_blank = By.id("password-error");
    By msgError_passwordConfirmation_blank = By.id("password-confirmation-error");
    By msgError_acceptBtn= By.id("advice-required-entry-agreement-6");
    By forgotPassBtn =  By.className("remind");
    By resetMyPassBtn = By.className("action submit primary");
}
