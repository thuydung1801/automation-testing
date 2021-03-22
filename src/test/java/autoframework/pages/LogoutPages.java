package autoframework.pages;

import org.openqa.selenium.By;

public class LogoutPages extends CommonPage {
    private final String signoutbutton = "//*[@class=\"panel-header-wrap\"]/div/div[2]/ul/li[2]/a";


    public void Logout() {
        waitAboutSecond(5);
        getDriver().findElement(By.xpath(signoutbutton)).click();
        waitAboutSecond(5);

    }
}
