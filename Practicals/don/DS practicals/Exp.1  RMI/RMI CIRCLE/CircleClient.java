import java.rmi.Naming;

public class CircleClient {
    public static void main(String[] args) {
        try {
            CircleInterface circle = (CircleInterface) Naming.lookup("rmi://localhost/Circle");               
            double radius = 5.0;
            double area = circle.calculateArea(radius);
            System.out.println("Area of the circle with radius " + radius + " is " + area);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

