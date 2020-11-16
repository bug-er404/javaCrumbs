package dao;
import model.Book;
import model.Cart;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.transaction.SystemException;
import javax.transaction.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDB {
    public void addItemToCart(Cart cartitem) throws SystemException {
        org.hibernate.Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            // start transaction
            transaction = session.beginTransaction();
            // save book
            session.save(cartitem);
            // commit change
            transaction.commit();
            session.close();
        }
        catch (Exception e)
        {
            if(transaction!=null)
                transaction.rollback();
        }
    }

    public void updateBook(Book book) throws SystemException {
        org.hibernate.Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            // start transaction
            transaction = session.beginTransaction();
            // save book
            session.saveOrUpdate(book);
            // commit change
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction!=null)
                transaction.rollback();
        }
    }

    public Book selectBook(int id) throws SystemException {
        org.hibernate.Transaction transaction = null;
        Book book = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            // start transaction
            transaction = session.beginTransaction();
            // get book
            book = session.get(Book.class, id);
            // commit change
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction!=null)
                transaction.rollback();
        }
        return book;
    }

    public List<Book> selectAllBooks() throws SystemException {
        org.hibernate.Transaction transaction = null;
        List<Book> books = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            // start transaction
            transaction =  session.beginTransaction();
            // get books
            books = session.createQuery("from Book").list();
            // commit change
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction!=null)
                transaction.rollback();
        }
        return books;
    }

    public void deleteBook(int id) throws SystemException {
        org.hibernate.Transaction transaction = null;
        Book book = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            // start transaction
            transaction = session.beginTransaction();
            // get book
            book = session.get(Book.class, id);
            //delete book
            session.delete(book);
            // commit change
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction!=null)
                transaction.rollback();
        }
    }
}
