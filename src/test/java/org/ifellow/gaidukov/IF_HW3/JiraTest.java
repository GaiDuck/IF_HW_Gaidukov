package org.ifellow.gaidukov.IF_HW3;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import org.ifellow.gaidukov.IF_HW3.hooks.WebHooks;
import org.ifellow.gaidukov.IF_HW3.pages.JiraMainPage;
import org.ifellow.gaidukov.IF_HW3.pages.TestProjectPage;
import org.ifellow.gaidukov.IF_HW3.pages.TestTaskPage;
import org.ifellow.gaidukov.IF_HW3.steps.AuthSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Тестирование Jira")
public class JiraTest extends WebHooks {

    private final AuthSteps authSteps = new AuthSteps();
    private final JiraMainPage jiraMainPage = new JiraMainPage();
    private final TestProjectPage testProjectPage = new TestProjectPage();
    private final TestTaskPage testTaskPage = new TestTaskPage();

    @Test
    @DisplayName("Авторизация в Jira")
    public void authJira() {
        authSteps.secretAuthJiraStep();
        jiraMainPage.projectsButtonIsDisplayed();
    }

    @Test
    @DisplayName("Переход в проект 'Test(TEST)'")
    public void openTestProject() {
        authSteps.secretAuthJiraStep();
        jiraMainPage.chooseProjectStep();
    }

    @Test
    @DisplayName("Проверка счетчика задач")
    public void checkTaskCounter() {
        authSteps.secretAuthJiraStep();
        jiraMainPage.chooseProjectStep();
        testProjectPage.checkThatTaskCounterWorksCorrectly();
    }

    @Test
    @DisplayName("Проверка задачи")
    public void checkTask() {
        authSteps.secretAuthJiraStep();
        jiraMainPage.findTask("TestSeleniumATHomework");
        testTaskPage.checkTaskData();
    }

    @Test
    @DisplayName("Создание задачи")
    public void createNewTask() {
        authSteps.secretAuthJiraStep();
        jiraMainPage.createNewTestTask("Название", "Метка",
                "TEST-181904", "TEST-174476", "Доска Спринт 1");
        Selenide.refresh();
        jiraMainPage.findTask("Название");
        jiraMainPage.changeTaskStatus();
    }
}