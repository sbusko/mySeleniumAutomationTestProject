package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.UserAccountPage;

public class LoginTest extends BaseTest {

    @Test
    void shouldLoginUserWithMandatoryFields() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        LoginPage loginPage = homePage.goToLoginPage();
        UserAccountPage userAccountPage = loginPage.goToUserAccountPage("bimpi@wp.pl", "softie");
        Assertions.assertTrue(userAccountPage.isUserLoggedIn("John", "Rambo"));
    }

    @Test
    void shouldNotLoginUserWhenPasswordIsMissing() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        LoginPage loginPage = homePage.goToLoginPage();
        UserAccountPage userAccountPage = loginPage.goToUserAccountPage("bimpi@wp.pl", "");

        Assertions.assertFalse(loginPage.isAlertDisplayed("password is required"));
    }
}
