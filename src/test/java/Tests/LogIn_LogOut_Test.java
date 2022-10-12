package Tests;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//        import org.seleniumhq.jetty9.server.HostHeaderCustomizer;

public class LogIn_LogOut_Test {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Setup\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://dev1.glamira.com/glgb");

        WebElement loginLocationElement = driver.findElement(By.xpath("//li[@data-label='or']//a"));
        loginLocationElement.click();

        WebElement formLoginElement = driver.findElement(By.xpath("//h2[@id='block-customer-login-heading']"));
        boolean status = formLoginElement.isDisplayed();
        if (status) {
            System.out.println("This is form login !");
        }
//		enter data login.

        WebElement useNamElement = driver.findElement(By.xpath("//input[@id='email']"));
        useNamElement.sendKeys("nguyenthilien1962@gmail.com");

        WebElement passWordElement = driver
                .findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']"));

        passWordElement.sendKeys("Lien1962@");

        WebElement actionElement = driver.findElement(By.xpath("//button[@id='send2']"));
        actionElement.submit();
//
        WebElement checkdisplayElement = driver.findElement(By.linkText("My Orders"));
        boolean status1 = checkdisplayElement.isDisplayed();

        if (status1) {
            System.out.println("This is my order");
            checkdisplayElement.click();
        }

//		checkblock

        WebElement checkblockElement = driver
                .findElement(By.xpath("//div[@class='block account-nav block-collapsible-nav']"));

        boolean statusblock = checkblockElement.isDisplayed();
        if (statusblock) {

            System.out.println("This is list content text");

            List<WebElement> listTextElements = driver.findElements(By.xpath("//ul[@class='nav items']"));

            for (int i = 0; i < listTextElements.size(); i++) {
                System.out.println(listTextElements.get(i).getText());
            }

        }
        driver.quit();
    }

}
