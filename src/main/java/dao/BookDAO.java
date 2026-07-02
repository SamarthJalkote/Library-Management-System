//BookDAO has only one job:
//
//Perform database operations on the books table.

package dao;

import model.Book;
import util.DBConnection;

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
}
