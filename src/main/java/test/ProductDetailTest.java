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
        testProductDetail.productInfo();
    }
    @Test(priority = 2)
    public void RunCase_PRD_1() throws InterruptedException {
        testProductDetail.testCase_PRD_Info1();

    }
    @Test(priority = 3)
    public void RunCase_PRD_2() throws InterruptedException {
        testProductDetail.testCase_PRD_Info2();

    }
    @Test(priority = 4)
    public void RunCase_PRD_3() throws InterruptedException {
        testProductDetail.testCase_PRD_Info3();

    }
    @Test(priority = 5)
    public void RunDimensionGuide() throws InterruptedException {
        testProductDetail.optionDimensionGuide();
    }

    @Test (priority = 6)
    public void RunFindSize() throws InterruptedException {
        testProductDetail.optionFindSize();
    }

}
