package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import utils.RandomUser;

public class NewsletterTest extends BaseTest {

    @Test
    void subscribeToNewsletterWithValidEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        RandomUser randomUser= new RandomUser();
        homePage.subscribeToNewsletter(randomUser.email);

        Assertions.assertTrue(homePage.isNewsletterAlertDisplayed("You have successfully subscribed to this newsletter."));
    }

    @Test
    void subscribeToNewsletterWithInvalidEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        homePage.subscribeToNewsletter("qwerty");

        Assertions.assertTrue(homePage.isNewsletterAlertDisplayed("Invalid email address."));
    }

    @Test
    void subscribeToNewsletterWithAlreadyRegisteredEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        homePage.subscribeToNewsletter("automationtest@test.pl");

        Assertions.assertTrue(homePage.isNewsletterAlertDisplayed("This email address is already registered."));
    }
}
