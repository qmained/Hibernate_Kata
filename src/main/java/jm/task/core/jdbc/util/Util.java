package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String url = "jdbc:mysql://localhost:3306/myDb?user=user&password=pass";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
