package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Name1", "LastName1", (byte) 20);
        System.out.printf("User с именем - %s добавлен в базу данных\n", "Name1");
        userDao.saveUser("Name2", "LastName2", (byte) 25);
        System.out.printf("User с именем - %s добавлен в базу данных\n", "Name2");
        userDao.saveUser("Name3", "LastName3", (byte) 31);
        System.out.printf("User с именем - %s добавлен в базу данных\n", "Name3");
        userDao.saveUser("Name4", "LastName4", (byte) 38);
        System.out.printf("User с именем - %s добавлен в базу данных\n", "Name4");


        userDao.removeUserById(1);
        for (var val : userDao.getAllUsers()) {
            System.out.println(val);
        }
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
