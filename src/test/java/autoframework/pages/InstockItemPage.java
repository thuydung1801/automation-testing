package autoframework.pages;

import autoframework.service.TestDataService;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class InstockItemPage extends CommonPage{
    By MsgTranfer = By.className("message");
    By barcodeBox = By.name("barcode");
    By selectBox = By.className("data-grid-checkbox-cell-inner");
    By itemState = By.xpath("//*[@id=\"reproduction_request_grid_table\"]/tbody/tr/td[15]");
    By clickItemState = By.name("item_state");
    By clickProcessStatus = By.name("processing_status");


    public void insertBarcode(String barcode) {
        getDriver().findElement(barcodeBox).sendKeys(barcode, Keys.ENTER);
    }
    public void selectOrder(){
        getDriver().findElement(selectBox).click();
    }
    public void getMsgTranfer(String expectMsg) {
        System.out.println("show actual msg:" +getDriver().findElement(MsgTranfer).getText());
        Assert.assertEquals(expectMsg,getDriver().findElement(MsgTranfer).getText());
    }
    public void sucTranfer(String expectText){
        System.out.println("successfully tranfer :" + getDriver().findElement(itemState).getText());
        Assert.assertEquals(expectText,getDriver().findElement(itemState).getText());
    }

    public void getFilter(String itemState, String processStatus) {
        Select select = new Select(getDriver().findElement(clickItemState));
        String itemStateElement = TestDataService.properties.getProperty(itemState);
        if (itemStateElement == null) {
            itemStateElement = itemState;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        select.selectByVisibleText(itemStateElement);

        Select selectProcess = new Select(getDriver().findElement(clickProcessStatus));
        String processStatusElement = TestDataService.properties.getProperty(processStatus);
        if (processStatusElement == null) {
            processStatusElement = processStatus;
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        selectProcess.selectByVisibleText(processStatusElement);;
        getDriver().findElement(clickProcessStatus).sendKeys(Keys.RETURN);
    }
    public void chooseRow(int numberOfRow) {
        String Row = "row";
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

}
