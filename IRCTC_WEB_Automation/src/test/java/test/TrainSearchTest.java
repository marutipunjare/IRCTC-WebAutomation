package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataprovider.DataProviders;
import pages.HomePage;
import utils.ExtentManager;
import utils.ScreenshotUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TrainSearchTest extends BaseTest {

    @Test(dataProvider = "TrainData", dataProviderClass = DataProviders.class)
    public void searchTrainsBetweenStations(String fromStation, String toStation) {
        try {
            HomePage home = new HomePage();

            home.closePopup();
            home.enterStations(fromStation, toStation);
            home.selectDateAfterDays(4);
            home.scrollBy(70); // scroll by 70px
            List<String> trainNames = home.searchTrains();

            // ✅ Assertions
            Assert.assertTrue(driver.getTitle().contains("IRCTC"), "Page title validation failed");
            int trainCount = trainNames.size();
            Assert.assertTrue(trainCount > 0, "No trains found!");

            // ✅ Console Output
            System.out.println("\n===============================");
            System.out.println("From: " + fromStation + " → To: " + toStation);
            System.out.println("Number of trains: " + trainCount);
            System.out.println("Train Names:");
            for (String train : trainNames) {
                System.out.println(" - " + train);
            }
            System.out.println("===============================");

            // ✅ Today’s date in dd/MM/yyyy format
            String todayFormatted = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            System.out.println("Today’s Date: " + todayFormatted);

            // ✅ Capture Screenshot
            home.captureResultPage("TrainSearch_" + fromStation + "_" + toStation);

            // ✅ Log in Extent Report
            ExtentManager.logPass("Test Passed. Found " + trainCount + " trains between " 
                                   + fromStation + " and " + toStation);

            
        } catch (Exception e) {
            ExtentManager.logFail("Test Failed: " + e.getMessage());
            ScreenshotUtils.captureScreenshot(driver, "Error_TrainSearch");
            Assert.fail(e.getMessage());
        }
    }
}
