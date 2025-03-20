package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {
        private static final String URL = "jdbc:mysql://agifinancas-agifinancas.l.aivencloud.com:14516/Agifinancas?ssl-mode=REQUIRED\n";
        private static final String user = "avnadmin";
        private static final String password =  "AVNS_kMcehxiSc5HYiaQpAj5";
        public static Connection getConnection() throws SQLException{
            return DriverManager.getConnection(URL, user, password);
        }
    }


