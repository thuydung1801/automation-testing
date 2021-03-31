package autoframework;

import  autoframework.service.TestDataService;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"src/test/resources/features/BackEnd/StartProduction.feature"},
    plugin = {"pretty", "json:target/StartProduction.json"}
)
public class StartProductionRunner {
  @BeforeClass
  public static void initConfiguration() {
    TestDataService.setProperties("/src/test/resources/data_test/data.properties");
  }
}
