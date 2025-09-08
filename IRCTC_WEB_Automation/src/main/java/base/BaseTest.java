package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.ExtentManager;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;

    @BeforeClass
    public void setUp() {
        prop = ConfigReader.loadProperties();

        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
        	 WebDriverManager.chromedriver().setup();

             // Chrome options
             ChromeOptions options = new ChromeOptions();
             Map<String, Object> prefs = new HashMap<>();
             prefs.put("profile.default_content_setting_values.notifications", 2); // Block notifications
             options.setExperimentalOption("prefs", prefs);
             options.addArguments("--start-maximized"); // start maximized
             driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
                Integer.parseInt(prop.getProperty("implicitWait"))));

        wait = new WebDriverWait(driver, Duration.ofSeconds(
                Integer.parseInt(prop.getProperty("explicitWait"))));

        driver.get(prop.getProperty("url"));
        ExtentManager.startTest("IRCTC Train Search Test");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        ExtentManager.flushReport();
    }
}
