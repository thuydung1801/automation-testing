package autoframework;

import  autoframework.service.TestDataService;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"src/test/resources/features/FrontEnd/CartPage.feature"},
    plugin = {"pretty", "json:target/CartPage.json"}
)
public class CartPageRunner {
  @BeforeClass
  public static void initConfiguration() {
    TestDataService.setProperties("/src/test/resources/data_test/data.properties");
  }
}
