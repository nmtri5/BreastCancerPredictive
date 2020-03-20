package pageui;

public class HomePageUI {
    public static final String DYNAMIC_WELCOME_TEXT = "//h1[@class='mt-4' and contains(text(), '%s')]";
    public static final String MENU_ITEM = "//div[@class='list-group list-group-flush']/a";
    public static final String LOGOUT_BUTTON ="//div[@class='list-group list-group-flush']//a[last()]" ;
    public static final String DYNAMIC_TAB = "//div[@class='list-group list-group-flush']//a[text()='%s']";
}



