package autoframework.pages.backEnd;

import autoframework.service.TestDataService;
import autoframework.pages.H_CommonPages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class InvoiceOrderPages extends H_CommonPages {
    private final String salemenu = "//*[@id=\"menu-magento-sales-sales\"]/a";
    private final String ordergrid = "//*[@href=\"https://test.glamira2.just4demo.biz/admin/sales/order/\"]";
    private final String searchbox = "#fulltext";
    private final String viewlocator = "//*[@id=\"container\"]/div/div[4]/table/tbody/tr[1]//a";
    private final String invoiceorder = "//*[@id='order_invoice']";
   // private final String SubmitInvoice = "//*[@id='id_ntK6dJK7a5IXsumRaT9e52liUR2Dn22U']";
    private final String SubmitInvoice = "//*[@id=\"invoice_totals\"]/div[2]/div[2]/button";
    private final String SuccessMessage = "#messages";
    private final String orderitemgrid = "//*[@href=\"https://test.glamira2.just4demo.biz/admin/salemanagement/sales_orderitem/\"]";
    private final String inputorder = "//*[@id=\"sales_order_item_grid_filter_increment_id\"]";
    private final String checkbox = "//*[@id=\"sales_order_item_grid_table\"]/tbody/tr/td[1]//input";
    private final String ActionRequestToProcess = "//*[@id=\"sales_order_item_grid_massaction-select\"]/option[2]";
    private final String stateofcolumnrequest = "//*[@id=\"sales_order_item_grid_table\"]/tbody/tr/td[5]";
    private final String SubmitButton = "//*[@id=\"sales_order_item_grid_massaction-form\"]/div/button";
    private final String PopupOKlocator = "//*[@class=\"modals-wrapper\"]/aside[2]/div[2]/footer/button[2]";
    private final String unsuccess = "#messages > div > div > div";



    public void salemenu() {
        getDriver().findElement(By.xpath(salemenu)).click();
        waitAboutSecond(5);
    }

    public void Ordergrid() {
        getDriver().findElement(By.xpath(ordergrid)).click();
        waitAboutSecond(20);
    }

//    public void SearchBox() {
//
////        enterTextIntoField("7029261685",searchbox);
//        getDriver().findElement(By.cssSelector(searchbox)).click();
//        getDriver().findElement(By.id("fulltext")).sendKeys("\n" + "7029261680"+ Keys.ENTER);
//       // getDriver().findElement(By.id("fulltext")).;
//        waitAboutSecond(10);
//    }

    public void ViewItem() {
        getDriver().findElement(By.xpath(viewlocator)).click();
        waitAboutSecond(5);
    }

    public void InvoiceOrder() {
        getDriver().findElement(By.xpath(invoiceorder)).click();
        waitAboutSecond(5);
    }

    public void SubmitInvoice() {
//        By by = new By.ByXPath(SubmitInvoice);
//        scrollTo(by);
//        waitAboutSecond(5);
//        click(by);
//        waitAboutSecond(5);
        scrollToAndClick(SubmitInvoice);

    }
    public void successmessage(String text) {
//        List<WebElement> list = getDriver().findElements(By.cssSelector(SuccessMessage));
//        Assert.assertEquals(text,list);
        validateInformation(SuccessMessage,text);
        waitAboutSecond(5);
        //đợi 1 phts để chạy auto request to process trong order item grid
    }

    public void OrderItemGrid() {
        getDriver().findElement(By.xpath(orderitemgrid)).click();
        waitAboutSecond(5);
    }

    public void SearchBox(String orderid) {
        String orderID = TestDataService.properties.getProperty(orderid);
        if (orderID == null) {
            orderID = orderid;
        }
        getDriver().findElement(By.cssSelector(searchbox)).clear();

        getDriver().findElement(By.id("fulltext")).sendKeys("\n" + orderID+ Keys.ENTER);
       // getDriver().findElement(By.id("fulltext")).;
        waitAboutSecond(10);
    }

    public void enteridoforder(String orderid) {
        InputText(orderid,inputorder);
        waitAboutSecond(5);
    }

    public void ChooseOrder() {
        getDriver().findElement(By.xpath(checkbox)).click();
        System.out.println("check click");
        waitAboutSecond(5);
    }

    public void ActionRequestToProcess() {
        getDriver().findElement(By.xpath(ActionRequestToProcess)).click();
        waitAboutSecond(5);
    }
    public void IsRequestedToProcessOfRecord() {
        String text = getDriver().findElement(By.xpath(stateofcolumnrequest)).getText();
        Assert.assertEquals(text,"Yes");

    }

    public void clickSubmitButton() {
        getDriver().findElement(By.xpath(SubmitButton)).click();
        waitAboutSecond(5);
        getDriver().findElement(By.xpath(PopupOKlocator)).click();
    }

    public void TheScreenDisplayShowsTheMessage(String text) {

        validateInformation(unsuccess,text);
        waitAboutSecond(5);
    }
}
