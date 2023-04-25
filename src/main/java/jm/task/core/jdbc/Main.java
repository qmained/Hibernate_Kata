package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService service = new UserServiceImpl();

        service.createUsersTable();

        service.saveUser("Name1", "LastName1", (byte) 20);
        System.out.printf("User с именем - %s добавлен в базу данных\n", "Name1");
        service.saveUser("Name255", "LastName2", (byte) 25);
        System.out.printf("User с именем - %s добавлен в базу данных\n", "Name2");
        service.saveUser("Name3", "LastName3", (byte) 31);
        System.out.printf("User с именем - %s добавлен в базу данных\n", "Name3");
        service.saveUser("Name4", "LastName4", (byte) 38);
        System.out.printf("User с именем - %s добавлен в базу данных\n", "Name4");

        service.removeUserById(1);
        for (var val : service.getAllUsers()) {
            System.out.println(val);
        }
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
