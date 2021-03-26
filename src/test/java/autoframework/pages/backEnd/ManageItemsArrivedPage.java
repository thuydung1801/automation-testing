package autoframework.pages.backEnd;

import autoframework.pages.CommonPage;
import autoframework.service.TestDataService;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ManageItemsArrivedPage extends CommonPage {
    By MsgTranfer = By.className("message");

    public void chooseRowManageItemsArrivedPage(int numberOfRow) {
        String Row = "rowManageItemsArrived";
        String selectRow = TestDataService.properties.getProperty(Row);
        if (selectRow == null) {
            selectRow = Row;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Row = selectRow + numberOfRow + "]/td[1]/label/input";

        getDriver().findElement(By.xpath(Row)).click();
        System.out.println(Row);
    }

    public void clickButtonToShipOut() {
        getDriver().findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[2]/div[1]/div/button")).click();
        getDriver().findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[2]/div[1]/div/ul/li/span")).click();
    }

    public void clickButtonOk() {
        getDriver().findElement(By.className("action-accept")).click();

    }
    public void getMsgTranferInManageItemsArrivedPage(String expectMsg) {
        System.out.println("show actual msg:" +getDriver().findElement(MsgTranfer).getText());
        Assert.assertEquals(expectMsg,getDriver().findElement(MsgTranfer).getText());
    }
}
