package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import service.LibraryService;

import java.io.IOException;

@WebServlet("/delete-book")
public class DeleteBookServlet extends HttpServlet {

    private final LibraryService libraryService = new LibraryService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        libraryService.deleteBook(id);

        response.sendRedirect("view-books");
    }
}
