package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.HomePage;
import page.Register;

public class RegistTest extends BaseTest {
    private Register objRegist;
    public RegistTest() {
        super();
    }
    @Test
    public void testcase001() throws InterruptedException {
        objRegist = new Register(this.keyword);
        objRegist.acceptAllCookie();
        //objRegist.registFail();
        objRegist.registSuccess();
    }

}
