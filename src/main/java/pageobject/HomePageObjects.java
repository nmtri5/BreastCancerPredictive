package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactoryManager;
import pageui.HomePageUI;

public class HomePageObjects extends AbstractPage {
    WebDriver driver;

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUsernameDisplayedCorrectly(WebDriver driver, String labUser) {
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_WELCOME_TEXT, labUser);
    }

    public boolean isNumberOfMenuItemCorrect(WebDriver driver, int role) {
        //1 is Lab, 2 is admin, 3 is patient, 4 is specialist
        switch (role) {
            case 1:
                return countElementNumber(driver, HomePageUI.MENU_ITEM) == 3;
            case 2:
                return countElementNumber(driver, HomePageUI.MENU_ITEM) == 5;
            case 3:
                return countElementNumber(driver, HomePageUI.MENU_ITEM) == 4;
            case 4:
                return countElementNumber(driver, HomePageUI.MENU_ITEM) == 3;
                default:
                    return countElementNumber(driver, HomePageUI.MENU_ITEM) == 3;
        }
    }

    public LoginPageObjects clickLogoutButton() {
        waitForElementVisible(driver, HomePageUI.LOGOUT_BUTTON);
        clickToElement(driver, HomePageUI.LOGOUT_BUTTON);
        return PageFactoryManager.getLoginPage(driver);
    }

}
