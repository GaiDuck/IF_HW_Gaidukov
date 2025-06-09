package org.ifellow.gaidukov.IF_HW5.steps;

import io.cucumber.java.ru.Когда;
import org.ifellow.gaidukov.IF_HW5.PropertyProcesser;
import org.ifellow.gaidukov.IF_HW5.apiSpecificatoins.ApiBaseSpecifications;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;

public class RickAndMortyHook {

    @Когда("^настроил Rick&Morty API$")
    public static void setUp() {
        PropertyProcesser prop = new PropertyProcesser();
        requestSpecification = ApiBaseSpecifications.baseRequestSpec(prop.getProp("RICK_AND_MORTY_URI"));
        responseSpecification = ApiBaseSpecifications.baseResponceSpecSucsess();
    }
}
