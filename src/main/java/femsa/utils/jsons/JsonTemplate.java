package femsa.utils.jsons;

import femsa.models.Credential;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Logger;

import static femsa.enums.CredentialsProperties.*;
import static femsa.enums.JsonPath.USERS_DATA;

public class JsonTemplate {
    private static final Logger LOGGER = Logger.getLogger(JsonTemplate.class.getName());

    public static Credential fromJsonToCredential(String credentialType, String credentialName ) throws IOException {
        // Read json file
        String dataJSON = new String(Files.readAllBytes(new File(USERS_DATA.getFilePath()).toPath()));
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

}


