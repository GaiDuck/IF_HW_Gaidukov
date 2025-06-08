package org.ifellow.gaidukov.IF_HW3.steps;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.ifellow.gaidukov.IF_HW3.features.PropertyProcessor;
import org.ifellow.gaidukov.IF_HW3.pages.JiraAuthPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class JiraAuthSteps extends JiraAuthPage {
    PropertyProcessor prop = new PropertyProcessor();

    @Step
    @Description("Ввел логин и пароль, затем нажал кнопку Войти")
    public void secretAuthJiraStep() {
        String userLogin = prop.getProp("USER_LOGIN", "USER");
        String userPassword = prop.getProp("USER_PASSWORD", "USER");

        fillTextField(loginField, userLogin);
        fillTextFieldBySecretText(passwordField, userPassword);

        loginButton.shouldBe(enabled, visible).click();
    }
}
