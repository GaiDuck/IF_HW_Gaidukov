package org.ifellow.gaidukov.IF_HW5;

import io.restassured.RestAssured;
import org.ifellow.gaidukov.IF_HW5.apiSpecificatoins.ApiBaseSpecifications;
import org.junit.jupiter.api.BeforeAll;

public class ReqresApiTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.requestSpecification = ApiBaseSpecifications.baseRequestSpec(Properties.REQRES_URL);
        RestAssured.responseSpecification = ApiBaseSpecifications.baseResponceSpecSucsess();
    }

}
