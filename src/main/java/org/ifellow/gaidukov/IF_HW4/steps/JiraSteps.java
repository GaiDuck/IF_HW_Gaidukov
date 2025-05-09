package org.ifellow.gaidukov.IF_HW4.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.ifellow.gaidukov.IF_HW4.pages.JiraAuthPage;
import org.ifellow.gaidukov.IF_HW4.pages.JiraMainPage;
import org.ifellow.gaidukov.IF_HW4.pages.TestProjectPage;
import org.ifellow.gaidukov.IF_HW4.pages.TestTaskPage;

public class JiraSteps {

    JiraAuthPage jiraAuthPage = new JiraAuthPage();
    JiraMainPage jiraMainPage = new JiraMainPage();
    TestProjectPage testProjectPage = new TestProjectPage();
    TestTaskPage testTaskPage = new TestTaskPage();

    @Когда("^Залогинился в системе Jira")
    public void authJira() {
        jiraAuthPage.enterLogin();
        jiraAuthPage.enterPassword();
        jiraAuthPage.loginButtonClick();
    }

    @Когда("^Перешел в проект Test")
    public void chooseProject() {
        jiraMainPage.chooseProject();
    }

    @Когда("^Нашел задачу '(.*)'")
    public void findTask(String taskName) {
        jiraMainPage.findTask(taskName);
    }

    @Тогда("^Проверил, что статус задачи - '(.*)', версия задачи - '(.*)'")
    public void checkTaskData(String taskStatus, String taskVersion) {
        testTaskPage.checkTaskData(taskStatus, taskVersion);
    }

    @Когда("^Открыл окно создания новой задачи и заполнил поле Название текстом '(.*)'")
    public void CreateNewTask(String title) {
        jiraMainPage.createNewTestTask();
        jiraMainPage.enterTaskTitle(title);
    }

    @Когда("^Установил кнопки около текстовых полей Описание и Окружение в положение Визуальный")
    public void setVisualState() {
        jiraMainPage.chooseVisualState();
    }

    @Когда("^Заполнил поля Описание текстом '(.*)' и Окружение текстом '(.*)'")
    public void fillDescriptionField(String descriptionText, String environmentText) {
        jiraMainPage.fillDescriptionTextField(descriptionText);
        jiraMainPage.fillEnvironmentTextField(environmentText);
    }

    @Когда("^Выбрал Исправить в версии 1.0")
    public void chooseVersionToFix() {
        jiraMainPage.chooseVersionToFix();
    }

    @Когда("^Выбрал приоритет '(.*)'")
    public void setPriority(String priority) {
        jiraMainPage.choosePriority(priority);
    }

    @Когда("^Выбрал метку '(.*)'")
    public void setMark(String mark) {
        jiraMainPage.chooseMark(mark);
    }

    @Когда("^Выбрал задействованные версии и выбрал задачу '([A-Z]{4})-([0-9]{6})' и назначил задачу на себя")
    public void setAffected(String taskName) {
        jiraMainPage.chooseAffectedVersion();
        jiraMainPage.chooseAffectedTask();
        jiraMainPage.chooseTask(taskName);
        jiraMainPage.assignTaskToYourSelf();
    }

    @Когда("^Выбрал эпик '([A-Z]{4})-([0-9]{6})'")
    public void setEpic(String epic) {
        jiraMainPage.chooseEpic(epic);
    }

    @Когда("^Выбрал спринт (.*)")
    public void setSprint(String sprint) {
        jiraMainPage.chooseSprint(sprint);
    }

    @Когда("^Выбрал минорную серьезность")
    public void setSeriousness() {
        jiraMainPage.chooseSeriousness();
    }

    @Тогда("^Подтвердил создание задачи")
    public void confirmCreatingNewTask() {
        jiraMainPage.confurmCreatingNewTask();
        Selenide.refresh();
    }

    @Когда("^Нашел задачу '(.*)'")
    public void findTaskByTitle(String taskTitle) {
        jiraMainPage.findTask(taskTitle);
    }

    @Когда("^Установил статус В РАБОТЕ")
    public void setWorkInProgress() {
        jiraMainPage.setWorkInProgressStatus();
    }

    @Когда("^Установил статус ГОТОВО")
    public void setDone() {
        jiraMainPage.setDoneStatus();
    }

    @Тогда("^Проверил, что статус задачи '(.*)'")
    public void assertStatus(String status) {
        jiraMainPage.assertTaskStatus(status);
    }

    @Когда("^Сбросил счетчик задач и записал текущее значение счетчика задач")
    public void getFirstNumberOfTasks() {
        testProjectPage.discardNumbersOfTasks();
        testProjectPage.setFirstNumberOfTasks();
    }

    @Когда("^Считал счетчик после создания новой задачи")
    public void getSecondNumberOfTasks() {
        testProjectPage.setSecondNumberOfTasks();
    }

    @Тогда("^Проверил, что счетчик увеличился")
    public void checkCounterIncrease() {
        testProjectPage.assertThatSecondNumberIsBigger();
    }
}
