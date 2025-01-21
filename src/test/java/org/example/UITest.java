package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UITest extends BaseTest {

    @Test
    void testGBNotEmailLogin() {
        LoginPage loginPage = new LoginPage(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
        loginPage.openLoginPage();

        loginPage.EmailInField("");
        loginPage.PasswordInField("");
        loginPage.clickLoginButton();

        Assertions.assertTrue(loginPage.getEmailError().contains("Обязательное поле"), " ");

        Assertions.assertTrue(loginPage.isElementDisplayed(loginPage.emailError), "Неверный email или пароль.");
    }

    @Test
    void testGBWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
        loginPage.openLoginPage();

        loginPage.PasswordInField(" ");
        loginPage.clickLoginButton();

        Assertions.assertTrue(loginPage.getPasswordError().contains("Обязательное поле"), " ");
    }
}
