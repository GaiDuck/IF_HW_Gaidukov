package org.ifellow.gaidukov.IF_HW5;

import org.ifellow.gaidukov.IF_HW5.dto.User;
import org.ifellow.gaidukov.IF_HW5.steps.ReqresApiSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReqresApiTest extends ReqresHook {

    ReqresApiSteps steps = new ReqresApiSteps();
    PropertyProcesser prop = new PropertyProcesser();

    @Test
    @DisplayName("Проверка создания нового пользователя")
    public void postNewUser() {
        User user = Mapper.readJsonFile("src/test/resources/Reqres.json", User.class);
        steps.postNewUser(user);
        Assertions.assertEquals(prop.getProp("USER_NAME"), user.name);
        Assertions.assertEquals(prop.getProp("USER_JOB"), user.job);
    }
}