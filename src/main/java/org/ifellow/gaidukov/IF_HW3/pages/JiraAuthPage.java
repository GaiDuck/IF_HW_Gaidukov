package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.ifellow.gaidukov.IF_HW3.PropertyProcessor.PropertyProcessor;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class JiraAuthPage {

    private final SelenideElement loginField = $x("//input[@name='os_username']")
            .as("поле Логин");
    private final SelenideElement passwordField = $x("//input[@name='os_password']")
            .as("поле Пароль");
    private final SelenideElement loginButton = $x("//input[@class='aui-button aui-button-primary']")
            .as("кнопка Войти");

    PropertyProcessor prop = new PropertyProcessor();

    @Step("Авторизация в Jira")
    public void authJiraStep() {
        Assertions.assertTrue(loginField.isDisplayed());
        loginField.click();
        loginField.sendKeys(prop.getProp("USER_LOGIN"));

        Assertions.assertTrue(passwordField.isDisplayed());
        passwordField.click();
        passwordField.sendKeys(prop.getProp("USER_PASSWORD"));

        Assertions.assertTrue(loginButton.isDisplayed());
        loginButton.click();
    }
}
