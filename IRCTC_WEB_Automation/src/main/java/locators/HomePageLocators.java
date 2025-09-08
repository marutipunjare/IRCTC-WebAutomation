package locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static final By okBtn = By.xpath("//button[contains(text(),'OK')]");
    public static final By origin = By.xpath("//*[@id='origin']/span/input");
    public static final By destination = By.xpath("//*[@id='destination']/span/input");
    public static final By calendar = By.xpath("//*[@id='jDate']/span/input");
    public static final By searchBtn = By.xpath("//*[@id=\"divMain\"]//button[text()='Search']");
    public static final By trainNames = By.xpath(
        "//*[@id='divMain']//span[contains(@class,'train-type')]/parent::div/div[contains(@class,'train-heading')]/strong");
}
