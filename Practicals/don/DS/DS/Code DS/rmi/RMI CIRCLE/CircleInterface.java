import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CircleInterface extends Remote {
    double calculateArea(double radius) throws RemoteException;
}

