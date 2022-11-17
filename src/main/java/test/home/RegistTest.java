package test.home;

import core.BaseTest;
import org.testng.annotations.Test;
import page.home.RegisterPage;

public class RegistTest extends BaseTest {
    private RegisterPage objRegist;
    public RegistTest() {
        super();
    }
    @Test
    public void testcase001() throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);
        objRegist.acceptAllCookies();
        objRegist.registFail();
        objRegist.registSuccess();
    }
}
