package femsa.api;

import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.models.User;
import femsa.utils.jsons.JsonTemplate;
import femsa.utils.jsons.Load;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.logging.Logger;

public class Update {

    private static final Logger LOGGER = Logger.getLogger(JsonTemplate.class.getName());
    private static final String URI = "https://apollo.b2b-qa.digitalfemsa.services/";


    public static Response getUserID() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(Load.credentialsFromJsonTemplate("src/test/resources/data/api/query.json"))
                .when()
                .post(URI)
                .then()
                .extract()
                .response();

        LOGGER.info("Status code login: " + response.getStatusCode());
        return response;
    }

    public static Response userInfo(String userData) {
        LOGGER.info("Updating user information... ");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer ".concat(getUserID().body().jsonPath().getString("data.login.accessToken")))
                .body(Load.userFromJsonTemplate(userData, getUserID().body().jsonPath().getString("data.login.idUser")))
                .when()
                .post(URI)
                .then()
                .extract()
                .response();
        LOGGER.info("Status code login: " + response.getStatusCode());
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

    public static void businessInfo(CredentialsName userData) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), userData.getName());
        Response loginResponse = getUserID();
        String token = loginResponse.jsonPath().getString("data.login.accessToken");
        String idUser = loginResponse.jsonPath().getString("data.login.idUser");
        Response userAccountInfoResponse = getUserAccountInfo(token, idUser);
        String idBranch = userAccountInfoResponse.body().jsonPath().getString("data.findUserAccountInfo.userAccount.idBranch").replace("[", "").replace("]", "");

        LOGGER.info("Updating business information");

        String mutation = "mutation Mutation($request: UpdateBusinessInfoRequest) {updateBusinessInfo(request: $request) {message status}}";
        String request =  "{\"businessActivity\":\"{{businessActivity}}\",\"businessName\":\"{{businessName}}\",\"idBranch\":\"{{idBranch}}\",\"zipCode\":\"{{postalCode}}\"}";

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

    public static void bankAccountInfo(CredentialsName userData){
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), userData.getName());
        Response loginResponse = getUserID();
        String token = loginResponse.jsonPath().getString("data.login.accessToken");
        String idUser = loginResponse.jsonPath().getString("data.login.idUser");
        Response userAccountInfoResponse = getUserAccountInfo(token, idUser);
        String idClabe = userAccountInfoResponse.body().jsonPath().getString("data.findUserAccountInfo.userAccount.idClabe").replace("[", "").replace("]", "");

        LOGGER.info("Updating business information");

        String mutation = "mutation Mutation($request: UpdateBankAccountInfoRequest) {updateBankAccountInfo(request: $request) {message status}}";
        String request =  "{\"clabe\":\"{{clabe}}\",\"holder\":\"{{holder}}\",\"idClabe\":\"{{idClabe}}\"}";


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

    public static void main(String[] args) {
        bankAccountInfo(CredentialsName.ELVIS);
    }
}
