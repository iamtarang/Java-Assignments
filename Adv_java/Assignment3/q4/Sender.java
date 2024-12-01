package Adv_java.Assignment3.q4;

import java.net.*;
import java.util.Scanner;

public class Sender {

    public Sender() throws Exception {
        DatagramSocket socket = new DatagramSocket();
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            // * Sending
            System.out.print("Enter your message: ");
            String message = keyboard.nextLine();
            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 2020);
            socket.send(packet);
            System.out.println("Sent: " + message);

            // * Receiving
            buffer = new byte[1500];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            message = new String(packet.getData(), 0, packet.getLength()).trim();
            System.out.println("Received: " + message);

            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }

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
