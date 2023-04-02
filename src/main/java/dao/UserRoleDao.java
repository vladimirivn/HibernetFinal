package dao;

import model.Role;
import model.User;

import java.util.List;

public interface UserRoleDao {

    void createUser(User user);
    void createRole(Role role);
    void updateUser(User user);
    void deleteUser(int id);
    User readUserById(int id);
    Role readRoleById(int id);
    List<User> readAllUsers();









}
