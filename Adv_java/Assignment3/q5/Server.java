package Adv_java.Assignment3.q5;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() throws IOException {
		// * Opening a new port */
		ServerSocket serverSocket = new ServerSocket(2020);
		System.out.println("Port 2020 running");

		Socket socket = serverSocket.accept();
		System.out.println("Client " + socket.getInetAddress() + " has connected.");

		// * IO buffer */
		BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		outSocket.println("Welcome!"); //:: Send 'Welcome' to client
		String message = inSocket.readLine();
		System.out.println("Client says: " + message); //:: Display Client's message

		socket.close();
		serverSocket.close();
		System.out.println("Socket closed");
	}

	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
