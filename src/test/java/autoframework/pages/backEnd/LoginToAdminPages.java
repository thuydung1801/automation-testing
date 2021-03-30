package autoframework.pages.backEnd;
import autoframework.pages.H_CommonPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static autoframework.service.TestDataService.properties;



public class LoginToAdminPages extends H_CommonPages {
    private final String username = "//*[@id=\"username\"]";
    private final String pass = "//*[@id=\"login\"]";
    private final String signin = "//*[@class=\"action-login action-primary\"]";
    private final String adminpages = "//*[@id=\"html-body\"]/div[1]";


    public void LoginAdmin(String userName, String password) {
        WebElement texBoxEmail = getDriver().findElement(By.xpath(username));
        WebElement textBoxPassWord = getDriver().findElement(By.xpath(pass));
        WebElement buttonLogin = getDriver().findElement(By.xpath(signin));

        texBoxEmail.sendKeys(userName);
        textBoxPassWord.sendKeys(password);
        buttonLogin.click();
    }

    public void LoginAdmin(String isValid) {
        String email;
        String password;

        if (isValid.equalsIgnoreCase("valid")) {
            email = properties.getProperty("username");
            password = properties.getProperty("pass");
        } else {
            email = properties.getProperty("wrongUsername");
            password = properties.getProperty("wrongPasswordadmin");
        }

        this.LoginAdmin(email, password);
    }

    public boolean AdminPages() {
        try {
            return getDriver().findElement(By.xpath(adminpages)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
