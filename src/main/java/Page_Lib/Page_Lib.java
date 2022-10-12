package Page_Lib;

import Page.Header_Page;
import Page.LogIn_LogOut_Page;
import Page.ProductDetail_Page;
import Page_Element.ListingPage_Element;
import org.openqa.selenium.WebDriver;

public class Page_Lib {
    private WebDriver driver;
    private Header_Page headerPage;
    private LogIn_LogOut_Page logInOutPage;
    private ProductDetail_Page productDetailPage;
    private ListingPage_Element listingPage;

    public Page_Lib(WebDriver driver) {
        this.driver = driver;
        listingPage = new ListingPage_Element(this.driver);
        headerPage = new Header_Page(this.driver);
        logInOutPage = new LogIn_LogOut_Page(this.driver);
        productDetailPage = new ProductDetail_Page(this.driver);
    }

    public Header_Page HeaderPage() {
        return headerPage;
    }

    public LogIn_LogOut_Page LogInOutage() {
        return logInOutPage;
    }

    public ProductDetail_Page ProductDetailPage() {
        return productDetailPage;
    }
    public ListingPage_Element ListingPage(){ return listingPage; }
}
