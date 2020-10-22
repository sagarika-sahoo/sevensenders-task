package komoot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

abstract public class AbstractBaseTest {

    private static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        String platform = System.getProperty("os.name");
        String driverPath = "drivers/chromedriver_linux64";

        if (platform.contains("Mac")) {
            driverPath = "drivers/chromedriver_mac64";
        }

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Wait for 2 secs, because of React SPA
     */
    public void waitForReact() {
        // wait for SPA to load
        waitFor(2000);
    }

    /**
     * Wait for time, because of React SPA
     * @param time time to wait
     */
    public void waitFor(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ignored) { }
    }
}
