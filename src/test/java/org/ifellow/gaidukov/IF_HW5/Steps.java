package org.ifellow.gaidukov.IF_HW5;

import io.restassured.response.ValidatableResponse;
import org.ifellow.gaidukov.IF_HW5.dto.Character;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Steps {

    List<Character> characterList = new ArrayList<>();

    public ValidatableResponse getCharactersByName(String name) {
        return given()
                .when()
                .get("?name=" + name)
                .then();
    }


    public Character getCharacterFromResponce(int number, ValidatableResponse response) {
        return response
                .extract()
                .body()
                .jsonPath()
                .getObject("result[0]", Character.class);

    }
}
