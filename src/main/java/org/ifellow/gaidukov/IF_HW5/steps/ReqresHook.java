package org.ifellow.gaidukov.IF_HW5.steps;

import io.cucumber.java.ru.Когда;
import org.ifellow.gaidukov.IF_HW5.PropertyProcesser;
import org.ifellow.gaidukov.IF_HW5.apiSpecificatoins.ApiBaseSpecifications;

import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;

public class ReqresHook {

    @Когда("^настроил REQRES API$")
    public static void setUp() {
        PropertyProcesser prop = new PropertyProcesser();
        requestSpecification = ApiBaseSpecifications.baseRequestSpec(prop.getProp("REQRES_URI"));
        responseSpecification = ApiBaseSpecifications.baseResponceSpecSucsess();
    }
}
