package org.ifellow.gaidukov.IF_HW5.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.ifellow.gaidukov.IF_HW5.Mapper;
import org.ifellow.gaidukov.IF_HW5.PropertyProcesser;
import org.ifellow.gaidukov.IF_HW5.dto.User;
import org.junit.jupiter.api.Assertions;

import static org.ifellow.gaidukov.IF_HW5.globalVar.TempModels.tempUser;

public class ReqresApiSteps {

    PropertyProcesser prop = new PropertyProcesser();

    @Когда("^создал нового пользователя$")
    public void createNewUserFromJson() {
        tempUser = Mapper.readJsonFile("src/test/resources/Reqres.json", User.class);
    }

    @Когда("^изменил данные пользователя$")
    public void changeUserData() {
        tempUser.setName(prop.getProp("USER_NAME"));
        tempUser.setJob(prop.getProp("USER_JOB"));
    }

    @Когда("^отправил данные пользователя$")
    public JsonPath postNewUser() {
        return RestAssured.given()
                .header(prop.getProp("HEADER_API_KEY"),
                        prop.getProp("HEADER_API_VALUE"))
                .when()
                .post("name=" + tempUser.name + "&job=" + tempUser.job)
                .then()
                .statusCode(Integer.parseInt(prop.getProp("REQRES_EXPECTED_STATUS")))
                .extract()
                .body()
                .jsonPath();
    }

    @Тогда("^проверил, что имя пользователя совпадает с ожидаемым")
    public void checkUserName() {
        Assertions.assertEquals(prop.getProp("USER_NAME"), tempUser.name);
    }

    @Тогда("^проверил, что профессия пользователя совпадает с ожидаемой")
    public void checkUserJob() {
        Assertions.assertEquals(prop.getProp("USER_JOB"), tempUser.job);
    }
}
