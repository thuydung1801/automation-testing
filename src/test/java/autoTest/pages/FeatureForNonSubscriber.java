package autoTest.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FeatureForNonSubscriber extends PageObject {
    MektoubeCommonPage commonPage = new MektoubeCommonPage();

    public boolean shouldSeePaymentPage() {
        commonPage.waitUntilElementIsVisible("PaymentModal");
        String titleText = getDriver().findElement(By.cssSelector("div[class='modal--header__title'] h2")).getText();
        String titleText2 = getDriver().findElement(By.cssSelector("div[class='modal--header__title'] p")).getText();
        String titleText3 = getDriver().findElement(By.cssSelector("h4[class='color-black mdc-dialog__innerTitle hidden-xs']")).getText();
        String titleText4 = getDriver().findElement(By.cssSelector("div[class='col col--2'] h4")).getText();
        if (!titleText.contentEquals("Abonnez-vous pour 0,32€ par jour !") && !titleText2.contentEquals("Sans engagement") && !titleText3.contentEquals("Choisissez votre formule")
                && !titleText4.contentEquals("Validez")) {
            System.out.println(titleText + titleText2 + titleText3 + titleText4);
            return false;
        }
        String titleTextOffer6month1 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] span[class='popular']")).getText();
        String titleTextOffer6month2 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] div[class='col'] h5")).getText();
        String titleTextOffer6month3 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] div[class='col'] p[class='yellow']")).getText();
        String titleTextOffer6month4 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] div[class='col'] p[class='catcher']")).getText();
        String titleTextOffer6month5 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] div[class='price'] h3")).getText();
        String titleTextOffer6month6 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] div[class='price'] p")).getText();
        if (!titleTextOffer6month1.contentEquals("Choix le plus populaire") && !titleTextOffer6month2.contentEquals("Pass 6 mois") && !titleTextOffer6month3.contentEquals("J'économise 50% !")
                && !titleTextOffer6month4.contentEquals("Facturé en un paiement de 59,90€") && !titleTextOffer6month5.contentEquals("9,90€") && !titleTextOffer6month6.contentEquals("/ mois")) {
            return false;
        }

        String titleTextOffer3month1 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue '] div[class='col'] h5")).getText();
        String titleTextOffer3month2 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue '] div[class='col'] p[class='yellow']")).getText();
        String titleTextOffer3month4 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue '] div[class='col'] p[class='catcher']")).getText();
        String titleTextOffer3month5 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue '] div[class='price'] h3")).getText();
        String titleTextOffer3month6 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue '] div[class='price'] p")).getText();
        if (!titleTextOffer3month1.contentEquals("Pass 3 mois") && !titleTextOffer3month2.contentEquals("J'économise 30%") && !titleTextOffer3month4.contentEquals("Facturé en un paiement de 39,90€") && !titleTextOffer3month5.contentEquals("13,30€")
                && !titleTextOffer3month6.contentEquals("/ mois")) {
            return false;
        }

        String titleTextOffer1month1 = getDriver().findElement(By.cssSelector("#my-dialog-content > form > div > div.mdc-dialog__inner.cols > div.col.col--1 > div > div:nth-child(3) > label > div:nth-child(1) > h5")).getText();
        String titleTextOffer1month5 = getDriver().findElement(By.cssSelector("#my-dialog-content > form > div > div.mdc-dialog__inner.cols > div.col.col--1 > div > div:nth-child(3) > label > div:nth-child(2) > div > h3")).getText();
        String titleTextOffer1month6 = getDriver().findElement(By.cssSelector("#my-dialog-content > form > div > div.mdc-dialog__inner.cols > div.col.col--1 > div > div:nth-child(3) > label > div:nth-child(2) > div > p")).getText();
        if (!titleTextOffer1month1.contentEquals("Pass 1 mois") && !titleTextOffer1month5.contentEquals("19,90€") && !titleTextOffer1month6.contentEquals("/ mois")) {
            System.out.println(titleTextOffer1month1 + titleTextOffer1month5 + titleTextOffer1month6);
            return false;
        }

        int width = getDriver().findElement(By.cssSelector("form[class='form__pass']")).getSize().getWidth();
        int hight = getDriver().findElement(By.cssSelector("form[class='form__pass']")).getSize().getHeight();
        if (width < 400 && hight < 300) {
            System.out.println("width and height of payment pass form" + " " + width + " " + hight);
            return false;
        }

        int widthOfListCard = getDriver().findElement(By.cssSelector("div[class='form__row form__row--card'] ul[class='list-cards'] img[src='/images/paiement_logos.jpg']")).getSize().getWidth();
        int hightOfListCard = getDriver().findElement(By.cssSelector("div[class='form__row form__row--card'] ul[class='list-cards'] img[src='/images/paiement_logos.jpg']")).getSize().getHeight();
        if (widthOfListCard < 150 && hightOfListCard < 5) {
            System.out.println("width and height of List card" + " " + widthOfListCard + " " + hightOfListCard);
            return false;
        }


        WebElement cardNumber = getDriver().findElement(By.cssSelector("div[class='form__row form__row--card'] label[data-shrink='false'] "));
        getDriver().findElement(By.cssSelector("div[class='form__row form__row--card'] input[type='tel'] ")).click();
        String cardNumberContent = cardNumber.getAttribute("data-shrink");
        if (!cardNumberContent.contentEquals("true")) {
            System.out.println(cardNumberContent + "missing cardNumber hehe");
            return false;
        }

        String textOfCardNumber = cardNumber.getText();
        if (!textOfCardNumber.contentEquals("Numero de Carte")) {
            System.out.println(textOfCardNumber + "fail hihi");
            return false;
        }

        WebElement cardExpireDate = getDriver().findElement(By.cssSelector("div[class='col col--exp'] label[data-shrink='false'] "));
        getDriver().findElement(By.cssSelector("div[class='col col--exp'] input[type='tel'] ")).click();
        String cardExpireDateElement = cardExpireDate.getAttribute("data-shrink");
        if (!cardExpireDateElement.contentEquals("true")) {
            System.out.println(textOfCardNumber + "missing card expire date hihi");
            return false;
        }

        String textOfExpireDate = cardExpireDate.getText();
        if (!textOfExpireDate.contentEquals("Date d'expiration")) {
            System.out.println("missing card expire date hihi" + textOfExpireDate);
            return false;
        }


        WebElement cardCVV = getDriver().findElement(By.cssSelector("div[class='col col--cvv cvv'] label[data-shrink='false'] "));
        getDriver().findElement(By.cssSelector("div[class='col col--cvv cvv'] input[type='tel'] ")).click();
        String cardCVVElement = cardCVV.getAttribute("data-shrink");
        if (!cardCVVElement.contentEquals("true")) {
            System.out.println(cardCVVElement + " this CVV button can't click able");
            return false;
        }

        String textOfCardCVVElement = cardCVV.getText();
        if (!textOfCardCVVElement.contentEquals("CVV")) {
            System.out.println("missing text CVV" + textOfCardCVVElement);
            return false;
        }
        commonPage.click("div[class='tooltip__icon cvv__icon'] a[class='cvv__link'] i[class='material-icons']");
//        getDriver().findElement(By.cssSelector("div[class='tooltip__icon cvv__icon'] a[class='cvv__link'] i[class='material-icons']")).click();
        WebElement toolTip = getDriver().findElement(By.cssSelector("div[class='tooltip--content']"));
        String toolTipElementContain = toolTip.getAttribute("aria-describedby");
        if (!toolTipElementContain.contains("mui-tooltip-")) {
            System.out.println("tool tip is appear!" + " " + toolTipElementContain);
            return false;
        }

        boolean acceptConditionIsDisplayed = getDriver().findElement(By.cssSelector("div[class='checkbox'] input[type='checkbox']")).isDisplayed();
        boolean acceptConditionIsSelected = getDriver().findElement(By.cssSelector("div[class='checkbox'] input[type='checkbox']")).isSelected();
        if (!acceptConditionIsDisplayed && !acceptConditionIsSelected) {
            System.out.println(" check box has problem");
            return false;
        }

        WebElement acceptConditionElement = getDriver().findElement(By.cssSelector("span[class='form-label '] span[class='label'] "));
        String acceptConditionContent = acceptConditionElement.getText();
        if (!acceptConditionContent.contentEquals("Je certifie etre majeur et j’accepte les CGU")) {
            System.out.println(acceptConditionContent + "fail hehe ");
            return false;
        }

        boolean submitPaymentIsDisplayed = getDriver().findElement(By.cssSelector("div[class='col col--2'] button[class='mdc-button mdc-button--raised mdc-button--fontInherit mdc-button--full mdc-button--fullScreenMobile']")).isDisplayed();
        boolean submitPaymentIsSelected = getDriver().findElement(By.cssSelector("div[class='col col--2'] button[class='mdc-button mdc-button--raised mdc-button--fontInherit mdc-button--full mdc-button--fullScreenMobile']")).isSelected();
        if (!submitPaymentIsDisplayed && !submitPaymentIsSelected) {
            System.out.println(acceptConditionContent + "fail hehe hehe ");
            return false;
        }

        WebElement paymentByCheck = getDriver().findElement(By.cssSelector("div[class='col col--2'] .form-link-checkpayment"));
        String paymentByCheck2 = paymentByCheck.getText();
        if (!paymentByCheck2.contentEquals("Autre moyen de paiment par chèque")) {
            System.out.println(paymentByCheck2 + "fail hehe hehe hehe");
            return false;
        }

        boolean formulaPaymentIsDisplay1 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='56']")).isDisplayed();
        boolean formulaPaymentIsSelected1 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='56']")).isSelected();
        if (!formulaPaymentIsDisplay1 && !formulaPaymentIsSelected1) {
            System.out.println("radio button to chose formula1 payment has problem ");
            return false;
        }

        boolean formulaPaymentIsDisplay2 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='54']")).isDisplayed();
        boolean formulaPaymentIsEnabled2 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='54']")).isEnabled();
        if (!formulaPaymentIsDisplay2 && !formulaPaymentIsEnabled2) {
            System.out.println("radio button to chose formula2 payment has problem ");
            return false;
        }

        boolean formulaPaymentIsDisplay3 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='53']")).isDisplayed();
        boolean formulaPaymentIsEnabled3 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='53']")).isEnabled();
        if (!formulaPaymentIsDisplay3 && !formulaPaymentIsEnabled3) {
            System.out.println("radio button to chose formula3 payment has problem ");
            return false;
        }

        WebElement taxRule = getDriver().findElement(By.cssSelector("div[class='form__row'] p[class='form__info form__info--faded'] "));
        String taxRule2 = taxRule.getText();
        if (!taxRule2.contains("Prix TTC ( Toute Taxe Comprise ) journalier appliqué pour la")) {
            System.out.println(taxRule2 + "missing tax rule");
            return false;
        }


        String parentHandle = getDriver().getWindowHandle();
        System.out.println("parent handle " + parentHandle);
        commonPage.click("span[class='form-label '] a[href='/cgu']");
//        getDriver().findElement(By.cssSelector("span[class='form-label '] a[href='/cgu'] ")).click();


        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(parentHandle)) {
                getDriver().switchTo().window(winHandle);

                String realUrlCGU = getDriver().getCurrentUrl();

                if (!realUrlCGU.contentEquals("https://www.mektoube.fr/cgu")) {
                    System.out.println(realUrlCGU + " " + "cgu url fail to get ");
                    return false;
                }
                System.out.println(realUrlCGU + " " + "get cgu url successful");
                getDriver().close();
            }
        }


        getDriver().switchTo().window(parentHandle);
        commonPage.waitUntilElementIsVisible("div[class='col col--2'] a[href='/check-payment']");
        commonPage.click("div[class='col col--2'] a[href='/check-payment']");
//        getDriver().findElement(By.cssSelector("div[class='col col--2'] a[href='/check-payment'] ")).click();


        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(parentHandle)) {
                getDriver().switchTo().window(winHandle);

                String checkPaymentUrl = getDriver().getCurrentUrl();
                if (!checkPaymentUrl.contentEquals("https://www.mektoube.fr/check-payment")) {
                    System.out.println(checkPaymentUrl + " " + "check payment url fail to get");
                    return false;
                }
                System.out.println(checkPaymentUrl + " " + "get check payment url successful");
                getDriver().close();
            }
        }
        getDriver().switchTo().window(parentHandle);

        System.out.println(titleTextOffer1month1 + titleTextOffer1month5 + titleTextOffer1month6);

        return true;

    }

    public boolean leaveAllFieldsInPaymentPageEmpty() {
        getDriver().findElement(By.cssSelector("div[class='checkbox'] input[type='checkbox']")).click();
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();
        String cardNumberWarning = getDriver().findElement(By.cssSelector(".form__row.form__row--card p.error")).getText();
        if (!cardNumberWarning.contentEquals("Le numéro de carte est obligatoire")) {
            return false;
        }
        String dateWarning = getDriver().findElement(By.cssSelector(".col.col--exp p.error")).getText();
        if (!dateWarning.contentEquals("La date est obligatoire")) {
            return false;
        }
        String CVVWarning = getDriver().findElement(By.cssSelector(".col.col--cvv.cvv p.error")).getText();
        if (!CVVWarning.contentEquals("Le CVV est obligatoire")) {
            return false;
        }
        String validateWarning = getDriver().findElement(By.cssSelector(".form__row.form__row--check p.error")).getText();
        if (!validateWarning.contentEquals("Vous devez accepter les CGU")) {
            return false;
        }
        return true;

    }

    public boolean fieldInvalidNumberOnPaymentPage() {
        getDriver().findElement(By.cssSelector("div[class='form__row form__row--card'] input[type='tel']")).sendKeys("4111111111111111");
        getDriver().findElement(By.cssSelector("div[class='col col--exp'] input[type='tel']")).sendKeys("1020");
        getDriver().findElement(By.cssSelector("div[class='col col--cvv cvv'] input[type='tel']")).sendKeys("123");
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='top-message-overlay'] div[class='top-message-text']")));
        System.out.println(element);
        String tpWWarning = element.getText();

        if (!tpWWarning.contentEquals("Echec du paiement - Refus de la banque - Verifier les infos de votre carte")) {
            System.out.println(tpWWarning);
            return false;
        }
        System.out.println(tpWWarning + " pass");
        return true;
    }

    public boolean fillAlphabetOmPaymentPage() {
        WebElement carNumber = getDriver().findElement(By.cssSelector("div[class='form__row form__row--card'] input[type='tel']"));
        carNumber.sendKeys("dsdasdad");
        WebElement date = getDriver().findElement(By.cssSelector("div[class='col col--exp'] input[type='tel']"));
        date.sendKeys("adas");
        WebElement CVVNumber = getDriver().findElement(By.cssSelector("div[class='col col--cvv cvv'] input[type='tel']"));
        CVVNumber.sendKeys("das");
        if (carNumber.getAttribute("value").contentEquals("dsdasdad")) {
            return false;
        }
        if (date.getAttribute("value").contentEquals("adas")) {
            return false;
        }
        if (CVVNumber.getAttribute("value").contentEquals("das")) {
            System.out.println(CVVNumber.getAttribute("value") + "fail");
            return false;
        }
        System.out.println(carNumber.getAttribute("value") + "pass");
        return true;
    }

    public boolean fillSpecialCharactersOnPaymentPage() {
        WebElement carNumber = getDriver().findElement(By.cssSelector("div[class='form__row form__row--card'] input[type='tel']"));
        carNumber.sendKeys("+((*&^^*&(");
        WebElement date = getDriver().findElement(By.cssSelector("div[class='col col--exp'] input[type='tel']"));
        date.sendKeys("(_+)");
        WebElement CVVNumber = getDriver().findElement(By.cssSelector("div[class='col col--cvv cvv'] input[type='tel']"));
        CVVNumber.sendKeys("$&*");
        if (carNumber.getAttribute("value").contentEquals("+((*&^^*&(")) {
            return false;
        }
        if (date.getAttribute("value").contentEquals("(_+)")) {
            return false;
        }
        if (CVVNumber.getAttribute("value").contentEquals("$&*")) {
            System.out.println(CVVNumber.getAttribute("value") + "fail");
            return false;
        }
        System.out.println(carNumber.getAttribute("value") + "pass");
        return true;
    }

    public boolean checkThatTheSixMonthOptionIsPreSelected() {
        WebElement sixMonthOption = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] input[type='radio']"));

        if (sixMonthOption.isSelected()) {
            System.out.println(sixMonthOption.getAttribute("checked") + " pass");
            return true;
        }
        System.out.println(sixMonthOption.getAttribute("checked") + " fail");
        return false;
    }

    public void clickContactRequestOrDiscussButton() {
        commonPage.waitUntilElementIsVisible("div[class='user__actions']");
        ArrayList<WebElement> contactRequest = new ArrayList<>(getDriver().findElements(By.cssSelector("button.mdc-button.mdc-button--unelevated.mdc-btn--pink")));
        ArrayList<WebElement> discuss = new ArrayList<>(getDriver().findElements(By.cssSelector("butto.nmdc-button.mdc-button--unelevated")));
        if (contactRequest.size() > 0) {
            contactRequest.get(0).click();
        } else {
            discuss.get(0).click();
        }


    }

    public boolean shouldSeeBlurMessage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> blurAvatar = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".messages__body span.avatar.avatar-box-backgrounded"))));
        System.out.println(blurAvatar.size());
        for (int i = 0; i < blurAvatar.size(); i++) {

            if (blurAvatar.get(i).getAttribute("style").contains("background-image: url(\"/images/mektoube_thumbnail.png\")")) {

                if (!blurAvatar.get(i).getAttribute("style").contains("filter: blur(0px)")) {
                    System.out.println(blurAvatar.get(i).getAttribute("style") + " " + i + " message from Mektoube service");
                    return false;
                }
                System.out.println(blurAvatar.get(i).getAttribute("style") + " " + i + " message from Mektoube service");
            } else {
                if (!blurAvatar.get(i).getAttribute("style").contains("filter: blur(3px)")) {
                    System.out.println(blurAvatar.get(i).getAttribute("style") + " " + i);
                    return false;
                }
                System.out.println(blurAvatar.get(i).getAttribute("style") + " " + i + " message of woman has ava");

            }

        }
        return true;

    }

    public boolean canReadServiceMessages() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> message = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".message"))));
        System.out.println(message.size());
        for (int i = 0; i < message.size(); i++) {

            String userName = message.get(i).findElement(By.cssSelector(".message__head h5")).getText();

            System.out.println(userName + " user name");

            if (userName.contentEquals("L'Equipe Mektoube")) {
                message.get(i).click();
                try {
                    Thread.sleep(2 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String titleMessage = getDriver().findElement(By.cssSelector(".chat__head .hidden-xs")).getText();
                if (!titleMessage.contentEquals("L'Equipe Mektoube")) {
                    System.out.println(titleMessage + " can not click to service message");
                    return false;
                }
                System.out.println(titleMessage);
            }

        }

        return true;
    }

    public void clickOnMessageUnread() {
        commonPage.waitUntilElementIsVisible("Messages");
        commonPage.click("Messages");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> unreadMess = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='message message--unread']"))));
        unreadMess.get(0).click();
    }

    public boolean shouldSeePayExpressInPaymentModal() {
        commonPage.waitUntilElementIsVisible("PaymentModal");
        ArrayList<WebElement> cardRow = new ArrayList<>(getDriver().findElements(By.cssSelector("div[class='col col--2']"))) ;
        if (cardRow.size() > 0 ) {
            System.out.println("exist cardRow");
            return false;
        }
        String titleText = getDriver().findElement(By.cssSelector("div[class='modal--header__title'] h2")).getText();
        String titleText2 = getDriver().findElement(By.cssSelector("div[class='modal--header__title'] p")).getText();
        String titleText3 = getDriver().findElement(By.cssSelector("h4[class='color-black mdc-dialog__innerTitle hidden-xs']")).getText();
        String titleText4 = getDriver().findElement(By.cssSelector("div[class='col col--2'] h4")).getText();
        if (!titleText.contentEquals("Abonnez-vous pour 0,32€ par jour !") && !titleText2.contentEquals("Sans engagement") && !titleText3.contentEquals("Choisissez votre formule")
                && !titleText4.contentEquals("Validez")) {
            System.out.println(titleText + titleText2 + titleText3 + titleText4);
            return false;
        }
        System.out.println(titleText + titleText2 + titleText3 + titleText4);
        String titleTextOffer6month1 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] span[class='popular']")).getText();
        String titleTextOffer6month2 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] div[class='col'] h5")).getText();
        String titleTextOffer6month3 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] div[class='col'] p[class='yellow']")).getText();
        String titleTextOffer6month4 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] div[class='col'] p[class='catcher']")).getText();
        String titleTextOffer6month5 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] div[class='price'] h3")).getText();
        String titleTextOffer6month6 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue offer__item--popular'] div[class='price'] p")).getText();
        if (!titleTextOffer6month1.contentEquals("Choix le plus populaire") && !titleTextOffer6month2.contentEquals("Pass 6 mois") && !titleTextOffer6month3.contentEquals("J'économise 50% !")
                && !titleTextOffer6month4.contentEquals("Facturé en un paiement de 59,90€") && !titleTextOffer6month5.contentEquals("9,90€") && !titleTextOffer6month6.contentEquals("/ mois")) {
            return false;
        }

        String titleTextOffer3month1 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue '] div[class='col'] h5")).getText();
        String titleTextOffer3month2 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue '] div[class='col'] p[class='yellow']")).getText();
        String titleTextOffer3month4 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue '] div[class='col'] p[class='catcher']")).getText();
        String titleTextOffer3month5 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue '] div[class='price'] h3")).getText();
        String titleTextOffer3month6 = getDriver().findElement(By.cssSelector("div[class='offer__item box box--blue '] div[class='price'] p")).getText();
        if (!titleTextOffer3month1.contentEquals("Pass 3 mois") && !titleTextOffer3month2.contentEquals("J'économise 30%") && !titleTextOffer3month4.contentEquals("Facturé en un paiement de 39,90€") && !titleTextOffer3month5.contentEquals("13,30€")
                && !titleTextOffer3month6.contentEquals("/ mois")) {
            return false;
        }

        String titleTextOffer1month1 = getDriver().findElement(By.cssSelector("#my-dialog-content > form > div > div.mdc-dialog__inner.cols > div.col.col--1 > div > div:nth-child(3) > label > div:nth-child(1) > h5")).getText();
        String titleTextOffer1month5 = getDriver().findElement(By.cssSelector("#my-dialog-content > form > div > div.mdc-dialog__inner.cols > div.col.col--1 > div > div:nth-child(3) > label > div:nth-child(2) > div > h3")).getText();
        String titleTextOffer1month6 = getDriver().findElement(By.cssSelector("#my-dialog-content > form > div > div.mdc-dialog__inner.cols > div.col.col--1 > div > div:nth-child(3) > label > div:nth-child(2) > div > p")).getText();
        if (!titleTextOffer1month1.contentEquals("Pass 1 mois") && !titleTextOffer1month5.contentEquals("19,90€") && !titleTextOffer1month6.contentEquals("/ mois")) {
            System.out.println(titleTextOffer1month1 + titleTextOffer1month5 + titleTextOffer1month6);
            return false;
        }
        System.out.println(titleTextOffer1month1 + titleTextOffer1month5 + titleTextOffer1month6);
        boolean formulaPaymentIsDisplay1 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='56']")).isDisplayed();
        boolean formulaPaymentIsSelected1 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='56']")).isSelected();
        if (!formulaPaymentIsDisplay1 && !formulaPaymentIsSelected1) {
            System.out.println("radio button to chose formula1 payment has problem ");
            return false;
        }
        System.out.println("radio button to chose formula1 payment ");
        boolean formulaPaymentIsDisplay2 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='54']")).isDisplayed();
        boolean formulaPaymentIsEnabled2 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='54']")).isEnabled();
        if (!formulaPaymentIsDisplay2 && !formulaPaymentIsEnabled2) {
            System.out.println("radio button to chose formula2 payment has problem ");
            return false;
        }
        System.out.println("radio button to chose formula2 payment ");
        boolean formulaPaymentIsDisplay3 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='53']")).isDisplayed();
        boolean formulaPaymentIsEnabled3 = getDriver().findElement(By.cssSelector("div[class='offer__item-aside'] input[value='53']")).isEnabled();
        if (!formulaPaymentIsDisplay3 && !formulaPaymentIsEnabled3) {
            System.out.println("radio button to chose formula3 payment has problem ");
            return false;
        }
        System.out.println("radio button to chose formula3 payment");
        boolean submitPaymentIsDisplay = getDriver().findElement(By.cssSelector("button[class='mdc-button mdc-button--raised mdc-button--fontInherit mdc-button--full mdc-button--fullScreenMobile']")).isDisplayed();
        boolean submitPaymentIsEnabled = getDriver().findElement(By.cssSelector("button[class='mdc-button mdc-button--raised mdc-button--fontInherit mdc-button--full mdc-button--fullScreenMobile']")).isEnabled();
        if (!submitPaymentIsDisplay && !submitPaymentIsEnabled) {
            System.out.println("submit payment button is missing");
            return false;
        }
        String submitButton = getDriver().findElement(By.cssSelector("button[class='mdc-button mdc-button--raised mdc-button--fontInherit mdc-button--full mdc-button--fullScreenMobile']")).getText();
        if (!submitButton.contentEquals("VALIDER VOTRE PAIEMENT")) {
            System.out.println(submitButton);
            return false;
        }
        System.out.println("submit payment button is appear");
        System.out.println(submitButton);


        WebElement taxRule = getDriver().findElement(By.cssSelector("div[class='form__row'] p[class='form__info form__info--faded'] "));
        String taxRule2 = taxRule.getText();
        if (!taxRule2.contains("Prix TTC ( Toute Taxe Comprise ) journalier appliqué pour la")) {
            System.out.println(taxRule2 + "missing tax rule");
            return false;
        }


        String parentHandle = getDriver().getWindowHandle();
        System.out.println("parent handle " + parentHandle);
        commonPage.click("span[class='form-label '] a[href='/cgu']");
//        getDriver().findElement(By.cssSelector("span[class='form-label '] a[href='/cgu'] ")).click();


        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(parentHandle)) {
                getDriver().switchTo().window(winHandle);

                String realUrlCGU = getDriver().getCurrentUrl();

                if (!realUrlCGU.contentEquals("https://www.mektoube.fr/cgu")) {
                    System.out.println(realUrlCGU + " " + "cgu url fail to get ");
                    return false;
                }
                System.out.println(realUrlCGU + " " + "get cgu url successful");
                getDriver().close();
            }
        }


        getDriver().switchTo().window(parentHandle);
        try {
            Thread.sleep(3 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        commonPage.click("div[class='col col--2'] a[href='/check-payment']");
//        getDriver().findElement(By.cssSelector("div[class='col col--2'] a[href='/check-payment'] ")).click();


        for (String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(parentHandle)) {
                getDriver().switchTo().window(winHandle);
                try {
                    Thread.sleep(2 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String checkPaymentUrl = getDriver().getCurrentUrl();
                if (!checkPaymentUrl.contentEquals("https://www.mektoube.fr/check-payment")) {
                    System.out.println(checkPaymentUrl + " " + "check payment url fail to get");
                    return false;
                }
                System.out.println(checkPaymentUrl + " " + "get check payment url successful");
                getDriver().close();
            }
        }
        getDriver().switchTo().window(parentHandle);

        System.out.println(titleTextOffer1month1 + titleTextOffer1month5 + titleTextOffer1month6);

        return true;

    }

    public boolean shouldSeeEnoughUnreadMessage() {
        commonPage.waitUntilElementIsVisible("span[class='badge']");
        String numberOfUnreadMess = getDriver().findElement(By.cssSelector("span[class='badge']")).getText();
        int numberOfUnreadMess1 =Integer.parseInt(numberOfUnreadMess);
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        ArrayList<WebElement> unreadMessList = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='message message--unread']"))));
        if (unreadMessList.size() == numberOfUnreadMess1) {
            System.out.println(unreadMessList.size() + "haha " + numberOfUnreadMess1);
            return true;
        }
        else {
            System.out.println(unreadMessList.size() + "huhu " + numberOfUnreadMess1);
            return false;
        }

    }

    public void iTryToClick(String button) {
        commonPage.waitUntilElementIsVisible(button);
        commonPage.click(button);
    }

    public void shouldSeeModalPopupWithMessage(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = '" + text + "']")));
        WebElement modalHeaderDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Vous bénéficierez d’un accès à l’ensemble des fonctionnalités du service.']")));
    }

    public void iTryToSeeOtherMembersPictureFullPage() {
        commonPage.waitUntilElementIsVisible("ProfileContainAva");
        commonPage.clickOnWhichIndexIs("ProfileContainAva", 0);
        commonPage.waitUntilElementIsVisible("div.user__avatar span");
        commonPage.click("div.user__avatar span");
    }

    public void iTryToSmileMoreThanProfile() {
        commonPage.waitUntilElementIsVisible("Profile");
        commonPage.clickOnWhichIndexIs("Profile",0);
        int smile = 0;
        while (smile < 9) {
            commonPage.waitUntilElementIsVisible("button[class='mdc-button mdc-button--outline mdc-button--unelevated']");
            commonPage.click("button[class='mdc-button mdc-button--outline mdc-button--unelevated']");
            commonPage.shouldSeeMessagePopupAtTop("Smile envoyé");
            commonPage.waitAboutSecond(4);
            smile++;
            System.out.println(smile);
            commonPage.click("a[class='control-button next-nav']");
        }


    }


}
