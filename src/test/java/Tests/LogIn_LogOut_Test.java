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
//    static WebDriver driver;
    ChromeDriver driver;

    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void loginLocationElement() throws InterruptedException {
        driver.get("https://dev1.glamira.com/glgb");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Log In/Sign Up')]")).click();
    }
//    @Test
//    public void status() {
//        boolean status = driver.findElement(By.xpath("//h2[@id='block-customer-login-heading']")).isDisplayed();
//        if (status) {
//            System.out.printf("This is form login !");
//        }
//    }
//    @Test
//    public void useNamElement() {
//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nguyenthilien1962@gmail.com");
//    }
//    @Test
//    public void passWordElement() {
//        driver.findElement(By.xpath("//field-set[@class='field-set login']//input[@id='pass']")).sendKeys("Lien1962@");
//    }
//
//    @Test
//    public void actionElement() {
//        driver.findElement(By.xpath("//button[@id='send2']")).submit();
//    }
//
//    //
//    @Test
//    public void checkdisplayElement() {
//        boolean status1 = driver.findElement(By.linkText("My Orders")).isDisplayed();
//        if (status1) {
//            System.out.println("This is my order");
//        }
//    }
//    @Test
//    public void SelectItem() {
//        driver.findElement(By.linkText("My Orders")).click();
//    }
//    //		checkblock
    @AfterMethod
    public void editProgram() {
        driver.quit();
    }


}
