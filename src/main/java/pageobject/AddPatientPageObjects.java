package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactoryManager;
import pageui.AddPatientPageUI;

public class AddPatientPageObjects extends AbstractPage{
    WebDriver driver;

    public AddPatientPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstName(String first){
        waitForElementPresence(driver, AddPatientPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddPatientPageUI.FIRST_NAME_TEXTBOX, first);
    }

    public void inputLastName(String last){
        waitForElementPresence(driver, AddPatientPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddPatientPageUI.LAST_NAME_TEXTBOX, last);
    }
    public void inputDepartment(String dept){
        waitForElementPresence(driver, AddPatientPageUI.DEPARTMENT_TEXTBOX);
        sendKeyToElement(driver, AddPatientPageUI.DEPARTMENT_TEXTBOX, dept);
    }
    public void inputAddress(String add){
        waitForElementPresence(driver, AddPatientPageUI.ADDRESS_TEXTBOX);
        sendKeyToElement(driver, AddPatientPageUI.ADDRESS_TEXTBOX, add);
    }
    public void inputPrescription(String pres){
        waitForElementPresence(driver, AddPatientPageUI.PRESCRIPTION_TEXTBOX);
        sendKeyToElement(driver, AddPatientPageUI.PRESCRIPTION_TEXTBOX, pres);
    }

    public PatientListPageObjects clickAddButton(){
        waitForElementPresence(driver, AddPatientPageUI.ADD_BUTTON);
        clickToElement(driver, AddPatientPageUI.ADD_BUTTON);
        return PageFactoryManager.getPatientListPage(driver);
    }
}
