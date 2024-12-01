package Adv_java.Assignment3.q3;

import java.io.*;
import java.net.*;

public class Client {

    public Client() throws Exception {
        try (Socket socket = new Socket("localhost", 2020)) {
            System.out.println("Connected to server.");

            // Receive the AES key from the server
            ObjectInputStream keyIn = new ObjectInputStream(socket.getInputStream());
            byte[] secretKey = (byte[]) keyIn.readObject();
            Encryptor.setSecretKey(secretKey);

            // Receive and decrypt file contents
            BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String encryptedLine;
            while ((encryptedLine = inSocket.readLine()) != null) {
                String decryptedLine = Encryptor.decrypt(encryptedLine);
                System.out.println(decryptedLine);
            }

            // Close resources
            socket.close();
            System.out.println("File content received and decrypted successfully.");
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
