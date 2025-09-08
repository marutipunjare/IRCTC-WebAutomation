package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void startTest(String testName) {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/Results/ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void flushReport() {
        extent.flush();
    }
}
