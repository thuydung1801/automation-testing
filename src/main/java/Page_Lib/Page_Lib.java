package Page_Lib;

import Page.Header_Footer.Header_Page;
import Page.Catalog.ListingPage_Page;
import Page.Customer.Login_Page;
import Page.Catalog.ProductDetail_Page;
import Page.Header_Footer.Marketing_Page;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Page_Lib {
    //private ChromeDriver driver;
    static RemoteWebDriver driver ;
    private Header_Page headerPage;
    private Login_Page logInOutPage;
    private ProductDetail_Page productDetailPage;
    private ListingPage_Page listingPage;
    private Marketing_Page marketingPage;

    public Page_Lib(RemoteWebDriver driver) {
        this.driver = driver;
        listingPage = new ListingPage_Page(this.driver);
        headerPage = new Header_Page(this.driver);
        logInOutPage = new Login_Page(this.driver);
        productDetailPage = new ProductDetail_Page(this.driver);
        marketingPage = new Marketing_Page(this.driver);
    }

    public Header_Page HeaderPage() {
        return headerPage;
    }

    public Login_Page LogInOutage() {
        return logInOutPage;
    }

    public ProductDetail_Page ProductDetailPage() {
        return productDetailPage;
    }
    public ListingPage_Page ListingPage(){ return listingPage; }
    public Marketing_Page MarketingPage(){
        return marketingPage;
    }
}
