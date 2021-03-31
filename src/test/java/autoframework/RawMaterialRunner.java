package autoframework;

import  autoframework.service.TestDataService;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"src/test/resources/features/BackEnd/RawMaterial.feature"},
    plugin = {"pretty", "json:target/RawMaterial.json"}
)
public class RawMaterialRunner {
  @BeforeClass
  public static void initConfiguration() {
    TestDataService.setProperties("/src/test/resources/data_test/data.properties");
  }
}
