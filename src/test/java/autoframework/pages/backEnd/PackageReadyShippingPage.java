package autoframework.pages.backEnd;

import autoframework.pages.CommonPage;
import autoframework.service.TestDataService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PackageReadyShippingPage extends CommonPage {
    By acceptBtn = By.className("action-accept");
    By createdMes = By.className("//*[@id=\"messages\"]/div/div[1]/div");
    By emailMes = By.className("//*[@id=\"messages\"]/div/div[2]/div");


    public void chooseRow(int numberOfRow) {
        String Row = "rowPackageReadyShipping";
        String selectRow = TestDataService.properties.getProperty(Row);
        if (selectRow == null) {
            selectRow = Row;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Row = selectRow + numberOfRow + "]/td[1]";

        getDriver().findElement(By.xpath(Row)).click();
        System.out.println(Row);
    }
    public void clickAcceptBtn(){
        WebElement Element = getDriver().findElement(By.className("action-accept"));
        Element.click();
    }
    public void clickCancelBtn(){
        WebElement Element = getDriver().findElement(By.className("action-dismiss"));
        Element.click();
    }
    public void assertMsg() {
        String emailMsg = getDriver().findElement(emailMes).getText();
        emailMsg.endsWith("has been created.");
        String createdMsg = getDriver().findElement(emailMes).getText();
        createdMsg.endsWith("has been sent email.");
    }

}
