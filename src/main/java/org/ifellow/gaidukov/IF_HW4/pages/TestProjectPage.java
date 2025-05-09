package org.ifellow.gaidukov.IF_HW4.pages;

import com.codeborne.selenide.Condition;
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

    private int firstNumberOfTasks;
    private int secondNumberOfTasks;

    public void discardNumbersOfTasks() {
        firstNumberOfTasks = 0;
        secondNumberOfTasks = 0;
    }

    public void setFirstNumberOfTasks() {
        firstNumberOfTasks = Integer.parseInt(currentNumberOfAllNumbers.shouldBe(Condition.visible).getText().split(" ")[2]);
    }

    public void setSecondNumberOfTasks() {
        secondNumberOfTasks = Integer.parseInt(currentNumberOfAllNumbers.shouldBe(Condition.visible).getText().split(" ")[2]);
    }

    public void assertThatSecondNumberIsBigger() {
        Assertions.assertTrue(secondNumberOfTasks > firstNumberOfTasks);
    }
}
