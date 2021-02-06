package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "email_create")
    WebElement emailCreateNewUserBox;

    @FindBy(id = "email")
    WebElement userEmail;

    @FindBy(id = "passwd")
    WebElement userPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToRegisterPage(String email) {
        emailCreateNewUserBox.sendKeys(email);
        emailCreateNewUserBox.sendKeys(Keys.ENTER);
    }

    //public void goToMyAccountPage(String email){
   //userEmail.sendKeys(email);
    // userPassword.sendKeys(passwd)
   //     userPassword.sendKeys(Keys.ENTER);
    //}
}
