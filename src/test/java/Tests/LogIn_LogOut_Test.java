package Tests;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

public class LogIn_LogOut_Test {
    static WebDriver driver;

    public void Setup() {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "D:\\Setup\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

   @Test
   public void SelectElement (){
        driver.findElement(By.xpath("//a[@title='Log In/Sign Up']")).click();
   }

    //		checkblock
    @AfterClass
    public void editProgram() {
        driver.quit();
    }


}
