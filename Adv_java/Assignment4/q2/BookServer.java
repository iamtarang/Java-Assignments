package Adv_java.Assignment4.q2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BookServer {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            IBookQuery bookQuery = new BookQueryImpl();

            // Get the existing registry (assuming the registry was started separately)
            Registry registry = LocateRegistry.getRegistry(1099);

            // Bind the remote object to the registry
            registry.bind("BookQuery", bookQuery);

            System.out.println("Book query Server is ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
