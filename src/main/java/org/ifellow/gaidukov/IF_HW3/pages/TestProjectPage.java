package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class TestProjectPage {
    private final SelenideElement currentNumberOfAllNumbers = $x("//div[@class='showing']")
            .as("номер текущей задачи из общего числа задач");
    private final SelenideElement creareNewTask = $x("//a[@id='create_link']")
            .as("кнопка Создать");
    private final SelenideElement taskTitle = $x("//input[@id='summary']")
            .as("поле Тема");
    private final SelenideElement confurmCreatingNewTask = $x("//input[@id='create-issue-submit']")
            .as("кнопка Создать в окне создания задачи");


    public void checkThatTaskCounterWorksCorrectly() {
        Assertions.assertTrue(currentNumberOfAllNumbers.isDisplayed());

        int firstNumberOfTasks = Integer.parseInt(currentNumberOfAllNumbers.getText().split(" ")[2]);

        Assertions.assertTrue(creareNewTask.isDisplayed());
        creareNewTask.click();

        taskTitle.shouldBe(Condition.clickable).click();
        taskTitle.sendKeys("test");

        Assertions.assertTrue(confurmCreatingNewTask.isDisplayed());
        confurmCreatingNewTask.click();
        currentNumberOfAllNumbers.shouldBe(Condition.visible);

        Selenide.refresh();
        currentNumberOfAllNumbers.shouldBe(Condition.visible);
        int secondNumberOfTasks = Integer.parseInt(currentNumberOfAllNumbers.getText().split(" ")[2]);

        Assertions.assertTrue(secondNumberOfTasks > firstNumberOfTasks);
    }
}
