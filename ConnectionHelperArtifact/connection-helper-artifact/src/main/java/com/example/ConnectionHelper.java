package com.example.connection_package;

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
    }
}
