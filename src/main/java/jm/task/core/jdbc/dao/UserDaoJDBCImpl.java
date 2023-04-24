package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement st = Util.getConnection().createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS Users(" +
                    "id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ," +
                    "name VARCHAR(40) NOT NULL," +
                    "lastname VARCHAR(40) NOT NULL," +
                    "age SMALLINT NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try (Statement st = Util.getConnection().createStatement()){
            st.execute("DROP TABLE IF EXISTS Users;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement st = Util.getConnection().prepareStatement("INSERT INTO Users (name, lastname, age) VALUES (?, ?, ?)")) {
            st.setString(1, name);
            st.setString(2, lastName);
            st.setByte(3, age);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement st = Util.getConnection().prepareStatement("DELETE FROM Users WHERE id = ?")) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Statement st = Util.getConnection().createStatement()) {
            ResultSet set = st.executeQuery("SELECT * FROM Users");
            while (set.next()) {
                long id = set.getLong("id");
                String name = set.getString("name");
                String lastName = set.getString("lastname");
                byte age = set.getByte("age");
                User user = new User(name, lastName, age);
                user.setId(id);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try (Statement st = Util.getConnection().createStatement()) {
            st.executeUpdate("DELETE FROM Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
