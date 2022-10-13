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
public class LogIn_LogOut_Test {
    static WebDriver driver;

    public void Setup() {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "D:\\Setup\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://dev1.glamira.com/glgb");
    }
    @Test
    public void loginLocationElement() {
        WebDriver driver = new ChromeDriver();
        driver.findElement(By.xpath("//li[@data-label='or']//a")).click();
    }
    @Test
    public void status() {
        boolean status = driver.findElement(By.xpath("//h2[@id='block-customer-login-heading']")).isDisplayed();
        if (status) {
            System.out.println("This is form login !");
        }
    }
    @Test
    public void useNamElement() {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nguyenthilien1962@gmail.com");
    }
    @Test
    public void passWordElement() {
        driver.findElement(By.xpath("//field-set[@class='field-set login']//input[@id='pass']")).sendKeys("Lien1962@");
    }

    @Test
    public void actionElement() {
        driver.findElement(By.xpath("//button[@id='send2']")).submit();
    }

    //
    @Test
    public void checkdisplayElement() {
        boolean status1 = driver.findElement(By.linkText("My Orders")).isDisplayed();
        if (status1) {
            System.out.println("This is my order");
        }
    }
    @Test
    public void SelectItem() {
        driver.findElement(By.linkText("My Orders")).click();
    }
    //		checkblock
    @AfterClass
    public void editProgram() {
        driver.quit();
    }


}
