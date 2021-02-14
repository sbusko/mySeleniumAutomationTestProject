package tests;

import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.ProductPage;

public class ShoppingTest extends BaseTest {

    @Test
    public void addProductsToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        ProductPage productPage = homePage.goToShoppingPage();
    }


}

