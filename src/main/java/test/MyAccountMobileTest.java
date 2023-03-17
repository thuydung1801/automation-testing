package test;

import core.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.MyAccountMobilePage;
import page.MyAccountPage;

public class MyAccountMobileTest extends BaseTest {
    private MyAccountPage testMyAccount;
    private MyAccountMobilePage testMyAccountMobile;

    public MyAccountMobileTest() {
        super();
        testMyAccount = new MyAccountPage(this.keyword);
        testMyAccountMobile = new MyAccountMobilePage(this.keyword);
    }


    public void setUpLogin(String baseURL) throws InterruptedException {
        testMyAccountMobile.setUp(baseURL);
    }

    @Test(priority = 1, description = "Change PERSONAL INFORMATION ")
    @Parameters("baseURL")
    public void testCase_PI_01(String baseURL) throws InterruptedException {
        setUpLogin(baseURL);
        testMyAccountMobile.changeFullnameWithData();
    }

    //
    @Test(priority = 2, description = "Change PERSONAL INFORMATION : forgot enter value First/last name  ")
    public void testCase_PI_02() throws InterruptedException {
        testMyAccountMobile.changeFullNameWithDataNUll();
    }

    @Test(priority = 3, description = "Change email ")
    public void testCase_PI_03() throws InterruptedException {
        testMyAccountMobile.changeEmail();
    }

    @Test(priority = 4, description = "CHANGE PASSWORD")
    @Parameters("baseURL")
    public void testCase_PI_04_LO_01(String baseURL) throws InterruptedException {
        testMyAccountMobile.changePassword(baseURL);
    }

    @Test(priority = 5, description = "DELETE ACCOUNT")
    @Parameters("baseURL")
    public void testCase_PI_06( String baseURL) throws InterruptedException {
        testMyAccount.deleteAccount("COM_PASSWORD_NEW_MOBILE",baseURL);
    }
//
//        -----------------------------
    @Test(priority = 6, description = "Edit BILLING ADDRESS")
    public void testCase_MA_01() throws InterruptedException {
        testMyAccountMobile.editBillingAddress();
    }

    @Test(priority = 7, description = "Edit SHIPPING ADDRESS")
    public void testCase_MA_02() throws InterruptedException {
        testMyAccountMobile.editShippingAddress();
    }

    @Test(priority = 8, description = "ADD NEW ADDRESS")
    public void testCase_MA_09() throws InterruptedException {
        testMyAccountMobile.addNewAddress();
    }

    @Test(priority = 9, description = "Edit a address in section Additional Address Entries")
    public void testCase_MA_03() throws InterruptedException {
        testMyAccountMobile.editAdditionalAddressEntries();
    }

    @Test(priority = 10, description = " Delete a address in section Additional Address Entries")
    @Parameters("baseURL")
    public void testCase_MA_04(String baseURL) throws InterruptedException {
        testMyAccountMobile.deleteAdditionalAddressEntries(baseURL);
    }
    @Test(priority = 11, description = "  Set as Default a address in section Additional Address Entries")
    public void testCase_MA_05() throws InterruptedException {
        testMyAccount.setAsDefaultAddress();
    }

    @Test(priority = 12, description = "Set Default Billing Address when edit address")
    public void testCase_MA_06() throws InterruptedException {
        testMyAccountMobile.editSetDefaultBilling();
    }

    //
    @Test(priority = 13, description = "Add New Address")
    public void testCase_MA_08() throws InterruptedException {
        testMyAccountMobile.addNewAddress();
    }

    @Test(priority = 14, description = "Save a item form product view")
    @Parameters("baseURL")
    public void testCase_MW_01(String baseURL) throws InterruptedException {
        testMyAccount.saveItemFormProductView(baseURL);
    }

    @Test(priority = 15, description = "Save a item form product list")
    public void testCase_MW_02() throws InterruptedException {
        testMyAccount.saveItemFormProductList();
    }

    @Test(priority = 16, description = "Compare My Wishlist - product_compare")
    public void testCase_MW_03() throws InterruptedException {
        testMyAccountMobile.compareMyWishProductMobile();
    }

    @Test(priority = 17, description = "Remove a item saved ")
    public void testCase_MW_04() throws InterruptedException {
        testMyAccount.removeItemSave("MAC_LINK_HEART_MOBILE");
    }

    @Test(priority = 18, description = "Check function of Email Selected Items")
    public void testCase_MW_05() throws InterruptedException {
        testMyAccount.emailSelectItem("MAC_LINK_HEART_MOBILE");
        keyword.resizeBrowser(319, 848);
    }
    //   case My Order
    @Test(priority = 19, description = "Check function icon  view order of completed order")
    @Parameters("baseURL")
    public void testCase_Myorder_01(String baseURL) throws InterruptedException {
        testMyAccountMobile.viewOrderComplete(baseURL);
    }

    @Test(priority = 20, description = "Check function icon view order of Recent  orders")
    public void testCase_Myorder_02() throws InterruptedException {
        testMyAccountMobile.viewOrderRecent();
    }
    @Test(priority = 21, description = "Check function of button Upload More")
    public void testCase_Myorder_04() throws InterruptedException {
        testMyAccount.upLoadItemOrder();
        keyword.resizeBrowser(319, 848);
    }
    @Test(priority = 22, description = "Check function icon return  of completed order")
    public void testCase_Myorder_03() throws InterruptedException {
        testMyAccount.viewReturn();
    }
     // case My Overview
    @Test(priority = 23, description = "Check order status = Order Confirmation ,display in tab Recent Orders ")
    @Parameters("baseURL")
    public void testCase_MO_03(String baseURL) throws InterruptedException {
        testMyAccountMobile.checkStatusConfirmation(baseURL);
    }

    @Test(priority = 24, description = "Check order status = Delivery, display in tab Recent Orders ")
    public void testCase_MO_05() throws InterruptedException {
        testMyAccountMobile.checkStatusDelivery();
    }

    @Test(priority = 25, description = "Check -Change Password- function in contact information ")
    public void testCase_MO_06() throws InterruptedException {
        testMyAccount.checkChangePassword();
    }

    @Test(priority = 26, description = "Check -Contact Information- edit function")
    public void testCase_MO_07() throws InterruptedException {
        testMyAccount.checkContactInfo();
    }

    @Test(priority = 27, description = "Check -Shipping Address- edit function")
    public void testCase_MO_08() throws InterruptedException {
        testMyAccount.checkChangeShippingAddress();
    }

    @Test(priority = 28, description = "Check -Billing Address- edit function ")
    public void testCase_MO_09() throws InterruptedException {
        testMyAccount.checkChangeBillingAddress();
    }

    @Test(priority = 29, description = "Check -Newsletters- edit function")
    public void testCase_MO_10() throws InterruptedException {
        testMyAccount.checkChangeNewsLetter();
    }
}
