package tests;

import org.testng.annotations.Test;
import steps.Steps2;

import java.io.IOException;

public class VisualTest extends BaseTest {
    private Steps2 step2;

    public VisualTest() {
        step2 = new Steps2();
    }

    //    @Test (priority = 12)
    public void loginForm() throws Exception {
        //step2 = new Steps2();
        step2.gotoLogin();

        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

    //    @Test (priority = 1)
    public void homePage() throws Exception {
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

    //    @Test (priority = 2)
    public void homePage_2() throws Exception {
        step2.scroll();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }


    //    @Test (priority = 3)
    public void homePage_3() throws Exception {
        step2.scroll();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

    //    @Test (priority = 4)
    public void homePage_4() throws Exception {
        step2.scroll();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

//    @Test(priority = 5)
    public void homePage_5() throws Exception {
        step2.scroll();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

//    @Test(priority = 6)
    public void homePage_6() throws Exception {
        step2.scroll();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

//    @Test(priority = 7)
    public void homePage_7() throws Exception {
        step2.scroll();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

//    @Test(priority = 8)
    public void homePage_8() throws Exception {
        step2.scroll();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

//    @Test(priority = 9)
    public void homePage_9() throws Exception {
        step2.scroll();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

//    @Test(priority = 10)
    public void homePage_10() throws Exception {
        step2.scroll();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

//    @Test(priority = 10)
    public void homePage_11() throws Exception {
        step2.scroll();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }

//    @Test(priority = 11)
//    public void listingPage_1() throws Exception {
//        step2.filterListing();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//
//    @Test(priority = 12)
//    public void listingPage_2() throws Exception {
//        step2.filterListingByPerciousStones();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//
//    @Test(priority = 13)
//    public void listingPage_3() throws Exception {
//        step2.filterListingBySemiPreciousStones();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//
//    @Test(priority = 14)
//    public void listingPage_4() throws Exception {
//        step2.filterListingBySwarovskiCrystals();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//
//    @Test(priority = 15)
//    public void listingPage_6() throws Exception {
//        step2.filterListingByCulturedPearls();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//
//    @Test(priority = 16)
//    public void listingPage_7() throws Exception {
//        step2.filterListingByLabCreatedStones();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//
//    @Test(priority = 17)
//    public void listingPage_8() throws Exception {
//        step2.filterListingByCabochonStones();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//
//    @Test(priority = 18)
//    public void listingPage_9() throws Exception {
//        step2.filterListingByCarat();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//        @Test(priority = 19)
//    public void listingPage_10() throws Exception {
//        step2.filterListingByCarat();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//        @Test(priority = 20)
//    public void listingPage_11() throws Exception {
//        step2.filterListingByStoneShape();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//    @Test(priority = 21)
//    public void listingPage_12() throws Exception {
//        step2.filterListingByColour();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }

//    @Test(priority = 1)
//    public void MyAccount_Overview_Content() throws Exception {
//        step2.myAccount_Overview_Content();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//    @Test(priority = 2)
//    public void MyAccount_Overview_ChangePass() throws Exception {
//        step2.myAccount_Overview_ChangePass();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }

  //  @Test(priority = 2)
    public void MyAccount_Overview_Footer() throws Exception {
        step2.myAccount_Overview_Footer();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
  //  @Test(priority = 3)
    public void Return_CustomerExist() throws Exception {
        step2.return_CustomerExist();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();

    }
  //  @Test(priority = 4)
    public void Return_CustomerNotExist() throws Exception {
        step2.return_CustomerNotExist();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
//    @Test(priority = 5)
//    public void SignUp_FormHomeLogin() throws Exception {
//        step2.signUp_FormHomeLogin();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//    @Test(priority = 6)
//    public void SignUp_FormCreateAccount_Step1() throws Exception {
//        step2.signUp_FormCreateAccount_Step1();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//    @Test(priority = 7)
//    public void SignUp_FormCreateAccountError_Step1() throws Exception {
//        step2.signUp_FormCreateAccountError_Step1();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//    @Test(priority = 8)
//    public void SignUp_FormCreateAccount_Step2() throws Exception {
//        step2.signUp_FormCreateAccount_Step2();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//    @Test(priority = 9)
//    public void SignUp_FormCreateAccountError_Step2() throws Exception {
//        step2.signUp_FormCreateAccountError_Step2();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//    @Test(priority = 10)
//    public void SignUp_FormCreateAccount_Step3() throws Exception {
//        step2.signUp_FormCreateAccount_Step3();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
//    @Test(priority = 11)
//    public void SignUp_FormCreateAccountError_Step3() throws Exception {
//        step2.signUp_FormCreateAccountError_Step3();
//        steps
//                .givenITakeScreenShot()
//                .whenISaveTheScreenShotsToFolders()
//                .thenIShouldCompareScreenshotsSuccessfully();
//    }
    @Test(priority = 12)
    public void SinIn1() throws Exception {
        step2.sinIn_FormHomeForgotPassword();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
    @Test(priority = 13)
    public void SinIn2() throws Exception {
        step2.sinIn_FormForgotPassword_Email();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
    @Test(priority = 14)
    public void SignIn3() throws Exception {
        step2.signIn_FormForgotPassword_HoverBtnSubmit();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
    @Test(priority = 15)
    public void SignIn4() throws Exception {
        step2.signIn_FormForgotPassword_EmailError();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
    @Test(priority = 16)
    public void SignIn5() throws Exception {
        step2.signIn_FormForgotPassword_SendCode();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
    @Test(priority = 17)
    public void SignIn6() throws Exception {
        step2.signIn_FormForgotPassword_SendCodeError();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
    @Test(priority = 18)
    public void SignIn7() throws Exception {
        step2.signIn_FormForgotPassword_ChangePassWaite();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }



    @Test(priority = 19)
    public void SignIn8() throws Exception {
        step2.signIn_FormForgotPassword_ChangePass();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
    @Test(priority = 20)
    public void SignIn9() throws Exception {
        step2.signIn_FormForgotPassword_ChangePassError();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }
    @Test(priority = 21)
    public void SignIn10() throws Exception {
        step2.signIn_FormForgotPassword_ChangePassSuccess();
        steps
                .givenITakeScreenShot()
                .whenISaveTheScreenShotsToFolders()
                .thenIShouldCompareScreenshotsSuccessfully();
    }


}
