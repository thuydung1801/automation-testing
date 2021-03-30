package autoframework.pages.backEnd;

import autoframework.pages.H_CommonPages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ManageStonePages extends H_CommonPages{
    private final String xpath_resetFilter = "//button/span[text()='Reset Filter']";
    private final String id_certificateDropdown = "manage_stone_grid_filter_certificate";
    private final String id_clarityDropdown = "manage_stone_grid_filter_clarity";
    private final String id_stoneTypeDropdown = "manage_stone_grid_filter_stone_type";

    public void resetFilter() {
        int i = 0;
        while (i < 3) {
            try {
                getDriver().findElement(By.xpath(xpath_resetFilter)).click();
                break;
            } catch (Exception e) {
                waitAboutSecond(1);
            }
            i++;
        }
        waitAboutSecond(5);
    }

    public void selectCertificate(String certificate) {
        int i = 0;
        while (i < 3) {
            try {
                Select certificateSelect = new Select(getDriver().findElement(By.id(id_certificateDropdown)));
                certificateSelect.selectByIndex(convertCertificateToIndex(certificate));
                break;
            } catch (Exception e) {
                waitAboutSecond(1);
            }
            i++;
        }
    }

    public void selectClarity(String clarity) {
        int i = 0;
        while (i < 3) {
            try {
                Select qualitySelect = new Select(getDriver().findElement(By.id(id_clarityDropdown)));
                qualitySelect.selectByVisibleText(clarity.trim());
                break;
            } catch (Exception e) {
                waitAboutSecond(1);
            }
            i++;
        }
    }

    public void selectType(String type) {
        int i = 0;
        while (i < 3) {
            try {
                Select typeSelect = new Select(getDriver().findElement(By.id(id_stoneTypeDropdown)));
                typeSelect.selectByVisibleText(type.trim());
                break;
            } catch (Exception e) {
                waitAboutSecond(1);
            }
            i++;
        }
    }

    private int convertCertificateToIndex(String certificate) {
        int returnInt = 0;
        switch (certificate.toUpperCase().trim()) {
            case "GL CERTIFIED":
                returnInt = 1;
                break;
            case "GIA":
                returnInt = 2;
                break;
            default:
                break;
        }
        return returnInt;
    }
}
