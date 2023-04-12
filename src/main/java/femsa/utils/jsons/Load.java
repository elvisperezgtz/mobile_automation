package femsa.utils.jsons;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import femsa.enums.JsonPath;
import femsa.models.Credential;
import femsa.models.User;
import femsa.utils.Decoder;

import java.io.FileReader;

import static femsa.enums.CredentialsName.ELVIS;
import static femsa.enums.JsonPath.CREDENTIALS;
import static femsa.utils.jsons.JsonTemplate.getCredentialsFromTemplate;
import static femsa.utils.jsons.JsonTemplate.getUserFromJsonTemplate;
import static java.util.Objects.requireNonNull;

public class Load {

    public static String credentialsFromJsonTemplate(String filePath) {
        Credential credential = getCredentialsFromTemplate(CREDENTIALS.getFilePath(), ELVIS.getName());
        String query = requireNonNull(loadJson(filePath).getAsJsonObject().toString());
        query = query.replace("{{password}}", Decoder.decode(credential.getPassword()));
        query = query.replace("{{userName}}", credential.getUsername());
        return query;
    }

    public static String userFromJsonTemplate(String userType, String idUser) {
        User user = getUserFromJsonTemplate(userType);
        System.out.println("ID ->" + idUser);
        String query = requireNonNull(loadJson("src/test/resources/data/api/templates/update_user_info_template.json").getAsJsonObject().toString());
        query = query.replace("{{email}}", user.getEmail());
        query = query.replace("{{idUser}}", idUser);
        query = query.replace("{{lastName}}", user.getLastName());
        query = query.replace("{{name}}", user.getFirstName());
        return query;
    }


    public static JsonObject loadJson(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
            return json;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String userAccountFromJsonTemplate(String idUser){
        String query = requireNonNull(loadJson(JsonPath.USER_ACCOUNT_DATA.getFilePath())).toString();
        query = query.replace("{{idUser}}", idUser);
        return query;
    }

    public static void main(String[] args) {
//        System.out.println(userFromJsonTemplate("Elvis",""));
        System.out.println(userAccountFromJsonTemplate("prueba"));
    }
}
