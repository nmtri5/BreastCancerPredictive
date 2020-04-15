package com.cancer.predictive;

import commons.AbstractTest;
import commons.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pagefactory.PageFactoryManager;
import pageobject.*;

public class SystemTest extends AbstractTest {
    WebDriver driver;
    HomePageObjects homePage;
    LoginPageObjects loginPage;
    PatientListPageObjects patientListPage;
    SearchResultPageObjects searchResultPage;
    UserManagementPageObjects userManagementPage;
    AddPatientPageObjects addPatientPage;
    EditPatientPageObjects editPatientPage;
    AddUserPageObjects addUserPage;
    EditUserPageObjects editUserPage;
    PatientHealthDataPageObjects patientHealthDataPage;
    EditHealthDataPageObjects editHealthDataPage;
    PredictorPageObjects predictorPage;
    PatientPopulationPageObjects patientPopulationPage;

    String parent;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = openBrowser(browser, Constants.STAGING_URL);
        loginPage = PageFactoryManager.getLoginPage(driver);

        log.info("Login - Lab Specialist input username");
        loginPage.inputUsername(Constants.ADMIN_USER);

        log.info("Login - Lab Specialist input password");
        loginPage.inputPassword(Constants.ADMIN_PASSWORD);

        log.info("Login - Lab Specialist click submit button");
        homePage = loginPage.clickLoginButton();
    }

    @Test(description = "Test a feature to search for a specific patient")
    public void SystemTest_001_Search(){
        log.info("Patient List - Click to Patient List tab");
        patientListPage = (PatientListPageObjects) homePage.clickToAnyTab(driver, "Patient List");

        log.info("Patient List - Input a Keyword in search field");
        patientListPage.inputSearchKeyword("Tri");

        log.info("Patient List - Click Search");
        searchResultPage = patientListPage.clickSearch();

        log.info("Patient List - VP: Verify search result");
        verifyTrue(searchResultPage.isSearchResultCorrect("Tri"));
    }

    @Test(description = "Test a feature to add a new patient")
    public void SystemTest_002_AddPatient(){
        log.info("Add Patient - Click to add button");
        patientListPage = (PatientListPageObjects) searchResultPage.clickToAnyTab(driver, "Patient List");
        addPatientPage = patientListPage.clickToAddPatient();

        log.info("Add Patient - Input Firstname");
        addPatientPage.inputFirstName("John");

        log.info("Add Patient - Input Lastname");
        addPatientPage.inputLastName("Kerry");

        log.info("Add Patient - Input Department");
        addPatientPage.inputDepartment("WH");

        log.info("Add Patient - Input Address");
        addPatientPage.inputAddress("The White House");

        log.info("Add Patient - Input Prescription");
        addPatientPage.inputPrescription("need special treatment");

        log.info("Add Patient - Click to Add Button");
        patientListPage = addPatientPage.clickAddButton();

        log.info("Add Patient - VP: Verify added sucessful");
        verifyTrue(patientListPage.isPatientAddSuccesfully("John"));
    }

    @Test(description = "Test a feature to edit a existing patient")
    public void SystemTest_003_EditPatientInfo(){
        log.info("Edit Patient - Click to Patient List tab");
        editPatientPage = patientListPage.clickToEditOnSpecificPatient("John");

        log.info("Edit Patient - Edit Firstname field");
        editPatientPage.editFirstName("Kane");

        log.info("Edit Patient - Edit Lastname field");
        editPatientPage.editLastName("Kennedy");

        log.info("Edit Patient - Edit Address field");
        editPatientPage.editAddress("The Pentagon");

        log.info("Edit Patient - Edit Department field");
        editPatientPage.editDepartment("SH");

        log.info("Edit Patient - Edit Prescription field");
        editPatientPage.editPrescription("good recover");

        log.info("Edit Patient - Click Submit button");
        patientListPage = editPatientPage.clickSubmit();

        log.info("Edit Patient - VP: Verify patient new info is updated");
        verifyTrue(patientListPage.isPatientInformationUpdated("Kane", "Kennedy", "The Pentagon", "SH", "good recover"));
    }

    @Test(description = "Test a feature to delete a existing patient")
    public void SystemTest_004_DeletePatient(){
        log.info("Delete Patient - Delete a patient");
        patientListPage.clickDeleteSpecificPatient("Kane");

        log.info("Delete Patient - VP: Verify the patient is deleted");
        verifyTrue(patientListPage.isTheSpecificPatientDeleted("Kane"));
    }

    @Test(description = "Test a feature to add a new employee")
    public void SystemTest_005_AddUser(){
        log.info("Add User - Click Add Employee button");
        userManagementPage = (UserManagementPageObjects) patientListPage.clickToAnyTab(driver,"User Management ");
        addUserPage = userManagementPage.clickAddEmployee();

        log.info("Add User - Input Username");
        addUserPage.inputUsername("trump");

        log.info("Add User - Input Password");
        addUserPage.inputPassword("123123");

        log.info("Add User - Choose a role");
        addUserPage.selectRoleDropdown("Patient Administrator");

        log.info("Add User - Choose a title");
        addUserPage.selectTitleDropdown("Nurse");

        log.info("Add User - Click Add button");
        userManagementPage = addUserPage.clickAddButton();

        log.info("Add User - VP: Verify a new user is added");
        verifyTrue(userManagementPage.isTheSpecificUserAdded("trump"));
    }

    @Test(description = "Test a feature to edit a existing employee")
    public void SystemTest_006_EditUser(){
        log.info("Edit User - Click edit on specific user");
        editUserPage = userManagementPage.clickEditOnSpecificUser("trump");

        log.info("Edit User - Edit username");
        editUserPage.editUsername("trudeau");

        log.info("Edit User - Edit password");
        editUserPage.editPassword("123123");

        log.info("Edit User - Edit a role");
        editUserPage.editRoleDropdown("Lab Specialist");

        log.info("Edit User - Edit a title");
        editUserPage.editTitleDropdown("Radiologist");

        log.info("Edit User - Click Add button");
        userManagementPage = editUserPage.clickSubmitButton();

        log.info("Edit User - VP: Verify new information is updated");
        verifyTrue(userManagementPage.isUserInformationUpdated("trudeau", "Lab Specialist", "Radiologist"));
    }

    @Test(description = "Test a feature to delete a existing employee")
    public void SystemTest_007_DeleteUser(){
        log.info("Delete User - Delete a user");
        userManagementPage.clickDeleteSpecificUser("trudeau");

        log.info("Delete User - VP: Verify the user is deleted");
        verifyTrue(userManagementPage.isTheSpecificUserDeleted("trudeau"));
    }

    @Test(description = "Test a feature to edit Patient Health Data")
    public void SystemTest_008_EditTestData(){
        log.info("Edit Test Data - Navigating to Patient List page");
        patientListPage = (PatientListPageObjects) userManagementPage.clickToAnyTab(driver,"Patient List");

        log.info("Edit Test Data - Click to specific patient");
        patientHealthDataPage = patientListPage.clickToAnyPatient("Jimmy");

        log.info("Edit Test Data - VP: Verify the correct patient page");
        patientHealthDataPage.verifyCorrectPageDisplayed("Jimmy");

        log.info("Edit Test Data - Click to Edit Data button");
        editHealthDataPage = patientHealthDataPage.clickToEditDataButton();

        log.info("Edit Test Data - Input new health data");
        editHealthDataPage.inputNewHealthData(0,0,0,0,0);

        log.info("Edit Test Data - Click to Submit button");
        patientHealthDataPage = editHealthDataPage.clickToSubmit();

        log.info("Edit Test Data - VP: Verify new data has been updated");
        patientHealthDataPage.isNewEditHealthDataCorrect(0,0,0,0,0);

        //Clean up test
        log.info("Edit Test Data - Click to Edit Data button");
        editHealthDataPage = patientHealthDataPage.clickToEditDataButton();

        log.info("Edit Test Data - Input new health data");
        editHealthDataPage.inputNewHealthData(12.2,1.5,212.2,21.5,2.1);

        log.info("Edit Test Data - Click to Submit button");
        patientHealthDataPage = editHealthDataPage.clickToSubmit();
    }

    @Test(description = "Test predictor benign")
    public void SystemTest_009_PredictorBenign(){
        log.info("Predictor - Navigate to predictor page");
        predictorPage = (PredictorPageObjects) patientHealthDataPage.clickToAnyTab(driver, "Predictor");

        log.info("Predictor - Input Health Data");
        predictorPage.inputPredictData(0,0,0,0,0);

        log.info("Predictor - Click to Submit Button");
        predictorPage.clickSubmit();

        log.info("Predictor - VP: veriy the result is benign");
        predictorPage.isResultDisplayedCorrect("benign");
    }

    @Test(description = "Test predictor benign")
    public void SystemTest_010_PredictorBenign(){
        log.info("Predictor - Input Health Data");
        predictorPage.inputPredictData(5.2,4.1,8.8,21,39);

        log.info("Predictor - Click to Submit Button");
        predictorPage.clickSubmit();

        log.info("Predictor - VP: veriy the result is malignant");
        predictorPage.isResultDisplayedCorrect("malignant");
    }

    @Test(description = "Test download")
    public void SystemTest_011_DownloadChart(){
        log.info("Data Visualization - Navigate to Patient List page");
        patientListPage = (PatientListPageObjects) predictorPage.clickToAnyTab(driver, "Patient List");

        log.info("Data Visualization - Input Health Data");
        patientPopulationPage =  patientListPage.clickSeePopulation();

        log.info("Data Visualization - Click to download as png");
        patientPopulationPage.clickSaveAsPNG();

        log.info("Data Visualization - VP: veriy the result is malignant");
        verifyTrue(patientPopulationPage.isFileDownloadedSuccessfully());
    }

    @AfterClass
    public void AfterClass() {
        closeBrowserAndDriver(driver);
    }
}
