package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class LeitorDB {
    public static String getUrlDB(){
        String url;
        String userHome = System.getProperty("user.home");
        Properties prop = new Properties();
        try {
            FileInputStream arq = new FileInputStream(userHome+"\\agiFinancas\\config.txt");
            prop.load(arq);
            arq.close();
            url = prop.getProperty("url");
            return url;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getHostDB(){
        String host;
        String userHome = System.getProperty("user.home");
        Properties prop = new Properties();
        try {
            FileInputStream arq = new FileInputStream(userHome+"\\agiFinancas\\config.txt");
            prop.load(arq);
            arq.close();
            host = prop.getProperty("host");
            return host;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getSenhaDB(){
        String senha;
        String userHome = System.getProperty("user.home");
        Properties prop = new Properties();
        try {
            FileInputStream arq = new FileInputStream(userHome+"\\agiFinancas\\config.txt");
            prop.load(arq);
            arq.close();
            senha = prop.getProperty("senha");
            return senha;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            LeitorDB.getUrlDB();
            Connection conn = JDBC_Connection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
