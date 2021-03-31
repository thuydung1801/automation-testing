package autoframework.pages.frontEnd;

import autoframework.pages.CommonPageL;

public class HomePage extends CommonPageL {

    String jewelryLocator = "div#main-menu div.mobile_menu_content li.main-default>ul>li:nth-child(1)>a";
    String gemRingLocator = "div#main-menu div.mobile_menu_content li.main-default>ul>li:nth-child(1)>ul.level1>li:nth-child(1)>ul>li:nth-child(1)>ul>li:nth-child(3)>a";
    String jewelryMobileLocator = "div#main-menu>div>div>div>div:nth-child(1)>ul>li:nth-child(1)>a";
    String ringLocator = "div.mobile_menu_content:nth-child(2) div.header-nav>ul>li:nth-child(1)>ul>li.nav-rings-home";
    String gemRingJewLocator = "div.mobile_menu_content:nth-child(2) div.header-nav>ul>li:nth-child(1)>ul>li.nav-rings-home>ul>li:nth-child(5) ul.level2>li.nav-nhan-kim-cuong-kim-cuong a";


    public void hoverOnJewelryThenClickOnGemRing() {
        hoverThenClickOn(jewelryLocator,gemRingLocator);


    }

    public void clickOnJewelry() {
        click(jewelryMobileLocator);
    }

    public void hoverRingAndClickGemRing() {
        hoverThenClickOn(ringLocator, gemRingJewLocator);
    }
}
