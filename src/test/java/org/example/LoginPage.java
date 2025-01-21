package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#user_email")
    public WebElement emailField;

    @FindBy(css = "#user_password")
    public WebElement passwordField;

    @FindBy(css = "input[type='submit']")
    public WebElement loginButton;

    @FindBy(css = "ul.parsley-errors-list")
    public WebElement emailError;

    @FindBy(css = "ul.parsley-errors-list")
    public WebElement passwordError;

    public void openLoginPage() {
        driver.get("https://gb.ru/login");
    }

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void EmailInField(String username) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(username);
    }

    public void PasswordInField(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    private String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();
    }

    public String getEmailError() {
        return getText(emailError);
    }

    public String getPasswordError() {
        return getText(passwordError);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
