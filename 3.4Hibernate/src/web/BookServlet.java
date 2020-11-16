package web;

import dao.BookDB;
import dao.CartDB;
import dao.UserDB;
import model.Book;
import model.Cart;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class BookServlet extends HttpServlet {
    private BookDB bookDB;
    private UserDB userDB;
    private CartDB cartDB;

    public BookServlet() {
        this.bookDB = new BookDB();
        this.userDB = new UserDB();
        this.cartDB = new CartDB();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertBook(request, response);
                    break;
                case "/delete":
                    deleteBook(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateBook(request, response);
                    break;
                case "/addtocart":
                    addToCart(request,response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (SystemException exc) {
            throw new ServletException(exc);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("new.jsp");
        dispatcher.forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SystemException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Float price = Float.valueOf(request.getParameter("price"));
        Book newBook = new Book(title, author, price);
        bookDB.insertBook(newBook);
        response.sendRedirect("list");
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SystemException {
        Book book = bookDB.selectBook(Integer.parseInt(request.getParameter("id")));
        User user = userDB.getUser();
        Cart newCart = new Cart(book, user);
        cartDB.addItemToCart(newCart);

        response.sendRedirect("list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SystemException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDB.deleteBook(id);
        response.sendRedirect("list");
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SystemException {
        List<Book> listBook = bookDB.selectAllBooks();
        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SystemException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDB.selectBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("new.jsp");
        request.setAttribute("book", existingBook);
        dispatcher.forward(request, response);
    }


    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SystemException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Float price = Float.valueOf(request.getParameter("price"));

        Book book = new Book(id, title, author, price);
        bookDB.updateBook(book);
        response.sendRedirect("list");
    }

}
