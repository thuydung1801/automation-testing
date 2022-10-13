package Page;

import Page_Element.Header_Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Header_Page {
    ChromeDriver driver;
    Header_Element header;


    public Header_Page(ChromeDriver driver) {
        this.driver = driver;
        header = new Header_Element(driver);


    }
    public void click(){
        header.headerLogin.click();
    }
}
