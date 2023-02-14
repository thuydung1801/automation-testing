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
    @Test(priority = 2, description = "Check the details of the product displayed")
    public void testCase_DP_01() throws InterruptedException {
        testProductDetail.showImgProduct();
    }
    @Test(priority = 3, description = "Check that the product details are displayed properly after changing the options")
    public void testCase_DP_02() throws InterruptedException {
        testProductDetail.chooseDefaultOptionWithRing();

    }
//    @Test(priority = 4, description = "Check the details of the necklace product displayed")
//    public void testCase_DP_03() throws InterruptedException {
//        testProductDetail.chooseDefaultOptionWithNecklace1();
//
//    }
//    @Test(priority = 5,description = "Check necklace product details displayed after change options")
//    public void testCase_DP_04() throws InterruptedException {
//        testProductDetail.chooseDefaultOptionWithNecklace2();
//    }
    @Test(priority = 6, description = "Engraving - Enter with text entered from the keyboard")
    public void testCase_PO_01() throws InterruptedException {
        testProductDetail.productOptionEngraving1();

    }
    @Test(priority = 7,description = "Engraving - Enter with text that is copied and pasted")
    public void testCase_PO_02() throws InterruptedException {
        testProductDetail.productOptionEngraving2();
    }

    @Test(priority = 8, description = "Engraving - Enter with allowed characters (characters on the computer keyboard) " +
            "when typing from the keyboard")
    public void testCase_PO_03() throws InterruptedException {
        testProductDetail.productOptionEngraving3();

    }
    @Test(priority = 9,description = "Engraving - Enter with allowed characters (character keyboard characters) " +
            "when copying and pasting")
    public void testCase_PO_04() throws InterruptedException {
        testProductDetail.productOptionEngraving4();
    }

    @Test (priority = 10,description = "Check the link to the ring-size-guide page from product view ")
    public void testCase_DG_01() throws InterruptedException {
        testProductDetail.optionDimensionGuide();
    }
   // @Test (priority = 11,description = "- Click in REQUEST A FREE RING SIZER to enable poup")
    public void testCase_DG_03() throws InterruptedException {
        testProductDetail.optionFindSizeWithInpSuccess();
    }
//    @Test (priority = 12,description = "Add to cart a single Ring item - selected ring size")
//    public void testCase_RS_01() throws InterruptedException {
//        testProductDetail.ringSize1();
//    }
//    @Test (priority = 13,description = "Add to cart a single Ring item - don't choose ring size")
//    public void testCase_RS_02() throws InterruptedException {
//        testProductDetail.ringSize2();
//    }
//    @Test (priority = 14,description = "Add to cart a Ring item- Send My Ring in Average Size")
//    public void testCase_RS_03() throws InterruptedException {
//        testProductDetail.ringSize3();
//    }

  //  @Test (priority = 16,description = "ORDER A FREE RING SIZER - do not enter a value")
    public void testCase_RS_form_02() throws InterruptedException {
        testProductDetail.optionFindSizeWithInpNull();
    }
 //   @Test (priority = 17, description = "ORDER A FREE RING SIZER - enter wrong email format")
    public void testCase_RS_form_03() throws InterruptedException {
        testProductDetail.optionFindSizeWithInpEmailError();
    }
  //  @Test (priority = 18, description = "ORDER A FREE RING SIZER - enter correct values")
    public void testCase_RS_form_01() throws InterruptedException {
        testProductDetail.optionFindSizeWithInpSuccess();
    }

     //NEW DESIGN - Product Page
    @Test (priority = 19, description = "Edit length with product having length is options successfully")
    public void testCase_NPP_01() throws InterruptedException {
        testProductDetail.newNPP01();
    }
    @Test (priority = 20, description = "Edit length with product having length is product related successfully")
    public void testCase_NPP_02() throws InterruptedException {
        testProductDetail.newNPP02();
    }
    @Test (priority = 21, description = "Edit length with product having length is product related and still select old option on modal")
    public void testCase_NPP_03() throws InterruptedException {
        testProductDetail.newNPP03();
    }
    @Test (priority = 22, description = "Edit length with product having length is product related and Cancel")
    public void testCase_NPP_04() throws InterruptedException {
        testProductDetail.newNPP04();
    }
    @Test (priority = 23, description = "Edit stone size carat with product having carat is product related successfully")
    public void testCase_NPP_05() throws InterruptedException {
        testProductDetail.newNPP05();
    }
    @Test (priority = 24, description = "Edit set option for product wedding set successfully")
    public void testCase_NPP_06() throws InterruptedException {
        testProductDetail.newNPP06();
    }
    @Test (priority = 25, description = "Edit set option for product wedding set and then select another product on modal")
    public void testCase_NPP_07() throws InterruptedException {
        testProductDetail.newNPP07();
    }
    @Test (priority = 26, description = "Edit set option for product wedding set and then still select old option on modal")
    public void testCase_NPP_08() throws InterruptedException {
        testProductDetail.newNPP08();
    }

}
