import dao.UserRoleDao;
import dao.impl.UserRoleDaoImpl;
import model.Role;
import model.User;

import java.util.List;


public class Main {
    private static final UserRoleDao USER_ROLE_DAO = new UserRoleDaoImpl();

    public static void main(String[] args) {

        Role role = new Role("ADMIN");
        Role role1 = new Role("USER");
        Role role2 = new Role("GUEST");

        USER_ROLE_DAO.createRole(role);
        USER_ROLE_DAO.createRole(role1);
        USER_ROLE_DAO.createRole(role2);

        User user = new User(1,"Ivan", "Ivanov", "qwerty",List.of(role));
        User user1 = new User(2,"Sergey", "Sergeev", "qazwsx",List.of(role1, role2));
        User user2 = new User(3,"Petr", "Petrov", "fgfgfgfgfg",List.of(role, role2));

        USER_ROLE_DAO.createUser(user);
        USER_ROLE_DAO.createUser(user1);
        USER_ROLE_DAO.createUser(user2);


//        System.out.println("--------Вывод всех пользователей без ролей-----------");
//        USER_ROLE_DAO.readAllUsers();

//        System.out.println("--------Вывод пользователя с его ролями-----------------");
//        USER_ROLE_DAO.readUserById(3);
//
//        System.out.println("--------Вывод пользователей по ролям-----------------");
//        USER_ROLE_DAO.readRoleById(3);

//        System.out.println("--------Удаление пользователя---------------------");
//        USER_ROLE_DAO.deleteUser(4);
//        USER_ROLE_DAO.readAllUsers();

          System.out.println("--------Обновление пользователя ---------------------");
          user.setPassword("11111");
          user.setRoleList(List.of(role,role1));
          USER_ROLE_DAO.updateUser(user);
          USER_ROLE_DAO.readAllUsers();
    }
}
