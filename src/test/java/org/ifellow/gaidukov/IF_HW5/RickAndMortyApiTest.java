package org.ifellow.gaidukov.IF_HW5;

import io.restassured.RestAssured;
import org.ifellow.gaidukov.IF_HW5.apiSpecificatoins.ApiBaseSpecifications;
import org.ifellow.gaidukov.IF_HW5.dto.Character;
import org.ifellow.gaidukov.IF_HW5.steps.RickAndMortyApiSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RickAndMortyApiTest {

    RickAndMortyApiSteps steps = new RickAndMortyApiSteps();

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = ApiBaseSpecifications.baseRequestSpec(Properties.RICK_AND_MORTY_CHARACTER_URL);
        RestAssured.responseSpecification = ApiBaseSpecifications.baseResponceSpecSucsess();
    }

    @Test
    @DisplayName("Проверка получения персонажа по имени.")
    public void getCharacterByName() {
        Character character = steps.getCharactersByName("Morty Smith", 0);
        Assertions.assertEquals("Morty Smith", character.name);
    }

    @Test
    @DisplayName("Проверка получения последнего эпизода по имени персонажа.")
    public void getLastCharactersEpisode() {
        String episodeNumber =
                steps.numberByUrl(
                        steps.getUrlFromCharacterClass(
                                steps.getCharactersByName("Morty Smith")));
        Assertions.assertEquals("51", episodeNumber);
    }

    @Test
    @DisplayName("Проверка получения последнего персонажа из эпизода")
    public void getLastEpisodesCharacter() {
        String characterName =
                steps.getCharacterById(
                        steps.numberByUrl(
                                steps.getEpisodeByNumber(
                                                steps.numberByUrl(
                                                        steps.getUrlFromCharacterClass(
                                                                steps.getCharactersByName("Morty Smith"))))
                                        .characters.getLast()))
                        .name;
        Assertions.assertEquals("Young Jerry", characterName);
    }

    @Test
    @DisplayName("Проверка получения местонахождения персонажа")
    public void getCharacterLocation() {
        String characterLocation =
                steps.getCharacterById(
                        steps.numberByUrl(
                                steps.getEpisodeByNumber(
                                                steps.numberByUrl(
                                                        steps.getUrlFromCharacterClass(
                                                                steps.getCharactersByName("Morty Smith"))))
                                        .characters.getLast()))
                        .location
                        .name;
        Assertions.assertEquals("Earth (Unknown dimension)", characterLocation);
    }

    @Test
    @DisplayName("Проверка расы персонажа")
    public void getCharacterSpecies() {
        String characterSpecies =
                steps.getCharacterById(
                        steps.numberByUrl(
                                steps.getEpisodeByNumber(
                                                steps.numberByUrl(
                                                        steps.getUrlFromCharacterClass(
                                                                steps.getCharactersByName("Morty Smith"))))
                                        .characters.getLast()))
                        .species;
        Assertions.assertEquals("Human", characterSpecies);
    }

    @Test
    @DisplayName("Проверка несовпадения местонахождения двух персонажей")
    public void compareCharactersLocation() {
        String firstCharacterLocation =
                steps.getCharactersByName("Morty Smith")
                        .location
                        .name;

        String secondCharacterLocation =
                steps.getCharacterById(
                        steps.numberByUrl(
                                steps.getEpisodeByNumber(
                                                steps.numberByUrl(
                                                        steps.getUrlFromCharacterClass(
                                                                steps.getCharactersByName("Morty Smith"))))
                                        .characters.getLast()))
                        .location
                        .name;

        Assertions.assertNotEquals(firstCharacterLocation, secondCharacterLocation);
    }

    @Test
    @DisplayName("Проверка совпадения расы двух персонажей")
    public void compareCharactersSpecies() {
        String firstCharacterSpecies =
                steps.getCharactersByName("Morty Smith")
                        .species;

        String secondCharacterSpecies =
                steps.getCharacterById(
                        steps.numberByUrl(
                                steps.getEpisodeByNumber(
                                                steps.numberByUrl(
                                                        steps.getUrlFromCharacterClass(
                                                                steps.getCharactersByName("Morty Smith"))))
                                        .characters.getLast()))
                        .species;

        Assertions.assertEquals(firstCharacterSpecies, secondCharacterSpecies);
    }
}