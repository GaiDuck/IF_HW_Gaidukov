package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.SelenideElement;
import org.ifellow.gaidukov.IF_HW3.steps.BaseSteps;

import static com.codeborne.selenide.Selenide.$x;

public class JiraProjectPage extends BaseSteps {
    protected final SelenideElement currentNumberOfAllNumbers = $x("//div[@class='showing']")
            .as("номер текущей задачи из общего числа задач");
    protected final SelenideElement creareNewTask = $x("//a[@id='create_link']")
            .as("кнопка Создать");
    protected final SelenideElement taskTitle = $x("//input[@id='summary']")
            .as("поле Тема");
    protected final SelenideElement confurmCreatingNewTask = $x("//input[@id='create-issue-submit']")
            .as("кнопка Создать в окне создания задачи");


}
