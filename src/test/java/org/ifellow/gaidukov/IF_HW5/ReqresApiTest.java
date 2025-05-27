package org.ifellow.gaidukov.IF_HW5;

import org.ifellow.gaidukov.IF_HW5.apiSpecificatoins.ApiBaseSpecifications;
import org.ifellow.gaidukov.IF_HW5.dto.User;
import org.ifellow.gaidukov.IF_HW5.steps.ReqresApiSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;

public class ReqresApiTest {

    ReqresApiSteps steps = new ReqresApiSteps();
    PropertyProcesser prop = new PropertyProcesser();

    @BeforeAll
    public static void setUp() {
        PropertyProcesser prop = new PropertyProcesser();
        requestSpecification = ApiBaseSpecifications.baseRequestSpec(prop.getProp("REQRES_URI"));
        responseSpecification = ApiBaseSpecifications.baseResponceSpecSucsess();
    }

    @Test
    @DisplayName("Проверка создания нового пользователя")
    public void postNewUser() {
        User user = Mapper.readJsonFile("src/test/resources/Reqres.json", User.class);
        steps.postNewUser(user);
        Assertions.assertEquals(prop.getProp("USER_NAME"), user.name);
        Assertions.assertEquals(prop.getProp("USER_JOB"), user.job);
    }
}