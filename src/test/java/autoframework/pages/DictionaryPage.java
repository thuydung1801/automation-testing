package autoframework.pages;

import org.apache.tools.ant.taskdefs.Sleep;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import autoframework.steps.serenity.Data.DataTest;
import net.thucydides.core.pages.PageObject;


import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.Keys.DOWN;

public class DictionaryPage extends PageObject {
    public static WebDriver driver;
    private static WebElement element;
    DataTest data = new DataTest();

    By firstNameInp = By.name("firstname");
    By lastNameInp = By.name("lastname");
    By emailInp = By.name("email");// chung
    By emailConfirmInp = By.name("emailconfirm");
    By passwordInp = By.name("password");
    By passwordConfirmationInp = By.name("password_confirmation");
    By signUpBtn = By.cssSelector("[class='authorization-text']");
    By acceptBtn = By.name("is_subscribed");
    By submitBtn = By.className("submit");
    By msgError = By.className("message-error");// chung
    By msgError_firstName_blank = By.id("firstname-error");
    By msgError_lastName_blank = By.id("lastname-error");
    By msgError_email_blank = By.id("email_address-error");
    By msgError_emailConfirm_blank = By.id("emailconfirm-error");
    By msgError_password_blank = By.id("password-error");
    By msgError_passwordConfirmation_blank = By.id("password-confirmation-error");
    By msgError_acceptBtn= By.id("advice-required-entry-agreement-6");



    By forgotPassBtn =  By.className("remind");
    By resetMyPassBtn = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
    By goBackBtn = By.xpath("//*[@id=\"form-validate\"]/div/div[2]/a/span");
    By msg_forgotPass = By.id("contentarea");
    By searchInp = By.id("search");
    By searchBtn =  By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button");
    By msgError_search = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[2]");
    By linkResult = By.xpath("//*[@id=\"mm-0\"]/div[3]/div[3]/ul/li[2]");
    By listBox = By.id("autocomplete-product");


    public void gotoUrl(String url) {
        getDriver().get(url);
    }

    public void checkURl(String expectUrl) throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertEquals(expectUrl, getDriver().getCurrentUrl());
    }

    //insert
    public void insertEmail(String email) throws InterruptedException {
        Thread.sleep(1000);
        getDriver().findElement(emailInp).sendKeys(email);
    } // chung
    public void insertFirstName(String firstName) {
        getDriver().findElement(firstNameInp).sendKeys(firstName);
    }
    public void insertLastName(String lastName) {
        getDriver().findElement(lastNameInp).sendKeys(lastName);
    }
    public void insertEmailConfirm(String emailConfirm) {
        getDriver().findElement(emailConfirmInp).sendKeys(emailConfirm);
    }
    public void insertPass(String pass) {
        getDriver().findElement(passwordInp).sendKeys(pass);
    }
    public void insertPassConfirm(String passConfirm) {
        getDriver().findElement(passwordConfirmationInp).sendKeys(passConfirm);
    }




    public void insertSearch(String key) {
        getDriver().findElement(searchInp).sendKeys(key);
    }
    public void insertKey(String key) throws InterruptedException {
        getDriver().findElement(searchInp).sendKeys(key);
        Thread.sleep(10000);
        getDriver().findElement(listBox).sendKeys(Keys.DOWN, Keys.DOWN , Keys.DOWN,Keys.DOWN, Keys.RETURN);
    }


    // Click button
    public void clickSignUpBtn(){
        getDriver().findElement(signUpBtn).click();
    }
    public void AcceptBtn(){
        getDriver().findElement(acceptBtn).click();
    }
    public void SubmitBtn() throws InterruptedException {
        getDriver().findElement(submitBtn).click();
        Thread.sleep(1000);
    }
    public void forgotPassBtn(){getDriver().findElement(forgotPassBtn).click();}
    public void resetMyPassBtn() throws InterruptedException {
        getDriver().findElement(resetMyPassBtn).click();
        Thread.sleep(10000);
    }
    public void goBackBtn() throws InterruptedException {
        getDriver().findElement(goBackBtn).click();
        Thread.sleep(10000);
    }
    public void searchBtn() throws InterruptedException {
        getDriver().findElement(searchBtn).click();
        Thread.sleep(10000);
    }

    // get messages
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
    // reset Pass successfully\
    public void getMsgSuc_forgotPass(String expectMsg){
        Assert.assertEquals(expectMsg,getDriver().findElement(msg_forgotPass).getText());
    }
    public void getMsg_Search(String expectMsg){
        Assert.assertEquals(expectMsg,getDriver().findElement(msgError_search).getText());
    }
    public void getLink_Search(String expectLk){
        Assert.assertEquals(expectLk,getDriver().findElement(linkResult).getText());
    }


}




