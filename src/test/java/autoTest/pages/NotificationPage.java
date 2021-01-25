package autoTest.pages;

import net.serenitybdd.core.annotations.findby.By;
import autoTest.service.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class NotificationPage extends PageObject {

    public void clickOnThePersonHaveAboveName(String name) {
        ArrayList<WebElement> searchList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li.profile--item > a.profile  > .profile__content > h5")));
        System.out.println("list search: " + searchList.size());
        searchList.get(0).click();
    }

    public void scrollAllPage(String element) {
        String cssSelector = TestDataService.properties.getProperty(element);
        System.out.println("selector is " + cssSelector);
        //scroll to get all user have choosed before
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        int itemLoaded = 0;
        int totalItems = getDriver().findElements(By.cssSelector(cssSelector)).size();
        System.out.println("total items to * 5000 are/is " + totalItems);
        int i = 1;
        while (itemLoaded < totalItems) {
            int intTo = i * 5000;
            js.executeScript("window.scrollTo(0," + intTo + ");");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            itemLoaded = totalItems;
            totalItems = getDriver().findElements(net.serenitybdd.core.annotations.findby.By.cssSelector(cssSelector)).size();
            i++;
        }
    }

    public void theGreenPointOfTheNotificationsAreDisplayed() {
        assertTrue(getDriver().findElement(By.cssSelector("span[class='mark green']")).isEnabled());
    }

    public void thePageReceviedARefusedPhotoNotification() {
        int count = 0;
        ArrayList<WebElement> contentNoti = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component > div.notification-item > div.notification-item__wrapper > div.notification--center > div.notification__content > p > strong")));
        for (WebElement content : contentNoti) {
            if (content.getText().contains("Votre photo a été refusée")) {
                count = 1;
                System.out.println("passed check recevied refuse photo notification!");
                break;
            }
        }
        if (count == 0) {
            assertEquals("ERROR", "ERROR1");
        }
    }

    public void clickingOnANotificationOfSmile() {
        int count = 0;
        //click on the first icon pink and save name of noti profile
        ArrayList<WebElement> notiList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component > div.notification-item > div.notification-item__wrapper > div.notification--center ")));
        for (WebElement noti : notiList) {
            try {
                System.out.println(noti);
                System.out.println(noti.toString());
                noti.findElement(By.cssSelector("div.notification__content > p > span[class='icon icon--pink']")).isEnabled();
                WriteToFile(noti.findElement(By.cssSelector("notification__meta > h5")).getText());
                noti.findElement(By.cssSelector("div.notification__content > p > span[class='icon icon--pink'] > strong")).click();
                count = 1;
                break;
            } catch (Exception e) {
                continue;
            }
        }
        if (count == 0) {
            System.out.println("Dont have any noti of smile");
        }
    }

    public void WriteToFile(String value) {
        try {
            FileWriter fw = new FileWriter("varFile.txt", false);
            fw.write(value);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success save...");
    }

    public void thePageRedirectToPageOfProfile() {
        //?? Do this affect with another step when dont have size???
        int size = 0;
        try {
            size = Integer.parseInt(ReadFromFile());
            if (size == 0) {
                return;
            }
        } catch (Exception e) {
            //none
        }
        Assert.assertTrue(getDriver().getCurrentUrl().contains("https://www.mektoube.fr/main/profil/"));
        //Assert.assertTrue(getDriver().getCurrentUrl().contains("https://www.mektoube.fr/main/profil/"));
    }

    public String ReadFromFile() throws Exception {
        FileReader fr = new FileReader("varFile.txt");
        int i;
        String var = "";
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
            var = var + (char) i;
        }
        fr.close();
        return var;
    }

    public void nameOfNotificationMustEqualWithNameInProfile() {
        try {
            String nameNoti = ReadFromFile();
            assertEquals(nameNoti, getDriver().findElement(By.cssSelector("div.user__meta > h1")).getText().toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickingOnANotificationOfVisit() {
        int count = 0;
        //click on the first icon blue and save name of noti profile
        ArrayList<WebElement> notiList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component > div.notification-item > div.notification-item__wrapper > div.notification--center ")));
        for (WebElement noti : notiList) {
            try {
                noti.findElement(By.cssSelector("div.notification__content > p > span[class='icon icon--blue']")).isEnabled();
                WriteToFile(noti.findElement(By.cssSelector("notification__meta > h5")).getText());
                noti.findElement(By.cssSelector("div.notification__content > p > span[class='icon icon--blue'] > strong")).click();
                count = 1;
                break;
            } catch (Exception e) {
                continue;
            }
        }
        if (count == 0) {
            System.out.println("Dont have any noti of visit");
        }
    }

    public void thePageShowAllNotificationsThatAreSmileNoti() {
        ArrayList<WebElement> notiList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component > div.notification-item > div.notification-item__wrapper > div.notification--center > div.notification__content > p")));
        for (WebElement noti : notiList) {
            Assert.assertTrue(noti.findElement(By.cssSelector("span[class='icon icon--pink']")).isEnabled());
        }
    }

    public void thePageShowAllNotificationsThatAreVisitNoti() {
        ArrayList<WebElement> notiList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component > div.notification-item > div.notification-item__wrapper > div.notification--center > div.notification__content > p")));
        for (WebElement noti : notiList) {
            Assert.assertTrue(noti.findElement(By.cssSelector("span[class='icon icon--blue']")).isEnabled());
        }
    }

    public void thePageShowAllNotificationsThatAreAllNotis() {
        ArrayList<WebElement> notiList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component > div.notification-item > div.notification-item__wrapper > div.notification--center > div.notification__content > p")));
        ArrayList<WebElement> refuseNotiList = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification__content > p > .icon.icon--refused")));
        ArrayList<WebElement> visitNotiList = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification__content > p > .icon.icon--blue")));
        ArrayList<WebElement> smileNotiList = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification__content > p > .icon.icon--pink")));
        assertEquals(notiList.size(), refuseNotiList.size() + visitNotiList.size() + smileNotiList.size());
    }

    public void clickOnANotificationOfVisitInRealTime() {
        int count = 0;
        //click on the visit noti that is online
        ArrayList<WebElement> notiList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component > div.notification-item > div.notification-item__wrapper ")));
        for (WebElement noti : notiList) {
            try {
                if (noti.findElement(By.cssSelector("div.notification__avatar > div.status.status--online ")).isEnabled() && noti.findElement(By.cssSelector("div.notification__content > p > span[class='icon icon--blue']")).isEnabled()) {
                    WriteToFile(noti.findElement(By.cssSelector("div.notification--center > .notification__meta > h5")).getText());
                    noti.findElement(By.cssSelector("div.notification__avatar > div.status.status--online ")).click();
                    count = 1;
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }
        if (count == 0) {
            System.out.println("Dont have any visit noti that is online");
        }
    }

    public void theProfileMustHaveGreenPoint() {

    }

    public void clickOnANotificationOfSmileInRealTime() {
        int count = 0;
        //click on the visit noti that is online
        ArrayList<WebElement> notiList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component > div.notification-item > div.notification-item__wrapper ")));
        for (WebElement noti : notiList) {
            try {
                if (noti.findElement(By.cssSelector("div.notification__avatar > div.status.status--online ")).isEnabled() && noti.findElement(By.cssSelector("div.notification__content > p > span[class='icon icon--pink']")).isEnabled()) {
                    WriteToFile(noti.findElement(By.cssSelector("div.notification--center > .notification__meta > h5")).getText());
                    noti.findElement(By.cssSelector("div.notification__avatar > div.status.status--online ")).click();
                    count = 1;
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }
        if (count == 0) {
            System.out.println("Dont have any smile noti that is online");
        }
    }

    public void thePageReceviedAAcceptPhotoNotification() {
        ArrayList<WebElement> contentNoti = new ArrayList<>(getDriver().findElements(By.cssSelector("div.infinite-scroll-component > div.notification-item > div.notification-item__wrapper > div.notification--center > div.notification__content > p > strong")));
        int count = 0;
        for (WebElement content : contentNoti) {
            if (content.getText().contains("Votre photo a été validé")) {
                count = 1;
                System.out.println("passed check recevied refuse photo notification!");
                break;
            }
        }
        if (count == 0) {
            assertEquals("ERROR", "ERROR1");
        }
    }

    public void clickOnTheElementIsIfNotYetChecked(String element) {
        String cssSelector = TestDataService.properties.getProperty(element);
        if (getDriver().findElement(By.cssSelector(cssSelector)).isSelected()) {
            return;
        } else {
            getDriver().findElement(By.cssSelector(cssSelector)).click();
        }
    }

    public void thePageShowGreenNotificationIsAt(String greenMess, String element) {
        String cssSelector = TestDataService.properties.getProperty(element);
        if (cssSelector == null) {
            cssSelector = element;
        }
        assertEquals(greenMess, getDriver().findElement(By.cssSelector(cssSelector)).getText());
    }

    public void thePageShowsFirstVisitNotificationIs(String name) {
        //// not yet

    }


    public void clickMessageButtonInFirstNotificationInNotiPage() {
        ArrayList<WebElement> listNotification = new ArrayList<>(getDriver().findElements(By.cssSelector("div.notification-item")));
        WebElement msgButtonInFirstNoti = listNotification.get(0).findElement(org.openqa.selenium.By.cssSelector("div.option-list span:nth-child(1)"));
        msgButtonInFirstNoti.click();
    }
}
