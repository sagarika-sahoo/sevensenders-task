package komoot;

import komoot.pages.HomePage;
import org.testng.annotations.Test;

public class HomeTest extends AbstractBaseTest {

    @Test(dependsOnGroups = "login")
    public void searchOnHomePage() {
        this.waitUntilPageLoaded();

        HomePage homePage = new HomePage(this.getDriver());
        homePage.selectSport("mtb");
    }
}
