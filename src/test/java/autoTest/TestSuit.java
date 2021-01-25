package autoTest;

import autoTest.service.TestDataService;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features={"src/test/resources/features/consult_mektoube_page/DiscoveriesScreen/ResearchAndFilters.feature"},
        plugin={ "pretty", "json:target/cucumber-reports.json" },
        monochrome = true
)

public class TestSuit {
    @BeforeClass
    public static void initConfiguration() {
        TestDataService.setProperties("\\src\\test\\resources\\data_test\\data.properties");
    }
}
