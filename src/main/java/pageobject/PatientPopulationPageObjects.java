package pageobject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageui.PatientPopulationPageUI;

import java.io.File;

public class PatientPopulationPageObjects extends AbstractPage {
    WebDriver driver;

    public PatientPopulationPageObjects(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSaveAsPNG() {
        waitForElementPresence(driver, PatientPopulationPageUI.MORE_OPTION_BUTTON);
        clickToElement(driver, PatientPopulationPageUI.MORE_OPTION_BUTTON);

        clickToElement(driver, PatientPopulationPageUI.DOWNLOAD_AS_PNG);
        sleep(5);
    }

    public boolean isFileDownloadedSuccessfully() {
        File folder = new File("C:\\Users\\nmtri\\Downloads");

        //List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        //Look for the file in the files
        // You should write smart REGEX according to the filename
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches("Chart.png")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        f.deleteOnExit();
        return found;
    }
}