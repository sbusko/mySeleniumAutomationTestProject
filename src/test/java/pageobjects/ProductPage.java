package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(css = ".ajax_block_product")
    List<WebElement> products;

    @FindBy(partialLinkText = "Add to cart")
    List<WebElement> addToCartButton;

    @FindBy(partialLinkText = "Continue shopping")
    WebElement continueShoppingButton;

    @FindBy(partialLinkText = "Proceed to checkout")
    WebElement checkoutButton;

    @FindBy(css = "#cart_title > span")
    WebElement numberOfItemsInShoppingCart;

    public ProductPage(WebDriver driver) { super(driver); }
}
