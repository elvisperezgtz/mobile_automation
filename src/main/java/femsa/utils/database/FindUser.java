package femsa.utils.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindUser {
    public static void andUpdate() throws SQLException {
        String host = "b2b-services-database-instance-1.ct0ibmeqcy9w.us-east-1.rds.amazonaws.com";
        String port = "5432";
        String database = "user-service";
        String user = "elvis.perez";
        String password = "gx1sCKbFsgbI";
        DatabaseConnector db = new DatabaseConnector(host, port, database, user, password);
        db.open();

        //actualizamos

        System.out.println(  db.update("UPDATE tbl_user SET name = 'Juan', last_name = 'Gil', email = 'jgil@mail.com' where  mobile like '%5521996723%'")+ " rows affected" );
        //verificamos la actualizacion
        ResultSet rs = db.executeQuery("select * from tbl_user ua WHERE mobile like '%5521996723%'");

        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("LAST_NAME = " + lastName);
            System.out.println("EMAIL = " + email);
            System.out.println();
        }
        rs.close();
        db.close();
    }


}
