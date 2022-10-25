package Page_Lib;

import Page.CheckOut.ShoppingPage_Page;
import Page.Header_Footer.Header_Page;
import Page.Catalog.ListingPage_Page;
import Page.Customer.Login_Page;
import Page.Catalog.ProductDetail_Page;
import org.openqa.selenium.remote.RemoteWebDriver;
import Page.CheckOut.MiniCart_Page;

public class Page_Lib {
    //private ChromeDriver driver;
    static RemoteWebDriver driver ;
    private Header_Page headerPage;
    private Login_Page logInOutPage;
    private ProductDetail_Page productDetailPage;
    private ListingPage_Page listingPage;
    private MiniCart_Page miniCartPage;
    private ShoppingPage_Page shoppingPage;

    public Page_Lib(RemoteWebDriver driver) {
        this.driver = driver;
        listingPage = new ListingPage_Page(this.driver);
        headerPage = new Header_Page(this.driver);
        logInOutPage = new Login_Page(this.driver);
        productDetailPage = new ProductDetail_Page(this.driver);
        miniCartPage = new MiniCart_Page((this.driver));
        shoppingPage = new ShoppingPage_Page(this.driver);
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
    public MiniCart_Page miniCartPage() {return  miniCartPage;}
    public  ShoppingPage_Page shoppingPagePage(){return shoppingPage; }
}
