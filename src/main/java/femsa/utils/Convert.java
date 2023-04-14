package femsa.utils;

import femsa.models.MerchantInfo;
import femsa.models.User;
import io.cucumber.datatable.DataTable;

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
    public static MerchantInfo dataTableToMerchantInfo(DataTable table){
        List<Map<String, String>> row = table.asMaps(String.class, String.class);
        return new MerchantInfo.Builder()
                .withMerchantName(row.get(0).get("businessName"))
                .withMerchantActivity(row.get(0).get("businessActivity"))
                .withPostalCode(row.get(0).get("postalCode"))
                .build();
    }
}

