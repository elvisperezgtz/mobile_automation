package femsa.api;

import femsa.utils.jsons.JsonTemplate;
import femsa.utils.jsons.Load;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.logging.Logger;

public class Update {

    private static final Logger LOGGER = Logger.getLogger(JsonTemplate.class.getName());
    private static final String URI= "https://apollo.b2b-qa.digitalfemsa.services";


    public static Response getUserID() {
        RestAssured.baseURI = URI;

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(Load.credentialsFromJsonTemplate("src/test/resources/data/api/query.json"))
                .when()
                .post("/")
                .then()
                .extract()
                .response();

        LOGGER.info("Status code login: " + response.getStatusCode());
        return response;
    }

    public static Response userInfo(String userData) {
        LOGGER.info("Updating user information... ");
        RestAssured.baseURI = URI;
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer ".concat(getUserID().jsonPath().getString("data.login.accessToken")))
                .body(Load.userFromJsonTemplate(userData, getUserID().jsonPath().getString("data.login.idUser")))
                .when()
                .post("/")
                .then()
                .extract()
                .response();
        LOGGER.info("Status code login: " + response.getStatusCode());
        return response;
    }
}
