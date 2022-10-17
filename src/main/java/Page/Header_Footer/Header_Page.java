package Page.Header_Footer;

import Page_Element.Header_Footer.Header_Element;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Header_Page {
    //  ChromeDriver driver;
    RemoteWebDriver driver;
    Header_Element headerElement;


    public Header_Page(RemoteWebDriver driver) {
        this.driver = driver;
        headerElement = new Header_Element(driver);


    }

    public void clickBtnLogIn() {

        headerElement.headerLogin.click();
    }

    public void senKeySearch() {
        headerElement.headerSearch.sendKeys("ring");
    }

    public void clickBtnSearch() {
        headerElement.headerBtnSearch.click();
    }

    public void clickBtnNext() {
        headerElement.headerBtnNext.click();
    }


}
