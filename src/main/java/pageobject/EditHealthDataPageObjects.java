package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactoryManager;
import pageui.EditHealthDataPageUI;

public class EditHealthDataPageObjects extends AbstractPage {
    WebDriver driver;

    public EditHealthDataPageObjects(WebDriver driver){
        this.driver = driver;
    }

    public void inputNewHealthData(double i, double i1, double i2, double i3, double i4) {
        waitForElementPresence(driver, EditHealthDataPageUI.CONCAVE_TEXTBOX);

        clearText(driver, EditHealthDataPageUI.CONCAVE_TEXTBOX);
        sendKeyToElement(driver, EditHealthDataPageUI.CONCAVE_TEXTBOX, String.valueOf(i));

        clearText(driver, EditHealthDataPageUI.RADIUS_TEXTBOX);
        sendKeyToElement(driver, EditHealthDataPageUI.RADIUS_TEXTBOX, String.valueOf(i1));

        clearText(driver, EditHealthDataPageUI.PERIMETER_TEXTBOX);
        sendKeyToElement(driver, EditHealthDataPageUI.PERIMETER_TEXTBOX, String.valueOf(i2));

        clearText(driver, EditHealthDataPageUI.AREA_TEXTBOX);
        sendKeyToElement(driver, EditHealthDataPageUI.AREA_TEXTBOX, String.valueOf(i3));

        clearText(driver, EditHealthDataPageUI.CONCAVE_POINT_WORST_TEXTBOX);
        sendKeyToElement(driver, EditHealthDataPageUI.CONCAVE_POINT_WORST_TEXTBOX, String.valueOf(i4));

    }

    public PatientHealthDataPageObjects clickToSubmit() {
        clickToElement(driver, EditHealthDataPageUI.SUBMIT_BUTTON);
        return PageFactoryManager.getPatientHealthDataPage(driver);
    }
}
