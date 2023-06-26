package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.ProductDetailPage;
import page.ReviewPage;
import page.checkout.ShoppingBagPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class ReviewTest extends BaseTest {
    private ReviewPage reviewPage ;


    private LoginPage objLogin;

    public SignInPage objSignIn;
    private RegisterPage objRegist;

    public ReviewTest() {
        super();
    }
    public void commonReview(String email, String password) throws InterruptedException {
        reviewPage = new ReviewPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
        Thread.sleep(5000);
        objRegist.acceptAllCookies();
        objLogin.loginOnWebsite(email,password, null,null, true);
        keyword.navigateToUrl("URL_REVIEW_ORDER");

    }
    @Test(priority = 1, description = "When \"ITEMS TO REVIEW\" tab doesn't have any item to review")
    public void testCase_MPR_05() throws InterruptedException {
        commonReview("LOGIN_DATA_EMAIL_NO_ORDER","LOGIN_DATA_PASSWORD_LY");
        reviewPage.checkItemReviewEmpty();
    }
    @Test(priority = 2, description = "When \"MY REVIEW\" tab doesn't have any item  reviewed")
    public void testCase_MPR_06() throws InterruptedException {
        keyword.deleteAllCookies();
        keyword.openNewTab("https://stage.glamira.co.uk/");
        commonReview("LOGIN_DATA_EMAIL_NO_REVIEW","LOGIN_DATA_PASSWORD_LY");
        reviewPage.checkMyReviewEmpty();
    }
    @Test(priority = 3, description = "check if the order is displayed in the \"ITEMS TO REVIEW\" tab")
    public void testCase_MPR_01() throws InterruptedException {
        keyword.deleteAllCookies();
        keyword.openNewTab("https://stage.glamira.co.uk/");
        commonReview("LOGIN_DATA_EMAIL_LY","LOGIN_DATA_PASSWORD_LY");
        reviewPage.checkOrderDisplayInItemToReview("REVIEW_TXT_PRODUCT");
    }
//    @Test(priority = 1, description = "check if the order is displayed in the \"ITEMS TO REVIEW\" tab")
//    public void testCase_MPR_02() throws InterruptedException {
//        reviewPage.writeAReview();
//    }
}
