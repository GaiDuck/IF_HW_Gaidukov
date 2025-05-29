package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
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
    private final SelenideElement buttonDone = $x("//span[text()='Выполнено']//ancestor::aui-item-link");
    private final SelenideElement taskStatus = $x("//span[@id='status-val']/span")
            .as("Статус задачи");
    private final SelenideElement notificationCloseButton = $x("//div[@id='aui-flag-container']//button[@class='aui-close-button']");

    @Step("Проверил, что кнопка Проекты отображается")
    public void projectsButtonIsDisplayed() {
        projectsButton.shouldBe(visible);
    }

    @Step("Выбрать проект")
    public void chooseProjectStep() {
        projectsButton.shouldBe(visible).click();
        testProjectButton.shouldBe(visible).click();
    }

    @Step("Найти задачу")
    public void findTask(String taskName) {
        projectsButton.shouldBe(visible);
        taskSeach.shouldBe(visible).click();
        taskSeach.sendKeys(taskName);
        taskSeach.pressEnter();
    }

    @Step("Создать новую задачу")
    public void createNewTestTask(String title, String mark, String taskName,
                                  String epic, String sprint) {
        creareNewTask.shouldBe(visible).click();
        taskTitle.shouldBe(clickable).sendKeys(title);

        if (Objects.equals(buttonVisualDiscription.getAttribute("aria-pressed"), "false")) {
            buttonVisualDiscription.click();
        }

        switchTo().frame(descriptionIframe);
        iFrameTextArea.shouldBe(enabled).sendKeys("Описание");
        switchTo().defaultContent();
        versionToFix.click();
        priority.shouldBe(enabled).sendKeys("Low");
        priority.pressEnter();
        marks.shouldBe(enabled).sendKeys(mark);
        marks.pressEnter();
        buttonVisualEnvironment.shouldBe(visible).scrollIntoView(true).click();
        switchTo().frame(environmentIframe);
        iFrameTextArea.shouldBe(enabled).sendKeys("Окружение");
        switchTo().defaultContent();
        affecteVersion.shouldBe(clickable).click();
        affectedTask.shouldBe(clickable).click();
        affectedTaskOption.shouldBe(clickable).click();
        task.shouldBe(clickable).sendKeys(taskName);
        buttonVisualDiscription.click();
        assignTaskToYourselfButton.shouldBe(clickable).click();
        epicLink.shouldBe(clickable).sendKeys(epic);
        buttonVisualDiscription.click();
        sprintLink.shouldBe(clickable).sendKeys(sprint);
        buttonVisualDiscription.click();
        seriousness.shouldBe(clickable).click();
        minor.shouldBe(clickable).click();
        confurmCreatingNewTask.shouldBe(clickable).click();
    }

    @Step("Поменять статус задачи")
    public void changeTaskStatus() {
        buttonWorkInProgress.shouldBe(clickable).click();
        for (int i = 0; i < 1500; i++) {
            if (!taskStatus.getText().equals("В РАБОТЕ")) {
                Selenide.sleep(10);
            } else if (taskStatus.getText().equals("В РАБОТЕ")) {
                break;
            }
        }
        if (notificationCloseButton.isDisplayed()) {
            notificationCloseButton.click();
        }
        dropDownBuisnessProcess.shouldBe(clickable).click();
        buttonDone.shouldBe(clickable, Duration.ofMillis(1000)).click();
        Selenide.refresh();
        Assertions.assertEquals("ГОТОВО", taskStatus.getText());
    }
}