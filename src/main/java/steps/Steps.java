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

    public KeywordWeb keyword;

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
        jsUtil.waitJS();
        //jsUtil.hideDynamicContent();
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
