package komoot;

import komoot.pages.HomePage;
import org.testng.annotations.Test;

public class HomeTest extends AbstractBaseTest {

    @Test(dependsOnGroups = "login")
    public void searchOnHomePage() {
        this.waitForReact();

        HomePage homePage = new HomePage(this.getDriver());
        homePage.selectSport("jogging");
        homePage.chooseLocation("Kopenhagener Strasse");
    }
}
