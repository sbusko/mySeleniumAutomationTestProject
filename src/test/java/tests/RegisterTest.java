package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class RegisterTest extends BaseTest {

    @Test
    void shouldRegisterUserWhenMandatoryFieldsAreFilled() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        LoginPage loginPage = homePage.goToLoginPage();
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser(randomUser);

        Assertions.assertTrue(homePage.isUserLoggedIn(randomUser.firstName, randomUser.lastName));
        Assertions.assertTrue(homePage.isUserLoggedIn());
    }

    @Test
    void shouldDisplayCorrectAlertsWhenPasswordIsMissing() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        LoginPage loginPage = homePage.goToLoginPage();
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

        RegisterPage registerPage = new RegisterPage(driver);
        randomUser.password = "";
        registerPage.registerUser(randomUser);

        Assertions.assertTrue(registerPage.isAlertDisplayed("passwd is required."));
    }

    @Test
    void shouldDisplayCorrectAlertsWhenFirstNameIsMissing() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        LoginPage loginPage = homePage.goToLoginPage();
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

        RegisterPage registerPage = new RegisterPage(driver);
        randomUser.firstName = "";
        registerPage.registerUser(randomUser);

        Assertions.assertTrue(registerPage.isAlertDisplayed("firstname is required."));
    }

    @Test
    void shouldDisplayCorrectAlertsWhenLastNameIsMissing() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        LoginPage loginPage =  homePage.goToLoginPage();
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

        RegisterPage registerPage = new RegisterPage(driver);
        randomUser.lastName = "";
        registerPage.registerUser(randomUser);

        Assertions.assertTrue(registerPage.isAlertDisplayed("lastname is required."));
    }
}
