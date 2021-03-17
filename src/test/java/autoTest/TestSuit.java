package autoTest;

import autoTest.service.TestDataService;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features={"src/test/resources/features/consult_mektoube_page/startAutoTest/Checkout.feature"},
        plugin={ "pretty", "json:target/cucumber-reports.json" },
        monochrome = true
)

public class TestSuit {
    @BeforeClass
    public static void initConfiguration() {
        //run with ubuntu, need set path to /
        TestDataService.setProperties("/src/test/resources/data_test/data.properties");
        //run with windows, need set path to \\
        //TestDataService.setProperties("\\src\\test\\resources\\data_test\\data.properties");
    }
}
