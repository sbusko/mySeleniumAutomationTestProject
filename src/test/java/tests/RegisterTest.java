package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.RandomUser;

public class RegisterTest extends BaseTest {

    @Test
    void shouldRegisterUserWhenMandatoryFieldsAreFilled() {
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
        driver.findElement(By.id("customer_lastname")).sendKeys(randomUser.lastName);
        driver.findElement(By.id("passwd")).sendKeys(randomUser.password);
        driver.findElement(By.id("address1")).sendKeys(randomUser.address1);
        driver.findElement(By.id("city")).sendKeys(randomUser.city);
        driver.findElement(By.id("postcode")).sendKeys(randomUser.postalCode);
        driver.findElement(By.id("phone_mobile")).sendKeys(randomUser.phoneNumber);

        WebElement selectElement = driver.findElement(By.id("id_state"));
        Select selectList = new Select(selectElement);
        selectList.selectByValue("2");

        // wyślij formularz
        driver.findElement(By.id("submitAccount")).click();

        // jakaś asercja/asercje
        Assertions.assertEquals("Sign out", driver.findElement(By.className("logout")).getText());
        Assertions.assertEquals(randomUser.firstName + " " + randomUser.lastName,
                driver.findElement(By.xpath("//a[@class=\"account\"]/span")).getText());
    }
}
