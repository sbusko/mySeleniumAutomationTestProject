package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    protected final static String BASE_URL = "http://automationpractice.com/index.php";
    protected WebDriver driver;

    @FindBy(id="search_query_top")
    WebElement searchBox;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchForProduct(String productName) {
        driver.findElement(By.id("search_query_top")).sendKeys(productName);
        driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);
    }
}
