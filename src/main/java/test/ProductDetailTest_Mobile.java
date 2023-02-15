package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.CustomerServicePage;
import page.ProductDetailPage;
import page.ProductDetailPage_Mobile;

public class ProductDetailTest_Mobile extends BaseTest {
    private ProductDetailPage testProductDetail;
    private ProductDetailPage_Mobile testProductDetailMobile;

    public ProductDetailTest_Mobile() {
        super();
        testProductDetail = new ProductDetailPage(this.keyword);
        testProductDetailMobile = new ProductDetailPage_Mobile(this.keyword);
    }
    @Test(priority = 1, description = "Product Infomation")
    public void runProductInfo() throws InterruptedException {
        testProductDetail.productInfo();
    }
    @Test(priority = 2, description = "Check the details of the product displayed")
    public void testCase_DP_01() throws InterruptedException {
        testProductDetailMobile.showImgProduct();
    }
    @Test(priority = 3, description = "Check that the product details are displayed properly after changing the options")
    public void testCase_DP_02() throws InterruptedException {
        testProductDetailMobile.chooseDefaultOptionWithRing();

    }
    @Test(priority = 4, description = "Check the details of the necklace product displayed")
    public void testCase_DP_03() throws InterruptedException {
        testProductDetail.chooseDefaultOptionWithNecklace1();

    }
    @Test(priority = 5,description = "Check necklace product details displayed after change options")
    public void testCase_DP_04() throws InterruptedException {
        testProductDetailMobile.chooseDefaultOptionWithNecklace2();
    }
}
