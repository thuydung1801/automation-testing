package Page_Lib;

import Page.Header_Page;
import Page.Login_Page;
import Page.ProductDetail_Page;
import Page_Element.ListingPage_Element;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Page_Lib {
    //private ChromeDriver driver;
    static RemoteWebDriver driver ;
    private Header_Page headerPage;
    private Login_Page logInOutPage;
    private ProductDetail_Page productDetailPage;
    private ListingPage_Element listingPage;

    public Page_Lib(RemoteWebDriver driver) {
        this.driver = driver;
        listingPage = new ListingPage_Element(this.driver);
        headerPage = new Header_Page(this.driver);
        logInOutPage = new Login_Page(this.driver);
        productDetailPage = new ProductDetail_Page(this.driver);
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
    public ListingPage_Element ListingPage(){ return listingPage; }
}
