package org.ifellow.gaidukov.IF_HW3.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.ifellow.gaidukov.IF_HW3.pages.JiraTaskPage;
import org.junit.jupiter.api.Assertions;

public class JiraTaskSteps extends JiraTaskPage {
    @Step("Проверить статус и версию задачи")
    public void checkTaskData() {
        taskStatus.shouldBe(Condition.visible);
        Assertions.assertEquals("СДЕЛАТЬ", taskStatus.getText());
        taskVersion.shouldBe(Condition.visible);
        Assertions.assertEquals("Version 2.0", taskVersion.getText());
    }
}
