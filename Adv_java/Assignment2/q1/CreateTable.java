package Adv_java.Assignment2.q1;

import java.sql.*;

public class CreateTable {
    private static final String URL = "jdbc:postgresql://localhost:5432/adv_java";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lakhma9urkar";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Book ("
                    + "ID SERIAL PRIMARY KEY, "
                    + "Title VARCHAR(100), "
                    + "Author VARCHAR(100), "
                    + "Price DECIMAL(10, 2))";
            Statement stmt = conn.createStatement();
            stmt.execute(createTableSQL);
            System.out.println("Book table created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
