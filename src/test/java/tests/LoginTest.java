package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.BasePage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.UserAccountPage;

public class LoginTest extends BaseTest {

    @Test
    void shouldLoginUserWithMandatoryFields() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        LoginPage loginPage = homePage.goToLoginPage();
        UserAccountPage userAccountPage = loginPage.goToUserAccountPage("automationtest@test.pl", "1qaz!QAZ");

        Assertions.assertTrue(userAccountPage.isUserLoggedIn("John", "Rambo"));
    }

    @Test
    void shouldNotLoginUserWhenPasswordIsMissing() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        LoginPage loginPage = homePage.goToLoginPage();
        UserAccountPage userAccountPage = loginPage.goToUserAccountPage("automationtest@test.pl", "");

        Assertions.assertFalse(loginPage.isAlertDisplayed("password is required"));
    }

    @Test
    void shouldLogoutUser() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        LoginPage loginPage = homePage.goToLoginPage();
        UserAccountPage userAccountPage = loginPage.goToUserAccountPage("automationtest@test.pl", "1qaz!QAZ");
        userAccountPage.signUserOut();

        Assertions.assertTrue(loginPage.isUserNotLoggedIn());
    }
}
