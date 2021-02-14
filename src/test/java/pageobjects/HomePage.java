package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class HomePage extends BasePage {

    public void openPage(){
        driver.get(BASE_URL);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void womenProductMenuDisplay() {
        Actions builder = new Actions(driver);
        builder.moveToElement(visibleProductCategoryMenuWomen).pause(2000).build().perform();
    }

    public boolean tshirtsProductMenuVisibility() {
        Boolean hiddenProductMenuVisible = hiddenProductMenuTshirts.isDisplayed();
        return hiddenProductMenuVisible;
    }

    public boolean blousesProductMenuVisibility() {
        Boolean hiddenProductMenuVisible = hiddenProductMenuBlouses.isDisplayed();
        return hiddenProductMenuVisible;
    }

    public boolean casualDressesProductMenuVisibility() {
        Boolean hiddenProductMenuVisible = hiddenProductMenuCasualDresses.isDisplayed();
        return hiddenProductMenuVisible;
    }

    public boolean allHiddenProductMenuElementsVisible() {
        Actions builder = new Actions(driver);
        builder.moveToElement(visibleProductCategoryMenuWomen).pause(2000).build().perform();
        Boolean hiddenProductMenuVisible = hiddenProductMenuTshirts.isDisplayed()
                && hiddenProductMenuBlouses.isDisplayed()
                && hiddenProductMenuCasualDresses.isDisplayed()
                && hiddenProductMenuEveningDresses.isDisplayed()
                && hiddenProductMenuSummerDresses.isDisplayed();
        return hiddenProductMenuVisible;
    }
}