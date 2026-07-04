package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;
import service.LibraryService;

import java.io.IOException;

@WebServlet("/edit-book")
public class EditBookServlet extends HttpServlet {

    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Book book = libraryService.getBookById(id);

        request.setAttribute("book", book);

        request.getRequestDispatcher("/edit-book.jsp")
                .forward(request, response);
    }
}
