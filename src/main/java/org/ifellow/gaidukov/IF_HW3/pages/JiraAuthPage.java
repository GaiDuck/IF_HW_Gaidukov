package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class JiraAuthPage {
    private final SelenideElement loginField = $x("//input[@name='os_username']")
            .as("поле Логин");
    private final SelenideElement passwordField = $x("//input[@name='os_password']")
            .as("поле Пароль");
    private final SelenideElement loginButton = $x("//input[@class='aui-button aui-button-primary']")
            .as("кнопка Войти");

    private static final String USER_LOGIN = "AT10";
    private static final String USER_PASSWORD = "Qwerty123";

    public void authJiraStep() {
        Assertions.assertTrue(loginField.isDisplayed());
        loginField.click();
        loginField.sendKeys(USER_LOGIN);

        Assertions.assertTrue(passwordField.isDisplayed());
        passwordField.click();
        passwordField.sendKeys(USER_PASSWORD);

        Assertions.assertTrue(loginButton.isDisplayed());
        loginButton.click();
    }
}
