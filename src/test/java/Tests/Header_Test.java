package Tests;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Page.Header_Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Header_Test {
    ChromeDriver driver;
    Header_Page hp;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void Run(){
        driver.get("https://dev1.glamira.com/glgb");
        hp.click();

//        driver.findElement(By.xpath("//span[contains(text(),'Log In/Sign Up')]")).click();
    }
    @AfterMethod
    public void Clean(){


    }

//    @BeforeClass
//    public void SetupHeaderPage(){
//
//    }
}



