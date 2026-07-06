package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;
import service.LibraryService;

import java.io.IOException;
import java.util.List;

@WebServlet("/search-book")
public class SearchBookServlet extends HttpServlet {

    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        List<Book> books = libraryService.searchBooks(keyword);

        request.setAttribute("books", books);

        request.getRequestDispatcher("/view-books.jsp")
                .forward(request, response);
    }
}
