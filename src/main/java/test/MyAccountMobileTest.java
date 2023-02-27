package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.MyAccountMobilePage;
import page.MyAccountPage;
import page.home.RegisterPage;

public class MyAccountMobileTest extends BaseTest {
    private RegisterPage objRegister;
    private MyAccountMobilePage testMyAccountMobile;

    public MyAccountMobileTest() {
        super();
        testMyAccountMobile = new MyAccountMobilePage(this.keyword);
    }

    @Test(priority = 1, description = "Change PERSONAL INFORMATION ")
    public void testCase_PI_01() throws InterruptedException {
        objRegister = new RegisterPage();
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/");
        objRegister.acceptAllCookies();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        testMyAccountMobile.changeFullnameWithData();
    }

    @Test(priority = 2, description = "Change PERSONAL INFORMATION : forgot enter value First/last name  ")
    public void testCase_PI_02() throws InterruptedException {
        testMyAccountMobile.changeFullnameWithDataNUll();
    }

    @Test(priority = 3, description = "Change email ")
    public void testCase_PI_03() throws InterruptedException {
        testMyAccountMobile.changeEmail();
    }

    @Test(priority = 4, description = "CHANGE PASSWORD")
    public void testCase_PI_04_LO_01() throws InterruptedException {
        testMyAccountMobile.changePassword();
    }
    @Test(priority = 4,description = "DELETE ACCOUNT")
    public void testCase_PI_06() throws InterruptedException {
        testMyAccountMobile.deleteAccount();
    }
////    My Addresses
    @Test(priority = 5,description = "Edit BILLING ADDRESS")
    public void testCase_MA_01() throws InterruptedException {
        testMyAccountMobile.editBillingAddress();
    }
    @Test(priority = 6,description = "Edit SHIPPING ADDRESS")
    public void testCase_MA_02() throws InterruptedException {
        testMyAccountMobile.editShippingAddress();
    }
    @Test(priority = 7,description = "ADD NEW ADDRESS")
    public void testCase_MA_09() throws InterruptedException {
        testMyAccountMobile.addNewAddress();
    }
    @Test(priority = 8,description = "Edit a address in section Additional Address Entries")
    public void testCase_MA_03() throws InterruptedException {
        testMyAccountMobile.editAdditionalAddressEntries();
    }
    @Test(priority = 9,description = " Delete a address in section Additional Address Entries")
    public void testCase_MA_04() throws InterruptedException {
        testMyAccountMobile.deleteAdditionalAddressEntries();
    }
    @Test(priority = 10,description = "  Set as Default a address in section Additional Address Entries")
    public void testCase_MA_05() throws InterruptedException {
        testMyAccountMobile.setAsDefaultAddress();
    }
    @Test(priority = 11,description = "Set Default Billing Address when edit address")
    public void testCase_MA_06() throws InterruptedException {
        testMyAccountMobile.editSetDefaultBilling();
    }
    @Test(priority = 12,description = "Set  DEFAULT SHIPPING ADDRESS when edit address")
    public void testCase_MA_07() throws InterruptedException {
        testMyAccountMobile.editSetDefaultShipping();
    }
    @Test(priority = 13,description = "Add New Address")
    public void testCase_MA_08() throws InterruptedException {
        testMyAccountMobile.addNewAddress();
    }

    //------------------------------My Wishlist
    @Test(priority = 14, description = "Save a item form product view")
    public void testCase_MW_01() throws InterruptedException {
        testMyAccountMobile.saveItemFormProductView();
    }

    @Test(priority = 15, description = "Save a item form product list")
    public void testCase_MW_02() throws InterruptedException {
        testMyAccountMobile.saveItemFormProductList();
    }

    @Test(priority = 16, description = "Compare My Wishlist - product_compare")
    public void testCase_MW_03() throws InterruptedException {
        testMyAccountMobile.compareMyWishProduct();
    }

    @Test(priority = 17, description = "Remove a item saved ")
    public void testCase_MW_04() throws InterruptedException {
        testMyAccountMobile.removeItemSave();
    }

    @Test(priority = 18, description = "Check function of Email Selected Items")
    public void testCase_MW_05() throws InterruptedException {
        testMyAccountMobile.emailSelectItem();
    }
    //   case My Order
//    @Test(priority = 19,description = "Check function icon  view order of completed order")
//    public void testCase_Myorder_01() throws InterruptedException {
//        objRegister = new RegisterPage();
//        keyword.untilJqueryIsDone(50L);
//        objRegister.acceptAllCookies();
//        testMyAccountMobile.viewOrderComplete();
//    }
//    @Test(priority = 20,description = "Check function icon view order of Recent  orders")
//    public void testCase_Myorder_02() throws InterruptedException {
//        testMyAccountMobile.viewOrderRecent();
//    }
//    @Test(priority = 21,description = "Check function icon view order of Recent  orders")
//    public void testCase_Myorder_04() throws InterruptedException {
//        testMyAccountMobile.upLoadItemOrder();
//    }
//    @Test(priority = 22,description = "Check function icon return  of completed order")
//    public void testCase_Myorder_03() throws InterruptedException {
//        testMyAccountMobile.viewReturn();
//    }
////    @Test(priority = 22,description = "Check  return  of completed order")
//    public void testCase_Myorder_05() throws InterruptedException {
//        testMyAccountMobile.stepReturn();
//    }
//
////
//    // case My Overview
    @Test(priority = 21,description = "Check order status = Order Confirmation ,display in tab Recent Orders ")
    public void testCase_MO_03() throws InterruptedException {
        testMyAccountMobile.checkStatusConfirmation();
    }
    @Test(priority = 22,description = "Check order status = Delivery, display in tab Recent Orders ")
    public void testCase_MO_05() throws InterruptedException {
        testMyAccountMobile.checkStatusDelivery();
    }
    @Test(priority = 23,description = "Check -Change Password- function in contact information ")
    public void testCase_MO_06() throws InterruptedException {
        testMyAccountMobile.checkChangePassword();
    }
    @Test(priority = 24,description = "Check -Contact Information- edit function")
    public void testCase_MO_07() throws InterruptedException {
        testMyAccountMobile.checkContactInfo();
    }
    @Test(priority = 25,description = "Check -Shipping Address- edit function")
    public void testCase_MO_08() throws InterruptedException {
        testMyAccountMobile.checkChangeShippingAddress();
    }
    @Test(priority = 26,description = "Check -Billing Address- edit function ")
    public void testCase_MO_09() throws InterruptedException {
        testMyAccountMobile.checkChangeBillingAddress();
    }
    @Test(priority = 27,description = "Check -Newsletters- edit function")
    public void testCase_MO_10() throws InterruptedException {
        testMyAccountMobile.checkChangeNewsLetter();
    }
}
