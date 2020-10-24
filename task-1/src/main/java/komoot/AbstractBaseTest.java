package komoot;

import komoot.pages.LandingPage;
import komoot.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

abstract public class AbstractBaseTest {

    private WebDriver driver;
    private String baseUrl;
    private String email;
    private String password;

    @BeforeMethod()
    @Parameters({ "base-url", "email", "password" })
    public void setup(String baseUrl, String email, String password) {
        String platform = System.getProperty("os.name");
        String driverPath = "drivers/chromedriver_linux64";

        if (platform.contains("Mac")) {
            driverPath = "drivers/chromedriver_mac64";
        }

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();

        if (System.getenv().containsKey("CI")) {
            options.addArguments("--headless");
        }

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        this.baseUrl = baseUrl.replaceAll("/$", "");
        this.email = email;
        this.password = password;
    }

    @AfterMethod()
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

    /**
     * Goto path relative to base url
     * @param path
     */
    public void goTo(String path) {
        driver.get(baseUrl + path);
    }

    /**
     * Perform app login using username and password testng parameters
     */
    public void performLogin() {
        performLogin(email, password);
    }

    /**
     * Perform app login with different inputs
     * @param email username/email for account
     * @param password password for account
     */
    public void performLogin(String email, String password) {
        this.goTo("/");
        this.waitForReact();

        LandingPage landingPage = new LandingPage(getDriver());
        landingPage.clickOnSignup();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.doLogin(email, password);
    }
}
