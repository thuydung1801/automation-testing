package autoframework.steps;


import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import autoframework.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps nia;

    @Given("^Go to '(.*)' url$")
    public void goToUrl(String url) {
        System.out.println("go to the " + url);
        nia.gotoUrl(url);
    }
    @When("Click Sign In/ Sign Up button")
    public void signUpBtn(){
        System.out.println("Click Sign up Button");
        nia.clickSignUpbtn();
    }
    @When("Insert first name: '(.*)'")
    public void insertFirstName(String firstName) {
        System.out.println(" Insert first name");
        nia.insertFirstName(firstName);
    }
    @When("Insert last name: '(.*)'")
    public void insertLastName(String lastName) {
        System.out.println(" Insert last name");
        nia.insertLastName(lastName);
    }
    @When("Insert email: '(.*)'")
    public void insertEmail(String email) throws InterruptedException {
        System.out.println(" Insert email");
        nia.insertEmail(email);
    }
    @When("Insert Confirm E-mail Address: '(.*)'" )
    public void insertEmailConfirm(String emailConfirm){
        System.out.println(" Insert email confirm");
        nia.insertEmailConfirm(emailConfirm);
    }
    @When("Insert password: '(.*)'")
    public void insertPass(String pass) throws InterruptedException {
        System.out.println(" Insert password");
        nia.insertPass(pass);
    }
    @When("Insert Confirm Password: '(.*)'")
    public void insertPassConfirm(String passConfirm) {
        System.out.println(" Insert confirm password");
        nia.insertPassConfirm(passConfirm);
    }
    @Then("^Show error-box$")
    public void error_box() throws Exception {
        System.out.println("login fail");
        //anna.getErrorMessage();
    }
    @When("Click accept button")
    public void clickBtn(){
        System.out.println("Click Accept Button");
        nia.clickAcceptBtn();
    }
    @When("Click Submit button")
    public void clickSubmitBtn() throws InterruptedException {
        System.out.println("Click Submit Button");
        nia.clickSubmitBtn();
    }

    @When("Click forgot Password button")
    public void clickForgotPassBtn(){
        System.out.println("Click Forgot Password Button");
        nia.clickForgotPassBtn();
    }
    @When("Click Reset My Password button")
    public void clickResetMyPassBtn() throws InterruptedException {
        System.out.println("Click Reset my Password Button");
        nia.clickResetMyPassBtn();
    }
    @When("Click Go Back button")
    public void clickGoBackBtn() throws InterruptedException {
        System.out.println("Click Go Back Button");
        nia.clickGoBackBtn();
    }
    @When("Insert key to block Search : '(.*)'")
    public void insertKeySearch(String key) throws InterruptedException {
            System.out.println(" Insert key :"+ key);
            nia.insertSearch(key);
            }

    @When("Insert key to block Search and press down 4 time : '(.*)'")
    public void insertKey(String key) throws InterruptedException {
        System.out.println(" Insert key :"+ key);
        nia.insertKey(key);
    }
    @When("click search button")
    public void clickSearchBtn() throws InterruptedException {
        System.out.println("Click Search Button");
        nia.clickSearchBtn();
    }
    @Then("Show Error Messages : '(.*)'")
    public void checkErrorMsg(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgError(expectMsg);
    }
    @Then("Show Error Messages under blank : '(.*)'")
    public void checkErrorMsg_firstName_blank(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgError_all_blank(expectMsg);
    }
    @Then("Show Error Messages under button : '(.*)'")
    public void getMsgError_acceptBtn(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgError_acceptBtn(expectMsg);
    }


    @Then("^Successfully into '(.*)' front site$")
    public void Successfully(String expectUrl) throws InterruptedException {
        System.out.println("Successfully");
            nia.successfully(expectUrl);
    }
    @Then("Show messages: '(.*)'")
    public void getMsgSuc_forgotPass(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgSuc_forgotPass(expectMsg);
    }
    @Then("Show messages for search: '(.*)'")
    public void getMsg_Search(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsg_Search(expectMsg);
    }
    @Then("Go to link: HOME /'(.*)'")
    public void getLk_Search(String expectLk){
        System.out.println("Go to link: HOME / " + expectLk );
        nia.getLink_Search(expectLk);
    }

}