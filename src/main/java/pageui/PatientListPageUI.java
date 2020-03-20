package pageui;

public class PatientListPageUI {
    public static final String SEARCH_TEXTBOX ="//input[@id='searchpatient']";
    public static final String SEARCH_BUTTON ="//button[text()='Search']";

    public static final String ADD_BUTTON ="//button[text()='Add Patient']";
    public static final String DYNAMIC_EDIT_BUTTON ="//td/a[text()='%s']/ancestor::td//following-sibling::td/a[text()='Edit']";
    public static final String DYNAMIC_DELETE_BUTTON ="//td/a[text()='%s']/ancestor::td//following-sibling::td/a[text()='Delete']";
    public static final String PATIENT_BY_FIRSTNAME = "//td/a[text()='%s']";

    public static final String NEW_PATIENT_FIRSTNAME = "//table[@class='table']//tbody[last()]//td[1]";
    public static final String NEW_PATIENT_LASTNAME = "//table[@class='table']//tbody[last()]//td[2]";
    public static final String NEW_PATIENT_ADDRESS = "//table[@class='table']//tbody[last()]//td[3]";
    public static final String NEW_PATIENT_DEPARTMENT = "//table[@class='table']//tbody[last()]//td[4]";
    public static final String NEW_PATIENT_PRESCRIPTION = "//table[@class='table']//tbody[last()]//td[5]";


}
