package test;

import core.BaseTest;
import core.KeywordWeb;
import org.testng.annotations.Test;
import page.MyAccountPage;

public class MyAccountTest extends BaseTest {
    private MyAccountPage testMyAccount;
    public MyAccountTest() {
        super();
        testMyAccount = new MyAccountPage(this.keyword);
    }
//    @Test(priority = 1,description = "Change PERSONAL INFORMATION ")
//    public void testCase_PI_01() throws InterruptedException {
//        testMyAccount.changeFullnameWithData();
//    }
//    @Test(priority = 2,description = "Change PERSONAL INFORMATION : forgot enter value First/last name  ")
//    public void testCase_PI_02() throws InterruptedException {
//        testMyAccount.changeFullnameWithDataNUll();
//    }
//    @Test(priority = 3,description = "Change email ")
//    public void testCase_PI_03() throws InterruptedException {
//        testMyAccount.changeEmail();
//    }
//    @Test(priority = 4,description = "CHANGE PASSWORD")
//    public void testCase_PI_04() throws InterruptedException {
//        testMyAccount.changePassword();
//    }
//    @Test(priority = 5,description = "Edit BILLING ADDRESS")
//    public void testCase_MA_01() throws InterruptedException {
//        testMyAccount.editBillingAddress();
//    }
//    @Test(priority = 6,description = "Edit SHIPPING ADDRESS")
//    public void testCase_MA_02() throws InterruptedException {
//        testMyAccount.editShippingAddress();
//    }
//    @Test(priority = 7,description = "ADD NEW ADDRESS")
//    public void testCase_MA_09() throws InterruptedException {
//        testMyAccount.addNewAddress();
//    }
    @Test(priority = 8,description = "Edit a address in section Additional Address Entries")
    public void testCase_MA_03() throws InterruptedException {
        testMyAccount.editAdditionalAddressEntries();
    }
    @Test(priority = 9,description = "Edit a address in section Additional Address Entries")
    public void testCase_MA_04() throws InterruptedException {
        testMyAccount.deleteAdditionalAddressEntries();
    }




}
