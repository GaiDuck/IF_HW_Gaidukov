package org.ifellow.gaidukov.IF_HW5;

import io.restassured.RestAssured;
import org.ifellow.gaidukov.IF_HW5.apiSpecificatoins.ApiBaseSpecifications;
import org.ifellow.gaidukov.IF_HW5.dto.User;
import org.ifellow.gaidukov.IF_HW5.steps.ReqresApiSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReqresApiTest {

    ReqresApiSteps steps = new ReqresApiSteps();

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = ApiBaseSpecifications.baseRequestSpec(Properties.REQRES_URL);
        RestAssured.responseSpecification = ApiBaseSpecifications.baseResponceSpecSucsess();
    }

    @Test
    @DisplayName("Проверка создания нового пользователя")
    public void postNewUser() {
        User user = Mapper.readJsonFile("src/test/resources/Reqres.json", User.class);
        steps.postNewUser(user);
        Assertions.assertEquals("Tomato", user.name);
        Assertions.assertEquals("Market", user.job);
    }

}
