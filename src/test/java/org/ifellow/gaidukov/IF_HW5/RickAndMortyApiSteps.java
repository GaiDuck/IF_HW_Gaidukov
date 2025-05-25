package org.ifellow.gaidukov.IF_HW5;

import org.ifellow.gaidukov.IF_HW5.dto.Character;
import org.ifellow.gaidukov.IF_HW5.dto.Episode;

import static io.restassured.RestAssured.given;

public class RickAndMortyApiSteps {

    public Character getCharacterById(String id) {
        return given()
                .when()
                .get("character/" + id)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject("$", Character.class);
    }

    public Character getCharactersByName(String name, int number) {
        return given()
                .when()
                .get("character?name=" + name)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject("results[" + number + "]", Character.class);
    }

    public Character getCharactersByName(String name) {
        return given()
                .when()
                .get("character?name=" + name)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject("results[0]", Character.class);
    }

    public String getUrlFromClass(Character character) {
        return character.episode.getLast();
    }

    public String numberByUrl(String episodeUrl) {
        String[] urlParts = episodeUrl.split("/");
        return urlParts[urlParts.length - 1];
    }

    public Episode getEpisodeByNumber(String episodeNumber) {
        Episode episode = given()
                .when()
                .get("episode/" + episodeNumber)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject("$", Episode.class);
        return episode;
    }

}