package autoframework.pages.backEnd;

import autoframework.Entity.OrderInfo;
import autoframework.pages.H_CommonPages;
import autoframework.service.TestDataService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;



import autoframework.Utils.Vars;



import java.util.List;


public class UpdateStoneProcessPages extends H_CommonPages {

    private final String productionmenu = "//*[@id=\"nav\"]/li[4]/a";
    private final String updatestoneprocess = "//*[@id=\"menu-opentechiz-production-production\"]/div/ul/li[1]/ul/li[9]/a";
    private final String barcodebox = "//*[@id=\"filter-item\"]/tbody/tr[2]/td/input";

    public void ProductionsMenu() {
        getDriver().findElement(By.xpath(productionmenu)).click();
        waitAboutSecond(5);

    }

    public void UpdateStoneProcessGrid() {
        getDriver().findElement(By.xpath(updatestoneprocess)).click();
        waitAboutSecond(5);
    }

    public void searchitemwithbarcode(String barcode) {
        String BARCODE = TestDataService.properties.getProperty(barcode);
        if (BARCODE == null) {
            BARCODE = barcode;
        }
        getDriver().findElement(By.xpath(barcodebox)).clear();

        getDriver().findElement(By.xpath(barcodebox)).sendKeys("\n" + BARCODE + Keys.ENTER);
        // getDriver().findElement(By.id("fulltext")).;
        waitAboutSecond(10);

    }



    public void GetInfoOfStoneOrder() {
        String xpath_listOfOrderedStone = "//table[@id='result_item_request']/tbody/tr/td/span[contains(.,'Ready')]";
        List<WebElement> orderedStoneList = getDriver().findElements(By.xpath(xpath_listOfOrderedStone));

        // vòn lặp ở đây
        for (int i = 0; i < orderedStoneList.size(); i++) {
            WebElement stone = orderedStoneList.get(i);
            String[] stoneInfo = stone.getText().split("\\|");

            //cacahs viết cũ chỉ in ra list  info của item
//            System.out.println("Certificate: " + stoneInfo[0]);
//            System.out.println("Shape: " + stoneInfo[1]);
//            System.out.println("type: " + stoneInfo[2]);
//            System.out.println("size: " + stoneInfo[3]);
//            System.out.println("qty: " + stoneInfo[4]);
//            System.out.println("diameter: " + stoneInfo[5]);
//            System.out.println("clarity: " + stoneInfo[6]);
//            System.out.println("color: " + stoneInfo[7]);
//            System.out.println("cut: " + stoneInfo[8]);
//            System.out.println("heated: " + stoneInfo[9]);
//            System.out.println("stoneName: " + stoneInfo[10]);
//            System.out.println("status: " + stoneInfo[11]);

            OrderInfo orderInfo1 = new OrderInfo();

             orderInfo1.setCertificate(stoneInfo[0]);
            orderInfo1.setShape(stoneInfo[1]);
            orderInfo1.setType(stoneInfo[2]);
            orderInfo1.setSize(stoneInfo[3]);
            orderInfo1.setQty(Integer.parseInt(stoneInfo[4].trim()));
            orderInfo1.setDiameter(stoneInfo[5]);
            orderInfo1.setClarity(stoneInfo[6]);
            orderInfo1.setColor(stoneInfo[7]);
            orderInfo1.setCut(stoneInfo[8]);
            orderInfo1.setHeated(stoneInfo[9]);
            orderInfo1.setStoneName(stoneInfo[10]);
            orderInfo1.setStatus(stoneInfo[11]);

            // Vars là 1 class viết hoạt động như kiểu 1 dependency injection, để lưu đối tượng rồi sau đó lấy ra ở 1 class khác
            // Vars.add là để lưu "order1" là tên biến, qua bên kia mình gọi ra.
            Vars.add("order1", orderInfo1);


        }


    }
    public void openManageStone() {
        OpenNewTab("https://test.glamira2.just4demo.biz/admin/material/stone_managestone/");

    }
}
