package Adv_java.Assignment3.q1;

import java.io.*;
import java.net.*;

public class Client {

    public Client() throws UnknownHostException, IOException {
        try (Socket socket = new Socket("localhost", 2020)) {

            System.out.println("\nConnected to server successfully. Reading file content.");

            BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read and print each line received from the server
            String line;
            while ((line = inSocket.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("File content received.");
            socket.close();
            System.out.println("Socket closed.");
            
        } catch (IOException e) {
            System.err.println(e);
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