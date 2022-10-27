package Page.Header_Footer;

import Page_Element.Header_Footer.Marketing_Element;
import Page_Element.catalog.ProductDetail_Element;
import Page_Lib.Common;
import Page_Lib.ReadData;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Marketing_Page extends Common {
    RemoteWebDriver driver;
    Marketing_Element marketingElement;
    ReadData data;
    public Marketing_Page(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        data = new ReadData();
        marketingElement = new Marketing_Element(driver);

    }
    public void caseGiftCard() throws InterruptedException {
        submitCookie();
        sendKey(marketingElement.ipName, data.getKey("ipName"));
        Thread.sleep(1000);
        sendKey(marketingElement.ipMail, data.getKey("ipMail"));
        skipAllow();

    }

}
