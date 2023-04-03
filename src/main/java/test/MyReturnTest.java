package test;
import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountOnMobilePage;
import page.CreateAccountOnWebPage;
import page.MyReturnPage;
import page.home.RegisterPage;


public class MyReturnTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private RegisterPage objRegist;
    private MyReturnPage objReturnPage;
    public MyReturnTest() {
        super();
        objRegist = new RegisterPage(this.keyword);
        objReturnPage = new MyReturnPage();
    }
    public void setUpLogin() throws InterruptedException {
        objRegist.acceptAllCookies();
        objReturnPage.goToFormLoginReturn();
    }

    @Test(priority = 1, description = "Cancel My Return successfully")
    public void testCase_MR_03() throws InterruptedException {
        setUpLogin();
        objReturnPage.returnSuccess();
    }


}
