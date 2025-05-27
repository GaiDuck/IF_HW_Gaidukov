package org.ifellow.gaidukov.IF_HW5.steps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.ifellow.gaidukov.IF_HW5.PropertyProcesser;
import org.ifellow.gaidukov.IF_HW5.dto.User;

public class ReqresApiSteps {

    PropertyProcesser prop = new PropertyProcesser();

    public JsonPath postNewUser(User user) {
        user.setName(prop.getProp("USER_NAME"));
        user.setJob(prop.getProp("USER_JOB"));
        return RestAssured.given()
                .header(prop.getProp("HEADER_API_KEY"),
                        prop.getProp("HEADER_API_VALUE"))
                .when()
                .post("name=" + user.name + "&job=" + user.job)
                .then()
                .statusCode(Integer.parseInt(prop.getProp("REQRES_EXPECTED_STATUS")))
                .extract()
                .body()
                .jsonPath();
    }
}
