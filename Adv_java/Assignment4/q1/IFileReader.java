package Adv_java.Assignment4.q1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFileReader extends Remote {
    String readFile(String fileName) throws RemoteException;
}
