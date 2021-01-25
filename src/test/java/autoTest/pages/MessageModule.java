package autoTest.pages;

import junit.framework.TestCase;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.jruby.util.Sprintf;
import org.openqa.selenium.JavascriptExecutor;
import autoTest.service.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.beans.Introspector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import autoTest.pages.NotificationPage;

public class MessageModule extends PageObject {


    MektoubeCommonPage commonPage = new MektoubeCommonPage();
    NotificationPage noti = new NotificationPage();
    DiscoveriesPage discoveriesPage;


    public boolean IfInspirationalTextInChatFieldCanChange() throws AWTException {
        commonPage.waitUntilElementIsVisible("Discuss");
        commonPage.click("Discuss");
        commonPage.waitUntilElementIsVisible("textarea[id='field-chat']");
        Robot robot = new Robot();
        for (int i = 0; i < 15; i++) {

            WebElement textArea = getDriver().findElement(By.cssSelector(".actions-form-wrapper textarea"));
//            Point textAreaLocation = textArea.getLocation();
//            int xcord = textAreaLocation.getX() + 5;
//            int ycord = textAreaLocation.getY() + 120;
//            robot.mouseMove(xcord, ycord);
//            System.out.println(xcord + " " + ycord);
//            try {
//                Thread.sleep(2 * 1000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            WebElement inpirationalTooltip = getDriver().findElement(By.cssSelector(".inpirational-tooltip button[type='button']"));
            inpirationalTooltip.click();
            commonPage.waitUntilElementIsVisible(".inspirational-list .inspirational-item");
            ArrayList<String> inpirationalOptionList = new ArrayList<>();
            ArrayList<WebElement> inpirationalElement = new ArrayList<>(getDriver().findElements(By.cssSelector(".inspirational-list .inspirational-item")));
            System.out.println(inpirationalElement.size());
            for (WebElement inpirationalOption : inpirationalElement) {
                inpirationalOptionList.add(inpirationalOption.getText());
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i > 9) {
                robot.mouseWheel(10);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                inpirationalElement.get(i).click();

            } else {
                inpirationalElement.get(i).click();
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String MessageDisplayInTextArea = getDriver().findElement(By.cssSelector(".actions-form-wrapper textarea")).getText();
            if (inpirationalOptionList.get(i).contentEquals("Salam. Qu'est-ce que tu fais pour te relaxer après une journée difficile ?")) {
                if (!MessageDisplayInTextArea.contentEquals("Salam. \n" +
                        "Qu'est-ce que tu fais pour te relaxer après une journée difficile ?")) {
                    return false;
                }
            } else {
                if (!MessageDisplayInTextArea.replace(" ", "").contains(inpirationalOptionList.get(i).replace(" ", ""))) {

                    System.out.println(i);
                    System.out.println(inpirationalOptionList.get(i));
                    System.out.println(MessageDisplayInTextArea + " fail");
                    return false;

                }
            }

            System.out.println(i);
            System.out.println(inpirationalOptionList.get(i));
            System.out.println(MessageDisplayInTextArea + " pass");
//            int xMoveOutOfTextArea = textAreaLocation.getX() - 20;
//            int yMoveOutOfTextArea = textAreaLocation.getY() + 90;
//            robot.mouseMove(xMoveOutOfTextArea, yMoveOutOfTextArea);
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println(xMoveOutOfTextArea + " " + yMoveOutOfTextArea);
        }

        return true;

    }

    public boolean sendInspirationalTextInChatField() {

        commonPage.waitUntilElementIsVisible(".actions-form-wrapper textarea");
        WebElement InTextArea = getDriver().findElement(By.cssSelector(".actions-form-wrapper textarea"));
        String MessageDisplayInTextArea = InTextArea.getText();
        System.out.println(MessageDisplayInTextArea);
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem(arguments[0],arguments[1])", "InTextArea", MessageDisplayInTextArea);
        System.out.println(MessageDisplayInTextArea);
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement sentMess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='mes-body-text']")));
        if (!sentMess.getText().replace(" ", "").contentEquals(MessageDisplayInTextArea.replace(" ", ""))) {
            System.out.println(sentMess.getText() + " " + MessageDisplayInTextArea);
            return false;
        }
        System.out.println(sentMess.getText() + " " + MessageDisplayInTextArea);

        ArrayList<WebElement> tickOfSentMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='chat__message chat__message--host']:last-child i.material-icons")));
        if (tickOfSentMess.size() != 1) {
            System.out.println(tickOfSentMess.size());
            return false;
        }
        System.out.println(sentMess + " pass");
        System.out.println(tickOfSentMess.size() + " pass");
        return true;
    }

    public boolean shouldSeeMessageContainInsiprationTextOfWoman() {
        commonPage.waitUntilElementIsVisible("Messages");
        commonPage.click("Messages");
//        String abc = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('nameField')");
//        System.out.println(abc);
        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
        for (WebElement userName : userNameList) {
            String textOfUserName = userName.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals("samiracute")) {

                ArrayList<WebElement> message = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='clickable-overlay']")));
                message.get(i).click();
                String getSentMessage = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('InTextArea')");
                WebDriverWait wait = new WebDriverWait(getDriver(), 60);
                WebElement sentMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='mes-body-text']")));
//                WebElement sentMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".chat__body-rows .chat__row.animated:nth-child(1) span.mes-body-text")));
                String sentMessage = sentMessageElement.getText();
                if (getSentMessage.contains(sentMessage)) {
                    System.out.println(userNames.get(i));
                    System.out.println(sentMessage + " " + getSentMessage + " Pass");
                    return true;
                }
                System.out.println(userNames.get(i));
                System.out.println(sentMessage + " " + getSentMessage + " fail");
            }

        }
        return false;
    }

    public void uploadEphemeralPicture() throws AWTException {
        commonPage.waitUntilElementIsVisible("label[for='file-upload-camera']");
        WebElement fileInput = getDriver().findElement(By.cssSelector("label[for='file-upload-camera']"));
        System.out.println(fileInput);
        fileInput.click();

        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String text = System.getProperty("user.dir") + "\\src\\test\\resources\\data_test\\testPicture5.jpg";
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
        robot.keyRelease(KeyEvent.VK_ENTER);
        try {
            Thread.sleep(2 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assertThat(SelectByDefaultFiveSecond(), is(equalTo(true)));
        getDriver().findElement(By.cssSelector(".delay-options div:nth-child(3)")).click();
        getDriver().findElement(By.cssSelector("button.submit-option")).click();
        try {
            Thread.sleep(5 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public boolean SelectByDefaultFiveSecond() {
        WebElement FiveSecondOption = getDriver().findElement(By.cssSelector(".delay-options div:nth-child(2)"));
        if (FiveSecondOption.findElement(By.cssSelector("p")).getText().contentEquals("5s")) {
            System.out.println(FiveSecondOption.findElement(By.cssSelector("p")).getText());
            return true;
        }
        System.out.println(FiveSecondOption.findElement(By.cssSelector("p")).getText());
        return false;

    }
    public boolean ReportAEphemeralPictureModalClose() {
        ArrayList<WebElement> ReportAEphemeralPictureModal = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='setting--modal report-epicture centered-modal mobile-nofull modal-480 modal is--opened']")));
        if (ReportAEphemeralPictureModal.size() > 0) {
            System.out.println(ReportAEphemeralPictureModal);
            return false;
        }
        System.out.println(ReportAEphemeralPictureModal);
        return true;
    }

    public void seeTheFirstEphemeralPictureAndClickClose() {
        commonPage.waitUntilElementIsVisible(".chat__row:nth-last-child(2) .chat__message-entry.ephemeral-wrapper");
        getDriver().findElement(By.cssSelector(".chat__row:nth-last-child(2) .chat__message-entry.ephemeral-wrapper")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 80);
        WebElement picture = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='display-image']")));
        getDriver().findElement(By.cssSelector("a.closer")).click();
    }

    public boolean shouldSeeTheSecondEphemeralPicture() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 120);
        ArrayList<WebElement> EphemeralPicture = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("img[class='display-image']"))));
        if (EphemeralPicture.size() > 0) {
            System.out.println("exit picture " + EphemeralPicture.size());
            System.out.println(EphemeralPicture.get(0).getAttribute("src"));
            return true;
        }
        System.out.println(EphemeralPicture.size());
        return false;
    }

    public boolean checkIfStatusOfUnreadMessagePictureIsRight() {
        String notSeePictureYet = getDriver().findElement(By.cssSelector(".chat__row:last-child .ephemeral-placeholder.ephemeral-placeholder--blue p.ephemeral_read_info")).getText();
        if (!notSeePictureYet.contentEquals("Pas encore vu")) {
            return false;
        }
        System.out.println(notSeePictureYet);
        ArrayList<WebElement> tick = new ArrayList<>(getDriver().findElements(By.cssSelector(".chat__row:last-child span.mes-time-state i.material-icons")));
        if (tick.size() != 1) {
            System.out.println(tick.size());
            return false;
        }
        System.out.println(tick.size());
        return true;
    }

    public boolean checkIfStatusOfReadMessagePictureIsRight() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 120);
        ArrayList<WebElement> chatRow = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".chat__row"))));

        String seenPicture = getDriver().findElement(By.cssSelector(".chat__row:last-child .ephemeral-placeholder.ephemeral-placeholder--blue p.ephemeral_read_info")).getText();
        if (!seenPicture.contains("Vu le ")) {
            System.out.println(seenPicture);
            return false;
        }
        System.out.println(seenPicture);
        ArrayList<WebElement> tick = new ArrayList<>(getDriver().findElements(By.cssSelector(".chat__row:last-child span.mes-time-state i.material-icons")));
        if (tick.size() != 2) {
            System.out.println(tick.size());
            return false;
        }
        System.out.println(tick.size());
        return true;
    }

    public void thePageStillShowDiscussionOfYassine_yesWith(String field){
        //Scroll all message item
        //??
        //get all name in disscussion
        int count=0;
        ArrayList<WebElement> messItemList= new ArrayList<>(getDriver().findElements(By.cssSelector("div[style='position: relative;'] > div > div.message__content > div.message__head > h5")));
        for(WebElement userName: messItemList){
            if(userName.getText().equals(field)){
                count=1;
                System.out.println("The page still show discussion of Yassine_yes with 'shainez29'");
                return;
            }
        }
        if(count==0){
            assertEquals("error","The page dont show discussion of Yassine_yes with 'shainez29'");
        }
    }

    public void clickOnTheMessageWith(String name) {
        ArrayList<WebElement> messItemList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[style='position: relative;'] > div > div.message__content > div.message__head > h5")));
        for (WebElement userName : messItemList) {
            if (userName.getText().equals(name)) {
                userName.click();
            }
        }
    }

    public void thePageShowMessageWithLastContentIsWith(String content, String name){
        //click on the name is name
        ArrayList<WebElement> messItemList= new ArrayList<>(getDriver().findElements(By.cssSelector("div[style='position: relative;'] > div > div.message__content > div.message__head > h5")));
        for(WebElement userName: messItemList){
            if(userName.getText().equals(name)){
                userName.click();
                System.out.println("clicked on the "+name);
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //have ? row
        ArrayList<WebElement> rowInMessList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.chat__body-rows > div.chat__row.animated > div.chat__message.chat__message--guest > div.chat__message-entry  > p > span:nth-child(1)")));
        //get last row and check with content
        System.out.println(rowInMessList.get(rowInMessList.size()-1).getText());
        //System.out.println(rowInMessList.get(rowInMessList.size()-2).getText());
        assertEquals(content, rowInMessList.get(rowInMessList.size()-1).getText());
    }

    public boolean thereIsNoDuplicateLogChat() {
        commonPage.waitUntilElementIsVisible("div[class='message__head'] h5");

        ArrayList<String> accountName = new ArrayList<>();
        ArrayList<WebElement> nameList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
        for (WebElement Name : nameList) {
            String textName = Name.getText();
            accountName.add(textName);
        }
        System.out.println(accountName);
        ArrayList<String> accountName2 = new ArrayList<>();
        accountName2.add(accountName.get(0));

        for (int i = 1; i < accountName.size(); i++) {
            for (int j = 0; j < accountName2.size(); j++) {
                if (accountName.get(i).contentEquals(accountName2.get(j))) {
                    System.out.println(accountName2 + " duplicate");
                    return false;
                }
            }
            accountName2.add(accountName.get(i));

        }
        return true;

    }

    public void clickToNextLogChatAndClickBackToLogChatIWasGoingToText() {

        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> listMessages = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='message']"))));
        System.out.println(listMessages.get(listMessages.size() - 1).findElement(By.cssSelector("h5")).getText());
        listMessages.get(listMessages.size() - 1).click();
        commonPage.waitAboutSecond(2);
        ArrayList<WebElement> listMessages1 = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='message']"))));
        System.out.println(listMessages1.get(0).findElement(By.cssSelector("h5")).getText());
        listMessages1.get(0).click();
    }



    //---------------------------------
    public void showingConversation(){
        //click on first conversation
        getDriver().findElement(By.cssSelector("div.messages__body div[style='position: relative;'] div.message:nth-child(1) div.clickable-overlay")).click();
        System.out.println("current url: "+getDriver().getCurrentUrl());
        assertTrue(getDriver().getCurrentUrl().contains("/main/messages"));
    }

    //scroll all message
    public void scrollSpecialElement(String element) throws AWTException {
        String cssSelector = TestDataService.properties.getProperty(element);
//        ArrayList<WebElement> message = new ArrayList<>(getDriver().findElements(By.cssSelector(cssSelector)));
//        message.get(message.size() - 1 ).sendKeys(Keys.ARROW_DOWN);
        ArrayList<WebElement> mess = new ArrayList<>(getDriver().findElements(By.cssSelector(".message")));
        System.out.println("mess size: "+mess.size());
        Robot robot = new Robot();
        WebElement messagesList = getDriver().findElement(By.cssSelector(".messages")); //get element div include all message
        Point listMess = messagesList.getLocation(); //get location of all messages in messsagesList
        int xcord = listMess.getX();// get x location of message
        int ycord = listMess.getY() + 120;// get y location of message
        robot.mouseMove(xcord, ycord);// move mouse into above location (x,y)
        System.out.println(xcord + " " + ycord);

        int itemLoaded = 0;
        int totalItems = mess.size();

        while (itemLoaded < totalItems) {
            //scroll and wait a bit to give the impression of smooth scrolling
            robot.mouseWheel(40);

            try {
                Thread.sleep(2 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            itemLoaded = totalItems;
            mess = new ArrayList<>(getDriver().findElements(org.openqa.selenium.By.cssSelector(".message")));
            totalItems = mess.size();
            System.out.println(mess.size());
        }
        mess = new ArrayList<>(getDriver().findElements(org.openqa.selenium.By.cssSelector(".message")));
        System.out.println("mess size: "+mess.size());
//        for(WebElement message: mess){
//            System.out.println(message.findElement(By.cssSelector("div[class='message__head'] h5")).getText()+": "+message.findElement(By.cssSelector("div.meta__text")).getText());
//        }
    }

    public void  thePageShowDiscussionsThatAreSortedFromTheMostRecentToTheOldest() {
        ArrayList<WebElement> dateList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.meta__text")));
        System.out.println("size of date list: " + dateList.size());
        //get current date time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("today: "+dtf.format(now));
        String[] todayDay =dtf.format(now).split("/");
        int maxDay = Integer.parseInt(todayDay[0]);
        int maxMonth = Integer.parseInt(todayDay[1]);

        for(WebElement date: dateList){
            System.out.println(date.getText());
            if(date.getText().contains("/")){
                String[] messDay = date.getText().split("/");
                System.out.println("messDay: "+Integer.parseInt(messDay[0]));
                System.out.println("messMonth: "+Integer.parseInt(messDay[1]));
                //previous month
                if(Integer.parseInt(messDay[1])<maxMonth){
                    System.out.println("messDay: "+Integer.parseInt(messDay[0]));
                    System.out.println("maxDay: "+maxDay);
                    maxMonth=Integer.parseInt(messDay[1]);
                    maxDay=Integer.parseInt(messDay[0]);
                    System.out.println("after messDay: "+Integer.parseInt(messDay[0]));
                    System.out.println("after maxDay: "+maxDay);
                }else if(Integer.parseInt(messDay[1])==maxMonth){//same month
                    System.out.println("messDay: "+Integer.parseInt(messDay[0]));
                    System.out.println("maxDay: "+maxDay);
                    if(Integer.parseInt(messDay[0])<=maxDay){
                        maxDay=Integer.parseInt(messDay[0]);
                    }else{
                        assertEquals("error","error1");
                    }
                    System.out.println("after maxDay: "+maxDay);
                }else{//next month
                    assertEquals("error","error1");
                }
            }
        }
        System.out.println("max day: "+maxDay);
        System.out.println("max month: "+maxMonth);
        //get current date time
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));
//
//       String[]  daylOfTheWeek_France = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
//       String[] dayOfWeek_USUK = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
//
//        long millis=System.currentTimeMillis();
//        java.util.Date date=new java.util.Date(millis);
//        System.out.println(date);
//        String[] today = date.toString().split(" ");//ex: Tue Oct 08
    }

    public void visitingOneProfile(){
        //https://www.mektoube.fr/main/my-account/my-profile/
        assertTrue(getDriver().getCurrentUrl().contains("/main/my-account/my-profile/"));
//        ArrayList<WebElement> chatRowsList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.chat__body-rows > div[class='chat__message chat__message--host']")));
//        int numberOfRows = chatRowsList.size();
//        System.out.println("have "+numberOfRows+" ");
//        //click on the lastest your conversation
//        getDriver().findElement(By.cssSelector("div#sidebar--message-1516896766")).click();
//        getDriver().findElement(By.cssSelector("div.chat__body-rows > div[class='chat__message chat__message--host']:nth-child("+numberOfRows+") > div > a > span")).click();
//        try {
//            if(getDriver().getCurrentUrl().equals("https://www.mektoube.fr/main/profil/2627555")){
//                System.out.println("passed");
//            }else if(getDriver().getCurrentUrl().equals("https://www.mektoube.fr/main/profil/329385")){
//                System.out.println("passed");
//            }
//        }catch (Exception e){
//            System.out.println("errorr");
//            assertEquals("error","error1");
//        }
    }

    public void clickOnFirstGifIs(String value){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("click value= " + value);
        String selected = "";
        try {
            if(value.equals("more_vert")) {
                selected = getDriver().findElement(By.cssSelector("div.blocklist-list > div.blocklist-item:nth-child(1) > div.left-info > div.user-info > h3")).getText();
                System.out.println("name just unblock: " + selected);
            }else if(value.equals("firstMoreVert")){
                selected = getDriver().findElement(By.cssSelector("div.hidden-xs.list-search-wrap > div.filter__item:nth-child(1) > div.filter__item-content > h5")).getText();
                System.out.println("first element in search save list ="+selected);
            }else if(value.equals("firstGif")){
                selected = getDriver().findElement(By.cssSelector("div#gifSlider > label:nth-child(1) > div > img")).getAttribute("src");
                System.out.println("Selected: " + selected);
            }else if(value.equals("firstRequestName")){
                //name of profile that response later
                selected = getDriver().findElement(By.cssSelector("div.infinite-scroll-component > div.request:nth-child(1) > div.request__head > h5")).getText();
                System.out.println("first request name: "+selected);
            }else if(value.equals("AcceptInLast5Refusals")){
                selected = getDriver().findElement(By.cssSelector("div.modal--body > .request:nth-child(1) > div.request__head > h5")).getText();
                System.out.println("first name in 5 last refusals: "+selected);
            }if(value.equals("firstDeleteInConversation")) {
                //get name of first discussion
                selected=getDriver().findElement(By.cssSelector("div[style='position: relative;'] > div:nth-child(1) > div.message__content > div.message__head > h5")).getText();
                System.out.println("first name in message: "+selected);
            }
            else {
                selected = getDriver().findElement(By.cssSelector("div.infinite-scroll-component  > div.request:nth-child(1) > div.request__head > h5")).getText();
                System.out.println("Select name: " + selected);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        //export this value to the file

        noti.WriteToFile(selected);

        String cssSelector = TestDataService.properties.getProperty(value);
        if (cssSelector == null) {
            cssSelector = value;
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.cssSelector(cssSelector)));
        element.click();
//        if(value.equals("firstConversation")){
//            //save id or profile and id of message
//            String url = getDriver().getCurrentUrl();
//            System.out.println("current url in message: "+url);
//            String[] templList = url.split("/");
//            //profileID|messID
//
//            selected = templList[templList.length-1] +"-"+templList[templList.length-2];
//            System.out.println("templList.length-1="+templList[templList.length-1]+"__ templList.length-2="+templList[templList.length-2]);
//            WriteToFile(selected);
//        }
    }

    public void clickOnFirstDeleteInConversationIs(String value){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("click value= " + value);
        String selected = "";
        try {
            if(value.equals("more_vert")) {
                selected = getDriver().findElement(By.cssSelector("div.blocklist-list > div.blocklist-item:nth-child(1) > div.left-info > div.user-info > h3")).getText();
                System.out.println("name just unblock: " + selected);
            }else if(value.equals("firstMoreVert")){
                selected = getDriver().findElement(By.cssSelector("div.hidden-xs.list-search-wrap > div.filter__item:nth-child(1) > div.filter__item-content > h5")).getText();
                System.out.println("first element in search save list ="+selected);
            }else if(value.equals("firstGif")){
                selected = getDriver().findElement(By.cssSelector("div#gifSlider > label:nth-child(1) > div > img")).getAttribute("src");
                System.out.println("Selected: " + selected);
            }else if(value.equals("firstRequestName")){
                //name of profile that response later
                selected = getDriver().findElement(By.cssSelector("div.infinite-scroll-component > div.request:nth-child(1) > div.request__head > h5")).getText();
                System.out.println("first request name: "+selected);
            }else if(value.equals("AcceptInLast5Refusals")){
                selected = getDriver().findElement(By.cssSelector("div.modal--body > .request:nth-child(1) > div.request__head > h5")).getText();
                System.out.println("first name in 5 last refusals: "+selected);
            }if(value.equals("firstDeleteInConversation")) {
                //get name of first discussion
                selected=getDriver().findElement(By.cssSelector("div[style='position: relative;'] > div:nth-child(1) > div.message__content > div.message__head > h5")).getText();
                System.out.println("first name in message: "+selected);
            }
            else {
                selected = getDriver().findElement(By.cssSelector("div.infinite-scroll-component  > div.request:nth-child(1) > div.request__head > h5")).getText();
                System.out.println("Select name: " + selected);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        //export this value to the file
        noti.WriteToFile(selected);

        String cssSelector = TestDataService.properties.getProperty(value);
        if (cssSelector == null) {
            cssSelector = value;
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.cssSelector(cssSelector)));
        element.click();
//        if(value.equals("firstConversation")){
//            //save id or profile and id of message
//            String url = getDriver().getCurrentUrl();
//            System.out.println("current url in message: "+url);
//            String[] templList = url.split("/");
//            //profileID|messID
//
//            selected = templList[templList.length-1] +"-"+templList[templList.length-2];
//            System.out.println("templList.length-1="+templList[templList.length-1]+"__ templList.length-2="+templList[templList.length-2]);
//            WriteToFile(selected);
//        }
    }

    public void thePageDontAllowSendAnEmptyMessage(){
        //click on the send button
        Assert.assertFalse(getDriver().findElement(By.cssSelector("button[type='submit']")).isEnabled());
    }

    public void theMessagesHaveUnreadDotAreNotRead(){
        ArrayList<WebElement> haveUnreadDotList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.messages__body > div > div[class='message message--unread'] > div.message__content > div.meta > span")));
        for(WebElement prof: haveUnreadDotList){
            System.out.println("prof "+prof.getAttribute("class"));
            assertEquals(prof.getAttribute("class"),"unread-dot");
        }
    }

    public void thePageShowsTenIfMoreThanTenMessges(){
        assertEquals("10+",getDriver().findElement(By.cssSelector("ul > li:nth-child(3) > a > span[class='badge']")).getText());
    }

    public void thePageCheckThisAccountHaveMoreThanTenNotReadMessages(){
        ArrayList<WebElement> messageNonRead = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message message--unread']")));
        if(messageNonRead.size()>10){
            System.out.println("Pass!");
        }else{
            assertEquals("10","9");
        }
    }

    public void theSendButtonIsDisable(){
        Assert.assertFalse(getDriver().findElement(By.cssSelector("button[type='submit']")).isEnabled());
    }

    public void theSearchGifTextfieldShowTextIsHello(){
        String realText = getDriver().findElement(By.cssSelector("#field-chat")).getText();
        assertEquals("hello",realText);
    }

    public  void checkingUnreadMessageList(){
        //get all unread message and check round blue icon
        ArrayList<WebElement> unreadDotList = new ArrayList<>(getDriver().findElements(By.cssSelector(".unread-dot")));
        ArrayList<WebElement> unreadList = new ArrayList<>(getDriver().findElements(By.cssSelector(".unread-dot")));
        if(unreadDotList.size()==unreadList.size()){
            System.out.println("Passed");
            return;
        }
        assertEquals(unreadDotList.size(),unreadList.size());
    }

    public void thePageShowAllMessages(){
        ArrayList<WebElement> allMessages = new ArrayList<>(getDriver().findElements(By.cssSelector("div.messages__body > div[style='position: relative;'] > div.message")));
        System.out.println("There are "+allMessages.size()+" messages");
//        ArrayList<WebElement> unreadMessageList = new ArrayList<>(getDriver().findElements(By.cssSelector("span.unread-dot")));
//        System.out.println("There are "+unreadMessageList.size()+" unread messages");
//        int unreadMess = 0;
//        int readMess = 0;
//        for(WebElement user: allMessages){
//            if(checkReadMessage(user)){//read message
//                readMess++;
//            }else{//unread message
//                unreadMess++;
//            }
//        }
//        System.out.println("There are "+readMess+" read messages");

    }

    public void clickOnThePersonHaveAboveNameInMessageList(String name){
        //collect all message
        ArrayList<WebElement> messageList = new ArrayList<>(getDriver().findElements(By.cssSelector(".message.message--unread > div.message__content > div > h5")));
        for(WebElement mess: messageList){
            String realName = mess.getText().substring(0,2);
            System.out.println("real name of non profile is "+realName);
            if(name.contains(realName)){
                mess.click();
            }
        }
    }

    public void thePageShowPopUpRequestPayTheFee(){
        Assert.assertTrue(getDriver().findElement(By.cssSelector(".modal-overlay.setting--modal.modal--pass")).isDisplayed());
    }

    public void thePageTheRedButtonSupprimerAppearsToTheRightOfEachDiscusses(){
        //get all message item that have to have Supprimer button
        ArrayList<WebElement> messageItemList= new ArrayList<>(getDriver().findElements(By.cssSelector("div[style='position: relative;'] > div > a > span > span")));
        for(WebElement mess: messageItemList){
            assertEquals("Supprimer", mess.getText());
        }
        //mus have red color background
        System.out.println();
        ArrayList<WebElement> messItemList= new ArrayList<>(getDriver().findElements(By.cssSelector("div[style='position: relative;'] > div > a.message__delete")));
        for(int i=0;i<messageItemList.size();i++){
            System.out.println(getDriver().findElement(By.cssSelector("div[style='position: relative;'] > div:nth-child("+(i+1)+") > a.message__delete")).getCssValue("background-color"));
            Assert.assertTrue(getDriver().findElement(By.cssSelector("div[style='position: relative;'] > div:nth-child("+(i+1)+") > a.message__delete")).getCssValue("background-color").toString().contains("255, 44, 44"));

        }
    }

    public void thePageShowGreenNotification(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement myDynamicElement = (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.top-message-text > div")));
        System.out.println(" myDynamicElement.getText()=="+ myDynamicElement.getText());
        assertTrue(myDynamicElement.getText().contains("a été supprimée"));
        //assertEquals("a été supprimée", myDynamicElement.getText());
    }

    public void thisDiscustionDontShowInMessage(){
        //get messageID and find in discussion list
        //messageID
        String deletedName=null;
        try {
            deletedName = noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //get all message item
        //scroll all message???

        ArrayList<WebElement> messageItemList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[style='position: relative;'] > div > div.message__content > div.message__head > h5")));
        System.out.println("NAME of deleted message="+deletedName);
        for(WebElement mess: messageItemList){
            assertNotEquals(deletedName,mess.getText());
//            if(mess.getText().equals(deletedName)){
//                assertEquals("error",":((deleted first discussion unsuccessful ");
//            }
        }
        System.out.println("passed because this discussion dont have deleted message");
    }

    public void insertAboveDeletedNameIntoFieldUpd(String field){
        String deletedName = "";
        try {
            deletedName = noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String cssSelector = TestDataService.properties.getProperty(field);
        getDriver().findElement(By.cssSelector(cssSelector)).sendKeys(deletedName);
    }

    public void clickOnTheProfileThatDeletedDiscussion(){
//        String[] tempList=null;
//        try {
//            tempList = ReadFromFile().split("-");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String profId = tempList[1];
//        //https://www.mektoube.fr/main/profil/2816198
//        //????????????????????????????????????????????????????????
//        System.out.println("go to "+"https://www.mektoube.fr/main/profil/"+profId);
//        getDriver().navigate().to("https://www.mektoube.fr/main/profil/"+profId);

        String deletedName = "";
        try {
            deletedName = noti.ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<WebElement> searchList= new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li > a > div.profile__content > h5")));
        for(WebElement prof: searchList){
            if(prof.getText().equals(deletedName)){
                prof.click();
                System.out.println("click on prof pass");
            }
        }
    }

    public void thisDiscussionDontHaveAnyDiscussLine(){
        //div.chat__body-rows > div.chat__row.animated
        try{
            getDriver().findElement(By.cssSelector("div.chat__body-rows > div.chat__row.animated")).isDisplayed();
            System.out.println("faild");
            assertEquals("error","not yet delete discuss line ");
        }catch (Exception e){
            System.out.println("passed, delete discussion complete");
        }
    }

    //upd 26/2/2020
    public void theLastMessageMustBeGif(){
        //get all row messs then get last conversation row, it must be gif
        ArrayList<WebElement> rowMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div.chat__body-rows div.chat__row")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("row size: "+rowMess.size());
        WebElement lastRow = rowMess.get(rowMess.size()-1);
        assertTrue(lastRow.findElement(By.cssSelector(".gif-wrapper")).isDisplayed());
    }

//    //upd 16/2/2020
//    public void clickOnLastThumbnailInConversation(){
//        //get all row messs then get last thumbnail of row
//        ArrayList<WebElement> rowMess = new ArrayList<>(getDriver().findElements(By.cssSelector("a.chat__message-image span.avatar")));
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("row size: "+rowMess.size());
//        WebElement lastThumbnail = rowMess.get(rowMess.size()-1);
//        lastThumbnail.click();
//    }

    //26/2/2020
    public void theConversationHaveLastRowIsHello(){
        //compare sent text with lastMessage just sent
        ArrayList<WebElement> chatRowsList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.chat__row ")));
        int rowNumber = chatRowsList.size()-1;
        System.out.println("row number are: "+rowNumber);//div.chat__body-rows div.chat__row:nth-child(20) span.mes-body-text
        String realLastMess = getDriver().findElement(By.cssSelector("div.chat__body-rows div.chat__row:nth-child("+rowNumber+") span.mes-body-text")).getText();
        System.out.println("real last message is "+realLastMess);
        assertEquals("hello",realLastMess);
    }

    //26/2/2020
    public void numberOfUnreadMessagesHaveToCorrect(){
        //filter all non read message
        commonPage.waitUntilElementIsVisible("RoundButton");
        commonPage.click("RoundButton");
        commonPage.click("unreadMessage");
        commonPage.waitAboutSecond(1);

        String unreadMess = getDriver().findElement(By.cssSelector("span.badge")).getText();
        System.out.println("There are/is "+unreadMess+" unread messages.");
        ArrayList<WebElement> unreadMessageList = new ArrayList<>(getDriver().findElements(By.cssSelector("span.unread-dot")));
        if(Integer.parseInt(unreadMess)>10){
            assertEquals("10+", unreadMess);
        }
        assertEquals(Integer.parseInt(unreadMess), unreadMessageList.size());
    }

    public void test() {
        System.out.println(getDriver().findElement(org.openqa.selenium.By.cssSelector("#\\34 15926554 > div.chat__message.chat__message--host > div > div > div > span")).getText());
    }

    public void shouldShowCupIconInConversation(){
        assertTrue(getDriver().findElement(By.cssSelector("a.open-virtualdate-cup")).isDisplayed());
    }

    public void thePageShowVirtualDateInformationPopUp(){
        commonPage.waitAboutSecond(3);

        assertTrue(getDriver().findElement(By.cssSelector("div[class='owl-item active'] img")).getAttribute("src").contains("/images/chat/visuel3.png"));
        assertEquals("Depuis quelques semaines, vous ne pouvez plus vous rencontrer physiquement. Nous savons à quel point cela peut etre frustrant.",
                getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14 pad-30 text-gray']")).getText());
        assertEquals("Nous avons lancer cette nouvelle fonctionnalité pour vous permettre d’échanger virtuellement, afin de vous concentrer sur une seule conversation à la fois.",
                getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-18 pad-20']")).getText());
        assertEquals("Comme si vous étiez dans un café virtuel.",
                getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14 pad-10 text-gray']")).getText());
        commonPage.click("button.owl-next");
        assertTrue(getDriver().findElement(By.cssSelector("div[class='owl-item active'] img")).getAttribute("src").contains("/images/chat/man_3.png"));
        assertEquals("Votre rendez-vous virtuel bloquera toutes les autres conversations pour vous concentrer sur la conversation en cours.",
                getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-24 pad-30']")).getText());
        assertEquals("Chaque rendez-vous virtuel dure 1h maximum, vous avez la possibilité d’arrêter le rendez-vous à tout moment, si vous le souhaitez. Vous ne pouvez effectuer qu’un seul rendez-vous par jour avec chaque contact.",
                getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14 pad-24 text-gray']")).getText());
        assertTrue(getDriver().findElement(By.cssSelector("button.owl-prev")).isDisplayed());
    }

    public void thePageShowAcceptRefusePopup(){
        assertTrue(getDriver().findElement(By.cssSelector("div.confirm-message")).getText().contains(" vous propose un rendez-vous virtuel"));
        assertTrue(getDriver().findElement(By.cssSelector("a.read-more")).isDisplayed());
        assertTrue(getDriver().findElement(By.xpath("//button[text()='Refuser']")).isDisplayed());
        assertTrue(getDriver().findElement(By.xpath("//button[text()='Accepter']")).isDisplayed());
        assertTrue(getDriver().findElement(By.cssSelector("div.cup-icon-wrap")).isDisplayed());
    }

    public void theMessagePageShowObjectAtFirstThread(String object){
        assertEquals(object, getDriver().findElement(By.cssSelector("#sidebar--message-3559777 > div.message__content > div.message__body")).getText());
    }

//    public void thePageChangeToVirtualDateModeAtAccepter(String username, String password){
//
//        //check count down
//        assertTrue(getDriver().findElement(By.cssSelector(".cup-icon")).isDisplayed());
//        assertTrue(getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14']")).isDisplayed());
//        //check count down before/after 3s
//        String actualTime = getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14']")).getText();
//        System.out.println(actualTime);
//        commonPage.waitAboutSecond(3);
//        String after3Second = getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14']")).getText();
//        System.out.println(after3Second);
//        assertTrue(Integer.parseInt(actualTime.substring(10,12)) > Integer.parseInt(after3Second.substring(10,12)));
//
//        //check lock message thread design
//        assertTrue(getDriver().findElement(By.cssSelector("div.blockthread-icon")).isDisplayed());
//        assertEquals("Rendez-vous en cours avec "+getDriver().findElement(By.cssSelector("h1.name")).getText().toUpperCase(),
//                getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-16']")).getText());
//        assertEquals("Pour accéder aux autres conversations vous devez mettre fin au rendez-vous en cours !",
//                getDriver().findElement(By.cssSelector("p[class='size-14 text-gray']")).getText());
//    }
//
//    public void thePageChangeToVirtualDateModeAtSender(String username, String password){
//        commonPage.click("SignOutIcon");
//        commonPage.loginWithAccountAndPassword(username,password);
//        commonPage.click("Messages");
//        commonPage.click("FirstMessageInMessageThread");
//
//        //check count down
//        assertTrue(getDriver().findElement(By.cssSelector(".cup-icon")).isDisplayed());
//        assertTrue(getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14']")).isDisplayed());
//        //check count down before/after 3s
//        String actualTime = getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14']")).getText();
//        System.out.println(actualTime);
//        commonPage.waitAboutSecond(3);
//        String after3Second = getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14']")).getText();
//        System.out.println(after3Second);
//        assertTrue(Integer.parseInt(actualTime.substring(10,12)) > Integer.parseInt(after3Second.substring(10,12)));
//
//        //check lock message thread design
//        assertTrue(getDriver().findElement(By.cssSelector("div.blockthread-icon")).isDisplayed());
//        assertEquals("Rendez-vous en cours avec "+getDriver().findElement(By.cssSelector("h1.name")).getText().toUpperCase(),
//                getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-16']")).getText());
//        assertEquals("Pour accéder aux autres conversations vous devez mettre fin au rendez-vous en cours !",
//                getDriver().findElement(By.cssSelector("p[class='size-14 text-gray']")).getText());
//    }

    public void thePageChangeToVirtualDateMode(String username, String password){
        commonPage.click("SignOutIcon");
        commonPage.loginWithAccountAndPassword(username,password);
        commonPage.click("Messages");
        commonPage.click("FirstMessageInMessageThread");

        //check count down
        commonPage.waitUntilElementIsVisible(".cup-icon");
        assertTrue(getDriver().findElement(By.cssSelector(".cup-icon")).isDisplayed());
        assertTrue(getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14']")).isDisplayed());
        //check count down before/after 3s
        String actualTime = getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14']")).getText();
        System.out.println(actualTime);
        commonPage.waitAboutSecond(3);
        String after3Second = getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-14']")).getText();
        System.out.println(after3Second);
        assertTrue(Integer.parseInt(actualTime.substring(10,12)) > Integer.parseInt(after3Second.substring(10,12)));

        //check lock message thread design
        assertTrue(getDriver().findElement(By.cssSelector("div.blockthread-icon")).isDisplayed());
        assertEquals("Rendez-vous en cours avec "+getDriver().findElement(By.cssSelector("h1.name")).getText().toUpperCase(),
                getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-16']")).getText());
        assertEquals("Pour accéder aux autres conversations vous devez mettre fin au rendez-vous en cours !",
                getDriver().findElement(By.cssSelector("p[class='size-14 text-gray']")).getText());
    }

    public void showNotiInConversation(String noti){
        assertTrue(getDriver().findElement(By.cssSelector("div.chat__body-rows div.chat__row:last-of-type div.body-message")).getText().contains(noti));
    }

    public void showNotiInAlertThatContains(String noti){
        assertTrue(getDriver().findElement(By.cssSelector("div.already-had-virtualdate")).getText().contains(noti));
    }

    public void thePageRedirectToConversationWithAccountName(String name){
        commonPage.waitAboutSecond(3);
        assertEquals(name, getDriver().findElement(By.cssSelector("div.user-detail span ")).getText());
        assertTrue(getDriver().findElement(By.cssSelector("p[class='avenir-condensed size-16']")).getText().
                contains(name.toUpperCase()));
    }
    public void allowingMicroAccess() throws AWTException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        commonPage.waitUntilElementIsVisible("button.btn-send-text-wrapper");

    }

    public void allowingLocationAccess() throws AWTException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void warningBoxWithContentIsDisplayed(String content) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement waringbox = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.cssSelector("div.voice-warning-box p")));
        TestCase.assertEquals(waringbox.getText(), content);
    }

    public void checkVoiceMessageDisplayInThreadChatList() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement lastSentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.cssSelector("div.chat__body-rows>div:last-child")));
        commonPage.waitAboutSecond(2);
        WebElement duarationInList = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.cssSelector("div.message:first-of-type p")));
        commonPage.waitUntilElementIsVisible("div.message:first-of-type div.message__body-audio"); // voice message is displayed in thread chat list
        TestCase.assertEquals(getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-child div.time")).getText(), duarationInList.getText());
    }

    public void thePageShowPopUpRequestPostAtLeastAPicture() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.cssSelector("div.photo-info--modal.modal.is--opened p")));
        String text = "Elle a joué le jeu, elle a ajouté une photo, elle souhaite que ce soit réciproque. Ne ratez cette occasion, pour la contacter, ajoutez une photo !";
        String text1 = StringUtils.normalizeSpace(popup.getText());
        TestCase.assertEquals(text, text1 );
    }

    public void sendAVoiceMessageTo(String userName) {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.insertIntoField(userName, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.xpath("//div[@class='profile__content']//*[text() = '" + userName + "']")));
        account.click();
        commonPage.waitUntilElementIsVisible("Discuss");
        commonPage.click("Discuss");
        WebElement voiceButton = getDriver().findElement(org.openqa.selenium.By.cssSelector("a.btn-send-text-wrapper"));
        voiceButton.click();
        commonPage.waitAboutSecond(4);
        getDriver().findElement(org.openqa.selenium.By.cssSelector("button.btn-send-text-wrapper")).click();
    }

    public void checkTimeInCounterAndSentVoiceMessageLength() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        commonPage.waitUntilElementIsVisible("span.record-time");
        WebElement timeCounter = getDriver().findElement(org.openqa.selenium.By.cssSelector("span.record-time"));
        WebElement sendButton = getDriver().findElement(org.openqa.selenium.By.cssSelector("button.btn-send-text-wrapper"));
        String recordTime = timeCounter.getText();
        sendButton.click();
        WebElement sentVoiceMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(net.serenitybdd.core.annotations.findby.By.cssSelector("div.chat__body-rows>div:last-child div.time")));
        String sentVoiceMessageLength = sentVoiceMessage.getText();
        TestCase.assertEquals(recordTime, sentVoiceMessageLength);
    }

    public void sendingTimeAndRealtime() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);

        SimpleDateFormat time_formatter = new SimpleDateFormat("HH:mm");
        String realTime = time_formatter.format(System.currentTimeMillis());

        commonPage.waitAboutSecond(2);
        WebElement sendingtime = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-child span.time"));
        String sendingTime = sendingtime.getText();

        TestCase.assertEquals(sendingTime,realTime);
    }

    public void chooseCancelRecord() {
        // Check id of last message before and after cancel button
        WebElement lastMessage = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-child"));
        String id1 = lastMessage.getAttribute("id") ;
        commonPage.waitAboutSecond(2);
        commonPage.click("div#form-actions-chat>span");
        commonPage.waitAboutSecond(2);
        WebElement lastMessage2 = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-child"));
        String id2 = lastMessage.getAttribute("id") ;
        TestCase.assertEquals(id1,id2);
    }

    public void recordRandomSeconds() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int second = random.nextInt(1, 5);
        commonPage.waitAboutSecond(second);
    }

    public void findElementByXpathAndScrollToUserAndClick(String button) {
        String XPath = TestDataService.properties.getProperty(button);
        if (XPath == null) {
            XPath = button;
        }
        WebElement Element = getDriver().findElement(org.openqa.selenium.By.xpath(XPath));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", Element);
        Element.click();
        System.out.println(Element);
    }

    public void reportAVoiceMessageShouldSeePopupMessage() {
        WebElement lastMessage = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-child"));
        WebElement messageOption = lastMessage.findElement(org.openqa.selenium.By.cssSelector("div.message-options"));
        messageOption.click();
        WebElement reportAction = getDriver().findElement(org.openqa.selenium.By.cssSelector("a.report-action"));
        reportAction.click();
        commonPage.waitUntilElementIsVisible("div.modal--header.no-shadow");
        WebElement validateBtn = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.d-block>button"));
        validateBtn.click();
        commonPage.shouldSeeMessagePopupAtTop("Votre signalement sur le message vocal a bien été pris en compte");
        commonPage.waitAboutSecond(4);

        //Report the second time
        messageOption.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement reportAction1 = getDriver().findElement(org.openqa.selenium.By.cssSelector("a.report-action"));
        wait.until(ExpectedConditions.elementToBeClickable(net.serenitybdd.core.annotations.findby.By.cssSelector("a.report-action")));
        reportAction1.click();
        commonPage.waitUntilElementIsVisible("div.modal--header.no-shadow");
        WebElement validateBtn1 = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.d-block>button"));
        validateBtn1.click();
        commonPage.shouldSeeMessagePopupAtTop("Ce message vocal a déjà été signalé");
    }

    public void searchAccountAndGoToThreadChatDetail(String username) {
        // search account ""
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.waitUntilElementIsVisible("div[class='modal__main_footer inside-header']");
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.waitAboutSecond(1);
        commonPage.insertIntoField(username, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        commonPage.waitUntilElementIsVisible(".profile");
        commonPage.waitAboutSecond(2);

        // selectTheProfileHasNameThatWeAreSearching
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + username + "']")));
        account.click();

        commonPage.click("Discuss");
    }

    public void checkRecordEndWhenGoToOtherThreadAndComeback() {
        commonPage.waitUntilElementIsVisible("div.input-audio-wrapper");
        commonPage.waitUntilElementIsVisible("div#form-actions-chat>span");

        // send a voice message first
        recordRandomSeconds();
        commonPage.click("button.btn-send-text-wrapper");

        // record a voice message
        commonPage.click("a.btn-send-text-wrapper");
        commonPage.waitAboutSecond(4);

        // click secondThread in list
        WebElement secondThread = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.messages__body>div>div:nth-child(2)"));
        secondThread.click();

        //comeback first thread
        commonPage.waitAboutSecond(2);
        WebElement firstThread = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.messages__body>div>div:nth-child(1)"));
        firstThread.click();
        commonPage.waitUntilElementIsVisible("a.btn-send-text-wrapper");
    }

    public void checkRecordEndWhenOpenNewBrowserTab() throws AWTException {
        commonPage.click("a.btn-send-text-wrapper");
        commonPage.waitAboutSecond(3);
        Robot robot = new Robot();

        // open new browser tab
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        commonPage.waitAboutSecond(2);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_1);
        commonPage.waitAboutSecond(2);

        commonPage.waitUntilElementIsVisible("a.btn-send-text-wrapper");
    }

    public void checkRecordEndWhenRunInBackground() throws AWTException {
        commonPage.click("a.btn-send-text-wrapper");
        commonPage.waitAboutSecond(2);
        Robot robot = new Robot();

        // go to desktop
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_D);
        commonPage.waitAboutSecond(2);

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_TAB);
        commonPage.waitAboutSecond(2);

        commonPage.waitUntilElementIsVisible("a.btn-send-text-wrapper");
    }

    public void clickSeeUnreadMessageAndCheckNumberOfMessageWithBlueCounter() {
        commonPage.waitUntilElementIsVisible("div.messages__body");
        commonPage.click("a.btn-filter i");
        commonPage.click("ul.filter-options li:nth-child(2)");

        ArrayList<String> noMessageNoti = new ArrayList<>();
        ArrayList<WebElement> notiDisplay = new ArrayList<>(getDriver().findElements(By.cssSelector("div.no-items__inner>h4")));
        for (WebElement noti : notiDisplay) {
            String textOfNoti = noti.getText();
            noMessageNoti.add(textOfNoti);
        }
        if (notiDisplay.size() > 0 && noMessageNoti.contains("Aucun message non lu")) {
            getDriver().findElements(org.openqa.selenium.By.cssSelector("a[href='/main/messages'] span:nth-child(3)")).isEmpty();
            System.out.println("No Unread messages");

        }
        else {
            System.out.println("Have unread messages");
            ArrayList<WebElement> newMessage = new ArrayList<>(getDriver().findElements(By.cssSelector("div.message--unread")));
            WebElement blueCounter = getDriver().findElement(org.openqa.selenium.By.cssSelector("a[href='/main/messages'] span:nth-child(3)"));
            String numberInCounter = blueCounter.getText();
            if (newMessage.size() < 10) {
                assertEquals(Integer.toString(newMessage.size()), numberInCounter);
                System.out.println("Unread messages:" + numberInCounter);
            }
            else {
                assertEquals("10+",numberInCounter);
                System.out.println("Unread message: 10+");
            }
        }

    }
    public void replyLastGifMessageAndCheckSendSuccess() throws AWTException {
        WebElement lastGifMessage = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type"));
        String linkGifMessage = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type div.gif-wrapper img")).getAttribute("src").substring(0,43);
        String idOfLastVoiceMsg = lastGifMessage.getAttribute("id");
        String XPath = "//div[@id='"+ idOfLastVoiceMsg +"']//button";

        //Reply gif by a photo
        commonPage.clickOnTheElementIsByXpath(XPath);
        commonPage.click("a.reply-action");
        uploadEphemeralPicture();
        commonPage.waitAboutSecond(3);
        WebElement replyedGif1 = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type div.gif-wrapper-parent img"));
        String linkGif1 = replyedGif1.getAttribute("src").substring(0,43);
        assertEquals(linkGifMessage,linkGif1);
        sendingTimeAndRealtime();
        System.out.println("Reply a gif message by a photo >> OK");

        //Reply gif by a text
        commonPage.clickOnTheElementIsByXpath(XPath);
        commonPage.click("a.reply-action");
        commonPage.insertIntoField("Gif is very funny :D", "div.input-wrapper textarea");
        commonPage.click("button.btn-send-text-wrapper");
        WebElement replyedGif2 = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type div.gif-wrapper-parent img"));
        String linkGif2 = replyedGif2.getAttribute("src").substring(0,43);
        assertEquals(linkGifMessage,linkGif1);
        sendingTimeAndRealtime();
        System.out.println("Reply a gif message by a text >> OK");

        //Reply gif by a Gif
        commonPage.clickOnTheElementIsByXpath(XPath);
        commonPage.click("a.reply-action");
        commonPage.click("span.btn-send-gif.active");
        commonPage.click("div.gifs-slider label:nth-child(3)");
        commonPage.click("button.btn-send-text-wrapper");
        commonPage.waitAboutSecond(2);
        WebElement replyedGif3 = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type div.gif-wrapper-parent img"));
        String linkGif3 = replyedGif3.getAttribute("src").substring(0,43);
        assertEquals(linkGifMessage,linkGif1);
        sendingTimeAndRealtime();
        System.out.println("Reply a gif message by a gif >> OK");

        //Reply gif by a Voice
        commonPage.clickOnTheElementIsByXpath(XPath);
        commonPage.click("a.reply-action");
        commonPage.click("a.btn-send-text-wrapper");
        commonPage.waitAboutSecond(3);
        allowingMicroAccess();
        recordRandomSeconds();
        commonPage.click("button.btn-send-text-wrapper");
        commonPage.waitAboutSecond(2);
        WebElement replyedGif4 = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type div.gif-wrapper-parent img"));
        String linkGif4 = replyedGif4.getAttribute("src").substring(0,43);
        assertEquals(linkGifMessage,linkGif1);
        sendingTimeAndRealtime();
        System.out.println("Reply a gif message by a voice >> OK");
    }

    public void replyLastVoiceMessageAndCheckSendSuccess() throws AWTException {
        WebElement lastVoiceMessage = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type"));
        String timeFileAudio = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type div.time")).getText();
        String idOfLastVoiceMsg = lastVoiceMessage.getAttribute("id");
        String XPath = "//div[@id='"+ idOfLastVoiceMsg +"']//button";

        //Reply voice by a gif
        commonPage.clickOnTheElementIsByXpath(XPath);
        commonPage.click("a.reply-action");
        commonPage.click("span.btn-send-gif.active");
        commonPage.click("div.gifs-slider label:nth-child(3)");
        commonPage.click("button.btn-send-text-wrapper");
        commonPage.waitAboutSecond(2);
        WebElement replyedVoice1 = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type div.is-parent div.time"));
        String timeFileAudio1 = replyedVoice1.getText();
        assertEquals(timeFileAudio,timeFileAudio1);
        sendingTimeAndRealtime();
        System.out.println("Reply a voice message by a gif >> OK");


        // Reply voice by a photo
        commonPage.clickOnTheElementIsByXpath(XPath);
        commonPage.click("a.reply-action");
        uploadEphemeralPicture();
        commonPage.waitAboutSecond(2);
        WebElement replyedVoice2 = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type div.is-parent div.time"));
        String timeFileAudio2 = replyedVoice2.getText();
        assertEquals(timeFileAudio,timeFileAudio2);
        sendingTimeAndRealtime();
        System.out.println("Reply a voice message by a photo >> OK");

        // Reply voice by a text
        commonPage.clickOnTheElementIsByXpath(XPath);
        commonPage.click("a.reply-action");
        commonPage.insertIntoField("Your voice is very funny :D", "div.input-wrapper textarea");
        commonPage.click("button.btn-send-text-wrapper");
        WebElement replyedVoice3 = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type div.is-parent div.time"));
        String timeFileAudio3 = replyedVoice3.getText();
        assertEquals(timeFileAudio,timeFileAudio3);
        sendingTimeAndRealtime();
        System.out.println("Reply a voice message by a text >> OK");

        // Reply voice by a voice
        commonPage.clickOnTheElementIsByXpath(XPath);
        commonPage.click("a.reply-action");
        commonPage.click("a.btn-send-text-wrapper");
        recordRandomSeconds();
        commonPage.click("button.btn-send-text-wrapper");
        WebElement replyedVoice4 = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.chat__body-rows>div:last-of-type div.is-parent div.time"));
        String timeFileAudio4 = replyedVoice4.getText();
        assertEquals(timeFileAudio,timeFileAudio4);
        sendingTimeAndRealtime();
        System.out.println("Reply a voice message by a text >> OK");
    }

    public void allowingMicroAccessAfterCloseLocationPerrmisson() throws AWTException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        commonPage.waitAboutSecond(3);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        commonPage.waitUntilElementIsVisible("button.btn-send-text-wrapper");
    }

    public void thisMessageHaveFeelingIcon(){
        assertEquals( "😍",getDriver().findElement(By.cssSelector(".chat__row:last-child .feeled-icon")).getText());
    }

    public void thisMessageDontHaveFeelingIcon(){
        try{
            assertTrue(getDriver().findElement(By.cssSelector(".chat__row:last-child .feeled-icon")).isDisplayed());
            assertEquals(true, false);
        }catch (Exception e){
            System.out.println(e.getCause());
            assertEquals(true, true);
        }
    }

    public void theLastMessageIs(String text){
        assertEquals(text, getDriver().findElement(By.cssSelector(".chat__row:last-child .mes-body-text")).getText());
    }

    public void theReplyIconIsHide(){
        try{
            assertTrue(getDriver().findElement(By.cssSelector(".chat__row:last-child .reply-action")).isDisplayed());
            assertEquals(true, false);
        }catch (Exception e){
            System.out.println(e.getCause());
            assertEquals(true, true);
        }
    }

    public void theTextAndTheTimeThatHasBeenRepliedMustBeCorrect(){
        String messageText = getDriver().findElement(By.cssSelector(".chat__row:last-child .mes-body-text")).getText();

        assertEquals(messageText,
                getDriver().findElement(By.cssSelector(".chat__actions .message-body")).getText());

        assertEquals(getDriver().findElement(By.cssSelector(".chat__row:last-child .time")).getText(),
                getDriver().findElement(By.cssSelector(".chat__actions .date-time")).getText());

        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('messageText','" + messageText + "')");
        String idReceivedLastMess = getDriver().findElement(By.cssSelector(".chat__row:last-child")).getAttribute("id");
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('idReceivedLastMess','" + idReceivedLastMess + "')");

    }

    public void theReplyMessageIsSent(){
        //text just sent
        assertEquals("Reply by text", getDriver().findElement(By.cssSelector(".chat__row:last-child .mes-body-text")).getText());
    }

    public void clickOnReceivedMessage(){
        String idReceivedLastMess = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('idReceivedLastMess')");
        getDriver().findElement(By.cssSelector("div[id='"+idReceivedLastMess+"'] .message-options")).click();

        getDriver().findElement(By.cssSelector("div[id='"+idReceivedLastMess+"'] .reply-action")).click();
    }

    public void theReplyGifMessageIsSent(){
        //gif just sent
        assertEquals("GIPHY", getDriver().findElement(By.cssSelector(".chat__row:last-child .license-name span")).getText());

    }

    public void theReplyPhotoMessageIsSent(){
        //photo just sent
        assertEquals("image", getDriver().findElement(By.cssSelector(".chat__row:last-child div[class='ephemeral-placeholder ephemeral-placeholder--blue'] i")).getText());
    }

    public void theReplyVoiceMessageIsSent(){
        //voice just sent
        assertTrue(getDriver().findElement(By.cssSelector(".chat__row:last-child div.audio-message")).isEnabled());
    }

    public void theLastMessageJustSentIsImage(){
        assertTrue(getDriver().findElement(By.cssSelector(".chat__row:last-child div[class='ephemeral-placeholder ephemeral-placeholder--blue'] i")).isDisplayed());
        //if free time -> check date just sent
    }

    public void theImageAndTheTimeThatHasBeenRepliedMustBeCorrect(){

        assertEquals("[PHOTO]",
                getDriver().findElement(By.cssSelector(".chat__actions .message-body")).getText());

        assertEquals(getDriver().findElement(By.cssSelector(".chat__row:last-child .time")).getText(),
                getDriver().findElement(By.cssSelector(".chat__actions .date-time")).getText());

        String idReceivedLastMess = getDriver().findElement(By.cssSelector(".chat__row:last-child")).getAttribute("id");
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('idReceivedLastMess','" + idReceivedLastMess + "')");

    }

    public void theMessageIsRepliedThatIsText(){
        //text of message that has replied
        String messageText = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('messageText')");
        assertEquals(messageText, getDriver().findElement(By.cssSelector(".chat__row:last-child .message-body")).getText());
    }

    public void theMessageIsRepliedThatIsImage(){
        //image icon of message that has replied
        assertTrue(getDriver().findElement(By.cssSelector(".chat__row:last-child div.pic-icon")).isDisplayed());
    }

    //upd 8/9/2020
    public void clickOnLastThumbnailInConversation(){
        getDriver().findElement(By.cssSelector(".chat__row:last-child .chat__message-image")).click();
    }

    public void theTimeSendMessageIsCorrect(){
        //get time of system
        //System.out.println(java.time.LocalTime.now());
        String currentTime = String.valueOf(java.time.LocalTime.now()).substring(0,5);
        System.out.println(currentTime);

        //get time message just sent
        String sentMessTime = getDriver().findElement(By.cssSelector(".chat__row:last-child .time")).getText();

        assertEquals(currentTime, sentMessTime);

    }
}
