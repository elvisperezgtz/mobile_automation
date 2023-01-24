package femsa.utils.database;

import java.sql.*;

public class DatabaseConnector {
    private String host;
    private String port;
    private String database;
    private String username;
    private String password;
    private Connection connection;

    public DatabaseConnector(String host, String port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public void open() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://" + host + ":" + port + "/" + database,
                username,
                password);
    }

    public void close() throws SQLException {
        connection.close();
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public int update(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }

}

