package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class RegisterTestMissingMandatoryFieldFirstName extends BaseTest {

    @Test
    void shouldDisplayCorrectAlertsWhenMandatoryDataIsMissing() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

        RegisterPage registerPage = new RegisterPage(driver);
        randomUser.firstName = "";
        registerPage.registerUser(randomUser);

        Assertions.assertTrue(registerPage.isAlertDisplayed("firstname is required."));
    }
}
