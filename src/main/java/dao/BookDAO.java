//BookDAO has only one job:
//
//Perform database operations on the books table.

package dao;

import model.Book;
import util.DBConnection;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class BookDAO {

    public void addBook(Book book) {

        String sql = "INSERT INTO books(title, author, category, price, quantity) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, book.getQuantity());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book added successfully!");
            } else {
                System.out.println("Failed to add book.");
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    public void viewAllBooks() {

        String sql = "SELECT * FROM books";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery();
        ) {

            while (resultSet.next()) {

                System.out.println("------------------------------");
                System.out.println("ID : " + resultSet.getInt("id"));
                System.out.println("Title : " + resultSet.getString("title"));
                System.out.println("Author : " + resultSet.getString("author"));
                System.out.println("Category : " + resultSet.getString("category"));
                System.out.println("Price : " + resultSet.getDouble("price"));
                System.out.println("Quantity : " + resultSet.getInt("quantity"));

            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void searchBook(int id) {

        String sql = "SELECT * FROM books WHERE id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {

                System.out.println("-------------------------------------");
                System.out.println("ID       : " + resultSet.getInt("id"));
                System.out.println("Title    : " + resultSet.getString("title"));
                System.out.println("Author   : " + resultSet.getString("author"));
                System.out.println("Category : " + resultSet.getString("category"));
                System.out.println("Price    : " + resultSet.getDouble("price"));
                System.out.println("Quantity : " + resultSet.getInt("quantity"));

            } else {

                System.out.println("Book not found.");

            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // Update Book
    public void updateBook(Book book) {

        String sql = "UPDATE books SET title=?, author=?, category=?, price=?, quantity=? WHERE id=?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, book.getQuantity());
            ps.setInt(6, book.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("Book not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }


    public void deleteBook(int id) {

        String sql = "DELETE FROM books WHERE id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Book not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {

                Book book = new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity")
                );

                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book getBookById(int id) {

        String sql = "SELECT * FROM books WHERE id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new Book(

                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    
}
