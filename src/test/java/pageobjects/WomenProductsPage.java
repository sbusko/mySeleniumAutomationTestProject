package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WomenProductsPage extends BasePage {

    @FindBy(css = ".ajax_block_product")
    List<WebElement> products;

    @FindBy(partialLinkText = "Add to cart")
    List<WebElement> addToCartButtons;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a[1]")
    WebElement addBlouseProductToCartButton;

    //@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]")
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img")
    WebElement blouseProduct;

    @FindBy(xpath = "/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]")
    WebElement blouseProductMoreButton;

    @FindBy(partialLinkText = "Continue shopping")
    WebElement continueShoppingButton;

    @FindBy(partialLinkText = "Proceed to checkout")
    WebElement checkoutButton;

    @FindBy(id = "quantity_wanted")
    WebElement productQuantity;

    @FindBy(xpath = "//*[@id='group_1']")
    WebElement productSize;

    public WomenProductsPage(WebDriver driver) { super(driver); }

    public void addProductToCart() {
        Actions builder = new Actions(driver);
        builder.moveToElement(blouseProduct).moveToElement(addBlouseProductToCartButton).click().perform();
    }

    public void productMoreInfo() {
        Actions builder = new Actions(driver);
        builder.moveToElement(blouseProduct).moveToElement(blouseProductMoreButton).click().perform();
    }

    public void proceedToOrder() {
        checkoutButton.click();
    }

    public void changeProductQuantity() {
        productQuantity.clear();
        productQuantity.sendKeys("2");
    }

    public void selectProductSize() {
        Select productSizeSelect = new Select(productSize);
        productSizeSelect.selectByVisibleText("M");
    }

    public void orderAllTheRest() {
        driver.findElement(By.id("color_11")).click();

        //Click on add to cart
        driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();

        //Click on proceed
        driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();
        //Checkout page Proceed
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
        //Agree terms&Conditions
        driver.findElement(By.xpath("//*[@id='cgv']")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();

        //Click on Payby Check
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
        //Confirm the order
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

        //Get Text
        String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();
        }
}
