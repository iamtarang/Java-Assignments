package Adv_java.Assignment4.q2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBookQuery extends Remote{
    Book queryBook (int bookId) throws RemoteException;
}
