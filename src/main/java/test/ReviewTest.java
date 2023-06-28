package test;

import core.BaseTest;
import org.testng.annotations.Parameters;
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
    @Test( priority = 1,description = "When \"ITEMS TO REVIEW\" tab doesn't have any item to review")
    public void testCase_MPR_05() throws InterruptedException {
        commonReview("LOGIN_DATA_EMAIL_NO_ORDER","LOGIN_DATA_PASSWORD_LY");
        reviewPage.checkOrderDisplayInItemToReview(null);
    }
    @Test(priority = 2,description = "When \"MY REVIEW\" tab doesn't have any item  reviewed")
    public void testCase_MPR_06() throws InterruptedException {
        keyword.deleteAllCookies();
        keyword.openNewTab("https://stage.glamira.co.uk/");
        commonReview("LOGIN_DATA_EMAIL_NO_REVIEW","LOGIN_DATA_PASSWORD_LY");
        reviewPage.checkOrderDisplayInMyReview(null);
    }
    @Test( priority = 3,description = "check if the order is displayed in the \"ITEMS TO REVIEW\" tab")
    public void testCase_MPR_01() throws InterruptedException {
        keyword.deleteAllCookies();
        keyword.openNewTab("https://stage.glamira.co.uk/");
        commonReview("LOGIN_DATA_EMAIL_LY","LOGIN_DATA_PASSWORD_LY");
        reviewPage.checkOrderDisplayInItemToReview("REVIEW_TXT_NAME_PRODUCT");
    }
    @Test( priority = 4,description = "Check function \"Write A Review\" - do not enter required values")
    public void testCase_MPR_03() throws InterruptedException {
        reviewPage.writeAReviewWithDataNUll("REVIEW_BTN_WRITE_REVIEW_PRODUCT");
    }
    @Test(priority = 5,description = "Check the entered values when the form is not submitted")
    public void testCase_MPR_04() throws InterruptedException {
        keyword.navigateToUrl("URL_REVIEW_ORDER");
        reviewPage.writeAReviewNotSubmit("REVIEW_BTN_WRITE_REVIEW_PRODUCT");
    }
    @Test(priority = 6, description = "Check function \"Write A Review\" - Enter all required values for an order with multiple items")
    public void testCase_MPR_02() throws InterruptedException {
        keyword.navigateToUrl("URL_REVIEW_ORDER");
        reviewPage.writeAReviewSuccessfully("REVIEW_BTN_WRITE_REVIEW_PRODUCT");
    }
    @Test(priority = 7,description = "MY REVIEWS- item displayed after submitting the review form")
    public void testCase_MPR_07() throws InterruptedException {
        keyword.navigateToUrl("URL_REVIEW_ORDER");
        reviewPage.checkOrderDisplayInMyReview("REVIEW_TXT_NAME_PRODUCT_REVIEWED");
    }
    @Test(priority = 8,description = "Check the redirect link to the product view of that item")
    public void testCase_MPR_08() throws InterruptedException {
        reviewPage.checkRedirectLinkToTheProductView("REVIEW_TXT_NAME_PRODUCT_REVIEWED");
    }
    @Parameters("baseURL")
    @Test(priority = 2,description = "Check the \"Write a review\" function when not loggin")
    public void testCase_WAR_02(String baseURL) throws InterruptedException {
        keyword.deleteAllCookies();
        keyword.openNewTab("https://stage.glamira.co.uk/");
        objRegist.acceptAllCookies();
        reviewPage.checkWriteAReviewInProductPage(baseURL +"glamira-diamonds-ring-madison-skug100620.html?alloy=white-585&stone1=diamond-Brillant&stone2=diamond-Brillant","NotLogin");
    }
    @Parameters("baseURL")
    @Test(priority = 3,description = "Check the \"Write a review\" function in the product view of the item that is not in the Item To review section")
    public void testCase_WAR_03(String baseURL) throws InterruptedException {
        keyword.deleteAllCookies();
        keyword.openNewTab("https://stage.glamira.co.uk/");
        commonReview("LOGIN_DATA_EMAIL_LY","LOGIN_DATA_PASSWORD_LY");
        reviewPage.checkWriteAReviewInProductPage(baseURL +"glamira-diamonds-ring-olivia-skug100515.html?alloy=white-585&stone1=diamond-Brillant","LoginWithItemNotInReview");
    }
    @Parameters("baseURL")
    @Test(priority = 4,description = "Check the \"Write a review\" function in the product view of the item that in the Item To review section")
    public void testCase_WAR_01(String baseURL) throws InterruptedException {
        reviewPage.checkWriteAReviewInProductPage(baseURL +"glamira-diamonds-ring-madison-skug100620.html?alloy=white-585&stone1=diamond-Brillant&stone2=diamond-Brillant","LoginWithItemInReview");
    }

}
