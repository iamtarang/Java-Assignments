package Adv_java.Assignment3.q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public Sender() throws Exception {
        // Create a DatagramSocket for UDP communication
        DatagramSocket socket = new DatagramSocket();
        
        // Use BufferedReader with InputStreamReader to read from System.in
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            // Sending
            System.out.print("Enter your message: ");
            
            // Use readLine() instead of nextLine() from Scanner
            String message = keyboard.readLine();
            
            // Convert message to byte array for UDP packet
            byte[] buffer = message.getBytes();
            
            // Create DatagramPacket to send to localhost on port 2020
            DatagramPacket packet = new DatagramPacket(
                buffer, 
                buffer.length, 
                InetAddress.getByName("localhost"), 
                2020
            );
            
            // Send the packet
            socket.send(packet);
            System.out.println("Sent: " + message);
            
            // Receiving
            buffer = new byte[1500];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            
            // Convert received packet data to string
            message = new String(packet.getData(), 0, packet.getLength()).trim();
            System.out.println("Received: " + message);
            
            // Exit condition
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }
        
        // Close resources
        socket.close();
        keyboard.close();
    }
    
    public static void main(String[] args) {
        try {
            new Sender();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}