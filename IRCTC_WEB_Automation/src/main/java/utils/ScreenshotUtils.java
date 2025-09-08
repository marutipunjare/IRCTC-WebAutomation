package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenshotUtils {
    public static void captureScreenshot(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destPath = System.getProperty("user.dir") + "/Snapshots/" + testName + "_" + timestamp + ".png";

        try {
            Files.copy(src, new File(destPath));
            System.out.println("Screenshot saved at: " + destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
