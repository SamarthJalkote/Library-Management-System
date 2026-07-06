package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;
import service.LibraryService;

import java.io.IOException;

@WebServlet("/update-book")
public class UpdateBookServlet extends HttpServlet {

    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String category = request.getParameter("category");

        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Book book = new Book(id, title, author, category, price, quantity);

        libraryService.updateBook(book);

        response.sendRedirect("view-books?message=Book updated successfully");
    }
}
