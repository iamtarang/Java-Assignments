package Adv_java.Assignment4.q1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteFileInterface extends Remote {
    // Method to read file contents from remote machine
    String readFile(String fileName) throws RemoteException;
}