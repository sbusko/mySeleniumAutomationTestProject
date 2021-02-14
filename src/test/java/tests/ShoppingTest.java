package tests;

import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.WomenProductsPage;

public class ShoppingTest extends BaseTest {

    @Test
    public void addProductsToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        WomenProductsPage womenProductsPage = homePage.goToProductPage();
    }

    @Test
    public void orderProcess() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        WomenProductsPage womenProductsPage = homePage.goToProductPage();
        womenProductsPage.productMoreInfo();
        womenProductsPage.changeProductQuantity();
        womenProductsPage.selectProductSize();
    }

    @Test
    public void orderProcess2() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        WomenProductsPage womenProductsPage = homePage.goToProductPage();
        womenProductsPage.addProductToCart();

        //Assertions.assertEquals("1", homePage.getCartQuantity("1"));
    }
}

