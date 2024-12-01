package Adv_java.Assignment4.q2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BookClient {
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object
            IBookQuery bookQuery = (IBookQuery) registry.lookup("BookQuery");

            // Call the remote method
            int id = 1;
            Book bookData = bookQuery.queryBook(id);
        
            bookData.toString();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
