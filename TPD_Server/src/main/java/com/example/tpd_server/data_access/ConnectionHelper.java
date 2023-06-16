package com.example.tpd_server.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionHelper {
    private static final String url = "jdbc:postgresql://34.116.167.104:5432/postgres?socketFactory=com.google.cloud.sql.postgres.SocketFactory&cloudSqlInstance=torm-389819:europe-central2:postgre&user=postgres&password=1q2w3e";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(ConnectionHelper.url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;

//    private static final String url = "jdbc:postgresql://127.0.0.1:5432/tpd";
//    private static final String user = "postgres";
//    private static final String password = "1q2w3e";
//
//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection(ConnectionHelper.url, ConnectionHelper.user, ConnectionHelper.password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
    }
}

