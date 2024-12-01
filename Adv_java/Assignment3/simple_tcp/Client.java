package Adv_java.Assignment3.simple_tcp;

import java.io.*;

import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public Client() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 2020);
		System.out.println("Connected to server successfully");

		BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		String message = inSocket.readLine();
		outSocket.println("Thanks");
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
