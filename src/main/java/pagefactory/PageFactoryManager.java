package pagefactory;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageobject.*;

public class PageFactoryManager{

    public static HomePageObjects getHomePage(WebDriver driver){
        return new HomePageObjects(driver);
    }
    public static LoginPageObjects getLoginPage(WebDriver driver){
        return new LoginPageObjects(driver);
    }
    public static PatientListPageObjects getPatientListPage(WebDriver driver){
        return new PatientListPageObjects(driver);
    }
    public static SearchResultPageObjects getSearchResultPage(WebDriver driver){ return new SearchResultPageObjects(driver); }
    public static UserManagementPageObjects getUserManagementPage(WebDriver driver){
        return new UserManagementPageObjects(driver);
    }

    public static AddPatientPageObjects getAddPatientPage(WebDriver driver) {
        return new AddPatientPageObjects(driver);
    }

    public static EditPatientPageObjects getEditPatientPage(WebDriver driver) {
        return new EditPatientPageObjects(driver);
    }

    public static EditUserPageObjects getEditUserPage(WebDriver driver) {
        return new EditUserPageObjects(driver);
    }

    public static AddUserPageObjects getAddUserPage(WebDriver driver) {
        return new AddUserPageObjects(driver);
    }

    public static PatientHealthDataPageObjects getPatientHealthDataPage(WebDriver driver) { return new PatientHealthDataPageObjects(driver);
    }

    public static EditHealthDataPageObjects getEditHealthDataPage(WebDriver driver) { return new EditHealthDataPageObjects(driver);}

    public static PredictorPageObjects getPredictorPage(WebDriver driver) { return new PredictorPageObjects(driver);
    }

    public static PatientPopulationPageObjects getPatientPopulationPage(WebDriver driver) {
        return new PatientPopulationPageObjects(driver);
    }
}


