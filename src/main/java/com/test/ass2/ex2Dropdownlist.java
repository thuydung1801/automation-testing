package com.test.ass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import core.LogHelper;

import static org.testng.AssertJUnit.*;

public class ex2Dropdownlist {
    protected static final Logger logger = LogHelper.getLogger();
    @Test
    public void test1() throws InterruptedException {
        logger.info("tro vao duong dan trinh duyet");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait waiting = new WebDriverWait(driver, 20);
        logger.info("di toi trang automatenow");
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);
        //waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'automateNow')]")));
//        logger.info("tuong tac voi dropdown");
//        Select ddlMenu = new Select(driver.findElement(By.xpath("//select[@id = 'g1103-dropdownmenu']")));
//        logger.info("kiem tra ddl ko dc chon nhieu option");
//        assertFalse(ddlMenu.isMultiple());
//        logger.info("kiem tra so luong option trong ddl");
//        assertEquals(5, ddlMenu.getOptions().size());
//        logger.info("chon option Hexa va kiem tra da chon dung option hexa");
//        ddlMenu.selectByVisibleText("Hexa");
//        Thread.sleep(2000);
//        assertEquals("Hexa", ddlMenu.getFirstSelectedOption().getText());
//        logger.info("chon option Decimal bang value");
//        ddlMenu.selectByValue("Decimal");
//        assertEquals("Decimal", ddlMenu.getFirstSelectedOption().getText());
//        Thread.sleep(2000);
//        logger.info("chon option by index");
//        ddlMenu.selectByIndex(3);
//        assertEquals("Octal", ddlMenu.getFirstSelectedOption().getText());
//        Thread.sleep(2000);

//        ddlMenu.deselectByIndex(3);
//        assertEquals("(none)", ddlMenu.getFirstSelectedOption().getText());
//        Thread.sleep(2000);

        logger.info("tick vao radio button");
        WebElement rdoMaleDiv = driver.findElement(By.xpath("//div[@class='custom-control custom-radio custom-control-inline'][1]"));
        WebElement rdoMaleInput = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        if (!rdoMaleInput.isSelected()) {
            rdoMaleDiv.click();
        }
        assertTrue(rdoMaleInput.isSelected());
        Thread.sleep(2000);

        WebElement rdodiv = driver.findElement(By.xpath("//div[@class='custom-control custom-radio custom-control-inline'][3]"));
        WebElement rdoMaleInput2 = driver.findElement(By.xpath("//input[@id='gender-radio-3']"));
        if (!rdoMaleInput2.isSelected()) {
            rdodiv.click();
        }
        assertTrue(rdoMaleInput2.isSelected());
        Thread.sleep(2000);
        logger.info("dong trinh duyet");
        driver.quit();


    }
}
