package Tests;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class LogIn_LogOut_Test {
    public static WebDriver driver;

    @BeforeClass
    public static void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://dev3.glamira.com/glgb/");
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
