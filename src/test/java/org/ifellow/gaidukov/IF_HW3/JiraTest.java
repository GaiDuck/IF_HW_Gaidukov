package org.ifellow.gaidukov.IF_HW3;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import org.ifellow.gaidukov.IF_HW3.PropertyProcessor.PropertyProcessor;
import org.ifellow.gaidukov.IF_HW3.pages.JiraAuthPage;
import org.ifellow.gaidukov.IF_HW3.pages.JiraMainPage;
import org.ifellow.gaidukov.IF_HW3.pages.TestProjectPage;
import org.ifellow.gaidukov.IF_HW3.pages.TestTaskPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Тестирование Jira")
public class JiraTest extends WebHooks {

    private JiraAuthPage jiraAuthPage = new JiraAuthPage();
    private JiraMainPage jiraMainPage = new JiraMainPage();
    private TestProjectPage testProjectPage = new TestProjectPage();
    private TestTaskPage testTaskPage = new TestTaskPage();

    PropertyProcessor userProp = new PropertyProcessor();

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
        jiraMainPage.createNewTestTask("Название", "Описание", "Описание", "Метка",
                "TEST-181904", "TEST-174476", "Доска Спринт 1");
        Selenide.refresh();
        jiraMainPage.findTask("Название");
        jiraMainPage.changeTaskStatus();
    }
}