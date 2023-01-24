package femsa.utils.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class FindUser {
    private FindUser(){}
    private static final Logger LOGGER = Logger.getLogger(FindUser.class.getName());
    public static void andUpdate() throws SQLException {

        String host = "b2b-services-database-instance-1.ct0ibmeqcy9w.us-east-1.rds.amazonaws.com";
        String port = "5432";
        String database = "user-service";
        String user = "elvis.perez";
        String password = "gx1sCKbFsgbI";
        DatabaseConnector db = new DatabaseConnector(host, port, database, user, password);
        db.open();

        //actualizamos

       LOGGER.info("Rows affected "+(db.update("UPDATE tbl_user SET name = 'Juan', last_name = 'Gil', email = 'jgil@mail.com' where  mobile like '%5521996723%'") ));
        //verificamos la actualizacion
        ResultSet rs = db.executeQuery("select * from tbl_user ua WHERE mobile like '%5521996723%'");

        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            LOGGER.info("ID = " + id);
            LOGGER.info("NAME = " + name);
            LOGGER.info("LAST_NAME = " + lastName);
            LOGGER.info("EMAIL = " + email);

        }
        rs.close();
        db.close();
    }
}
