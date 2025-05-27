package org.ifellow.gaidukov.IF_HW5;

import org.ifellow.gaidukov.IF_HW5.dto.Character;
import org.ifellow.gaidukov.IF_HW5.steps.RickAndMortyApiSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RickAndMortyApiTest extends RickAndMortyHook {

    RickAndMortyApiSteps steps = new RickAndMortyApiSteps();

    @Test
    @DisplayName("Проверка получения персонажа по имени.")
    public void getCharacterByName() {
        Character character = steps.getCharactersByName("Morty Smith");
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
                                steps.getLastCoworkerByName("Morty Smith")))
                        .name;
        Assertions.assertEquals("Young Jerry", characterName);
    }

    @Test
    @DisplayName("Проверка получения местонахождения персонажа")
    public void getCharacterLocation() {
        String characterLocation =
                steps.getCharacterById(
                        steps.numberByUrl(
                                steps.getLastCoworkerByName("Morty Smith")))
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
                                steps.getLastCoworkerByName("Morty Smith")))
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
                                steps.getLastCoworkerByName("Morty Smith")))
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
                                steps.getLastCoworkerByName("Morty Smith")))
                        .species;

        Assertions.assertEquals(firstCharacterSpecies, secondCharacterSpecies);
    }
}