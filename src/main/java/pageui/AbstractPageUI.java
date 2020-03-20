package pageui;

public class AbstractPageUI {
    public static final String BREADCUMB_ACTIVE_LINK = "//ul[@class = 'breadcrumb']//li[@class = 'active']";

    /** Header Links **/
    public static final String DYNAMIC_HEADER_LINK = "//div[@class = 'header-container']//a[text() = '%s']";

    /** Menu items **/
    public static final String DYNAMIC_MENU_ITEM_LINK = "//ul[@class = 'nav']/li/a[@title = '%s']";

}
