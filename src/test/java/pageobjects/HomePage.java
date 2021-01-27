package pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        driver.get(BASE_URL);
    }
}
