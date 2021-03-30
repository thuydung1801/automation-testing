package autoframework.pages.frontEnd;

import autoframework.pages.CommonPage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ReturnFormPage extends CommonPage {
    By btnSubmitReturn = By.id("submit-return-form");
    public void clickSubmitReturn(){
        getDriver().findElement(btnSubmitReturn).click();
    }
    public void getMsgError_all_blank_return_form(String expectMsgError){
        Assert.assertEquals(expectMsgError,getDriver().findElement(By.id("order_number-error")).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(By.id("email_address-error")).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(By.id("firstname-error")).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(By.id("lastname-error")).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(By.id("phone_number-error")).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(By.id("term_condition-error")).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(By.id("change_ringsize_condition-error")).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(By.id("permission_reproduction-error")).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(By.id("permission_resizing-error")).getText());

    }
    public void showErrorMessageForEmailBlank(String expectMsgError) {
        System.out.println("Show message: "+getDriver().findElement(By.id("email_address-error")).getText());
        Assert.assertEquals(expectMsgError,getDriver().findElement(By.id("email_address-error")).getText());
    }

}
