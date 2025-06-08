package org.ifellow.gaidukov.IF_HW3.steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.ifellow.gaidukov.IF_HW3.pages.JiraProjectPage;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class JiraProjectSteps extends JiraProjectPage {

    @Step("Проверить корректность работы счетчика задач")
    public void checkThatTaskCounterWorksCorrectly() {

        currentNumberOfAllNumbers.shouldBe(enabled, visible);

        int firstNumberOfTasks = Integer.parseInt(currentNumberOfAllNumbers.getText().split(" ")[2]);
        creareNewTask.shouldBe(enabled, visible).click();
        fillTextField(taskTitle, "testTitle");
        confurmCreatingNewTask.shouldBe(enabled, visible).click();

        Selenide.refresh();
        currentNumberOfAllNumbers.shouldBe(enabled, visible);
        int secondNumberOfTasks = Integer.parseInt(currentNumberOfAllNumbers.getText().split(" ")[2]);

        Assertions.assertTrue(secondNumberOfTasks > firstNumberOfTasks);
    }
}
