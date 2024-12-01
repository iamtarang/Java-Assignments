package Adv_java.Assignment2.q3;

import java.sql.*;

public class PLSQL {

    private static final String URL = "jdbc:postgresql://localhost:5432/adv_java";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lakhma9urkar";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            createStoredProcedure(conn);
            callStoredProcedure(conn);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void createStoredProcedure(Connection conn) {
        String createProcedureSQL = 
                "CREATE OR REPLACE PROCEDURE update_book_prices() " +
                "LANGUAGE plpgsql " +
                "AS $$ " +
                "BEGIN " +
                "    UPDATE Book " +
                "    SET Price = Price * 1.10 " +
                "    WHERE Price > 500; " +
                "    UPDATE Book " +
                "    SET Price = Price * 1.05 " +
                "    WHERE Price <= 500; " +
                "END; " +
                "$$";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createProcedureSQL);
            System.out.println("Stored procedure 'update_book_prices' created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating stored procedure: " + e.getMessage());
        }
    }

    public static void callStoredProcedure(Connection conn) {
        String callSQL = "CALL update_book_prices()";

        try (CallableStatement cstmt = conn.prepareCall(callSQL)) {
            cstmt.execute();
            System.out.println("Book prices updated successfully by stored procedure.");
        } catch (SQLException e) {
            System.out.println("Error calling stored procedure: " + e.getMessage());
        }
    }
}
