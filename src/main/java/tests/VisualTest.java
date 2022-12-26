package tests;
import org.testng.annotations.Test;
public class VisualTest extends BaseTest {
    @Test
    public void visualTest() throws Exception {
        steps
                .givenIAcceptTheCookies()
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
}