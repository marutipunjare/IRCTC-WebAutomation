package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtils {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public ActionUtils(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.actions = new Actions(driver);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement el = driver.findElement(locator);
        el.clear();
        el.sendKeys(text);
    }

    public void pressEnter(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void moveToAndClick(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement el = driver.findElement(locator);
        actions.moveToElement(el).click().perform();
    }

    public void scrollBy(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    public String getText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }
}
