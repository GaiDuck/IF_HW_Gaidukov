package org.ifellow.gaidukov.IF_HW5.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.RestAssured;
import org.ifellow.gaidukov.IF_HW5.PropertyProcesser;
import org.ifellow.gaidukov.IF_HW5.dto.Character;
import org.ifellow.gaidukov.IF_HW5.dto.Episode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class RickAndMortyApiSteps {

    PropertyProcesser prop = new PropertyProcesser();
    Character mortySmith;
    String lastEpisodeUrl;
    String lastEpisodeNumber;
    Episode episode;
    String lastCharacterId;
    Character misteryCharacter;

    @Когда("^получил персонажа по имени \"([^\"]*)\"$")
    public void getCharacterByName(String name) {
        mortySmith = RestAssured.given()
                .when()
                .get(prop.getProp("RICK_AND_MORTY_CHARACTER_ENDPOINT") + "?name=" + name)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject(prop.getProp("RICK_AND_MORTY_FIRST_RESULT_PATH"), Character.class);
    }

    @Когда("^получил URL последнего эпизода, в котором появлялся Морти Смит$")
    public void getUrlFromCharacterClass() {
        lastEpisodeUrl = mortySmith.episode.get(mortySmith.episode.size() - 1);
    }

    @Когда("^получил номер последнего эпизода$")
    public void numberByUrl() {
        String[] urlParts = lastEpisodeUrl.split("/");
        lastEpisodeNumber = urlParts[urlParts.length - 1];
    }

    @Когда("^получил эпизод по номеру$")
    public void getEpisodeByNumber() {
        episode = RestAssured.given()
                .when()
                .get(prop.getProp("RICK_AND_MORTY_EPISODE_ENDPOINT") + "/" + lastEpisodeNumber)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject(prop.getProp("RICK_AND_MORTY_ROOT_PATH"), Episode.class);
    }

    @Когда("^получил id последнего персонажа из эпизода$")
    public void getAllCharactersFromEpisode() {
        String lastCharacterUrl = episode.characters.get(episode.characters.size() - 1);
        String[] splitedCharacterUrl = lastCharacterUrl.split("/");
        lastCharacterId = splitedCharacterUrl[splitedCharacterUrl.length - 1];
    }

    @Когда("^получил персонажа по id$")
    public void getCharacterById() {
        misteryCharacter = RestAssured.given()
                .when()
                .get(prop.getProp("RICK_AND_MORTY_CHARACTER_ENDPOINT") + "/" + lastCharacterId)
                .then()
                .extract()
                .body()
                .jsonPath()
                .getObject(prop.getProp("RICK_AND_MORTY_ROOT_PATH"), Character.class);
    }

    @Тогда("^проверил, что расса Морти Смита и этого персонажа совпадают$")
    public void compareCharectersSpecies() {
        Assertions.assertEquals(mortySmith.species, misteryCharacter.species);
    }

    @Тогда("^проверил, что местоположение Морти Смита и этого персонажа не совпадают$")
    public void compareCharectersLocation() {
        Assertions.assertNotEquals(mortySmith.location, misteryCharacter.location);
    }
}