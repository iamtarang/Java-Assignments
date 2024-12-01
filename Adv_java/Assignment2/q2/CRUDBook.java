package Adv_java.Assignment2.q2;

import java.sql.*;

public class CRUDBook {

    private static final String URL = "jdbc:postgresql://localhost:5432/adv_java";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lakhma9urkar";

    public static void main(String[] args) {
        insertBook("Book Title 1", "Author 1", 550.0);
        updateBookPrice(1, 620.0);
        deleteBook(2);
        queryBooks();
    }

    // insert a new book into the Book table
    public static void insertBook(String title, String author, double price) {
        String insertSQL = "INSERT INTO Book (Title, Author, Price) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setDouble(3, price);

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("Inserted " + rowsInserted + " book(s) successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting book: " + e.getMessage());
        }
    }

    // update the price of a book
    public static void updateBookPrice(int ID, double newPrice) {
        String updateSQL = "UPDATE Book SET Price = ? WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setDouble(1, newPrice);
            pstmt.setInt(2, ID);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Updated " + rowsUpdated + " book(s) successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    // delete a book
    public static void deleteBook(int ID) {
        String deleteSQL = "DELETE FROM Book WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

            pstmt.setInt(1, ID);

            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("Deleted " + rowsDeleted + " book(s) successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }

    // query and display all books
    public static void queryBooks() {
        String querySQL = "SELECT * FROM Book";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(querySQL)) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                double price = rs.getDouble("Price");

                System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Price: " + price);
            }
        } catch (SQLException e) {
            System.out.println("Error querying books: " + e.getMessage());
        }
    }
}
