package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import org.testng.Assert;


public class ReviewPage extends BasePage {
    public ReviewPage() {
        super();
    }
    public ReviewPage(KeywordWeb key){
        super(key);
    }
    //check the order is displayed in the "ITEMS TO REVIEW" tab
    public void checkOrderDisplayInItemToReview(String order) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        if(order==null) {
            keyword.assertEquals("REVIEW_DATA_EMPTY_ORDER","REVIEW_TXT_EMPTY_ORDER");
        }
        else {
            keyword.click("REVIEW_BTN_ITEM_TO_REVIEW");
            keyword.untilJqueryIsDone(50L);
            keyword.verifyElementVisible(order);
            keyword.assertEquals("REVIEW_DATA_NAME_PRODUCT", "REVIEW_TXT_NAME_PRODUCT");
            keyword.assertEquals("REVIEW_DATA_STONE_PRODUCT", "REVIEW_TXT_STONE_PRODUCT");
            keyword.assertEquals("REVIEW_DATA_COLOR_PRODUCT", "REVIEW_TXT_COLOR_PRODUCT");
        }
    }
    //check the order is displayed in the "MY REVIEW" tab
    public void checkOrderDisplayInMyReview(String order) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("REVIEW_BTN_MY_REVIEW");
        keyword.untilJqueryIsDone(50L);
        if(order==null) {
            keyword.assertEquals("REVIEW_DATA_EMPTY_REVIEW","REVIEW_TXT_EMPTY_REVIEW");
        }
        else {
            keyword.verifyElementVisible(order);
            keyword.verifyElementVisible("REVIEW_PROP_RATING_VALUE");
            keyword.assertEquals("REVIEW_DATA_NAME_PRODUCT", "REVIEW_TXT_NAME_PRODUCT_REVIEWED");
            keyword.assertEquals("REVIEW_DATA_STONE_PRODUCT_REVIEWED", "REVIEW_TXT_STONE_PRODUCT_REVIEWED");
            keyword.assertEquals("REVIEW_DATA_COLOR_PRODUCT_REVIEWED", "REVIEW_TXT_COLOR_PRODUCT_REVIEWED");
        }
    }
    public void writeAReviewWithDataNUll(String order) throws InterruptedException {
        writeAReview(order,null, null, null,null,null,null,null);
        keyword.scrollToPositionByScript("window.scrollBy(0,300)");
        keyword.click("REVIEW_BTN_SUBMIT_REVIEW");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("REVIEW_DATA_MESS_CHOOSE_RATING","REVIEW_MESS_CHOOSE_RATING");
        keyword.assertEquals("REVIEW_DATA_MESS_CHOOSE","REVIEW_MESS_INPUT_TITLE");
        keyword.assertEquals("REVIEW_DATA_MESS_CHOOSE","REVIEW_MESS_INPUT_REVIEW");
        keyword.assertEquals("REVIEW_DATA_MESS_CHOOSE","REVIEW_MESS_CHOOSE_TERM");
        keyword.assertEquals("REVIEW_DATA_MESS_CHOOSE","REVIEW_MESS_CHOOSE_POLICY");
        keyword.assertEquals("REVIEW_DATA_MESS_CHOOSE","REVIEW_MESS_CHOOSE_RECAPTCHA");
    }
    public void writeAReviewSuccessfully(String order) throws InterruptedException {
        writeAReview(order,"REVIEW_INP_SCORE", "REVIEW_DATA_TITLE","REVIEW_DATA_REVIEW",
                "C:\\Users\\Admin\\Desktop\\linh tinh\\anh.jpeg",
                "REVIEW_INP_AGREE_TERM","REVIEW_INP_AGREE_POLICY","REVIEW_CHECKBOX_RECAPTCHA");
        keyword.scrollToPositionByScript("window.scrollBy(0,300)");
        keyword.click("REVIEW_BTN_SUBMIT_REVIEW");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(3000);
    }
    public void writeAReviewNotSubmit(String order) throws InterruptedException {
        writeAReview(order,"REVIEW_INP_SCORE", "REVIEW_DATA_TITLE","REVIEW_DATA_REVIEW",
                "C:\\Users\\Admin\\Desktop\\linh tinh\\anh.jpeg",
                "REVIEW_INP_AGREE_TERM","REVIEW_INP_AGREE_POLICY","REVIEW_CHECKBOX_RECAPTCHA");
        keyword.click("REVIEW_BTN_CLOSE_REVIEW");
        keyword.untilJqueryIsDone(50L);
        keyword.click(order);
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("REVIEW_DATA_EMPTY","REVIEW_INP_TITLE");
        keyword.assertEquals("REVIEW_DATA_EMPTY","REVIEW_INP_REVIEW");
    }
    public void writeAReview(String order,String chooseRating, String dataTitle,String dataReview,String pathPhoto,String chooseTerm,String choosePolicy, String chooseRecaptcha) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click(order);
        keyword.untilJqueryIsDone(50L);
        keyword.click(chooseRating);
        keyword.clearText("REVIEW_INP_TITLE");
        keyword.sendKeys("REVIEW_INP_TITLE", dataTitle);
        keyword.clearText("REVIEW_INP_REVIEW");
        keyword.sendKeys("REVIEW_INP_REVIEW",dataReview);
        keyword.chooseFile("REVIEW_CHOOSE_IMAGE1", pathPhoto);
        keyword.chooseFile("REVIEW_CHOOSE_IMAGE2", pathPhoto);
        keyword.chooseFile("REVIEW_CHOOSE_IMAGE3",pathPhoto);
        keyword.click(chooseTerm);
        keyword.click(choosePolicy);
        keyword.switchToIFrameByXpath("REVIEW_IFRAME_RECAPTCHA");
        keyword.click(chooseRecaptcha);
        keyword.switchToDefaultContent();
    }
    public void checkRedirectLinkToTheProductView(String order) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click(order);
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("REVIEW_DATA_NAME_PRODUCT","REVIEW_TXT_TITLE_PRODUCT_PAGE");
        String getStone= keyword.getText("REVIEW_TXT_STONE_PRODUCT_PAGE");
        String stone = getStone.substring(1,getStone.length()-6);
        Assert.assertEquals(stone,PropertiesFile.getPropValue("REVIEW_DATA_STONE_PRODUCT_REVIEWED"));
        String getColor= keyword.getText("REVIEW_TXT_COLOR_PRODUCT_PAGE");
        String color = getColor.substring(1,getColor.length()-1);
        Assert.assertEquals(color,PropertiesFile.getPropValue("REVIEW_DATA_COLOR_PRODUCT_REVIEWED"));
    }
}
