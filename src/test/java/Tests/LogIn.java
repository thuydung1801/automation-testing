package Tests;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Common_Page.AbstractBase_Test;
import Page.Header_Page;
import Page.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LogIn extends AbstractBase_Test {
   // ChromeDriver driver;
    @Test
    public void Run(){
        App().Flow().navigateToUrl("https://dev1.glamira.com/glgb");
        App().Pages().LogInOutage().click();
        App().Pages().LogInOutage().EnterMail();
        App().Pages().LogInOutage().EnterPw();
        App().Pages().LogInOutage().SubmitBtn();
    }
   // Login_Page login;


//    @BeforeMethod
//    public void Setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }
//    @Test
//    public void GetURL(){
//        driver.get("https://dev1.glamira.com/glgb");
//        login.click();
////        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nguyenthilien1962@gmail.com");
////        driver.findElement(By.xpath("//button[@id='send2']")).submit();
////        driver.findElement(By.xpath("//button[@id='send2']")).submit();
//    }
//
//    @AfterMethod
//    public void Clean() {
//        driver.quit();
//
//    }
}
