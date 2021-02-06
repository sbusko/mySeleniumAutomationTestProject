package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class RegisterTest extends BaseTest {

    @Test
    void shouldRegisterUserWhenMandatoryFieldsAreFilled() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser(randomUser);
        Assertions.assertTrue(homePage.isUserLoggedIn());

        // jakaś asercja/asercje
        Assertions.assertEquals("Sign out", driver.findElement(By.className("logout")).getText());
        Assertions.assertEquals(randomUser.firstName + " " + randomUser.lastName,
                driver.findElement(By.xpath("//a[@class=\"account\"]/span")).getText());
    }

    @Test
    void shouldDisplayCorrectAlertsWhenMandatoryDataIsMissing() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

        RegisterPage registerPage = new RegisterPage(driver);
        randomUser.lastName = "";
        randomUser.firstName = "";
        randomUser.password = "";
        registerPage.registerUser(randomUser);

        Assertions.assertTrue(registerPage.isAlertDisplayed("passwd is required."));
        Assertions.assertTrue(registerPage.isAlertDisplayed("lastname is required."));
        Assertions.assertTrue(registerPage.isAlertDisplayed("firstname is required."));
    }
}
