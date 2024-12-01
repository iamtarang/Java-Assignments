package Adv_java.Assignment3.q5;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public Client() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 3030); // Connect to ProxyServer on port 3030
		System.out.println("Connected to proxy server successfully");

		BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		String message = inSocket.readLine(); // Receive welcome message from Server (via ProxyServer)
		outSocket.println("Thanks"); // Send response back to Server (via ProxyServer)
		System.out.println("Server says: " + message);

		socket.close();
		System.out.println("Socket closed.");
	}

	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
