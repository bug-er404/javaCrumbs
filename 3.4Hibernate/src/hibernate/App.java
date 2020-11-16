package hibernate;

import dao.BookDB;
import model.Book;

import javax.transaction.SystemException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SystemException
    {

        BookDB bookdb = new BookDB();

        // test inserting book
        Book book = new Book("The poems","Rumi",  7.99);
        bookdb.insertBook(book);

        // get book by id
        Book book1 = bookdb.selectBook(book.getBookId());
        System.out.println(book1.getTitle());

        // get all books
        List<Book> books = bookdb.selectAllBooks();
        books.forEach(book2->System.out.println(book2.getTitle()));

        // test delete book
        bookdb.deleteBook(book1.getBookId());

    }
}
