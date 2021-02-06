package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class LoginTestPositivePath extends BaseTest {

@Test
    void shouldLoginUserWithMandatoryFields() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToMyAccountPage("bimpi@wp.pl", "softie");
        RandomUser randomUser = new RandomUser();

        MyAccountPage myAccountPage = new MyAccountPage(driver);

        Assertions.assertEquals("MY ACCOUNT", driver.
                findElement(By.xpath("//div[@id='center_column']/h1")).getText());


    }
}
