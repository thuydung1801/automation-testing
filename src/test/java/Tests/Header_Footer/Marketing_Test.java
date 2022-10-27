package Tests.Header_Footer;

import Common_Page.AbstractBase_Test;
import Page_Lib.ReadData;
import org.testng.annotations.Test;

public class Marketing_Test extends AbstractBase_Test {
    ReadData data = new ReadData();
    @Test
    public void RunGiftCard() throws InterruptedException {
        App().Flow().navigateToUrl(data.getKey("url_Marketing"));
        App().Pages().MarketingPage().caseGiftCard();

    }

}
