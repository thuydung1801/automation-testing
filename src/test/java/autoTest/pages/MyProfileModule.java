package autoTest.pages;

import autoTest.service.TestDataService;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import static io.restassured.RestAssured.get;
import static junit.framework.TestCase.assertTrue;

import autoTest.model.Statistic;
import autoTest.steps.serenity.MektoubeCommonEndUserSteps;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyProfileModule extends PageObject {
    MektoubeCommonPage commonPage = new MektoubeCommonPage();
    ContactRequestPage contactRequestPage = new ContactRequestPage();
    NotificationPage notiPage = new NotificationPage();

    public void uploadPictureAgain() throws AWTException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='upload-action']")));
        fileInput.click();

        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String text = System.getProperty("user.dir") + "\\src\\test\\resources\\data_test\\testPicture.jpg";
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        try {
            Thread.sleep(4 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        robot.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
        robot.keyRelease(KeyEvent.VK_ENTER);
        try {
            Thread.sleep(1 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void removeAccountFromBlackList() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement remove = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".blocklist-item:nth-child(1) i[class='remove-action material-icons']")));
        remove.click();
        getDriver().findElement(By.cssSelector("a[class='remove-action']")).click();
    }

    public Response makeGetRequest(String url) {
        JavascriptExecutor jsExcute = (JavascriptExecutor) getDriver();
        String puk = (String) jsExcute.executeScript("return localStorage.getItem('puk')");
        System.out.println(puk);
        String token = (String) jsExcute.executeScript("return localStorage.getItem('token')");
        Response response = given()
                .baseUri(url)
                .queryParam("full", "1")
                .queryParam("frontend", "1")
                .header("Content-Type", "application/json, text/plain, */*")
                .header("Accept", "application/json, text/plain, */*")
                .header("x-asgard-puk", puk)
                .header("x-asgard-token", token)
                .when()
                .get(url);
        return response;
    }

    public Statistic getStatisticFromHTML() {
        commonPage.waitUntilElementIsVisible(".list-stats > li:nth-child(1) .stat__meta.hidden-xs h2");
        int smileCount = Integer.parseInt(getDriver().findElement(By.cssSelector(".list-stats > li:nth-child(1) .stat__meta.hidden-xs h2")).getText());
        System.out.println(smileCount);
        int viewCount = Integer.parseInt(getDriver().findElement(By.cssSelector(".list-stats > li:nth-child(2) .stat__meta.hidden-xs h2")).getText());
        int onlineFavouriteCount = Integer.parseInt(getDriver().findElement(By.cssSelector(".list-stats > li:nth-child(3) .stat__meta.hidden-xs h2")).getText());
        Statistic statistic = new Statistic(smileCount, viewCount, onlineFavouriteCount);
        return statistic;
    }

    public Statistic getStatisticFromAPI() {
        Response response = makeGetRequest("https://www.mektoube.fr/api/pond/shainez29");
        System.out.println(response.getBody());
        System.out.println("Response Body is: " + response.getBody().asString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        int smileCount = jsonPathEvaluator.get("CONTENT.STATISTICS.smileTotal") instanceof String ? Integer.parseInt(jsonPathEvaluator.get("CONTENT.STATISTICS.smileTotal")) : jsonPathEvaluator.get("CONTENT.STATISTICS.smileTotal");
        int viewCount = jsonPathEvaluator.get("CONTENT.STATISTICS.viewTotal") instanceof String ? Integer.parseInt(jsonPathEvaluator.get("CONTENT.STATISTICS.viewTotal")) : jsonPathEvaluator.get("CONTENT.STATISTICS.viewTotal");
        int onlineFavouriteCount = jsonPathEvaluator.get("CONTENT.STATISTICS.starOnline") instanceof String ? Integer.parseInt(jsonPathEvaluator.get("CONTENT.STATISTICS.starOnline")) : jsonPathEvaluator.get("CONTENT.STATISTICS.starOnline");
        Statistic statistic = new Statistic(smileCount, viewCount, onlineFavouriteCount);
        return statistic;
    }

    public boolean buttonPasswordVisibleShouldWork() {
        commonPage.waitUntilElementIsVisible("input[name='current_password']");
        WebElement eyeButton = getDriver().findElement(By.cssSelector("input[name='current_password']"));
        String eyeButtonAttribute = eyeButton.getAttribute("type");
        if (eyeButtonAttribute.contentEquals("text")) {
            return true;
        }
        System.out.println(eyeButtonAttribute);
        return false;
    }

    public boolean settingModalIsClosed() {
        ArrayList<WebElement> settingModal = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='setting--modal modal-480 modal is--opened']")));
        if (settingModal.size() > 0) {
            System.out.println(settingModal.size());
            return false;
        }
        System.out.println(settingModal.size());
        return true;
    }

    public boolean shouldSeeModalExplanationOfThePhotoFilter() {
        ArrayList<WebElement> picture = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='modal--body'] img[src='/images/temp/photo_filter_infos_woman.png']")));
        if (picture.size() == 0) {
            System.out.println(picture);
            return false;
        }
        WebElement content = getDriver().findElement(By.cssSelector(".modal--body p"));
        String contentOfElement = content.getText();
        if (!contentOfElement.contentEquals("Ne soyez contactée que par les hommes ayant une photo de profil !\n" +
                "\n" +
                "S’ils n’en possèdent pas, nous les informons que vous exigez une photo \n" +
                "\n" +
                "Attention, pour profiter de cette fonctionnalité vous devez, vous aussi, posséder une photo !")) {
            System.out.println(contentOfElement);
            return false;
        }
        System.out.println(contentOfElement);
        return true;
    }

    public boolean buttonFilterPhotoRemainTurnOff() {
        WebElement filterButton = getDriver().findElement(By.cssSelector("div[class='filter__item']:nth-child(3) input[id='onlyPict']"));

        if (filterButton.isSelected()) {
            System.out.println(filterButton.getAttribute("checked") + " checked");
            return false;
        }
        System.out.println(filterButton.getAttribute("checked") + " empty");
        return true;
    }

    public boolean activePhotoFilterButton() {
        WebElement filterButton = getDriver().findElement(By.cssSelector("div[class='filter__item']:nth-child(3) input[id='onlyPict']"));

        if (filterButton.isSelected()) {

            System.out.println(filterButton.getAttribute("checked") + " checked");
            return true;
        } else {
            filterButton.click();
            WebElement popupErrorMsgElements = getDriver().findElement(By.cssSelector("div.top-message-text"));
            String popupErrorMsgElementText = popupErrorMsgElements.getText();
            System.out.println(popupErrorMsgElementText);
            if (popupErrorMsgElementText.contentEquals("Vos préférences ont été mises à jour")) {
                return true;
            }
            System.out.println(popupErrorMsgElementText);
            return false;
        }

    }

    public boolean shouldSeeModalExplainAboutNeedToAddPhoto() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> modal = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='photo-info--modal modal is--opened']"))));
        if (modal.size() > 0) {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".photo-info--modal.modal.is--opened div[class='modal--body'] p")));
            String messageText = message.getText();
            if (messageText.contentEquals("Elle a joué le jeu, elle a ajouté une photo, elle souhaite que ce soit réciproque.\n" +
                    "\n" +
                    "Ne ratez cette occasion, pour la contacter, ajoutez une photo !")) {
                System.out.println(messageText);
                return true;
            }
            return false;

        }
        return false;

    }

    public boolean deactivePhotoFilterButton() {
        WebElement filterButton = getDriver().findElement(By.cssSelector(".list-settings input[id='onlyPict']"));

        if (filterButton.isSelected()) {
            filterButton.click();
            WebElement popupErrorMsgElements = getDriver().findElement(By.cssSelector("div.top-message-text"));
            String popupErrorMsgElementText = popupErrorMsgElements.getText();
            System.out.println(popupErrorMsgElementText);
            if (popupErrorMsgElementText.contentEquals("Vos préférences ont été mises à jour")) {
                return true;
            }
            System.out.println(popupErrorMsgElementText);
            return false;

        } else {
            System.out.println(filterButton.getAttribute("checked") + " ok, this button is remain deactive");
            return true;
        }
    }

    public boolean shouldSeeTextAreaIsDisable() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        getDriver().findElement(By.cssSelector("div.filter div.filter__item:nth-child(1)")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea.white.edit-summary-textarea")));
        if (textArea.isEnabled()) {
            System.out.println(getDriver().findElement(By.cssSelector("textarea.white.edit-summary-textarea")).getAttribute("disabled") + " fail");
            return false;
        }
        System.out.println(getDriver().findElement(By.cssSelector("textarea.white.edit-summary-textarea")).getAttribute("disabled") + " pass");
        getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();
        return true;
    }

    public boolean checkIfInformationWeSelectedIsDisplayedCorrectlyInProfile() {
        ArrayList<WebElement> editFieldList = new ArrayList<>(getDriver().findElements(By.cssSelector(".filter__item")));

        ArrayList<WebElement> firstSectionGroupDisplayItemList = new ArrayList<>(getDriver().findElements(By.cssSelector(".section__group:nth-child(1) ul.list-text li")));
        ArrayList<WebElement> secondSectionGroupDisplayItemList = new ArrayList<>(getDriver().findElements(By.cssSelector(".section__group:nth-child(2) ul.list-text li")));

        firstSectionGroupDisplayItemList.addAll(secondSectionGroupDisplayItemList);

        ArrayList<WebElement> displayList = firstSectionGroupDisplayItemList;

        for (int i = 0; i < editFieldList.size(); i++) {

            String editItemName = editFieldList.get(i).findElement(By.cssSelector("h5")).getText();

            String editItemValue = editFieldList.get(i).findElement(By.cssSelector("span.value-text")).getText();

            if (editItemName.contentEquals("Mon accroche")) { // case edit item is introduction
                ArrayList<WebElement> introductionElements = new ArrayList<>(getDriver().findElements(By.cssSelector(".section__body blockquote.profile-quote p")));
                editFieldList.get(i).click();
                try {
                    Thread.sleep(2 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String contentOfIntroduction = getDriver().findElement(By.cssSelector("textarea.white.edit-summary-textarea")).getText();
                if (introductionElements.size() > 0 && !introductionElements.get(0).getText().contentEquals(contentOfIntroduction)) {
                    System.out.println(introductionElements.get(0).getText() + " " + "Failed because of introduction miss match" + " " + contentOfIntroduction);
                    return false;
                }
                System.out.println(introductionElements + "Introduction validation success");
                getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();

            } else if (editItemName.contentEquals("Anniversaire")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate birthdate = LocalDate.parse(editItemValue, formatter);//specify year, month, date directly

                LocalDate currentDate = LocalDate.now(); //gets localDate
                Period diff = Period.between(birthdate, currentDate); //difference between the dates is calculated

                WebElement displayAgeElement = getDriver().findElement(By.cssSelector(".list-complex li:nth-child(1) h2"));

                int displayAge = Integer.parseInt(displayAgeElement.getText().split("\n")[0]);

                if (displayAge != diff.getYears()) {
                    System.out.println("Age validation failed");
                    return false;
                }
                System.out.println(diff.getYears() + " years");
            } else if (editItemName.contentEquals("Taille")) {
                String tall = getDriver().findElement(By.cssSelector("ul.list-complex li:nth-child(2) h2")).getText();
                if (editItemValue.contains("00")) {
                    if (!editItemValue.replace("00 cm", "").contentEquals(tall.replace(",", "").replace("\n" +
                            "mètres", ""))) {
                        System.out.println(editItemValue.replace("00 cm", "") + " " + tall.replace(",", "").replace("\n" +
                                "mètres", "") + " fail at Taille field");
                        return false;
                    }
                    System.out.println(editItemValue.replace("00 cm", "") + " " + tall.replace(",", "").replace("\n" +
                            "mètres", "") + " pass at Taille field");
                }
                if (editItemValue.contains("10") || editItemValue.contains("20") || editItemValue.contains("30") || editItemValue.contains("40") || editItemValue.contains("50")
                        || editItemValue.contains("60") || editItemValue.contains("70") || editItemValue.contains("80") || editItemValue.contains("90")) {
                    if (!editItemValue.replace("0 cm", "").contentEquals(tall.replace(",", "").replace("\n" +
                            "mètres", ""))) {
                        System.out.println(editItemValue.replace("0 cm", "") + " " + tall.replace(",", "").replace("\n" +
                                "mètres", "") + " fail at Taille field");
                        return false;
                    }
                    System.out.println(editItemValue.replace("0 cm", "") + " " + tall.replace(",", "").replace("\n" +
                            "mètres", "") + " pass at Taille field");
                } else {
                    if (!editItemValue.replace(" cm", "").contentEquals(tall.replace(",", "").replace("\n" +
                            "mètres", ""))) {
                        System.out.println(editItemValue.replace(" cm", "") + " " + tall.replace(",", "").replace("\n" +
                                "mètres", "") + " fail at Taille field");
                        return false;
                    }
                    System.out.println(editItemValue.replace(" cm", "") + " " + tall.replace(",", "").replace("\n" +
                            "mètres", "") + " pass at Taille field");
                }


            } else if (editItemName.contentEquals("Localisation")) {
                String habitat = getDriver().findElement(By.cssSelector("ul.list-text li:nth-child(2) span")).getText();
                if (!editItemValue.contentEquals(habitat)) {
                    return false;
                }
                System.out.println(" pass at Habitat field: " + editItemValue + " " + habitat);
            } else {
                for (int j = 0; j < displayList.size(); j++) {

                    String displayItemName = displayList.get(j).findElement(By.cssSelector("strong")).getText();

                    String displayItemValue = displayList.get(j).findElement(By.cssSelector("span")).getText();

                    if (editItemName.contentEquals(displayItemName.replace(" :", ""))) {
                        if (!editItemValue.contentEquals(displayItemValue)) {
                            System.out.println(editItemName + " " + editItemValue + " " + displayItemName + " " + displayItemValue + " fail because value is not same" + " " + i + " " + j);
                            return false;
                        }
                        System.out.println(i + " " + j);
                        System.out.println(" pass at field: " + editItemName + ": " + editItemValue + " " + displayItemValue);
                    }
                }
            }
        }
        return true;
    }

    public boolean leaveAllEditProfileFieldsEmptyAndClickValidate() {
        commonPage.waitUntilElementIsVisible(".filter:nth-child(2)");
        ArrayList<WebElement> emptyFields = new ArrayList<>(getDriver().findElements(By.cssSelector(".filter__item-aside span.value-text.is-red")));
        System.out.println(emptyFields.size());
        for (int i = 0; i < emptyFields.size(); i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView()", emptyFields.get(i));
            emptyFields.get(i).click();
            commonPage.waitUntilElementIsVisible("div[class='setting--modal filter--modal modal is--opened']");

            String question = getDriver().findElement(By.cssSelector(".modal__header h4")).getText();

            if (question.contentEquals("Mon accroche")) {
                commonPage.waitUntilElementIsVisible("button.modal-circle-check-btn");
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
                String popupErrorMsgElementText = popupErrorMsgElements.getText();
                if (!popupErrorMsgElementText.contentEquals("Le champ est vide")) {
                    System.out.println(i + " " + question + " " + popupErrorMsgElementText);
                    return false;
                }
                commonPage.waitUntilElementIsVisible("a.closer i.material-icons");
                getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();
            } else if (question.contentEquals("Combien mesurez-vous ?")) {
                commonPage.waitUntilElementIsVisible("a.closer i.material-icons");
                getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();
            } else {
                commonPage.waitUntilElementIsVisible("button.modal-circle-check-btn");
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
                String popupErrorMsgElementText = popupErrorMsgElements.getText();
                System.out.println(popupErrorMsgElementText + " " + i);
                if (!popupErrorMsgElementText.contentEquals("Sélectionnez un champ pour valider")) {
                    System.out.println(i + " " + question + " " + popupErrorMsgElementText);
                    return false;
                }
                commonPage.waitUntilElementIsVisible("a.closer i.material-icons");
                getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();
            }
        }
        emptyFields = new ArrayList<>(getDriver().findElements(By.cssSelector(".filter__item-aside span.value-text.is-red")));
        System.out.println(emptyFields.size());
        return true;
    }

    public boolean fillAllEmptyFields() {
        ArrayList<WebElement> emptyFields = new ArrayList<>(getDriver().findElements(By.cssSelector(".filter__item-aside span.value-text.is-red")));

        System.out.println(emptyFields.size());
        for (int i = 0; i < emptyFields.size(); i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView()", emptyFields.get(i));
            emptyFields.get(i).click();
            commonPage.waitUntilElementIsVisible(".modal__header h4");
            String question = getDriver().findElement(By.cssSelector(".modal__header h4")).getText();
            if (question.contentEquals("Combien mesurez-vous ?")) {
                String tallValueText = getDriver().findElement(By.cssSelector("span.handle-value")).getText();

                int j = Integer.parseInt(tallValueText.replace(" cm", ""));
                System.out.println(j);

                if (j <= 185) {

                    for (j = Integer.parseInt(tallValueText.replace(" cm", "")); j <= 184; j++) {
                        System.out.println(j + " đã nhảy vào đây 1");
                        getDriver().findElement(By.cssSelector("div[class='rc-slider-handle']")).sendKeys(Keys.ARROW_UP);

                    }
                }
                if (j > 185) {

                    System.out.println(j + " đã nhảy vào đây 2");
                    for (j = Integer.parseInt(tallValueText.replace(" cm", "")); j > 185; j--) {
                        getDriver().findElement(By.cssSelector("div[class='rc-slider-handle']")).sendKeys(Keys.ARROW_DOWN);

                    }
                }
                tallValueText = getDriver().findElement(By.cssSelector("span.handle-value")).getText();

                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();

                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementText = popupErrorMsgElements.getText();
                System.out.println(popupErrorMsgElementText);
                if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                    System.out.println("fail hàm chiều cao " + question + i);
                    return false;
                }
                System.out.println("pass hàm chiều cao " + tallValueText + question + i);
                emptyFields.get(i).click();
                System.out.println(" đã click lại " + i);
                try {
                    Thread.sleep(2 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ArrayList<WebElement> popupErrorMsgElementsExist = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
                if (popupErrorMsgElementsExist.size() > 0) {
                    System.out.println(popupErrorMsgElementsExist + " error message still appear");
                    return false;
                }
                getDriver().findElement(By.cssSelector(".closer .material-icons")).click();

            } else if (question.contentEquals("Style") || question.contentEquals("Habitudes Alimentaires") || question.contentEquals("Langues") || question.contentEquals("Domicile")
                    || question.contentEquals("Caractères") || question.contentEquals("Sports pratiqués")) {
                getDriver().findElement(By.cssSelector("#checkbox-control-1 input[type='checkbox']")).click();
                getDriver().findElement(By.cssSelector("#checkbox-control-2 input[type='checkbox']")).click();
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();

                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementText = popupErrorMsgElements.getText();
                System.out.println(popupErrorMsgElementText);
                if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                    System.out.println("fail hàm check box " + question + i);
                    return false;
                }
                System.out.println("pass hàm check box " + question + i);
                emptyFields.get(i).click();
                System.out.println(" đã click lại " + i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ArrayList<WebElement> popupErrorMsgElementsExist = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
                if (popupErrorMsgElementsExist.size() > 0) {
                    System.out.println(popupErrorMsgElementsExist + " error message still appear");
                    return false;
                }
                getDriver().findElement(By.cssSelector(".closer .material-icons")).click();


            } else if (question.contentEquals("Mon accroche")) {
                getDriver().findElement(By.cssSelector("textarea.white.edit-summary-textarea")).sendKeys("Salam à tous !\n" +
                        "J'aimerais faire une belle rencontre pour me marier.\n" +
                        "Depuis quelques année, ma carrière était ma priorité, donc je n'ai pas eu le temps de faire de rencontres !\n" +
                        "Voici le temps de mettre sa vie privée en first one !!");
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementText = popupErrorMsgElements.getText();
                System.out.println(popupErrorMsgElementText);
                if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                    System.out.println("pass hàm Mon Accroche " + question + i);
                    return false;

                }

                emptyFields.get(i).click();
                System.out.println(" đã click lại " + i);
                commonPage.waitUntilElementIsVisible("div[class='setting--modal filter--modal modal is--opened']");
                ArrayList<WebElement> popupErrorMsgElementsExist = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
                if (popupErrorMsgElementsExist.size() > 0) {
                    System.out.println(popupErrorMsgElementsExist + " error message still appear");
                    return false;
                }
                getDriver().findElement(By.cssSelector(".closer .material-icons")).click();


            } else {
                commonPage.waitUntilElementIsVisible("div[class='setting--modal filter--modal modal is--opened']");
                getDriver().findElement(By.cssSelector("div[role='radiogroup'] input[value='1']")).click();
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementText = popupErrorMsgElements.getText();
                System.out.println(popupErrorMsgElementText);
                if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                    System.out.println("pass hàm radio " + question + i);
                    return false;
                }
                System.out.println("pass hàm radio " + question + i);
                emptyFields.get(i).click();
                System.out.println(" đã click lại " + i);
                commonPage.waitUntilElementIsVisible("div[class='setting--modal filter--modal modal is--opened']");
                ArrayList<WebElement> popupErrorMsgElementsExist = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
                if (popupErrorMsgElementsExist.size() > 0) {
                    System.out.println(popupErrorMsgElementsExist + " error message still appear");
                    return false;
                }
                getDriver().findElement(By.cssSelector(".closer .material-icons")).click();


            }
        }
        return true;
    }

    public boolean editMyProfileAgain() {

        ArrayList<WebElement> editProfileField = new ArrayList<>(getDriver().findElements(By.cssSelector(".filter__item")));
        System.out.println(editProfileField.size());
        for (int i = 0; i < editProfileField.size(); i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView()", editProfileField.get(i));
            editProfileField.get(i).click();
            commonPage.waitUntilElementIsVisible("div[class='setting--modal filter--modal modal is--opened']");

            String question = getDriver().findElement(By.cssSelector(".modal__header h4")).getText();
            if (question.contentEquals("Mon accroche")) {
                commonPage.waitUntilElementIsVisible("a.closer i.material-icons");
                getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();
                System.out.println("pass hàm Mon accroche" + question + " " + 1);
            } else if (question.contentEquals("Anniversaire")) {
                commonPage.waitUntilElementIsVisible("div[class='field--date-input']");
                String birthDayYear = getDriver().findElement(By.cssSelector("input[placeholder='AAAA']")).getAttribute("value");
                System.out.println(birthDayYear);
                getDriver().findElement(By.cssSelector(".input-group div:nth-child(1) input[placeholder='JJ']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);

                getDriver().findElement(By.cssSelector(".input-group div:nth-child(3) input[placeholder='MM']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);

                getDriver().findElement(By.cssSelector(".input-group div:nth-child(5) input[placeholder='AAAA']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
                String popupErrorMsgElementText = popupErrorMsgElements.getText();
                if (!popupErrorMsgElementText.contentEquals("Le champ est vide")) {
                    return false;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("input[placeholder='JJ']")).sendKeys("31");
                getDriver().findElement(By.cssSelector("input[placeholder='MM']")).sendKeys("11");
                getDriver().findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1997");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
                String popupErrorMsgElementText2 = popupErrorMsgElements.getText();
                if (!popupErrorMsgElementText2.contentEquals("Merci de renseigner une date valide")) {
                    return false;
                }
                getDriver().findElement(By.cssSelector("input[placeholder='JJ']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
                getDriver().findElement(By.cssSelector("input[placeholder='MM']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
                getDriver().findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("input[placeholder='JJ']")).sendKeys("-h");
                if (!getDriver().findElement(By.cssSelector("input[placeholder='JJ']")).getAttribute("value").contentEquals("")) {
                    return false;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                getDriver().findElement(By.cssSelector("input[placeholder='JJ']")).sendKeys("31");
                getDriver().findElement(By.cssSelector("input[placeholder='MM']")).sendKeys("10");


                int year = Integer.parseInt(birthDayYear);

                String valueOfYear = String.valueOf(year - 1);
                System.out.println(valueOfYear);
                getDriver().findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys(valueOfYear);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                WebElement popupErrorMsgElementsAtTop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementTextAtTop = popupErrorMsgElementsAtTop.getText();
                if (!popupErrorMsgElementTextAtTop.contentEquals("Votre profil a été mis à jour")) {
                    return false;
                }
                System.out.println("pass hàm birthday " + question + " " + i);

            } else if (question.contentEquals("Combien mesurez-vous ?")) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                for (int j = 0; j < 2; j++) {

                    getDriver().findElement(By.cssSelector("div[class='rc-slider-handle']")).sendKeys(Keys.ARROW_DOWN);
                }
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElementsAtTop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementTextAtTop = popupErrorMsgElementsAtTop.getText();
                if (!popupErrorMsgElementTextAtTop.contentEquals("Votre profil a été mis à jour")) {
                    return false;
                }
                System.out.println("pass hàm chiều cao " + question + " " + i);

            } else if (question.contentEquals("Où habitez-vous ?")) {
                commonPage.waitUntilElementIsVisible(".field--choosen__main");
                getDriver().findElement(By.cssSelector(".field--choosen__main")).click();
                commonPage.waitUntilElementIsVisible("div[role='radiogroup']");
                getDriver().findElement(By.cssSelector("div[role='radiogroup'] label:last-child input[type='radio']")).click();
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                commonPage.waitUntilElementIsVisible("div[role='radiogroup']");
                getDriver().findElement(By.cssSelector("div[role='radiogroup'] label:last-child input[type='radio']")).click();
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                commonPage.waitUntilElementIsVisible("div[role='radiogroup']");
                getDriver().findElement(By.cssSelector("div[role='radiogroup'] label:last-child input[type='radio']")).click();
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElementsAtTop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementTextAtTop = popupErrorMsgElementsAtTop.getText();
                if (!popupErrorMsgElementTextAtTop.contentEquals("Votre profil a été mis à jour")) {
                    return false;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("pass hàm habitat 1 " + question + " " + i);
                String editLocation = getDriver().findElement(By.cssSelector(".filter .filter__item:nth-child(7) span.value-text")).getText();
                String displayLocation = getDriver().findElement(By.cssSelector(".section__inner .section__group:nth-child(1) ul.list-text li:nth-child(2) span")).getText();
                System.out.println(editLocation + " " + displayLocation);
                if (!editLocation.contentEquals(displayLocation)) {
                    return false;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                editProfileField.get(i).click();
                commonPage.waitUntilElementIsVisible("small.field--choosen__option");
                getDriver().findElement(By.cssSelector("small.field--choosen__option")).click();
                commonPage.waitUntilElementIsVisible("div[role='radiogroup']");
                getDriver().findElement(By.cssSelector("div[role='radiogroup'] label:nth-child(1) input[type='radio']")).click();
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                popupErrorMsgElementsAtTop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                popupErrorMsgElementTextAtTop = popupErrorMsgElementsAtTop.getText();
                if (!popupErrorMsgElementTextAtTop.contentEquals("Votre profil a été mis à jour")) {
                    return false;
                }
                System.out.println("pass hàm habitat 2 " + question + " " + i);
            } else if (question.contentEquals("Style") || question.contentEquals("Habitudes Alimentaires") || question.contentEquals("Langues") || question.contentEquals("Domicile")
                    || question.contentEquals("Caractères") || question.contentEquals("Sports pratiqués")) {
                ArrayList<WebElement> checkBox = new ArrayList<>(getDriver().findElements(By.cssSelector(".checkbox-list input[type='checkbox']")));
                for (int k = 0; k < checkBox.size(); k++) {
                    if (checkBox.get(k).isSelected() && k == (checkBox.size() - 1)) {
                        checkBox.get(0).click();
                        break;
                    }
                    if (checkBox.get(k).isSelected() && k != (checkBox.size() - 1)) {
                        checkBox.get(k + 1).click();
                        break;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ArrayList<WebElement> PrivacyCharter = new ArrayList<>(getDriver().findElements(By.cssSelector(".popover-container")));
                if (PrivacyCharter.size() > 0) {
                    getDriver().findElement(By.cssSelector(".group-actions button:nth-child(2)")).click();
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElementsAtTop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementTextAtTop = popupErrorMsgElementsAtTop.getText();
                if (!popupErrorMsgElementTextAtTop.contentEquals("Votre profil a été mis à jour")) {
                    return false;
                }
                System.out.println("pass hàm checkbox " + question + " " + i);

            } else {
                commonPage.waitUntilElementIsVisible("div[role='radiogroup']");
                ArrayList<WebElement> radioButton = new ArrayList<>(getDriver().findElements(By.cssSelector("div[role='radiogroup'] input[type='radio']")));
                for (int k = 0; k < radioButton.size(); k++) {
                    if (radioButton.get(k).isSelected() && k == (radioButton.size() - 1)) {
                        radioButton.get(0).click();
                        break;
                    }
                    if (radioButton.get(k).isSelected() && k != (radioButton.size() - 1)) {
                        radioButton.get(k + 1).click();
                        break;
                    }
                }


                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                WebElement popupErrorMsgElementsAtTop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementTextAtTop = popupErrorMsgElementsAtTop.getText();
                if (!popupErrorMsgElementTextAtTop.contentEquals("Votre profil a été mis à jour")) {
                    return false;
                }
                System.out.println("pass hàm radio " + question + " " + i);


            }

        }
        return true;
    }

    public boolean fillAllMyCriteriaEmptyFields() {
        ArrayList<WebElement> emptyFields = new ArrayList<>(getDriver().findElements(By.cssSelector(".filter__item-aside span.value-text.is-red")));
        System.out.println(emptyFields.size());
        WebDriverWait wait1 = new WebDriverWait(getDriver(), 4);
        for (int i = 0; i < emptyFields.size(); i++) {

            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView()", emptyFields.get(i));
            emptyFields.get(i).click();

            try {
                WebElement ageModal = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='setting--modal range-slider-modal modal-400 mobile-nofull modal is--opened']")));
                String questionAge = getDriver().findElement(By.cssSelector("div[class='modal--header__title'] h2")).getText();
                if (questionAge.contentEquals("Âge")) {
                    for (int j = 18; j < 25; j++) {
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-1")).sendKeys(Keys.ARROW_UP);
                    }
                    for (int k = 99; k > 35; k--) {
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_DOWN);
                    }
                    String leftSlider = getDriver().findElement(By.cssSelector(".rc-slider div:nth-child(4) span.handle-value")).getText();
                    String rightSlider = getDriver().findElement(By.cssSelector(".rc-slider div:nth-child(5) span.handle-value")).getText();
                    System.out.println("Age arange between " + leftSlider + " and: " + rightSlider);

                    getDriver().findElement(By.cssSelector("button[class='mdc-button mdc-button--unelevated']")).click();

                    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                    WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                    String popupErrorMsgElementText = popupErrorMsgElements.getText();
                    System.out.println(popupErrorMsgElementText);
                    if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                        System.out.println("fail Age" + i);
                        return false;
                    }
                    System.out.println("pass Age " + i);
                    emptyFields.get(i).click();
                    System.out.println(" đã click lại " + i);
                    commonPage.waitUntilElementIsVisible("div[class='setting--modal range-slider-modal modal-400 mobile-nofull modal is--opened']");
                    ArrayList<WebElement> popupErrorMsgElementsExist = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
                    if (popupErrorMsgElementsExist.size() > 0) {
                        System.out.println(popupErrorMsgElementsExist + " error message still appear");
                        return false;
                    }
                    getDriver().findElement(By.cssSelector(".closer .material-icons")).click();

                }
            } catch (Exception e) {
                commonPage.waitUntilElementIsVisible("div[class='setting--modal filter--modal modal is--opened']");
                String question = getDriver().findElement(By.cssSelector(".modal__header h4")).getText();
                if (question.contentEquals("Taille")) {

                    for (int j = 100; j < 165; j++) {
                        getDriver().findElement(By.cssSelector(".rc-slider.rc-slider-vertical div:nth-child(4) .rc-slider-handle.rc-slider-handle-1")).sendKeys(Keys.ARROW_UP);
                    }
                    for (int k = 220; k > 175; k--) {
                        getDriver().findElement(By.cssSelector(".rc-slider.rc-slider-vertical div:nth-child(5) .rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_DOWN);
                    }
                    System.out.println("tall is between: " + getDriver().findElement(By.cssSelector(".rc-slider.rc-slider-vertical div:nth-child(4) span.handle-value")).getText()
                            + " and " + getDriver().findElement(By.cssSelector(".rc-slider.rc-slider-vertical div:nth-child(5) span.handle-value")).getText());

                    getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();

                    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                    WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                    String popupErrorMsgElementText = popupErrorMsgElements.getText();
                    System.out.println(popupErrorMsgElementText);
                    if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                        System.out.println("fail tall " + question + i);
                        return false;
                    }
                    System.out.println("pass tall " + question + i);
                    emptyFields.get(i).click();
                    System.out.println(" đã click lại " + i);
                    commonPage.waitUntilElementIsVisible("div[class='setting--modal filter--modal modal is--opened']");
                    ArrayList<WebElement> popupErrorMsgElementsExist = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
                    if (popupErrorMsgElementsExist.size() > 0) {
                        System.out.println(popupErrorMsgElementsExist + " error message still appear");
                        return false;
                    }
                    getDriver().findElement(By.cssSelector(".closer .material-icons")).click();


                } else if (question.contentEquals("Localisation") || question.contentEquals("Origine") || question.contentEquals("Pratiquante") || question.contentEquals("A des enfants")
                        || question.contentEquals("Veut des enfants") || question.contentEquals("Fume-t-elle ?")) {
                    commonPage.waitUntilElementIsVisible("div[role='radiogroup']");
                    getDriver().findElement(By.cssSelector("div[role='radiogroup'] label:nth-child(1) input[type='radio']")).click();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception f) {
                        f.printStackTrace();
                    }
                    getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();

                    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                    WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                    String popupErrorMsgElementText = popupErrorMsgElements.getText();
                    System.out.println(popupErrorMsgElementText);
                    if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                        System.out.println("fail hàm radio button " + question + " " + i);
                        return false;

                    }
                    System.out.println("pass hàm radio button " + question + " " + i);
                    emptyFields.get(i).click();
                    System.out.println(" đã click lại " + i);
                    commonPage.waitUntilElementIsVisible("div[class='setting--modal filter--modal modal is--opened']");
                    ArrayList<WebElement> popupErrorMsgElementsExist = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
                    if (popupErrorMsgElementsExist.size() > 0) {
                        System.out.println(popupErrorMsgElementsExist + " error message still appear");
                        return false;
                    }
                    getDriver().findElement(By.cssSelector(".closer .material-icons")).click();


                } else {
                    commonPage.waitUntilElementIsVisible(".checkbox-list");
                    getDriver().findElement(By.cssSelector(".checkbox-list div:nth-child(1) input[type='checkbox']")).click();
                    getDriver().findElement(By.cssSelector(".checkbox-list div:nth-child(2) input[type='checkbox']")).click();

                    getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();

                    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                    WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                    String popupErrorMsgElementText = popupErrorMsgElements.getText();
                    System.out.println(popupErrorMsgElementText);
                    if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                        System.out.println("fail hàm check box " + question + " " + i);
                        return false;

                    }
                    System.out.println("pass hàm check box " + question + " " + i);
                    emptyFields.get(i).click();
                    System.out.println(" đã click lại " + i);
                    commonPage.waitUntilElementIsVisible("div[class='setting--modal filter--modal modal is--opened']");
                    ArrayList<WebElement> popupErrorMsgElementsExist = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
                    if (popupErrorMsgElementsExist.size() > 0) {
                        System.out.println(popupErrorMsgElementsExist + " error message still appear");
                        return false;
                    }
                    getDriver().findElement(By.cssSelector(".closer .material-icons")).click();


                }
            }


        }
        return true;
    }

    public boolean checkInfomationAboutMyCriteria() {
        ArrayList<WebElement> editFieldList = new ArrayList<>(getDriver().findElements(By.cssSelector(".filter__item")));
        ArrayList<WebElement> SectionGroupDisplayItemList = new ArrayList<>(getDriver().findElements(By.cssSelector(".section__group:nth-child(3) ul.list-text li")));
        for (int i = 0; i < editFieldList.size(); i++) {

            String editItemName = editFieldList.get(i).findElement(By.cssSelector("h5")).getText();

            String editItemValue = editFieldList.get(i).findElement(By.cssSelector("span.value-text")).getText();
            if (editItemName.contentEquals("Taille")) {

                String tall = getDriver().findElement(By.cssSelector(".section__group:nth-child(3) ul.list-text li:nth-child(9) span")).getText();

                boolean b = editItemValue.contains("10") || editItemValue.contains("20") || editItemValue.contains("30") || editItemValue.contains("40") || editItemValue.contains("50")
                        || editItemValue.contains("60") || editItemValue.contains("70") || editItemValue.contains("80") || editItemValue.contains("90");
                if (editItemValue.contains("00") && !b) {
                    String tallReplace1 = tall.replace("Entre ", "").replace("et", "-").replace("m", "");
                    String editItemValueReplace1 = editItemValue.replace("00", "").replace(" cm", "");
                    if (!editItemValueReplace1.contentEquals(tallReplace1)) {
                        System.out.println(i);
                        System.out.println("fail because informaion isn't match 1: " + editItemName + ": " + editItemValueReplace1 + " " + tallReplace1);
                        return false;
                    }
                    System.out.println(i);
                    System.out.println("pass at 1: " + editItemName + ": " + tallReplace1 + " " + editItemValueReplace1);
                }

                if (editItemValue.contains("10") || editItemValue.contains("20") || editItemValue.contains("30") || editItemValue.contains("40") || editItemValue.contains("50")
                        || editItemValue.contains("60") || editItemValue.contains("70") || editItemValue.contains("80") || editItemValue.contains("90") && !editItemValue.contains("00")) {

                    String tallReplace2 = tall.replace("Entre ", "").replace(",", "").replace("et", "-").replace("m", "");
                    String editItemValueReplace2 = editItemValue.replace("0", "").replace(" cm", "");
                    if (!editItemValueReplace2.contentEquals(tallReplace2)) {
                        System.out.println(i);
                        System.out.println("fail because informaion isn't match 2: " + editItemName + editItemValueReplace2 + " " + tallReplace2);
                        return false;
                    }
                    System.out.println(i);
                    System.out.println("pass at 2: " + editItemName + ": " + tallReplace2 + " " + editItemValueReplace2);

                }
                if (editItemValue.contains("00") && b) {
                    String tallReplace3 = tall.replace("Entre ", "").replace(",", "").replace("et", "-").replace("m", "");
                    String editItemValueReplace2 = editItemValue.replace("00", "").replace("0", "").replace(" cm", "");
                    if (!editItemValueReplace2.contentEquals(tallReplace3)) {
                        System.out.println(i);
                        System.out.println("fail because information isn't match 3: " + editItemName + editItemValueReplace2 + " " + tallReplace3);
                        return false;
                    }
                    System.out.println(i);
                    System.out.println("pass at 3: " + editItemName + ": " + tallReplace3 + " " + editItemValueReplace2);

                }
                if (!editItemValue.contains("00") && !b) {
                    String tallReplace3 = tall.replace("Entre ", "").replace(",", "").replace("et", "-").replace("m", "");

                    String editItemValueReplace3 = editItemValue.replace(" cm", "");
                    if (!editItemValueReplace3.contentEquals(tallReplace3)) {
                        System.out.println(i);
                        System.out.println("fail because information isn't match 4: " + editItemName + ": " + tallReplace3 + " " + editItemValueReplace3);
                        return false;
                    }
                    System.out.println(i);
                    System.out.println("pass at 4: " + editItemName + " hihi " + tallReplace3 + " hehe " + editItemValueReplace3);

                }

            }
            if (editItemName.contentEquals  ("Âge")) {
                System.out.println("từ từ đã");

            }
            else if (!editItemName.contentEquals("Taille") && !editItemName.contentEquals  ("Âge"))  {
                for (int j = 0; j < SectionGroupDisplayItemList.size(); j++) {

                    String displayItemName = SectionGroupDisplayItemList.get(j).findElement(By.cssSelector("strong")).getText();

                    String displayItemValue = SectionGroupDisplayItemList.get(j).findElement(By.cssSelector("span")).getText();

                    if (editItemName.contentEquals(displayItemName.replace(" :", ""))) {
                        if (!editItemValue.contentEquals(displayItemValue)) {
                            System.out.println("fail because informaion isn't match: " + editItemName + " " + editItemValue + " " + displayItemValue);
                            return false;
                        }
                        System.out.println(i + " " + j);
                        System.out.println("pass at: " + editItemName + " " + editItemValue + " " + displayItemValue);
                    }
                }
            }

        }
        return true;
    }

    public boolean editMyCriteriaAgain() {
        ArrayList<WebElement> editCriteriaField = new ArrayList<>(getDriver().findElements(By.cssSelector(".filter__item")));
        System.out.println(editCriteriaField.size());
        for (int i = 0; i < editCriteriaField.size(); i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView()", editCriteriaField.get(i));
            editCriteriaField.get(i).click();
            WebDriverWait wait1 = new WebDriverWait(getDriver(), 4);
            try {
                WebElement ageModal = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='setting--modal range-slider-modal modal-400 mobile-nofull modal is--opened']")));
                String questionAge = getDriver().findElement(By.cssSelector("div[class='modal--header__title'] h2")).getText();
                if (questionAge.contentEquals("Âge")) {
                    for (int j = 0; j <= 2; j++) {
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-1")).sendKeys(Keys.ARROW_RIGHT);
                    }
                    for (int k = 0; k <= 2; k++) {
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_RIGHT);
                    }
                    String leftSlider = getDriver().findElement(By.cssSelector(".rc-slider div:nth-child(4) span.handle-value")).getText();
                    String rightSlider = getDriver().findElement(By.cssSelector(".rc-slider div:nth-child(5) span.handle-value")).getText();
                    System.out.println("Age arange between " + leftSlider + " and: " + rightSlider);


                    getDriver().findElement(By.cssSelector("button[class='mdc-button mdc-button--unelevated']")).click();

                    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                    WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                    String popupErrorMsgElementText = popupErrorMsgElements.getText();
                    System.out.println(popupErrorMsgElementText);
                    if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {

                        return false;
                    }
                }
            } catch (Exception e) {
                commonPage.waitUntilElementIsVisible("div[class='setting--modal filter--modal modal is--opened']");

                String question = getDriver().findElement(By.cssSelector(".modal__header h4")).getText();
                if (question.contentEquals("Taille")) {
                    for (int j = 0; j <= 2; j++) {
                        getDriver().findElement(By.cssSelector(".rc-slider div:nth-child(4) .rc-slider-handle.rc-slider-handle-1")).sendKeys(Keys.ARROW_UP);
                    }
                    for (int k = 0; k <= 2; k++) {
                        getDriver().findElement(By.cssSelector(".rc-slider div:nth-child(5) .rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_UP);
                    }
                    System.out.println(getDriver().findElement(By.cssSelector(".rc-slider div:nth-child(4) span.handle-value")).getText()
                            + " chiều cao nằm giữa " + getDriver().findElement(By.cssSelector(".rc-slider div:nth-child(5) span.handle-value")).getText());


                    getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();

                    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                    WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                    String popupErrorMsgElementText = popupErrorMsgElements.getText();
                    System.out.println(popupErrorMsgElementText);
                    if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                        System.out.println("fail chiều cao" + question + " " + i);
                        return false;
                    }
                    System.out.println("pass chiều cao " + question + " " + i);
                }else if (question.contentEquals("Localisation") || question.contentEquals("Origine") || question.contentEquals("Pratiquante") || question.contentEquals("A des enfants")
                        || question.contentEquals("Veut des enfants") || question.contentEquals("Fume-t-elle ?")) {
                    commonPage.waitUntilElementIsVisible("div[role='radiogroup']");
                    ArrayList<WebElement> radioButton = new ArrayList<>(getDriver().findElements(By.cssSelector("div[role='radiogroup'] input[type='radio']")));
                    for (int k = 0; k < radioButton.size(); k++) {
                        if (radioButton.get(k).isSelected() && k == (radioButton.size() - 1)) {
                            radioButton.get(0).click();
                            break;
                        }
                        if (radioButton.get(k).isSelected() && k != (radioButton.size() - 1)) {
                            radioButton.get(k + 1).click();
                            break;
                        }
                    }

                    getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();

                    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                    WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                    String popupErrorMsgElementText = popupErrorMsgElements.getText();
                    System.out.println(popupErrorMsgElementText);
                    if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                        System.out.println("fail hàm radio " + question + " " + i);
                        return false;

                    }
                    System.out.println("pass hàm radio" + question + " " + i);

                } else {
                    commonPage.waitUntilElementIsVisible(".checkbox-list");
                    ArrayList<WebElement> checkBox = new ArrayList<>(getDriver().findElements(By.cssSelector(".checkbox-list input[type='checkbox']")));
                    for (int k = 0; k < checkBox.size(); k++) {
                        if (checkBox.get(k).isSelected() && k == (checkBox.size() - 1)) {
                            checkBox.get(0).click();
                            break;
                        }
                        if (checkBox.get(k).isSelected() && k != (checkBox.size() - 1)) {
                            checkBox.get(k + 1).click();
                            break;
                        }
                    }

                    getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();

                    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                    WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                    String popupErrorMsgElementText = popupErrorMsgElements.getText();
                    System.out.println(popupErrorMsgElementText);
                    if (!popupErrorMsgElementText.contentEquals("Votre profil a été mis à jour")) {
                        System.out.println("fail hàm check box " + question + " " + i);
                        return false;

                    }
                    System.out.println("pass hàm check box " + question + " " + i);

                }
            }

        }
        return true;
    }

    public boolean leaveAllEditCriteriaFieldsEmptyAndClickValidate() {
        commonPage.waitUntilElementIsVisible(".filter__item-aside span.value-text.is-red");
        ArrayList<WebElement> emptyFields = new ArrayList<>(getDriver().findElements(By.cssSelector(".filter__item-aside span.value-text.is-red")));
        System.out.println(emptyFields.size());
        for (int i = 0; i < emptyFields.size(); i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].scrollIntoView()", emptyFields.get(i));
            emptyFields.get(i).click();
            WebDriverWait wait1 = new WebDriverWait(getDriver(), 4);
            try {

                WebElement normalModal = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='setting--modal filter--modal modal is--opened']")));
                String question = getDriver().findElement(By.cssSelector(".modal__header h4")).getText();
                if ( question.contentEquals("Taille")) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();
                } else {

                    getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
                    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                    WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
                    String popupErrorMsgElementText = popupErrorMsgElements.getText();
                    System.out.println(popupErrorMsgElementText + i);
                    if (!popupErrorMsgElementText.contentEquals("Sélectionnez un champ pour valider")) {
                        return false;
                    }

                    getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();
                }
            } catch (Exception e) {
                WebElement ageModal = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='setting--modal range-slider-modal modal-400 mobile-nofull modal is--opened']")));
                String questionAge = getDriver().findElement(By.cssSelector("div[class='modal--header__title'] h2")).getText();
                if (questionAge.contentEquals("Âge")) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception f) {
                        f.printStackTrace();
                    }

                    getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();
                }
            }

//
//            String question = getDriver().findElement(By.cssSelector(".modal__header h4")).getText();
//            String questionAge = getDriver().findElement(By.cssSelector("div[class='modal--header__title'] h2")).getText();
//
//            if (questionAge.contentEquals("Âge") || question.contentEquals("Taille")) {
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();
//            } else {
//
//                getDriver().findElement(By.cssSelector("button.modal-circle-check-btn")).click();
//                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//                WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
//                String popupErrorMsgElementText = popupErrorMsgElements.getText();
//                System.out.println(popupErrorMsgElementText + i);
//                if (!popupErrorMsgElementText.contentEquals("Sélectionnez un champ pour valider")) {
//                    return false;
//                }
//
//                getDriver().findElement(By.cssSelector("a.closer i.material-icons")).click();
//            }
        }
        emptyFields = new ArrayList<>(getDriver().findElements(By.cssSelector(".filter__item-aside span.value-text.is-red")));
        System.out.println(emptyFields.size());
        return true;
    }

    public boolean activeAgeFilterFromTo(int minAge, int maxAge) {
        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("settingBtn");
        commonPage.click("settingBtn");
        commonPage.waitUntilElementIsVisible(".filter__item.age_filter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 50);
        WebElement filterButton = getDriver().findElement(By.cssSelector(".filter__item.age_filter input[id='ageFilter']"));

        if (filterButton.isSelected()) {
            System.out.println(filterButton.getAttribute("checked") + " checked");
            getDriver().findElement(By.cssSelector("a.age-filter-config")).click();
            String minAgeOnSlider = getDriver().findElement(By.cssSelector("div[class='rc-slider-handle rc-slider-handle-1']")).getAttribute("aria-valuenow");
            int numberOfMinAgeOnSlider = Integer.parseInt(minAgeOnSlider);
            System.out.println(numberOfMinAgeOnSlider);
            String maxAgeOnSlider = getDriver().findElement(By.cssSelector("div[class='rc-slider-handle rc-slider-handle-2']")).getAttribute("aria-valuenow");
            int numberOfMaxAgeOnSlider = Integer.parseInt(maxAgeOnSlider);
            System.out.println(numberOfMaxAgeOnSlider);

            if (minAge > numberOfMinAgeOnSlider) {

                if (maxAge > numberOfMaxAgeOnSlider) {
                    for (int j = numberOfMaxAgeOnSlider; j <= maxAge; j++) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_RIGHT);
                    }
                }
                if (maxAge < numberOfMaxAgeOnSlider) {
                    for (int j = numberOfMaxAgeOnSlider; j >= maxAge; j--) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_LEFT);
                    }
                }
                if (numberOfMaxAgeOnSlider == maxAge) {
                    System.out.println("max age is ok");
                }
                for (int i = numberOfMinAgeOnSlider; i <= minAge; i++) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-1")).sendKeys(Keys.ARROW_RIGHT);
                }

                getDriver().findElement(By.cssSelector("div[class='setting--modal age_filter_modal modal is--opened'] button[class='mdc-button mdc-button--unelevated']")).click();
                WebElement popupErrorMsgElements2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementText2 = popupErrorMsgElements2.getText();
                System.out.println(popupErrorMsgElementText2);
                if (!popupErrorMsgElementText2.contentEquals("Vos préférences ont été mises à jour")) {
                    return false;
                }

            }
            if (minAge < numberOfMinAgeOnSlider) {
                for (int i = numberOfMinAgeOnSlider; i >= minAge; i--) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-1")).sendKeys(Keys.ARROW_LEFT);
                }
                if (maxAge > numberOfMaxAgeOnSlider) {
                    for (int j = numberOfMaxAgeOnSlider; j <= maxAge; j++) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_RIGHT);
                    }
                }
                if (maxAge < numberOfMaxAgeOnSlider) {
                    for (int j = numberOfMaxAgeOnSlider; j >= maxAge; j--) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_LEFT);
                    }
                }
                if (numberOfMaxAgeOnSlider == maxAge) {
                    System.out.println("max age is ok");
                }

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("div[class='setting--modal age_filter_modal modal is--opened'] button[class='mdc-button mdc-button--unelevated']")).click();

                WebElement popupErrorMsgElements2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementText2 = popupErrorMsgElements2.getText();
                System.out.println(popupErrorMsgElementText2);
                if (!popupErrorMsgElementText2.contentEquals("Vos préférences ont été mises à jour")) {
                    return false;
                }

            }
            if (numberOfMinAgeOnSlider == minAge) {
                System.out.println("min age is ok");
                if (maxAge > numberOfMaxAgeOnSlider) {
                    for (int j = numberOfMaxAgeOnSlider; j <= maxAge; j++) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_RIGHT);
                    }
                }
                if (maxAge < numberOfMaxAgeOnSlider) {
                    for (int j = numberOfMaxAgeOnSlider; j >= maxAge; j--) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_LEFT);
                    }
                }
                if (numberOfMaxAgeOnSlider == maxAge) {
                    System.out.println("max age is ok");
                }

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("div[class='setting--modal age_filter_modal modal is--opened'] button[class='mdc-button mdc-button--unelevated']")).click();

                WebElement popupErrorMsgElements2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementText2 = popupErrorMsgElements2.getText();
                System.out.println(popupErrorMsgElementText2);
                if (!popupErrorMsgElementText2.contentEquals("Vos préférences ont été mises à jour")) {
                    return false;
                }
            }


        } else {
            filterButton.click();

            WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
            String popupErrorMsgElementText = popupErrorMsgElements.getText();
            System.out.println(popupErrorMsgElementText);
            if (!popupErrorMsgElementText.contentEquals("Vos préférences ont été mises à jour")) {
                return false;
            }
            getDriver().findElement(By.cssSelector("a.age-filter-config")).click();
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String min = getDriver().findElement(By.cssSelector("div[class='rc-slider-handle rc-slider-handle-1']")).getAttribute("aria-valuenow");
            int minOfAge = Integer.parseInt(min);
            String max = getDriver().findElement(By.cssSelector("div[class='rc-slider-handle rc-slider-handle-2']")).getAttribute("aria-valuenow");
            int maxOfAge = Integer.parseInt(max);

            if (minAge > minOfAge) {
                for (int i = minOfAge; i <= minAge; i++) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-1")).sendKeys(Keys.ARROW_RIGHT);
                }
                if (maxAge > maxOfAge) {
                    for (int j = maxOfAge; j <= maxAge; j++) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_LEFT);
                    }
                }
                if (maxAge < maxOfAge) {
                    for (int j = maxOfAge; j >= maxAge; j--) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_RIGHT);
                    }
                }
                if (maxOfAge == maxAge) {
                    System.out.println("max age is ok");
                }

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("div[class='setting--modal age_filter_modal modal is--opened'] button[class='mdc-button mdc-button--unelevated']")).click();

                WebElement popupErrorMsgElements2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementText2 = popupErrorMsgElements2.getText();
                System.out.println(popupErrorMsgElementText2);
                if (!popupErrorMsgElementText2.contentEquals("Vos préférences ont été mises à jour")) {
                    return false;
                }

            }
            if (minOfAge > minAge) {
                for (int i = minOfAge; i >= minAge; i--) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-1")).sendKeys(Keys.ARROW_LEFT);
                }
                if (maxAge > maxOfAge) {
                    for (int j = maxOfAge; j <= maxAge; j++) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_RIGHT);
                    }
                }
                if (maxAge < maxOfAge) {
                    for (int j = maxOfAge; j >= maxAge; j--) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_LEFT);
                    }
                }
                if (maxOfAge == maxAge) {
                    System.out.println("max age is ok");
                }
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("div[class='setting--modal age_filter_modal modal is--opened'] button[class='mdc-button mdc-button--unelevated']")).click();

                WebElement popupErrorMsgElements2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementText2 = popupErrorMsgElements2.getText();
                System.out.println(popupErrorMsgElementText2);
                if (!popupErrorMsgElementText2.contentEquals("Vos préférences ont été mises à jour")) {
                    return false;
                }

            }
            if (minOfAge == minAge) {
                System.out.println("min age is ok");
                if (maxAge > maxOfAge) {
                    for (int j = maxOfAge; j <= maxAge; j++) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_RIGHT);
                    }
                }
                if (maxAge < maxOfAge) {
                    for (int j = maxOfAge; j >= maxAge; j--) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getDriver().findElement(By.cssSelector(".rc-slider-handle.rc-slider-handle-2")).sendKeys(Keys.ARROW_LEFT);
                    }
                }
                if (maxOfAge == maxAge) {
                    System.out.println("max age is ok");
                }

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getDriver().findElement(By.cssSelector("div[class='setting--modal age_filter_modal modal is--opened'] button[class='mdc-button mdc-button--unelevated']")).click();

                WebElement popupErrorMsgElements2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
                String popupErrorMsgElementText2 = popupErrorMsgElements2.getText();
                System.out.println(popupErrorMsgElementText2);
                if (!popupErrorMsgElementText2.contentEquals("Vos préférences ont été mises à jour")) {
                    return false;
                }
            }
        }
        System.out.println(getDriver().findElement(By.cssSelector("span.age-filter-info")).getText());
        return true;
    }

    public void deleteFromFavoritesList(String name) {
        ArrayList<WebElement> favoritesAccount = new ArrayList<>(getDriver().findElements(By.cssSelector("li.profile--item")));
        for (int i = 0; i < favoritesAccount.size(); i++) {
            String accountName = favoritesAccount.get(i).findElement(By.cssSelector(".profile__content h5")).getText();
            if (accountName.contentEquals(name)) {

                favoritesAccount.get(i).findElement(By.cssSelector(".profile__custom-delete i.material-icons.right-icon")).click();
                commonPage.waitUntilElementIsVisible("ul[role='menu'] li");
                commonPage.click("ul[role='menu'] li");
                break;
            }
        }
    }

    public void uploadPictureFromLibraryInComputer(String picture) throws AWTException {
        WebElement fileInput = getDriver().findElement(By.cssSelector("div[class='upload-link-wrapper']"));
        System.out.println(fileInput);
        fileInput.click();

        try {
            Thread.sleep(3 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String text = System.getProperty("user.dir") + "\\src\\test\\resources\\data_test\\" + picture;

        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        try {
            Thread.sleep(3 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public boolean deactiveAgeFilter() {
        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("settingBtn");
        commonPage.click("settingBtn");
        commonPage.waitUntilElementIsVisible(".filter__item.age_filter");
        WebElement filterButton = getDriver().findElement(By.cssSelector("div[class='filter__item age_filter'] input[id='ageFilter']"));

        if (filterButton.isSelected()) {
            filterButton.click();
            WebElement popupErrorMsgElements = getDriver().findElement(By.cssSelector("div.top-message-text"));
            String popupErrorMsgElementText = popupErrorMsgElements.getText();
            System.out.println(popupErrorMsgElementText);
            if (popupErrorMsgElementText.contentEquals("Vos préférences ont été mises à jour")) {
                return true;
            }
            System.out.println(popupErrorMsgElementText);
            return false;

        } else {
            System.out.println(filterButton.getAttribute("checked") + " ok, this button is remain deactive");
            return true;
        }
    }

    public boolean checkIfContentOfAlertTextAboutAgeFilterIsCorrect() {
        commonPage.waitUntilElementIsVisible(".alert__text");
        String alertText1 = getDriver().findElement(By.cssSelector(".alert__text h5:nth-child(1)")).getText();
        String alertText2 = getDriver().findElement(By.cssSelector(".alert__text h5:nth-child(2)")).getText();
        if (!alertText1.contentEquals("Cette personne est bloquée par vos filtres, elle ne pourra pas vous contacter.") && !alertText2.contentEquals("Faites le premier pas pour discuter \uD83D\uDE0A")) {
            System.out.println(alertText1);
            System.out.println(alertText2);
            return false;
        }
        System.out.println(alertText1);
        System.out.println(alertText2);
        return true;
    }

    public boolean shouldNotSeeSmileVisitNotificationOf(String user) throws AWTException {
        commonPage.waitUntilElementIsVisible("NotificationTextLink");
        commonPage.click("NotificationTextLink");
        commonPage.waitUntilElementIsVisible(".list-notification");
        ArrayList<WebElement> noti = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification-item")));
        if (noti.size() > 0) {
            System.out.println(noti.size());
            Robot robot = new Robot();
            WebElement notificationList = getDriver().findElement(By.cssSelector(".list-notification"));
            Point listNoti = notificationList.getLocation();
            int xcord = listNoti.getX();
            int ycord = listNoti.getY() + 120;
            robot.mouseMove(xcord, ycord);
            System.out.println(xcord + " " + ycord);

            int itemLoaded = 0;
            int totalItems = noti.size();

            while (itemLoaded < totalItems) {

                //scroll and wait a bit to give the impression of smooth scrolling
                robot.mouseWheel(50);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                itemLoaded = totalItems;
                noti = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification-item")));
                totalItems = noti.size();
                System.out.println(noti.size());
            }
            noti = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification-item")));
            totalItems = noti.size();
            System.out.println(totalItems);
            System.out.println(noti.get(noti.size() - 1).findElement(By.cssSelector(".notification__meta h5")).getText());
            String numberNotiBefore = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('noti.size()')");
            int numberLastNoti = Integer.parseInt(numberNotiBefore);

            int newNoti = totalItems - numberLastNoti;
            System.out.println(newNoti + " đây là số noti mới có");
            if (newNoti > 0) {
                for (int i = 0; i < newNoti; i++) {
                    String name = noti.get(i).findElement(By.cssSelector(".notification__meta h5")).getText();
                    if (name.contentEquals(user)) {

                        System.out.println(name);
                        System.out.println(noti.get(i).findElement(By.cssSelector(".notification__content strong")).getText());
                        return false;
                    }
                    System.out.println("ok");
                }
            }
        } else {
            System.out.println("notification list empty");
            return true;
        }
        return true;
    }

    public void checkNumberOfVisitSmileNotification() throws AWTException {
        commonPage.waitUntilElementIsVisible("NotificationTextLink");
        commonPage.click("NotificationTextLink");
        commonPage.waitAboutSecond(2);
        ArrayList<WebElement> noti = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification-item")));
        if (noti.size() > 0) {
            System.out.println(noti.size());
            Robot robot = new Robot();
            WebElement notificationList = getDriver().findElement(By.cssSelector(".list-notification"));
            Point listNoti = notificationList.getLocation();
            int xcord = listNoti.getX();
            int ycord = listNoti.getY() + 120;
            robot.mouseMove(xcord, ycord);
            System.out.println(xcord + " " + ycord);

            int itemLoaded = 0;
            int totalItems = noti.size();

            while (itemLoaded < totalItems) {

                //scroll and wait a bit to give the impression of smooth scrolling
                robot.mouseWheel(40);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                itemLoaded = totalItems;
                noti = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification-item")));
                totalItems = noti.size();
                System.out.println(noti.size());
            }
            noti = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification-item")));
            totalItems = noti.size();
            System.out.println(noti.get(noti.size() - 1).findElement(By.cssSelector(".notification__meta h5")).getText());
            ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('noti.size()','" + totalItems + "')");
            System.out.println(totalItems + " đã lưu vào local storage");
        } else {
            noti = new ArrayList<>(getDriver().findElements(By.cssSelector(".notification-item")));
            int totalItems = noti.size();
            ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('noti.size()','" + totalItems + "')");
            System.out.println(totalItems + " đã lưu vào local storage");
        }

    }

    public boolean shouldNotSeeContactRequestNotificationOf(String userName) throws AWTException {
        commonPage.waitUntilElementIsVisible("a[href='/main/contact-requests']");
        commonPage.click("a[href='/main/contact-requests']");
        commonPage.waitUntilElementIsVisible(".section--requests");
        ArrayList<WebElement> contactRequest = new ArrayList<>(getDriver().findElements(By.cssSelector(".request")));
        if (contactRequest.size() > 0) {
            System.out.println(contactRequest.size());
            Robot robot = new Robot();
            WebElement notificationList = getDriver().findElement(By.cssSelector(".section--requests .section__body"));
            Point listNoti = notificationList.getLocation();
            int xcord = listNoti.getX();
            int ycord = listNoti.getY() + 120;
            robot.mouseMove(xcord, ycord);
            System.out.println(xcord + " " + ycord);

            int itemLoaded = 0;
            int totalItems = contactRequest.size();

            while (itemLoaded < totalItems) {

                //scroll and wait a bit to give the impression of smooth scrolling
                robot.mouseWheel(40);

                try {
                    Thread.sleep(4 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                itemLoaded = totalItems;
                contactRequest = new ArrayList<>(getDriver().findElements(By.cssSelector(".request")));
                totalItems = contactRequest.size();
                System.out.println(contactRequest.size());
            }
            contactRequest = new ArrayList<>(getDriver().findElements(By.cssSelector(".request")));
            totalItems = contactRequest.size();
            System.out.println(totalItems);
            for (int i = 0; i < contactRequest.size(); i++) {
                String name = contactRequest.get(i).findElement(By.cssSelector(".request__head h5")).getText();
                if (name.contentEquals(userName)) {
                    System.out.println(name);
                    return false;
                }
                System.out.println(name);
            }
        } else {
            System.out.println("empty contact requets list");
            return true;
        }
        return true;
    }

    public boolean ContentOfAlertTextAboutAgeFilterIsAlreadyDisapear() {
        commonPage.waitUntilElementIsVisible("div[class='user__head']");
        ArrayList<WebElement> alertAboutAgeFilter = new ArrayList<>(getDriver().findElements(By.cssSelector(".alert.alert--info")));
        if (alertAboutAgeFilter.size() > 0) {
            System.out.println(alertAboutAgeFilter.get(0).findElement(By.cssSelector(".alert.alert--info h5:nth-child(1)")).getText());
            return false;
        }
        System.out.println(alertAboutAgeFilter.size());
        return true;
    }


    public void checkNumberOfMessages() throws AWTException {
        commonPage.waitUntilElementIsVisible("Messages");
        commonPage.click("Messages");
        commonPage.waitAboutSecond(2);
        ArrayList<WebElement> mess = new ArrayList<>(getDriver().findElements(By.cssSelector(".message")));
        if (mess.size() > 0) {
            System.out.println(mess.size());
            Robot robot = new Robot();
            WebElement notificationList = getDriver().findElement(By.cssSelector(".messages"));
            Point listNoti = notificationList.getLocation();
            int xcord = listNoti.getX();
            int ycord = listNoti.getY() + 120;
            robot.mouseMove(xcord, ycord);
            System.out.println(xcord + " " + ycord);

            int itemLoaded = 0;
            int totalItems = mess.size();

            while (itemLoaded < totalItems) {

                //scroll and wait a bit to give the impression of smooth scrolling
                robot.mouseWheel(40);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                itemLoaded = totalItems;
                mess = new ArrayList<>(getDriver().findElements(By.cssSelector(".message")));
                totalItems = mess.size();
                System.out.println(mess.size());
            }
            mess = new ArrayList<>(getDriver().findElements(By.cssSelector(".message")));
            totalItems = mess.size();
            System.out.println(mess.get(mess.size() - 1).findElement(By.cssSelector(".message__head h5")).getText());
            ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('mess.size()','" + totalItems + "')");
            System.out.println(totalItems + " đã lưu vào local storage");
        } else {
            mess = new ArrayList<>(getDriver().findElements(By.cssSelector(".message")));
            int totalItems = mess.size();
            ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('mess.size()','" + totalItems + "')");
            System.out.println(totalItems + " đã lưu vào local storage");
        }
    }

    public boolean shouldNotSeeMessageOf(String user) throws AWTException {
        commonPage.waitUntilElementIsVisible("Messages");
        commonPage.click("Messages");
        ArrayList<WebElement> mess = new ArrayList<>(getDriver().findElements(By.cssSelector(".message")));
        if (mess.size() > 0) {
            System.out.println(mess.size());
            Robot robot = new Robot();
            WebElement notificationList = getDriver().findElement(By.cssSelector(".messages"));
            Point listNoti = notificationList.getLocation();
            int xcord = listNoti.getX();
            int ycord = listNoti.getY() + 120;
            robot.mouseMove(xcord, ycord);
            System.out.println(xcord + " " + ycord);

            int itemLoaded = 0;
            int totalItems = mess.size();

            while (itemLoaded < totalItems) {

                //scroll and wait a bit to give the impression of smooth scrolling
                robot.mouseWheel(50);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                itemLoaded = totalItems;
                mess = new ArrayList<>(getDriver().findElements(By.cssSelector(".message")));
                totalItems = mess.size();
                System.out.println(mess.size());
            }
            mess = new ArrayList<>(getDriver().findElements(By.cssSelector(".message")));
            totalItems = mess.size();
            System.out.println(totalItems);
            System.out.println(mess.get(mess.size() - 1).findElement(By.cssSelector(".message__head h5")).getText());
            String numberNotiBefore = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('mess.size()')");
            int numberLastNoti = Integer.parseInt(numberNotiBefore);

            int newNoti = totalItems - numberLastNoti;
            System.out.println(newNoti + " đây là số noti mới có");
            if (newNoti > 0) {
                for (int i = 0; i < newNoti; i++) {
                    String name = mess.get(i).findElement(By.cssSelector(".message__head h5")).getText();
                    if (name.contentEquals(user)) {

                        System.out.println(name);
                        return false;
                    }
                }
            }
        } else {
            System.out.println("message list empty");
            return true;
        }
        return true;
    }

    public void turnOffLibraryWindow() throws AWTException {

        WebElement fileInput = getDriver().findElement(By.cssSelector("div[class='upload-action']"));
        fileInput.click();


        try {
            Thread.sleep(4 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Robot r = new Robot();

        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);

        r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
        r.keyRelease(KeyEvent.VK_ENTER);

        try {
            Thread.sleep(4 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public boolean SeeWarningMessageAboutPhotoRefuse() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement refusePictureModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='slick-slide slick-active slick-current'] div[class='gallery-item-container']")));

        WebElement warningContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.warning-message > p")));
        String warningContent2 = warningContent.getText();
        if (warningContent2.contentEquals("Pour vous permettre de faire des rencontres dans les meilleures conditions, sachez que nous refusons systématiquement les photos suivantes :")) {


            String[] warningContentBelow = {
                    "Photo qui ne vous représente pas (images, paysages...)",
                    "Photo avec lunettes de soleil",
                    "Photo contenant un numéro de téléphone, une adresse email, un pseudo",
                    "Photo non cadrée, floue, sombre ou trop petite",
                    "Photo de groupe ou avec enfant",
                    "Photo torse nu",
                    "Photo pouvant heurter la sensibilité des autres membres",
            };
            ArrayList<WebElement> warningContentBelowList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.warning-message > ul > li")));
            ArrayList<String> warningContentBelow2 = new ArrayList<>();
            for (WebElement displayItem : warningContentBelowList) {
                warningContentBelow2.add(displayItem.getText());
            }
            for (String item : warningContentBelow) {
                if (!warningContentBelow2.contains(item)) {
                    return false;
                }
            }
            return true;

        } else {
            return false;
        }
    }

    public boolean shouldSeeStopIconOnRejectedPhoto() {
        ArrayList<WebElement> RejectIconList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='owl-stage-outer'] div[class='owl-stage'] div[class='refused-icon-overlay']")));
        if (RejectIconList.size() > 0) {
            System.out.println(RejectIconList + " " + "pass hehe");
            return true;
        } else {
            System.out.println(RejectIconList + " " + "maybe this account do not contain any rejected photo");
            return false;
        }
    }

    public void uploadFileFromLibraryInComputer() throws AWTException {

        WebElement fileInput = getDriver().findElement(By.cssSelector("div[class='upload-link-wrapper']"));
        System.out.println(fileInput);
        fileInput.click();

        try {
            Thread.sleep(3 * 1000);
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
            Thread.sleep(4 * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void uploadPictureToUnderApprovalProcess(String picture) throws AWTException {

        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("avaInProfileBtn");
        commonPage.click("avaInProfileBtn");
        commonPage.waitAboutSecond(4);
        uploadPictureFromLibraryInComputer(picture);
    }

    public void insertAndCompletelyErasesMyIntroductionInProfile() {
        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("EditProfile");
        commonPage.click("EditProfile");
        commonPage.waitUntilElementIsVisible("EditMonAccroche");
        commonPage.click("EditMonAccroche");
        commonPage.waitUntilElementIsVisible("IntroductionTextField");
        commonPage.insertIntoField("hi, this is test introduction", "IntroductionTextField");
        commonPage.waitAboutSecond(2);
        commonPage.clearTextFromField("IntroductionTextField");
    }

    public void deactiveAgeFilterAndLogOut() {
        deactiveAgeFilter();
        commonPage.scrollToElementThatHasTextAndClick("//div[@class='list-settings']//*[contains(text(),'Se déconnecter')]");

    }


    public void activeAgeFilterFromToAndLogOut(int minAge, int maxAge) {
        activeAgeFilterFromTo(minAge, maxAge);
        commonPage.scrollToElementThatHasTextAndClick("//div[@class='list-settings']//*[contains(text(),'Se déconnecter')]");

    }

    public void changePasswwordFromToAndLogout(String passWord1, String passWord2) {
        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("settingBtn");
        commonPage.click("settingBtn");
        commonPage.waitUntilElementIsVisible(".list-settings");
        commonPage.scrollToElementThatHasTextAndClick("ChangerVotreMotDePasse");
        commonPage.insertIntoField(passWord1, "input[name='passwd']");
        commonPage.insertIntoField(passWord2, "input[name='new_data']");
        commonPage.click("div[class='setting--modal mobile-nofull change-password-modal modal is--opened'] button[class='mdc-button mdc-button--unelevated']");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Votre mot de passe a été mis à jour"), is(equalTo(true)));
        commonPage.scrollToElementThatHasTextAndClick("//div[@class='list-settings']//*[contains(text(),'Se déconnecter')]");
    }

    public void canLoginWithNewPassword(String newPassWord) {
        commonPage.clearTextFromField("input[name='password']");
        commonPage.insertIntoField(newPassWord, "input[name='password']");
        commonPage.click(".form__actions button[type='submit']");
        commonPage.waitUntilElementIsVisible("div[class='header__inner']");
        assertThat(commonPage.redirectToLink("discoveries.url"), is(equalTo(true)));
    }

    public void loginWithOldPasswword(String oldPassWord) {
        commonPage.loginWithAccountAndPassword("lannt.woman@gmail.com", oldPassWord);
    }


    public void sendSmileAndContactRequestToWhenAgeFilterIsActive(String womanAccount) {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.insertIntoField(womanAccount, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + womanAccount + "']")));
        account.click();
        commonPage.waitUntilElementIsVisible("smileBtn");
        commonPage.click("smileBtn");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Smile envoyé"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
        commonPage.click("smileBtn");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Smile envoyé"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
        commonPage.waitUntilElementIsVisible("destinyBtn");
        commonPage.click("destinyBtn");
        commonPage.waitUntilElementIsVisible("textarea[placeholder='Donnez-lui envie de répondre et personnalisez votre message ! ']");
        commonPage.insertIntoField("hi, this is test greeting", "textarea[placeholder='Donnez-lui envie de répondre et personnalisez votre message ! ']");
        commonPage.click("button[type='submit']");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("C'est bien parti !"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
        commonPage.click("DiscoveriesScreenBtn");
        commonPage.waitUntilElementIsVisible("Profile");
        commonPage.clickOnWhichIndexIs("Profile", 0);
        commonPage.waitUntilElementIsVisible("destinyBtn");
        commonPage.click("destinyBtn");
        commonPage.waitUntilElementIsVisible("textarea[placeholder='Donnez-lui envie de répondre et personnalisez votre message ! ']");
        commonPage.insertIntoField("hi, this is test greeting", "textarea[placeholder='Donnez-lui envie de répondre et personnalisez votre message ! ']");
        commonPage.click("button[type='submit']");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("C'est bien parti !"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
    }

    public boolean sendSmileAndContactRequestToWhenAgeFilterIsDeactive(String womanAccount) {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.insertIntoField(womanAccount, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + womanAccount + "']")));
        account.click();
        commonPage.waitUntilElementIsVisible("smileBtn");
        commonPage.click("smileBtn");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Smile envoyé"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
        commonPage.click("smileBtn");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Personne déjà smilée"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
        commonPage.waitUntilElementIsVisible("destinyBtn");
        commonPage.click("destinyBtn");
        commonPage.waitUntilElementIsVisible("textarea[placeholder='Donnez-lui envie de répondre et personnalisez votre message ! ']");
        commonPage.insertIntoField("hi, this is test greeting", "textarea[placeholder='Donnez-lui envie de répondre et personnalisez votre message ! ']");
        commonPage.click("button[type='submit']");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("C'est bien parti !"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
        assertThat(contactRequestPage.shouldSeeTextOnButtonChangeTo("VOUS AVEZ SOUHAITÉ CROISER SON DESTIN"), is(equalTo(true)));
        commonPage.click(".user__header i.material-icons");
        commonPage.waitUntilElementIsVisible("Profile");
        commonPage.clickOnWhichIndexIs("Profile", 0);
        commonPage.waitUntilElementIsVisible(".user__actions");
        commonPage.click("destinyBtn");
        commonPage.waitAboutSecond(4);
        ArrayList<WebElement> contactRequestModal = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='setting--modal contact-request-modal small-form-modal mobile-nofull avoid-keyboard-space modal is--opened']")));
        if (contactRequestModal.size() > 0) {
            System.out.println(contactRequestModal.size() + " fail");
            return false;
        }
        System.out.println(contactRequestModal.size() + " pass");
        return true;
    }

    public void sendMessageTo(String userName) {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.insertIntoField(userName, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + userName + "']")));
        account.click();
        commonPage.waitUntilElementIsVisible("Discuss");
        commonPage.click("Discuss");
        commonPage.waitUntilElementIsVisible("chatField");
        commonPage.insertIntoField("hi, my name is Yassine_yes2, this is test message second time =)))", "chatField");
        commonPage.click("sendMessage");
        assertThat(contactRequestPage.shouldSendMessageAsUsual("hi, my name is Yassine_yes2, this is test message second time =)))"), is(equalTo(true)));


    }

    public void smileWith(String userName) {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.insertIntoField(userName, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + userName + "']")));
        account.click();
        commonPage.waitUntilElementIsVisible("smileBtn");
        commonPage.click("smileBtn");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Smile envoyé"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
        commonPage.click("smileBtn");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Personne déjà smilée"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
    }

    public void sendMessageAndSmileToWhenAgeFilterIsActive(String userAccount) {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.insertIntoField(userAccount, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + userAccount + "']")));
        account.click();
        commonPage.waitUntilElementIsVisible("smileBtn");
        commonPage.click("smileBtn");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Smile envoyé"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
        commonPage.click("smileBtn");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Smile envoyé"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
        commonPage.waitUntilElementIsVisible("Discuss");
        commonPage.click("Discuss");
        commonPage.waitUntilElementIsVisible("chatField");
        commonPage.waitAboutSecond(2);
        commonPage.insertIntoField("Active age filter", "chatField");
        commonPage.click("sendMessage");
        assertThat(contactRequestPage.shouldSendMessageAsUsual("Active age filter"), is(equalTo(true)));
        commonPage.insertIntoField("Active age filter 2", "chatField");
        commonPage.click("sendMessage");
        assertThat(contactRequestPage.shouldSendMessageAsUsual("Active age filter 2"), is(equalTo(true)));
        commonPage.insertIntoField("Active age filter 3", "chatField");
        commonPage.click("sendMessage");
        assertThat(contactRequestPage.shouldSendMessageAsUsual("Active age filter 3"), is(equalTo(true)));

    }

    public void sendSmileAndMessageToWhenAgeFilterIsDeactive(String userAccount) {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.insertIntoField(userAccount, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + userAccount + "']")));
        account.click();
        commonPage.waitUntilElementIsVisible("smileBtn");
        commonPage.click("smileBtn");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Smile envoyé"), is(equalTo(true)));
        commonPage.waitAboutSecond(5);
        commonPage.click("smileBtn");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Personne déjà smilée"), is(equalTo(true)));
        commonPage.waitAboutSecond(4);
        commonPage.waitUntilElementIsVisible("Discuss");
        commonPage.click("Discuss");
        commonPage.waitUntilElementIsVisible("chatField");
        commonPage.insertIntoField("Deactive Age filter", "chatField");
        commonPage.click("sendMessage");
        assertThat(contactRequestPage.shouldSendMessageAsUsual("Deactive Age filter"), is(equalTo(true)));
    }

    public boolean shouldSeeMessageWith(String userName) {
        commonPage.waitUntilElementIsVisible("Messages");
        commonPage.click("Messages");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);

        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message__head']//*[text() = '" + userName + "']")));

        ArrayList<String> userNames = new ArrayList<>();
        ArrayList<WebElement> userNameList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='message__head'] h5"))));
        for (WebElement userName1 : userNameList) {
            String textOfUserName = userName1.getText();
            userNames.add(textOfUserName);
        }
        System.out.println(userNames);

        for (int i = 0; i < userNames.size(); i++) {

            if (userNames.get(i).contentEquals(userName)) {
                if (i == 0) {
                    System.out.println(userName);
                    System.out.println(i + " pass");
                    ArrayList<WebElement> message = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='clickable-overlay']")));
                    message.get(i).click();
                    return true;
                }
                ArrayList<WebElement> acceptMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='message__head'] h5")));
                String commercialMess = acceptMess.get(0).getText();
                if (i == 1 && commercialMess.contentEquals("L'Equipe Mektoube")) {
                    System.out.println(commercialMess + " " + i);
                    ArrayList<WebElement> message = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='clickable-overlay']")));
                    message.get(i).click();

                    return true;
                }

            }
        }
        return false;
    }

    public boolean shouldSeeSmileVisitNotificationOf(String userName) {
        commonPage.waitUntilElementIsVisible("NotificationTextLink");
        commonPage.click("NotificationTextLink");
        WebDriverWait wait = new WebDriverWait(getDriver(), 50);
        ArrayList<String> userNameList = new ArrayList<>();
        ArrayList<WebElement> userNameElement = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".notification__meta h5"))));
        for (WebElement userNameItem : userNameElement) {
            userNameList.add(userNameItem.getText());
        }
        for (int i = 0; i < userNameList.size(); i++) {
            if (userNameList.get(i).contentEquals(userName)) {
                System.out.println(userNameList.get(i) + " " + i);
                return true;
            }

        }
        System.out.println(userNameList);
        return false;
    }

    public void discussWith(String userName) {
        commonPage.waitUntilElementIsVisible("SearchForm");
        commonPage.clickFilterByUsername();
        commonPage.clearTextFromField("SearchUserNameField");
        commonPage.waitAboutSecond(1);
        commonPage.insertIntoField(userName, "SearchUserNameField");
        commonPage.click("ValidateBtn");
        commonPage.waitAboutSecond(1);
        commonPage.click("submitFilter");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile__content']//*[text() = '" + userName + "']")));
        account.click();
        commonPage.waitUntilElementIsVisible("Discuss");
        commonPage.click("Discuss");
        commonPage.waitUntilElementIsVisible("chatField");
        commonPage.insertIntoField("Send message before active age filter", "chatField");
        commonPage.click("sendMessage");
        assertThat(contactRequestPage.shouldSendMessageAsUsual("Send message before active age filter"), is(equalTo(true)));
    }

    public void seeHisFavoritesOnlineTheCaseExistingProfilesOnline() {
        //count profile in favorite that is online
        ArrayList<WebElement> onlineList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='status status--online']")));
        System.out.println("There are (is) " + onlineList.size() + " in favorite list that is online");
    }

    public void seeHisFavoritesOnlineTheCaseNoProfileOnline() {
        ArrayList<WebElement> onlineList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='status status--online']")));
        ArrayList<WebElement> favorUserList = new ArrayList<>(getDriver().findElements(By.cssSelector("li[class='profile--item']")));
        ArrayList<WebElement> awayList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='status status--away']")));
        System.out.println("There are (is) " + (favorUserList.size() - onlineList.size() - awayList.size()) + " in favorite list that is not online");
    }

    public void showingErrorMessageThisProfileAlreadyInYourFavorites() {
        String errorMessage = getDriver().findElement(By.cssSelector("#root >  .container-fluid > .top-message-overlay > .top-message-text > div")).getText();
        assertEquals("Déjà dans vos favoris", errorMessage);
        getDriver().close();
    }

    public void removeFirstProfileFromFavorisList(){
        //remove first person from favoris list
        String unfavoriteId = getDriver().findElement(org.openqa.selenium.By.cssSelector("ul[class='list-profiles list-profiles--favoris'] > li:nth-child(1)")).getAttribute("id");
        System.out.println("id is "+unfavoriteId);
        WriteToFile(unfavoriteId);
        getDriver().findElement(org.openqa.selenium.By.cssSelector(".list-profiles.list-profiles--favoris > li:nth-child(1) > div > div > .material-icons.right-icon")).click();
        getDriver().findElement(org.openqa.selenium.By.cssSelector("ul[role='menu'] > li")).click();
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

    public void theFavorisListDoNotShowAboveProfile() {
        getDriver().navigate().refresh();
        String unfavoriteId = "";
        try {
            unfavoriteId = ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<WebElement> favoriteList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul[class='list-profiles list-profiles--favoris'] > li")));
        for (WebElement user : favoriteList) {
            System.out.println("real id : " + user.getAttribute("id") + " unfavorite id : " + unfavoriteId);
            assertNotEquals(unfavoriteId, user.getAttribute("id"));
            System.out.println("passed");
        }
        getDriver().close();
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

    public void thePageShowsErrorMessage(String field) {
        String cssSelector = TestDataService.properties.getProperty(field);
        String errorMessage = getDriver().findElement(By.cssSelector(cssSelector)).getText();
        assertEquals("Personne bloquée, Ajout à vos favoris impossible !", errorMessage);
        getDriver().close();
    }

    public void clickOnFirstProfileInDiscovery() {
        String name = getDriver().findElement(By.cssSelector("ul.list-profiles > li:nth-child(1) > a.profile  > div.profile__content > h5")).getText();
        WriteToFile(name);
        getDriver().findElement(By.cssSelector("ul.list-profiles > li:nth-child(1) > a.profile  > div.profile__content > h5")).click();
    }

    public void checkingAboveProfileHaveToInFavoriteList(){
        String favortiName = "";
        try {
            favortiName = ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<WebElement> favoriteList = new ArrayList<>(getDriver().findElements(org.openqa.selenium.By.cssSelector("ul.list-profiles > li > div.profile  > div.profile__content > h5")));
        for(WebElement user: favoriteList){
            if(user.getText().equals(favortiName)){
                System.out.println("passed");
                return;
            }
        }
        assertEquals("error",favortiName);
    }

    public void theDiscoveryPageDontShow(String name){
        //no item or have items but dont appear shainez
        if(getDriver().findElement(By.cssSelector(".no-items__inner")).isEnabled()){
            System.out.println("Passed");
            return;
        }
        ArrayList<WebElement> discoveryList = new ArrayList<>(getDriver().findElements(
                By.cssSelector("ul.list-profiles > li > div.profile  > div.profile__content > h5")));
        for(WebElement user: discoveryList){
            assertNotEquals(user.getText(),name);
        }
        System.out.println("done");
        System.out.println("the discovery page dont show name is "+name);
    }

    public void displayBlackList() {
        boolean isDisplay = getDriver().findElement(By.cssSelector("div[class='setting--modal modal is--opened']")).isDisplayed();
        if (isDisplay) {
            System.out.println("Displayed black list!");
        } else {
            System.out.println("Dont display black list");
        }
        //check gender of all users, return true if all is men, else false
        getDriver().close();
    }

    public void clickToOneConversation(){
        String blockUserName="";
        getDriver().findElement(org.openqa.selenium.By.cssSelector("div[style='position: relative;'] > div:nth-child(1) > div.message__content > div.message__head h5")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        blockUserName = getDriver().findElement(org.openqa.selenium.By.cssSelector("div[class='messages__body'] > div:nth-child(1) > div:nth-child(1) > div.message__content > div.message__head > h5 ")).getText();
        WriteToFile(blockUserName);
    }

    public void checkBlockedResult() throws Exception {
        String blockUserName=ReadFromFile();
        //if added blacklist then this person will show in blacklist
        //MonCompteButton
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //click on Mon Comple button
        getDriver().findElement(org.openqa.selenium.By.cssSelector("span[class='my-acc']")).click();
        //click on Réglages Button
        getDriver().findElement(org.openqa.selenium.By.cssSelector("div[class='user__menu'] > ul > li:nth-child(4) > a > div.text")).click();
        //click on Blackliste of woman
        getDriver().findElement(org.openqa.selenium.By.xpath("//h5[text()='Blackliste']")).click();
        //wait for load black list profile
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //get blocked user list
        ArrayList<WebElement> blockUserList = new ArrayList<>(getDriver().findElements(org.openqa.selenium.By.cssSelector("div[class='blocklist-list'] > div")));
        //find
        System.out.println("Block user Name: "+blockUserName);
        for(int i=0;i<blockUserList.size();i++){
            //get Name of user in blockUserList
            String demo = getDriver().findElement(org.openqa.selenium.By.cssSelector("div[class='blocklist-list'] > div:nth-child("+(i+1)+") > div[class='left-info'] > div.user-info > h3")).getText();
            System.out.println("Name "+(i+1)+": "+demo);
            //
            try {
                assertEquals(demo, blockUserName);
                System.out.println("Block successful");
                //unblock
                getDriver().findElement(org.openqa.selenium.By.cssSelector("div.blocklist-list div.blocklist-item:nth-child(1) i")).click();
                getDriver().findElement(org.openqa.selenium.By.cssSelector("div.blocklist-list div.blocklist-item:nth-child(1) ul li a")).click();
                return;
            }catch (Exception e){
                System.out.println("Block faild");
            }
        }
    }

    public void clickFirstPersonInDiscovery(){
        String blockUserName = getDriver().findElement(By.cssSelector("ul[class='list-profiles'] > li:nth-child(1) >a.profile > div[class='profile__content'] > h5")).getText();
        WriteToFile(blockUserName);
        //System.out.println("Blockusername in clickOnePerson: "+blockUserName);
        getDriver().findElement(By.cssSelector("ul[class='list-profiles'] > li:nth-child(1) >a.profile > div[class='profile__content'] > h5")).click();
    }

    public void thePageShowNotificationTheBlockIsConfirmed(){
        String realAlert = getDriver().findElement(By.cssSelector("#root > div.container-fluid > div[class='top-message-overlay success'] > div.top-message-text > div")).getText();
        assertEquals("Le blocage est confirmé", realAlert);
    }

    public void theBlockListHaveToStoreAboveProfile(){
        ArrayList<WebElement> blockList = new ArrayList<>(getDriver().findElements(By.cssSelector(".blocklist-list > .blocklist-item > .left-info > div.user-info > h3")));
        String blockName="";
        try {
            blockName = ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count=0;
        for(WebElement user: blockList){
            if(user.getText().equals(blockName)){
                count=1;
                System.out.println("add profile in black list successfull");
                return;
            }
        }
        if(count==0){
            assertEquals("ERRROR","FAILD");
        }
    }

    public void checkUnblockedResult(){
        String unlockName="";
        try {
            unlockName = ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //get all user in black list
        ArrayList<WebElement> blockUserList = new ArrayList<>(getDriver().findElements(By.cssSelector("div.blocklist-list > div.blocklist-item > div.left-info > div.user-info > h3")));
        for(WebElement user: blockUserList){
            System.out.println(user.getText());
            if(user.getText().equals(unlockName)){
                assertEquals(unlockName,"error");
            }
        }
    }

    public void disableAgeFilter(){
        try{
            if(getDriver().findElement(By.cssSelector("a.age-filter-config")).isEnabled()){
                getDriver().findElement(By.cssSelector("input#ageFilter")).click();
            }
        }catch (Exception e){
            System.out.println("done");
        }
    }

    public void thePageDontShowAPersonWhoIsBlockingUs(){
        try {
            ArrayList<WebElement> searchedProfile = new ArrayList<>(getDriver().findElements(By.cssSelector("div.profile__content > h5")));
            for (WebElement prof : searchedProfile) {
                //not find is correctly
                assertNotEquals(prof.getText(), "shaiez29");
            }
        }catch (Exception e){//cant find any profile
            String noItemNoti = getDriver().findElement(By.cssSelector("div.no-items__inner > h4")).getText();
            assertEquals("Aucun resultat trouvé pour votre recherche.",noItemNoti);
        }
    }

    public void allProfileDontShowNotificationBox(){
        //save all id of profiles
        ArrayList<WebElement> personList = new ArrayList<>(getDriver().findElements(By.cssSelector("ul.list-profiles > li")));
        ArrayList<String> idList = new ArrayList<>();
        for(WebElement per: personList){
            if(per.getAttribute("class").equals("profile--item fake-profile-boost")){
                continue;
            }
            idList.add(per.getAttribute("id"));
        }
        //click on all profile and check notification box
        //expected: dont show noti box
        for(String id: idList){
            //click on profile that have this id
            getDriver().findElement(By.cssSelector("#"+id)).click();
            //expected: dont show noti box
            try{
                if(getDriver().findElement(By.cssSelector("div.alert__text")).isEnabled()) {
                    assertEquals("dont have noti box","have noti box");
                    break;
                }
            }catch (Exception e){
                //click on discovery button
                getDriver().findElement(By.cssSelector("nav.nav.nav--primary ul li:nth-child(1) a span.icon")).click();
                continue;
            }
        }
    }

    public void enableAgeFilter() {
        try {
            if (getDriver().findElement(By.cssSelector("a.age-filter-config")).isEnabled()) {
                System.out.println("done");
                //save range of age in txt file
                String rangeAge = getDriver().findElement(By.cssSelector("span.age-filter-info")).getText();
                WriteToFile(rangeAge);
            }
        } catch (Exception e) {
            getDriver().findElement(By.cssSelector("input#ageFilter")).click();
            //save range of age in txt file
            String rangeAge = getDriver().findElement(By.cssSelector("span.age-filter-info")).getText();
            WriteToFile(rangeAge);
        }
    }

    public void thePageShowGreenAlert() {
        assertEquals("Vos préférences ont été mises à jour",getDriver().findElement(By.cssSelector("div.top-message-text > div")).getText());
    }

    public void thePageDontHave(String element) {
        String cssSelector = TestDataService.properties.getProperty(element);
        try {
            if (getDriver().findElement(By.cssSelector(cssSelector)).isEnabled()) {
                System.out.println("faild");
                assertTrue(getDriver().findElement(By.cssSelector(cssSelector)).isEnabled());
            }
        } catch (Exception e) {
            System.out.println("pass ");
        }
    }

    public void makeSureBlacklistDoNotContainAccountWeWillGoingToBeSearching(String account) {

        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("settingBtn");
        commonPage.click("settingBtn");
        commonPage.waitUntilElementIsVisible(".list-settings");
        commonPage.scrollToElementThatHasTextAndClick("//div[@class='list-settings']//*[contains(text(),'Blackliste')]");
        commonPage.waitUntilElementIsVisible("div[class='setting--modal blocklist-modal modal is--opened']");
        ArrayList<WebElement> blockedAccount = new ArrayList<>(getDriver().findElements(By.cssSelector(".blocklist-item")));
        if (blockedAccount.size() == 0) {
            System.out.println("black list is empty");
            commonPage.click("div[class='setting--modal blocklist-modal modal is--opened'] a[class='closer right-side'] i[class='material-icons']");
            commonPage.click("DiscoveriesScreenBtn");
        } else {
            for (int i = 0; i < blockedAccount.size(); i++) {
                String userWeAlreadyBlocked = blockedAccount.get(i).findElement(By.cssSelector("h3")).getText();
                if (userWeAlreadyBlocked.contentEquals(account)) {
                    blockedAccount.get(i).findElement(By.cssSelector("i[class='remove-action material-icons']")).click();
                    blockedAccount.get(i).findElement(By.cssSelector("a[class='remove-action']")).click();
                    assertThat(commonPage.shouldSeeMessagePopupAtTop("Personne débloquée"), is(equalTo(true)));
                    commonPage.waitAboutSecond(4);
                    break;
                }

            }

            commonPage.click("div[class='setting--modal blocklist-modal modal is--opened'] a[class='closer right-side'] i[class='material-icons']");
            commonPage.click("DiscoveriesScreenBtn");
        }

    }

    public boolean shouldNotSeeAccountInBlacklist(String account) {
        commonPage.waitAboutSecond(4);
        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("settingBtn");
        commonPage.click("settingBtn");
        commonPage.waitUntilElementIsVisible(".list-settings");
        commonPage.scrollToElementThatHasTextAndClick("//div[@class='list-settings']//*[contains(text(),'Blackliste')]");
        commonPage.waitUntilElementIsVisible("div[class='setting--modal blocklist-modal modal is--opened']");
        ArrayList<WebElement> blockedAccount = new ArrayList<>(getDriver().findElements(By.cssSelector(".blocklist-item")));
        if (blockedAccount.size() == 0) {
            System.out.println("black list is empty");
            return true;
        } else {
            for (int i = 0; i < blockedAccount.size(); i++) {
                String userWeAlreadyBlocked = blockedAccount.get(i).findElement(By.cssSelector("h3")).getText();
                System.out.println(userWeAlreadyBlocked);
                if (userWeAlreadyBlocked.contentEquals(account)) {
                    System.out.println(userWeAlreadyBlocked);
                    return false;
                }

            }

            return true;
        }
    }

    public void makeSureAgeFilterOfManAccountStillRemainTurnOff(String username) {
        commonPage.loginWithAccountAndPassword(username, "Mektoubi2017");
        deactiveAgeFilterAndLogOut();
    }

    public boolean shouldSeeRedBorderInPasswordAndNewEmailFields() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        ArrayList<WebElement> redBorder = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='input-field-container black-skin border-skin is-invalid']"))));
        if (redBorder.size() == 2) {
            return true;

        }
        return false;
    }


    public boolean checkIfWarningConfirmEmailExist() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            ArrayList<WebElement> warningConfirmEmail = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a.warning-info"))));
            if (warningConfirmEmail.size() > 0) {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
        return true;
    }

    public void verifyConfirmEmailLink() {
        commonPage.gotoUrl("http://www.google.com/gmail/");
//        commonPage.waitUntilElementIsVisible("div[data-allow-at-sign='true']");
        commonPage.waitAboutSecond(2);
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        ArrayList<WebElement> resetPassword = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='xT']//*[contains(text(),'Validation de votre adresse e-mail')]"))));
        resetPassword.get(0).click();
        commonPage.waitAboutSecond(4);
        ArrayList<WebElement> expandMail = new ArrayList<>(getDriver().findElements(By.cssSelector("div.ajV img[src='//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif']")));
        if (expandMail.size() > 0) {
            commonPage.scrollToAndClick("div.ajV img[src='//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif']:last-child");
        }
        commonPage.waitAboutSecond(1);
        ArrayList<WebElement> resetPasswordLink = new ArrayList<>(getDriver().findElements(By.xpath("//a/span[contains(text(),'Confirmez votre adresse e-mail')]")));
//        commonPage.clickOnRadionButtonThatHasText("//a/span[contains(text(),'Je confirme ma demande de désinscription')]");
        System.out.println(resetPassword.size());
        resetPasswordLink.get(resetPasswordLink.size() - 1).click();
    }

    public void canNotSendMessage(){
        //click on image icon
//        commonPage.click("chooseImageIcon");
//        notiPage.thePageShowGreenNotificationIsAt("Vous ne pouvez pas écrire à shainez29","redNotiInTopHeader");
//        commonPage.waitAboutSecond(4);
        //click on gif icon
        commonPage.click("gifIcon");
        notiPage.thePageShowGreenNotificationIsAt("Vous ne pouvez pas écrire à shainez29","redNotiInTopHeader");
        commonPage.waitAboutSecond(4);
        //disable textfield
        assertEquals(false,getDriver().findElement(By.cssSelector("#field-chat")).isEnabled());
        //disable send button
        assertEquals(false,getDriver().findElement(By.cssSelector("button[type='submit']")).isEnabled());
    }

    public void thePageShowPopUpToChooseAgeRange(){
        assertTrue(getDriver().findElement(By.cssSelector("div[class='setting--modal age_filter_modal modal is--opened']")).isDisplayed());

        assertEquals("Ne soyez contacté(e) que par les personnes qui correspondent à la tranche d'âge sélectionnée:",
                getDriver().findElement(By.cssSelector("div[class='modal--body'] p")).getText());

        String ageRangInForm = getDriver().findElement(By.cssSelector("div.modal--body h5")).getText();
        String[] ageRangeInFormList = ageRangInForm.split(" ");
        int minAgeInForm = Integer.parseInt(ageRangeInFormList[1]);
        int maxAgeInForm = Integer.parseInt(ageRangeInFormList[3]);
        String ageRangeInLabel = getDriver().findElement(By.cssSelector("span.age-filter-info")).getText();
        String[] ageRangeInLabelList = ageRangeInLabel.split(" ");
        int minAgeInLabel = Integer.parseInt(ageRangeInLabelList[0]);
        int maxAgeInLabel = Integer.parseInt(ageRangeInLabelList[2]);
        assertEquals(minAgeInForm,minAgeInLabel);
        assertEquals(maxAgeInForm,maxAgeInLabel);
    }

    public void ageFilterInfoDoNotChange(){
        String currentAgeInfo = getDriver().findElement(By.cssSelector("span.age-filter-info")).getText();
        String oldAgeInfo = "";
        try {
            oldAgeInfo = ReadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(oldAgeInfo,currentAgeInfo);
    }

    public void clickAManProfileWhoIsOutOfMyFilter(){
        //click on first profile
        commonPage.click("firstProfileInDiscovery");
        int count=0;
        while(count!=1){
            //get age of this profile
            //scroll to see MySheet and check pratiquant
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));            String currentAgeText = getDriver().findElement(By.cssSelector("ul.list-complex li:nth-child(1) h2")).getText();
            String[] currentAgeTextList = currentAgeText.split("\n");
            int currentAge = Integer.parseInt(currentAgeTextList[0]);

            if(currentAge<20||currentAge>21){
                String textUnderProfile = getDriver().findElement(By.cssSelector("div.alert__text")).getText();
                System.out.println("text under profile: "+textUnderProfile);
                assertEquals("Cette personne est bloquée par vos filtres, elle ne pourra pas vous contacter.\n" +
                                "Faites le premier pas pour discuter \uD83D\uDE0A",
                        textUnderProfile);
                count=1;
                return;
            }
            //scroll on Top
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("window.scrollBy(0,-1000)");
            //click next profile
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='control-button next-nav']")));
            getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();
        }
    }

    public void visitAManProfileWhoIsOutOfMyFilterAndWhoseBirthdayIs(){

        //click on first profile
        commonPage.click("firstProfileInDiscovery");
        int count=0;
        while(count!=1){
            //get age of this profile
            //scroll to see MySheet and check pratiquant
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getDriver().findElement(By.cssSelector("div.section__inner div.section__group:nth-child(1) div.section__group-head h2")));            String currentAgeText = getDriver().findElement(By.cssSelector("ul.list-complex li:nth-child(1) h2")).getText();
            String[] currentAgeTextList = currentAgeText.split("\n");
            int currentAge = Integer.parseInt(currentAgeTextList[0]);
            String textUnderProfile = getDriver().findElement(By.cssSelector("div.alert__text")).getText();
            System.out.println("text under profile: "+textUnderProfile);
            if(currentAge<20||currentAge>21){
                assertEquals("Cette personne est bloquée par vos filtres, elle ne pourra pas vous contacter.\n" +
                                "Faites le premier pas pour discuter \uD83D\uDE0A",
                        textUnderProfile);
                count=1;
                return;
            }
            assertEquals("C'est son anniversaire aujourd'hui!Souhaite-lui un Joyeux Anniversaire",textUnderProfile);
            //scroll on Top
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("window.scrollBy(0,-1000)");
            //click next profile
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='control-button next-nav']")));
            getDriver().findElement(By.cssSelector("a[class='control-button next-nav']")).click();
        }
    }

    public boolean shouldSeeRedBorderInMessageField() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        ArrayList<WebElement> redBorder = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='input-field-container black-skin border-skin is-invalid']"))));
        if (redBorder.size() == 1) {
            return true;

        }
        return false;
    }

    public boolean settingIsClosed(String modal) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 4);
        String cssSelector = TestDataService.properties.getProperty(modal);
        if (cssSelector == null) {
            cssSelector = modal;
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("css " + cssSelector);
        ArrayList<WebElement> settingModal = new ArrayList<>(getDriver().findElements(By.cssSelector(modal)));
        //ArrayList<WebElement> settingModal = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(modal))));
        try {

            if (settingModal.size() > 0) {
                System.out.println(settingModal.size());
                return false;
            }
        } catch (Exception e) {
            System.out.println(settingModal.size());
            return true;
        }
        return true;
    }

    public void changeSettingOfNotification() {
        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("settingBtn");
        commonPage.click("settingBtn");
        commonPage.waitUntilElementIsVisible(".list-settings");
        commonPage.scrollToElementThatHasTextAndClick("//div[@class='list-settings']//*[contains(text(),'Notifications')]");
        commonPage.waitUntilElementIsVisible("div[class='setting--modal notification-modal modal-400 mobile-nofull modal is--opened']");
        commonPage.click("div[class='setting--modal notification-modal modal-400 mobile-nofull modal is--opened'] input[type='checkbox']");
    }

    public void visitingAProfileFromTheFavoritesPage() {
        //visit first profile in favorite list
        getDriver().findElement(By.cssSelector("ul[class='list-profiles list-profiles--favoris'] > li:nth-child(1) > div > div[class='profile__content'] h5")).click();
        if (getDriver().getCurrentUrl().contains("/main/profil/")) {
            System.out.println("Visting a profile is successful!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println("Visting a profile is not successful!!");
    }

    public void editNicknameAndCheckNewNickname() {
        commonPage.waitUntilElementIsVisible("input[value='samiracute']");
        WebElement nickNameField = getDriver().findElement(org.openqa.selenium.By.cssSelector("input[value='samiracute']"));
        nickNameField.clear();
        nickNameField.sendKeys("samirababy");
        commonPage.click("div.form--actions>button");
        commonPage.shouldSeeMessagePopupAtTop("Votre prénom a bien été modifié");

        WebElement newNickName = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.user__meta h1"));
        assertEquals("Samirababy", newNickName.getText());
    }
    public void insertAntiUsernameFromListAndClickValidate() throws FileNotFoundException {
        Scanner s = new Scanner(new File("C:\\Users\\chipn\\Desktop\\AT-Mektoube\\qa-responsive\\src\\test\\resources\\data_test\\antiUsernamePattern.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() <= 10) {
                String newlist = "a" + list.get(i) + "12";
                commonPage.waitAboutSecond(4);
                commonPage.click("button.edit-name-btn");
                commonPage.clearTextFromField("input[type='text']");
                commonPage.insertIntoField(newlist,"input[type='text']");
                commonPage.click("button.mdc-button.mdc-button--unelevated.mobile-fixed-bottom-btn");
                commonPage.thePageShowErrorMessageIs("Ce prénom n’est pas accepté, veuillez en choisir un autre");
                System.out.println(newlist);
            }
            else {
                commonPage.waitAboutSecond(4);
                commonPage.click("button.edit-name-btn");
                commonPage.clearTextFromField("input[type='text']");
                commonPage.insertIntoField(list.get(i),"input[type='text']");
                commonPage.click("button.mdc-button.mdc-button--unelevated.mobile-fixed-bottom-btn");
                commonPage.thePageShowErrorMessageIs("Ce prénom n’est pas accepté, veuillez en choisir un autre");
                System.out.println(list.get(i));
            }
        }
        System.out.println("ket thuc vong lap");
    }
}
