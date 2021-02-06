package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class LoginTestPositivePath extends BaseTest {

@Test
    void shouldLoginUserWithMandatoryFields

    {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();

        loginPage.goToMyAccountPage(randomUser);
        randomUser.email = "bimpi@wp.pl";
        randomUser.password = "softie";


    }

    LoginPage loginPage = new LoginPage(driver);
    RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

    RegisterPage registerPage = new RegisterPage(driver);
    randomUser.lastName = "";
        registerPage.registerUser(randomUser);
}
