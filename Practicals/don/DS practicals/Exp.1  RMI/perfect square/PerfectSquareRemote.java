import java.rmi.*;
import java.rmi.server.*;

public class PerfectSquareRemote extends UnicastRemoteObject implements PerfectSquare{

PerfectSquareRemote()throws RemoteException{
super();
}

public boolean isPerfectSquare(double x){
	//calculating the square root of the given number  
double sqrt=Math.sqrt(x);   
//finds the floor value of the square root and comparing it with zero  
return ((sqrt - Math.floor(sqrt)) == 0);   
}
}