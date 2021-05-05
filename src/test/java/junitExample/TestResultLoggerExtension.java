package junitExample;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.DriverProvider;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {

    public void afterAll(ExtensionContext extensionContext) {
        System.out.println("Test in after all section");
        DriverProvider.INSTANCE.removeDriver();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test is failed");
        makeScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) DriverProvider.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}