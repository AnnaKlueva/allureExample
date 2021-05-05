package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DriverProvider;

import java.time.Duration;


public class Waiters {

    public static WebElement waitUntilElementIsVisible(WebElement element){
        return new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(element));
    }
}
