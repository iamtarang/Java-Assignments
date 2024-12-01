package Adv_java.Assignment3.q1;

import java.io.*;
import java.net.*;

public class Server {

    public Server() throws IOException {
        // * Opening a new port
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("\nPort 2020 running");

        try (Socket socket = serverSocket.accept()) {

            System.out.println("Client " + socket.getInetAddress() + " has connected.");

            // * IO stream for client
            PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);

            // * File to read
            File file = new File("C:\\MCA\\Sem 3\\College material\\Adv Java\\Java_Assignments\\Adv_java\\Assignment3\\q1\\sample.txt");
            BufferedReader fileReader = new BufferedReader(new FileReader(file));

            // * Read the file and send each line to the client
            String line;
            while ((line = fileReader.readLine()) != null) {
                outSocket.println(line);
            }

            // * Close file reader and notify client of completion
            fileReader.close();
            System.out.println("File sent to client.");

            socket.close();
            serverSocket.close();
            System.out.println("Socket closed");

        } catch (IOException exception) {
            System.err.println(exception);
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
