package tests;
import org.testng.annotations.Test;
import steps.Steps2;

public class VisualTest extends BaseTest {
    private Steps2 step2;
    @Test
    public void visualTest() throws Exception {
        step2 = new Steps2(this.keyword);
        step2.a();

        steps
                //.givenIAcceptTheCookies()
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
}