package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void shouldReturnProductListWhenSearchForExistingProducts() {
        driver.get(BASE_URL);
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);

        List<WebElement> products = driver.findElements(By.cssSelector(".product_list .product-container"));
        Assertions.assertEquals(7, products.size());
    }
}
