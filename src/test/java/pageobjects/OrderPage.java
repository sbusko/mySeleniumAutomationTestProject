package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage {

    @FindBy(partialLinkText = "Proceed to checkout")
    WebElement checkoutButton;

    @FindBy(id = "email")
    WebElement userRegisteredEmail;

    @FindBy(id = "passwd")
    WebElement userRegisteredPassword;

    @FindBy(id="SubmitLogin")
    WebElement submitLoginButton;

    public OrderPage(WebDriver driver) { super(driver);
    }

    public void orderProcessSignIn(String email, String password) {
        userRegisteredEmail.sendKeys(email);
        userRegisteredPassword.sendKeys(password);
        submitLoginButton.click();
    }
}
