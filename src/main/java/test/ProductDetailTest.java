package test;

import core.BaseTest;
import org.testng.annotations.Parameters;
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
    @Test(priority = 4, description = "Check the details of the necklace product displayed")
    public void testCase_DP_03() throws InterruptedException {
        testProductDetail.chooseDefaultOptionWithNecklace1();

    }
    @Test(priority = 5,description = "Check necklace product details displayed after change options")
    public void testCase_DP_04() throws InterruptedException {
        testProductDetail.chooseDefaultOptionWithNecklace2();
    }
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
    @Test (priority = 12,description = "Add to cart a single Ring item - selected ring size")
    public void testCase_RS_01() throws InterruptedException {
        testProductDetail.ringSize1();
    }
    @Test (priority = 13,description = "Add to cart a single Ring item - don't choose ring size")
    public void testCase_RS_02() throws InterruptedException {
        testProductDetail.ringSize2();
    }
    @Test (priority = 14,description = "Add to cart a Ring item- Send My Ring in Average Size")
    public void testCase_RS_03() throws InterruptedException {
        testProductDetail.ringSize3();
    }

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
    @Test (priority = 27, description = "Check stone quality for stone that are not layer image")
    @Parameters("baseURL")
    public void testCase_NPP_12(String baseURL) throws InterruptedException {
        testProductDetail.newNPP12(baseURL);
    }
    @Test (priority = 28, description = "Check stone quality for stone that are layer image")
    @Parameters("baseURL")
    public void testCase_NPP_13(String baseURL) throws InterruptedException {
        testProductDetail.newNPP13(baseURL);
    }
    @Test (priority = 29, description = "Check chain option of product necklaces")
    @Parameters("baseURL")
    public void testCase_NPP_14(String baseURL) throws InterruptedException {
        testProductDetail.newNPP14(baseURL);
    }
    @Test (priority = 30, description = "Submit form Bracelet with account not login successfully")
    @Parameters("baseURL")
    public void testCase_NPP_15(String baseURL) throws InterruptedException {
        testProductDetail.newNPP15(baseURL);
    }
    @Test (priority = 31, description = "Submit form Bracelet sucessfully with register account")
    @Parameters("baseURL")
    public void testCase_NPP_16(String baseURL) throws InterruptedException {
        testProductDetail.newNPP16(baseURL);
    }
    @Test (priority = 32, description = "Submit form Bracelet sucessfully with account login")
    @Parameters("baseURL")
    public void testCase_NPP_18_17(String baseURL) throws InterruptedException {
        testProductDetail.newNPP18_NPP17(baseURL);
    }
    @Test (priority = 33, description = "Order a ringsizer with account not login successfully")
    @Parameters("baseURL")
    public void testCase_NPP_19(String baseURL) throws InterruptedException {
        testProductDetail.newNPP19(baseURL);
    }
    @Test (priority = 34, description = "Order a ringsizer sucessfully with register account")
    @Parameters("baseURL")
    public void testCase_NPP_20(String baseURL) throws InterruptedException {
        testProductDetail.newNPP20(baseURL);
    }
    @Test (priority = 35, description = "Order a ringsizer sucessfully with account login")
    @Parameters("baseURL")
    public void testCase_NPP_22_21(String baseURL) throws InterruptedException {
        testProductDetail.newNPP22_NPP21(baseURL);
    }
    @Test (priority = 36, description = "Check Metal select logic")
    @Parameters("baseURL")
    public void testCase_NPP_25(String baseURL) throws InterruptedException {
        testProductDetail.newNPP25(baseURL);
    }
    @Test (priority = 37, description = "Check show Lab Created Stones tab ")
    @Parameters("baseURL")
    public void testCase_NPP_29(String baseURL) throws InterruptedException {
        testProductDetail.newNPP29(baseURL);
    }
    @Test (priority = 38, description = "Check Lab stone option in product page")
    @Parameters("baseURL")
    public void testCase_NPP_26_27_28(String baseURL) throws InterruptedException {
        testProductDetail.newNPP26_27(baseURL);
    }
    @Test (priority = 39, description = "Check Dimension Guide section ")
    @Parameters("baseURL")
    public void testCase_NPP_30(String baseURL) throws InterruptedException {
        testProductDetail.newNPP30(baseURL);
    }
    @Test (priority = 40, description = "Check show Dimension Guide section ")
    @Parameters("baseURL")
    public void testCase_NPP_31(String baseURL) throws InterruptedException {
        testProductDetail.newNPP31(baseURL);
    }
    @Test (priority = 41, description = "Check show Dimension Guide section ")
    @Parameters("baseURL")
    public void testCase_NPP_32(String baseURL) throws InterruptedException {
        testProductDetail.newNPP32(baseURL);
    }
    @Test (priority = 42, description = "Check Upload Your Photo in product page")
    @Parameters("baseURL")
    public void testCase_NPP_33_36(String baseURL) throws InterruptedException {
        testProductDetail.newNPP33_36(baseURL);
    }
    @Test (priority = 43, description = "Check Upload Your Photo in product page")
    @Parameters("baseURL")
    public void testCase_NPP_34(String baseURL) throws InterruptedException {
        testProductDetail.newNPP34(baseURL);
    }
    @Test (priority = 44, description = "Check Upload Your Photo in product page - Delete images")
    @Parameters("baseURL")
    public void testCase_NPP_35(String baseURL) throws InterruptedException {
        testProductDetail.newNPP35(baseURL);
    }
    @Test (priority = 45, description = "Check Upload Your Photo in product page-Required field")
    @Parameters("baseURL")
    public void testCase_NPP_37(String baseURL) throws InterruptedException {
        testProductDetail.newNPP37(baseURL);
    }
    @Test (priority = 46, description = "Check show More Details section")
    @Parameters("baseURL")
    public void testCase_NPP_38_39(String baseURL) throws InterruptedException {
        testProductDetail.newNPP38_39(baseURL);
    }
    @Test (priority = 47, description = "Check item show under Add to Cart button only for product wedding ring")
    @Parameters("baseURL")
    public void testCase_NPP_41(String baseURL) throws InterruptedException {
        testProductDetail.newNPP41_50();
    }
    @Test (priority = 48, description = "Check width information beside product name")
    @Parameters("baseURL")
    public void testCase_NPP_43(String baseURL) throws InterruptedException {
        testProductDetail.newNPP43(baseURL);
    }
    @Test (priority = 49, description = "Check show width information beside product name")
    @Parameters("baseURL")
    public void testCase_NPP_44(String baseURL) throws InterruptedException {
        testProductDetail.newNPP44(baseURL);
    }
    @Test (priority = 50, description = "Check Carat information beside product name")
    @Parameters("baseURL")
    public void testCase_NPP_45(String baseURL) throws InterruptedException {
        testProductDetail.newNPP45(baseURL);
    }

    @Test (priority = 51, description = "Check item show under Add to Cart button only for others product")
    @Parameters("baseURL")
    public void testCase_NPP_42(String baseURL) throws InterruptedException {
        testProductDetail.newNPP42(baseURL);
    }
    @Test (priority = 52, description = "Check show Carats information beside product name")
    @Parameters("baseURL")
    public void testCase_NPP_46(String baseURL) throws InterruptedException {
        testProductDetail.newNPP46(baseURL);
    }




//  Check price product

//    @Test (priority = 29, description = "Check stone quality for stone that are layer image")
//    @Parameters("baseURL")
//    public void testCase_PP_01(String baseURL) throws InterruptedException {
//        testProductDetail.pricePP01(baseURL);
//    }
//    @Test (priority = 29, description = "Check stone quality for stone that are layer image")
//    @Parameters("baseURL")
//    public void testCase_PP_02(String baseURL) throws InterruptedException {
//        testProductDetail.pricePP02(baseURL);
//    }
//    @Test (priority = 29, description = "Check stone quality for stone that are layer image")
//    @Parameters("baseURL")
//    public void testCase_PP_03(String baseURL) throws InterruptedException {
//        testProductDetail.pricePP03(baseURL);
//    }

}
