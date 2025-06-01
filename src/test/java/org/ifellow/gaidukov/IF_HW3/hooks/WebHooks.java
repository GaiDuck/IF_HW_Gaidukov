package org.ifellow.gaidukov.IF_HW3.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.ifellow.gaidukov.IF_HW3.features.PropertyProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {

    @BeforeAll
    public static void setUpAllure() {
        PropertyProcessor prop = new PropertyProcessor();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(Boolean.getBoolean(prop.getProp("saveScreenshots", "ALLURE")))
                .savePageSource(Boolean.getBoolean(prop.getProp("savePageValue", "ALLURE"))));
    }

    @AfterEach
    public void shutBrowser() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 15000;

        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        getWebDriver().manage().window().maximize();
    }
}
