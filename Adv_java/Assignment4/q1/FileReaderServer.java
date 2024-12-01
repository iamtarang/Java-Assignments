package Adv_java.Assignment4.q1;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class FileReaderServer {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            IFileReader fileReader = new FileReaderImpl();

            // Get the existing registry (assuming the registry was started separately)
            Registry registry = LocateRegistry.getRegistry(1099);

            // Bind the remote object to the registry
            registry.bind("FileReader", fileReader);

            System.out.println("File Reader Server is ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
