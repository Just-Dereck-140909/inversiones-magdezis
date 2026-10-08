package main.java.com.ingsoft.inversiones.magdezis.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(Credentials.URL_MYSQL_DB, Credentials.USER_DB, Credentials.PASS_DB
        );
    }
}