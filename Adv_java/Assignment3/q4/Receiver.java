package Adv_java.Assignment3.q4;

import java.net.*;
import java.util.Scanner;

public class Receiver {

    public Receiver() throws Exception {
        DatagramSocket socket = new DatagramSocket(2020);
        System.out.println("\nReceiver is running");
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            byte[] buffer = new byte[1500]; // * MTU: Maximum Transmission Unit
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet); // * retrieving sender's message

            String message = new String(packet.getData(), 0, packet.getLength()).trim();
            System.out.println("Received: " + message);

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            InetAddress senderAddress = packet.getAddress();
            int senderPort = packet.getPort();

            System.out.print("Enter your message: ");
            message = keyboard.nextLine();
            buffer = message.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, senderAddress, senderPort);

            socket.send(packet);
            System.out.println("Sent: " + message);

            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }

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
