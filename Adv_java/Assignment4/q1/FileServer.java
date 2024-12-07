package Adv_java.Assignment4.q1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileServer {
    public static void main(String[] args) {
        try {
            // Create remote object
            RemoteFileInterface fileService = new RemoteFileImpl();

            // Create RMI registry on port 1099 (default RMI port)
            Registry registry = LocateRegistry.createRegistry(3000);

            // Bind remote object to registry
            registry.rebind("FileService", fileService);

            System.out.println("File Service is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}