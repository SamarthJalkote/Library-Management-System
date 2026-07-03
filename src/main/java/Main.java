import dao.BookDAO;
import model.Book;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();

        while (true) {

            System.out.println("\n========== Library Management System ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Title : ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author : ");
                    String author = scanner.nextLine();

                    System.out.print("Enter Category : ");
                    String category = scanner.nextLine();

                    System.out.print("Enter Price : ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter Quantity : ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Book book = new Book(title, author, category, price, quantity);

                    bookDAO.addBook(book);

                    break;

                case 2:

                    bookDAO.viewAllBooks();

                    break;

                case 3:

                    System.out.print("Enter Book ID : ");
                    int searchId = scanner.nextInt();

                    bookDAO.searchBook(searchId);

                    break;

                case 4:

                    System.out.print("Enter Book ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Title : ");
                    title = scanner.nextLine();

                    System.out.print("Enter New Author : ");
                    author = scanner.nextLine();

                    System.out.print("Enter New Category : ");
                    category = scanner.nextLine();

                    System.out.print("Enter New Price : ");
                    price = scanner.nextDouble();

                    System.out.print("Enter New Quantity : ");
                    quantity = scanner.nextInt();

                    Book updatedBook = new Book(id, title, author, category, price, quantity);

                    bookDAO.updateBook(updatedBook);

                    break;

                case 5:

                    System.out.print("Enter Book ID : ");
                    int deleteId = scanner.nextInt();

                    bookDAO.deleteBook(deleteId);

                    break;

                case 6:

                    System.out.println("Thank you for using Library Management System.");
                    scanner.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }
    }
}
