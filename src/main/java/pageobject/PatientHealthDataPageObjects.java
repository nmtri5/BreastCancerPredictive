package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactoryManager;
import pageui.PatientHealthDataPageUI;

public class PatientHealthDataPageObjects extends AbstractPage{
    WebDriver driver;

    public PatientHealthDataPageObjects (WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyCorrectPageDisplayed(String patientName) {
        return isElementDisplayed(driver, PatientHealthDataPageUI.DYNMAMIC_TITLE, patientName);
    }

    public EditHealthDataPageObjects clickToEditDataButton() {
        waitForElementPresence(driver, PatientHealthDataPageUI.EDIT_BUTTON);
        clickToElement(driver, PatientHealthDataPageUI.EDIT_BUTTON);
        return PageFactoryManager.getEditHealthDataPage(driver);
    }

    public boolean isNewEditHealthDataCorrect(double first, double second, double third, double fourth, double fifth) {
        boolean bool = true;
        if(!getTextElement(driver, PatientHealthDataPageUI.CONCAVE_POINT_MEAN_TEXTBOX).equals(first)
                && !getTextElement(driver, PatientHealthDataPageUI.RADIUS_WORST_TEXTBOX).equals(second)
                && !getTextElement(driver, PatientHealthDataPageUI.PERIMETER_WORST_TEXTBOX).equals(third)
                && !getTextElement(driver, PatientHealthDataPageUI.AREA_WORST_TEXTBOX).equals(fourth)
                && !getTextElement(driver, PatientHealthDataPageUI.CONCAVE_POINT_WORST).equals(fifth))

        {
            bool = false;
        }
        return bool;
    }
}
