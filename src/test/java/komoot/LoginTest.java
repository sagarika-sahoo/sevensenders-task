package komoot;

import komoot.pages.LandingPage;
import komoot.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends AbstractBaseTest {

    @Test(groups = { "login" })
    @Parameters({ "base-url" })
    public void loginTest(String baseUrl) {
        System.out.println(baseUrl);
        this.getDriver().get(baseUrl);
        this.waitUntilPageLoaded();

        LandingPage landingPage = new LandingPage(this.getDriver());
        landingPage.clickOnSignup();

        LoginPage loginPage = new LoginPage(this.getDriver());
        loginPage.enterLogin("qasaga1991@gmail.com", "Test@123");
    }
}
