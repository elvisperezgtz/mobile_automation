package femsa.api;

import femsa.enums.JsonPath;
import femsa.models.User;
import femsa.utils.Decoder;
import femsa.utils.jsons.JsonTemplate;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.logging.Logger;

public class Update {

    private static final Logger LOGGER = Logger.getLogger(JsonTemplate.class.getName());
    private static final String URI = "https://apollo.b2b-qa.digitalfemsa.services/";


    public static Response getUserID(String password, String username) {
        String requestBody = "{\"query\":\"query Query($request: LoginRequest) {\\n  login(request: $request) {\\n    accessToken\\n    changePassword\\n    idUser\\n    message\\n    profiles\\n    refreshToken\\n    status\\n  }\\n}\",\"variables\":{\"request\":{\"password\":\"%s\",\"userName\":\"%s\"}}}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(String.format(requestBody, password, username))
                .when()
                .post(URI)
                .then()
                .extract()
                .response();

        LOGGER.info("Status code login: " + response.getStatusCode());
        return response;
    }

    public static Response userInfo(String userData) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), userData );

        Response loginResponse = getUserID(Decoder.decode(user.getCredentials().getPassword()), user.getCredentials().getUsername());
        String email = user.getEmail();
        String idUser = loginResponse.body().jsonPath().getString("data.login.idUser");
        String lastname = user.getLastName();
        String firstname = user.getFirstName();
        String token = loginResponse.body().jsonPath().getString("data.login.accessToken");

        LOGGER.info("Updating user information... ");
        String query = "mutation UpdateUserInfo($request: SaveUserInfoRequest) {updateUserInfo(request: $request) {message status}}";
        String requestBody = String.format("{\"query\":\"%s\",\"variables\":{\"request\":{\"email\":\"%s\",\"idUser\":\"%s\",\"lastName\":\"%s\",\"name\":\"%s\"}}}", query, email, idUser, lastname, firstname);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer ".concat(token))
                .body(requestBody)
                .when()
                .post(URI)
                .then()
                .extract()
                .response();
        LOGGER.info("Status code user Info: " + response.getStatusCode());
        return response;
    }

    public static Response getUserAccountInfo(String token, String idUser) {
        LOGGER.info("Getting user account information");
        RestAssured.baseURI = URI;
        String query = "query Query($request: UserAccountRequest) {findUserAccountInfo(request: $request) {message status userAccount {holder idBranch idClabe idFinancialData idMerchant nameMerchant}}}";
        String variables = "{\"request\":{\"idUser\":\"" + idUser + "\"}}";

        Response response = RestAssured.given()
                .header("content-type", ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body("{\"query\":\"" + query + "\",\"variables\":" + variables + "}")
                .post(URI);
        return response;
    }

    public static void businessInfo(String userData) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), userData );
        Response loginResponse = getUserID(Decoder.decode(user.getCredentials().getPassword()), user.getCredentials().getUsername());
        String token = loginResponse.jsonPath().getString("data.login.accessToken");
        String idUser = loginResponse.jsonPath().getString("data.login.idUser");
        Response userAccountInfoResponse = getUserAccountInfo(token, idUser);
        String idBranch = userAccountInfoResponse.body().jsonPath().getString("data.findUserAccountInfo.userAccount.idBranch").replace("[", "").replace("]", "");

        LOGGER.info("Updating business information");

        String mutation = "mutation Mutation($request: UpdateBusinessInfoRequest) {updateBusinessInfo(request: $request) {message status}}";
        String request = "{\"businessActivity\":\"{{businessActivity}}\",\"businessName\":\"{{businessName}}\",\"idBranch\":\"{{idBranch}}\",\"zipCode\":\"{{postalCode}}\"}";

        request = request.replace("{{businessActivity}}", "5542");
        request = request.replace("{{businessName}}", user.getMerchantInfo().getMerchantName());
        request = request.replace("{{idBranch}}", idBranch);
        request = request.replace("{{postalCode}}", user.getMerchantInfo().getPostalCode());

        LOGGER.info("Query " + request);
        RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer ".concat(token))
                .body("{\"query\":\"" + mutation + "\",\"variables\":{\"request\":" + request + "}}")
                .post("")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .prettyPrint();
    }

    public static void bankAccountInfo(String userData) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), userData);
        Response loginResponse = getUserID(Decoder.decode(user.getCredentials().getPassword()), user.getCredentials().getUsername());
        String token = loginResponse.jsonPath().getString("data.login.accessToken");
        String idUser = loginResponse.jsonPath().getString("data.login.idUser");
        Response userAccountInfoResponse = getUserAccountInfo(token, idUser);
        String idClabe = userAccountInfoResponse.body().jsonPath().getString("data.findUserAccountInfo.userAccount.idClabe").replace("[", "").replace("]", "");

        LOGGER.info("Updating business information");

        String mutation = "mutation Mutation($request: UpdateBankAccountInfoRequest) {updateBankAccountInfo(request: $request) {message status}}";
        String request = "{\"clabe\":\"{{clabe}}\",\"holder\":\"{{holder}}\",\"idClabe\":\"{{idClabe}}\"}";


        request = request.replace("{{clabe}}", user.getBankInformation().getClabe());
        request = request.replace("{{holder}}", user.getBankInformation().getAccountHolder());
        request = request.replace("{{idClabe}}", idClabe);

        LOGGER.info("Query " + request);
        RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer ".concat(token))
                .body("{\"query\":\"" + mutation + "\",\"variables\":{\"request\":" + request + "}}")
                .post("")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .prettyPrint();
    }

}
