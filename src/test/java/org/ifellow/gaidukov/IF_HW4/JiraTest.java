/*
package org.ifellow.gaidukov.IF_HW4;

import com.codeborne.selenide.Selenide;
import org.ifellow.gaidukov.IF_HW4.pages.JiraAuthPage;
import org.ifellow.gaidukov.IF_HW4.pages.JiraMainPage;
import org.ifellow.gaidukov.IF_HW4.pages.TestProjectPage;
import org.ifellow.gaidukov.IF_HW4.pages.TestTaskPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JiraTest extends WebHooks {

    private JiraAuthPage jiraAuthPage = new JiraAuthPage();
    private JiraMainPage jiraMainPage = new JiraMainPage();
    private TestProjectPage testProjectPage = new TestProjectPage();
    private TestTaskPage testTaskPage = new TestTaskPage();

    private String taskName = "TestSeleniumATHomework";
    private String taskStatus = "СДЕЛАТЬ";
    private String taskVersion = "Version 2.0";

    @Test
    @DisplayName("Авторизация в Jira")
    public void authJira() {
        jiraAuthPage.authJiraStep();
    }

    @Test
    @DisplayName("Переход в проект 'Test(TEST)'")
    public void openTestProject() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.chooseProject();
    }

    @Test
    @DisplayName("Проверка счетчика задач")
    public void checkTaskCounter() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.chooseProject();
        testProjectPage.checkThatTaskCounterWorksCorrectly();
    }

    @Test
    @DisplayName("Проверка задачи")
    public void checkTask() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.findTask(taskName);
        testTaskPage.checkTaskData(taskStatus, taskVersion);
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
}*/
