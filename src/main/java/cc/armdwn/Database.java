package cc.armdwn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/keepclone";
        return DriverManager.getConnection(url, "admin", "adminpassword");
    }
}