package org.ifellow.gaidukov.IF_HW3;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import org.ifellow.gaidukov.IF_HW3.features.PropertyProcessor;
import org.ifellow.gaidukov.IF_HW3.hooks.WebHooks;
import org.ifellow.gaidukov.IF_HW3.steps.JiraAuthSteps;
import org.ifellow.gaidukov.IF_HW3.steps.JiraMainSteps;
import org.ifellow.gaidukov.IF_HW3.steps.JiraProjectSteps;
import org.ifellow.gaidukov.IF_HW3.steps.JiraTaskSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Тестирование Jira")
public class JiraTest extends WebHooks {

    private final JiraAuthSteps jiraAuthSteps = new JiraAuthSteps();
    private final JiraMainSteps jiraMainSteps = new JiraMainSteps();
    private final JiraProjectSteps jiraProjectSteps = new JiraProjectSteps();
    private final JiraTaskSteps jiraTaskSteps = new JiraTaskSteps();

    PropertyProcessor prop = new PropertyProcessor();

    private final String testTaskName = prop.getProp("TASK_TITLE", "TEST_TASK");
    private final String title = prop.getProp("TASK_TITLE", "TASK");
    private final String description = prop.getProp("TASK_DESCRIPTION", "TASK");
    private final String taskPriority = prop.getProp("TASK_PRIORITY", "TASK");
    private final String mark = prop.getProp("TASK_MARK", "TASK");
    private final String taskName = prop.getProp("TASK_AFFECTED", "TASK");
    private final String environment = prop.getProp("TASK_ENVIRONMENT", "TASK");
    private final String affectedTaskName = prop.getProp("TASK_RELATED", "TASK");
    private final String epic = prop.getProp("TASK_EPIC", "TASK");
    private final String sprint = prop.getProp("TASK_SPRINT", "TASK");
    private final String taskSeriousness = prop.getProp("TASK_SERIOUSNESS", "TASK");

    @Test
    @DisplayName("Авторизация в Jira")
    public void authJira() {
        jiraAuthSteps.secretAuthJiraStep();
        jiraMainSteps.projectsButtonIsDisplayed();
    }

    @Test
    @DisplayName("Переход в проект 'Test(TEST)'")
    public void openTestProject() {
        jiraAuthSteps.secretAuthJiraStep();
        jiraMainSteps.chooseProjectStep();
    }

    @Test
    @DisplayName("Проверка счетчика задач")
    public void checkTaskCounter() {
        jiraAuthSteps.secretAuthJiraStep();
        jiraMainSteps.chooseProjectStep();
        jiraProjectSteps.checkThatTaskCounterWorksCorrectly();
    }

    @Test
    @DisplayName("Проверка задачи")
    public void checkTask() {
        jiraAuthSteps.secretAuthJiraStep();
        jiraMainSteps.projectsButtonIsDisplayed();
        jiraMainSteps.findTask(testTaskName);
        jiraTaskSteps.checkTaskData();
    }

    @Test
    @DisplayName("Создание задачи")
    public void createNewTask() {
        jiraAuthSteps.secretAuthJiraStep();
        jiraMainSteps.createNewTestTask(title, description, taskPriority, mark, taskName, environment, affectedTaskName, epic, sprint, taskSeriousness);
        Selenide.refresh();
        jiraMainSteps.findTask(title);
        jiraMainSteps.changeTaskStatus();
    }
}