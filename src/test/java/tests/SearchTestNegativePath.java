package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

public class SearchTestNegativePath extends BaseTest {

    @Test
    public void shouldReturnEmptyProductListWhenSearchForNonExistingProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.searchForProduct("drill");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertEquals(0, searchResultPage.getNumberOfFoundedProducts());
    }
}
