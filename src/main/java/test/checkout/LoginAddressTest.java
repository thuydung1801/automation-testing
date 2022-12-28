package test.checkout;

import core.AllureTestListener;
import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.checkout.LoginAddressPage;
import page.checkout.ShoppingBagPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;


@Listeners({ AllureTestListener.class })
public class LoginAddressTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    public  ShoppingBagPage objShoppingBagPage;
    public  LoginPage objLogin;

    public  SignInPage objSignIn;
    private  RegisterPage objRegist;
    private  LoginAddressPage objLoginAddress;

    public LoginAddressTest() { super();}

    public void customerNotLogin() throws InterruptedException {
        objShoppingBagPage = new ShoppingBagPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
        objLoginAddress = new LoginAddressPage(this.keyword);
        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
    }
    public void customerLogin() throws InterruptedException {
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/");
        objLogin.loginOnWebsite("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD",
                "LOGIN_DATA_PHONE_LINH","LOGIN_DATA_PHONE_PASS", true);
        keyword.untilJqueryIsDone(50L);
    }

    @Test(priority = 1,
            description = "Add new billing address with all valid data and next page successfully")
    public void NLA_01_02() throws InterruptedException {
        logger.info("NLA_02");
        customerNotLogin();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.fillContactInformation(false, "CHECKOUT_LA_DATA_STREET_1",
                "CHECKOUT_LA_DATA_CODE_1","CHECKOUT_LA_DATA_CITY_1");
        objLoginAddress.verifyMelissa();

    }
    @Test(priority = 2,
            description = "Add new billing address using suggest address with store no state")
    public void NLA_03() throws InterruptedException {
        logger.info("NLA_03");
        objLoginAddress.resetForNewCase();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.fillContactInformation(true, null, null, null);
        objLoginAddress.verifyMelissa();

    }

    @Test(priority = 5,
            description = "Add new billing address and continue with your input options")
    public void NLA_05() throws InterruptedException {
        logger.info("NLA_05");
        //customerNotLogin();
        objLoginAddress.resetForNewCase();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.fillContactInformation(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2");
        objLoginAddress.chooseAddressOnValidation(false,"CHECKOUT_LA_BTN_APPLY_ADDRESS");
        objLoginAddress.verifyMelissa();
        objLoginAddress.compareAddress("CHECKOUT_DATA_EXPECT_DATA","CHECKOUT_LBL_ADDRESS_INFO");
    }

    @Test(priority = 3,
            description = "Add new billing address and continue with We Suggested option")
    public void NLA_06() throws InterruptedException {
        logger.info("NLA_06");
        objLoginAddress.resetForNewCase();
        //customerNotLogin();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.fillContactInformation(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2");
        objLoginAddress.chooseAddressOnValidation(true,"CHECKOUT_LA_BTN_APPLY_ADDRESS");
        objLoginAddress.verifyMelissa();
        objLoginAddress.compareAddress("CHECKOUT_DATA_EXPECT_DATA","CHECKOUT_LBL_ADDRESS_INFO");
    }

    @Test(priority = 4,
            description = "Add new another shipping address")
    public void NLA_08() throws InterruptedException {
        logger.info("NLA_08");
        objLoginAddress.addNewAddress(true,null,null,null,"CHECKOUT_HPL_NEW_ADDRESS");
    }

    @Test(priority = 6,
            description = "Add new another shipping address")
    public void NLA_07() throws InterruptedException {
        logger.info("NLA_07");
        objLoginAddress.addNewAddress(false,"CHECKOUT_LA_DATA_STREET_4",
                "CHECKOUT_LA_DATA_CODE_2","CHECKOUT_LA_DATA_CITY_2","CHECKOUT_HPL_NEW_ADDRESS");
    }

    @Test(priority = 7,
            description = "Add new shipping address with invalid data and using Your input option")
    public void NLA_10() throws InterruptedException {
        logger.info("NLA_10");
        //customerNotLogin();
        objLoginAddress.resetForNewCase();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.fillContactInformation(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2");
        objLoginAddress.chooseAddressOnValidation(true,"CHECKOUT_LA_BTN_APPLY_ADDRESS");
        objLoginAddress.addNewAddress(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2","CHECKOUT_HPL_NEW_ADDRESS");
        objLoginAddress.chooseAddressOnValidation(true,"CHECKOUT_LA_BTN_APPLY_ADDRESS_2");
        objLoginAddress.isAddNewAddress();
    }

    @Test(priority = 8,
            description = "Add new shipping address with invalid data and using Your input option")
    public void NLA_11() throws InterruptedException {
        logger.info("NLA_11");
        //customerNotLogin();
        objLoginAddress.resetForNewCase();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.fillContactInformation(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2");
        objLoginAddress.chooseAddressOnValidation(true,"CHECKOUT_LA_BTN_APPLY_ADDRESS");
        objLoginAddress.addNewAddress(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2","CHECKOUT_HPL_NEW_ADDRESS");
        objLoginAddress.chooseAddressOnValidation(false,"CHECKOUT_LA_BTN_APPLY_ADDRESS_2");
        objLoginAddress.isAddNewAddress();
    }

    @Test(priority = 9,
            description = "Edit shipping address same as billing")
    public void NLA_12_16() throws InterruptedException {
        objLoginAddress.editAddress("CHECKOUT_BTN_EDIT_ADDRESS");
        objLoginAddress.compareAddress("CHECKOUT_DATA_EXPECT_DATA","CHECKOUT_LBL_ADDRESS_INFO_2");
        objLoginAddress.goBack("CHECKOUT_BTN_CONTINUE_GUEST");
        objLoginAddress.moveToAddressPage();
        //objLoginAddress.checkOutNotLogin();

    }

    @Test(priority = 1, description = "Edit billing address ")
    public void NLA_13_14_15() throws InterruptedException {
        objLoginAddress.editBillingAddress();
    }

    @Test(priority = 10, description = "Login successfully with customer email on checkout page")
    public void NLA_17() throws InterruptedException {
        //customerNotLogin();
        objLoginAddress.resetForNewCase();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.loginOnLAPage();
    }

    @Test(priority = 11, description = "Leave blank Email/Phone or Password")
    public void NLA_19() throws InterruptedException {
        customerNotLogin();
        //objLoginAddress.resetForNewCase();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.loginFailed("noEmail");
    }

    @Test(priority = 12, description = "Continue with Customer login and input email or phone not matching password")
    public void NLA_20() throws InterruptedException {
        objLoginAddress.loginFailed("wrongPass");
    }
    @Test(priority = 12, description = "Continue with Customer login and input email invalid")
    public void NLA_21() throws InterruptedException {
        objLoginAddress.loginFailed("invalidEmail");
    }
    @Test(priority = 12, description = "Add new billing address with all valid data and next page successfully")
    public void NLA_35() throws InterruptedException {
        customerLogin();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.addNewBillingAddress(false, "CHECKOUT_LA_DATA_STREET_1",
                "CHECKOUT_LA_DATA_CODE_1", "CHECKOUT_LA_DATA_CITY_1");
        objLoginAddress.verifyMelissa();
    }
    @Test(priority = 13, description = "Add new billing address using suggest address with store no state")
    public void NLA_36() throws InterruptedException {
        objLoginAddress.addNewBillingAddress(true, "CHECKOUT_LA_DATA_STREET_1",
                "CHECKOUT_LA_DATA_CODE_1", "CHECKOUT_LA_DATA_CITY_1");
    }
    @Test(priority = 14, description = "Remove billing address successfully")
    public void NLA_41() throws InterruptedException {
        objLoginAddress.removeAddress("CHECKOUT_LA_BTN_REMOVE_BILLING_ADDRESS");
    }

    @Test(priority = 14, description = "Add new billing address and continue with your input options")
    public void NLA_38() throws InterruptedException {
        objLoginAddress.addNewBillingAddress(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2");
        objLoginAddress.chooseAddressOnValidation(false,"CHECKOUT_LA_BTN_APPLY_ADDRESS_2");
        objLoginAddress.checkNumberOfAddress("4");
    }
    @Test(priority = 15, description = "Add new billing address and continue with We Suggested option")
    public void NLA_39_40() throws InterruptedException {
        objLoginAddress.addNewBillingAddress(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2");
        objLoginAddress.chooseAddressOnValidation(true,"CHECKOUT_LA_BTN_APPLY_ADDRESS_2");
        objLoginAddress.checkNumberOfAddress("5");
    }
    @Test(priority = 16, description = "Add new another shipping address")
    public void NLA_42() throws InterruptedException {
        objLoginAddress.proceedAddress();
        objLoginAddress.addNewAddress(false,"CHECKOUT_LA_DATA_STREET_4",
                "CHECKOUT_LA_DATA_CODE_2","CHECKOUT_LA_DATA_CITY_2","CHECKOUT_HPL_NEW_SHIP_ADDRESS_LOGIN");
    }
    @Test(priority = 17, description = "Add new another shipping and using suggest address")
    public void NLA_43() throws InterruptedException {
        objLoginAddress.addNewAddress(true,"CHECKOUT_LA_DATA_STREET_4",
                "CHECKOUT_LA_DATA_CODE_2","CHECKOUT_LA_DATA_CITY_2","CHECKOUT_HPL_NEW_SHIP_ADDRESS_LOGIN");
    }
    @Test(priority = 18, description = "Add new shipping address with invalid data and using Your input option")
    public void NLA_45() throws InterruptedException {
        objLoginAddress.addNewAddress(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2","CHECKOUT_HPL_NEW_SHIP_ADDRESS_LOGIN");
        objLoginAddress.chooseAddressOnValidation(false,"CHECKOUT_LA_BTN_APPLY_ADDRESS_2");
        objLoginAddress.checkNumberOfAddress("6");
    }

    @Test(priority = 19, description = "Add new shipping address with invalid data and using We suggest option")
    public void NLA_46() throws InterruptedException {
        objLoginAddress.addNewAddress(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2","CHECKOUT_HPL_NEW_SHIP_ADDRESS_LOGIN");
        objLoginAddress.chooseAddressOnValidation(true,"CHECKOUT_LA_BTN_APPLY_ADDRESS_2");
        objLoginAddress.checkNumberOfAddress("7");
    }

    @Test(priority = 20, description = "Edit shipping address same as billing")
    public void NLA_47_49() throws InterruptedException {
        objLoginAddress.editAddress("CHECKOUT_BTN_EDIT_SHIP_ADDRESS");
        objLoginAddress.chooseAddressOnValidation(false,"CHECKOUT_LA_BTN_APPLY_ADDRESS_2");
    }

    @Test(priority = 21, description = "Edit shipping address with address not same as billing")
    public void NLA_50() throws InterruptedException {
        objLoginAddress.editFullShippingAddress();
    }

    @Test(priority = 22, description = "Remove shipping address successfully")
    public void NLA_51() throws InterruptedException {
        objLoginAddress.removeShippingAddress();
    }

    @Test(priority = 23, description = "Using back button with customer login")
    public void NLA_52() throws InterruptedException {
        objLoginAddress.goBack("CHECKOUT_BTN_CHECKOUT");
    }
    @Test(priority = 24, description = "Add new address and input wrong format postcode on the page, customer not login")
    public void NLA_53() throws InterruptedException {
        customerNotLogin();
        //objLoginAddress.resetForNewCase();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.wrongFormatCode();
    }
    @Test(priority = 25, description = "Add new address and input postcode more than 12 symbols")
    public void NLA_54() throws InterruptedException {
        objLoginAddress.invalidCodeSymbols();
    }

    @Test(priority = 25, description = "Forgot password but didn't input Email / Phone")
    public void NLA_26() throws InterruptedException {
        objLoginAddress.goBack("CHECKOUT_BTN_CONTINUE_GUEST");
        objLoginAddress.forgotPassword("noEmail");
    }
    @Test(priority = 26, description = "Forgot password and input Email wrong format")
    public void NLA_27() throws InterruptedException {
        objLoginAddress.forgotPassword("wrong format");
    }

    @Test(priority = 26, description = "Forgot password and input invalid verify code")
    public void NLA_31() throws InterruptedException {
        objLoginAddress.forgotPassword("invalid code");
    }
    @Test(priority = 27, description = "Forgot password and didn't input verify code")
    public void NLA_32() throws InterruptedException {
        objLoginAddress.forgotPassword("blank code");
    }

    @Test(priority = 28, description = "Add new billing address using suggest address with store having state")
    public void NLA_04() throws InterruptedException {
        customerNotLogin();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glus/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.fillContactInformation(true, null,null,null);
        objLoginAddress.verifyMelissa();
        objLoginAddress.compareAddress("CHECKOUT_DATA_EXPECT_DATA_4","CHECKOUT_LBL_ADDRESS_INFO");
    }


}
