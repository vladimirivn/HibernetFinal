import dao.RoleDao;
import dao.UserDao;
import dao.impl.RoleDaoImpl;
import dao.impl.UserDaoImpl;
import model.Role;
import model.User;

import java.util.List;
import java.util.Set;

public class Main {
    private static final UserDao USER_DAO = new UserDaoImpl();
    private static final RoleDao ROLE_DAO = new RoleDaoImpl();

    public static void main(String[] args) {

        Role role = new Role("ADMIN");
        Role role1 = new Role("USER");

        User user = new User(1,"Ivan", "Ivanov", "qwerty", role);
        User user1 = new User(2,"Sergey", "Sergeev", "qazwsx", role1);
        User user2 = new User(3,"Petr", "Petrov", "fgfgfgfgfg", role1);


        ROLE_DAO.create(role);
        ROLE_DAO.create(role1);
        USER_DAO.create(user);
        USER_DAO.create(user1);
        USER_DAO.create(user2);

//        System.out.println("--------Вывод всех ролей---------------------");
//        ROLE_DAO.getAll().forEach(System.out::println);

//        System.out.println("--------Вывод всех пользователей без ролей-----------");
//        USER_DAO.getUsers().forEach(System.out::println);
//        System.out.println("--------Вывод пользователей по ролям-----------------");
//        USER_DAO.getByRole(role).forEach(System.out::println);
//        USER_DAO.getByRole(role1).forEach(System.out::println);
//        System.out.println("--------Удаление пользователя---------------------");
//        USER_DAO.deleteUser(USER_DAO.readById(user2.getId()));
//        USER_DAO.getUsers().forEach(System.out::println);
        System.out.println("--------Удаление роли ---------------------");
        ROLE_DAO.delete(ROLE_DAO.getRoleById(role1.getId()));
        USER_DAO.getUsers().forEach(System.out::println);
    }
}
