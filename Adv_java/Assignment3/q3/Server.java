package Adv_java.Assignment3.q3;

import java.io.*;
import java.net.*;
// import javax.crypto.SecretKey;

public class Server {

    public Server() throws Exception {
        // Generate the AES encryption key
        Encryptor.generateKey();
        byte[] secretKey = Encryptor.getSecretKey();

        // Open a server socket
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Server is running on port 2020...");

        try (Socket socket = serverSocket.accept()) {
            System.out.println("Client connected: " + socket.getInetAddress());

            // Send the AES key to the client
            ObjectOutputStream keyOut = new ObjectOutputStream(socket.getOutputStream());
            keyOut.writeObject(secretKey);
            keyOut.flush();

            // Send encrypted file contents
            PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
            File file = new File("./sample.txt");
            BufferedReader fileReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = fileReader.readLine()) != null) {
                String encryptedLine = Encryptor.encrypt(line);
                outSocket.println(encryptedLine);
            }

            // Close resources
            fileReader.close();
            socket.close();
            serverSocket.close();
            System.out.println("File sent successfully. Server closed.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
