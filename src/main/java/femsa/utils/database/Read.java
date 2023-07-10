package femsa.utils.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Read {
    private static final Logger LOGGER = Logger.getLogger(Read.class.getName());
    public static final String HOST = "b2b-services-database.cluster-chustjluqurn.us-east-1.rds.amazonaws.com";
    public static final String PORT = "5432";
    public static final String DATABASE = "user-service";
    public static final String USER = "paloit.aazcarate";
    public static final String PASSWORD = "plJ45$Mz*29";

    public static String otpFromDataBase(String phoneNumber) throws SQLException {

        DatabaseConnector db = new DatabaseConnector(HOST, PORT, DATABASE, USER, PASSWORD);
        db.open();
        String idUser = idUser(phoneNumber);
        String otp = null;
        ResultSet rs = db.executeQuery("select * from tbl_otp where id_user ='"+idUser+"' and status = 'SENT'");
        while (rs.next()) {
            otp = rs.getString("otp");
            LOGGER.info("OTP = " + otp);
        }
        rs.close();
        db.close();
        return otp;
    }

    public static String idUser(String phoneNumber) throws SQLException {
        DatabaseConnector db = new DatabaseConnector(HOST, PORT, DATABASE, USER, PASSWORD);
        db.open();
        ResultSet rs = db.executeQuery("SELECT id FROM tbl_user WHERE mobile = '"+phoneNumber+"'");
        String idUser = null;
        while (rs.next()) {
            idUser = rs.getString("id");
            LOGGER.info("ID = " + idUser);
        }
        rs.close();
        db.close();
        return idUser;
    }


    public static void main(String[] args) throws SQLException {
        otpFromDataBase("0000000000");
    }
}
