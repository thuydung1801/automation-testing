package Tests.Header_Footer;

import Common_Page.AbstractBase_Test;
import org.testng.annotations.Test;

public class Header_Test extends AbstractBase_Test {

    @Test
    public void RunLogin(){
            App().Flow().navigateToUrl("https://dev1.glamira.com/glgb");
            App().Pages().HeaderPage().clickBtnLogIn();
    }
    @Test
    public void RunSearch(){
        App().Flow().navigateToUrl("https://dev1.glamira.com/glgb/");
        App().Pages().HeaderPage().senKeySearch();
        App().Pages().HeaderPage().clickBtnSearch();
        App().Pages().HeaderPage().clickBtnNext();
    }



}



