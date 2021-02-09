package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "email_create")
    WebElement emailCreateNewUserBox;

    @FindBy(id = "email")
    WebElement userRegisteredEmail;

    @FindBy(id = "passwd")
    WebElement userRegisteredPassword;

    @FindBy(id="SubmitLogin")
    WebElement submitLoginButton;

    @FindBy(css = ".alert >ol")
    WebElement failAlert;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAlertDisplayed(String expectedAlertText) {
        return failAlert.getText().contains(expectedAlertText);
    }

    public void goToRegisterPage(String email) {
        emailCreateNewUserBox.sendKeys(email);
        emailCreateNewUserBox.sendKeys(Keys.ENTER);
    }

    public UserAccountPage goToUserAccountPage(String email, String password) {
        userRegisteredEmail.sendKeys(email);
        userRegisteredPassword.sendKeys(password);
        submitLoginButton.click();
        return new UserAccountPage(driver);
    }
}
