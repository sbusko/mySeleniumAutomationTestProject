package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected final static String BASE_URL = "http://automationpractice.com/index.php";
    protected WebDriver driver;

    @FindBy(id = "search_query_top")
    WebElement searchBox;

    @FindBy(className = "logout")
    WebElement signOutButton;

    @FindBy(className = "login")
    WebElement goToLoginPageButton;

    @FindBy(xpath = "//a[@class=\"account\"]/span")
    WebElement loggedUserName;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
    }

    public LoginPage goToLoginPage() {
        goToLoginPageButton.click();
        return new LoginPage(driver);
    }

    public boolean isUserLoggedIn(String firstName, String lastName) {
        Boolean signOutButtonVisible = signOutButton.isDisplayed();
        String expectedUserData = firstName + " " + lastName;
        Boolean userNameCorrectValues = expectedUserData.equals(loggedUserName.getText());
        return signOutButtonVisible && userNameCorrectValues;
    }
    public boolean isUserLoggedIn() {
        Boolean signOutButtonVisible = signOutButton.isDisplayed();
        return signOutButtonVisible;
    }
}
