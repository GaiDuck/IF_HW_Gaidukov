package org.ifellow.gaidukov.IF_HW5;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RickAndMortyApiTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = ApiBaseSpecifications.baseRequestSpec(Properties.RICK_AND_MORTY_URL);
        RestAssured.responseSpecification = ApiBaseSpecifications.baseResponceSpecSucsess();
    }

    @Test
    public void firstApiGetTest() {
        given()
                .when()
                .get("/get?name=Morty Smith");

    }
}
