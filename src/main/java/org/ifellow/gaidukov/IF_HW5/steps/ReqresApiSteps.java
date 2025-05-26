package org.ifellow.gaidukov.IF_HW5.steps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.ifellow.gaidukov.IF_HW5.dto.User;

public class ReqresApiSteps {

    public JsonPath postNewUser(User user) {
        user.setName("Tomato");
        user.setJob("Market");
        return RestAssured.given()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .post("name=" + user.name + "&job=" + user.job)
                .then()
                .statusCode(201)
                .extract()
                .body()
                .jsonPath();
    }
}
