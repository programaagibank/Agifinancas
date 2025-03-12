package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {
        private static final String URL = "";
        private static final String user = "";
        private static final String password =  "";
        public static Connection getConnection() throws SQLException{
            return DriverManager.getConnection(URL, user, password);
        }
    }


