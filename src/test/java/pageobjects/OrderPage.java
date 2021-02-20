package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    WebElement checkoutButton;

    @FindBy(id = "email")
    WebElement userRegisteredEmail;

    @FindBy(id = "passwd")
    WebElement userRegisteredPassword;

    @FindBy(id="SubmitLogin")
    WebElement submitLoginButton;

    @FindBy(className = "alert-success")
    WebElement orderAlert;

    public OrderPage(WebDriver driver) { super(driver);
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }

    public void orderProcessSignIn(String email, String password) {
        userRegisteredEmail.sendKeys(email);
        userRegisteredPassword.sendKeys(password);
        submitLoginButton.click();
    }
    public boolean isOrderAlertDisplayed(String confirmationOrderAlertText) {
        return orderAlert.getText().contains(confirmationOrderAlertText);
    }
}
