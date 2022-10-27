package Tests.Catalog;

import Common_Page.AbstractBase_Test;
import Page_Lib.ReadData;
import org.testng.annotations.Test;

public class ProductDetail_Test extends AbstractBase_Test {
    ReadData data = new ReadData();

    @Test
    public void RunProductInfo() throws InterruptedException {
        App().Flow().navigateToUrl(data.getKey("url_ProductInfo"));

        App().Pages().ProductDetailPage().clickProduct();

//        App().Pages().ProductDetailPage().click();
        System.out.printf("-----test 1: Show  detail image" +"\n");

        App().Pages().ProductDetailPage().clickShowImg();
        System.out.printf("=> test 1 done"+"\n");
        Thread.sleep(2000);

        System.out.printf("-----test 2: Default option "+"\n");
        App().Pages().ProductDetailPage().skipAllow();

        App().Flow().printfCurrentPageUrl();
        App().Flow().getCurrentPageUrl();

        App().Pages().ProductDetailPage().selectOption();
        System.out.printf("=> test 2 done"+"\n");

        System.out.printf("------test 2.1: Dropdown"+"\n");
        Thread.sleep(1000);
        App().Pages().ProductDetailPage().clickDropdown();
        System.out.printf("=> test 2.1 done"+"\n");

        System.out.printf("------test 2.2: Add to cart"+"\n");
        App().Pages().ProductDetailPage().clickAddCart();
        System.out.printf("=>test 2.2 done"+"\n");


        System.out.printf("---------test 3: Quantity option for earring men" +"\n");

        App().Flow().openNewTab(data.getKey("url_ProductDetail"));
        App().Pages().ProductDetailPage().optionFreeSize();


        System.out.printf("=> test 3 done");

    }
    @Test
    public void RunProductRingSize(){
        App().Flow().navigateToUrl("https://dev3.glamira.com/glde/herrenohrringe/diamant/");

        App().Pages().ProductDetailPage().optionEarringMen();

    }
    @Test void RunDimensionGuide() throws InterruptedException {
        App().Flow().navigateToUrl(data.getKey("url_ProductDetail"));
        App().Pages().ProductDetailPage().optionDimensionGuide();
    }
    @Test void RunFindSize() throws InterruptedException {
        App().Flow().navigateToUrl(data.getKey("url_ProductDetail"));
        App().Pages().ProductDetailPage().optionFindSize();
    }
    @Test
    public void test(){
        App().Flow().navigateToUrl(data.getKey("url_ProductDetail"));

        App().Pages().ProductDetailPage().dropdown();
    }

}
