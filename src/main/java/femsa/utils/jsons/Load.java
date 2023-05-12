package femsa.utils.jsons;

import femsa.enums.JsonPath;
import femsa.models.Credentials;
import femsa.models.User;
import femsa.utils.Decoder;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static femsa.enums.CredentialsName.ELVIS;
import static femsa.enums.JsonPath.CREDENTIALS;
import static femsa.utils.jsons.JsonTemplate.getCredentialsFromTemplate;
import static femsa.utils.jsons.JsonTemplate.getUserFromJsonTemplate;
import static java.util.Objects.requireNonNull;

public class Load {

    public static String credentialsFromJsonTemplate(String filePath) {
        Credentials credentials = getCredentialsFromTemplate(CREDENTIALS.getFilePath(), ELVIS.getName());
        String query = requireNonNull(loadJson(filePath).toString());
        query = query.replace("{{password}}", Decoder.decode(credentials.getPassword()));
        query = query.replace("{{userName}}", credentials.getUsername());
        return query;
    }

    public static String userFromJsonTemplate(String userType, String idUser) {
        User user = getUserFromJsonTemplate(userType);
        System.out.println("ID ->" + idUser);
        String query = requireNonNull(loadJson("src/test/resources/data/api/templates/update_user_info_template.json").toString());
        query = query.replace("{{email}}", user.getEmail());
        query = query.replace("{{idUser}}", idUser);
        query = query.replace("{{lastName}}", user.getLastName());
        query = query.replace("{{name}}", user.getFirstName());
        System.out.println(query);
        return query;
    }


    public static JSONObject loadJson(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear un objeto JSONObject a partir del contenido del archivo JSON
        String jsonContent = stringBuilder.toString();
        return new JSONObject(jsonContent);
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
