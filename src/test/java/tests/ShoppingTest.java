package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.*;

public class ShoppingTest extends BaseTest {

    @Test
    public void addProductsToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        WomenProductsPage womenProductsPage = homePage.goToProductPage();
        womenProductsPage.addProductToCart();
    }

    @Test
    public void addProductToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        WomenProductsPage womenProductsPage = homePage.goToProductPage();
        womenProductsPage.addProductToCart();
        womenProductsPage.clickProceedToCheckoutButton();
        Assertions.assertEquals("1", homePage.getCartQuantity());
    }

    @Test
    public void orderProcess() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        WomenProductsPage womenProductsPage = homePage.goToProductPage();
        womenProductsPage.clickProductMoreButton();
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.selectProductSize();
    }

    @Test
    public void fullOrderProcessLoggedInUser() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.goToUserAccountPage("automationtest@test.pl", "1qaz!QAZ");
        WomenProductsPage womenProductsPage = homePage.goToProductPage();
        womenProductsPage.clickProductMoreButton();
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.changeProductQuantity();
        productDetailPage.selectProductSize();
        OrderPage orderPage= new OrderPage(driver);
        womenProductsPage.orderAllTheRest();

        Assertions.assertTrue(orderPage.isOrderAlertDisplayed("Your order on My Store is complete."));
    }
}

