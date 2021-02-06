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

        LoginPage loginPage = homePage.goToLoginPage();

        MyAccountPage myAccountPage = loginPage.goToMyAccountPage("bimpi@wp.pl", "softie");;

        Assertions.assertTrue(myAccountPage.isUserLoggedIn());
    }
}
