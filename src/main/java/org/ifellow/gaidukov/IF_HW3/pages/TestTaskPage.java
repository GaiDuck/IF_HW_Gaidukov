package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class TestTaskPage {
    private final SelenideElement taskStatus = $x("//span[@id='status-val']/span")
            .as("Статус задачи");
    private final SelenideElement taskVersion = $x("//span[@id='fixVersions-field']/a")
            .as("Версия задачи");

    @Step("Проверить статус и версию задачи")
    public void checkTaskData() {
        taskStatus.shouldBe(Condition.visible);
        Assertions.assertEquals("СДЕЛАТЬ", taskStatus.getText());
        taskVersion.shouldBe(Condition.visible);
        Assertions.assertEquals("Version 2.0", taskVersion.getText());
    }
}
