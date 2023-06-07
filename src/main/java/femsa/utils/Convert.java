package femsa.utils;

import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.models.BankInformation;
import femsa.models.Credentials;
import femsa.models.MerchantInfo;
import femsa.models.User;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;

import java.util.List;
import java.util.Map;


public class Convert {
    public static User dataTableToUser(DataTable table) {
        List<Map<String, String>> row = table.asMaps(String.class, String.class);
        return new User.Builder()
                .withFirstName(row.get(0).get("firstName"))
                .withLastName((row.get(0).get("lastName")))
                .withEmail(row.get(0).get("email"))

                .build();
    }

    public static MerchantInfo dataTableToMerchantInfo(DataTable table) {
        List<Map<String, String>> row = table.asMaps(String.class, String.class);
        return new MerchantInfo.Builder()
                .withMerchantName(row.get(0).get("businessName"))
                .withMerchantActivity(row.get(0).get("businessActivity"))
                .withPostalCode(row.get(0).get("postalCode"))
                .build();
    }

    public static BankInformation dataTableToBankAccountInfo(DataTable bankAccountInformation) {
        List<Map<String, String>> row = bankAccountInformation.asMaps(String.class, String.class);
        return new BankInformation.Builder()
                .withClabe(row.get(0).get("clabe"))
                .withAccountHolder(row.get(0).get("accountHolder"))
                .build();
    }

    public  static Credentials dataTableToCredentials(DataTable credentialsInfo){
        List<Map<String,String>> row = credentialsInfo.asMaps(String.class, String.class);
        return  new Credentials.Builder()
                .withUsername(row.get(0).get("username"))
                .withPassword(row.get(0).get("password"))
                .build();
    }
    public static User dataTableToUserWithoutEmail(DataTable table, Actor actor) {
        List<Map<String, String>> row = table.asMaps(String.class, String.class);
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        return new User.Builder()
                .withFirstName(row.get(0).get("firstName"))
                .withLastName((row.get(0).get("lastName")))
                .withEmail(user.getEmail())

                .build();
    }
}

