package org.ifellow.gaidukov.IF_HW3.steps;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.ifellow.gaidukov.IF_HW3.features.PropertyProcessor;
import org.ifellow.gaidukov.IF_HW3.pages.JiraAuthPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.SetValueOptions.withText;

public class AuthSteps extends JiraAuthPage {
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
