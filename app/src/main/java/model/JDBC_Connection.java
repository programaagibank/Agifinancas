package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Connection {
    private static final String URL = LeitorDB.getUrlDB();
    private static final String user = LeitorDB.getHostDB();
    private static final String password = LeitorDB.getSenhaDB();

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }
}


