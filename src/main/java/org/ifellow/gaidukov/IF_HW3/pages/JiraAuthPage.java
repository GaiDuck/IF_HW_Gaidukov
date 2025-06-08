package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.SelenideElement;
import org.ifellow.gaidukov.IF_HW3.steps.BaseSteps;

import static com.codeborne.selenide.Selenide.$x;

public class JiraAuthPage extends BaseSteps {
    protected final SelenideElement loginField = $x("//input[@name='os_username']")
            .as("поле Логин");
    protected final SelenideElement passwordField = $x("//input[@name='os_password']")
            .as("поле Пароль");
    protected final SelenideElement loginButton = $x("//input[@class='aui-button aui-button-primary']")
            .as("кнопка Войти");
}
