package autoframework.pages.frontEnd;

import autoframework.pages.CommonPage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ForgotPassPage extends CommonPage {
    By msgError = By.id("email_address-error");// chung
    By manyRequest = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
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
    public void getMsgError_fail(String expectMsgError){
        Assert.assertEquals(expectMsgError,getDriver().findElement(manyRequest).getText());
    }

}
