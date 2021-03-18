package autoframework;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/BackEnd/instockItem.feature",
        plugin= {"html:target/testrunner",
                "json:target/testrunner/cucumber.json",
                "junit:target/testrunner/cucumber.xml"}
)
public class InstockItemSuite {
}
