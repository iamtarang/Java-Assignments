package Adv_java.Assignment1.q1;

import java.io.*;

public class BookManagementSystem {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.println("\nBook Management System");
                System.out.println("1. Add Book");
                System.out.println("2. Display All Books");
                System.out.println("3. Search Book");
                System.out.println("4. Update Book");
                System.out.println("5. Delete Book");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                String choice = reader.readLine();

                try {
                    switch (choice) {
                        case "1":
                            manager.addBook();
                            break;
                        case "2":
                            manager.displayAllBooks();
                            break;
                        case "3":
                            manager.searchBook();
                            break;
                        case "4":
                            manager.updateBook();
                            break;
                        case "5":
                            manager.deleteBook();
                            break;
                        case "6":
                            System.out.println("Thank you for using Book Management System!");
                            reader.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice! Please try again.");
                            break;
                    }
                } catch (IOException e) {
                    System.out.println("Error processing request: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}
