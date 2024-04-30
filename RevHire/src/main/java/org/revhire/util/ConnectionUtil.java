package org.revhire.util;

import java.sql.*;

public class ConnectionUtil {
    public static Connection getConnection(){
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String  url = "jdbc:sqlserver://localhost;databaseName=RevPro;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       return connection;
    }

}
