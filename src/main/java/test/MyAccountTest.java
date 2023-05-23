package test;

import core.BaseTest;
import core.KeywordWeb;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.MyAccountPage;

public class MyAccountTest extends BaseTest {
    private MyAccountPage testMyAccount;
    public MyAccountTest() {
        super();
        testMyAccount = new MyAccountPage(this.keyword);
    }
    @Test(priority = 1,description = "Change PERSONAL INFORMATION ")
    public void testCase_PI_01() throws InterruptedException {
        testMyAccount.changeFullnameWithData();
    }
    @Test(priority = 2,description = "Change PERSONAL INFORMATION : forgot enter value First/last name  ")
    public void testCase_PI_02() throws InterruptedException {
        testMyAccount.changeFullnameWithDataNUll();
    }
    @Test(priority = 3,description = "Change email ")
    public void testCase_PI_03() throws InterruptedException {
        testMyAccount.changeEmail();
    }
    @Test(priority = 4,description = "CHANGE PASSWORD")
    public void testCase_PI_04_LO_01() throws InterruptedException {
        testMyAccount.changePassword();
    }
    @Test(priority = 4,description = "DELETE ACCOUNT")
    @Parameters("baseURL")
    public void testCase_PI_06(String baseURL) throws InterruptedException {
        testMyAccount.deleteAccount("COM_INP_DATA_PASS_STAGE",baseURL);
    }
    @Test(priority = 5,description = "Edit BILLING ADDRESS")
    public void testCase_MA_01() throws InterruptedException {
        testMyAccount.editBillingAddress();
    }
    @Test(priority = 6,description = "Edit SHIPPING ADDRESS")
    public void testCase_MA_02() throws InterruptedException {
        testMyAccount.editShippingAddress();
    }
    @Test(priority = 7,description = "ADD NEW ADDRESS- When customer account there are no any  addresses yet")
    public void testCase_MA_09() throws InterruptedException {
        testMyAccount.addNewAddress();
    }
    @Test(priority = 8,description = "Edit a address in section Additional Address Entries")
    public void testCase_MA_03() throws InterruptedException {
        testMyAccount.editAdditionalAddressEntries();
    }
    @Test(priority = 9,description = " Delete a address in section Additional Address Entries")
    public void testCase_MA_04() throws InterruptedException {
        testMyAccount.deleteAdditionalAddressEntries();
    }
    @Test(priority = 10,description = "  Set as Default a address in section Additional Address Entries")
    public void testCase_MA_05() throws InterruptedException {
        testMyAccount.setAsDefaultAddress();
    }
    @Test(priority = 11,description = "Set Default Billing Address when edit address")
    public void testCase_MA_06() throws InterruptedException {
        testMyAccount.editSetDefaultBilling();
    }
    @Test(priority = 12,description = "Set  DEFAULT SHIPPING ADDRESS when edit address")
    public void testCase_MA_07() throws InterruptedException {
        testMyAccount.editSetDefaultShipping();
    }
    @Test(priority = 13,description = "Add New Address")
    public void testCase_MA_08() throws InterruptedException {
        testMyAccount.addNewAddress();
    }
    @Test(priority = 14,description = "Save a item form product view")
    @Parameters("baseURL")
    public void testCase_MW_01(String baseURL) throws InterruptedException {
        testMyAccount.saveItemFormProductView(baseURL);
    }
    @Test(priority = 15,description = "Save a item form product list")
    public void testCase_MW_02() throws InterruptedException {
        testMyAccount.saveItemFormProductList();
    }
    @Test(priority = 16,description = "Compare My Wishlist - product_compare")
    public void testCase_MW_03() throws InterruptedException {
        testMyAccount.compareMyWishProduct("MAC_LINK_HEART");
    }
    @Test(priority = 17,description = "Remove a item saved ")
    public void testCase_MW_04() throws InterruptedException {
        testMyAccount.removeItemSave("MAC_LINK_HEART");
    }
    @Test(priority = 18,description = "Check function of Email Selected Items")
    public void testCase_MW_05() throws InterruptedException {
        testMyAccount.emailSelectItem("MAC_LINK_HEART");
    }

//       case My Order
    @Test(priority = 19,description = "Check function icon  view order of completed order")
    public void testCase_Myorder_01() throws InterruptedException {
        testMyAccount.viewOrderComplete();
    }
    @Test(priority = 20,description = "Check function icon view order of Recent  orders")
    public void testCase_Myorder_02() throws InterruptedException {
        testMyAccount.viewOrderRecent();
    }

    @Test(priority = 21,description = "Check function icon view order of Recent  orders")

    public void testCase_Myorder_04() throws InterruptedException {
        testMyAccount.upLoadItemOrder();
    }
//    @Test(priority = 22,description = "Check function icon return  of completed order")
//    public void testCase_Myorder_03() throws InterruptedException {
//        testMyAccount.viewReturn();
//    }

//    @Test(priority = 22,description = "Check  return  of completed order")
//    public void testCase_Myorder_05() throws InterruptedException {
//        testMyAccount.stepReturn();
//    }
    // case My Overview
    @Test(priority = 23,description = "Check order status = Order Confirmation ,display in tab Recent Orders ")
    public void testCase_MO_03() throws InterruptedException {
        testMyAccount.checkStatusConfirmation();
    }
    @Test(priority = 24,description = "Check order status = Delivery, display in tab Recent Orders ")
    public void testCase_MO_05() throws InterruptedException {
        testMyAccount.checkStatusDelivery();
    }
    @Test(priority = 25,description = "Check -Change Password- function in contact information ")
    public void testCase_MO_06() throws InterruptedException {
        testMyAccount.checkChangePassword();
    }
    @Test(priority = 26,description = "Check -Contact Information- edit function")
    public void testCase_MO_07() throws InterruptedException {
        testMyAccount.checkContactInfo();
    }
    @Test(priority = 27,description = "Check -Shipping Address- edit function")
    public void testCase_MO_08() throws InterruptedException {
        testMyAccount.checkChangeShippingAddress();
    }
    @Test(priority = 28,description = "Check -Billing Address- edit function ")
    public void testCase_MO_09() throws InterruptedException {
        testMyAccount.checkChangeBillingAddress();
    }
    @Test(priority = 29,description = "Check -Newsletters- edit function")
    public void testCase_MO_10() throws InterruptedException {
        testMyAccount.checkChangeNewsLetter();
    }
}
