package org.ifellow.gaidukov.IF_HW3.steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.ifellow.gaidukov.IF_HW3.pages.JiraMainPage;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;

public class JiraMainSteps extends JiraMainPage {
    @Step("Проверить, что кнопка Проекты отображается")
    public void projectsButtonIsDisplayed() {
        projectsButton.shouldBe(visible);
    }

    @Step("Выбрать проект")
    public void chooseProjectStep() {
        chooseElementFromDropdownByText(projectsButton, "Test (TEST)");
    }

    @Step("Найти задачу")
    public void findTask(String taskName) {
        searchByText(taskSeach, taskName);
    }

    @Step("Создать новую задачу")
    public void createNewTestTask(String title, String description, String taskPriority,
                                  String mark, String taskName, String environment,
                                  String affectedTaskName, String epic, String sprint,
                                  String taskSeriousness) {

        creareNewTask.shouldBe(visible).click();
        fillTextField(taskTitle, title);
        checkRadiobuttonIsPressed(buttonVisualDiscription);
        fillIFrameTextField(descriptionIframe, iFrameTextArea, description);
        versionToFix.click();
        fillTextFiedWithDropdown(priority, taskPriority);
        fillTextFiedWithDropdown(marks, mark);
        buttonVisualEnvironment.shouldBe(visible).scrollIntoView(true).click();
        fillIFrameTextField(environmentIframe, iFrameTextArea, environment);
        affectedVersion.shouldBe(clickable).click();
        chooseElementFromDropdownByText(affectedTask, affectedTaskName);
        fillTextFiedWithDropdown(task, taskName);
        assignTaskToYourselfButton.shouldBe(clickable).click();
        fillTextFiedWithDropdown(epicLink, epic);
        fillTextFiedWithDropdown(sprintLink, sprint);
        buttonVisualDiscription.click();
        chooseElementFromDropdownByText(seriousness, taskSeriousness);
        confurmCreatingNewTask.shouldBe(clickable).click();
    }

    @Step("Поменять статус задачи")
    public void changeTaskStatus() {
        buttonWorkInProgress.shouldBe(clickable).click();
        waitForValueChange(taskStatus, "В РАБОТЕ");
        if (notificationCloseButton.isDisplayed() && notificationCloseButton.isEnabled()) {
            notificationCloseButton.click();
        }
        dropDownBuisnessProcess.shouldBe(clickable).click();
        buttonDone.shouldBe(clickable, Duration.ofMillis(1000)).click();
        Selenide.refresh();
        Assertions.assertEquals("ГОТОВО", taskStatus.getText());
    }
}
