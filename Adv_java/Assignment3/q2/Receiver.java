package Adv_java.Assignment3.q2;

import java.net.*;

public class Receiver {

    public Receiver() throws Exception {
        DatagramSocket socket = new DatagramSocket(2020);
        System.out.println("Receiver is running and waiting for file...");

        byte[] buffer = new byte[1500];
        boolean receiving = true;

        while (receiving) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength()).trim();

            // * Check for EOF signal
            if (message.equals("EOF")) {
                System.out.println("EOF signal received. File transfer complete.");
                receiving = false;
            } else {
                System.out.print(message);
            }
        }

        socket.close();
    }

    public static void main(String[] args) {
        try {
            new Receiver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
