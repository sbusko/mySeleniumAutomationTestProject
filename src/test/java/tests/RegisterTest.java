package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.RandomUser;

public class RegisterTest extends BaseTest {

    @Test
    void shouldRegisterUserWhenMandatoryFieldsAreFilled(){
        driver.get(BASE_URL);
        // przejdź do login/register
        driver.findElement(By.className("login")).click();

        // utwórz losowego użytkownika
        RandomUser randomUser = new RandomUser();
        // zaloguj dane użytkownika
        System.out.println(randomUser);

        driver.findElement(By.id("email_create")).sendKeys(randomUser.email);
        driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);

        driver.findElement(By.id("customer_firstname")).sendKeys(randomUser.firstName);
        driver.findElement(By.id("customer_firstname")).sendKeys(randomUser.lastName);

        // uzupełnij resztę wymaganych pól
        // uzupełnij resztę wymaganych pól
        // uzupełnij resztę wymaganych pól

        // wyślij formularz
        driver.findElement(By.id("submitAccount")).click();

        // jakaś asercja/asercje

    }
}
