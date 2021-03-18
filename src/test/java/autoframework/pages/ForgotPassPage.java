package autoframework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ForgotPassPage extends BasePage {

    By forgotPassBtn =  By.className("remind");
    By resetMyPassBtn = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
    By goBackBtn = By.xpath("//*[@id=\"form-validate\"]/div/div[2]/a/span");
    By msg_forgotPass = By.id("contentarea");

    public void forgotPassBtn(){getDriver().findElement(forgotPassBtn).click();}
    public void resetMyPassBtn() {
        getDriver().findElement(resetMyPassBtn).click();
    }
    public void goBackBtn() {
        getDriver().findElement(goBackBtn).click();
    }
    public void getMsgSuc_forgotPass(String expectMsg){
        Assert.assertEquals(expectMsg,getDriver().findElement(msg_forgotPass).getText());
    }
}
