package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

public class SearchTest extends BaseTest {

    @Test
    public void shouldReturnProductListWhenSearchForExistingProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.searchForProduct("dress");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertEquals(7, searchResultPage.getNumberOfFoundedProducts());
    }

    @Test
    public void shouldReturnEmptyProductListWhenSearchForNonExistingProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.searchForProduct("bike");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertEquals(0, searchResultPage.getNumberOfFoundedProducts());

    }
    @Test
    public void shouldDisplayRightMessageWhenSearchForExistingProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.searchForProduct("dress");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertTrue(searchResultPage.isRightSearchResultMessageDisplayed("7 results have been found."));
    }

    @Test
    public void shouldDisplayRightMessageWhenSearchForNonExistingProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.searchForProduct("bike");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertTrue(searchResultPage.isRightSearchResultMessageDisplayed("0 results have been found."));
    }
}
