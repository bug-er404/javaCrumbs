package dao;

import model.Book;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.transaction.SystemException;
import java.util.List;

public class UserDB {
    public User getUser() throws SystemException {
        org.hibernate.Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start transaction
            transaction = session.beginTransaction();
            // get book
            user = session.get(User.class, 1);
            // commit change
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return user;
    }
}
