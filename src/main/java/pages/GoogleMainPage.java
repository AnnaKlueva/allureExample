package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

import static utils.Constants.BASE_URL;

public class GoogleMainPage extends BasePage{

    @FindBy(css = ".gLFyf.gsfi")
    private WebElement searchField;

    public GoogleMainPage() {
        super();
        DriverProvider.INSTANCE.getDriver().get(BASE_URL);
        waitForLoad();
    }

    @Override
    void waitForLoad() {
        Waiters.waitUntilElementIsVisible(searchField);
    }

    @Step
    public void searchFor(String text) {
        searchField.click();
        searchField.sendKeys(text);
        //Click "enter" button
        searchField.sendKeys(Keys.ENTER);
    }
}
