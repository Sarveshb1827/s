import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Circle extends UnicastRemoteObject implements CircleInterface {
    protected Circle() throws RemoteException {
        super();
    }

    @Override
    public double calculateArea(double radius) throws RemoteException {
        return (Math.PI * radius * radius);
    }
}

