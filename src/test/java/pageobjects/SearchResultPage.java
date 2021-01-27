package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage {


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfFoundProducts() {
        List<WebElement> products = driver.findElements(By.cssSelector(".product_list .product-container"));
        return products.size();
    }
}
