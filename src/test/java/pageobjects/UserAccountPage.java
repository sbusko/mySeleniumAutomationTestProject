package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccountPage extends BasePage {

    public UserAccountPage(WebDriver driver){ super(driver); }

    public void signUserOut() {
        signOutButton.click();
    }
}
