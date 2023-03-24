package femsa.utils.jsons;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import femsa.models.Credential;
import femsa.models.User;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Logger;

import static femsa.enums.CredentialsProperties.*;
import static femsa.enums.JsonPath.CREDENTIALS;

public class JsonTemplate {
    private static final Logger LOGGER = Logger.getLogger(JsonTemplate.class.getName());

    public static Credential fromJsonToCredential(String credentialType, String credentialName ) throws IOException {
        // Read json file
        String dataJSON = new String(Files.readAllBytes(new File(CREDENTIALS.getFilePath()).toPath()));
        // Convert json file into json object
        JSONObject data = new JSONObject(dataJSON);

        // Get data from json object and fill Credential object
        JSONObject jsonData = data.getJSONObject("data").getJSONObject(credentialName);
        Credential credentials;
        if (credentialType.equalsIgnoreCase("email")) {
            credentials = new Credential.Builder()
                    .withUsername(jsonData.getString(EMAIL.getPropertyName()))
                    .withPassword(jsonData.getString(PASSWORD.getPropertyName()))
                    .build();
        } else {
            credentials = new Credential.Builder()
                    .withUsername(jsonData.getString(PHONE_NUMBER.getPropertyName()))
                    .withPassword(jsonData.getString(PASSWORD.getPropertyName()))
                    .build();
        }

        LOGGER.info("Credential: ".concat(credentials.toString()));
        return credentials;
    }

    public static User getObjectFromJsonFile(String filePath, String objectName) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            JsonObject dataObject = jsonObject.getAsJsonObject("data");
            JsonObject elvisObject = dataObject.getAsJsonObject(objectName);
            LOGGER.info(elvisObject.toString());
            return gson.fromJson(elvisObject, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
      LOGGER.info(getObjectFromJsonFile("src/test/resources/data/api/users/users_data.json","elvis").toString());
    }

}


