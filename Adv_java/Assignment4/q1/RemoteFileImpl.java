package Adv_java.Assignment4.q1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RemoteFileImpl extends UnicastRemoteObject implements RemoteFileInterface {
    // Required constructor
    protected RemoteFileImpl() throws RemoteException {
        super();
    }

    @Override
    public String readFile(String fileName) throws RemoteException {
        try {
            // Read entire file content as string
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (Exception e) {
            // Wrap and rethrow as RemoteException
            throw new RemoteException("Error reading file: " + fileName, e);
        }
    }
}