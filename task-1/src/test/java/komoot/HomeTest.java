package komoot;

import komoot.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends AbstractBaseTest {

    @Test
    public void searchOnHomePage() {
        performLogin();

        goTo("/");
        waitForReact();

        HomePage homePage = new HomePage(getDriver());
        homePage.selectSport("jogging");
        homePage.chooseLocation("Kopenhagener Strasse");

        waitFor(5000);

        WebDriver driver = getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,750)");

        String tourCount = driver.findElement(By.cssSelector(".c-filter-bar .tw-flex-auto")).getText();
        System.out.println(tourCount);
        Assert.assertTrue(tourCount.contains("Tours"));
    }
}
