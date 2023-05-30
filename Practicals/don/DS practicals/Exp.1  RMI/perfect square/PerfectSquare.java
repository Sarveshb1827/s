import java.rmi.*;
public interface PerfectSquare extends Remote{

public boolean isPerfectSquare(double x)throws RemoteException;
}
