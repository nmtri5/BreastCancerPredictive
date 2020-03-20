package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactoryManager;
import pageui.UserManagementPageUI;

public class UserManagementPageObjects extends AbstractPage {
    WebDriver driver;

    public UserManagementPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public EditUserPageObjects clickEditOnSpecificUser(String user) {
        waitForElementPresence(driver, UserManagementPageUI.DYNAMIC_EDIT_BUTTON, user);
        clickToElement(driver, UserManagementPageUI.DYNAMIC_EDIT_BUTTON, user);
        return PageFactoryManager.getEditUserPage(driver);
    }

    public void clickDeleteOnSpecificUser(String user) {
        waitForElementPresence(driver, UserManagementPageUI.DYNAMIC_DELETE_BUTTON, user);
        clickToElement(driver, UserManagementPageUI.DYNAMIC_DELETE_BUTTON, user);
    }

    public AddUserPageObjects clickAddEmployee() {
        waitForElementPresence(driver, UserManagementPageUI.ADD_BUTTON);
        clickToElement(driver, UserManagementPageUI.ADD_BUTTON);
        return PageFactoryManager.getAddUserPage(driver);
    }

    public boolean isTheSpecificUserAdded(String user) {
        return isElementDisplayed(driver, UserManagementPageUI.USER_BY_FIRSTNAME, user);
    }

    public boolean isUserInformationUpdated(String test, String patient_administrator, String nurse) {
        boolean bool = true;
        if(!getTextElement(driver, UserManagementPageUI.NEW_EMPLOYEE_USER).equals(test)
                && !getTextElement(driver, UserManagementPageUI.NEW_EMPLOYEE_ROLE).equals(patient_administrator)
                && !getTextElement(driver, UserManagementPageUI.NEW_EMPLOYEE_TITLE).equals(nurse))
        {
            bool = false;
        }
        return bool;
    }

    public void clickDeleteSpecificUser(String kane) {
        waitForElementPresence(driver, UserManagementPageUI.DYNAMIC_DELETE_BUTTON, kane);
        clickToElement(driver, UserManagementPageUI.DYNAMIC_DELETE_BUTTON, kane);
    }

    public boolean isTheSpecificUserDeleted(String kane) {
        return isElementUndispayed(driver, UserManagementPageUI.USER_BY_FIRSTNAME, kane);
    }
}
