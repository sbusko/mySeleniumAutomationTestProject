package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(css = ".product_list .product-container")
    List<WebElement> products;

    @FindBy(css = "#center_column > h1 > span.heading-counter")
    WebElement searchResultMessage;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfFoundedProducts() {
        return products.size();
    }

    public boolean isRightSearchResultMessageDisplayed(String expectedMessageText) {
        return searchResultMessage.getText().contains(expectedMessageText);
    }
}
