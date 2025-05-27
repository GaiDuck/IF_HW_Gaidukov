package org.ifellow.gaidukov.IF_HW5.steps;

import io.restassured.RestAssured;
import org.ifellow.gaidukov.IF_HW5.PropertyProcesser;
import org.ifellow.gaidukov.IF_HW5.dto.Character;
import org.ifellow.gaidukov.IF_HW5.dto.Episode;

import java.util.ArrayList;

public class RickAndMortyApiSteps {

    PropertyProcesser prop = new PropertyProcesser();

    public Character getCharacterById(String id) {
        return RestAssured.given()
                .when()
                .get(prop.getProp("RICK_AND_MORTY_CHARACTER_ENDPOINT") + "/" + id)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject(prop.getProp("RICK_AND_MORTY_ROOT_PATH"), Character.class);
    }

    public Character getCharactersByName(String name) {
        return RestAssured.given()
                .when()
                .get(prop.getProp("RICK_AND_MORTY_CHARACTER_ENDPOINT") + "?name=" + name)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject(prop.getProp("RICK_AND_MORTY_FIRST_RESULT_PATH"), Character.class);
    }

    public String getUrlFromCharacterClass(Character character) {
        return character.episode.get(character.episode.size() - 1);
    }

    public String numberByUrl(String episodeUrl) {
        String[] urlParts = episodeUrl.split("/");
        return urlParts[urlParts.length - 1];
    }

    public Episode getEpisodeByNumber(String episodeNumber) {
        return RestAssured.given()
                .when()
                .get(prop.getProp("RICK_AND_MORTY_EPISODE_ENDPOINT") + "/" + episodeNumber)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject(prop.getProp("RICK_AND_MORTY_ROOT_PATH"), Episode.class);
    }

    public String getLastCoworkerByName(String characterName) {
        ArrayList<String> charactersList = getEpisodeByNumber(
                numberByUrl(
                        getUrlFromCharacterClass(
                                getCharactersByName(characterName))))
                .characters;
        return charactersList.get(charactersList.size() - 1);
    }
}