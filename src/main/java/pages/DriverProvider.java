package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static utils.Constants.*;

public class DriverProvider {
    public static final DriverProvider INSTANCE = new DriverProvider();
    private ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();

    private DriverProvider(){}

    public WebDriver getDriver(){
        if (DRIVER.get() == null) {
            String browserType = loadProperties().getProperty("browserType");
            DRIVER.set(DriverFactory.createInstance(BrowserType.valueOf(browserType)));
        }
        return DRIVER.get();
    }

    public void removeDriver() {
        DRIVER.get().quit();
        DRIVER.remove();
    }

    public static Properties loadProperties(){
        String current = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String resourcesFolder = "src" + separator + "main" + separator + "resources";

        Path file = Paths.get(current + separator + resourcesFolder + separator + FILENAME_WITH_PROPERTIES);

        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("No such properties file");
        }
        return properties;
    }
}
