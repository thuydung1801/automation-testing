package autoframework.steps.backEnd;

import autoframework.pages.backEnd.RawMaterialPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RawMaterialStepdefs {
    @Steps
    RawMaterialPage rawMaterialPage;
    @When("^Click on Add New Raw Material$")
    public void clickOnAddNewRawMaterial() {
        rawMaterialPage.clickOnAddNewRawMaterial();
    }

    @And("^Input information \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" Select \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void inputRawInformation(String serialNo, String weight, String brand, String date, String materialAlloy, String fineMaterial, String isNewRaw) throws Throwable {
        rawMaterialPage.inputRawInformation(serialNo,weight,brand,date,materialAlloy,fineMaterial,isNewRaw);
    }

    @And("^Click on Save to save new raw$")
    public void clickOnSaveToSaveNewRaw() {
        rawMaterialPage.clickOnSaveToSaveNewRaw();
    }

    @When("^View detail of the material has \"([^\"]*)\"$")
    public void viewDetailOfTheMaterialHas(String serialNo) throws Throwable {
        rawMaterialPage.viewDetailOfTheMaterialHas(serialNo);
    }


    @And("^View the History$")
    public void viewTheHistory() {
        rawMaterialPage.viewTheHistory();
    }



    @Then("^The weight usage for the \"([^\"]*)\" is \"([^\"]*)\"$")
    public void theWeightUsageIs(String metalCode, String weight) throws Throwable {
        rawMaterialPage.theWeightUsageIs(metalCode, weight);
    }
}
