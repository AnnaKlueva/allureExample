package testNgExample;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.DriverProvider;


public class TestNgRunner {

    @BeforeMethod
    public  void before(){
    }

    @AfterMethod(alwaysRun = true)
    public void after(ITestResult result){
        if (!result.isSuccess()) {
            makeScreenshot();
        }
        DriverProvider.INSTANCE.removeDriver();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) DriverProvider.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
