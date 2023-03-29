package dao;

import model.Role;

import java.util.List;

public interface RoleDao {
    void create(Role role);
    void update(Role role);
    void update(List<Role> roleList);
    void delete(Role role);
    Role getRoleById(int id);
    List<Role> getAll();
}
