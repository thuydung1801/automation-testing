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
    @Test(priority = 1, description = "Product Infomation")
    public void runProductInfo() throws InterruptedException {
        testProductDetail.productInfo();
    }
    @Test(priority = 2, description = "Show image product")
    public void testCase_DP_01() throws InterruptedException {
        testProductDetail.showImgProduct();
    }
    @Test(priority = 3, description = "Default option product")
    public void testCase_DP_02() throws InterruptedException {
        testProductDetail.chooseDefaultOption();

    }
    @Test(priority = 4, description = "Choose option Freesize")
    public void testCase_DG_02() throws InterruptedException {
        testProductDetail.chooseOptionFreeSize();

    }
    @Test(priority = 5,description = "Choose option DimionGuide")
    public void testCase_DG_01() throws InterruptedException {
        testProductDetail.optionDimensionGuide();
    }

    @Test (priority = 6,description = "Choose option Findsize_exception 1")
    public void testCase_RS_form_02() throws InterruptedException {
        testProductDetail.optionFindSizeWithInpNull();
    }
    @Test (priority = 7, description = "Choose option Findsize_exception 2")
    public void testCase_RS_form_03() throws InterruptedException {
        testProductDetail.optionFindSizeWithInpEmailError();
    }
    @Test (priority = 8, description = "Choose option Findsize_exception 3")
    public void testCase_RS_form_01() throws InterruptedException {
        testProductDetail.optionFindSizeWithInpSuccess();
    }

}