package Adv_java.Assignment3.q2;

import java.io.*;
import java.net.*;

public class Sender {

    private static final String FILE_PATH = "C:\\MCA\\Sem 3\\College material\\Adv Java\\Java_Assignments\\Adv_java\\Assignment3\\q2\\sample.txt";

    public Sender() throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress receiverAddress = InetAddress.getByName("localhost");

        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH)) {
            byte[] buffer = new byte[1500];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                DatagramPacket packet = new DatagramPacket(buffer, bytesRead, receiverAddress, 2020);
                socket.send(packet);
                System.out.println("Sent packet of size: " + bytesRead);
            }
            
            byte[] eofSignal = "EOF".getBytes();
            DatagramPacket eofPacket = new DatagramPacket(eofSignal, eofSignal.length, receiverAddress, 2020);
            socket.send(eofPacket);
            System.out.println("File transfer complete. Sent EOF signal.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    public static void main(String[] args) {
        try {
            new Sender();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
