package komoot;

import komoot.pages.LandingPage;
import komoot.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends AbstractBaseTest {

    @Test(groups = "login")
    @Parameters({ "base-url", "username", "password" })
    public void loginTest(String baseUrl, String username, String password) {
        this.getDriver().get(baseUrl);
        this.waitForReact();

        LandingPage landingPage = new LandingPage(this.getDriver());
        landingPage.clickOnSignup();

        LoginPage loginPage = new LoginPage(this.getDriver());
        loginPage.enterLogin(username, password);
    }
}
