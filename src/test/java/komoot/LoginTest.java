package komoot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends AbstractBaseTest {

    @Test
    public void validLoginTest() {
        performLogin();

        String titleText = getDriver().findElement(By.tagName("h2")).getText();
        Assert.assertEquals(titleText, "Find the Perfect Tour");
    }

    @Test
    @Parameters({ "username" })
    public void invalidLoginTest(String username) {
        performLogin(username, "password");

        String errorText = "Unfortunately we couldn’t log you in. Please verify your email and password and try again.";
        List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(text(),'" + errorText + "')]"));
        Assert.assertTrue(list.size() > 0, "Error text not found!");
    }
}
