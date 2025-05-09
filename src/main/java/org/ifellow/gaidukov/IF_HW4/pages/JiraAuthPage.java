package org.ifellow.gaidukov.IF_HW4.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraAuthPage {
    public final SelenideElement loginField = $x("//input[@name='os_username']")
            .as("поле Логин");
    private final SelenideElement passwordField = $x("//input[@name='os_password']")
            .as("поле Пароль");
    private final SelenideElement loginButton = $x("//input[@class='aui-button aui-button-primary']")
            .as("кнопка Войти");

    private static final String USER_LOGIN = "AT10";
    private static final String USER_PASSWORD = "Qwerty123";

    public void enterLogin() {
        loginField.shouldBe(Condition.enabled).sendKeys(USER_LOGIN);
    }

    public void enterPassword() {
        passwordField.shouldBe(Condition.enabled).sendKeys(USER_PASSWORD);
    }

    public void loginButtonClick() {
        loginButton.shouldBe(Condition.clickable).click();
    }
}
