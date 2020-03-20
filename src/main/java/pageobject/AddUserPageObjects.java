package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactoryManager;
import pageui.AddUserPageUI;

public class AddUserPageObjects extends AbstractPage{
    WebDriver driver;

    public AddUserPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String user){
        waitForElementPresence(driver, AddUserPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, AddUserPageUI.USERNAME_TEXTBOX, user);
    }

    public void inputPassword(String pass){
        waitForElementPresence(driver, AddUserPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AddUserPageUI.PASSWORD_TEXTBOX, pass);
    }

    public void selectRoleDropdown(String role) {
        waitForElementPresence(driver, AddUserPageUI.ROLE_DROPDOWN);
        selectItemInHtmlDropdown(driver, AddUserPageUI.ROLE_DROPDOWN, role);
    }

    public void selectTitleDropdown(String title) {
        waitForElementPresence(driver, AddUserPageUI.TITLE_DROPDOWN);
        selectItemInHtmlDropdown(driver, AddUserPageUI.TITLE_DROPDOWN, title);
    }

    public UserManagementPageObjects clickAddButton(){
        waitForElementPresence(driver, AddUserPageUI.ADD_BUTTON);
        clickToElement(driver, AddUserPageUI.ADD_BUTTON);
        return PageFactoryManager.getUserManagementPage(driver);
    }
}
