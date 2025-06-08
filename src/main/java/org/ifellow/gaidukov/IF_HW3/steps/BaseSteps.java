package org.ifellow.gaidukov.IF_HW3.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.SetValueOptions.withText;

public class BaseSteps {

    protected void fillTextField(SelenideElement textField, String value) {
        textField.shouldBe(enabled, visible).setValue(value);
    }

    protected void fillTextFieldBySecretText(SelenideElement textField, String value) {
        textField.shouldBe(enabled, visible).setValue(withText(value).sensitive());
    }

    protected void fillTextFiedWithDropdown(SelenideElement textField, String value) {
        textField.shouldBe(enabled, visible).setValue(value);
        textField.pressEnter();
    }

    protected void fillIFrameTextField(SelenideElement iFrame, SelenideElement textField, String value) {
        switchTo().frame(iFrame);
        textField.shouldBe(enabled).sendKeys(value);
        switchTo().defaultContent();
    }

    protected void chooseElementFromDropdownByText(SelenideElement dropDown, String text) {
        dropDown.shouldBe(enabled, visible).click();
        findElementByText(text).shouldBe(enabled, visible).click();
    }

    protected void chooseElementFromDropdownWithInputByText(SelenideElement dropDown, String text) {
        dropDown.shouldBe(enabled, visible).click();
        dropDown.sendKeys(text);
        findElementByText(text).shouldBe(enabled, visible).click();
    }

    private SelenideElement findElementByText(String text) {
        return $x("//*[contains(text(), '" + text + "')]");
    }

    protected void checkRadiobuttonIsPressed(SelenideElement radiobutton) {
        if (Objects.equals(radiobutton.getAttribute("aria-pressed"), "false")) {
            radiobutton.click();
        }
    }

    protected void searchByText(SelenideElement searchField, String text) {
        fillTextField(searchField, text);
        searchField.pressEnter();
    }

    protected void waitForValueChange(SelenideElement element, String value) {
        for (int i = 0; i < 1500; i++) {
            if (!element.getText().equals(value)) {
                Selenide.sleep(10);
            } else {
                break;
            }
        }
    }
}
