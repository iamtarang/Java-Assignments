package Adv_java.Assignment3.q5;

import java.io.*;
import java.net.*;

public class ProxyServer {

	public ProxyServer() throws IOException {
		// Start ProxyServer on port 3030
		ServerSocket proxySocket = new ServerSocket(3030);
		System.out.println("ProxyServer is running on port 3030");

		// Accept client connection
		Socket clientSocket = proxySocket.accept();
		System.out.println("Client connected: " + clientSocket.getInetAddress());

		// Connect to the actual Server on port 2020
		Socket serverSocket = new Socket("localhost", 2020);
		System.out.println("Connected to actual Server on port 2020");

		// Streams for communication with Client
		BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);

		// Streams for communication with Server
		BufferedReader serverIn = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		PrintWriter serverOut = new PrintWriter(serverSocket.getOutputStream(), true);

		// Relay message from Server to Client (e.g., "Welcome!")
		String messageFromServer = serverIn.readLine();
		System.out.println("Received from Server: " + messageFromServer);
		clientOut.println(messageFromServer); // Send to Client

		// Relay message from Client to Server (e.g., "Thanks")
		String messageFromClient = clientIn.readLine();
		System.out.println("Received from Client: " + messageFromClient);
		serverOut.println(messageFromClient); // Send to Server

		// Close all resources
		clientSocket.close();
		serverSocket.close();
		proxySocket.close();
		System.out.println("ProxyServer closed.");
	}

	public static void main(String[] args) {
		try {
			new ProxyServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

