package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Const;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    Util util = new Util();
    public void createUsersTable() {
        String insert = "CREATE TABLE" + " " + "IF NOT EXISTS" + " " + "users" +
                "(" +
                Const.USER_ID + " " + "INT AUTO_INCREMENT PRIMARY KEY NOT NULL" + "," +
                Const.USER_NAME + " " + "VARCHAR(45)" + "," +
                Const.USER_LASTNAME + " " + "VARCHAR(45)" + "," +
                Const.USER_AGE + " " + "TINYINT" + ")";
        try {
            PreparedStatement prSt = util.getDbConnection().prepareStatement(insert);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
        }

    }

    public void dropUsersTable() {
        String insert = "DROP TABLE IF EXISTS users;";
        try {
            PreparedStatement prSt = util.getDbConnection().prepareStatement(insert);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "("
                + Const.USER_NAME + "," + Const.USER_LASTNAME + "," +
                Const.USER_AGE + ")" + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = util.getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, lastName);
            prSt.setInt(3, age);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {

        }
    }

    public void removeUserById(long id) {

        String insert = "DELETE from users where id=" + id;
        try {
            PreparedStatement prSt = util.getDbConnection().prepareStatement(insert);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
        }

    }

    public List<User> getAllUsers() {
        String insert = "select id, firstname, lastName, age from users";
        ResultSet rs;
        List<User> list = new ArrayList<>();
        try {PreparedStatement prSt = util.getDbConnection().prepareStatement(insert);
        rs = prSt.executeQuery(insert);

        while (rs.next()) {
            User user = new User(rs.getString(2),
                    rs.getString(3), (byte) rs.getByte(4));
            list.add(user);
        }
        }catch (SQLException | ClassNotFoundException e) {
        }
        return list;
    }

    public void cleanUsersTable() {
        String insert = "TRUNCATE users;";
        try {
            PreparedStatement prSt = util.getDbConnection().prepareStatement(insert);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
        }
    }
}
