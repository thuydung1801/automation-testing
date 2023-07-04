package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.ListingPage;
import page.home.LoginPage;
import page.home.RegisterPage;

public class ListingPageTest extends BaseTest {
    private ListingPage testListingPage;
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private static Logger logger = LogHelper.getLogger();

    public ListingPageTest() {
        super();
        testListingPage = new ListingPage((this.keyword));
        objRegist = new RegisterPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
    }
    @Test(priority = 1, description = "Input data of Min > Max price")
    public void testCase_LP09() throws InterruptedException {
        objRegist.acceptAllCookies();
        testListingPage.goToAllProduct();
        testListingPage.filterPrice();
        testListingPage.enterPrice();
    }
    @Test(priority = 2, description = "Loading page endless with Upload more button instead of pagination")
    public void testCase_LP15() throws InterruptedException {
        testListingPage.checkUploadPage();
    }
    @Test(priority = 3, description = "The number of items in brackets must be the item limit each time the page loads, specifically: Upload More(30)")
    public void testCase_LP16() throws InterruptedException {
        testListingPage.checkUploadPage();
    }
    @Test(priority = 4, description = "Click to UPLOAD MORE button")
    public void testCase_LP22() throws InterruptedException {
        testListingPage.checkUploadMore();
    }
    @Test(priority = 5, description = "TLoading page endless with \"Upload more\" button - do not display this text when not a product load")
    public void testCase_LP17() throws InterruptedException {
        testListingPage.notShowButtonUploadMore();
    }
    @Test(priority = 6, description = "Check show button : Upload more (Number products of listing page < 30 products)")
    public void testCase_LP18() throws InterruptedException {
        testListingPage.notShowButtonUploadMoreWhenProductOfPageLessThan30();
    }
    @Test(priority = 7, description = "Popup product relate")
    public void testCase_LP28() throws InterruptedException {
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/engagement-rings/solitaire-pave/");
        keyword.untilJqueryIsDone(50L);
        objRegist.acceptAllCookies();
        testListingPage.checkPopupProductRelate();
    }
    @Test(priority = 8, description = "Check show button: Upload more when all the products on the page have been loaded  then go back to top and scrolling again")
    public void testCase_LP19() throws InterruptedException {
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/diamond-rings/blue-topaz/950-platinum/?p=17");
        testListingPage.checkButtonUploadMoreWhenShowFullProduct();
    }

    @Test(priority = 9, description = "Auto loading product with 6 pages")
    public void testCase_LP20() throws InterruptedException {
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/diamond-rings/blue-topaz/950-platinum/?p=17");
        keyword.untilJqueryIsDone(50L);
        testListingPage.checkButtonUploadMoreWhenShowFullProduct();
    }

    @Test(priority = 10, description = "Check function saved this item")
    public void testCase_LP40() throws InterruptedException {
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/diamond-rings/blue-topaz/950-platinum/?p=17");
        keyword.untilJqueryIsDone(50L);
        testListingPage.checkFunctionSavedItem();
    }
}