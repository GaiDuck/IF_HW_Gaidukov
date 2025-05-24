package org.ifellow.gaidukov.IF_HW5;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.ifellow.gaidukov.IF_HW5.dto.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RickAndMortyApiTest {

    Steps steps = new Steps();

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = ApiBaseSpecifications.baseRequestSpec(Properties.RICK_AND_MORTY_CHARACTER_URL);
        RestAssured.responseSpecification = ApiBaseSpecifications.baseResponceSpecSucsess();
    }

    @Test
    @DisplayName("Проверка получения персонажа по имени.")
    public void getResponce() {
        ValidatableResponse responce = steps.getCharactersByName("Morty Smith");
        Assertions.assertNotNull(responce);
        Character character = steps.getCharacterFromResponce(0, responce);
        Assertions.assertEquals(character.name, "Morty Smith");
    }


}