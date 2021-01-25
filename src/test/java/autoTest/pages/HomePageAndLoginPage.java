package autoTest.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import autoTest.service.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

public class HomePageAndLoginPage extends PageObject {
    MektoubeCommonPage commonPage = new MektoubeCommonPage();
    DiscoveriesPage discoveriesPage = new DiscoveriesPage();

    public void enterAValidDateOfBirthAndValidate() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        commonPage.waitAboutSecond(3);
        WebElement day = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='JJ']")));
        day.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        day.sendKeys("31");

        WebElement month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='MM']")));
        month.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        month.sendKeys("10");

        WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='AAAA']")));
        year.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        year.sendKeys("1997");
        commonPage.waitAboutSecond(3);
        WebElement checkButton = getDriver().findElement(org.openqa.selenium.By.cssSelector("button[class='question-circle-check-btn']"));
        checkButton.click();
    }

    public boolean shouldSeeUniqueCity() {
        ArrayList<String> uniqueCityValues = new ArrayList<>();
        ArrayList<WebElement> uniqueCity = new ArrayList<>(getDriver().findElements(By.cssSelector("input[type='radio']")));
        if (uniqueCity.size() > 1) {
            for (WebElement uniqueValue : uniqueCity) {
                uniqueCityValues.add(uniqueValue.getAttribute("value"));
            }
            System.out.println(uniqueCityValues + "fail");
            return false;
        }
        System.out.println(uniqueCityValues + "pass");
        return true;
    }

    public void insertEmailAndUserNameForWomanAccount(String email, String username) {
        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys(email);
        String emailValue = emailField.getAttribute("value");
        System.out.println("This is email use for run automation" + " " + emailValue);
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('emailField','" + emailValue + "')");

        WebElement nameField = getDriver().findElement(By.cssSelector("input[name='signUpLogin']"));
        nameField.sendKeys(username);
        String nameValue = nameField.getAttribute("value");
        System.out.println("This is username use for run automation" + " " + nameValue);

        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('nameField','" + nameValue + "')");
    }




    public boolean theFieldRemainsEmpty() {
        WebElement birthDayField = getDriver().findElement(By.cssSelector("input[placeholder='JJ']"));
        String valueOfBirthday = birthDayField.getAttribute("value");
        if (valueOfBirthday.contentEquals("")) {
            System.out.println("empty" + " " + valueOfBirthday + " " + "hihi");
            return true;
        } else {
            System.out.println("can fill invalid number" + valueOfBirthday);
            return false;
        }
    }

    public void enterAInvalidDateToBirthdayField() {
        commonPage.clearTextFromField("input[placeholder='JJ']");
        commonPage.clearTextFromField("input[placeholder='MM']");
        commonPage.clearTextFromField("input[placeholder='AAAA");
        getDriver().findElement(By.cssSelector("input[placeholder='JJ']")).sendKeys("31");
        getDriver().findElement(By.cssSelector("input[placeholder='MM']")).sendKeys("11");
        getDriver().findElement(By.cssSelector("input[placeholder='AAAA")).sendKeys("1997");
        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
    }

    public void insertRandomEmailForMenToEmailField() {
        long randomNumber = (long) ((JavascriptExecutor) getDriver()).executeScript("return Math.floor(Math.random()*1111111)");
        String randomEmail = "kamel" + randomNumber + "@gmail.com";
        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys(randomEmail);
        String emailValue = emailField.getAttribute("value");
        System.out.println("This is email use for run automation" + " " + emailValue);
    }

    public void insertRandomUsernameForMenToUsernameField() {
        long randomNumber = (long) ((JavascriptExecutor) getDriver()).executeScript("return Math.floor(Math.random()*111111)");
        String randomUserName = "kamel" + randomNumber;
        WebElement nameField = getDriver().findElement(By.cssSelector("input[name='signUpLogin']"));
        nameField.sendKeys(randomUserName);
        String nameValue = nameField.getAttribute("value");
        System.out.println("This is username use for run automation" + " " + nameValue);
    }

    public boolean checkIfEyeButtonWorking() {
        WebElement inputPassWord = getDriver().findElement(By.cssSelector("input[name='password']"));
        String PassWWordElement = inputPassWord.getAttribute("type");
        if (PassWWordElement.contentEquals("text")) {
            System.out.println(PassWWordElement + " pass");
            return true;
        }
        System.out.println(PassWWordElement + " fail");
        return false;
    }

    public boolean postalCodeFieldRemainEmpty() {
        WebElement postalCode = getDriver().findElement(By.cssSelector("input[type='number']"));
        String postalValue = postalCode.getAttribute("value");
        if (postalValue.contentEquals("")) {
            System.out.println(postalValue + " pass");
            return true;
        }
        System.out.println(postalValue + " fail");
        return false;
    }

    public boolean tooltipZipcodeIsAppear() {
        commonPage.waitAboutSecond(1);
        WebElement toolTippostalCode = getDriver().findElement(By.cssSelector("label[data-shrink='true']"));
        String postalToolTipValue = toolTippostalCode.getAttribute("data-shrink");
        if (postalToolTipValue.contentEquals("true")) {
            System.out.println(postalToolTipValue + " pass");
            return true;
        }
        System.out.println(postalToolTipValue + " pass");
        return false;
    }

    public boolean viewCity(int city) {
        ArrayList<WebElement> cityRadioButton = new ArrayList<>(getDriver().findElements(By.cssSelector(".field--radio-input input[type='radio']")));
        int numberOfCityRadioButton = cityRadioButton.size();
        if (numberOfCityRadioButton == city) {
            System.out.println(numberOfCityRadioButton + " pass");
            return true;
        }
        System.out.println(numberOfCityRadioButton + " fail");
        return false;
    }

    public void moveTallSliderToChooseHowToTall() {
        for (int i = 160; i <= 175; i++) {
            getDriver().findElement(By.cssSelector("div[class='rc-slider-handle']")).sendKeys(Keys.ARROW_UP);
        }
        WebElement tallValue = getDriver().findElement(By.cssSelector("span[class='handle-value']"));
        String tallValueElement = tallValue.getText();
        if (tallValueElement.contentEquals("175 cm")) {
            System.out.println(tallValueElement + " pass");
        } else {
            System.out.println(tallValueElement + " fail");
        }

    }

    public void choseServeralOptionsOfQuestionInEachRegistrationForm() {
        commonPage.waitUntilElementIsVisible(".list--radio");
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(1) input[type='radio']")).click();
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(2) input[type='radio']")).click();
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(3) input[type='radio']")).click();
    }

    public boolean skipAllQuestionsInEveryRegistrationForm() {
        getDriver().findElement(By.cssSelector("a[class='question-skip']")).click();
        String jobForm = getDriver().getCurrentUrl();
        if (!jobForm.contentEquals("https://www.mektoube.fr/inscription/jobForm")) {
            return false;

        }
        getDriver().findElement(By.cssSelector("a[class='question-skip']")).click();
        String maritalForm = getDriver().getCurrentUrl();
        if (!maritalForm.contentEquals("https://www.mektoube.fr/inscription/maritalForm")) {
            return false;

        }
        getDriver().findElement(By.cssSelector("a[class='question-skip']")).click();
        String religiousForm = getDriver().getCurrentUrl();
        if (!religiousForm.contentEquals("https://www.mektoube.fr/inscription/religiousForm")) {
            return false;

        }
        getDriver().findElement(By.cssSelector("a[class='question-skip']")).click();
        String silhouetteForm = getDriver().getCurrentUrl();
        if (!silhouetteForm.contentEquals("https://www.mektoube.fr/inscription/silhouetteForm")) {
            return false;

        }
        getDriver().findElement(By.cssSelector("a[class='question-skip']")).click();
        String tallForm = getDriver().getCurrentUrl();
        if (!tallForm.contentEquals("https://www.mektoube.fr/inscription/tallForm")) {
            return false;

        }
        getDriver().findElement(By.cssSelector("a[class='question-skip']")).click();
        String enfantsForm = getDriver().getCurrentUrl();
        if (!enfantsForm.contentEquals("https://www.mektoube.fr/inscription/enfantsForm")) {
            return false;

        }
        getDriver().findElement(By.cssSelector("a[class='question-skip']")).click();
        String degreeForm = getDriver().getCurrentUrl();
        if (!degreeForm.contentEquals("https://www.mektoube.fr/inscription/degreeForm")) {
            return false;

        }
        getDriver().findElement(By.cssSelector("a[class='question-skip']")).click();
        String discoveries = getDriver().getCurrentUrl();
        if (!discoveries.contentEquals("https://www.mektoube.fr/main/discoveries")) {
            return false;

        }
        System.out.println(silhouetteForm + " " + discoveries);
        return true;
    }

    public boolean answerAllQuestionInRegistrationForm() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement radioList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list--radio")));

        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(1) input[type='radio']")).click();
        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
        WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
        if (!popupErrorMsgElements.getText().contentEquals("Votre profil a été mis à jour")) {
            System.out.println(popupErrorMsgElements.getText() + " fail");
            return false;
        }
        System.out.println(popupErrorMsgElements.getText() + " pass");

        String maritalForm = getDriver().getCurrentUrl();
        if (!maritalForm.contentEquals("https://www.mektoube.fr/inscription/maritalForm")) {
            System.out.println(maritalForm + "fail");
            return false;

        }
        System.out.println(maritalForm + "pass");
        try {
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(1) input[type='radio']")).click();
        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
        WebElement popupErrorMsgElements2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
        if (!popupErrorMsgElements2.getText().contentEquals("Votre profil a été mis à jour")) {
            System.out.println(popupErrorMsgElements2.getText() + " fail");
            return false;
        }
        System.out.println(popupErrorMsgElements2.getText() + " pass");
        try {
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String religiousForm = getDriver().getCurrentUrl();
        if (!religiousForm.contentEquals("https://www.mektoube.fr/inscription/religiousForm")) {
            System.out.println(religiousForm + "fail");
            return false;

        }
        System.out.println(religiousForm + "pass");
        try {
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(1) input[type='radio']")).click();
        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
        WebElement popupErrorMsgElements3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
        if (!popupErrorMsgElements3.getText().contentEquals("Votre profil a été mis à jour")) {
            System.out.println(popupErrorMsgElements3.getText());
            return false;
        }
        try {
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String silhouetteForm = getDriver().getCurrentUrl();
        if (!silhouetteForm.contentEquals("https://www.mektoube.fr/inscription/silhouetteForm")) {
            return false;

        }
        try {
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(1) input[type='radio']")).click();
        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
        WebElement popupErrorMsgElements4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
        if (!popupErrorMsgElements4.getText().contentEquals("Votre profil a été mis à jour")) {
            System.out.println(popupErrorMsgElements4.getText());
            return false;
        }

        String tallForm = getDriver().getCurrentUrl();
        if (!tallForm.contentEquals("https://www.mektoube.fr/inscription/tallForm")) {
            return false;

        }
        try {
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 160; i < 175; i++) {
            getDriver().findElement(By.cssSelector("div[class='rc-slider-handle']")).sendKeys(Keys.ARROW_UP);
        }
        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
        WebElement popupErrorMsgElements5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
        if (!popupErrorMsgElements5.getText().contentEquals("Votre profil a été mis à jour")) {
            System.out.println(popupErrorMsgElements4.getText());
            return false;
        }

        String enfantsForm = getDriver().getCurrentUrl();
        if (!enfantsForm.contentEquals("https://www.mektoube.fr/inscription/enfantsForm")) {
            return false;

        }
        try {
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(1) input[type='radio']")).click();
        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
        WebElement popupErrorMsgElements6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
        if (!popupErrorMsgElements6.getText().contentEquals("Votre profil a été mis à jour")) {
            System.out.println(popupErrorMsgElements6.getText());
            return false;
        }

        String degreeForm = getDriver().getCurrentUrl();
        if (!degreeForm.contentEquals("https://www.mektoube.fr/inscription/degreeForm")) {
            return false;

        }
        try {
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(1) input[type='radio']")).click();
        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
        WebElement popupErrorMsgElements7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
        if (!popupErrorMsgElements7.getText().contentEquals("Votre profil a été mis à jour")) {
            System.out.println(popupErrorMsgElements7.getText());
            return false;
        }
        String discoveries = getDriver().getCurrentUrl();
        if (!discoveries.contentEquals("https://www.mektoube.fr/main/discoveries")) {
            System.out.println(discoveries + "fail");
            return false;

        }
        System.out.println(discoveries + "pass");
        return true;

    }

    public boolean checkIfDuplicateOptionOfCity() {
        commonPage.waitUntilElementIsVisible("div.list--radio");
        ArrayList<WebElement> inputElements = new ArrayList<>(getDriver().findElements(By.cssSelector("input[type='radio']")));
        System.out.println(inputElements.size());

        ArrayList<String> cityNames = new ArrayList<>();
        ArrayList<WebElement> cityList = new ArrayList<>(getDriver().findElements(By.cssSelector("span[class='form-label ']")));
        for (WebElement cityName : cityList) {
            String textOfCityName = cityName.getText();
            cityNames.add(textOfCityName);
        }
        System.out.println(cityNames);
        ArrayList<String> cityNames2 = new ArrayList<>();
        cityNames2.add(cityNames.get(0));

        for (int i = 1; i < cityNames.size(); i++) {
            for (int j = 0; j < cityNames2.size(); j++) {
                if (cityNames.get(i).contentEquals(cityNames2.get(j))) {
                    System.out.println(cityNames2 + " duplicate");
                    return false;
                }
            }
            cityNames2.add(cityNames.get(i));

        }
        return true;

    }

    public boolean checkIfEyeButtonWorkingInSignupPage() {
        WebElement inputPassWord = getDriver().findElement(By.cssSelector("input[name='signUpPassword']"));
        String PassWWordElement = inputPassWord.getAttribute("type");
        if (PassWWordElement.contentEquals("text")) {
            System.out.println(PassWWordElement + " pass");
            return true;
        }
        System.out.println(PassWWordElement + " fail");
        return false;

    }

    public boolean checkIfCGUPrivateCharterLinkWorking() {
        String parentHandle = getDriver().getWindowHandle();
        System.out.println("parent handle " + parentHandle);
        getDriver().findElement(By.cssSelector("span[class='label'] a[href='/cgu']")).click();


        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(parentHandle)) {
                getDriver().switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)

                String realUrlCGU = getDriver().getCurrentUrl();

                if (!realUrlCGU.contentEquals("https://www.mektoube.fr/cgu")) {
                    System.out.println(realUrlCGU + " " + "cgu url fail to get ");
                    return false;
                }
                commonPage.waitAboutSecond(3);
                System.out.println(realUrlCGU + " " + "get cgu url successful");
                getDriver().close();
            }
        }


        getDriver().switchTo().window(parentHandle);


        getDriver().findElement(By.cssSelector("span[class='label'] a[href='/charte-vie-privee'] ")).click();

        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(parentHandle)) {
                getDriver().switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
                try {
                    Thread.sleep(5 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String checkPaymentUrl = getDriver().getCurrentUrl();
                if (!checkPaymentUrl.contentEquals("https://www.mektoube.fr/charte-vie-privee")) {
                    System.out.println(checkPaymentUrl + " " + "Charte vie privée url fail to get");
                    return false;
                }
                System.out.println(checkPaymentUrl + " " + "get Charte vie privée url successful");
                getDriver().close();
            }
        }
        getDriver().switchTo().window(parentHandle);

        return true;

    }

    public boolean checkIfBlockButtonIsCheckedByDefault() {
        commonPage.waitUntilElementIsVisible("div[class='setting--modal report-abuse modal-480 modal is--opened']");
        WebElement blockButton = getDriver().findElement(By.cssSelector(".checkbox-space-between input[type='checkbox']"));
        if (blockButton.isSelected()) {
            System.out.println(blockButton.getAttribute("checked"));
            return true;
        }
        System.out.println(blockButton.getAttribute("checked"));
        return false;
    }

    public void clickBlockButtonToRemoveSelect() {
        commonPage.waitAboutSecond(3);
        getDriver().findElement(By.cssSelector(".checkbox-space-between input[type='checkbox']")).click();
    }

    public boolean bothTwoButtonPasswordVisibleShouldWork() {
        WebElement eyeButton1 = getDriver().findElement(By.cssSelector("div[class='input-field-container black-skin border-skin is-valid']:nth-child(1) input[name='passwd']"));
        String eyeButton1Attribute = eyeButton1.getAttribute("type");
        if (!eyeButton1Attribute.contentEquals("text")) {
            return false;
        }
        WebElement eyeButton2 = getDriver().findElement(By.cssSelector("div[class='input-field-container black-skin border-skin is-valid']:nth-child(2) input[name='new_data']"));
        String eyeButton2Attribute = eyeButton2.getAttribute("type");
        if (!eyeButton2Attribute.contentEquals("text")) {
            return false;
        }
        System.out.println(eyeButton1Attribute);
        System.out.println(eyeButton2Attribute);
        return true;
    }

    public boolean checkIfPasswordVisibleButtonIsWorking() {
        getDriver().findElement(By.cssSelector("div.form__body div.form__row:nth-child(1) button[aria-label='Toggle password visibility']")).click();
        WebElement inputPassWord = getDriver().findElement(By.cssSelector("input[name='password']"));
        String PassWWordElement = inputPassWord.getAttribute("type");
        if (!PassWWordElement.contentEquals("text")) {
            System.out.println(PassWWordElement + " fail");
            return false;
        }
        getDriver().findElement(By.cssSelector("div.form__body div.form__row:nth-child(2) button[aria-label='Toggle password visibility']")).click();
        WebElement confirmPassWord = getDriver().findElement(By.cssSelector("input[name='confirm_password']"));
        String confirmPassWordElement = confirmPassWord.getAttribute("type");
        if (!confirmPassWordElement.contentEquals("text")) {
            System.out.println(PassWWordElement + " fail");
            return false;
        }
        System.out.println(PassWWordElement + " pass");
        System.out.println(PassWWordElement + " pass");
        return true;
    }

    public boolean checkIfUploadAvatarSuccessful() {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement popupErrorMsgElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top-message-text")));
        String popupErrorMsgElementText = popupErrorMsgElements.getText();
        System.out.println(popupErrorMsgElementText);
        if (popupErrorMsgElementText.contentEquals("Photo en cours d'approbation")) {
            System.out.println(popupErrorMsgElementText + " đang trong phê duyệt");
            try {
                Thread.sleep(2 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String currentUrl = getDriver().getCurrentUrl();
            System.out.println(currentUrl + " ok lấy đc url ròi");
            if (!currentUrl.contentEquals("https://www.mektoube.fr/inscription/jobForm")) {
                System.out.println(currentUrl);
                System.out.println("haiz1");
                return false;
            }

            System.out.println(currentUrl);
            System.out.println("haiz2");
        }
        if (popupErrorMsgElementText.contentEquals("La photo n'est pas valide")) {
            System.out.println(popupErrorMsgElementText + " k hợp lệ");
            getDriver().findElement(By.cssSelector("a[class='question-skip']")).click();
            String currentUrl2 = getDriver().getCurrentUrl();
            System.out.println(currentUrl2 + " ok lấy đc url ròi");
            if (!currentUrl2.contentEquals("https://www.mektoube.fr/inscription/jobForm")) {
                System.out.println(currentUrl2);
                System.out.println("haiz3");
                return false;
            }
            System.out.println("haiz4");
            System.out.println(currentUrl2);
        }
        try {
            Thread.sleep(5 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public ArrayList<String> getErrorMessages() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        ArrayList<String> errorMsgs = new ArrayList<>();

        try {
            ArrayList<WebElement> popupErrorMsgElements = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.top-message-text"))));
            if (popupErrorMsgElements.size() > 0) {
                errorMsgs.add(popupErrorMsgElements.get(0).getText());
            }
            ArrayList<WebElement> inlineErrorMsgElements = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
            for (WebElement errorItem : inlineErrorMsgElements) {
                errorMsgs.add(errorItem.getText());
            }

            System.out.println(errorMsgs + " try");
            return errorMsgs;
        }  catch (Exception e) {

            ArrayList<WebElement> inlineErrorMsgElements = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("p.error"))));
            for (WebElement errorItem : inlineErrorMsgElements) {
                errorMsgs.add(errorItem.getText());
            }

            System.out.println(errorMsgs + " catch");
            return errorMsgs;
        }
//        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
//        ArrayList<String> errorMsgs = new ArrayList<>();
//
//        ArrayList<WebElement> popupErrorMsgElements = new ArrayList<>(getDriver().findElements(By.cssSelector("div.top-message-text")));
//        if (popupErrorMsgElements.size() > 0) {
//            errorMsgs.add(popupErrorMsgElements.get(0).getText());
//        }
//        ArrayList<WebElement> inlineErrorMsgElements = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
//        for (WebElement errorItem : inlineErrorMsgElements) {
//            errorMsgs.add(errorItem.getText());
//        }
//
//        System.out.println(errorMsgs);
//        return errorMsgs;
    }

    public void clickOnTextLink(String textLink) {
        switch (textLink) {
            case "Pas de compte ?":
                getDriver().findElement(By.xpath("//a[@href='/inscription/entityForm']")).click();
                break;
            case "Mot de passe oublié ?":
                getDriver().findElement(By.cssSelector("a[href='/forgot-password']")).click();
                break;
            case "Nous contacter":
                getDriver().findElement(By.xpath("//a[@href='/contact']")).click();
                break;
            case "Aide":
                getDriver().findElement(By.xpath("//a[@href='https://aide.mektoube.fr/']")).click();
                break;
        }
    }

    public void ClickOnRéinitialiserMonMotDePasseButton() {
        getDriver().findElement(By.cssSelector("button[class='mdc-button mdc-button--blue mdc-button--unelevated']")).click();
    }

    public void enterValidEmailAndClickOnRéinitialiserMonMotDePasseButton() {
        //getDriver().findElement(By.cssSelector("input[name='email']")).sendKeys("mektoubitest@gmail.com");
        commonPage.waitAboutSecond(2);
        commonPage.insertIntoField("mektoubitest@gmail.com","input[name='email']");
        commonPage.waitAboutSecond(2);
        getDriver().findElement(By.cssSelector("span[class='mdc-button__label']")).click();
    }

    public void donTSelectAnythingAndClickValidate() {

        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
    }

    public void clickRadioButtonOfAlgérienneMarocaineTunisienne() {
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(1) input[type='radio']")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(2) input[type='radio']")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.cssSelector(".list--radio label:nth-child(3) input[type='radio']")).click();
    }

    public boolean onlyTunisienneIsClicked() {
        ArrayList<WebElement> radioButtonList = (ArrayList<WebElement>) getDriver().findElements(By.cssSelector("input[type='radio']"));
        int selectedRadioButtonIndex = -1;
        int numberOfSelectedRadioButton = 0;
        for (int i = 0; i < radioButtonList.size(); i++) {
            if (radioButtonList.get(i).isSelected()) {
                selectedRadioButtonIndex = i;
                numberOfSelectedRadioButton++;
            }
        }

        if (numberOfSelectedRadioButton == 1 && selectedRadioButtonIndex == 2) {
            return true;
        }
        return false;
    }

    public void clickElementHasText(String text) {
        getDriver().findElement(By.xpath("//a/span[contains(text(),'" + text + "')]")).click();
    }

    public void switchTab() {
        String parentHandle = getDriver().getWindowHandle();


        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(parentHandle)) {
                getDriver().switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
            }
        }
    }

    public void leaveTheAgeFieldEmptyAndValidate() {
        getDriver().findElement(By.cssSelector("input[type='text']")).sendKeys("");
        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
    }

    public ArrayList<String> shouldSeeRealDate() {
        try {
            Thread.sleep(2 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> date = new ArrayList<>();
        ArrayList<WebElement> contentOfDate = new ArrayList<>(getDriver().findElements(By.cssSelector("input[placeholder='JJ'] ")));
        for (WebElement date1 : contentOfDate) {
            date.add(date1.getAttribute("value"));
            System.out.println(date);
        }
        return date;


    }

    public ArrayList<String> shouldSeeRealMonth() {
        ArrayList<String> month = new ArrayList<>();
        ArrayList<WebElement> contentOfMonth = new ArrayList<>(getDriver().findElements(By.cssSelector("input[placeholder='MM'] ")));
        for (WebElement month1 : contentOfMonth) {
            month.add(month1.getAttribute("value"));
        }
        return month;
    }

    public ArrayList<String> shouldSeeRealYear() {
        ArrayList<String> year = new ArrayList<>();
        ArrayList<WebElement> contentOfYear = new ArrayList<>(getDriver().findElements(By.cssSelector("input[placeholder='AAAA'] ")));
        for (WebElement year1 : contentOfYear) {
            year.add(year1.getAttribute("value"));
        }
        return year;
    }

    public void enterAPositiveDateOfBirth(String positiveDate) {
        commonPage.clearTextFromField("input[placeholder='JJ']");
        commonPage.clearTextFromField("input[placeholder='MM']");
        commonPage.clearTextFromField("input[placeholder='AAAA']");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement day = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='JJ']")));
        day.sendKeys("-31");

        WebElement month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='MM']")));
        month.sendKeys("-10");

        WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='AAAA']")));
        year.sendKeys("-1997");

    }


    public void enterADateOfBirthOfUserUnderEighteen() {

        WebDriverWait wait = new WebDriverWait(getDriver(), 60);

        WebElement day = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='JJ']")));
        day.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        day.sendKeys("31");

        WebElement month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='MM']")));
        month.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        month.sendKeys("12");

        WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='AAAA']")));
        year.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        year.sendKeys("2002");
        getDriver().findElement(By.cssSelector("button[class='question-circle-check-btn']")).click();
    }

    public void checkIfManAccountIsCreate() {
        ArrayList<String> alertMessPopUp = new ArrayList<>();
        ArrayList<WebElement> alertMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div.top-message-text")));
        for (WebElement mess : alertMess) {
            String textOfAlert = mess.getText();
            alertMessPopUp.add(textOfAlert);

        }
        while (alertMess.size() > 0 && alertMessPopUp.contains("Ce pseudo est déjà utilisé.")) {
            System.out.println(alertMessPopUp);
            try {
                Thread.sleep(4 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            getDriver().findElement(By.cssSelector("input[name='signUpEmail']")).clear();
            getDriver().findElement(By.cssSelector("input[name='signUpLogin']")).clear();
            insertRandomEmailForMenToEmailField();
            insertRandomUsernameForMenToUsernameField();
            System.out.println(getDriver().findElement(By.cssSelector("input[name='signUpPassword']")).getAttribute("value"));
            getDriver().findElement(By.cssSelector("button[type='submit']")).click();
            alertMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div.top-message-text")));
        }
    }


    public void logoutCurrentAccountAfterCreatedSuccessful() {
        skipAllQuestionsInEveryRegistrationForm();
        commonPage.logoutCurrentFemaleAccount();
        commonPage.waitAboutSecond(2);
        assertThat(commonPage.redirectToLink("https://www.mektoube.fr/"), is(equalTo(true)));
    }

    public void ClickOnRealProfile(int index) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> profile = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".profile"))));
        ArrayList<WebElement> fakeAccount = new ArrayList<>(profile.get(index).findElements(By.cssSelector("div[class='fake-content']")));
        if (fakeAccount.size() > 0) {
            profile.get(index + 1).click();
            System.out.println(index);
        } else {
            profile.get(index).click();
        }
    }

    public void checkSomeAccountsToCheckIfThereAreFemaleAccount() {
        ClickOnRealProfile(0);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquante :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquant :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(1);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquante :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquant :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(2);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquante :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquant :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(3);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquante :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquant :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
//        ClickOnRealProfile(4);
//        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
//        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquante :"), is(equalTo(true)));
//        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquant :"), is(equalTo(true)));
//        commonPage.click("returnArrowInProfile");
//        ClickOnRealProfile(5);
//        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
//        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquante :"), is(equalTo(true)));
//        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquant :"), is(equalTo(true)));
//        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(9);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquante :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquant :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(14);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquante :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquant :"), is(equalTo(true)));


    }

    public void checkSomeAccountsToCheckIfThereAreMaleAccount() {

        ClickOnRealProfile(0);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquant :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquante :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(1);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquant :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquante :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(2);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquant :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquante :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(3);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquant :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquante :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(4);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquant :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquante :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(5);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquant :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquante :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(9);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquant :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquante :"), is(equalTo(true)));
        commonPage.click("returnArrowInProfile");
        ClickOnRealProfile(14);
        commonPage.waitUntilElementIsVisible("div.col.col--size-1 ul li:nth-child(9) strong");
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation("Pratiquant :"), is(equalTo(true)));
        assertThat(discoveriesPage.shouldSeeInMyResearch("Pratiquante :"), is(equalTo(true)));
    }


    public boolean deleteCreatedAccount() {

        commonPage.waitUntilElementIsVisible("MyProfileBtn");
        commonPage.click("MyProfileBtn");
        commonPage.waitUntilElementIsVisible("settingBtn");
        commonPage.click("settingBtn");
        commonPage.waitUntilElementIsVisible(".list-settings");
        commonPage.scrollToElementThatHasTextAndClick("//div[@class='list-settings']//*[contains(text(),'Mon Compte')]");
        commonPage.scrollToElementThatHasTextAndClick("//div[@class='list-settings']//*[contains(text(),'Supprimer mon compte')]");
        commonPage.waitUntilElementIsVisible("form[class='form form--delete-account']");
        commonPage.insertIntoField("Mektoubi2017", "input[name='password']");
        commonPage.click("form[class='form form--delete-account'] button[class='mdc-button mdc-button--unelevated mdc-btn--red']");
        assertThat(commonPage.shouldSeeMessagePopupAtTop("Un email de confirmation vous a été envoyé"), is(equalTo(true)));
        commonPage.gotoUrl("http://www.google.com/gmail/");
        System.out.println("ok đi đến đc gmail");
        String signInGmail = getDriver().getCurrentUrl();
        System.out.println(signInGmail);
        if (signInGmail.contentEquals("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin")) {
            System.out.println(" cần qua steps login");
            commonPage.insertIntoField("mektoubitest@gmail.com", "input[type='email']");
            commonPage.click("div#identifierNext");
            commonPage.waitAboutSecond(2);
            commonPage.waitUntilElementIsVisible("div[id='password']");
            commonPage.insertIntoField("Mektoubi2017", "input[type='password']");
            commonPage.click("div#passwordNext");
            System.out.println(" ok log on gmail xong");
        }
//        commonPage.waitUntilElementIsVisible("tr[role='row']");
        commonPage.clickOnRadionButtonThatHasText("//div[@class='xT']//*[contains(text(),'Désinscription de votre compte sur Mektoube.fr')]");
        commonPage.waitAboutSecond(4);
        ArrayList<WebElement> expandMail = new ArrayList<>(getDriver().findElements(By.cssSelector("div.ajV img[src='//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif']")));
        if (expandMail.size() > 0) {
            commonPage.scrollToAndClick("div.ajV img[src='//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif']:last-child");
        }
        commonPage.waitAboutSecond(1);
        ArrayList<WebElement> desinscriptionTextLink = new ArrayList<>(getDriver().findElements(By.xpath("//a/span[contains(text(),'Je confirme ma demande de désinscription')]")));
//        commonPage.clickOnRadionButtonThatHasText("//a/span[contains(text(),'Je confirme ma demande de désinscription')]");
        desinscriptionTextLink.get(desinscriptionTextLink.size() - 1).click();
        commonPage.waitAboutSecond(2);
        String unregister = getDriver().getCurrentUrl();
        if (unregister.contains("https://mektoube.fr/unregister/")) {
            return false;
        }
        String parentHandle = getDriver().getWindowHandle();

        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(parentHandle)) {
                getDriver().switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
                commonPage.gotoUrl("https://www.mektoube.fr/");
// if go to discoveries screen => have to log out
//                commonPage.logoutCurrentFemaleAccount();
//                WebDriverWait wait = new WebDriverWait(getDriver(), 5);
                commonPage.loginWithAccountAndPassword("mektoubitest@gmail.com", "Mektoubi2017");
//                WebElement alertMessPopUpElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='home-intro']")));
                String alertMessPopUp = getDriver().findElement(By.cssSelector("div[class='error-box'] p")).getText();

                if (!alertMessPopUp.equals("Identifiant ou mot de passe incorrect")) {
                    System.out.println(alertMessPopUp);
                    return false;
                }

                getDriver().close();
            }
        }

        getDriver().switchTo().window(parentHandle);
        commonPage.click("deleteMektoubeEmail");
        commonPage.waitAboutSecond(1);
        return true;

    }

    public void createAWomanAccountWithEmailAndUsername(String email, String username) {
        commonPage.loginWithAccountAndPassword(email, "Mektoubi2017");
        ArrayList<String> alertMessPopUp = new ArrayList<>();
        ArrayList<WebElement> alertMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='error-box'] p")));
        for (WebElement mess : alertMess) {
            String textOfAlert = mess.getText();
            alertMessPopUp.add(textOfAlert);

        }
        if (alertMess.size() > 0 && alertMessPopUp.contains("Identifiant ou mot de passe incorrect")) {
            commonPage.gotoUrl("https://www.mektoube.fr/");
            commonPage.click("iAmAWoman");
            commonPage.click("FreeRegistration");
            commonPage.redirectToLink("birthdayForm.url");
            enterAValidDateOfBirthAndValidate();
            commonPage.redirectToLink("originForm.url");
            commonPage.clickOnRadionButtonThatHasText("//div[@class='list--radio']//*[contains(text(),'Algérienne')]");
            commonPage.click("confirmBtn");
            commonPage.click("MaLocalisationField");
            commonPage.waitUntilElementIsVisible("CountriesList");
            commonPage.clickOnRadionButtonThatHasText("France");
            commonPage.click("confirmBtn");
            commonPage.waitUntilElementIsVisible("div[class='form__body']");
            commonPage.redirectToLink("zipCode.url");
            commonPage.insertIntoField("75001", "ZipcodeField");
            commonPage.click("confirmBtn");
            commonPage.waitUntilElementIsVisible("div[class='list--radio']");
            commonPage.redirectToLink("CityOfZipCode75001.url");
            shouldSeeUniqueCity();
            commonPage.click("Paris1erCity");
            commonPage.click("confirmBtn");
            commonPage.waitUntilElementIsVisible("form[class='form form--register-block']");
            commonPage.redirectToLink("signUp.url");
            insertEmailAndUserNameForWomanAccount(email, username);
            commonPage.insertIntoField("Mektoubi2017", "input[type='password']");
            commonPage.click("TermsOfUse1");
            commonPage.click("TermsOfUse2");
            commonPage.click("CreateAccountBtn");
            commonPage.waitUntilElementIsVisible("div[class='congratulation']");
            commonPage.redirectToLink("CreateAccountSuccess.url");

        } else {
            deleteCreatedAccount();
            switchTab();
            commonPage.gotoUrl("https://www.mektoube.fr/");
            commonPage.click("iAmAWoman");
            commonPage.click("FreeRegistration");
            commonPage.redirectToLink("birthdayForm.url");
            enterAValidDateOfBirthAndValidate();
            commonPage.redirectToLink("originForm.url");
            commonPage.clickOnRadionButtonThatHasText("//div[@class='list--radio']//*[contains(text(),'Algérienne')]");
            commonPage.click("confirmBtn");
            commonPage.click("MaLocalisationField");
            commonPage.waitUntilElementIsVisible("CountriesList");
            commonPage.clickOnRadionButtonThatHasText("France");
            commonPage.click("confirmBtn");
            commonPage.waitUntilElementIsVisible("div[class='form__body']");
            commonPage.redirectToLink("zipCode.url");
            commonPage.insertIntoField("75001", "ZipcodeField");
            commonPage.click("confirmBtn");
            commonPage.waitUntilElementIsVisible("div[class='list--radio']");
            commonPage.redirectToLink("CityOfZipCode75001.url");
            shouldSeeUniqueCity();
            commonPage.click("Paris1erCity");
            commonPage.click("confirmBtn");
            commonPage.waitUntilElementIsVisible("form[class='form form--register-block']");
            commonPage.redirectToLink("signUp.url");
            insertEmailAndUserNameForWomanAccount(email, username);
            commonPage.insertIntoField("Mektoubi2017", "input[type='password']");
            commonPage.click("TermsOfUse1");
            commonPage.click("TermsOfUse2");
            commonPage.click("CreateAccountBtn");
            commonPage.waitUntilElementIsVisible("div[class='congratulation']");
            commonPage.redirectToLink("CreateAccountSuccess.url");

        }
    }

    public void doTheStepsToTheSignUpScreen() {

        createAWomanAccountWithEmailAndUsername("mektoubitest@gmail.com", "samiracute");

    }

    public void createAManAccountWithEmailAndUsername(String email, String username) {
        commonPage.loginWithAccountAndPassword(email, "Mektoubi2017");
        ArrayList<String> alertMessPopUp = new ArrayList<>();
        ArrayList<WebElement> alertMess = new ArrayList<>(getDriver().findElements(By.cssSelector("div.top-message-text")));
        for (WebElement mess : alertMess) {
            String textOfAlert = mess.getText();
            alertMessPopUp.add(textOfAlert);

        }
        if (alertMess.size() > 0 && alertMessPopUp.contains("Identifiant ou mot de passe incorrect")) {
            commonPage.gotoUrl("https://www.mektoube.fr/");
            commonPage.click("iAmAMan");
            commonPage.click("FreeRegistration");
            commonPage.redirectToLink("birthdayForm.url");
            enterAValidDateOfBirthAndValidate();
            commonPage.redirectToLink("originForm.url");
            commonPage.clickOnRadionButtonThatHasText("//div[@class='list--radio']//*[contains(text(),'Algérienne')]");
            commonPage.click("confirmBtn");
            commonPage.click("MaLocalisationField");
            commonPage.waitUntilElementIsVisible("CountriesList");
            commonPage.clickOnRadionButtonThatHasText("France");
            commonPage.click("confirmBtn");
            commonPage.waitAboutSecond(2);
            commonPage.redirectToLink("zipCode.url");
            commonPage.insertIntoField("75001", "ZipcodeField");
            commonPage.click("confirmBtn");
            commonPage.waitAboutSecond(2);
            commonPage.redirectToLink("CityOfZipCode75001.url");
            shouldSeeUniqueCity();
            commonPage.click("Paris1erCity");
            commonPage.click("confirmBtn");
            commonPage.waitAboutSecond(2);
            commonPage.redirectToLink("signUp.url");
            insertEmailAndUserNameForWomanAccount(email, username);
            commonPage.insertIntoField("Mektoubi2017", "input[type='password']");
            commonPage.click("TermsOfUse1");
            commonPage.click("TermsOfUse2");
            commonPage.click("CreateAccountBtn");
            commonPage.waitUntilElementIsVisible("div[class='congratulation']");
            commonPage.redirectToLink("CreateAccountSuccess.url");

        } else {
            deleteCreatedAccount();
            commonPage.gotoUrl("https://www.mektoube.fr/");
            commonPage.click("iAmAMan");
            commonPage.click("FreeRegistration");
            commonPage.redirectToLink("birthdayForm.url");
            enterAValidDateOfBirthAndValidate();
            commonPage.redirectToLink("originForm.url");
            commonPage.clickOnRadionButtonThatHasText("//div[@class='list--radio']//*[contains(text(),'Algérienne')]");
            commonPage.click("confirmBtn");
            commonPage.click("MaLocalisationField");
            commonPage.waitAboutSecond(5);
            commonPage.waitUntilElementIsVisible("CountriesList");
            commonPage.clickOnRadionButtonThatHasText("France");
            commonPage.click("confirmBtn");
            commonPage.waitAboutSecond(2);
            commonPage.redirectToLink("zipCode.url");
            commonPage.insertIntoField("75001", "ZipcodeField");
            commonPage.click("confirmBtn");
            commonPage.waitAboutSecond(2);
            commonPage.redirectToLink("CityOfZipCode75001.url");
            shouldSeeUniqueCity();
            commonPage.click("Paris1erCity");
            commonPage.click("confirmBtn");
            commonPage.waitAboutSecond(2);
            commonPage.redirectToLink("signUp.url");
            insertEmailAndUserNameForWomanAccount(email, username);
//        insertRandomEmailForWomanToEmailField();
//        insertRandomUsernameForWomanToUsernameField();
            commonPage.insertIntoField("Mektoubi2017", "input[type='password']");
            commonPage.click("TermsOfUse1");
            commonPage.click("TermsOfUse2");
            commonPage.click("CreateAccountBtn");
            commonPage.waitUntilElementIsVisible("div[class='congratulation']");
            commonPage.redirectToLink("CreateAccountSuccess.url");

        }
    }


    public void showErrorMessageInAllOrFirstOneField() {
        String errorText = getDriver().findElement(By.cssSelector(".error")).getText();
        if (errorText.equals("Le nom est requis.L'email est requis.Le contenu du message est requis.Veuillez valider le Captcha")) {
            System.out.println("==>let fields blank on contact page: Passed!!");
        }
        getDriver().close();
    }

    public boolean shouldNotSeeMessagePopUp(String mess) {
        ArrayList<WebElement> popupMess = new ArrayList<>(getDriver().findElements(By.cssSelector("p.error")));
        if (popupMess.size() > 0) {
            System.out.println(popupMess.size() + " " + popupMess.get(0).getText() + " fail");
            return false;
        }
        System.out.println(popupMess.size() + " pass");
        return true;

    }

    public void iEnterOnlyAlphabel(String alphabet) {
        commonPage.clearTextFromField("BirthdayField");
        commonPage.insertIntoField(alphabet, "BirthdayField");
    }

    public void loginGmailAndClickLinkToResetPassword() {
        commonPage.gotoUrl("http://www.google.com/gmail/");
        commonPage.waitUntilElementIsVisible("div[data-allow-at-sign='true']");
        commonPage.insertIntoField("mektoubitest@gmail.com","input[type='email']");
        commonPage.click("div#identifierNext");
        commonPage.waitUntilElementIsVisible("div[data-is-visible='false']");
        commonPage.waitAboutSecond(1);
        commonPage.insertIntoField("Mektoubi2017","input[type='password']");
        commonPage.click("div#passwordNext");
        commonPage.waitAboutSecond(2);
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        ArrayList<WebElement> resetPassword = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='xT']//*[contains(text(),'Mot de passe oublié')]"))));
        resetPassword.get(0).click();
        commonPage.waitAboutSecond(4);
        ArrayList<WebElement> expandMail = new ArrayList<>(getDriver().findElements(By.cssSelector("div.ajV img[src='//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif']")));
        if (expandMail.size() > 0) {
            commonPage.scrollToAndClick("div.ajV img[src='//ssl.gstatic.com/ui/v1/icons/mail/images/cleardot.gif']:last-child");
        }
        commonPage.waitAboutSecond(1);
        ArrayList<WebElement> resetPasswordLink = new ArrayList<>(getDriver().findElements(By.xpath("//a/span[contains(text(),'CHANGER MON MOT DE PASSE')]")));
//        commonPage.clickOnRadionButtonThatHasText("//a/span[contains(text(),'Je confirme ma demande de désinscription')]");
        resetPasswordLink.get(resetPasswordLink.size() - 1).click();

    }


    public void scrollTheTestimonials() throws AWTException {
//        for(int i=0;i<20;i++){
//            WebElement ele = getDriver().findElement(By.cssSelector("div[class='subsidary__main testimonies-main'] > #testimoniesList > div:nth-child(1) > div[class='infinite-scroll-component '] > div > div > h2"));
//            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", ele);
//        }

        //before
        ArrayList<WebElement> testimonialList = new ArrayList<>(getDriver().findElements(By.cssSelector("div#testimonyListitem")));
        System.out.println("testimonial size: "+testimonialList.size());
        //use robot to control mouse to scroll special element in page
        Robot robot = new Robot();
        //find location want to move mouse to
        WebElement testimonialArea = getDriver().findElement(By.cssSelector("div.infinite-scroll-component > div:nth-child(1)"));
        //get location when move mouse into then can scroll
        Point testimoniaAreaPoint = testimonialArea.getLocation();
        int xcord = testimoniaAreaPoint.getX()+100;// get x location of testimonial
        int ycord = testimoniaAreaPoint.getY()+200;// get y location of testimonial
        robot.mouseMove(xcord, ycord);// move mouse into above location (x,y)
        try {
            Thread.sleep(3 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        robot.mouseMove(xcord, ycord);// move mouse into above location (x,y)
        try {
            Thread.sleep(3 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(xcord + "---" + ycord);

        int itemLoaded = 0;
        int totalItems = testimonialList.size();

        while (itemLoaded < totalItems) {
            //scroll and wait a bit to give the impression of smooth scrolling
            //wheelAmt: + towards the user|| - away from the user
            robot.mouseWheel(100);
            //wait for page load
            try {
                Thread.sleep(2 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            itemLoaded = totalItems;
            testimonialList = new ArrayList<>(getDriver().findElements(org.openqa.selenium.By.cssSelector("div#testimonyListitem")));
            System.out.println("After load size of testimonialList :"+testimonialList.size());
            totalItems = testimonialList.size();
            System.out.println(testimonialList.size());
        }
        //after scroll
        testimonialList = new ArrayList<>(getDriver().findElements(org.openqa.selenium.By.cssSelector("div#testimonyListitem")));
        System.out.println("testimonial size: "+testimonialList.size());
    }

    public void thePageShowNumberOfTestimonials(){
        ArrayList<WebElement> testimonialList = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='subsidary__main testimonies-main'] > #testimoniesList > div > div[class='infinite-scroll-component '] > div > div > h2")));
        System.out.println("There are "+testimonialList.size()+" testimonials");
    }

    public void displayAllErrorAtRacontezNousVotreDestin() {
        String error = getDriver().findElement(By.cssSelector(".error")).getText();
        System.out.println("Error is: " + error);
        if (error.equals("Le champ est vide")) {
            System.out.println("==> PASSED!!!!");
            getDriver().close();
        } else {
            System.out.println("failded....");
        }
    }

    public void scrollTopPage(){
        WebElement element = getDriver().findElement(By.tagName("header"));

        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void theFormIsClosed() {
        try {
            boolean isHaveForm = getDriver().findElement(By.cssSelector(".testimony-modal.modal.is--opened")).isDisplayed();
        } catch (Exception e) {
            System.out.println("===>PASSED!!!");
        }
        getDriver().close();
    }

    public void scrollToViewThatDontClick(String element){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String cssSelector = TestDataService.properties.getProperty(element);
        ArrayList<WebElement> filterItemList = new ArrayList<>(getDriver().findElements(By.cssSelector(cssSelector)));
        System.out.println("filter item have size "+filterItemList.size());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", filterItemList.get(0));
    }

    public void scrollAnyPage(int height) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        int i = 1;
        int intTo = i * height;
        js.executeScript("window.scrollTo(0," + intTo + ");");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void browserShouldRedirectToAtNewTab(String targetUrl, String stt){
        ArrayList<String> tabs_windows = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs_windows.get(Integer.parseInt(stt)));//switch to new tab
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(getDriver().getCurrentUrl().contains(targetUrl));//compare post url with wish url
        System.out.println("==>Successful "+targetUrl);
        //getDriver().close();
        getDriver().navigate().back();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scroll() {
        ArrayList<WebElement> filterItemList = new ArrayList<>(getDriver().findElements(By.cssSelector("a[class='btn-app-store']")));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", filterItemList.get(0));
        filterItemList.get(0).click();
    }

    public void browserShouldRedirectToAtJustOneNewTab(String targetUrl, String stt){
        ArrayList<String> tabs_windows = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs_windows.get(Integer.parseInt(stt)));//switch to new tab
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(getDriver().getCurrentUrl().contains(targetUrl));//compare post url with wish url
        System.out.println("==>Successful "+targetUrl);
    }

    public String getCurrentUrl() {
        System.out.println(getDriver().getCurrentUrl());
        return getDriver().getCurrentUrl();
    }

    public void clickToLinkSeConnecter() {
        ArrayList<WebElement> Cookie = new ArrayList<>(getDriver().findElements(By.cssSelector("button[class='mdc-button mdc-button--outlined']")));
        if (Cookie.size() > 0) {
            Cookie.get(0).click();
            getDriver().findElement(By.cssSelector("header[class='header--home hidden-xs'] a[href='/login'] ")).click();
        } else {
            getDriver().findElement(By.cssSelector("header[class='header--home hidden-xs'] a[href='/login'] ")).click();
        }
    }

    public void thePageShowErrorInclude(String errorMess){
        ArrayList<WebElement> errorTextList = new ArrayList<>(getDriver().findElements(By.cssSelector(".error"))) ;
        String errorText = "";
        for(WebElement error: errorTextList){
            errorText+=error.getText();
        }

        System.out.println("errorText: "+errorText);
        assertEquals(errorMess,errorText);

    }

    public void enterIntoNomPrénomFieldWithValue(String value) {
        getDriver().findElement(By.cssSelector("input[name='login']")).sendKeys(value);
    }

    public void alwaysSeeNotice(String notice) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement moticeText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = '" + notice + "']")));
    }

    public void leavePasswordFieldEmptyAndClickSubmit() {
        commonPage.insertIntoField("shainez29", "input[name='username']");
        commonPage.click("button[type='submit']");
        commonPage.waitUntilElementIsVisible("div[class='form__row  form__row__for-password'] div[class='input-outline-field-container is-invalid']");
    }

    public void leaveBothUsernameAndPasswordFieldsEmpty() {
        commonPage.click("button[type='submit']");
        commonPage.waitUntilElementIsVisible("div[class='form__row  form__row__for-username'] div[class='input-outline-field-container is-invalid']");
        commonPage.waitUntilElementIsVisible("div[class='form__row  form__row__for-password'] div[class='input-outline-field-container is-invalid']");
    }

    public void leaveUsernameFieldEmptyAndClickSubmit() {
        commonPage.clearTextFromField("input[name='username']");
        commonPage.insertIntoField("mektoube", "input[name='password']");
        commonPage.click("button[type='submit']");
        commonPage.waitUntilElementIsVisible("div[class='form__row  form__row__for-username'] div[class='input-outline-field-container is-invalid']");
        commonPage.clearTextFromField("input[name='password']");
    }

    public void displayWarning(String warningText) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement moticeText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = '" + warningText + "']")));
        System.out.println(getDriver().findElement(By.cssSelector("div[class='error-box'] p")).getText());
    }

    public void loginBackofficeAndAddANewBlackemail(String blackemail) {
        WebElement username = getDriver().findElement(org.openqa.selenium.By.cssSelector("input[type='text']"));
        username.sendKeys("admin");
        WebElement password = getDriver().findElement(org.openqa.selenium.By.cssSelector("input[type='password']"));
        password.sendKeys("mektoube");
        getDriver().findElement(org.openqa.selenium.By.cssSelector("button[type='submit']")).click();
        commonPage.waitUntilElementIsVisible("a[href='/dashboard/blackmails']");
        commonPage.click("a[href='/dashboard/blackmails']");
        commonPage.click("div.content");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement blackEmailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.cssSelector("form.backmail-form.content input")));
        blackEmailInput.sendKeys(blackemail);
        commonPage.click("form.backmail-form.content button");
        commonPage.waitUntilElementIsVisible("div.MuiAlert-message");
        WebElement message = getDriver().findElement(org.openqa.selenium.By.cssSelector("div.MuiAlert-message"));
        assertEquals("Add new blackmails successful!", message.getText());
    }

    public void createAManAccountWithBlackemail(String blackemail) {
        commonPage.gotoUrl("https://responsive-staging.ltservices2.ovh/");

    }

    public void createAWomanAccount() {
        commonPage.gotoUrl("https://www.mektoube.fr/");
        commonPage.click("iAmAWoman");
        commonPage.click("FreeRegistration");
        commonPage.redirectToLink("birthdayForm.url");
        enterAValidDateOfBirthAndValidate();
        commonPage.redirectToLink("originForm.url");
        commonPage.clickOnRadionButtonThatHasText("//div[@class='list--radio']//*[contains(text(),'Algérienne')]");
        commonPage.click("confirmBtn");
        commonPage.click("MaLocalisationField");
        commonPage.waitUntilElementIsVisible("CountriesList");
        commonPage.clickOnRadionButtonThatHasText("France");
        commonPage.click("confirmBtn");
        commonPage.waitUntilElementIsVisible("div[class='form__body']");
        commonPage.redirectToLink("zipCode.url");
        commonPage.insertIntoField("75001", "ZipcodeField");
        commonPage.click("confirmBtn");
        commonPage.waitUntilElementIsVisible("div[class='list--radio']");
        commonPage.redirectToLink("CityOfZipCode75001.url");
        shouldSeeUniqueCity();
        commonPage.click("Paris1erCity");
        commonPage.click("confirmBtn");
        commonPage.waitUntilElementIsVisible("form[class='form form--register-block']");
        commonPage.redirectToLink("signUp.url");
        insertEmailAndUserNameForWomanAccount("lannt4998@gmail.com", "lantiu98");
        commonPage.insertIntoField("Lantiu4998@", "input[type='password']");
        commonPage.click("TermsOfUse1");
        commonPage.click("TermsOfUse2");
        commonPage.click("CreateAccountBtn");
        commonPage.waitUntilElementIsVisible("div[class='congratulation']");
        commonPage.redirectToLink("CreateAccountSuccess.url");

        skipAllQuestionsInEveryRegistrationForm();
    }

    public void validateEmail() {
        commonPage.waitUntilElementIsVisible("div.modal-content");
        commonPage.scrollToElementThatHasTextAndClick("RenvoyerUnEmailDeValidation");
        commonPage.shouldSeeMessagePopupAtTop("L'email de vérification a bien été envoyé");

        commonPage.gotoUrl("http://www.google.com/gmail/");
        System.out.println("ok đi đến đc gmail");
        String signInGmail = getDriver().getCurrentUrl();
        System.out.println(signInGmail);
        if (signInGmail.contentEquals("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin")) {
            System.out.println(" cần qua steps login");
            commonPage.insertIntoField("lannt4998@gmail.com", "input[type='email']");
            commonPage.click("div#identifierNext");
            commonPage.waitAboutSecond(2);
            commonPage.waitUntilElementIsVisible("div[id='password']");
            commonPage.insertIntoField("lannguyentb4998@", "input[type='password']");
            commonPage.click("div#passwordNext");
            System.out.println(" ok log on gmail xong");

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
    }

    public void createAWomanAccountWithDisposableBlackEmail(String email) {
        commonPage.gotoUrl("https://www.mektoube.fr/");
        commonPage.click("iAmAWoman");
        commonPage.click("FreeRegistration");
        commonPage.redirectToLink("birthdayForm.url");
        enterAValidDateOfBirthAndValidate();
        commonPage.redirectToLink("originForm.url");
        commonPage.clickOnRadionButtonThatHasText("//div[@class='list--radio']//*[contains(text(),'Algérienne')]");
        commonPage.click("confirmBtn");
        commonPage.click("MaLocalisationField");
        commonPage.waitUntilElementIsVisible("CountriesList");
        commonPage.clickOnRadionButtonThatHasText("France");
        commonPage.click("confirmBtn");
        commonPage.waitUntilElementIsVisible("div[class='form__body']");
        commonPage.redirectToLink("zipCode.url");
        commonPage.insertIntoField("75001", "ZipcodeField");
        commonPage.click("confirmBtn");
        commonPage.waitUntilElementIsVisible("div[class='list--radio']");
        commonPage.redirectToLink("CityOfZipCode75001.url");
        shouldSeeUniqueCity();
        commonPage.click("Paris1erCity");
        commonPage.click("confirmBtn");
        commonPage.waitUntilElementIsVisible("form[class='form form--register-block']");
        commonPage.redirectToLink("signUp.url");
        insertEmailAndUserNameForWomanAccount(email, "lantiu98");
        commonPage.insertIntoField("Lantiu4998@", "input[type='password']");
        commonPage.click("TermsOfUse1");
        commonPage.click("TermsOfUse2");
        commonPage.click("CreateAccountBtn");
    }
    public void createAWomanAccountWithEmailAntiUsername(String antiUsername) {
        commonPage.click("iAmAWoman");
        commonPage.click("FreeRegistration");
        commonPage.redirectToLink("birthdayForm.url");
        enterAValidDateOfBirthAndValidate();
        commonPage.redirectToLink("originForm.url");
        commonPage.clickOnRadionButtonThatHasText("//div[@class='list--radio']//*[contains(text(),'Algérienne')]");
        commonPage.click("confirmBtn");
        commonPage.click("MaLocalisationField");
        commonPage.waitUntilElementIsVisible("CountriesList");
        commonPage.clickOnRadionButtonThatHasText("France");
        commonPage.click("confirmBtn");
        commonPage.waitUntilElementIsVisible("div[class='form__body']");
        commonPage.redirectToLink("zipCode.url");
        commonPage.insertIntoField("75001", "ZipcodeField");
        commonPage.click("confirmBtn");
        commonPage.waitUntilElementIsVisible("div[class='list--radio']");
        commonPage.redirectToLink("CityOfZipCode75001.url");
        shouldSeeUniqueCity();
        commonPage.click("Paris1erCity");
        commonPage.click("confirmBtn");
        commonPage.waitUntilElementIsVisible("form[class='form form--register-block']");
        commonPage.redirectToLink("signUp.url");
        commonPage.insertIntoField("qa+techiz@mektoube.fr","input[type='email']");
        commonPage.insertIntoField(antiUsername,"input[type='text']");
        commonPage.insertIntoField("Mektoubi2017", "input[type='password']");
        commonPage.click("TermsOfUse1");
        commonPage.click("TermsOfUse2");
        commonPage.click("CreateAccountBtn");
    }

    public void insertAntiUsernameAndClick(String antiUsername, String button) {
        commonPage.waitAboutSecond(4);
        commonPage.clearTextFromField("input[type='text']");
        commonPage.insertIntoField(antiUsername, "input[type='text']");
        commonPage.click(button);
        commonPage.waitAboutSecond(2);
        //commonPage.thePageShowErrorMessageIs("Ce prénom n’est pas accepté, veuillez en choisir un autre");
    }

    public void insertAntiUsernameFromListAndClickCreateAccountButton() throws FileNotFoundException {
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
                commonPage.waitAboutSecond(5);
                commonPage.clearTextFromField("input[type='text']");
                commonPage.insertIntoField(newlist,"input[type='text']");
                commonPage.click("CreateAccountBtn");
                commonPage.waitAboutSecond(2);
                commonPage.thePageShowErrorMessageIs("Ce prénom n’est pas accepté, veuillez en choisir un autre");
                System.out.println(newlist);
            }
            else {
                commonPage.waitAboutSecond(5);
                commonPage.clearTextFromField("input[type='text']");
                commonPage.insertIntoField(list.get(i),"input[type='text']");
                commonPage.click("CreateAccountBtn");
                commonPage.waitAboutSecond(2);
                commonPage.thePageShowErrorMessageIs("Ce prénom n’est pas accepté, veuillez en choisir un autre");
                System.out.println(list.get(i));
            }
        }
        System.out.println("ket thuc vong lap");
    }
}
