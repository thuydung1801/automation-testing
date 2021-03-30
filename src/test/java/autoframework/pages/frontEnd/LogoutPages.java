package autoframework.pages.frontEnd;

import autoframework.pages.H_CommonPages;
import org.openqa.selenium.By;

public class LogoutPages extends H_CommonPages {
    private final String signoutbutton = "//*[@class=\"panel-header-wrap\"]/div/div[2]/ul/li[2]/a";


    public void Logout() {
        waitAboutSecond(5);
        getDriver().findElement(By.xpath(signoutbutton)).click();
        waitAboutSecond(5);

    }
}
