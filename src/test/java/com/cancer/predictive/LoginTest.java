package com.cancer.predictive;

import commons.AbstractTest;
import commons.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pagefactory.PageFactoryManager;
import pageobject.HomePageObjects;
import pageobject.LoginPageObjects;

public class LoginTest extends AbstractTest {
    WebDriver driver;
    HomePageObjects homePage;
    LoginPageObjects loginPage;

    String parent;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = openBrowser(browser, Constants.STAGING_URL);
        loginPage = PageFactoryManager.getLoginPage(driver);
    }

    @Test
    public void Login_001_LabSpecialist() {
        log.info("Login - Lab Specialist input username");
        loginPage.inputUsername(Constants.LAB_USER);

        log.info("Login - Lab Specialist input password");
        loginPage.inputPassword(Constants.LAB_PASSWORD);

        log.info("Login - Lab Specialist click submit button");
        homePage = loginPage.clickLoginButton();

        log.info("Login - VP: Verify Homepage is displayed");
        verifyTrue(homePage.isUsernameDisplayedCorrectly(driver,Constants.LAB_USER));

        log.info("Login - VP: Verify menu item display correctly for Lab Specialist role");
        verifyTrue(homePage.isNumberOfMenuItemCorrect(driver, 1));

        log.info("Post Condition - Click Logout button");
        loginPage = homePage.clickLogoutButton();
    }

    @Test
    public void Login_002_PatientAdmin() {
        log.info("Login - Lab Specialist input username");
        loginPage.inputUsername(Constants.PATIENT_ADMIN);

        log.info("Login - Lab Specialist input password");
        loginPage.inputPassword(Constants.PATIENT_PASSWORD);

        log.info("Login - Lab Specialist click submit button");
        homePage = loginPage.clickLoginButton();

        log.info("Login - VP: Verify Homepage is displayed");
        verifyTrue(homePage.isUsernameDisplayedCorrectly(driver,Constants.PATIENT_ADMIN));

        log.info("Login - VP: Verify menu item display correctly for Lab Specialist role");
        verifyTrue(homePage.isNumberOfMenuItemCorrect(driver, 3));

        log.info("Post Condition - Click Logout button");
        loginPage = homePage.clickLogoutButton();
    }

    @Test
    public void Login_003_HospitalSpecialist() {
        log.info("Login - Lab Specialist input username");
        loginPage.inputUsername(Constants.SPECIALIST_USER);

        log.info("Login - Lab Specialist input password");
        loginPage.inputPassword(Constants.SPECIALISTPASSWORD);

        log.info("Login - Lab Specialist click submit button");
        homePage = loginPage.clickLoginButton();

        log.info("Login - VP: Verify Homepage is displayed");
        verifyTrue(homePage.isUsernameDisplayedCorrectly(driver,Constants.SPECIALIST_USER));

        log.info("Login - VP: Verify menu item display correctly for Lab Specialist role");
        verifyTrue(homePage.isNumberOfMenuItemCorrect(driver, 4));

        log.info("Post Condition - Click Logout button");
        loginPage = homePage.clickLogoutButton();
    }

    @Test
    public void Login_004_SystemAdmin() {
        log.info("Login - Lab Specialist input username");
        loginPage.inputUsername(Constants.ADMIN_USER);

        log.info("Login - Lab Specialist input password");
        loginPage.inputPassword(Constants.ADMIN_PASSWORD);

        log.info("Login - Lab Specialist click submit button");
        homePage = loginPage.clickLoginButton();

        log.info("Login - VP: Verify Homepage is displayed");
        verifyTrue(homePage.isUsernameDisplayedCorrectly(driver,Constants.ADMIN_USER));

        log.info("Login - VP: Verify menu item display correctly for Lab Specialist role");
        verifyTrue(homePage.isNumberOfMenuItemCorrect(driver, 2));

        log.info("Post Condition - Click Logout button");
        loginPage = homePage.clickLogoutButton();
    }

    @AfterClass
    public void AfterClass() {
        closeBrowserAndDriver(driver);
    }
}
