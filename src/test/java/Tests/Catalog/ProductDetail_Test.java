package Tests.Catalog;

import Common_Page.AbstractBase_Test;
import org.testng.annotations.Test;

public class ProductDetail_Test extends AbstractBase_Test {
    @Test
    public void RunProductDetail() throws InterruptedException {
        App().Flow().navigateToUrl("https://dev3.glamira.com/glde/diamantringe/diamant/");

        App().Pages().ProductDetailPage().clickProduct();

//        App().Pages().ProductDetailPage().click();
        System.out.printf("test 1: Show  detail image" +"\n");
        App().Pages().ProductDetailPage().clickShowImg();
        Thread.sleep(2000);
        App().Pages().ProductDetailPage().closeDialog();

        System.out.printf("test 2: Dropdown");
        Thread.sleep(1000);
        App().Pages().ProductDetailPage().clickDropdown();



    }

}
