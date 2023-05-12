package com.example.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    private static PreparedStatement preparedStatement;
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String ipAddress = "//127.0.0.1:3306/recipes";
    private static final String jdbcURL = protocol + vendorName + ipAddress + "?connectionTimeZone=SERVER";
    private static final String MYSQLJDBCDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;
    public static final String username = "root";
    public static final String password = "!=?zFGH7";
    public static Connection initiateConnection(){
        try{
            Class.forName(MYSQLJDBCDriver);
            conn = (Connection) DriverManager.getConnection(jdbcURL, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    public static Connection getConnection() {
        return conn;
    }
    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void setPreparedStatement(Connection conn, String sqlStatement) throws SQLException {preparedStatement = conn.prepareStatement(sqlStatement);}
    public static PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }


}
