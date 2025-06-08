package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.SelenideElement;
import org.ifellow.gaidukov.IF_HW3.steps.BaseSteps;

import static com.codeborne.selenide.Selenide.$x;

public class JiraMainPage extends BaseSteps {
    protected final SelenideElement projectsButton = $x("//a[@id='browse_link']")
            .as("кнопка Проекты");
    protected final SelenideElement taskSeach = $x("//input[@id='quickSearchInput']")
            .as("поле Поиск");
    protected final SelenideElement creareNewTask = $x("//a[@id='create_link']")
            .as("кнопка Создать");
    protected final SelenideElement taskTitle = $x("//input[@id='summary']")
            .as("поле Тема");
    protected final SelenideElement buttonVisualDiscription = $x("//div[@id='description-wiki-edit']//button[text()='Визуальный']")
            .as("кнопка 'Визуальный' рядом с полем Описание");
    protected final SelenideElement buttonVisualEnvironment = $x("//div[@id='environment-wiki-edit']//button[text()='Визуальный']")
            .as("кнопка 'Визуальный' рядом с полем Окружение");
    protected final SelenideElement descriptionIframe = $x("//div[@id='description-wiki-edit']//iframe")
            .as("IFRAME 'описание'");
    protected final SelenideElement environmentIframe = $x("//div[@id='environment-wiki-edit']//iframe")
            .as("IFRAME 'описание'");
    protected final SelenideElement iFrameTextArea = $x("//body[@id='tinymce']")
            .as("Текстовое поле Iframe");
    protected final SelenideElement versionToFix = $x("//select[@id='fixVersions']//option[@value='10001']")
            .as("Исправить в версиях");
    protected final SelenideElement priority = $x("//input[@id='priority-field']")
            .as("Приоритет");
    protected final SelenideElement marks = $x("//textarea[@id='labels-textarea']")
            .as("Метки");
    protected final SelenideElement affectedVersion = $x("//select[@id='versions']//option[@value='10000']")
            .as("Затронутые версии");
    protected final SelenideElement affectedTask = $x("//select[@id='issuelinks-linktype']")
            .as("Связанные задачи");
    protected final SelenideElement task = $x("//textarea[@id='issuelinks-issues-textarea']")
            .as("Задача");
    protected final SelenideElement assignTaskToYourselfButton = $x("//button[@data-field-id='#assignee']")
            .as("Назначить на себя");
    protected final SelenideElement epicLink = $x("//input[@id='customfield_10100-field']")
            .as("Ссылка на эпик");
    protected final SelenideElement sprintLink = $x("//input[@id='customfield_10104-field']")
            .as("Ссылка на спринт");
    protected final SelenideElement seriousness = $x("//select[@id='customfield_10400']")
            .as("Серьезность");
    protected final SelenideElement minor = $x("//option[@value='10101']")
            .as("Минорный");
    protected final SelenideElement confurmCreatingNewTask = $x("//input[@id='create-issue-submit']")
            .as("кнопка Создать в окне создания задачи");
    protected final SelenideElement buttonWorkInProgress = $x("//span[text()='В работе']");
    protected final SelenideElement dropDownBuisnessProcess = $x("//span[text()='Бизнес-процесс']");
    protected final SelenideElement buttonDone = $x("//span[text()='Выполнено']//ancestor::aui-item-link");
    protected final SelenideElement taskStatus = $x("//span[@id='status-val']/span")
            .as("Статус задачи");
    protected final SelenideElement notificationCloseButton = $x("//div[@id='aui-flag-container']//button[@class='aui-close-button']");
}