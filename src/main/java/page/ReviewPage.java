package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.util.ArrayList;

public class ReviewPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public ReviewPage() {
        super();
    }
    public ReviewPage(KeywordWeb key){
        super(key);
    }
    public void checkItemReviewEmpty() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("REVIEW_TXT_EXPECT_EMPTY_ORDER","REVIEW_TXT_ACTUAL_EMPTY_ORDER");
    }
    public void checkMyReviewEmpty() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("REVIEW_BTN_MY_REVIEW");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("REVIEW_TXT_EXPECT_EMPTY_REVIEW","REVIEW_TXT_ACTUAL_EMPTY_REVIEW");
    }
    public void checkOrderDisplayInItemToReview(String order) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("REVIEW_BTN_ITEM_TO_REVIEW");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementPresent(order);
        keyword.assertEquals("REVIEW_TXT_EXPECT_NAME_PRODUCT","REVIEW_TXT_ACTUAL_NAME_PRODUCT");
        keyword.assertEquals("REVIEW_TXT_EXPECT_STONE_PRODUCT","REVIEW_TXT_ACTUAL_STONE_PRODUCT");
        keyword.assertEquals("REVIEW_TXT_EXPECT_COLOR_PRODUCT","REVIEW_TXT_ACTUAL_COLOR_PRODUCT");
    }
    public void writeAReview(boolean chooseRating, boolean inputTitle,boolean inputReview, boolean chooseFile,boolean chooseTerm, boolean choosePolicy, boolean clickReCaptcha) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("REVIEW_BTN_WRITE_REVIEW_PRODUCT");
        keyword.untilJqueryIsDone(50L);
        checkClickField("REVIEW_INP_SCORE",chooseRating,"REVIEW_MESS_EXPECT_CHOOSE_RATING","REVIEW_MESS_ACTUAL_CHOOSE_RATING");
        checkInputField("REVIEW_INP_TITLE","REVIEW_TXT_TITLE",inputTitle,"REVIEW_MESS_EXPECT_CHOOSE","REVIEW_MESS_ACTUAL_INPUT_TITLE");
        checkInputField("REVIEW_INP_REVIEW","REVIEW_TXT_REVIEW",inputReview,"REVIEW_MESS_EXPECT_CHOOSE","REVIEW_MESS_ACTUAL_INPUT_REVIEW");
        keyword.chooseFile("REVIEW_CHOOSE_IMAGE1", "C:\\Users\\Admin\\Desktop\\linh tinh\\anh.jpeg");
        keyword.chooseFile("REVIEW_CHOOSE_IMAGE2", "C:\\Users\\Admin\\Desktop\\linh tinh\\anh.jpeg");
        keyword.chooseFile("REVIEW_CHOOSE_IMAGE3", "C:\\Users\\Admin\\Desktop\\linh tinh\\anh.jpeg");
        checkClickField("REVIEW_INP_AGREE_TERM",chooseTerm,"REVIEW_MESS_EXPECT_CHOOSE","REVIEW_MESS_ACTUAL_CHOOSE_TERM");
        checkClickField("REVIEW_INP_AGREE_POLICY",choosePolicy,"REVIEW_MESS_EXPECT_CHOOSE","REVIEW_MESS_ACTUAL_CHOOSE_POLICY");
        Thread.sleep(6000);
        keyword.click("REVIEW_BTN_SUBMIT_REVIEW");
        // keyword.switchToIFrameByXpath("REVIEW_IFRAME_RECAPTCHA");
    }
    public void checkClickField ( String field,boolean check, String messExpect, String messActual) {
        if(!check) {
            keyword.assertEquals(messExpect,messActual);
        }
        else {
            keyword.click(field);
        }
    }
    public void checkInputField ( String field,String content, boolean check, String messExpect, String messActual) {
        if(!check) {
            keyword.assertEquals(messExpect,messActual);
        }
        else {
            keyword.clearText(field);
            keyword.sendKeys(field, content);
        }
    }
    public void checkChooseFile( String field,boolean check, String messExpect, String messActual) {
        if(!check) {
            keyword.assertEquals(messExpect,messActual);
        }
        else {
            keyword.click(field);
        }
    }

}
