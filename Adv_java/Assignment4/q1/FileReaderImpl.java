package Adv_java.Assignment4.q1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileReaderImpl extends UnicastRemoteObject implements IFileReader {

    public FileReaderImpl() throws RemoteException {
        super();
    }

    @Override
    public String readFile(String fileName) throws RemoteException {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RemoteException("Error reading file: " + e.getMessage());
        }
    }
}
