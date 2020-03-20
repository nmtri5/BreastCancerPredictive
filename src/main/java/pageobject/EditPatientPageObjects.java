package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactoryManager;
import pageui.EditPatientPageUI;

public class EditPatientPageObjects extends AbstractPage{
    WebDriver driver;

    public EditPatientPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void editFirstName(String kane) {
        waitForElementPresence(driver, EditPatientPageUI.EDIT_FIRSNAME_TEXTBOX);
        clearText(driver, EditPatientPageUI.EDIT_FIRSNAME_TEXTBOX);
        sendKeyToElement(driver, EditPatientPageUI.EDIT_FIRSNAME_TEXTBOX, kane);
    }

    public void editLastName(String last) {
        waitForElementPresence(driver, EditPatientPageUI.EDIT_LASTNAME_TEXTBOX);
        clearText(driver, EditPatientPageUI.EDIT_LASTNAME_TEXTBOX);
        sendKeyToElement(driver, EditPatientPageUI.EDIT_LASTNAME_TEXTBOX, last);
    }

    public void editAddress(String add) {
        waitForElementPresence(driver, EditPatientPageUI.EDIT_ADDRESS_TEXTBOX);
        clearText(driver, EditPatientPageUI.EDIT_ADDRESS_TEXTBOX);
        sendKeyToElement(driver, EditPatientPageUI.EDIT_ADDRESS_TEXTBOX, add);
    }

    public void editDepartment(String dept) {
        waitForElementPresence(driver, EditPatientPageUI.EDIT_DEPARTMENT_TEXTBOX);
        clearText(driver, EditPatientPageUI.EDIT_DEPARTMENT_TEXTBOX);
        sendKeyToElement(driver, EditPatientPageUI.EDIT_DEPARTMENT_TEXTBOX, dept);
    }

    public void editPrescription(String pres) {
        waitForElementPresence(driver, EditPatientPageUI.EDIT_PRESCRIPTION_TEXTBOX);
        clearText(driver, EditPatientPageUI.EDIT_PRESCRIPTION_TEXTBOX);
        sendKeyToElement(driver, EditPatientPageUI.EDIT_PRESCRIPTION_TEXTBOX, pres);
    }

    public PatientListPageObjects clickSubmit() {
        waitForElementPresence(driver, EditPatientPageUI.SUBMIT_BUTTON);
        clickToElement(driver, EditPatientPageUI.SUBMIT_BUTTON);
        return PageFactoryManager.getPatientListPage(driver);
    }
}
