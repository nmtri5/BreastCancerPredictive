package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageui.PredictorPageUI;

import java.util.function.Predicate;

public class PredictorPageObjects extends AbstractPage {
    WebDriver driver;

    public PredictorPageObjects(WebDriver driver) {
        this.driver = driver;
    }


    public void inputPredictData(double i, double i1, double i2, double i3, double i4) {
        waitForElementPresence(driver, PredictorPageUI.FIRST_TEXTBOX);

        clearText(driver, PredictorPageUI.FIRST_TEXTBOX);
        sendKeyToElement(driver, PredictorPageUI.FIRST_TEXTBOX, String.valueOf(i));

        clearText(driver, PredictorPageUI.SECOND_TEXTBOX);
        sendKeyToElement(driver, PredictorPageUI.SECOND_TEXTBOX, String.valueOf(i1));

        clearText(driver, PredictorPageUI.THIRD_TEXTBOX);
        sendKeyToElement(driver, PredictorPageUI.THIRD_TEXTBOX, String.valueOf(i2));

        clearText(driver, PredictorPageUI.FOURTH_TEXTBOX);
        sendKeyToElement(driver, PredictorPageUI.FOURTH_TEXTBOX, String.valueOf(i3));

        clearText(driver, PredictorPageUI.FIFTH_TEXTBOX);
        sendKeyToElement(driver, PredictorPageUI.FIFTH_TEXTBOX, String.valueOf(i4));
    }

    public void clickSubmit() {
        waitForElementPresence(driver, PredictorPageUI.SUBMIT_BUTTON);
        clickToElement(driver, PredictorPageUI.SUBMIT_BUTTON);
    }

    public boolean isResultDisplayedCorrect(String status) {
        return isElementDisplayed(driver, PredictorPageUI.DYNAMIC_RESULT_FIELD, status);
    }
}
