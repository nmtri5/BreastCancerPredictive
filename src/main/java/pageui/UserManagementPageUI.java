package pageui;

public class UserManagementPageUI {
    public static final String DYNAMIC_EDIT_BUTTON ="//td[text()='%s']//following-sibling::td/a[text()='Edit']";
    public static final String DYNAMIC_DELETE_BUTTON ="//td[text()='%s']//following-sibling::td/a[text()='Delete']";
    public static final String ADD_BUTTON ="//button[text()='Add Employee']";
    public static final String USER_BY_FIRSTNAME = "//tbody[last()]//td[text()='%s']";

    public static final String NEW_EMPLOYEE_USER = "//table[@class='table']//tbody[last()]//td[1]";
    public static final String NEW_EMPLOYEE_ROLE = "//table[@class='table']//tbody[last()]//td[2]";
    public static final String NEW_EMPLOYEE_TITLE = "//table[@class='table']//tbody[last()]//td[3]";
}
