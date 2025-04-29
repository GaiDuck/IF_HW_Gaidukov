package org.ifellow.gaidukov.IF_HW3;

import com.codeborne.selenide.Selenide;
import org.ifellow.gaidukov.IF_HW3.pages.JiraAuthPage;
import org.ifellow.gaidukov.IF_HW3.pages.JiraMainPage;
import org.ifellow.gaidukov.IF_HW3.pages.TestProjectPage;
import org.ifellow.gaidukov.IF_HW3.pages.TestTaskPage;
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
    public void authJira() {
        jiraAuthPage.authJiraStep();
    }

    @Test
    public void openTestProject() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.chooseProjectStep();
    }

    @Test
    public void checkTaskCounter() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.chooseProjectStep();
        testProjectPage.checkThatTaskCounterWorksCorrectly();
    }

    @Test
    public void checkTask() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.findTask(taskName);
        testTaskPage.checkTaskData(taskStatus, taskVersion);
    }

    @Test
    public void createNewTask() {
        jiraAuthPage.authJiraStep();
        jiraMainPage.createNewTestTask("Название", "Описание", "Описание", "Метка",
                "TEST-181904", "TEST-174476", "Доска Спринт 1");
        Selenide.sleep(5000);
        jiraMainPage.findTask("Название");
        jiraMainPage.changeTaskStatus();
    }
}
