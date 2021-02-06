package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

public class SearchTestPositivePath extends BaseTest {

    @Test
    public void shouldReturnProductListWhenSearchForExistingProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.searchForProduct("dress");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertEquals(7, searchResultPage.getNumberOfFoundedProducts());
    }
}
