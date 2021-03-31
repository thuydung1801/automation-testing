package autoframework.pages.backEnd;

import autoframework.pages.CommonPageL;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CartPriceRulePage extends CommonPageL {
    String addBtnLocator = "button#add";
    String nameLocator = "input[name=\"name\"]";
    String websiteLocator = "select[name=\"website_ids\"]";
    String customerGroupLocator = "select[name=\"customer_group_ids\"]";
    String discountAmountLocator = "input[name=\"discount_amount\"]";
    String saveBtnLocator = "button#save";
    String discardSubsequentRules = "div[data-index=\"stop_rules_processing\"] div.admin__actions-switch";





    public void createADiscountRule(String arg0) {
        click(addBtnLocator);
        insertIntoField("testDiscount",nameLocator);
        getDriver().findElement(By.cssSelector(websiteLocator)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        getDriver().findElement(By.cssSelector(customerGroupLocator)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        insertIntoField(arg0,discountAmountLocator);
        scrollToAndClick(discardSubsequentRules);
        click(saveBtnLocator);




    }
}
