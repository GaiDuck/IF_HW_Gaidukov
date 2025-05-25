package org.ifellow.gaidukov.IF_HW5.steps;

import io.restassured.RestAssured;
import org.ifellow.gaidukov.IF_HW5.dto.Character;
import org.ifellow.gaidukov.IF_HW5.dto.Episode;

public class RickAndMortyApiSteps {

    public Character getCharacterById(String id) {
        return RestAssured.given()
                .when()
                .get("character/" + id)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject("$", Character.class);
    }

    public Character getCharactersByName(String name, int number) {
        return RestAssured.given()
                .when()
                .get("character?name=" + name)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject("results[" + number + "]", Character.class);
    }

    public Character getCharactersByName(String name) {
        return RestAssured.given()
                .when()
                .get("character?name=" + name)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject("results[0]", Character.class);
    }

    public String getUrlFromCharacterClass(Character character) {
        return character.episode.getLast();
    }

    public String numberByUrl(String episodeUrl) {
        String[] urlParts = episodeUrl.split("/");
        return urlParts[urlParts.length - 1];
    }

    public Episode getEpisodeByNumber(String episodeNumber) {
        return RestAssured.given()
                .when()
                .get("episode/" + episodeNumber)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject("$", Episode.class);
    }

}