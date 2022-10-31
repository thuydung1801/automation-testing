package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.ProductDetailPage;

import java.util.Properties;

public class ProductDetailTest extends BaseTest {
    private ProductDetailPage testProductDetail;

    public ProductDetailTest() {
        super();
        testProductDetail = new ProductDetailPage(this.keyword);

    }
    @Test(priority = 1)
    public void RunProductInfo() throws InterruptedException {
//        testProductDetail.submitCookie();
        testProductDetail.productInfo();

    }
    @Test(priority = 2)
    public void RunDimensionGuide() throws InterruptedException {
        testProductDetail.optionDimensionGuide();
    }

    @Test (priority = 3)
    public void RunFindSize() throws InterruptedException {
        testProductDetail.optionFindSize();
    }
}
