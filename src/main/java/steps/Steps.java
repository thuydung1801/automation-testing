package steps;
import java.io.File;
import java.io.IOException;

import core.BasePage;
import core.KeywordWeb;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.checkout.LoginAddressPage;
import page.checkout.ShoppingBagPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import ru.yandex.qatools.ashot.Screenshot;
import utils.FolderUtil;
import utils.ImageMagickUtil;
import utils.JSUtil;
import utils.ScreenshotUtil;
public class Steps {
    public WebDriver     driver;
    public WebDriverWait wait;
    public JSUtil        jsUtil;
    public String        url = "https://dev4.glamira.com/glau";
    public Screenshot    googleScreenshot;
    public FolderUtil      folderUtil      = new FolderUtil();
    public ScreenshotUtil  screenshotUtil  = new ScreenshotUtil();
    public ImageMagickUtil imageMagickUtil = new ImageMagickUtil();

    private RegisterPage objRegist;
    private LoginPage objLogin;
    private ShoppingBagPage objShoppingBagPage;
    public KeywordWeb keyword;
//
//    public Steps(){
//        keyword = new KeywordWeb();
//    }
////    public Steps(KeywordWeb key){
////       this.keyword = key;
////    }

    public Steps(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        jsUtil = new JSUtil(wait, driver);
    }

    public void preTestSetup() throws IOException {
        //Create screenshot and differences folders if they are not exist
        folderUtil.createFolder(folderUtil.parentScreenShotsLocation);
        folderUtil.createFolder(folderUtil.parentDifferencesLocation);
        //Clean Differences Root Folder
        File differencesFolder = new File(folderUtil.parentDifferencesLocation);
        FileUtils.cleanDirectory(differencesFolder);
        driver.navigate().to(url);
        //driver.findElement(By.xpath("/html/body/div[2]/div[3]/header/div/div/div[3]/ul/li[1]/a")).click();
        jsUtil.waitJS();
        //jsUtil.hideDynamicContent();
    }

    public void A() throws InterruptedException {

    }

    public Steps givenIAcceptTheCookies() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/header/div/div/div[3]/ul/li[1]/a")).click();
        return this;
    }

    public Steps givenITakeScreenShot() {
        //Take ScreenShot with AShot
        googleScreenshot = screenshotUtil.takeScreenshot(driver);
        return this;
    }


    public Steps whenISaveTheScreenShotsToFolders() throws IOException {
        //Write actual screenshot to the actual screenshot path
        folderUtil.writeScreenshotToFolder(googleScreenshot);
        return this;
    }

    public Steps thenIShouldCompareScreenshotsSuccessfully() throws Exception {
        //Do image comparison
        imageMagickUtil.doComparison(googleScreenshot, folderUtil);
        return this;
    }
}
