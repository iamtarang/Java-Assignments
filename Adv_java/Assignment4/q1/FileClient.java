package Adv_java.Assignment4.q1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileClient {
    public static void main(String[] args) {
        try {
            // Connect to RMI registry
            Registry registry = LocateRegistry.getRegistry("localhost", 3000);

            // Lookup the remote object
            RemoteFileInterface fileService = 
                (RemoteFileInterface) registry.lookup("FileService");

            // Read file from remote server
            String fileContent = fileService.readFile("C:\\MCA\\Sem 3\\College material\\Adv Java\\Java_Assignments\\Adv_java\\Assignment3\\q1\\sample.txt");
            
            // Display file contents
            System.out.println("File Contents:\n" + fileContent);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}