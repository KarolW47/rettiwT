package com.sda.rettiwt.hibernate.dao;

import com.sda.rettiwt.hibernate.config.HibernateUtils;
import com.sda.rettiwt.hibernate.entity.User;
import lombok.NonNull;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class UserDao extends AbstractDao<User> {

    private static UserDao userDao;

    public static final String USER_SESSION = "mysessioncookie";

    public static UserDao getInstance() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public Optional<User> checkUserByEmailAndPassword(final @NonNull String email, final @NonNull String password) {
        Session session = HibernateUtils.getSession();
        try {
            String hql = "from User u where upper(u.email) = upper(:email) and u.pass = :password";
            List<User> users = session.createQuery(hql)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .list();

            if(users.size() == 1){
                return Optional.of(users.get(0));
            }
            return Optional.empty();
        } catch (HibernateException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


    @Override
    protected Class<User> getClazz() {
        return User.class;
    }
}
