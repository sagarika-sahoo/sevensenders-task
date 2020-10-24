package komoot;

import komoot.pages.HomePage;
import komoot.pages.LandingPage;
import komoot.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;

public class LoginTest extends AbstractBaseTest {
    @Test
    public void validLoginTest() {
        performLogin();
        waitForReact();

        String titleText = getDriver().findElement(By.tagName("h2")).getText();
        Assert.assertEquals(titleText, "Find the Perfect Tour");
    }

    @Test
    public void invalidEmailIdTest() {
        this.goTo("/");
        this.waitForReact();

        WebDriver driver = getDriver();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignup();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test");

        boolean valid = loginPage.isEmailInputValid();
        Assert.assertFalse(valid, "email input validation is not working");
    }

    @Test
    @Parameters({ "email" })
    public void invalidLoginTest(String email) {
        performLogin(email, "password");
        waitForReact();

        String errorText = "Unfortunately we couldn’t log you in. Please verify your email and password and try again.";
        List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(text(),'" + errorText + "')]"));
        Assert.assertTrue(list.size() > 0, "Error text not found!");
    }

    @Test
    public void logoutTest() {
        performLogin();
        waitForReact();

        HomePage homePage = new HomePage(getDriver());
        homePage.openUserMenu();
        homePage.clickLogout();
    }
}
