package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageui.SearchResultPageUI;

import java.util.List;

public class SearchResultPageObjects extends AbstractPage{
    WebDriver driver;

    public SearchResultPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchResultCorrect(String s) {
        boolean bool = true;
        List<String> a = getTextInListOfElement(driver, SearchResultPageUI.DYNAMIC_RESULT_TEXT, s);
        for (String result : a)
        {
            if(!result.equals(s)) {
                bool = false;
            }
        }
        return bool;
    }
}
