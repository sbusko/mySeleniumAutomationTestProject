package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage extends BasePage {

    @FindBy(id = "quantity_wanted")
    WebElement productQuantity;

    @FindBy(xpath = "//*[@id='group_1']")
    WebElement productSize;

    public ProductDetailPage(WebDriver driver) { super(driver);
    }

    public void changeProductQuantity() {
        productQuantity.clear();
        productQuantity.sendKeys("2");
    }

    public void selectProductSize() {
        Select productSizeSelect = new Select(productSize);
        productSizeSelect.selectByVisibleText("M");
    }
}
