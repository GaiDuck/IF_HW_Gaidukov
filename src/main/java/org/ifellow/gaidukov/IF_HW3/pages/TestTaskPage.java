package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class TestTaskPage {
    private final SelenideElement taskStatus = $x("//span[@id='status-val']/span")
            .as("Статус задачи");
    private final SelenideElement taskVersion = $x("//span[@id='fixVersions-field']/a")
            .as("Версия задачи");

    public void checkTaskData(String status, String version) {
        taskStatus.shouldBe(Condition.visible);
        Assertions.assertEquals(taskStatus.getText(), status);
        taskVersion.shouldBe(Condition.visible);
        Assertions.assertEquals(taskVersion.getText(), version);
    }
}
