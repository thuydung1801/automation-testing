package autoframework.steps.serenity;

import autoframework.pages.DictionaryPage;

public class EndUserSteps {

    DictionaryPage dictionaryPage;

    public void gotoUrl(String url) {
        dictionaryPage.gotoUrl(url);
    }


    public void clickSignUpbtn(){
        dictionaryPage.clickSignUpBtn();
    }
    public void successfully(String expectUrl) throws InterruptedException {
        dictionaryPage.checkURl(expectUrl);
    }
    public void insertEmail(String email) throws InterruptedException {
        dictionaryPage.insertEmail(email);
    }
    public void insertFirstName(String firstName) {
        dictionaryPage.insertFirstName(firstName);
    }
    public void insertLastName(String lastName) {
        dictionaryPage.insertLastName(lastName);
    }
    public void insertEmailConfirm(String emailConfirm) {
        dictionaryPage.insertEmailConfirm(emailConfirm);
    }
    public void insertPass(String pass) {
        dictionaryPage.insertPass(pass);
    }
    public void insertPassConfirm(String passConfirm) {
        dictionaryPage.insertPassConfirm(passConfirm);
    }
    public void insertSearch(String key) throws InterruptedException {
        dictionaryPage.insertSearch(key);
    }

    public void insertKey(String key) throws InterruptedException {
        dictionaryPage.insertKey(key);
    }
    // click button
    public void clickAcceptBtn(){
        dictionaryPage.AcceptBtn();
    }
    public void clickSubmitBtn() throws InterruptedException {
        dictionaryPage.SubmitBtn();
    }
    public void clickForgotPassBtn(){dictionaryPage.forgotPassBtn();}
    public void clickResetMyPassBtn() throws InterruptedException {dictionaryPage.resetMyPassBtn();}
    public void clickGoBackBtn() throws InterruptedException {dictionaryPage.goBackBtn();}

    public void clickSearchBtn() throws InterruptedException {dictionaryPage.searchBtn();}

    //Get Messages
    // register fail
    public void getMsgError(String msgError){
        dictionaryPage.getMsgError_fail(msgError);
    }
    //  leave all blank
    public void getMsgError_all_blank(String msgError){
        dictionaryPage.getMsgError_all_blank(msgError);
    }
    public void getMsgError_acceptBtn(String msgError){
        dictionaryPage.getMsgError_acceptBtn(msgError);
    }
    public void getMsgSuc_forgotPass(String msgSuc){
        dictionaryPage.getMsgSuc_forgotPass(msgSuc);
    }
    public void getMsg_Search(String msgSearch){
        dictionaryPage.getMsg_Search(msgSearch);
    }

    public void getLink_Search(String linkSearch){
        dictionaryPage.getLink_Search(linkSearch);
    }

    //https://test.glamira2.just4demo.biz/glgb/catalogsearch/result/?q=neck
}