package Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Common_Page.AbstractBase_Test;
import Page.Header_Page;
import Page_Lib.App_Lib;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Header_Test extends AbstractBase_Test {


    @Test
    public void RunLogin(){
            App().Flow().navigateToUrl("https://dev1.glamira.com/glgb");
            App().Pages().HeaderPage().clickBtnLogIn();

    }
    @Test
    public void RunSearch(){
        App().Flow().navigateToUrl("https://dev1.glamira.com/glgb/");
        App().Pages().HeaderPage().senKeySearch();

        App().Pages().HeaderPage().clickBtnSearch();
        App().Pages().HeaderPage().clickBtnNext();
    }



}



