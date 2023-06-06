package project.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static project.utils.PropConst.WEB_DRIVER;
import static project.utils.PropConst.WEB_DRIVER_PATH;

public class DriverManager {
    private WebDriver driver;
    private static DriverManager instance = null;
    private final TestPropManager props = TestPropManager.getTestPropManager();
    private DriverManager() {
    }
    public static DriverManager getDriverManager() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initDriver() {
        System.setProperty(props.getProperty(WEB_DRIVER), props.getProperty(WEB_DRIVER_PATH));
        driver = new ChromeDriver();
        }
    }
