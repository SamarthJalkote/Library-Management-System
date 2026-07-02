import dao.BookDAO;
import model.Book;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();

        System.out.println("===== Library Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {

            System.out.print("Enter Title: ");
            String title = scanner.nextLine();

            System.out.print("Enter Author: ");
            String author = scanner.nextLine();

            System.out.print("Enter Category: ");
            String category = scanner.nextLine();

            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();

            Book book = new Book(title, author, category, price, quantity);

            bookDAO.addBook(book);

        }
        else if (choice == 2) {

            bookDAO.viewAllBooks();

        }
        else {

            System.out.println("Invalid Choice");

        }

        scanner.close();
    }
}
