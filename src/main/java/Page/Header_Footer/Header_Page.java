package Page.Header_Footer;

import Page_Element.Header_Footer.Header_Element;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Header_Page {
    //  ChromeDriver driver;
    RemoteWebDriver driver;
    Header_Element headerElement;
    public Header_Page(RemoteWebDriver driver) {
        this.driver = driver;
        headerElement = new Header_Element(driver);
        driver.manage().window().maximize();

    }
    public void clickBtnLogIn() {

        headerElement.headerLogin.click();
    }

    public void senKeySearch() {

        File file = new File("D:\\automation\\src\\main\\Data_Test\\data.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        headerElement.headerSearch.sendKeys(prop.getProperty("searchKey"));
    }

    public void clickBtnSearch() {
        headerElement.headerBtnSearch.click();
    }
    public void clickBtnNext() {
        headerElement.headerBtnNext.click();
    }


}
