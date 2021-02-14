package pageobjects;

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

    @FindBy(css = "#columns > p")
    WebElement loggedUserName;

    @FindBy(id = "newsletter-input")
    WebElement newsletterBox;

    @FindBy(name = "submitNewsletter")
    WebElement submitNewsletterButton;

    @FindBy(css = "#columns > p")
    WebElement newsletterAlert;

    //@FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
    WebElement visibleProductCategoryMenuWomen;

    @FindBy(partialLinkText = "T-shirts")
    WebElement hiddenProductMenuTshirts;

    @FindBy(partialLinkText = "Blouses")
    WebElement hiddenProductMenuBlouses;

    @FindBy(partialLinkText = "Casual Dresses")
    WebElement hiddenProductMenuCasualDresses;

    @FindBy(partialLinkText = "Evening Dresses")
    WebElement hiddenProductMenuEveningDresses;

    @FindBy(partialLinkText = "Summer Dresses")
    WebElement hiddenProductMenuSummerDresses;

    @FindBy(xpath = "//*[@id='header'']/div[3]/div/div/div[3]/div/a/span[1]")
    WebElement cartQuantity;

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

    public WomenProductsPage goToProductPage() {
         visibleProductCategoryMenuWomen.click();
         return new WomenProductsPage(driver);
    }

    public boolean isUserLoggedIn(String firstName, String lastName) {
        Boolean signOutButtonVisible = signOutButton.isDisplayed();
        String expectedUserData = firstName + " " + lastName;
        Boolean userNameCorrectValues = expectedUserData.equals(loggedUserName.getText());
        return signOutButtonVisible && userNameCorrectValues;
    }

    public boolean isUserLoggedIn(){
        Boolean signOutButtonVisible = signOutButton.isDisplayed();
        return signOutButtonVisible;
    }

    public void subscribeToNewsletter(String email) {
        newsletterBox.sendKeys(email);
        submitNewsletterButton.click();
    }

    public boolean isNewsletterAlertDisplayed(String expectedAlertText) {
        return newsletterAlert.getText().contains(expectedAlertText);
    }

    public String getCartQuantity(String expectedCartQuantity) {
        return cartQuantity.getText();
    }

}
