package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactoryManager;
import pageui.EditUserPageUI;

public class EditUserPageObjects extends AbstractPage{
    WebDriver driver;

    public EditUserPageObjects(WebDriver driver){
        this.driver = driver;
    }


    public void editUsername(String test) {
        waitForElementPresence(driver, EditUserPageUI.EDIT_USERNAME_TEXTBOX);
        clearText(driver, EditUserPageUI.EDIT_USERNAME_TEXTBOX);
        sendKeyToElement(driver, EditUserPageUI.EDIT_USERNAME_TEXTBOX, test);
    }

    public void editPassword(String s) {
        waitForElementPresence(driver, EditUserPageUI.EDIT_PASSWORD_TEXTBOX);
        clearText(driver, EditUserPageUI.EDIT_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, EditUserPageUI.EDIT_PASSWORD_TEXTBOX, s);
    }

    public void editRoleDropdown(String role) {
        waitForElementPresence(driver, EditUserPageUI.EDIT_ROLE_DROPDOWN);
        selectItemInHtmlDropdown(driver, EditUserPageUI.EDIT_ROLE_DROPDOWN, role);
    }

    public void editTitleDropdown(String title) {
        waitForElementPresence(driver, EditUserPageUI.EDIT_TITLE_DROPDOWN);
        selectItemInHtmlDropdown(driver, EditUserPageUI.EDIT_TITLE_DROPDOWN, title);
    }

    public UserManagementPageObjects clickSubmitButton() {
        waitForElementPresence(driver, EditUserPageUI.SUBMIT_BUTTON);
        clickToElement(driver, EditUserPageUI.SUBMIT_BUTTON);
        return PageFactoryManager.getUserManagementPage(driver);
    }
}
