package com.test.ass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import core.LogHelper;

import static org.testng.AssertJUnit.assertEquals;

public class ex1 {
    protected static final Logger logger = LogHelper.getLogger();
    @Test
    public void test1() {
        logger.info("tro vao duong dan trinh duyet");
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait waiting = new WebDriverWait(driver, 20);
        logger.info("di toi trang tiki");
        driver.get("https://tiki.vn");
        waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-view-id=\"main_search_form_button\"]")));
        logger.info("check title");
        String strTitle = driver.getTitle();
        assertEquals("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh", strTitle);
        logger.info("kiem tra placeholder");
        WebElement tbxSearch = driver.findElement(By.xpath("//input[@data-view-id=\"main_search_form_input\"]"));
        String strPlaceholder = tbxSearch.getAttribute("placeholder");
        assertEquals("Tìm sản phẩm, danh mục hay thương hiệu mong muốn ...", strPlaceholder);
        logger.info("check font-size cua textbox tim kiem");
        assertEquals("13px", tbxSearch.getCssValue("font-size"));

        logger.info("nhap san pham vao o tim kiem");
        driver.findElement(By.xpath("//input[@data-view-id=\"main_search_form_input\"]")).sendKeys("banh trung thu");
//        logger.info("bam nut tim kiem");
//        driver.findElement(By.xpath("//button[@data-view-id=\"main_search_form_button\"]")).click();
//        WebDriverWait waiting = new WebDriverWait(driver, 20);
//        waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h3[text()='Bánh Trung Thu Hữu Nghị - Thập Cẩm Lạp Xưởng 150g'])")));
//        logger.info("bam vao sam pham dau tien");
//        driver.findElement(By.xpath("(//h3[text()='Hộp 2 Bánh Trung Thu Kinh Đô \"Thu Sum Vầy\"'])[1]")).click();
//        logger.info("doi load man hinh");
//        waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Hộp 2 Bánh Trung Thu Kinh Đô \"Thu Sum Vầy\"')]")));
//        logger.info("kiem tra ten va gia cua san pham");
//        driver.findElement(By.xpath("(//h1[text()='Hộp 2 Bánh Trung Thu Kinh Đô \"Thu Sum Vầy\"'])[1]")).isDisplayed();
//        driver.findElement(By.xpath("//div[text()='227.000 ₫']")).isDisplayed();
        logger.info("dong trinh duyet");
        driver.quit();



    }



}
