package Tests.Catalog;

import Common_Page.AbstractBase_Test;
import org.testng.annotations.Test;

public class ProductDetail_Test extends AbstractBase_Test {
    @Test
    public void RunProductDetail() throws InterruptedException {
        App().Flow().navigateToUrl("https://dev3.glamira.com/glde/diamantringe/diamant/");

        App().Pages().ProductDetailPage().clickProduct();

//        App().Pages().ProductDetailPage().click();
        System.out.printf("-----test 1: Show  detail image" +"\n");

        App().Pages().ProductDetailPage().clickShowImg();
        System.out.printf("test 1 done");
        Thread.sleep(2000);

        System.out.printf("-----test 2: Default option ");
        App().Pages().ProductDetailPage().selectOption();
        System.out.printf("test 2 done");

        System.out.printf("------test 2.1: Dropdown");
        Thread.sleep(1000);
        App().Pages().ProductDetailPage().clickDropdown();
        System.out.printf("test 2.1 done");

        System.out.printf("------test 2.2: Add to cart");
        App().Pages().ProductDetailPage().clickAddCart();
        System.out.printf("test 2.2 done");


    }

}
