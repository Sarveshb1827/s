import java.rmi.*;
import java.util.*;
public class MyClient{

public static void main(String args[]){
try{
Scanner sc=new Scanner(System.in);
System.out.println("Enter Number To find Perfect Square Or Not");
double n=sc.nextDouble();
PerfectSquare stub=(PerfectSquare)Naming.lookup("rmi://localhost:5000/sonoo");
boolean flag= stub.isPerfectSquare(n);
	if(flag){
		System.out.println("The Number is Perfect Square");
	}
	else{
		System.out.println("The Number is Not Perfect Square");
	}

		}catch(Exception e){System.out.println(e);}
	}

}
