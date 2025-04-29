package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;

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
    private final SelenideElement textFieldDiscription = $x("//div[@id='description-wiki-edit']//textarea")
            .as("текстовое поле Описание");
    private final SelenideElement textFieldEnvironment = $x("//body[@id='tinymce']")
            .as("текстовое поле Окружение");
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


    public void chooseProjectStep() {
        projectsButton.shouldBe(Condition.visible).click();
        testProjectButton.shouldBe(Condition.visible).click();
    }

    public void findTask(String taskName) {
        projectsButton.shouldBe(Condition.visible);
        taskSeach.shouldBe(Condition.visible).click();
        taskSeach.sendKeys(taskName);
        taskSeach.pressEnter();
    }

    public void createNewTestTask(String title, String discription, String environment, String mark, String taskName,
                                  String epic, String sprint) {
        creareNewTask.shouldBe(Condition.visible).click();
        taskTitle.shouldBe(Condition.clickable).sendKeys(title);

        if (Objects.equals(buttonVisualDiscription.getAttribute("aria-pressed"), "false")) {
            buttonVisualDiscription.click();
        }

        textFieldDiscription.sendKeys(discription);
        versionToFix.click();
        priority.shouldBe(Condition.enabled).sendKeys("Low");
        priority.pressEnter();
        marks.shouldBe(Condition.enabled).sendKeys(mark);
        marks.pressEnter();
        buttonVisualEnvironment.shouldBe(Condition.visible).scrollIntoView(true).click();
        //textFieldEnvironment.shouldBe(Condition.enabled).sendKeys(environment);
        affecteVersion.shouldBe(Condition.clickable).click();
        affectedTask.shouldBe(Condition.clickable).click();
        affectedTaskOption.shouldBe(Condition.clickable).click();
        task.shouldBe(Condition.clickable).sendKeys(taskName);
        assignTaskToYourselfButton.shouldBe(Condition.clickable).click();
        epicLink.shouldBe(Condition.clickable).sendKeys(epic);
        sprintLink.shouldBe(Condition.clickable).sendKeys(sprint);
        seriousness.shouldBe(Condition.clickable).click();
        minor.shouldBe(Condition.clickable).click();
        confurmCreatingNewTask.shouldBe(Condition.clickable).click();
    }

    public void changeTaskStatus() {
        buttonWorkInProgress.shouldBe(Condition.enabled).click();
        dropDownBuisnessProcess.shouldBe(Condition.enabled).click();
        buttonDone.shouldBe(Condition.enabled).click();
        Selenide.refresh();
        Assertions.assertEquals("ГОТОВО", taskStatus.getText());
    }
}