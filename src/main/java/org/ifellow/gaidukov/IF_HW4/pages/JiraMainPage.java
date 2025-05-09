package org.ifellow.gaidukov.IF_HW4.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class JiraMainPage {
    private final SelenideElement projectsButton = $x("//a[@id='browse_link']")
            .as("кнопка Проекты");
    private final SelenideElement testProjectButton = $x("//a[@id='admin_main_proj_link_lnk']")
            .as("кнопка проекта Test(TEST)");
    private final SelenideElement taskSeach = $x("//input[@id='quickSearchInput']")
            .as("поле Поиск");
    private final SelenideElement creareNewTask = $x("//a[@id='create_link']")
            .as("кнопка Создать");
    private final SelenideElement taskTitle = $x("//input[@id='summary']")
            .as("поле Тема");
    private final SelenideElement buttonVisualDiscription = $x("//div[@id='description-wiki-edit']//button[text()='Визуальный']")
            .as("кнопка 'Визуальный' рядом с полем Описание");
    private final SelenideElement buttonVisualEnvironment = $x("//div[@id='environment-wiki-edit']//button[text()='Визуальный']")
            .as("кнопка 'Визуальный' рядом с полем Окружение");
    private final SelenideElement descriptionIframe = $x("//div[@id='description-wiki-edit']//iframe")
            .as("IFRAME 'описание'");
    private final SelenideElement environmentIframe = $x("//div[@id='environment-wiki-edit']//iframe")
            .as("IFRAME 'описание'");
    private final SelenideElement iFrameTextArea = $x("//body[@id='tinymce']")
            .as("Текстовое поле Iframe");
    private final SelenideElement versionToFix = $x("//select[@id='fixVersions']//option[@value='10001']")
            .as("Исправить в версиях");
    private final SelenideElement priority = $x("//input[@id='priority-field']")
            .as("Приоритет");
    private final SelenideElement lowPriority = $x("//li[@id='low-617']").as("Низкий приоритет");
    private final SelenideElement marks = $x("//textarea[@id='labels-textarea']")
            .as("Метки");
    private final SelenideElement affecteVersion = $x("//select[@id='versions']//option[@value='10000']")
            .as("Затронутые версии");
    private final SelenideElement affectedTask = $x("//select[@id='issuelinks-linktype']")
            .as("Затронутые задачи");
    private final SelenideElement affectedTaskOption = $x("//option[@value='duplicates']")
            .as("duplicates");
    private final SelenideElement task = $x("//textarea[@id='issuelinks-issues-textarea']")
            .as("Задача");
    private final SelenideElement assignTaskToYourselfButton = $x("//button[@data-field-id='#assignee']")
            .as("Назначить на себя");
    private final SelenideElement epicLink = $x("//input[@id='customfield_10100-field']")
            .as("Ссылка на эпик");
    private final SelenideElement selectEpic = $x("//ul[@id='предложения']/li[@id='06/jul/19-3:25-pm-15']")
            .as("Ссылка на конкретный эпик");
    private final SelenideElement sprintLink = $x("//input[@id='customfield_10104-field']")
            .as("Ссылка на спринт");
    private final SelenideElement seriousness = $x("//select[@id='customfield_10400']")
            .as("Серьезность");
    private final SelenideElement minor = $x("//option[@value='10101']")
            .as("Минорный");
    private final SelenideElement confurmCreatingNewTask = $x("//input[@id='create-issue-submit']")
            .as("кнопка Создать в окне создания задачи");
    private final SelenideElement buttonWorkInProgress = $x("//span[text()='В работе']");
    private final SelenideElement dropDownBuisnessProcess = $x("//span[text()='Бизнес-процесс']");
    private final SelenideElement buttonDone = $x("//span[text()='Выполнено']");
    private final SelenideElement taskStatus = $x("//span[@id='status-val']/span")
            .as("Статус задачи");


    public void chooseProject() {
        projectsButton.shouldBe(Condition.visible).click();
        testProjectButton.shouldBe(Condition.visible).click();
    }

    public void findTask(String taskName) {
        taskSeach.shouldBe(Condition.visible).click();
        taskSeach.sendKeys(taskName);
        taskSeach.pressEnter();
    }

    public void createNewTestTask() {
        creareNewTask.shouldBe(Condition.visible).click();
    }

    public void enterTaskTitle(String title) {
        taskTitle.shouldBe(Condition.clickable).sendKeys(title);
    }

    public void chooseVisualState() {
        if (Objects.equals(buttonVisualDiscription.getAttribute("aria-pressed"), "false")) {
            buttonVisualDiscription.shouldBe(Condition.enabled).click();
        }

        if (Objects.equals(buttonVisualEnvironment.getAttribute("aria-pressed"), "false")) {
            buttonVisualEnvironment.shouldBe(Condition.enabled).click();
        }
    }

    public void fillDescriptionTextField(String descriptionText) {
        switchTo().frame(descriptionIframe);
        iFrameTextArea.shouldBe(Condition.enabled).sendKeys(descriptionText);
        switchTo().defaultContent();
    }

    public void fillEnvironmentTextField(String environmentText) {
        switchTo().frame(environmentIframe);
        iFrameTextArea.shouldBe(Condition.enabled).sendKeys(environmentText);
        switchTo().defaultContent();
    }

    public void chooseVersionToFix() {
        versionToFix.click();
    }

    public void choosePriority(String priorityText) {
        priority.shouldBe(Condition.enabled).sendKeys(priorityText);
        priority.pressEnter();
    }

    public void chooseMark(String markText) {
        marks.shouldBe(Condition.enabled).sendKeys(markText);
        marks.pressEnter();
    }

    public void chooseAffectedVersion() {
        affecteVersion.shouldBe(Condition.clickable).click();
    }

    public void chooseAffectedTask() {
        affectedTask.shouldBe(Condition.clickable).click();
        affectedTaskOption.shouldBe(Condition.clickable).click();
    }

    public void chooseTask(String taskName) {
        task.shouldBe(Condition.enabled).sendKeys(taskName);
        buttonVisualDiscription.click();
    }

    public void assignTaskToYourSelf() {
        assignTaskToYourselfButton.shouldBe(Condition.clickable).click();
    }

    public void chooseEpic(String epic) {
        epicLink.shouldBe(Condition.clickable).sendKeys(epic);
        buttonVisualDiscription.click();
    }

    public void chooseSprint(String sprint) {
        sprintLink.shouldBe(Condition.clickable).sendKeys(sprint);
        buttonVisualDiscription.click();
    }

    public void chooseSeriousness() {
        seriousness.shouldBe(Condition.clickable).click();
        minor.shouldBe(Condition.clickable).click();
    }

    public void confurmCreatingNewTask() {
        confurmCreatingNewTask.shouldBe(Condition.clickable).click();
    }

    public void setWorkInProgressStatus() {
        buttonWorkInProgress.shouldBe(Condition.clickable).click();
    }

    public void setDoneStatus() {
        dropDownBuisnessProcess.shouldBe(Condition.clickable).click();
        buttonDone.shouldBe(Condition.clickable).click();
        Selenide.refresh();
    }

    public void assertTaskStatus(String status) {
        Assertions.assertEquals(status, taskStatus.getText());
    }
}