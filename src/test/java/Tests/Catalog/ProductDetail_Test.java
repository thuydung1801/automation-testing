package Tests.Catalog;

import Common_Page.AbstractBase_Test;
import org.testng.annotations.Test;

public class ProductDetail_Test extends AbstractBase_Test {
    @Test
    public void RunProductInfo() throws InterruptedException {
        App().Flow().navigateToUrl("https://dev3.glamira.com/glde/diamantringe/diamant/");

        App().Pages().ProductDetailPage().clickProduct();

//        App().Pages().ProductDetailPage().click();
        System.out.printf("-----test 1: Show  detail image" +"\n");

        App().Pages().ProductDetailPage().clickShowImg();
        System.out.printf("test 1 done"+"\n");
        Thread.sleep(2000);

        System.out.printf("-----test 2: Default option "+"\n");
        App().Pages().ProductDetailPage().skipAllow();

        App().Flow().printfCurrentPageUrl();
        App().Flow().getCurrentPageUrl();

        App().Pages().ProductDetailPage().selectOption();
        System.out.printf("test 2 done"+"\n");

        System.out.printf("------test 2.1: Dropdown"+"\n");
        Thread.sleep(1000);
        App().Pages().ProductDetailPage().clickDropdown();
        System.out.printf("test 2.1 done"+"\n");

        System.out.printf("------test 2.2: Add to cart"+"\n");
        App().Pages().ProductDetailPage().clickAddCart();
        System.out.printf("test 2.2 done"+"\n");


        System.out.printf("---------test 3: Quantity option for earring men" +"\n");
        App().Flow().openNewTab("https://dev3.glamira.com/glde/herrenohrringe/diamant/");


        System.out.printf("test 3 done");

    }
    @Test
    public void RunProductRingSize(){
        App().Flow().navigateToUrl("https://dev3.glamira.com/glde/herrenohrringe/diamant/");

        App().Pages().ProductDetailPage().optionEarringMen();
//        App().Pages().ProductDetailPage().skipAllow();

    }
    @Test void RunDemo1(){
        App().Flow().navigateToUrl("https://dev3.glamira.com/glde/glamira-ring-mutia.html?alloy=yellow_white-750&stone1=diamond-Brillant&stone2=diamond-Brillant");
        App().Pages().ProductDetailPage().optionFreeSize();


//        App().Pages().ProductDetailPage().skipAllow();
    }
    @Test void RunDemo2(){
        App().Flow().getCurrentPageUrl();
        App().Pages().ProductDetailPage().optionFindSize();
    }

}
