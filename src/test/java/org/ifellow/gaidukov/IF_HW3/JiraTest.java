package org.ifellow.gaidukov.IF_HW3;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import org.ifellow.gaidukov.IF_HW3.pages.JiraAuthPage;
import org.ifellow.gaidukov.IF_HW3.pages.JiraMainPage;
import org.ifellow.gaidukov.IF_HW3.pages.TestProjectPage;
import org.ifellow.gaidukov.IF_HW3.pages.TestTaskPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Тестирование Jira")
public class JiraTest extends WebHooks {

    private final JiraAuthPage jiraAuthPage = new JiraAuthPage();
    private final JiraMainPage jiraMainPage = new JiraMainPage();
    private final TestProjectPage testProjectPage = new TestProjectPage();
    private final TestTaskPage testTaskPage = new TestTaskPage();

    @Test
    @DisplayName("Авторизация в Jira")
    public void authJira() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.projectsButtonIsDisplayed();
    }

    @Test
    @DisplayName("Переход в проект 'Test(TEST)'")
    public void openTestProject() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.chooseProjectStep();
    }

    @Test
    @DisplayName("Проверка счетчика задач")
    public void checkTaskCounter() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.chooseProjectStep();
        testProjectPage.checkThatTaskCounterWorksCorrectly();
    }

    @Test
    @DisplayName("Проверка задачи")
    public void checkTask() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.findTask("TestSeleniumATHomework");
        testTaskPage.checkTaskData();
    }

    @Test
    @DisplayName("Создание задачи")
    public void createNewTask() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.createNewTestTask("Название", "Метка",
                "TEST-181904", "TEST-174476", "Доска Спринт 1");
        Selenide.refresh();
        jiraMainPage.findTask("Название");
        jiraMainPage.changeTaskStatus();
    }
}