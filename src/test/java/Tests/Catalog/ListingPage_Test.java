package Tests.Catalog;
import Common_Page.AbstractBase_Test;
import org.testng.annotations.Test;

public class ListingPage_Test extends AbstractBase_Test {
    @Test
    public void ClickAllView() {
        App().Flow().navigateToUrl("https://dev3.glamira.com/glgb/rings-home/");
        App().Pages().ListingPage().ClickOnView();
        App().Pages().ListingPage().SelectStn();
        App().Pages().ListingPage().SelectCR();
    }
}
