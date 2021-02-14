package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;

public class NavigationMenuTest extends BaseTest {

    @Test
    public void allElementsOfWomenProductMenuVisible1() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.womenProductMenuDisplay();

        Assertions.assertTrue(homePage.tshirtsProductMenuVisibility());
        Assertions.assertTrue(homePage.blousesProductMenuVisibility());
        Assertions.assertTrue(homePage.casualDressesProductMenuVisibility());
    }

    @Test
    public void allElementsOfWomenProductMenuVisible2() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.womenProductMenuDisplay();

        Assertions.assertTrue(homePage.allHiddenProductMenuElementsVisible());
    }
}
