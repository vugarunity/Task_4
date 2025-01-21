package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UITest extends BaseTest {

    @Test
    void testGBNotEmailLogin() {
        // Используем PageFactory для инициализации LoginPage
        LoginPage loginPage = new LoginPage(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
        loginPage.openLoginPage();


        // Вводим данные
        loginPage.EmailInField("");
        loginPage.PasswordInField("");
        loginPage.clickLoginButton();

        // Проверяем, что ошибка для email отображается с ожидаемым текстом
//        String expectedErrorMessage = "Обязательное поле.";
//        String actualErrorMessage = loginPage.getEmailError();

        Assertions.assertTrue(loginPage.getEmailError().contains("Обязательное поле"), " ");

        Assertions.assertTrue(loginPage.isElementDisplayed(loginPage.emailError), "Неверный email или пароль.");

//        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage, " ");


    }

    @Test
    void testGBWithoutPassword() {
        // Используем PageFactory для инициализации LoginPage
        LoginPage loginPage = new LoginPage(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
        loginPage.openLoginPage();

        // Вводим email и оставляем пароль пустым
        loginPage.PasswordInField(" ");
        loginPage.clickLoginButton();

        // Проверяем, отображается ли ошибка для пароля
        Assertions.assertTrue(loginPage.getPasswordError().contains("Обязательное поле"), " ");
    }
}
