package pages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;
import locators.HomePageLocators;
import utils.ActionUtils;
import utils.ScreenshotUtils;

public class HomePage extends BaseTest {

    ActionUtils action;

    public HomePage() {
        action = new ActionUtils(driver, wait);
    }

    public void closePopup() {
        action.click(HomePageLocators.okBtn);
    }

    public void enterStations(String from, String to) {
        action.type(HomePageLocators.origin, from);
        action.pressEnter(HomePageLocators.origin);

        WebElement firstOriginOption = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='origin']/span/div/ul/li[1]"))
        );
        firstOriginOption.click();

        action.type(HomePageLocators.destination, to);
        action.pressEnter(HomePageLocators.destination);

        WebElement firstDestinationOption = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pr_id_2_list']/li[1]"))
        );
        firstDestinationOption.click();
    }

    public void selectDateAfterDays(int days) {
        LocalDate target = LocalDate.now().plusDays(days);
        int day = target.getDayOfMonth();

        action.click(HomePageLocators.calendar);

        By dateLocator = By.xpath(
            "//*[@id='jDate']//div[contains(@class,'ui-datepicker-group')]//a[text()='" + day + "']"
        );
        action.moveToAndClick(dateLocator);
    }

    public void scrollBy(int pixels) {
        action.scrollBy(pixels);
    }

    /**
     * Clicks search and returns train names as a List<String>
     */
    public List<String> searchTrains() {
        action.click(HomePageLocators.searchBtn);

        // wait until at least one train appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.trainNames));

        List<WebElement> trainElements = driver.findElements(HomePageLocators.trainNames);
        List<String> trainNames = new ArrayList<>();

        for (WebElement el : trainElements) {
            String name = el.getText().trim();
            if (!name.isEmpty()) {
                trainNames.add(name);
            }
        }

        return trainNames;
    }

    public void captureResultPage(String testName) {
        ScreenshotUtils.captureScreenshot(driver, testName);
    }
}
