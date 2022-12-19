package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
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
    UserDaoJDBCImpl usdji = new UserDaoJDBCImpl();
    public void createUsersTable() {
        usdji.createUsersTable();

    }

    public void dropUsersTable() {
        usdji.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        usdji.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        usdji.removeUserById(id);

    }

    public List<User> getAllUsers() {
        return usdji.getAllUsers();
    }

    public void cleanUsersTable() {
        usdji.cleanUsersTable();
    }
}
