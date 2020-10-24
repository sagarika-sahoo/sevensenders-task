package komoot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(css = ".c-sport-selector")
    WebElement sportSelector;

    @FindBy(css = "input.c-location-search__input")
    WebElement cityInput;

    @FindBy(css = ".c-location-search__results")
    WebElement cityAutocompleteList;

    @FindBy(css = ".c-topmenu:last-child")
    WebElement userMenu;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutElement;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void selectSport(String sport) {
        sportSelector.findElement(By.cssSelector("[data-value='" + sport + "']")).click();
    }

    public void chooseLocation(String locationName) {
        cityInput.click();
        cityInput.sendKeys(locationName);

        // select the first in autocomplete
        cityAutocompleteList.findElement(By.tagName("li")).click();
    }

    public void openUserMenu() {
        userMenu.click();
    }

    public void clickLogout() {
        logoutElement.click();
    }
}
