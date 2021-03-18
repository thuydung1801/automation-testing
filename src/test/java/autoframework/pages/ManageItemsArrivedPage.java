package autoframework.pages;

import autoframework.service.TestDataService;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ManageItemsArrivedPage {

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
}
