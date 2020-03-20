package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactoryManager;
import pageui.PatientListPageUI;

public class PatientListPageObjects extends AbstractPage{
    WebDriver driver;

    public PatientListPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void inputSearchKeyword(String s) {
        waitForElementPresence(driver, PatientListPageUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, PatientListPageUI.SEARCH_TEXTBOX, s);
    }

    public SearchResultPageObjects clickSearch() {
        waitForElementPresence(driver, PatientListPageUI.SEARCH_BUTTON);
        clickToElement(driver, PatientListPageUI.SEARCH_BUTTON);
        return PageFactoryManager.getSearchResultPage(driver);
    }

    public AddPatientPageObjects clickToAddPatient() {
        waitForElementPresence(driver, PatientListPageUI.ADD_BUTTON);
        clickToElement(driver, PatientListPageUI.ADD_BUTTON);
        return PageFactoryManager.getAddPatientPage(driver);
    }

    public boolean isPatientAddSuccesfully(String john) {
        return isElementDisplayed(driver, PatientListPageUI.PATIENT_BY_FIRSTNAME, john);
    }

    public EditPatientPageObjects clickToEditOnSpecificPatient(String john) {
        waitForElementPresence(driver, PatientListPageUI.DYNAMIC_EDIT_BUTTON, john);
        clickToElement(driver, PatientListPageUI.DYNAMIC_EDIT_BUTTON, john);
        return PageFactoryManager.getEditPatientPage(driver);
    }

    public boolean isPatientInformationUpdated(String first, String last, String address, String dept, String pres) {
        boolean bool = true;
        if(!getTextElement(driver, PatientListPageUI.NEW_PATIENT_FIRSTNAME).equals(first)
                && !getTextElement(driver, PatientListPageUI.NEW_PATIENT_LASTNAME).equals(last)
                && !getTextElement(driver, PatientListPageUI.NEW_PATIENT_ADDRESS).equals(address)
                && !getTextElement(driver, PatientListPageUI.NEW_PATIENT_DEPARTMENT).equals(dept)
                && !getTextElement(driver, PatientListPageUI.NEW_PATIENT_PRESCRIPTION).equals(pres))

        {
            bool = false;
        }
        return bool;
    }

    public void clickDeleteSpecificPatient(String kane) {
        waitForElementPresence(driver, PatientListPageUI.DYNAMIC_DELETE_BUTTON, kane);
        clickToElement(driver, PatientListPageUI.DYNAMIC_DELETE_BUTTON, kane);
    }

    public boolean isTheSpecificPatientDeleted(String kane) {
        return isElementUndispayed(driver, PatientListPageUI.PATIENT_BY_FIRSTNAME, kane);
    }
}
