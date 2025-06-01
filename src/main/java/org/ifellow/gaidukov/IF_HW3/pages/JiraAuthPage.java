package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.ifellow.gaidukov.IF_HW3.features.PropertyProcessor;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.SetValueOptions.withText;

public class JiraAuthPage {
    private final SelenideElement loginField = $x("//input[@name='os_username']")
            .as("поле Логин");
    private final SelenideElement passwordField = $x("//input[@name='os_password']")
            .as("поле Пароль");
    private final SelenideElement loginButton = $x("//input[@class='aui-button aui-button-primary']")
            .as("кнопка Войти");

    PropertyProcessor prop = new PropertyProcessor();

    @Step
    @Description("Ввел логин и пароль, затем нажал кнопку Войти")
    public void secretAuthJiraStep() {
        loginField.shouldBe(enabled, visible).setValue(prop.getProp("USER_LOGIN", "USER"));
        passwordField.shouldBe(enabled, visible).
                setValue(withText(prop.getProp("USER_PASSWORD", "USER")).sensitive());
        loginButton.shouldBe(enabled, visible).click();
    }
}
