package Adv_java.Assignment4.q1;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class FileReaderClient {
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object
            IFileReader fileReader = (IFileReader) registry.lookup("FileReader");

            // Call the remote method
            String fileName = "C:\\MCA\\Sem 3\\College material\\Adv Java\\Java_Assignments\\Adv_java\\Assignment4\\q1\\sample.txt";
            String content = fileReader.readFile(fileName);

            System.out.println("File content:");
            System.out.println(content);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
