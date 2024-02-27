package com.mycompany.proj_arnaualberto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
        Connection getConnection() throws SQLException {
        String BD_URL = String.format("%s//%s/%s", "jdbc:mysql:", "localhost", "escuela");
        Connection conn;
        conn = DriverManager.getConnection(BD_URL, "root", "123456");
        return conn;
    }
}
