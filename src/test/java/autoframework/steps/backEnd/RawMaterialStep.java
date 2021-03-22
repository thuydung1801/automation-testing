package autoframework.steps.backEnd;

import autoframework.pages.backEnd.RawMaterialPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RawMaterialStep {
    @Steps
    RawMaterialPage nia;
    @When("^Click on Add New Raw Material$")
    public void clickOnAddNewRawMaterial() {
        nia.clickOnAddNewRawMaterial();
    }

    @And("^Input information \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" Select \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void inputRawInformation(String serialNo, String weight, String brand, String date, String materialAlloy, String fineMaterial, String isNewRaw) throws Throwable {
        nia.inputRawInformation(serialNo,weight,brand,date,materialAlloy,fineMaterial,isNewRaw);
    }

    @And("^Click on Save to save new raw$")
    public void clickOnSaveToSaveNewRaw() {
        nia.clickOnSaveToSaveNewRaw();
    }

    @When("^View detail of the material has \"([^\"]*)\"$")
    public void viewDetailOfTheMaterialHas(String serialNo) throws Throwable {
        nia.viewDetailOfTheMaterialHas(serialNo);
    }


    @And("^View the History$")
    public void viewTheHistory() {
        nia.viewTheHistory();
    }



    @Then("^The weight usage for the \"([^\"]*)\" is \"([^\"]*)\"$")
    public void theWeightUsageIs(String metalCode, String weight) throws Throwable {
        nia.theWeightUsageIs(metalCode, weight);
    }
}
