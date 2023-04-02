package dao.impl;

import config.HibernateSessionFactoryUtil;
import dao.UserRoleDao;
import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserRoleDaoImpl implements UserRoleDao {

    @Override
    public void createUser(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public void createRole(Role role) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        }
    }

    @Override
    public void updateUser(User user) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }

    @Override
    public void deleteUser(int id) {
        User user;

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            user = session.get(User.class, id);
            if(!(user == null)) {
                session.remove(user);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User readUserById(int id) {
        User user = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            user = session.get(User.class, id);
            System.out.println(user + " " + user.getRoleList());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Role readRoleById(int id) {
        Role role = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            role = session.get(Role.class, id);
            System.out.println(role + " " + role.getUsers());
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public List<User> readAllUsers() {
        List<User> users;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            users = session.createQuery("FROM User", User.class).list();
            System.out.println(users);
            transaction.commit();
        }
        return users;
    }

}
