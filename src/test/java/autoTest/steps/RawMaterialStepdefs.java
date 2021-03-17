package autoTest.steps;

import autoTest.steps.serenity.RawMaterialEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RawMaterialStepdefs {
    @Steps
    RawMaterialEndUserSteps rawMaterialEndUserSteps;
    @When("^Click on Add New Raw Material$")
    public void clickOnAddNewRawMaterial() {
        rawMaterialEndUserSteps.clickOnAddNewRawMaterial();
    }

    @And("^Input information \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" Select \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void inputRawInformation(String serialNo, String weight, String brand, String date, String materialAlloy, String fineMaterial, String isNewRaw) throws Throwable {
        rawMaterialEndUserSteps.inputRawInformation(serialNo,weight,brand,date,materialAlloy,fineMaterial,isNewRaw);
    }

    @And("^Click on Save to save new raw$")
    public void clickOnSaveToSaveNewRaw() {
        rawMaterialEndUserSteps.clickOnSaveToSaveNewRaw();
    }

    @When("^View detail of the material has \"([^\"]*)\"$")
    public void viewDetailOfTheMaterialHas(String serialNo) throws Throwable {
        rawMaterialEndUserSteps.viewDetailOfTheMaterialHas(serialNo);
    }


    @And("^View the History$")
    public void viewTheHistory() {
        rawMaterialEndUserSteps.viewTheHistory();
    }



    @Then("^The weight usage for the \"([^\"]*)\" is \"([^\"]*)\"$")
    public void theWeightUsageIs(String metalCode, String weight) throws Throwable {
        rawMaterialEndUserSteps.theWeightUsageIs(metalCode, weight);
    }
}
