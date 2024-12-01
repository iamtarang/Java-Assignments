package Adv_java.Assignment4.q2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

public class BookQueryImpl extends UnicastRemoteObject implements IBookQuery {

    private static final String URL = "jdbc:postgresql://localhost:5432/adv_java";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lakhma9urkar";

    public BookQueryImpl() throws RemoteException {
        super();
    }

    @Override
    public Book queryBook(int bookId) throws RemoteException {
        String querySQL = "SELECT * FROM Book WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(querySQL)) {

            pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                double price = rs.getDouble("Price");

                // Return a Book object with the retrieved data
                return new Book(id, title, author, price);
            } else {
                System.out.println("No book found with ID: " + bookId);
                return null; // No book found
            }
        } catch (SQLException e) {
            // throw new UnsupportedOperationException("Unimplemented method 'queryBook'");
            System.out.println("Error querying book by ID: " + e.getMessage());
            return null;
        }
    }
}
