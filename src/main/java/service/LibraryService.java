package service;

import dao.BookDAO;
import model.Book;

public class LibraryService {

    private final BookDAO bookDAO = new BookDAO();

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void viewAllBooks() {
        bookDAO.viewAllBooks();
    }

    public void searchBook(int id) {
        bookDAO.searchBook(id);
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}
