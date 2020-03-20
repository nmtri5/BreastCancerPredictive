package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactoryManager;
import pageui.HomePageUI;
import pageui.LoginPageUI;

public class LoginPageObjects extends AbstractPage {
    WebDriver driver;

    public LoginPageObjects (WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username) {
        waitForElementPresence(driver, LoginPageUI.LOGIN_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.LOGIN_TEXTBOX, username);
    }

    public void inputPassword(String password) {
        waitForElementPresence(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public HomePageObjects clickLoginButton() {
        waitForElementPresence(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageFactoryManager.getHomePage(driver);
    }
}
