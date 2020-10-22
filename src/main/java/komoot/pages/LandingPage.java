package komoot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;

    @FindBy(css = ".tw-fixed button")
    WebElement signUpLoginButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnSignup() {
        signUpLoginButton.click();
    }
}
