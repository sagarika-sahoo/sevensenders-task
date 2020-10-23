package komoot;

import komoot.pages.HomePage;
import komoot.pages.LoginPage;
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
    }
}
