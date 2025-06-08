package org.ifellow.gaidukov.IF_HW3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraTaskPage {
    protected final SelenideElement taskStatus = $x("//span[@id='status-val']/span")
            .as("Статус задачи");
    protected final SelenideElement taskVersion = $x("//span[@id='fixVersions-field']/a")
            .as("Версия задачи");
}
