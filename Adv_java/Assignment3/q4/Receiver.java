package Adv_java.Assignment3.q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver {
    public Receiver() throws Exception {
        // Create a DatagramSocket listening on port 2020
        DatagramSocket socket = new DatagramSocket(2020);
        System.out.println("\nReceiver is running");
        
        // Use BufferedReader with InputStreamReader to read from System.in
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            // Prepare buffer for receiving messages
            // MTU: Maximum Transmission Unit (1500 bytes is standard Ethernet frame size)
            byte[] buffer = new byte[1500];
            
            // Create DatagramPacket to receive incoming data
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            // Wait and receive message from sender
            socket.receive(packet);
            
            // Convert received packet to readable string
            String message = new String(packet.getData(), 0, packet.getLength()).trim();
            System.out.println("Received: " + message);
            
            // Check for exit condition
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
            
            // Get sender's address and port for reply
            InetAddress senderAddress = packet.getAddress();
            int senderPort = packet.getPort();
            
            // Prepare to send a response
            System.out.print("Enter your message: ");
            message = keyboard.readLine();
            
            // Convert message to bytes
            buffer = message.getBytes();
            
            // Create packet to send back to the sender
            packet = new DatagramPacket(
                buffer, 
                buffer.length, 
                senderAddress, 
                senderPort
            );
            
            // Send the response
            socket.send(packet);
            System.out.println("Sent: " + message);
            
            // Check for exit condition on sent message
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
            new Receiver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}